package com.example.springboottestdemo.controller;

import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.util.StringUtils;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

    private static final String[] hexDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f"};

    private static final String SHA1 = "SHA1";
    private static final String SHA256 = "SHA-256";
    private static final String SHA512 = "SHA-512";

//--------------------------判定字符串属性------------------------------------

    /**
     * @param beforeStr
     * @return String 过滤后的字符串
     * @Title: isUrl
     * @Description: 替换文中的所有中英文标点，空格
     * @Author huxiaosan
     * @DateTime 2019年6月4日 下午3:07:59
     */
    public static String filterPunctuation(String beforeStr) {
       return beforeStr.replaceAll("[\\s\\p{P}]+", "");
    }

    /**
     * @param leftStr rightStr
     * @return
     * @Title: isUrl
     * @Description: 判定字母是否成对匹配
     * @Author huxiaosan
     * @DateTime 2019年6月4日 下午3:07:59
     */
    public static boolean isMatch(String leftStr, String rightStr) {
        switch (rightStr) {
            case ")":
                return leftStr.equals("(");
            case "}":
                return leftStr.equals("{");
            case "]":
                return leftStr.equals("[");
            case "）":
                return leftStr.equals("（");
            case "】":
                return leftStr.equals("【");
            case "”":
                return leftStr.equals("“");
            default:
                return false;
        }
    }

    /**
     * @param str
     * @return
     * @Title: isUrl
     * @Description: 判定首字母是否为有效标点
     * @Author huxiaosan
     * @DateTime 2019年6月4日 下午3:07:59
     */
    public static boolean initialValid(String str) {
        Pattern pattern = Pattern.compile("^[”]\\)}}】）]");
        return !pattern.matcher(str).find();
    }
    /**
     * @param str
     * @return
     * @Title: isUrl
     * @Description: 判定一个词在字符串中出现的次数
     * @Author huxiaosan
     * @DateTime 2019年6月4日 下午3:07:59
     */
    public static int getKeyTime(String str,String key) {
        int count = 0;
        int index = 0;
        while((index=str.indexOf(key,index))!=-1){
            index = index+key.length();
            count++;
        }
        return count;
    }

    /**
     * @param str
     * @return
     * @Title: isUrl
     * @Description: 判定标点是否成对出现
     * @Author huxiaosan
     * @DateTime 2019年6月4日 下午3:07:59
     */
    public static boolean isPunktruationNorm(String str) {
        ArrayStack<String> stringStack = new ArrayStack<>();
        String leftPunktruation = "({[（【“";
        String rightPunktruation = ")}]）】”";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String s = String.valueOf(c);
            if (!rightPunktruation.contains(s)) {
                //不属于右半边符号压栈
                stringStack.push(s);
            } else {
                int count = 0;
                try {
                    //取出栈顶数据
                    String pop = stringStack.pop();
                    while (!isMatch(pop, s)) {
                        //属于左半边符号却没有配对成功返回false
                        if (leftPunktruation.contains(pop)) {
                            return false;
                        }
                        pop = stringStack.pop();
                        count++;
                    }
                } catch (RuntimeException e) {
                    //知道取出所有数据都没有成功，
                    return false;
                }
                //两个符号之间没有数据
                if (count == 0) return false;
            }
        }
        while (!stringStack.empty()) {
            String ch = stringStack.pop();
            //右半边符号全部对应，栈中还留有左半边符号
            if (leftPunktruation.contains(ch)) return false;
        }
        return true;
    }

    /**
     * @param str
     * @return
     * @Title: isUrl
     * @Description: 判定字符串是否包含URL
     * @Author huxiaosan
     * @DateTime 2019年6月4日 下午3:07:59
     */
    public static boolean isUrl(String str) {
        return str.contains("http");
    }

    /**
     * @param str
     * @return
     * @Title: isInteger
     * @Description: 判定字符串是否是数字
     * @Author BlueMorpho
     * @DateTime 2019年1月24日 下午3:07:59
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        return pattern.matcher(str).matches();
    }

    /**
     * @param str
     * @return
     * @Title: isDelay
     * @Description: 判定是否是匹配<2   0   0   0>
     * @Author BlueMorpho
     * @DateTime 2019年1月24日 下午5:32:38
     */
    public static boolean isDelay(String str) {
        Pattern pattern = Pattern.compile("^<[0-9]{1,}>$");
        return pattern.matcher(str).matches();
    }

    /**
     * @param str
     * @return
     * @Title: tailHasPunctuation
     * @Description: 去除字符串结尾的标点符号
     * @Author BlueMorpho
     * @DateTime 2019年2月18日 下午7:12:54
     */
    public static String deleteTailPunctuation(String str) {
        String dest = null;
        Pattern patPunc = Pattern.compile("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]+$");
        Matcher m = patPunc.matcher(str);
        dest = m.replaceAll("");

        return dest;
    }

