package pl.redny.mikrus.client

import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.jboss.resteasy.reactive.RestForm
import pl.redny.mikrus.client.dto.response.InfoResponse
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
}
