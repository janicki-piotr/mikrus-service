package pl.redny.mikrus.domain

import kotlinx.serialization.Serializable

@Serializable
data class ServerStats(
    val df: String?,
    val free: String?,
    val ps: String?,
    val uptime: String?
)
