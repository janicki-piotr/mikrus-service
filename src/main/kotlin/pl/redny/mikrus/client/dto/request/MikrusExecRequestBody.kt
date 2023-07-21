package pl.redny.mikrus.client.dto.request

import kotlinx.serialization.Serializable


@Serializable
data class MikrusExecRequestBody(val key: String, val srv: String, val cmd: String)
