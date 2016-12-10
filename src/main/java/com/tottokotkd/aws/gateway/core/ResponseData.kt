package com.tottokotkd.aws.gateway.core

/**
 * Created by tottokotkd on 2016/12/10.
 */

data class ResponseData(override val body: String?, override val headers: Map<String, String>, override val statusCode: Int): GatewayResponse {
    constructor(body: String? = null, headers: Map<String, String> = mapOf(), statusCode: StatusCode = StatusCode.OK): this(body, headers, statusCode.value)
}

