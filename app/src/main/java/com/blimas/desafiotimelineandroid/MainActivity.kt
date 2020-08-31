package com.blimas.desafiotimelineandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.blimas.desafiotimelineandroid.view.activity.LancamentosDetalhadosActivity
import com.blimas.desafiotimelineandroid.view.activity.LancamentosSimplesActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setListeners()
    }

    private fun setListeners() {
        button_lancamentos.setOnClickListener(this)
        button_lancamentos_detalhados.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_lancamentos) {
            startActivity(Intent(this, LancamentosSimplesActivity::class.java))
        }else if (view.id == R.id.button_lancamentos_detalhados) {
            startActivity(Intent(this, LancamentosDetalhadosActivity::class.java))
        }
    }
}