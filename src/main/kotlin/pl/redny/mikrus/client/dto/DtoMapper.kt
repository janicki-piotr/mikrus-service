package pl.redny.mikrus.client.dto

import kotlinx.datetime.LocalDateTime
import pl.redny.mikrus.client.dto.response.*
import pl.redny.mikrus.domain.*

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

fun LogsResponseItem.toLog(): Log = Log(
    id = id,
    output = output,
    serverId = serverId,
    task = task,
    creationDateTime = LocalDateTime.parse(creationDateTime.replace(" ", "T")),
    completionDateTime = completionDateTime?.let { LocalDateTime.parse(it.replace(" ", "T")) }
)

fun StatsResponse.toServerStats(): ServerStats = ServerStats(
    df = df.ifBlank { null },
    free = free.ifBlank { null },
    ps = ps.ifBlank { null },
    uptime = uptime.ifBlank { null }
)

fun ExecResponse.toExecutedCommand(): ExecutedCommand = ExecutedCommand(
    output = output.ifBlank { null }
)
