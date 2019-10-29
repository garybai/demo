package com.example.unnameddemo.result;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Gary
 * @className Test
 * @description TODO
 * @date 2019-07-26 12:16
 **/
@RestController
@RequestMapping("/result")
public class Test {


    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("test")
    public ResultData<String> test() {
        String s = "hahahahah";
        return ResultData.ok(s);
    }

    @RequestMapping("error")
    public ResultData<String> error() {
//        Integer.parseInt("abc123");
//        System.out.println(10/0);
        for (int i = 5; i >= -5; i--) {
            System.out.println(100 / i);
//            try {
//                System.out.println(100 / i);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
        }
        return ResultData.ok();
    }

    @GetMapping("/testNull")
    public boolean testNull() {
        //这里故意造成一个空指针的异常，并且不进行处理
        String str = null;
        str.equals("111");
        return true;
    }

    @GetMapping("/testIndexOutOfBunds")
    public boolean testIndexOutOfRebunds() {

        String[] split = "1,2,3".split(",");
        System.out.println(split[5]);

        return true;
    }

    @PostMapping("/testMyException")
    public ResultData<Boolean> testMyException() {
        //如果姓名为空就手动抛出一个自定义的异常！
        String userName = null;
        if (userName == null) {
            throw new MyException("-1", "用户姓名不能为空！");
        }
        return ResultData.ok(true);
    }

    @PostMapping("/testService")
    public ResultData<Boolean> testService() {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ResultData.ok(true);
    }

    @PostMapping("/testTimeOut")
    public ResultData<Boolean> testTimeOut() {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        String js = "{\"query\": {\"match\": {\"content\": \"红绳\"}},\"from\": 0,\"size\": 2}";
        JSONObject jsonObject = JSON.parseObject(js);

        HttpEntity<Object> request = new HttpEntity<>(jsonObject, headers);

        JSONObject jo = restTemplate.postForObject("http://192.168.1.90:8080/result/testService", request, JSONObject.class);
        System.out.println(jo);
        return ResultData.ok(true);
    }

    @GetMapping("/testSuccess")
    public ResultData testSuccess() {
        Map<String, String> map = new HashMap<>();
        map.put("A", "a");
        map.put("B", "b");
        map.put("C", "c");
        return ResultData.ok(map);
    }

    @RequestMapping("/testError")
    public ResultData testError() {
        return ResultData.error("099", "错误错误错误");
    }

    @RequestMapping("/testError1")
    public ResultData testError1() {
        throw new MyException(MyExceptionEnum.BODY_NOT_MATCH);
        //return ResultData.error(MyExceptionEnum.BODY_NOT_MATCH);
    }

}
