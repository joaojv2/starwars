package com.felcks.starwars.api.utility

import com.felcks.starwars.api.Container
import com.github.wrdlbrnft.proguardannotations.DontKeep
import okhttp3.Dispatcher
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit

@DontKeep
private val dispatcher: Dispatcher = Dispatcher().also { it.maxRequestsPerHost = 5 }

@DontKeep
private val client: OkHttpClient = OkHttpClient.Builder()
    .readTimeout(1, TimeUnit.MINUTES)
    .connectTimeout(1, TimeUnit.MINUTES)
    .dispatcher(dispatcher)
    .build()

@DontKeep
internal fun retrofitNewBuilder(): Retrofit = Retrofit.Builder()
    .baseUrl(Container.baseUrl)
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .client(client)
    .build()
