package com.felcks.starwars.api.httpmethods

import io.reactivex.schedulers.Schedulers
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class HttpMethodsTest {

    private val signal: CountDownLatch = CountDownLatch(1)

    @Test
    fun `asyncProducts$app_debug`() {

        HttpMethods.asyncProducts()
            .subscribeOn(Schedulers.io())
            .subscribe(
                { response -> println("Response success -> $response") },
                { error -> println("Response error -> ${error.localizedMessage}") }
            )

        signal.await(1, TimeUnit.MINUTES)
    }
}