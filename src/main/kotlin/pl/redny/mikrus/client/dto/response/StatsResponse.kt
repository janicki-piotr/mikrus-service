package pl.redny.mikrus.client.dto.response

import kotlinx.serialization.Serializable

@Serializable
data class StatsResponse(
    val df: String?,
    val free: String?,
    val ps: String?,
    val uptime: String?
)
