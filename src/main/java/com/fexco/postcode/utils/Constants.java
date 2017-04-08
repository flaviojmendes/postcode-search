package com.fexco.postcode.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author flavio
 */
@Component
public class Constants{

    @Value("${com.fexco.postcode.apikey}")
    private String apiKey;

    public static final String API_BASE_URL = "http://ws.postcoder.com/pcw/";


    public String getApiKey() {
        return apiKey;
    }



    public static final String ADDRESS_IE = "/address/ie/";

    public static final String ADDRESS_GEO = "/addressgeo/ie/";

    public static final String POSITON_IE = "/position/ie/";

    public static final String RGEO_IE = "/rgeo/ie/";

    public static final String ADDRESS_UK = "/address/uk/";

}
