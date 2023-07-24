package pl.redny.mikrus.domain

import kotlinx.serialization.Serializable

@Serializable
data class Database (
    val name: String,
    val details: String
)
