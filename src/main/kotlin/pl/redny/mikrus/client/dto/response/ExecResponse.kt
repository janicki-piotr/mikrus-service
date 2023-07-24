package pl.redny.mikrus.client.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExecResponse(
    @SerialName("output")
    val output: String
)
