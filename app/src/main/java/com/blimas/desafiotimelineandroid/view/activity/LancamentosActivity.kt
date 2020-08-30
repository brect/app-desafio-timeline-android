package com.blimas.desafiotimelineandroid.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blimas.desafiotimelineandroid.R
import com.blimas.desafiotimelineandroid.view.adapter.LancamentosAdapter
import com.blimas.desafiotimelineandroid.viewmodel.LancamentosViewModel

class LancamentosActivity : AppCompatActivity() {

    private lateinit var mViewModel: LancamentosViewModel
    private val mAdapter = LancamentosAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lancamentos)

        mViewModel = ViewModelProvider(this).get(LancamentosViewModel::class.java)

        val recycler = findViewById<RecyclerView>(R.id.recycler_lancamentos)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = mAdapter

        observe()
    }

    override fun onResume() {
        super.onResume()
        mViewModel.listAll()
    }

    private fun observe() {
        mViewModel.lancamentos.observe(this, Observer {
            if (it.count() > 0) {
                mAdapter.updateListener(it)
            }
        })
    }
}