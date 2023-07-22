package pl.redny.mikrus.domain

import kotlinx.serialization.Serializable

@Serializable
data class Size(
        val size: Int,
        val unit: String
)
