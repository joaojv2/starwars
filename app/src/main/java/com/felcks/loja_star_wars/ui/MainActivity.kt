package com.felcks.loja_star_wars.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.felcks.loja_star_wars.R
import com.felcks.loja_star_wars.domain.Produto
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Mvp.View {

    private val presenter: Mvp.Presenter by lazy<Mvp.Presenter>{
        MainPresenter(this, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_carregar.setOnClickListener {
            presenter.carregarLista()
        }
    }

    override fun mostrarLista(lista: List<Produto>) {

    }
}
