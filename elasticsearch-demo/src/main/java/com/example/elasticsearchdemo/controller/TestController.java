package com.example.elasticsearchdemo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.elasticsearchdemo.dao.ArticleRepository;
import com.example.elasticsearchdemo.model.ArticlePO;
import com.example.elasticsearchdemo.service.ArticleService;
import com.hankcs.hanlp.dictionary.stopword.CoreStopWordDictionary;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gary
 * @className TestController
 * @description TODO
 * @date 2019-07-04 19:29
 **/
@RestController
public class TestController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private RestTemplate restTemplate;

//    @PostMapping(value = "/test")
//    public void insert() {
//        ArticlePO articlePO = new ArticlePO();
//        articlePO.setId(1L)
//                .setCategory("美食")
//                .setContent("中国历史文化悠久，地大物博，各地差异大，并且受地理环境、气候条件以及饮食习惯的影响，也因靠山吃山靠水吃水这种因地制宜的思想影响，因此菜的风味也不尽相同，随着时间的沉淀，形成了如今的八大菜系:鲁、川、苏、粤、闽、浙、湘、徽。所以今天就来给大家介绍一下浙菜。浙江菜，简称浙菜，是中国汉族八大菜系之一，其地山清水秀，物产丰富佳肴美，故谚曰:\\\"上有天堂，下有苏杭\\\"。浙江省位于我国东海之滨，北部水道成网，素有鱼米之乡之称。西南丘陵起伏，盛产山珍野味。东部沿海渔场密布，水产资源丰富，有经济鱼类和贝壳水产品500余种，总产值居全国之首，物产丰富，佳肴自美，特色独具，有口皆碑。浙菜有绍兴、杭州、宁波菜系组成。浙江处于鱼米之乡，多产鱼虾，因此口味清鲜，烹饪方法以炖、炸、焖、蒸为主，注重原汁原味，制作精细。名菜有：西湖醋鱼、龙井虾仁、宁波汤团等。追根溯源：宋代以来饮食著作多为江浙文士所著，其代表菜也多与文化名人、风景名胜有关。浙菜以其浓郁的文化特色享誉海内外。非常特色：浙菜由杭州菜、宁波菜、绍兴菜、瓯菜组成。菜式小巧玲珑，清俊逸秀，菜品鲜美滑嫩，脆软清爽。运用香糟调味。非常手段：常用烹调技法有30多种，注重煨、焖、烩、炖等。代表：东坡肉(杭州)、西湖醋鱼(杭州)、龙井虾仁(杭州)、三丝敲鱼(温州)。西湖醋鱼是源于西湖渔家叔嫂除暴安良的民间故事，又名”叔嫂传珍”。是杭州历久不衰的传统名菜。特点：此莱采用鲜活鱼饿养过，鱼肉结实，体内杂物及泥土气已排泄除掉，火候掌握严格，形态仍保持鲜活，成菜色泽红亮，肉质鲜嫩，酸中藏甜，味美如吃蟹肉。")
//                .setTitle("中国八大菜系的浙菜，大家知道多少")
//                .setDigest("中国历史文化悠久，地大物博，各地差异大，并且受地理环境、气候条件以及饮食习惯的影响，也因靠山吃山靠水吃水这种因地制宜的思想影响，因此菜的风味也不尽相同，随着时间的沉淀，形成了如今的八大菜系:鲁、川、苏、粤、闽、浙、湘、徽。");
//        articleService.save(articlePO);
//    }

    @PostMapping(value = "getAll")
    public void getAll() {
        List<ArticlePO> all = articleService.getAll();
        all.forEach(articlePO -> {
//            System.out.println(articlePO);
            try {
                StringBuilder sb = new StringBuilder();

                JSONArray jsonArray = JSONArray.parseArray(articlePO.getContent());
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (jsonObject.containsKey("text")) {
                        sb.append(jsonObject.getString("text"));
                    }
                }
//            System.out.println(sb);
                articlePO.setContent(sb.toString());
                System.out.println(articlePO);
                articleRepository.save(articlePO);

            } catch (Exception e) {
                e.printStackTrace();
            }

        });
    }

    @PostMapping(value = "analyzer")
    public void analyzer(@RequestParam("s") String s) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        String js = "{\"analyzer\": \"ik_smart\",\"text\":\"" + s + "\"}";
        JSONObject jsonObject = JSON.parseObject(js);

        HttpEntity<Object> request = new HttpEntity<>(jsonObject, headers);

        HttpEntity<JSONObject> jo = restTemplate.postForEntity("http://117.78.27.206:9200/_analyze", request, JSONObject.class);
        System.out.println(jo.getBody());

        JSONObject result = jo.getBody();
        JSONArray jsonArray = result.getJSONArray("tokens");
        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject tokenJo = (JSONObject) jsonArray.get(i);
            tokens.add(tokenJo.getString("token"));
        }
        System.out.println(tokens);
    }

    @PostMapping(value = "search")
    public void search() {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        //queryBuilder.withQuery(QueryBuilders.matchPhraseQuery("content", "驾驶区设置防护设施").analyzer("ik_smart").slop(1));
        queryBuilder.withQuery(QueryBuilders.matchQuery("content", "驾驶区设置防护设施").operator(Operator.AND).analyzer("ik_smart"));
        queryBuilder.withPageable(PageRequest.of(0, 10));
        // 搜索，获取结果
        Page<ArticlePO> items = articleRepository.search(queryBuilder.build());
        System.out.println(queryBuilder.build().getQuery());
        // 总条数
        System.out.println(items);
        long total = items.getTotalElements();
        System.out.println("total = " + total);
        for (ArticlePO item : items) {
            System.out.println(item);
        }

    }

    public static void main(String[] args) {
        String text = "谢尔盖·科罗廖夫（1907年1月12日－1966年1月14日），原苏联宇航事业的伟大设计师与组织者 ，第一枚射程超过8000公里的洲际火箭（弹道导弹）的设计者，第一颗人造地球卫星的运载火箭的设计者、第一艘载人航天飞船的总设计师。";
//
        List<Term> lists = NLPTokenizer.segment(text);
        System.out.println(lists);
        CoreStopWordDictionary.apply(lists);
        System.out.println(lists);

//        String content = "程序员(英文Programmer)是从事程序开发、维护的专业人员。一般将程序员分为程序设计人员和程序编码人员，但两者的界限并不非常清楚，特别是在中国。软件从业人员分为初级程序员、高级程序员、系统分析员和项目经理四大类。";
//        List<String> keywordList = HanLP.extractKeyword(content, 5);
//        System.out.println(keywordList);

//        String document = "算法可大致分为基本算法、数据结构的算法、数论算法、计算几何的算法、图的算法、动态规划以及数值分析、加密算法、排序算法、检索算法、随机化算法、并行算法、厄米变形模型、随机森林算法。\n" +
//                "算法可以宽泛的分为三类，\n" +
//                "一，有限的确定性算法，这类算法在有限的一段时间内终止。他们可能要花很长时间来执行指定的任务，但仍将在一定的时间内终止。这类算法得出的结果常取决于输入值。\n" +
//                "二，有限的非确定算法，这类算法在有限的时间内终止。然而，对于一个（或一些）给定的数值，算法的结果并不是唯一的或确定的。\n" +
//                "三，无限的算法，是那些由于没有定义终止定义条件，或定义的条件无法由输入的数据满足而不终止运行的算法。通常，无限算法的产生是由于未能确定的定义终止条件。";
//        List<String> sentenceList = HanLP.extractSummary(document, 1);
//        System.out.println(sentenceList);
//        List<String> keywordList = HanLP.extractKeyword(document, 3);
//        System.out.println(keywordList);
//
//        String text = "算法工程师\n" +
//                "算法（Algorithm）是一系列解决问题的清晰指令，也就是说，能够对一定规范的输入，在有限时间内获得所要求的输出。如果一个算法有缺陷，或不适合于某个问题，执行这个算法将不会解决这个问题。不同的算法可能用不同的时间、空间或效率来完成同样的任务。一个算法的优劣可以用空间复杂度与时间复杂度来衡量。算法工程师就是利用算法处理事物的人。\n" +
//                "\n" +
//                "1职位简介\n" +
//                "算法工程师是一个非常高端的职位；\n" +
//                "专业要求：计算机、电子、通信、数学等相关专业；\n" +
//                "学历要求：本科及其以上的学历，大多数是硕士学历及其以上；\n" +
//                "语言要求：英语要求是熟练，基本上能阅读国外专业书刊；\n" +
//                "必须掌握计算机相关知识，熟练使用仿真工具MATLAB等，必须会一门编程语言。\n" +
//                "\n" +
//                "2研究方向\n" +
//                "视频算法工程师、图像处理算法工程师、音频算法工程师 通信基带算法工程师\n" +
//                "\n" +
//                "3目前国内外状况\n" +
//                "目前国内从事算法研究的工程师不少，但是高级算法工程师却很少，是一个非常紧缺的专业工程师。算法工程师根据研究领域来分主要有音频/视频算法处理、图像技术方面的二维信息算法处理和通信物理层、雷达信号处理、生物医学信号处理等领域的一维信息算法处理。\n" +
//                "在计算机音视频和图形图像技术等二维信息算法处理方面目前比较先进的视频处理算法：机器视觉成为此类算法研究的核心；另外还有2D转3D算法(2D-to-3D conversion)，去隔行算法(de-interlacing)，运动估计运动补偿算法(Motion estimation/Motion Compensation)，去噪算法(Noise Reduction)，缩放算法(scaling)，锐化处理算法(Sharpness)，超分辨率算法(Super Resolution),手势识别(gesture recognition),人脸识别(face recognition)。\n" +
//                "在通信物理层等一维信息领域目前常用的算法：无线领域的RRM、RTT，传送领域的调制解调、信道均衡、信号检测、网络优化、信号分解等。\n" +
//                "另外数据挖掘、互联网搜索算法也成为当今的热门方向。\n" +
//                "算法工程师逐渐往人工智能方向发展。";
//        List<String> phraseList = HanLP.extractPhrase(text, 10);
//        System.out.println(phraseList);

//        Suggester suggester = new Suggester();
//        String[] titleArray =
//                (
//                        "威廉王子发表演说 呼吁保护野生动物\n" +
//                                "《时代》年度人物最终入围名单出炉 普京马云入选\n" +
//                                "“黑格比”横扫菲：菲吸取“海燕”经验及早疏散\n" +
//                                "日本保密法将正式生效 日媒指其损害国民知情权\n" +
//                                "英报告说空气污染带来“公共健康危机”\n" +
//                                "用笔记本电脑写程序"
//                ).split("\\n");
//        for (String title : titleArray) {
//            suggester.addSentence(title);
//        }
//
//        //System.out.println(suggester.suggest("发言", 1));       // 语义
//        System.out.println(suggester.suggest("发表", 1));   // 字符
       // System.out.println(suggester.suggest("mayun", 1));      // 拼音


//        CoNLLSentence sentence = HanLP.parseDependency("徐先生还具体帮助他确定了把画雄鹰、松鼠和麻雀作为主攻目标。");
//        System.out.println(sentence);
//        // 可以方便地遍历它
//        for (CoNLLWord word : sentence) {
//            System.out.printf("%s --(%s)--> %s\n", word.LEMMA, word.DEPREL, word.HEAD.LEMMA);
//        }
//        // 也可以直接拿到数组，任意顺序或逆序遍历
//        CoNLLWord[] wordArray = sentence.getWordArray();
//        for (int i = wordArray.length - 1; i >= 0; i--) {
//            CoNLLWord word = wordArray[i];
//            System.out.printf("%s --(%s)--> %s\n", word.LEMMA, word.DEPREL, word.HEAD.LEMMA);
//        }
//        // 还可以直接遍历子树，从某棵子树的某个节点一路遍历到虚根
//        CoNLLWord head = wordArray[12];
//        while ((head = head.HEAD) != null) {
//            if (head == CoNLLWord.ROOT) {
//                System.out.println(head.LEMMA);
//            } else {
//                System.out.printf("%s --(%s)--> ", head.LEMMA, head.DEPREL);
//            }
//        }
    }

}
