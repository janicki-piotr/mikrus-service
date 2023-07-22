package pl.redny.mikrus.domain

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class ServerInformation(
    val expireTime: LocalDateTime?,
    val cytrusExpireTime: LocalDateTime?,
    val storageExpireTime: LocalDateTime?,
    val lastPanelLoginTime: LocalDateTime?,
    val diskSize: Size,
    val ramSize: Size,
    val serverId: String?,
    val serverName: String?

)


