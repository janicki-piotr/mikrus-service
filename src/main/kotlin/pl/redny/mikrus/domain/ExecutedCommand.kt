package pl.redny.mikrus.domain

import kotlinx.serialization.Serializable

@Serializable
data class ExecutedCommand(
    val output: String?
)
