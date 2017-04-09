package com.fexco.postcode.consumer;

import com.fexco.postcode.utils.Constants;
import com.fexco.postcode.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * This Class consumes the third-party API to restrieve UK post information.
 *
 * @author flavio
 */
@Component
public class UKRestConsumer {

    @Autowired
    private Constants constants;


    @Autowired
    private RestTemplate restTemplate;

    @Cacheable("uk-address-ie")
    public String consumeAddressUk(String query, Map<String, String> params) {
        String url = Constants.API_BASE_URL + constants.getApiKey() + Constants.ADDRESS_UK + query;
        ResponseEntity<String> reponse = restTemplate.getForEntity(URIBuilder.build(url, params), String.class);

        return reponse.getBody();
    }

}
