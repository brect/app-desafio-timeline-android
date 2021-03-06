package com.blimas.desafiotimelineandroid.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blimas.desafiotimelineandroid.R
import com.blimas.desafiotimelineandroid.service.constants.ApplicationConstants.BUNDLE.CATEGORIA_VALUE
import com.blimas.desafiotimelineandroid.service.constants.ApplicationConstants.BUNDLE.LANCAMENTO_ID
import com.blimas.desafiotimelineandroid.service.listener.LancamentosListener
import com.blimas.desafiotimelineandroid.service.model.LancamentoModel
import com.blimas.desafiotimelineandroid.utils.FormatValues
import com.blimas.desafiotimelineandroid.view.adapter.LancamentosDetalhadosAdapter
import com.blimas.desafiotimelineandroid.viewmodel.LancamentosViewModel
import kotlinx.android.synthetic.main.activity_lancamentos_detalhados.*
import kotlinx.android.synthetic.main.activity_lancamentos_simples.progress_bar
import kotlinx.android.synthetic.main.toolbar.*

class LancamentosDetalhadosActivity : AppCompatActivity() {

    private lateinit var mViewModel: LancamentosViewModel
    private val mAdapter = LancamentosDetalhadosAdapter()
    private lateinit var mListener: LancamentosListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lancamentos_detalhados)

        configToolbar()

        mViewModel = ViewModelProvider(this).get(LancamentosViewModel::class.java)

        setRecyclerAndAdapter()
        openDetalhesLancamentos()

        observe()

    }

    override fun onResume() {
        super.onResume()
        mAdapter.attachListener(mListener)
        mViewModel.getLancamentos()
        mViewModel.getCategorias()
    }

    private fun configToolbar() {
        setSupportActionBar(my_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        my_toolbar.title = "Lançamentos"
    }

    private fun setRecyclerAndAdapter() {
        val recycler = findViewById<RecyclerView>(R.id.recycler_lancamentos_detalhados)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = mAdapter
    }

    private fun openDetalhesLancamentos() {
        mListener = object : LancamentosListener {
            override fun onItemClick(param: LancamentoModel) {
                val intent = Intent(applicationContext, DetalhesLancamentoActivity::class.java)
                val bundle = Bundle()
                bundle.putParcelable(LANCAMENTO_ID, param)
                bundle.putString(
                    CATEGORIA_VALUE,
                    getCategoria(param.categoria)
                )
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

    fun getCategoria(categoria: Int): String? {
        val index = categoria - 1
        return mViewModel.categorias.value?.get(index)?.nome
    }

    private fun observe() {

        mViewModel.lancamentos.observe(this, Observer {
            if (it.count() > 0) {
                mViewModel.getGastosMensais(it)
                mViewModel.getBalancoGastosMensais(it)

                text_gasto_total.text = getGastoTotal(it)

                mAdapter.updateListener(it)
            } else {
                Toast.makeText(this, getString(R.string.ERROR_UNEXPECTED), Toast.LENGTH_SHORT)
                    .show()
                progress_bar.visibility = View.GONE
            }
        })

        mViewModel.balancoGastos.observe(this, Observer {
            if (it.count() > 0) {
                mAdapter.updateBalanceGroupListener(it)
            } else {
                Toast.makeText(this, getString(R.string.ERROR_UNEXPECTED), Toast.LENGTH_SHORT)
                    .show()
            }
            progress_bar.visibility = View.GONE
        })

        mViewModel.gastos.observe(this, Observer {
            if (it.count() > 0) {
                mAdapter.updateGroupListener(it)
            } else {
                Toast.makeText(this, getString(R.string.ERROR_UNEXPECTED), Toast.LENGTH_SHORT)
                    .show()
            }
            progress_bar.visibility = View.GONE
        })

        mViewModel.validation.observe(this, Observer {
            Toast.makeText(this, it.errorMessage(), Toast.LENGTH_SHORT).show()
        })
    }

    private fun getGastoTotal(it: List<LancamentoModel>): String {
        return FormatValues.formatMoneyText(it.sumByDouble { it.valor })
    }

}