package com.economy.infrastructure.api.rest;

import com.economy.domain.model.Saque;
import com.economy.domain.service.SaqueService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/saques")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SaqueRestController {
    private final SaqueService saqueService;

    public SaqueRestController(SaqueService saqueService) {
        this.saqueService = saqueService;
    }

    @POST
    @Path("/pix")
    public Response emitirSaquePix(Saque saque) {
        Saque novoSaque = saqueService.criarSaque(saque);
        return Response.ok(novoSaque).build();
    }

    @GET
    @Path("/empregado/{empregadoId}")
    public Response listarSaquesPorEmpregado(@PathParam("empregadoId") int empregadoId) {
        List<Saque> saques = saqueService.listarByEmpregadoId(empregadoId);
        return Response.ok(saques).build();
    }
}
