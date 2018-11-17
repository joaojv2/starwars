package com.felcks.starwars.api.models

import com.felcks.starwars.enums.StatusEnum
import com.github.wrdlbrnft.proguardannotations.DontKeep

internal data class InternalResponse internal constructor(

    @DontKeep
    val status: StatusEnum,

    @DontKeep
    val source: ArrayList<DataResponse>? = null,

    @DontKeep
    val error: Throwable? = null
)