package org.springframework.boot.resttemplate.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.resttemplate.exceptions.FavqsServiceException;
import org.springframework.boot.resttemplate.exceptions.ResourceNotFoundException;
import org.springframework.boot.resttemplate.model.Quote;
import org.springframework.boot.resttemplate.model.QuoteOffDayResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class FavqsClient {
    private static final String RESOURCE_PATH="https://favqs.com/api/";
    private static final String QOD_RESOURCE = RESOURCE_PATH + "/qotd";
    private Logger LOG = LoggerFactory.getLogger(FavqsClient.class);
    private RestTemplate restTemplate;

    public ResponseEntity<Quote> getQuoteById(long id) throws ResourceNotFoundException, FavqsServiceException {
        ResponseEntity<Quote> quote;
        try{
            quote = restTemplate.getForEntity(RESOURCE_PATH + "/{id}",
                    Quote.class,
                    Long.toString(id));
        }catch (HttpClientErrorException e){
            throw new ResourceNotFoundException(
                    String.format("Resource not found"));
        }
        catch (Exception e){
            throw new FavqsServiceException( "Resource not found");
        }


        return quote;
    }

    public ResponseEntity<QuoteOffDayResponse> getQuoteOftheDay() throws ResourceNotFoundException, FavqsServiceException {
        ResponseEntity<QuoteOffDayResponse> qod = null;
        try {
            qod = restTemplate.getForEntity(QOD_RESOURCE, QuoteOffDayResponse.class);
        } catch (RestClientException e) {
            throw new ResourceNotFoundException(
                    String.format("Resource not found"));
        } catch(Exception e){
            throw new FavqsServiceException( "Resource not found");
        }
        return qod;
    }
    
}
