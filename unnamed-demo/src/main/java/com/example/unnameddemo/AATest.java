package com.example.unnameddemo;

import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;

/**
 * aatest
 *
 * @author Gary
 * @date 2020/8/1 00:49
 **/
public class AATest {

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        List<Long> list = Arrays.asList(100L, 200L, 300L);
        jsonObject.put("id", 1);
        jsonObject.put("caseList", list);
        System.out.println(jsonObject);
        People people = jsonObject.toJavaObject(People.class);
        System.out.println(people);
    }

    private static class People {
        private Long id;
        private List<Long> caseList;

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public List<Long> getCaseList() {
            return caseList;
        }

        public void setCaseList(List<Long> caseList) {
            this.caseList = caseList;
        }

        @Override
        public String toString() {
            return "People{" +
                    "id=" + id +
                    ", caseList=" + caseList +
                    '}';
        }
    }
}
