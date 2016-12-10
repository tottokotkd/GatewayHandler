# GatewayHandler

minimum Kotlin Interfaces and data classes to create AWS Lambda Handler, which ready for Lambda Proxy.

## gradle

```gradle
repositories {
    maven {
        url "https://dl.bintray.com/tottokotkd/maven"
    }
}

dependencies {
    compile 'com.tottokotkd:GatewayHandler:1.0.0'
}
```

## use

```kotlin
package hello

import com.amazonaws.services.lambda.runtime.Context
import com.tottokotkd.aws.gateway.json.*

data class Request(var key1: String? = null, var key2: String? = null, var key3: String? = null)
data class Result(var message: String? = null, var request: Request? = null)

class HandlerGateway: JsonHandler<Request, Result> {
    override fun handleRequest(input: Request, context: Context): JsonResponse<Result> {
        val body = Result("now Kotlin handles request! key1=${input.key1}, key2=${input.key2}, key3=${input.key3}", input);
        return JsonResponse(body)
    }
}
```

