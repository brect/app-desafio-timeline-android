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
import com.blimas.desafiotimelineandroid.service.constants.ApplicationConstants.BUNDLE.LANCAMENTO_ID
import com.blimas.desafiotimelineandroid.service.listener.LancamentosListener
import com.blimas.desafiotimelineandroid.view.adapter.LancamentosAdapter
import com.blimas.desafiotimelineandroid.viewmodel.LancamentosViewModel
import kotlinx.android.synthetic.main.activity_lancamentos.*

class LancamentosActivity : AppCompatActivity() {

    private lateinit var mViewModel: LancamentosViewModel
    private val mAdapter = LancamentosAdapter()
    private lateinit var mListener: LancamentosListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lancamentos)

        mViewModel = ViewModelProvider(this).get(LancamentosViewModel::class.java)

        val recycler = findViewById<RecyclerView>(R.id.recycler_lancamentos)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = mAdapter

        mListener = object : LancamentosListener{
            override fun onItemClick(id: Int) {
                val intent = Intent(applicationContext, DetalhesLancamentoActivity::class.java)
                val bundle = Bundle()
                bundle.putInt(LANCAMENTO_ID, id)
                intent.putExtras(bundle)
                startActivity(intent)
            }

        }

        observe()
    }

    override fun onResume() {
        super.onResume()
        mAdapter.attachListener(mListener)
        mViewModel.listAll()
    }

    private fun observe() {
        mViewModel.lancamentos.observe(this, Observer {
            if (it.count() > 0) {
                mAdapter.updateListener(it)
            }else{
                Toast.makeText(this, "Dados indisponíveis no momento", Toast.LENGTH_SHORT).show()
            }
            progress_bar.visibility = View.GONE
        })
    }
}