package pl.redny.mikrus.client

import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import kotlinx.serialization.json.JsonObject
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.jboss.resteasy.reactive.RestForm
import pl.redny.mikrus.client.dto.response.*

@RegisterRestClient
interface MikrusApiClient {

    @POST
    @Path("/info")
    fun getServerInfo(
        @RestForm("key") authorizationToken: String,
        @RestForm("srv") serverName: String
    ): InfoResponse

    @POST
    @Path("/serwery")
    fun getServers(
        @RestForm("key") authorizationToken: String,
        @RestForm("srv") serverName: String
    ): List<ServersResponseItem>

    @POST
    @Path("/restart")
    fun restartServer(
        @RestForm("key") authorizationToken: String,
        @RestForm("srv") serverName: String
    )

    @POST
    @Path("/amfetamina")
    fun runAmphetamineMode(
        @RestForm("key") authorizationToken: String,
        @RestForm("srv") serverName: String
    )

    @POST
    @Path("/exec")
    fun runExec(
        @RestForm("key") authorizationToken: String,
        @RestForm("srv") serverName: String,
        @RestForm("cmd") command: String
    ) : ExecResponse

    @POST
    @Path("/logs")
    fun getLogs(
        @RestForm("key") authorizationToken: String,
        @RestForm("srv") serverName: String
    ): List<LogsResponseItem>

    @POST
    @Path("/logs/{logId}")
    fun getLog(
        @RestForm("key") authorizationToken: String,
        @RestForm("srv") serverName: String,
        @PathParam("logId") logId: String
    ): LogsResponseItem

    @POST
    @Path("/db")
    fun getDatabases(
        @RestForm("key") authorizationToken: String,
        @RestForm("srv") serverName: String
    ): Map<String, String>

    @POST
    @Path("/stats")
    fun getServerStats(
        @RestForm("key") authorizationToken: String,
        @RestForm("srv") serverName: String
    ): StatsResponse

    @POST
    @Path("/porty")
    fun getServerPorts(
        @RestForm("key") authorizationToken: String,
        @RestForm("srv") serverName: String
    ): List<Int>

    @POST
    @Path("/cloud")
    fun getCloudServices(
        @RestForm("key") authorizationToken: String,
        @RestForm("srv") serverName: String
    ): List<JsonObject>
}
