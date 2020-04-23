package com.example.unnameddemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * a
 *
 * @author Gary
 * @date 2020/4/7 20:56
 **/
public class Shit {

    public static void main(String[] args) {
        String str = "1.1 1.7 1.3 1.6 1.2 1.10 1.30 2.1 2.2 3.1";
        System.out.println(transfer(str));
    }

    private static String transfer(String str) {

        Map<String, ArrayList<Integer>> map = new HashMap<>(4);
        String[] strings = str.split(" ");
        for (String s : strings) {
            String m = s.split("\\.")[0];
            String d = s.split("\\.")[1];
            if (!map.containsKey(m)) {
                ArrayList<Integer> dList = new ArrayList<>();
                dList.add(Integer.parseInt(d));
                map.put(m, dList);
            } else {
                map.get(m).add(Integer.parseInt(d));
            }

        }

        StringBuilder s = new StringBuilder();
        for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
            // 1.1 1.2 1.3 1.6 1.10 1.30 2.1 2.2 3.1
            String key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
            Collections.sort(value);
            int i = 1;
            int start = value.get(0);
            int end = value.get(0);
            s.append(key).append(".").append(start); // 1.1
            while (i < value.size()) {
                if (value.get(i) - value.get(i - 1) != 1) {
                    if (start != end) {
                        s.append("-").append(end);
                    }
                    start = value.get(i);
                    s.append(" ").append(key).append(".").append(start);
                }
                end = value.get(i);
                i++;
                if (i == value.size() && start != end) {
                    s.append("-").append(end);
                }
            }
            s.append(" ");
        }
        return s.toString();
    }
}
