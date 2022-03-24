package com.example.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.orgs.R
import com.example.orgs.dao.ProdutosDao
import com.example.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity: AppCompatActivity(R.layout.activity_main) {

    val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.getAll())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraRecycleView()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.getAll())
        configuraFab()
    }

    private fun configuraRecycleView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_main_recyclerview)
        val dao = ProdutosDao()
        recyclerView.adapter = adapter
    }

    private fun configuraFab() {
        val fab =
            findViewById<FloatingActionButton>(R.id.activity_main_floatingActionButton).setOnClickListener {
                direcionaParaFormularioProduto()
            }
    }

    private fun direcionaParaFormularioProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }
}