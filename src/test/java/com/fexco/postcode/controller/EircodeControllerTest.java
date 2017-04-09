package com.fexco.postcode.controller;

import com.fexco.postcode.consumer.EircodeRestConsumer;
import com.fexco.postcode.service.EircodeService;
import com.fexco.postcode.utils.Constants;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.times;

/**
 * @author flavio
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT,properties = "application.properties")
public class EircodeControllerTest {


    @Autowired
    private Constants constants;


    @MockBean
    private EircodeService eircodeService;


    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private EircodeController eircodeController;


    @Autowired
    private CacheManager cacheManager;

    /**
     * Cleaning Spring cache before each execution
     */
    @Before
    public void init() {
        Cache cache = cacheManager.getCache("default-test");
        cache.clear();

    }


    @Test
    public void testAddressIe() {
        given(this.eircodeService
                .getAddressIe(contains("D02X285"),
                        anyMap()))
                .willReturn("working");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(Constants.ADDRESS_IE + "D02X285",
                String.class);
        Assert.assertEquals("working",responseEntity.getBody());
    }

    @Test
    public void testAddressGeo() {
        given(this.eircodeService
                .getAddressGeo(contains("D02X285"),
                        anyMap()))
                .willReturn("working");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(Constants.ADDRESS_GEO + "D02X285",
                String.class);
        Assert.assertEquals("working",responseEntity.getBody());
    }

    @Test
    public void testPositionIe() {
        given(this.eircodeService
                .getPositionIe(contains("D02X285"),
                        anyMap()))
                .willReturn("working");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(Constants.POSITON_IE + "D02X285",
                String.class);
        Assert.assertEquals("working",responseEntity.getBody());
    }

    @Test
    public void testRevGeoIe() {
        given(this.eircodeService
                .getRgeoIe(anyDouble(), anyDouble(),
                        anyMap()))
                .willReturn("working");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(Constants.RGEO_IE + "53.332067/-6.255492",
                String.class);
        Assert.assertEquals("working",responseEntity.getBody());
    }

}
