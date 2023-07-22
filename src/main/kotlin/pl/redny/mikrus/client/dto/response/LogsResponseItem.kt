package pl.redny.mikrus.client.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class LogsResponseItem(
    val id: String?,
    val output: String?,
    val server_id: String?,
    val task: String?,
    val when_created: String?,
    val when_done: String?
)
