package pl.redny.mikrus.client.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LogsResponseItem(
    @SerialName("id")
    val id: String,
    @SerialName("output")
    val output: String,
    @SerialName("server_id")
    val serverId: String,
    @SerialName("task")
    val task: String,
    @SerialName("when_created")
    val creationDateTime: String,
    @SerialName("when_done")
    val completionDateTime: String?
)
