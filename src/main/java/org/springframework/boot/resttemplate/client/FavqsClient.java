package org.springframework.boot.resttemplate.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.resttemplate.model.Quote;
import org.springframework.boot.resttemplate.model.QuoteOffDayResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

public class FavqsClient {
    private static final String RESOURCE_PATH="https://favqs.com/api/";
    private static final String QOD_RESOURCE = RESOURCE_PATH + "/qotd";
    private Logger LOG = LoggerFactory.getLogger(FavqsClient.class);
    private RestTemplate restTemplate;

    public ResponseEntity<Quote> getQuoteById(long id){
        ResponseEntity<Quote> quote = restTemplate.getForEntity(RESOURCE_PATH + "/{id}",
                Quote.class,
                Long.toString(id));
        return quote;
    }

    public Optional<QuoteOffDayResponse> getQuoteOftheDay() {
        QuoteOffDayResponse qod = restTemplate.getForObject(QOD_RESOURCE, QuoteOffDayResponse.class);
        return Optional.ofNullable(qod);
    }
    
}
