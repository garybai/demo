package com.example.resttemplatedemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Gary
 * @className TestController
 * @description TODO
 * @date 2019-07-02 15:51
 **/
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/test")
    public void test() {
//        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://192.168.1.90:9200/", String.class);
//        HttpStatus httpStatus = forEntity.getStatusCode();
//        int statusCodeValue = forEntity.getStatusCodeValue();
//
//        System.out.println(statusCodeValue);
//        System.out.println(httpStatus.getReasonPhrase());
//        System.out.println(forEntity.getBody());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        String js = "{\"query\": {\"match\": {\"content\": \"红绳\"}},\"from\": 0,\"size\": 2}";
        JSONObject jsonObject = JSON.parseObject(js);

        HttpEntity<Object> request = new HttpEntity<>(jsonObject, headers);

        JSONObject jo = restTemplate.postForObject("http://192.168.1.90:9200/artindex/_search", request, JSONObject.class);
        System.out.println(jo);
//        HttpEntity<JSONObject> jo = restTemplate.postForEntity("http://192.168.1.90:9200/artindex/_search", request, JSONObject.class);
//        System.out.println(jo.getBody());

//        ResponseEntity<JSONObject> exchange = restTemplate.exchange("http://192.168.1.90:9200/artindex/_search", HttpMethod.POST, request, JSONObject.class);
//        System.out.println(exchange.getStatusCodeValue());
//        System.out.println(exchange.getStatusCode());
//        System.out.println(exchange.getBody());

    }
}
