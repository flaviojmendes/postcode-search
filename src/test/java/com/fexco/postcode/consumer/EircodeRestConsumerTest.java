package com.fexco.postcode.consumer;

import com.fexco.postcode.utils.Constants;
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
public class EircodeRestConsumerTest {


    @MockBean
    private RestTemplate restTemplate;

    @Autowired
    private Constants constants;

    @Autowired
    private EircodeRestConsumer eircodeRestConsumer;

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
    public void testConsumeAddressIe() {
        given(this.restTemplate
                .getForEntity(any(URI.class),
                        eq(String.class)))
                .willReturn(new ResponseEntity<>("working", HttpStatus.OK));

        Map<String, String> params = new HashMap<>();
        params.put("lines", "3");
        params.put("format", "json");
        String response = eircodeRestConsumer.consumeAddressIe("D02X285", params);
        Assert.assertEquals(response, "working");
    }

    @Test
    public void testConsumeAddressGeo() {
        given(this.restTemplate
                .getForEntity(any(URI.class),
                        eq(String.class)))
                .willReturn(new ResponseEntity<>("working", HttpStatus.OK));

        Map<String, String> params = new HashMap<>();
        params.put("format", "json");
        String response = eircodeRestConsumer.consumeAddressGeo("Adelaide%20Road", params);
        Assert.assertEquals(response, "working");
    }

    @Test
    public void testConsumePositionIe() {
        given(this.restTemplate
                .getForEntity(any(URI.class),
                        eq(String.class)))
                .willReturn(new ResponseEntity<>("working", HttpStatus.OK));

        Map<String, String> params = new HashMap<>();
        params.put("format", "json");
        String response = eircodeRestConsumer.consumePositionIe("D02X285", params);
        Assert.assertEquals(response, "working");
    }
    @Test
    public void testConsumeRgeoIe() {
        given(this.restTemplate
                .getForEntity(any(URI.class),
                        eq(String.class)))
                .willReturn(new ResponseEntity<>("working", HttpStatus.OK));

        Map<String, String> params = new HashMap<>();
        params.put("format", "json");
        String response = eircodeRestConsumer.consumeRgeoIe(53.332067, -6.255492, params);
        Assert.assertEquals(response, "working");
    }
}
