package com.yangchd.week13.homework06.core.consumer;

import com.yangchd.week13.homework06.core.common.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

public class HttpConsumer implements Consumer {

    private final RestTemplate restTemplate = new RestTemplate();

    private Map<String, Object> properties;

    public HttpConsumer(Map<String, Object> properties) {
        this.properties = properties;
    }

    @Override
    public List poll(int rate) {
        String topic = properties.get(Constants.TOPIC).toString();
        String group = properties.get(Constants.GROUP).toString();
        String url = properties.get(Constants.URL).toString();
        String brokerUrl = url + "/poll?topic=" + topic + "&rate=" + rate + "&group=" + group;
        ResponseEntity<List> response = restTemplate.getForEntity(brokerUrl, List.class);
        return response.getBody();
    }
}
