package com.fexco.postcode.utils;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author flavio
 */
public class URIBuilder {


    public static URI build(String url, Map<String, String> params){
        LinkedMultiValueMap<String, String> mapParams = new LinkedMultiValueMap<String, String>();
        params.entrySet().forEach(entry -> mapParams.put(entry.getKey(), retrieveQueryParam(entry.getValue())));
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url).queryParams(mapParams).build();
        return uriComponents.toUri();
    }

    private static List<String> retrieveQueryParam(String value) {
        List<String> valueList = new ArrayList<>();
        valueList.add(value);
        return valueList;
    }

}
