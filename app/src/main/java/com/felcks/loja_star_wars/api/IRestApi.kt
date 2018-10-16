package com.felcks.loja_star_wars.api

import com.felcks.loja_star_wars.api_model.ProdutoDataResponse
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by hal on 16/10/18.
 */
interface IRestApi {

    @GET("products.json")
    fun getListagemObras(): Call<List<ProdutoDataResponse>>
}