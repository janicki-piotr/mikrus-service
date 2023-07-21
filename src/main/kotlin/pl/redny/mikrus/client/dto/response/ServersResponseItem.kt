package pl.redny.mikrus.client.dto.response

data class ServersResponseItem(
    val expires: String?,
    val param_disk: String?,
    val param_ram: String?,
    val server_id: String?,
    val server_name: String?
)
