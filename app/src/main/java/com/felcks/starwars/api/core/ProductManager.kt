package com.felcks.starwars.api.core

import com.felcks.starwars.api.httpmethods.HttpMethods
import com.felcks.starwars.api.models.DataResponse
import com.felcks.starwars.api.models.InternalResponse
import com.felcks.starwars.enums.StatusEnum
import com.github.wrdlbrnft.proguardannotations.DontKeep
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import retrofit2.Response

internal object ProductManager {

    @DontKeep
    internal fun asyncRequest(block: (InternalResponse) -> Unit) {

        HttpMethods.asyncProducts()
            .subscribeOn(Schedulers.io())
            .subscribe(
                { block.invoke(onNext(it)) },
                { block.invoke(InternalResponse(StatusEnum.ERROR, error = it)) }
            )
    }

    @DontKeep
    private fun onNext(response: Response<ResponseBody>): InternalResponse {
        return when (response.isSuccessful) {
            true -> InternalResponse(StatusEnum.SUCCESS, fromArrayListJson(response.body()?.source()?.readByteArray()!!))

            false -> InternalResponse(StatusEnum.ERROR, error = Throwable(response.message(),
                Throwable(
                    String(response.errorBody()?.source()?.readByteArray()!!)
                )
            ))
        }
    }

    @DontKeep
    private fun fromArrayListJson(response: ByteArray): ArrayList<DataResponse> {
        return object : TypeToken<ArrayList<DataResponse>>() {}.type.let { type ->
            Gson().fromJson(String(response), type)
        }
    }
}