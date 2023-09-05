package com.kermes.apiecommerce;

import com.kermes.apiecommerce.DTOs.ClientCreateDTO;
import com.kermes.apiecommerce.DTOs.ClientReponseDTO;
import com.kermes.apiecommerce.Exeptions.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "/sql/clients/clients-insert.sql",executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/sql/clients/clients-delete.sql",executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class ClientsIT {

    @Autowired
    WebTestClient testClient;

    @Test
    public void createClient_emailValidos_returnClientcomStatus201(){
              ClientReponseDTO clientResponse = testClient
                      .post()
                      .uri("api/v1/clients")
                      .contentType(MediaType.APPLICATION_NDJSON)
                      .bodyValue(new ClientCreateDTO("kermes@hotmail.com"))
                      .exchange()
                      .expectStatus().isCreated()
                      .expectBody(ClientReponseDTO.class)
                      .returnResult()
                      .getResponseBody();

              org.assertj.core.api.Assertions.assertThat(clientResponse).isNotNull();
              org.assertj.core.api.Assertions.assertThat(clientResponse.getId()).isNotNull();
              org.assertj.core.api.Assertions.assertThat(clientResponse.getEmail()).isEqualTo("kermes@hotmail.com");
    }

    @Test
    public void createClient_emailinValidos_returnErrorMessageStatus422(){
        ErrorMessage clientResponse = testClient
                .post()
                .uri("api/v1/clients")
                .contentType(MediaType.APPLICATION_NDJSON)
                .bodyValue(new ClientCreateDTO(""))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(ErrorMessage.class)
                .returnResult()
                .getResponseBody();

        org.assertj.core.api.Assertions.assertThat(clientResponse).isNotNull();
        org.assertj.core.api.Assertions.assertThat(clientResponse.getStatus()).isEqualTo(422);

        clientResponse = testClient
                .post()
                .uri("api/v1/clients")
                .contentType(MediaType.APPLICATION_NDJSON)
                .bodyValue(new ClientCreateDTO("kermes.salustiano"))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(ErrorMessage.class)
                .returnResult()
                .getResponseBody();

        org.assertj.core.api.Assertions.assertThat(clientResponse).isNotNull();
        org.assertj.core.api.Assertions.assertThat(clientResponse.getStatus()).isEqualTo(422);
    }

    @Test
    public void createClient_emailRepetido_returnErrorMessageStatus409(){
        ErrorMessage clientResponse = testClient
                .post()
                .uri("api/v1/clients")
                .contentType(MediaType.APPLICATION_NDJSON)
                .bodyValue(new ClientCreateDTO("kermes.salustiano@gmail.com"))
                .exchange()
                .expectStatus().isEqualTo(409)
                .expectBody(ErrorMessage.class)
                .returnResult()
                .getResponseBody();

        org.assertj.core.api.Assertions.assertThat(clientResponse).isNotNull();
        org.assertj.core.api.Assertions.assertThat(clientResponse.getStatus()).isEqualTo(409);
    }

    @Test
    public void buscarClient_comEmailexistente_returnClientcomStatus200(){
        ClientReponseDTO clientResponse = testClient
                .get()
                .uri("api/v1/clients/kermes.salustiano@gmail.com")
                .exchange()
                .expectStatus().isOk()
                .expectBody(ClientReponseDTO.class)
                .returnResult()
                .getResponseBody();

        org.assertj.core.api.Assertions.assertThat(clientResponse).isNotNull();
        org.assertj.core.api.Assertions.assertThat(clientResponse.getId()).isNotNull();
        org.assertj.core.api.Assertions.assertThat(clientResponse.getEmail()).isEqualTo("kermes@hotmail.com");
    }
    @Test
    public void buscarClient_comEmailInexistente_returnErrorMessagecomStatus404(){
        ErrorMessage clientResponse = testClient
                .get()
                .uri("api/v1/clients/kermes@gmail.com")
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(ErrorMessage.class)
                .returnResult()
                .getResponseBody();

        org.assertj.core.api.Assertions.assertThat(clientResponse).isNotNull();
        org.assertj.core.api.Assertions.assertThat(clientResponse.getStatus()).isEqualTo(404);
    }
}
