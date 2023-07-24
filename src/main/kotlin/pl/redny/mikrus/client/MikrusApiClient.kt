package pl.redny.mikrus.client

import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.jboss.resteasy.reactive.RestForm
import pl.redny.mikrus.client.dto.response.InfoResponse
import pl.redny.mikrus.client.dto.response.LogsResponseItem
import pl.redny.mikrus.client.dto.response.ServersResponseItem

@RegisterRestClient
interface MikrusApiClient {

    @POST
    @Path("/info")
    fun getServerInfo(
            @RestForm("srv") serverName: String,
            @RestForm("key") authorizationToken: String
    ): InfoResponse

    @POST
    @Path("/serwery")
    fun getServers(
            @RestForm("srv") serverName: String,
            @RestForm("key") authorizationToken: String
    ): List<ServersResponseItem>

    @POST
    @Path("/restart")
    fun restartServer(
        @RestForm("srv") serverName: String,
        @RestForm("key") authorizationToken: String
    )

    @POST
    @Path("/amfetamina")
    fun runAmphetamineMode(
        @RestForm("srv") serverName: String,
        @RestForm("key") authorizationToken: String
    )

    @POST
    @Path("/logs")
    fun getLogs(
        @RestForm("srv") serverName: String,
        @RestForm("key") authorizationToken: String
    ): List<LogsResponseItem>

    @POST
    @Path("/logs/{logId}")
    fun getLog(
        @RestForm("srv") serverName: String,
        @RestForm("key") authorizationToken: String,
        @PathParam("logId") logId: String
    ): LogsResponseItem

    @POST
    @Path("/db")
    fun getDatabases(
        @RestForm("srv") serverName: String,
        @RestForm("key") authorizationToken: String
    ): Map<String, String>
}
