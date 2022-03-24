package com.example.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.orgs.R
import com.example.orgs.dao.ProdutosDao
import com.example.orgs.model.Produto
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val dao = ProdutosDao()
        findViewById<Button>(R.id.button_salvar).setOnClickListener {
            val produto = criaProduto()

            dao.create(produto)
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val nome = findViewById<EditText>(R.id.activity_formulario_produto_nome).text.toString()
        val descricao = findViewById<EditText>(R.id.activity_formulario_produto_descricao).text.toString()
        val valorString = findViewById<EditText>(R.id.activity_formulario_produto_valor).text.toString()

        val valor = if (valorString.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorString)
        }

        return Produto(
            nome = nome,
            descricao = descricao,
            valor = valor
        )
    }
}