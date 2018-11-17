package com.felcks.starwars.api

import com.felcks.starwars.api.httpmethods.RetrofitHttpMethods
import com.felcks.starwars.api.utility.retrofitNewBuilder
import kotlin.properties.Delegates

internal object Container {

    internal var baseUrl: String by Delegates.observable("https://raw.githubusercontent.com/") { _, oldValue, newValue ->
        if (oldValue != newValue) {
            retrofit = retrofitNewBuilder().create(RetrofitHttpMethods::class.java)
        }
    }
        @Synchronized get
        @Synchronized set

    internal var retrofit: RetrofitHttpMethods = retrofitNewBuilder().create(RetrofitHttpMethods::class.java)
        @Synchronized private set
        @Synchronized get
}