package com.tottokotkd.aws.gateway.core

/**
 * Created by tottokotkd on 2016/12/11.
 */

interface DataHandler<I, D: Any>: GatewayRequestHandler<I, ResponseData<D>>
