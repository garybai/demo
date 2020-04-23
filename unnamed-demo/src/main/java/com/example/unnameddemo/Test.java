package com.example.unnameddemo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;

import java.util.*;

/**
 * @author Gary
 * @className Test
 * @description TODO
 * @date 2019-07-19 16:27
 **/
public class Test {

    private static String extractText(Node node) {

        /* TextNode直接返回结果 */
        if (node instanceof TextNode) {
            return ((TextNode) node).text();
        }
        /* 非TextNode的Node，遍历其孩子Node */
        List<Node> children = node.childNodes();
        StringBuffer buffer = new StringBuffer();

        for (Node child : children) {
//            if("#text".equalsIgnoreCase(child.nodeName())){
//                buffer1.append("\"text\":\"" + extractText(child)+"\"");
//            }
            buffer.append(extractText(child));
        }
        return buffer.toString();
    }

    private static String extractTextToJson(Node node) {

        /* TextNode直接返回结果 */
        if (node instanceof TextNode) {
            return "\"text\":\"" + ((TextNode) node).text() + "\",";
        }
        /* 非TextNode的Node，遍历其孩子Node */
        List<Node> children = node.childNodes();
        StringBuffer buffer = new StringBuffer();

        for (Node child : children) {
            buffer.append(extractTextToJson(child));
        }
        return buffer.toString();
    }

    /* 使用jsoup解析html并转化为提取字符串*/
    public static String html2Str(String html) {
        Document doc = Jsoup.parse(html);
        return extractText(doc);
    }

    /* 使用jsoup解析html并转化为提取字符串*/
    public static String html2Json(String html) {
        Document doc = Jsoup.parse(html);
        return extractTextToJson(doc);
    }


//    public static void main(String[] args) {
//
//        String html = "<p>aaa<strong>bbb</strong>ccc</p>";
//
////        Document document = Jsoup.parse(html);
////        Elements elements = document.select("p");
//
////        for (Element element : elements) {
////            System.out.println(element + "-------" + element.text() + "------" + element.ownText() + "--------" + element.wholeText());
////        }
//        System.out.println(html2Str(html));
//        System.out.println(html2Json(html));
//
////    String strDate = "2017-03-25";
////    注意：SimpleDateFormat构造函数的样式与strDate的样式必须相符
////        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
////        //必须捕获异常
////        Date date = null;
////        try {
////
////            date = simpleDateFormat.parse("2017-03-25");
////            System.out.println(date);
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
//
//
//
//    }

    public static int compareVersion(String s1, String s2) {
        String[] s1Split = s1.split("\\.", -1);
        String[] s2Split = s2.split("\\.", -1);
        int len1 = s1Split.length;
        int len2 = s2Split.length;
        int lim = Math.min(len1, len2);
        int i = 0;
        while (i < lim) {
            int c1 = "".equals(s1Split[i]) ? 0 : Integer.parseInt(s1Split[i]);
            int c2 = "".equals(s2Split[i]) ? 0 : Integer.parseInt(s2Split[i]);
            if (c1 != c2) {
                return c1 - c2;
            }
            i++;
        }
        return len1 - len2;
    }

    public static boolean push(Integer a) {
        if (a == 10) {
            return false;
        }
        return Math.random() > 0.1;
    }

    public static void batchPush(ArrayList<Integer> list, Integer n) {

        if (n > 3) {
            return;
        }
        System.out.println("第" + n + "次推送");
        if (list == null || list.size() == 0) {
            return;
        }
        ArrayList<Integer> faildList = new ArrayList<>();
        for (Integer a : list) {
            boolean push = push(a);
            if (!push) {
                System.out.println(a + "失败");
                faildList.add(a);
            } else {
                System.out.println(a + "成功");
            }
        }

        System.out.println("失败" + faildList.size() + "条----");
        n++;
        if (faildList.size() != 0) {
            batchPush(faildList, n);
        }
    }


