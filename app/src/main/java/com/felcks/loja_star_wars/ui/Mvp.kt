package com.felcks.loja_star_wars.ui

import com.felcks.loja_star_wars.domain.Produto
import rx.Observable

/**
 * Created by hal on 16/10/18.
 */
interface Mvp {

    interface View{
        fun mostrarLista(lista: List<Produto>)
    }

    interface Presenter{
        fun carregarLista()
    }

    interface Model{
        fun carregarLista(): Observable<List<Produto>>
    }
}