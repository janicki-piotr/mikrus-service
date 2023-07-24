package pl.redny.mikrus.resource

import jakarta.annotation.security.PermitAll
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType
import org.eclipse.microprofile.rest.client.inject.RestClient
import pl.redny.mikrus.client.MikrusApiClient
import pl.redny.mikrus.client.dto.toLog
import pl.redny.mikrus.client.dto.toServer
import pl.redny.mikrus.client.dto.toServerInformation
import pl.redny.mikrus.domain.Database

@Path("/api/v1")
class MikrusResource(
    @RestClient
    val mikrusApiClient: MikrusApiClient
) {

    @GET
    @Path("/server/info")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun getServerInfo(
        @QueryParam("authToken") authToken: String,
        @QueryParam("serverName") serverName: String
    ) = mikrusApiClient.getServerInfo(serverName, authToken)
        .toServerInformation()

    @GET
    @Path("/server")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun getServers(
        @QueryParam("authToken") authToken: String,
        @QueryParam("serverName") serverName: String
    ) = mikrusApiClient.getServers(serverName, authToken)
        .map { it.toServer() }
        .toList()

    @POST
    @Path("/server/restart")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun restartServer(
        @QueryParam("authToken") authToken: String,
        @QueryParam("serverName") serverName: String
    ) = mikrusApiClient.restartServer(serverName, authToken)

    @POST
    @Path("/server/amphetamine")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun rumAmphetamineMode(
        @QueryParam("authToken") authToken: String,
        @QueryParam("serverName") serverName: String
    ) = mikrusApiClient.runAmphetamineMode(serverName, authToken)

    @GET
    @Path("/log")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun getLogs(
        @QueryParam("authToken") authToken: String,
        @QueryParam("serverName") serverName: String
    ) = mikrusApiClient.getLogs(serverName, authToken)
        .map { it.toLog() }
        .toList()

    @GET
    @Path("/log/{logId}")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun getLog(
        @QueryParam("authToken") authToken: String,
        @QueryParam("serverName") serverName: String,
        @PathParam("logId") logId: String
    ) = mikrusApiClient.getLog(serverName, authToken, logId)
        .toLog()

    @GET
    @Path("/database")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun getDatabases(
        @QueryParam("authToken") authToken: String,
        @QueryParam("serverName") serverName: String
    ): List<Database> = mikrusApiClient.getDatabases(serverName, authToken)
        .entries
        .stream()
        .map { Database(it.key, it.value) }
        .toList()

}
