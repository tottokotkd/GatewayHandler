# GatewayHandler

minimum Kotlin Interfaces and data classes to create AWS Lambda Handler, which ready for Lambda Proxy.

## gradle

```gradle
repositories {
    maven {
        jcenter()
    }
}

dependencies {
    compile 'com.tottokotkd:GatewayHandler:1.0.0'
}
```

## use

```kotlin
package hello

import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.document.DynamoDB
import com.amazonaws.services.dynamodbv2.document.Item
import com.amazonaws.services.lambda.runtime.Context
import com.tottokotkd.aws.gateway.core.*
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import kotlin.properties.Delegates

class SaveRequest {
    lateinit var user: String
    lateinit var url: String
    var rate: Int by Delegates.notNull()
    lateinit var timestamp: String
}

data class Result(val body: Any, val headers: Map<String, String>, val statusCode: Int)

class SaveHandler: DataHandler<SaveRequest, Any> {
    override fun handleRequest(input: SaveRequest, context: Context): ResponseData<Any> {

        val timestamp = try {
            ZonedDateTime.parse(input.timestamp, DateTimeFormatter.ISO_DATE_TIME)  
        } catch (e: Exception) {
            return ResponseData(mapOf("status" to "error", "desc" to "date time parsing failed."), StatusCode.BadRequest)
        }

        val dynamoDB = DynamoDB(Regions.US_EAST_1)
        val t = dynamoDB.getTable("pages")
        val item = Item.fromMap(mapOf("user" to input.user, "url" to input.url, "rate" to input.rate, "epoch" to timestamp.toEpochSecond(), "timezone" to timestamp.offset.totalSeconds))
        val result = t.putItem(item)

        return ResponseData(mapOf("status" to "success", "input" to input))
    }

}
```

