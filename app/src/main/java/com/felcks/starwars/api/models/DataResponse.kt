package com.felcks.starwars.api.models

import com.github.wrdlbrnft.proguardannotations.DontKeep
import com.google.gson.annotations.SerializedName

internal data class DataResponse internal constructor(

    @DontKeep
    @SerializedName("title")
    val title: String,

    @DontKeep
    @SerializedName("price")
    val price: Long,

    @DontKeep
    @SerializedName("zipcode")
    val zipCode: String,

    @DontKeep
    @SerializedName("seller")
    val seller: String,

    @DontKeep
    @SerializedName("thumbnailHd")
    val thumbnailHd: String,

    @DontKeep
    @SerializedName("date")
    val date: String
)