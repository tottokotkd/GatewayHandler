package com.tottokotkd.aws.gateway.util

import com.tottokotkd.aws.gateway.core.GatewayRequestHandler

/**
 * Created by tottokotkd on 2016/12/11.
 */

interface DataHandler<I, D: Any>: GatewayRequestHandler<I, ResponseData<D>>
