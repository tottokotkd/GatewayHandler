package com.tottokotkd.aws.gateway.json

import com.squareup.moshi.Moshi
import com.tottokotkd.aws.gateway.core.GatewayResponse
import com.tottokotkd.aws.gateway.core.StatusCode

/**
 * Created by tottokotkd on 2016/12/09.
 */

data class JsonResponse<R: Any>(protected val result: R?, override val headers: Map<String, String>, override val statusCode: Int): GatewayResponse {

    override val body: String?
        get() = result?.let { toJSON(it) }

    companion object {
        fun <O: Any>toJSON(obj: O): String {
            return Moshi.Builder().build().adapter(obj.javaClass).toJson(obj)
        }
    }

    constructor(result: R? = null, headers: Map<String, String> = mapOf(), statusCode: StatusCode = StatusCode.OK): this(result, headers, statusCode.value)
}


