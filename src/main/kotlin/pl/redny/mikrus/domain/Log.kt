package pl.redny.mikrus.domain

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Log(
    val id: String,
    val output: String,
    val serverId: String,
    val task: String,
    val creationDateTime: LocalDateTime,
    val completionDateTime: LocalDateTime?
)
