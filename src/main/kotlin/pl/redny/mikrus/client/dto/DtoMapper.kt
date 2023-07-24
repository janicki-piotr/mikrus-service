package pl.redny.mikrus.client.dto

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.SerialName
import pl.redny.mikrus.client.dto.response.InfoResponse
import pl.redny.mikrus.client.dto.response.LogsResponseItem
import pl.redny.mikrus.client.dto.response.ServersResponseItem
import pl.redny.mikrus.domain.Log
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

fun LogsResponseItem.toLog() : Log = Log(
        id = id,
        output = output,
        serverId = serverId,
        task = task,
        creationDateTime =  LocalDateTime.parse(creationDateTime.replace(" ", "T")),
        completionDateTime = completionDateTime?.let { LocalDateTime.parse(it.replace(" ", "T")) }
)
