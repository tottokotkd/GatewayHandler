package com.tottokotkd.aws.gateway.core

import com.amazonaws.services.lambda.runtime.RequestHandler

/**
 * Created by tottokotkd on 2016/12/08.
 */

interface GatewayRequestHandler<I, R: GatewayResponse>: RequestHandler<I, R>
