package com.fexco.postcode.service;

import com.fexco.postcode.consumer.EircodeRestConsumer;
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
public class EircodeServiceTest {


    @MockBean
    private EircodeRestConsumer eircodeRestConsumer;

    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private EircodeService eircodeService;

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
    public void testGetAddressIe() {
        given(this.eircodeService
                .getAddressIe(contains("D02X285"),
                        anyMapOf(String.class, String.class)))
                .willReturn("working");

        Map<String, String> params = new HashMap<>();
        params.put("lines", "3");
        params.put("format", "json");
        String response = eircodeService.getAddressIe("D02X285", params);
        Assert.assertEquals(response, "working");
    }

    @Test
    public void testGetAddressGeo() {
        given(this.eircodeService
                .getAddressGeo(contains("Adelaide%20Road"),
                        anyMapOf(String.class, String.class)))
                .willReturn("working");

        Map<String, String> params = new HashMap<>();
        params.put("lines", "3");
        params.put("format", "json");
        String response = eircodeService.getAddressGeo("Adelaide%20Road", params);
        Assert.assertEquals(response, "working");
    }

    @Test
    public void testGetPositionIe() {
        given(this.eircodeService
                .getPositionIe(contains("D02X285"),
                        anyMapOf(String.class, String.class)))
                .willReturn("working");

        Map<String, String> params = new HashMap<>();
        params.put("lines", "3");
        params.put("format", "json");
        String response = eircodeService.getPositionIe("D02X285", params);
        Assert.assertEquals(response, "working");
    }

    @Test
    public void testGetRgeoIe() {
        given(this.eircodeService
                .getRgeoIe(anyDouble(), anyDouble(),
                        anyMapOf(String.class, String.class)))
                .willReturn("working");

        Map<String, String> params = new HashMap<>();
        params.put("lines", "3");
        params.put("format", "json");
        String response = eircodeService.getRgeoIe(53.332067, -6.255492, params);
        Assert.assertEquals(response, "working");
    }

}