//--------------------------获取随机数------------------------------------

    /**
     * @param N
     * @return N位随机数
     * @Title: generateDecimalistRandomName
     * @Description: 生成N位的随机码，每位为10进制。例：513513
     * @Author BlueMorpho
     * @DateTime 2019年1月18日 下午3:44:07
     */
    public static String generateDecimalRandom(int N) {
        StringBuilder random = new StringBuilder();
        for (int i = 0; i < N; i++) {
            random.append(Integer.toString(new Random().nextInt(10)));
        }
        return random.toString();
    }

    /**
     * @param N
     * @return N位随机数
     * @Title: generateHexRandomName
     * @Description: 生成N位的随机码，每位为十六进制。例：1b91fd6540
     * @Author BlueMorpho
     * @DateTime 2019年1月18日 下午3:45:02
     */
    public static String generateHexRandom(int N) {
        StringBuilder random = new StringBuilder();
        for (int i = 0; i < N; i++) {
            random.append(Integer.toHexString(new Random().nextInt(16)));
        }
        return random.toString();
    }

    /**
     * @param N
     * @return N位随机数
     * @Title: generateCharacterRandom
     * @Description: 生成N位的随机字符，包含数字、大小写字母。例：N07Lp4Ai2V5auO76iHM8
     * @Author BlueMorpho
     * @DateTime 2019年1月18日 下午4:19:30
     */
    public static String generateCharacterRandom(int N) {
        StringBuilder random = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int index = new Random().nextInt(3);
            // 目的是随机选择生成数字、大小写字母
            switch (index) {
                case 0:
                    random.append(new Random().nextInt(10)); // 生成0~9
                    break;
                case 1:
                    random.append((char) (new Random().nextInt(26) + 65)); // 生成A~Z
                    break;
                case 2:
                    random.append((char) (new Random().nextInt(26) + 97));// 生成a~z
                    break;
            }
        }
        return random.toString();
    }
    //----------------------------url---------------------------------------
