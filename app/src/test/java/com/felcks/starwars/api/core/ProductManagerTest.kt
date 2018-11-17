package com.felcks.starwars.api.core

import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

class ProductManagerTest {

    private val signal: CountDownLatch = CountDownLatch(1)

    @Test
    fun `asyncRequest$app_debug`() {

        ProductManager.asyncRequest { response ->
            response.source?.forEach { data ->
                println(data)
            }
        }

        signal.await(1, TimeUnit.MINUTES)
    }
}