    public static void main(String[] args) {



        test();

//        ArrayList<Integer> list = new ArrayList<>(1000);
//        for (int i = 0; i < 1000; i++) {
//            list.add(i);
//        }
//
//        batchPush(list, 1);


//        System.out.println(list.size());
//        Instant now = Instant.now();
//        int nano = now.getNano();


//        LocalDateTime dateTime = LocalDateTime.now();
//        String str = dateTime.format(DateTimeFormatter.ISO_DATE_TIME);
//        System.out.println(str);
//        str = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        System.out.println(str);

//        IntSummaryStatistics summaryStatistics = Stream.of(1, 2, 3).mapToInt((i) -> i).summaryStatistics();
//        System.out.println("max:" + summaryStatistics.getMax());
//        System.out.println("min:" + summaryStatistics.getMin());
//        System.out.println("sum:" + summaryStatistics.getSum());
//        System.out.println("average:" + summaryStatistics.getAverage());

//        boolean noneMatch = Stream.of(1, 2, 3).noneMatch(i  -> i > 5);
//        System.out.println(noneMatch);

//        Optional<String> first = Stream.of("A", "B", "C").findFirst();
//        System.out.println(first.get());

//        Optional<String> any = Stream.of("A", "B", "C").findAny();
//        System.out.println(any.get());

//        boolean result = Stream.of(1, 2, 3).allMatch(i  -> i > 0);
//        System.out.println(result);

//        Stream.of(1, 2, 3).reduce(Integer::sum);
//        Stream.of(1, 2, 3).reduce(0, (a, b) -> a + b);

//        Optional<Integer> max = Stream.of(1, 2, 3).parallel().max(Comparator.comparingInt(o -> o));
//        System.out.println("max:" + max.get());

//        System.out.println(Stream.of(1, 2, 3).count());

//        Stream.of(1, 2, 3).collect(Collectors.toList());
//        Stream.of(1, 2, 3).collect(Collectors.toSet());

//        Stream.of(1, 2, 3).limit(2).forEach(System.out::println);

//        Stream.of(1, 3, 2).sorted().forEach(System.out::println);


//        Stream.of(1, 2, 3).skip(2).forEach(System.out::println);

//        Stream.of(1, 2).peek(i -> System.out.println("peekCall:" + i)).forEach(System.out::println);


//        Stream.of(1, 2, 3).flatMap(i -> Stream.of(i * 10)).forEach(System.out::println);

//        Stream.of("a", "b", "c").map(item -> item.toUpperCase()).forEach(System.out::println);
//        Stream.of("a", "b", "c").map(String::toUpperCase).forEach(System.out::println);

//        Stream.of(1, 2, 3, 4, 5).filter(i -> i >= 3).forEach(System.out::println);

//        Stream.of(1, 2, 2).distinct().forEach(System.out::println);

//        Stream.concat(Stream.of("1", "2"), Stream.of("A")).forEach(System.out::println);


//        String str = "a,b,c,,";
////        String[] ary = str.split(",");
////        // 预期大于 3，结果是 3
////        System.out.println(ary.length);6
//        String a = "2.8";
//        String b = "2.2.0";
//        //System.out.println(a.compareTo(b));
//
//        System.out.println(compareVersion(a, b));

//        for (int i = 5; i >= -5; i--) {
//            try {
//                System.out.println(100 / i);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        Map map1 = Maps.newHashMap();
//        map1.put("key",null);
//        System.out.println(map1.get("key"));
//        Map map2 = Maps.newConcurrentMap();
//        map2.put("key", null);

//        List<String> list = Arrays.asList("欢迎", "关注", "程序新视界");
//        list.forEach(System.out::println);
//        List<String> collect = list.stream().filter(str -> str.length() > 2).collect(Collectors.toList());
//        collect.forEach(System.out::println);

//        Stream<Integer> stream = Stream.of(1);
//        Stream<String> stream1 = Stream.of("a", "b", "c");
//
//        Stream<Double> generateDouble = Stream.generate(Math::random);
//        generateDouble.forEach(System.out::println);

//        Stream.iterate(1, i -> i + 1).limit(10).forEach(System.out::println);
//        List<String> list = new ArrayList<>();
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.stream().forEach(System.out::println);
//        int[] nums = new int[]{1, 2, 3, 4, 5};
//        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void test() {
        List<Object> l1 = new ArrayList<>();
        System.out.println(l1.size());
        l1.add(1);
        l1.add(2);
        l1.add(3);
        System.out.println(l1);
        l1.add(1,"a");
        System.out.println(l1);
        l1.set(1,"n");
        System.out.println(l1);
        List<Object> l2 = new LinkedList<>();
        List<Object> l3 = new Vector<>();
        List<Object> l4 =  new Stack<>();

        Set<Object> s1 = new HashSet<>();
        Set<Object> s2 = new LinkedHashSet<>();
        Set<Object> s = new TreeSet<>();

        Queue<Object> queue = new PriorityQueue<>();

        Map<String, Object> table = new Hashtable<>();
        Map<String, Object> map3 = new LinkedHashMap<>();
        Map<String, Object> map4 = new TreeMap<>();
        Map<String, String> map = new HashMap<>(4);
        map.put("xsd", "aaa");
        map.put("vdw", "ccc");
        map.put("wqt", "ddd");
        map.put("fwe", "bbb");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + "\tvalue:" + entry.getValue());
        }

        Set<Map.Entry<String, String>> sets = map.entrySet();
        LinkedList<Map.Entry<String, String>> linkedList = new LinkedList<>(sets);

        linkedList.sort(Comparator.comparing(Map.Entry::getValue));
        Map<String, String> map1 = new LinkedHashMap<>();
        for (Map.Entry<String, String> entry : linkedList){
            map1.put(entry.getKey(), entry.getValue());
        }

        for (Map.Entry<String, String> entry : map1.entrySet()) {
            System.out.println("key:" + entry.getKey() + "\tvalue:" + entry.getValue());
        }

        Map<String, String> map2 = new TreeMap<>();
        map2.put("xsd", "aaa");
        map2.put("vdw", "ccc");
        map2.put("wqt", "ddd");
        map2.put("fwe", "bbb");
        for (Map.Entry<String, String> entry : map2.entrySet()) {
            System.out.println("key:" + entry.getKey() + "\tvalue:" + entry.getValue());
        }

    }


}
