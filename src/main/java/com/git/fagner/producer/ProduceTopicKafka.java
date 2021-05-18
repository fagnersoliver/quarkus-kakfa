package com.git.fagner.producer;

import com.git.fagner.model.ProduceTopicoKafkaModel;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/producetopickafka")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProduceTopicKafka {

    @Inject
    @Channel("topico-teste")
    Emitter<String> emitter;

    @POST
    @APIResponse(responseCode = "201", description = "Caso restaurante seja cadastrado com sucesso")
    public Response adicionarPrato(@Valid ProduceTopicoKafkaModel dto) {

        // Trecho que vai postar na fila activeMQ
        //Jsonb create = JsonbBuilder.create();
        //String json = create.toJson(dto);
        emitter.send("fagner");

        System.out.println(json);

        return Response.status(Status.CREATED).build();
    }
}
