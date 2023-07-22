package pl.redny.mikrus.client.dto

import kotlinx.datetime.LocalDateTime
import pl.redny.mikrus.client.dto.response.InfoResponse
import pl.redny.mikrus.client.dto.response.ServersResponseItem
import pl.redny.mikrus.domain.Server
import pl.redny.mikrus.domain.ServerInformation
import pl.redny.mikrus.domain.Size

fun InfoResponse.toServerInformation(): ServerInformation = ServerInformation(
        expireTime = expireTime?.let { LocalDateTime.parse(it.replace(" ", "T")) },
        cytrusExpireTime = cytrusExpireTime?.let { LocalDateTime.parse(it.replace(" ", "T")) },
        storageExpireTime = storageExpireTime?.let { LocalDateTime.parse(it.replace(" ", "T")) },
        lastPanelLoginTime = lastPanelLoginTime?.let { LocalDateTime.parse(it.replace(" ", "T")) },
        diskSize = Size(diskSize?.toInt() ?: 0, "GB"),
        ramSize = Size(ramSize?.toInt() ?: 0, "MB"),
        serverId = serverId,
        serverName = serverName
)

fun ServersResponseItem.toServer(): Server = Server(
        expireTime = expireTime?.let { LocalDateTime.parse(it.replace(" ", "T")) },
        diskSize = Size(diskSize?.toInt() ?: 0, "GB"),
        ramSize = Size(ramSize?.toInt() ?: 0, "MB"),
        serverId = serverId,
        serverName = serverName
)
