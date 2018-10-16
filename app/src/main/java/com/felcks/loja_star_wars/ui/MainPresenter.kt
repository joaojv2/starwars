package com.felcks.loja_star_wars.ui

import android.content.Context
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by hal on 16/10/18.
 */
class MainPresenter(val context: Context,
                    val view: Mvp.View): Mvp.Presenter {


    private var subscriptions = CompositeSubscription()

    private val model: Mvp.Model by lazy<Mvp.Model>{
        MainModel(this)
    }


    override fun carregarLista() {

        val subscription = model.carregarLista()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { itens ->
                            view.mostrarLista(itens)
                        },
                        { e ->

                        }
                )
        subscriptions.add(subscription)
    }
}