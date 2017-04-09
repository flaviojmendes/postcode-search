package com.fexco.postcode.service;

import com.fexco.postcode.consumer.EircodeRestConsumer;
import com.fexco.postcode.consumer.UKRestConsumer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.BDDMockito.*;

/**
 * @author flavio
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UKServiceTest {


    @MockBean
    private UKRestConsumer ukRestConsumer;

    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private UKService ukService;

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
    public void testGetAddressUk() {
        given(this.ukService
                .getAddressUk(contains("NR147PZ"),
                        anyMapOf(String.class, String.class)))
                .willReturn("working");

        Map<String, String> params = new HashMap<>();
        params.put("lines", "3");
        params.put("format", "json");
        String response = ukService.getAddressUk("NR147PZ", params);
        Assert.assertEquals(response, "working");
    }


}
