package com.felcks.loja_star_wars.ui

import com.felcks.loja_star_wars.api.RestApi
import com.felcks.loja_star_wars.domain.Produto
import rx.Observable

/**
 * Created by hal on 16/10/18.
 */
class MainModel(val presenter: Mvp.Presenter): Mvp.Model {

    val api = RestApi()

    override fun carregarLista(): Observable<List<Produto>> {

        return Observable.create { subscriber ->
            val callResponse = api.carregarItens()
            val response = callResponse.execute()

            if (response.isSuccessful && response.body() != null) {

                val itens: List<Produto> = response.body().map {
                    Produto(it.title ?: "",
                            it.price ?: 0.0,
                            it.seller ?: "",
                            it.thumbnailHd ?: "")
                }

                subscriber.onNext(itens)
                subscriber.onCompleted()
            }
            else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}