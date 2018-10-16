package com.felcks.loja_star_wars.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by hal on 16/10/18.
 */
class RestApi {

    private val api : IRestApi

    init {

        val client: OkHttpClient = OkHttpClient.Builder()
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .build()


        val retrofit = Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/stone-pagamentos/desafio-mobile/master/store/")
                .addConverterFactory(MoshiConverterFactory.create().asLenient())
                .client(client)
                .build()


        api = retrofit.create(IRestApi::class.java)
    }

    fun carregarItens() = api.getListagemObras()
}