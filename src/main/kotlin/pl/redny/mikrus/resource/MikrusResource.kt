package pl.redny.mikrus.resource

import jakarta.annotation.security.PermitAll
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType
import pl.redny.mikrus.domain.Database
import pl.redny.mikrus.service.MikrusService

@Path("/api/v1")
class MikrusResource(val mikrusService: MikrusService) {

    @GET
    @Path("/server/info")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun getServerInfo(
        @QueryParam("authToken") authToken: String,
        @QueryParam("serverName") serverName: String
    ) = mikrusService.getServerInfo(authToken, serverName)

    @GET
    @Path("/server")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun getServers(
        @QueryParam("authToken") authToken: String,
        @QueryParam("serverName") serverName: String
    ) = mikrusService.getServers(authToken, serverName)

    @GET
    @Path("/server/stats")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun getServerStats(
        @QueryParam("authToken") authToken: String,
        @QueryParam("serverName") serverName: String
    ) = mikrusService.getServerStats(authToken, serverName)

    @GET
    @Path("/server/ports")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun getServerPorts(
        @QueryParam("authToken") authToken: String,
        @QueryParam("serverName") serverName: String
    ) = mikrusService.getServerPorts(authToken, serverName)

    @POST
    @Path("/server/restart")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun restartServer(
        @QueryParam("authToken") authToken: String,
        @QueryParam("serverName") serverName: String
    ) = mikrusService.restartServer(authToken, serverName)

    @POST
    @Path("/server/amphetamine")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun runAmphetamineMode(
        @QueryParam("authToken") authToken: String,
        @QueryParam("serverName") serverName: String
    ) = mikrusService.rumAmphetamineMode(authToken, serverName)

    @POST
    @Path("/server/execute")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun executeCommandOnServer(
        @QueryParam("authToken") authToken: String,
        @QueryParam("serverName") serverName: String,
        @QueryParam("command") command: String
    ) = mikrusService.executeCommandOnServer(authToken, serverName, command)

    @GET
    @Path("/log")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun getLogs(
        @QueryParam("authToken") authToken: String,
        @QueryParam("serverName") serverName: String
    ) = mikrusService.getLogs(authToken, serverName)

    @GET
    @Path("/log/{logId}")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun getLog(
        @QueryParam("authToken") authToken: String,
        @QueryParam("serverName") serverName: String,
        @PathParam("logId") logId: String
    ) = mikrusService.getLog(authToken, serverName, logId)

    @GET
    @Path("/database")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun getDatabases(
        @QueryParam("authToken") authToken: String,
        @QueryParam("serverName") serverName: String
    ): List<Database> = mikrusService.getDatabases(authToken, serverName)

    @GET
    @Path("/cloud")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun getCloudServices(
        @QueryParam("authToken") authToken: String,
        @QueryParam("serverName") serverName: String
    ) = mikrusService.getCloudServices(authToken, serverName)

}
