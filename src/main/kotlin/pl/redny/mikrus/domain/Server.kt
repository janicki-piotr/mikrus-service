package pl.redny.mikrus.domain

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Server(
        val expireTime: LocalDateTime?,
        val diskSize: Size,
        val ramSize: Size,
        val serverId: String?,
        val serverName: String?
)
