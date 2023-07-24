package pl.redny.mikrus.service

import jakarta.enterprise.context.ApplicationScoped
import org.eclipse.microprofile.rest.client.inject.RestClient
import pl.redny.mikrus.client.MikrusApiClient
import pl.redny.mikrus.client.dto.*
import pl.redny.mikrus.domain.Database

@ApplicationScoped
class MikrusService(
    @RestClient
    val mikrusApiClient: MikrusApiClient
) {

    val translationMap = mapOf(
        "bazaZalozona" to "databaseCreated",
        "login" to "login",
        "baza" to "database",
        "haslo" to "password",
        "host" to "host",
        "port" to "port"
    )

    fun getServerInfo(
        authToken: String,
        serverName: String
    ) = mikrusApiClient
        .getServerInfo(authToken, serverName)
        .toServerInformation()

    fun getServers(
        authToken: String,
        serverName: String
    ) = mikrusApiClient
        .getServers(authToken, serverName)
        .map { it.toServer() }
        .toList()

    fun getServerStats(
        authToken: String,
        serverName: String
    ) = mikrusApiClient
        .getServerStats(authToken, serverName)
        .toServerStats()

    fun getServerPorts(
        authToken: String,
        serverName: String
    ) = mikrusApiClient
        .getServerPorts(authToken, serverName)

    fun restartServer(
        authToken: String,
        serverName: String
    ) = mikrusApiClient
        .restartServer(authToken, serverName)

    fun rumAmphetamineMode(
        authToken: String,
        serverName: String
    ) = mikrusApiClient
        .runAmphetamineMode(authToken, serverName)

    fun executeCommandOnServer(
        authToken: String,
        serverName: String,
        command: String
    ) = mikrusApiClient
        .runExec(authToken, serverName, command)
        .toExecutedCommand()


    fun getLogs(
        authToken: String,
        serverName: String
    ) = mikrusApiClient
        .getLogs(authToken, serverName)
        .map { it.toLog() }
        .toList()

    fun getLog(
        authToken: String,
        serverName: String,
        logId: String
    ) = mikrusApiClient
        .getLog(authToken, serverName, logId)
        .toLog()

    fun getDatabases(
        authToken: String,
        serverName: String
    ): List<Database> = mikrusApiClient
        .getDatabases(authToken, serverName)
        .entries
        .stream()
        .map { Database(it.key, mapDatabaseDetails(it)) }
        .toList()

    private fun mapDatabaseDetails(it: Map.Entry<String, String>) =
        it.value.split("\n")
            .filter { it.isNotBlank() }
            .associate {
                val parts = it.split(":")
                if (parts.size == 2) {
                    parts[0].trim() to parts[1].trim()
                } else {
                    it.trim() to "true"
                }
            }
            .mapKeys { convertToCamelCase(it.key) }
            .mapKeys { translationMap.getOrDefault(it.key, it.key) }

    fun getCloudServices(
        authToken: String,
        serverName: String
    ) = mikrusApiClient
        .getCloudServices(authToken, serverName)

    fun convertToCamelCase(value: String): String {
        return value
            .split(" ")
            .mapIndexed { index, word ->
                if (index == 0) {
                    word.lowercase()
                } else {
                    word.replaceFirstChar(Char::titlecase)
                }
            }
            .joinToString("")
    }
}
