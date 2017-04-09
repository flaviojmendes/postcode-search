package com.fexco.postcode.consumer;

import com.fexco.postcode.utils.Constants;
import com.fexco.postcode.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.*;

/**
 * @author flavio
 */
@Component
public class EircodeRestConsumer {

    @Autowired
    private Constants constants;

    @Autowired
    private RestTemplate restTemplate;


    @Cacheable("eircode-address-ie")
    public String consumeAddressIe(String query, Map<String, String> params) {
        String url = Constants.API_BASE_URL + constants.getApiKey() + Constants.ADDRESS_IE + query;
        ResponseEntity<String> reponse = restTemplate.getForEntity(URIBuilder.build(url, params), String.class);

        return reponse.getBody();
    }

    @Cacheable("eircode-address-geo")
    public String consumeAddressGeo(String query, Map<String, String> params) {
        String url = Constants.API_BASE_URL + constants.getApiKey() + Constants.ADDRESS_GEO + query;
        ResponseEntity<String> reponse = restTemplate.getForEntity(URIBuilder.build(url, params), String.class);

        return reponse.getBody();
    }

    @Cacheable("eircode-position-ie")
    public String consumePositionIe(String query, Map<String, String> params) {
        String url = Constants.API_BASE_URL + constants.getApiKey() + Constants.POSITON_IE + query;
        ResponseEntity<String> reponse = restTemplate.getForEntity(URIBuilder.build(url, params), String.class);

        return reponse.getBody();
    }

    @Cacheable("eircode-rgeo-ie")
    public String consumeRgeoIe(Double lat, Double lon, Map<String, String> params) {
        String url = Constants.API_BASE_URL + constants.getApiKey() + Constants.POSITON_IE + lat + "/" + lon;
        ResponseEntity<String> reponse = restTemplate.getForEntity(URIBuilder.build(url, params), String.class);

        return reponse.getBody();
    }



}
