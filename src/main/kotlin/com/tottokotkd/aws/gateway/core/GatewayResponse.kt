package com.tottokotkd.aws.gateway.core

/**
 * Created by tottokotkd on 2016/12/08.
 */

interface GatewayResponse {
    val body: String?
    val headers: Map<String, String>
    val statusCode: Int
}



