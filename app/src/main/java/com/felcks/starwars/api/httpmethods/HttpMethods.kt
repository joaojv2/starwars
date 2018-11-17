package com.felcks.starwars.api.httpmethods

import com.felcks.starwars.api.Container
import com.github.wrdlbrnft.proguardannotations.DontKeep
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Response

internal object HttpMethods {

    @DontKeep
    internal fun asyncProducts(): Observable<Response<ResponseBody>> = Container.retrofit.products()
}