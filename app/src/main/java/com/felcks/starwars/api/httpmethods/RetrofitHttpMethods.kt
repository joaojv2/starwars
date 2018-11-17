package com.felcks.starwars.api.httpmethods

import com.github.wrdlbrnft.proguardannotations.DontKeep
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

/**
 *  This interface contains all endpoints to api request.
 */
internal interface RetrofitHttpMethods {

    @DontKeep
    @GET("stone-pagamentos/desafio-mobile/master/store/products.json")
    fun products(): Observable<Response<ResponseBody>>
}