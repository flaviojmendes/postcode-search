package com.fexco.postcode.service;

import com.fexco.postcode.consumer.EircodeRestConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 *
 * Service that is responsible to retrieve and manage the Eircode querying.
 *
 * @author flavio
 */

@Service
public class EircodeService {

    @Autowired
    private EircodeRestConsumer eircodeRestConsumer;


    public String getAddressIe(String query, Map<String, String> params) {
        return eircodeRestConsumer.consumeAddressIe(query, params);
    }

    public String getAddressGeo(String query, Map<String, String> params) {
        return eircodeRestConsumer.consumeAddressGeo(query, params);
    }

    public String getPositionIe(String query, Map<String, String> params) {
        return eircodeRestConsumer.consumePositionIe(query, params);
    }

    public String getRgeoIe(Double lat, Double lon, Map<String, String> params) {
        return eircodeRestConsumer.consumeRgeoIe(lat, lon, params);
    }


}
