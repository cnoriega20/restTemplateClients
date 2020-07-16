package org.springframework.boot.resttemplate.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.resttemplate.model.JsonPlaceHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;

public class JsonPlaceHolderClient {
    private static final String RESOURCE_PATH="https://jsonplaceholder.typicode.com";
    private static final String JSON_PLACEHOLDER_RESOURCE = RESOURCE_PATH + "/posts";
    private Logger LOG = LoggerFactory.getLogger(JsonPlaceHolderClient.class);
    private RestTemplate restTemplate;

    public ResponseEntity<JsonPlaceHolder> getResource(long id){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JsonPlaceHolder> jsonPlaceHolder = restTemplate.getForEntity(JSON_PLACEHOLDER_RESOURCE + "/{id}",
                JsonPlaceHolder.class, Long.toString(id));
        return  jsonPlaceHolder;
    }

    public JsonPlaceHolder[] getAllResource(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JsonPlaceHolder[]> jsonListResponse = restTemplate.getForEntity(JSON_PLACEHOLDER_RESOURCE, JsonPlaceHolder[].class);
        JsonPlaceHolder[]  jsonPlaceHolders = jsonListResponse.getBody();
        assert jsonPlaceHolders != null;
        asList(jsonPlaceHolders).forEach(System.out::println);
        return jsonPlaceHolders;

    }
}
