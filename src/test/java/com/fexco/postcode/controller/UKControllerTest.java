package com.fexco.postcode.controller;

import com.fexco.postcode.service.UKService;
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

import static org.mockito.BDDMockito.*;

/**
 * @author flavio
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT,properties = "application.properties")
public class UKControllerTest {


    @Autowired
    private Constants constants;


    @MockBean
    private UKService eircodeService;


    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UKController eircodeController;


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
    public void testAddressUK() {
        given(this.eircodeService
                .getAddressUk(contains("NR147PZ"),
                        anyMap()))
                .willReturn("working");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(Constants.ADDRESS_UK + "NR147PZ",
                String.class);
        Assert.assertEquals("working",responseEntity.getBody());
    }

    @Test
    public void testAddressUKWithParams() {
        given(this.eircodeService
                .getAddressUk(contains("NR147PZ"),
                        anyMap()))
                .willReturn("working");
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(Constants.ADDRESS_UK + "NR147PZ?format=xml",
                String.class);
        Assert.assertEquals("working",responseEntity.getBody());
    }


}