//    public static HuaweiBucket getBucket(String url) {
//        HuaweiBucket huaweiBucket = new HuaweiBucket();
//        huaweiBucket.setBucketName(url.substring(url.indexOf("//") + 2, url.indexOf(".")));
//        huaweiBucket.setObjectKey(url.substring(url.indexOf("myhuaweicloud.com") + "myhuaweicloud.com".length()+1));
//        return huaweiBucket;
//    }
    //----------------------------MD5---------------------------------------
    public static String MD5(String str) {
            if (StringUtils.isEmpty(str)) {
            throw new IllegalArgumentException("String to encript cannot be null or zero length");
        }
        StringBuffer hexString = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] hash = md.digest();
            for (int i = 0; i < hash.length; i++) {
                if ((0xff & hash[i]) < 0x10) {
                    hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
                } else {
                    hexString.append(Integer.toHexString(0xFF & hash[i]));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return hexString.toString();
    }


    public static String fileMD5(File file) {
        FileInputStream fis = null;
        String md5=null;
        try {
             fis = new FileInputStream(file);
             md5 = MD5(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(fis!=null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return md5;
    }
    public static String MD5(InputStream stream) {
        BigInteger bigInt = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[1024];
            int length = -1;
            while ((length = stream.read(buffer)) != -1) {
                md.update(buffer, 0, length);
            }
            bigInt = new BigInteger(1, md.digest());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bigInt != null ? bigInt.toString(16) : null;
    }

    public static String byteArrayToHexString(byte[] iI1l) {
        StringBuffer illl1111I1I = new StringBuffer();
        for (int i11I = 0; i11I < iI1l.length; ++i11I)
            illl1111I1I.append(byteToHexString(iI1l[i11I]));

        return illl1111I1I.toString();
    }

    private static String byteToHexString(byte iI1l) {
        int ilIl = iI1l;
        if (ilIl < 0)
            ilIl += 256;
        int iIII1 = ilIl / 16;
        int i1I1I = ilIl % 16;
        return hexDigits[iIII1] + hexDigits[i1I1I];
    }

    public static String MD5Encode(String iIIllI1II) {
        String i1I1lIll1Ill1I1 = null;
        try {
            i1I1lIll1Ill1I1 = new String(iIIllI1II);
            MessageDigest iIl1l = MessageDigest.getInstance("MD5");
            i1I1lIll1Ill1I1 = byteArrayToHexString(iIl1l.digest(i1I1lIll1Ill1I1.getBytes()));
        } catch (Exception iIl1l) {
        }
        return i1I1lIll1Ill1I1;
    }

    // ----------------------------SHA加密---------------------------------------

    /**
     * @param strText
     * @return
     * @Title: SHA1
     * @Description: 传入文本内容，返回 SHA1串
     * @Author BlueMorpho
     * @DateTime 2019年1月22日 下午2:41:24
     */
    public static String SHA1(final String strText) {
        return SHA(strText, SHA1);
    }

    /**
     * @param strText
     * @return
     * @throws UnsupportedEncodingException
     * @Title: SHA256
     * @Description: 传入文本内容，返回 SHA-256串
     * @Author BlueMorpho
     * @DateTime 2019年1月22日 下午2:26:58
     */
    public static String SHA256(final String strText) {
        return SHA(strText, SHA256);
    }

    /**
     * @param strText
     * @return
     * @throws UnsupportedEncodingException
     * @Title: SHA512
     * @Description: 传入文本内容，返回 SHA-512串
     * @Author BlueMorpho
     * @DateTime 2019年1月22日 下午2:27:13
     */
    public static String SHA512(final String strText) {
        return SHA(strText, SHA512);
    }

    /**
     * @param strText
     * @param shaType
     * @return
     * @throws UnsupportedEncodingException
     * @Title: SHA
     * @Description: 字符串 SHA 加密
     * @Author BlueMorpho
     * @DateTime 2019年1月22日 下午2:28:32
     */
    private static String SHA(final String strText, final String shaType) {
        // 返回值
        String strResult = null;
        // 是否是有效字符串
        if (strText != null && strText.length() > 0) {
            try {
                // SHA 加密开始
                // 创建加密对象 并传入加密类型
                MessageDigest messageDigest = MessageDigest.getInstance(shaType);
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes("UTF-8"));
                // 得到返回結果
                strResult = byteArrayToHexString(messageDigest.digest());
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return strResult;
    }

    // ----------------------------防sql注入---------------------------------------

    /**
     * @param str
     * @return
     * @Title: sqlInjection
     * @Description: 防sql注入
     * @Author BlueMorpho
     * @DateTime 2019年1月22日 下午2:42:28
     */
    public static boolean sqlInjection(String str) {
        str = str.toLowerCase();// 统一转为小写
        String badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|"
                + "char|declare|sitename|net user|xp_cmdshell|;|or|+|,|like'|and|exec|execute|insert|create|drop|"
                + "table|from|grant|use|group_concat|column_name|"
                + "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|"
                + "chr|mid|master|truncate|char|declare|or|;|--|+|,|like|//|/|%|#";// 过滤掉的sql关键字，可以手动添加
        String[] badStrs = badStr.split("\\|");
        for (int i = 0; i < badStrs.length; i++) {
            if (str.indexOf(badStrs[i]) >= 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //System.out.println(isPunktruationNorm("as“f({af})”"));
        System.out.println(getKeyTime("哈哈你好哈哈啊","好哈"));
    }
}
