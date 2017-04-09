package com.fexco.postcode.consumer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.BDDMockito.*;

/**
 * @author flavio
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UKRestConsumerTest {


    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private UKRestConsumer ukRestConsumer;

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
    public void testConsumeAddressUk() {
        given(this.restTemplate
                .getForEntity(any(URI.class),
                        eq(String.class)))
                .willReturn(new ResponseEntity<String>("working", HttpStatus.OK));

        Map<String, String> params = new HashMap<String, String>();
        params.put("lines", "3");
        params.put("format", "json");
        String response = ukRestConsumer.consumeAddressUk("NR147PZ", params);
        Assert.assertEquals(response, "working");
    }

}
