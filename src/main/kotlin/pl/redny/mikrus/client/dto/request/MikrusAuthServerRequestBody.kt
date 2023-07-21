package pl.redny.mikrus.client.dto.request

import kotlinx.serialization.Serializable


@Serializable
data class MikrusAuthServerRequestBody(val key: String, val srv: String)
