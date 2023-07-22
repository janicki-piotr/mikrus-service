package pl.redny.mikrus.resource

import jakarta.annotation.security.PermitAll
import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.MediaType
import org.eclipse.microprofile.rest.client.inject.RestClient
import pl.redny.mikrus.client.MikrusApiClient
import pl.redny.mikrus.client.dto.toServer
import pl.redny.mikrus.client.dto.toServerInformation

@Path("/api/v1")
class MikrusResource(
        @RestClient
        val mikrusApiClient: MikrusApiClient
) {

    @GET
    @Path("/info")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun getServerInfo(
            @QueryParam("authToken") authToken: String,
            @QueryParam("serverName") serverName: String
    ) = mikrusApiClient.getServerInfo(serverName, authToken).toServerInformation()

    @GET
    @Path("/server")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun getServers(
            @QueryParam("authToken") authToken: String,
            @QueryParam("serverName") serverName: String
    ) = mikrusApiClient.getServers(serverName, authToken).map { it.toServer() }.toList()

    @POST
    @Path("/server/restart")
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    fun restartServer(
            @QueryParam("authToken") authToken: String,
            @QueryParam("serverName") serverName: String
    ) = mikrusApiClient.restartServer(serverName, authToken)

}
