package pl.redny.mikrus.client.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InfoResponse(
    @SerialName("expires")
    val expireTime: String?,
    @SerialName("expires_cytrus")
    val cytrusExpireTime: String?,
    @SerialName("expires_storage")
    val storageExpireTime: String?,
    @SerialName("lastlog_panel")
    val lastPanelLoginTime: String?,
    @SerialName("param_disk")
    val diskSize: String?,
    @SerialName("param_ram")
    val ramSize: String?,
    @SerialName("server_id")
    val serverId: String?,
    @SerialName("server_name")
    val serverName: String?
)
