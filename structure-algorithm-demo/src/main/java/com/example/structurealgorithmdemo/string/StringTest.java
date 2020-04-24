package com.example.structurealgorithmdemo.string;

/**
 * 字符串测试
 *
 * @author Gary
 * @date 2020/4/23 11:08
 **/
public class StringTest {

    public static void main(String[] args) {

//        String s = "abcd123";
//        System.out.println(loopShift(s, 3));
        String s = "aaa";

        System.out.println(new Solution().pStrings(s));

    }


    public static String loopShift(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        StringBuilder ss = new StringBuilder();
        for (int i = 0; i < n - k; i++) {
            s1.insert(0, s.charAt(i));
            s1.reverse();
        }
        System.out.println(s1);
        for (int i = n - k; i < n; i++) {
            s2.insert(0, s.charAt(i));
        }
        System.out.println(s2);
        for (int i = 0; i < n; i++) {
            ss.insert(0, (s1 + s2.toString()).charAt(i));
        }
        return ss.toString();
    }


}

class Solution {

    int count = 0;

    public int pStrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendSubstring(s, i, i);
            extendSubstring(s, i, i + 1);
        }
        return count;
    }

    private void extendSubstring(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
            count++;
        }
    }
}
