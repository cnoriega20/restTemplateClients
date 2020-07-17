package org.springframework.boot.resttemplate.client;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.resttemplate.model.JsonPlaceHolder;
import org.springframework.boot.resttemplate.model.Quote;
import org.springframework.boot.resttemplate.model.QuoteOffDayResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class FavqsClientTest extends JsonPlaceHolderClient {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private FavqsClient favqsClient = new FavqsClient();

    private static final String RESOURCE_PATH="https://favqs.com/api/";
    private static final String QOD_RESOURCE = RESOURCE_PATH + "/qotd";


    @Test
    public void getQuoteByIdTest() {
        /*Quote quote = new Quote();
        Mockito
                .when(restTemplate.getForEntity(QOD_RESOURCE + "/1",
                        JsonPlaceHolder.class, Long.toString(1)))
                .thenReturn(new ResponseEntity<JsonPlaceHolder>(jsonPlaceHolder, HttpStatus.OK));

        assertThat(jsonPlaceHolderClient.getResource(1).getStatusCode()).isEqualTo(HttpStatus.OK);
        assertNotNull(jsonPlaceHolderClient.getResource(1));*/
    }

    @SneakyThrows
    @Test
    public void getQuoteOftheDayTest() {
        QuoteOffDayResponse quoteOffDayResponse = new QuoteOffDayResponse();
        Mockito
                .when(restTemplate.getForEntity(QOD_RESOURCE,
                        QuoteOffDayResponse.class))
                .thenReturn(new ResponseEntity<QuoteOffDayResponse>(quoteOffDayResponse, HttpStatus.OK));
        assertThat(favqsClient.getQuoteOftheDay().getStatusCode()).isEqualTo(HttpStatus.OK);
        assertNotNull(favqsClient.getQuoteOftheDay());
    }
}