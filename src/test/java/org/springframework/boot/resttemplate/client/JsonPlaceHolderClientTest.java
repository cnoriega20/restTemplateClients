package org.springframework.boot.resttemplate.client;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttemplate.model.JsonPlaceHolder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class JsonPlaceHolderClientTest extends JsonPlaceHolderClient {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private JsonPlaceHolderClient jsonPlaceHolderClient= new JsonPlaceHolderClient();


    private static final String RESOURCE_PATH="https://jsonplaceholder.typicode.com";
    private static final String JSON_PLACEHOLDER_RESOURCE = RESOURCE_PATH + "/posts";


    @Test
    public void givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject() {
        JsonPlaceHolder jsonPlaceHolder = new JsonPlaceHolder();
        Mockito
                .when(restTemplate.getForEntity(RESOURCE_PATH + "/1",
                        JsonPlaceHolder.class, Long.toString(1)))
                .thenReturn(new ResponseEntity<JsonPlaceHolder>(jsonPlaceHolder, HttpStatus.OK));

        assertThat(jsonPlaceHolderClient.getResource(1).getStatusCode()).isEqualTo(HttpStatus.OK);
        assertNotNull(jsonPlaceHolderClient.getResource(1));
    }

    @Test
    public void givenTestRestTemplate_whenSendGetForEntity_thenStatusOk(){
        JsonPlaceHolder jsonPlaceHolder = new JsonPlaceHolder();
        Mockito
                .when(restTemplate.getForEntity(JSON_PLACEHOLDER_RESOURCE ,
                        JsonPlaceHolder.class))
                .thenReturn(new ResponseEntity<JsonPlaceHolder>(jsonPlaceHolder, HttpStatus.OK));

        assertThat(jsonPlaceHolderClient.getAllResource()).isNotEmpty();
        assertNotNull(jsonPlaceHolderClient.getAllResource());
    }

//    @Test
//    public void testGetResource() throws URISyntaxException {
//        RestTemplate restTemplate = new RestTemplate();
//
//        URI uri = new URI(JSON_PLACEHOLDER_RESOURCE);
//
//        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
//
//    }

}