package com.blimas.desafiotimelineandroid.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.blimas.desafiotimelineandroid.R
import com.blimas.desafiotimelineandroid.service.constants.ApplicationConstants.BUNDLE.CATEGORIA_VALUE
import com.blimas.desafiotimelineandroid.service.constants.ApplicationConstants.BUNDLE.LANCAMENTO_ID
import com.blimas.desafiotimelineandroid.service.model.LancamentoModel
import com.blimas.desafiotimelineandroid.utils.FormatValues
import kotlinx.android.synthetic.main.activity_detalhes_lancamento.*
import kotlinx.android.synthetic.main.toolbar.*

class DetalhesLancamentoActivity : AppCompatActivity() {

    private lateinit var mLancamento: LancamentoModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_lancamento)

        setSupportActionBar(my_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        my_toolbar.title = ""

        loadDataFromActivity()
    }


    private fun loadDataFromActivity() {
        val bundle = intent.extras
        if (bundle != null) {
            mLancamento = bundle.getParcelable(LANCAMENTO_ID)!!
            val categoria = bundle.getString(CATEGORIA_VALUE)

            text_origem.text = mLancamento.origem
            text_categoria.text = categoria
            text_valor.text = FormatValues.formatMoneyText(mLancamento.valor)
        }
    }
}