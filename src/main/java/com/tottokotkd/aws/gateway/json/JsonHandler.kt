package com.tottokotkd.aws.gateway.json

import com.amazonaws.services.lambda.runtime.Context
import com.tottokotkd.aws.gateway.core.GatewayRequestHandler

/**
 * Created by tottokotkd on 2016/12/09.
 */

interface JsonHandler<I, R: Any>: GatewayRequestHandler<I, JsonResponse<R>> {
    override fun handleRequest(input: I, context: Context): JsonResponse<R>
}
