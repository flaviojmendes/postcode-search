package com.fexco.postcode.service;

import com.fexco.postcode.consumer.UKRestConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *
 * Service that is responsible to retrieve and manage UK addresses querying.
 *
 * @author flavio
 */

@Service
public class UKService {

    @Autowired
    private UKRestConsumer ukRestConsumer;


    public String getAddressUk(String query, Map<String, String> params) {
        return ukRestConsumer.consumeAddressUk(query, params);
    }



}
