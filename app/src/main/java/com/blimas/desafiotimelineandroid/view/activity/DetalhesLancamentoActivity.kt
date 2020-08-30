package com.blimas.desafiotimelineandroid.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blimas.desafiotimelineandroid.R
import com.blimas.desafiotimelineandroid.service.constants.ApplicationConstants.BUNDLE.LANCAMENTO_ID
import com.blimas.desafiotimelineandroid.service.model.LancamentoModel
import kotlinx.android.synthetic.main.activity_detalhes_lancamento.*

class DetalhesLancamentoActivity : AppCompatActivity() {

    private lateinit var mLancamento: LancamentoModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_lancamento)

        loadDataFromActivity()
    }

    private fun loadDataFromActivity() {
        val bundle = intent.extras
        if (bundle != null){
            mLancamento = bundle.getParcelable(LANCAMENTO_ID)!!

            text_origem.text = mLancamento.origem
        }
    }
}