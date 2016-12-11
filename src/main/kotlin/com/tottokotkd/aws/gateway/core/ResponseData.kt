package com.tottokotkd.aws.gateway.core

/**
 * Created by tottokotkd on 2016/12/10.
 */

data class ResponseData<R: Any>(override val body: Any?, override val statusCode: Int, override val headers: Map<String, String>): GatewayResponse {
    constructor(body: R? = null, statusCode: StatusCode = StatusCode.OK, headers: Map<String, String> = mapOf()): this(body, statusCode.value, headers)
}
