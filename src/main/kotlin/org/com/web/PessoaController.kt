package org.com.web

import jakarta.ws.rs.GET
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.QueryParam
import jakarta.ws.rs.core.Response
import java.util.UUID

@Path("/pessoas")
class PessoaController {

    @POST
    fun create(request: PessoaRequest) = PessoaResponse(
        UUID.randomUUID().toString(),
        "apelido",
        "nome",
        "1999/03/30",
        emptyList()
    ).let { Response.status(Response.Status.CREATED).entity(it).build() }


    @GET
    @Path("/{id}")
    fun findById(@PathParam("id") id: String) = PessoaResponse(
        UUID.randomUUID().toString(),
        "apelido",
        "nome",
        "1999/03/30",
        emptyList()
    ).let { Response.status(Response.Status.OK).entity(it).build() }

    @GET
    fun searchBy(@QueryParam("t") term: String) = PessoaResponse(
        UUID.randomUUID().toString(),
        "apelido",
        "nome",
        "1999/03/30",
        emptyList()
    ).let { Response.status(Response.Status.OK).entity(listOf(it)).build() }
}