package com.example.springboottestdemo.controller;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName:
 * @Description:
 * @Author
 * @DateTime
 */
public class SimHash {
    private static final BigInteger bigInteger = new BigInteger("1");
    private static int hashbits = 128;
    private static BigInteger[] MASKS = new BigInteger[hashbits];

    private static synchronized void initMASKS() {
        if(MASKS[hashbits-1]==null){
            for (int i = 0; i <hashbits ; i++) {
                MASKS[i] = new BigInteger("1").shiftLeft(i);
            }
        }
    }

    public static BigInteger simHash(String strs) {
        //过滤点中英文及空格
        strs = StringUtil.filterPunctuation(strs);
        if(MASKS[hashbits-1]==null)
        initMASKS();
        int[] dim=new int[128];
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            String substring;
            BigInteger bigInteger;
            for (int index = 0; index <strs.length() ; index++) {
                substring = strs.substring(index, index + 1);
                StringBuilder hexString = new StringBuilder();
                md.update(substring.getBytes());
                byte[] bytes = md.digest();
                int i;
                for (byte b : bytes) {
                    i = b;
                    if (i < 0)
                        i += 256;
                    if (i < 16)
                        hexString.append("0");
                    hexString.append(Integer.toHexString(i));
                }
                //16进制转10进制
                bigInteger = new BigInteger(String.valueOf(hexString), 16);
                for (int j = 0; j < hashbits; j++) {
                    if(!"0".equals(bigInteger.and(MASKS[j]).toString())){
                        dim[j]+=1.0;
                    }else {
                        dim[j]+=-1.0;
                    }
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger bigInteger = new BigInteger("0");
        for (int i = 0; i <hashbits ; i++) {
            if(dim[i]>0)
                bigInteger=bigInteger.or(MASKS[i]);
        }
        return bigInteger;
    }

    public static double dist(BigInteger h1,BigInteger h2) {
        BigInteger x=(h1.xor(h2).and((bigInteger.shiftLeft(hashbits).subtract(bigInteger))));
        double dist=0;
        while (!"0".equals(x.toString())){
           dist+=1.0;
            x=x.and(x.subtract(bigInteger));
       }
       return dist/hashbits;
    }

    public static double compare(Object s1,Object s2){
        BigInteger integer1;
        BigInteger integer2;
        if(s1 instanceof String&&s2 instanceof String){
             integer1 = simHash((String) s1);
             integer2 = simHash((String) s2);
        }else if(s1 instanceof BigInteger&&s2 instanceof BigInteger) {
             integer1=(BigInteger)s1;
             integer2=(BigInteger)s2;
        }else {
            return 0.0;
        }
        double dist = dist(integer1, integer2);
        dist=1.0-dist;
        if(dist<0.5){
            dist=0.0;
        }else {
            dist=(dist-0.5)/0.5;
        }
        return DoubleUtil.formatDouble2(dist);
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        long l = System.currentTimeMillis();
        SimHash simHash = new SimHash();
        BigInteger integer1 = simHash.simHash("易撰网简介与产品介绍\n" +
                "\n" +
                "易撰网平台由长沙营智信息技术有限公司于2017年开发。长沙营智信息技术有限公司，成立于2014年，深耕数据服务市场，5年来为多个行业提供数据采集、数据分析、程序开发等服务。易撰平台现有会员用户超过50万，公司技术团队超40人，运营团队30人，为易撰提供强有力的技术支撑与专业的服务支持。\n" +
                "\n" +
                "易撰网平台是一款专业的自媒体数据分析工具，同时也是一款自媒体教育培训课程平台；旨在为自媒体人提供数据搜索、数据分析服务及运营工具，以NLP算法深入研究整合各方数据资源，打破信息孤岛，用大数据为创作赋能，为原创保驾护航，使各自媒体人实现轻松创作，高效运营。\n" +
                "\n" +
                "产品介绍:\n" +
                "\n" +
                "易撰旗下产品有自媒体助手、BPM自媒体业务流程管控系统、抖音助手、易撰会社群。\n" +
                "\n" +
                "1. 自媒体助手工具：\n" +
                "\n" +
                "包括自媒体数据分析、稿件质量评定、运营辅助工具系统三大核心功能。\n" +
                "\n" +
                "自媒体数据分析功能栏分数据库、数据监测、排行榜、编辑器四个具体功能。\n" +
                "\n" +
                "1、 数据库：\n" +
                "\n" +
                "有自媒体文库、商品库、话题库、视频库。\n" +
                "\n" +
                "自媒体库收录众自媒体平台实时资讯数据，内容覆盖各行业领域，可支持各创作领域自媒体创客进行资讯搜索，并有精选爆文，为各创作领域自媒体创客提供优质选题与素材资源，还有实时热点监测，让各创作领域自媒体创客随时了解实时热点，把握创作方向。\n" +
                "\n" +
                "商品库抓取量大电商平台商品资源，可为自媒体淘宝客提供商品资源，并支持佣金、销量对比，让自媒体淘宝客更熟悉商品信息，做优质推广，还有主流自媒体平台优质商品图文，为各自媒体淘宝客提供创作指引。\n" +
                "\n" +
                "话题库收录各主流问答平台问答数据，各自媒体创客可以通过不同领域问答搜索获取选题灵感、创作素材，还可以同步了解各话题热度情况及用户关注情况。\n" +
                "\n" +
                "视频库收录各视频平台数据，数据更新实时，每日更新数据达百万+，为各视频创客提供素材来源，并支持同步下载及批量下载工具，一键下载多个视频，解除繁琐操作，提供创作效率。\n" +
                "\n" +
                "2、数据监测工具：\n" +
                "\n" +
                "栏分作者关注、数据对比、稀缺内容3个具体功能。\n" +
                "\n" +
                "作者关注提供作者监测功能，用户输入需监测作者任意文章链接即可成功监测该作者，添加之后，即可实时监测该作者发文动态、文章各项具体数据、历史发布文章数据，还可同步导出数据，让各自媒体创客通过大咖数据走势做同行大咖数据分析，总结运营规律、优质选题、爆文创作技巧。\n" +
                "\n" +
                "数据对比提供自媒体账号信息对比、文章对比服务，用户成功添加账号、文章之后可进行账号及稿件对比。账号对比可以实现用户对不同账号进行账号基础信息、账号数据对比，对比出差异，以此明白不同账号用户、内容及数据差异，有效进行账号估值。\n" +
                "\n" +
                "稿件对比可以让用户细致了解不同文章类型具体数据差异，了解不同选题、标题、创作类型的文章的数据差异情况，以优化自身创作。\n" +
                "\n" +
                "稀缺内容数据来源于腾讯全平台热议话题，实时更新，帮助创作者快速掌握创作话题在全网的内容饱和度。创作者可以在稀缺内容工具栏查看各热点话题的热度指数、话题时效、稀缺程度、样本文章数据，全方位了解热点话题情况，做优质选题刷选，还可以通过稀缺话题榜找各领域稀缺性强的热点话题，以降低内容重复率，获取更多平台推荐量及用户点击量。\n" +
                "\n" +
                "3、排行榜功能：\n" +
                "\n" +
                "排行榜旨在为创作者提供不同平台不同领域作者榜单数据，创作者可以在此随意查询各平台、各领域大咖排名数据，及自身账号排名数据，分日榜、周榜、月榜，助力创作者了解不同领域作者运营情况，轻松找各行大咖。\n" +
                "\n" +
                "4、编辑器是易撰自创文章创作工具：\n" +
                "\n" +
                "可以实现全平台热点数据实时共享，稿件编辑、质量评测一站式服务。\n" +
                "\n" +
                "还有爆文标题助手、文章风险检测、文章原创性检测、内容转繁体、视频下载5项实用工具，可以帮助创作者解决创作过程中遇见的创作难题，有效检测出稿件中所存在的风险因素及稿件原创情况，以规避账号风险及平台消重问题，助力创作者实现更优、更快、更安全的创作。");
        long l1 = System.currentTimeMillis();

        BigInteger integer2 = simHash.simHash("易撰网简介与产品介绍\n" +
                "\n" +
                "易撰网平台由长沙营智信息技术有限公司于2017年开发。长沙营智信息技术有限公司，成立于2014年，深耕数据服务市场，5年来为多个行业提供数据采集、数据分析、程序开发等服务。易撰平台现有会员用户超过50万，公司技术团队超40人，运营团队30人，为易撰提供强有力的技术支撑与专业的服务支持。\n" +
                "\n" +
                "易撰网平台是一款专业的自媒体数据分析工具，同时也是一款自媒体教育培训课程平台；旨在为自媒体人提供数据搜索、数据分析服务及运营工具，以NLP算法深入研究整合各方数据资源，打破信息孤岛，用大数据为创作赋能，为原创保驾护航，使各自媒体人实现轻松创作，高效运营。\n" +
                "\n" +
                "产品介绍:\n" +
                "\n" +
                "易撰旗下产品有自媒体助手、BPM自媒体业务流程管控系统、抖音助手、易撰会社群。\n" +
                "\n" +
                "1. 自媒体助手工具：\n" +
                "\n" +
                "包括自媒体数据分析、稿件质量评定、运营辅助工具系统三大核心功能。\n" +
                "\n" +
                "自媒体数据分析功能栏分数据库、数据监测、排行榜、编辑器四个具体功能。\n" +
                "\n" +
                "1、 数据库：\n" +
                "\n" +
                "有自媒体文库、商品库、话题库、视频库。\n" +
                "\n" +
                "自媒体库收录众自媒体平台实时资讯数据，内容覆盖各行业领域，可支持各创作领域自媒体创客进行资讯搜索，并有精选爆文，为各创作领域自媒体创客提供优质选题与素材资源，还有实时热点监测，让各创作领域自媒体创客随时了解实时热点，把握创作方向。\n" +
                "\n" +
                "商品库抓取量大电商平台商品资源，可为自媒体淘宝客提供商品资源，并支持佣金、销量对比，让自媒体淘宝客更熟悉商品信息，做优质推广，还有主流自媒体平台优质商品图文，为各自媒体淘宝客提供创作指引。\n" +
                "\n" +
                "话题库收录各主流问答平台问答数据，各自媒体创客可以通过不同领域问答搜索获取选题灵感、创作素材，还可以同步了解各话题热度情况及用户关注情况。\n" +
                "\n" +
                "视频库收录各视频平台数据，数据更新实时，每日更新数据达百万+，为各视频创客提供素材来源，并支持同步下载及批量下载工具，一键下载多个视频，解除繁琐操作，提供创作效率。\n" +
                "\n" +
                "2、数据监测工具：\n" +
                "\n" +
                "栏分作者关注、数据对比、稀缺内容3个具体功能。\n" +
                "\n" +
                "作者关注提供作者监测功能，用户输入需监测作者任意文章链接即可成功监测该作者，添加之后，即可实时监测该作者发文动态、文章各项具体数据、历史发布文章数据，还可同步导出数据，让各自媒体创客通过大咖数据走势做同行大咖数据分析，总结运营规律、优质选题、爆文创作技巧。\n" +
                "\n" +
                "数据对比提供自媒体账号信息对比、文章对比服务，用户成功添加账号、文章之后可进行账号及稿件对比。账号对比可以实现用户对不同账号进行账号基础信息、账号数据对比，对比出差异，以此明白不同账号用户、内容及数据差异，有效进行账号估值。\n" +
                "\n" +
                "稿件对比可以让用户细致了解不同文章类型具体数据差异，了解不同选题、标题、创作类型的文章的数据差异情况，以优化自身创作。\n" +
                "\n" +
                "稀缺内容数据来源于腾讯全平台热议话题，实时更新，帮助创作者快速掌握创作话题在全网的内容饱和度。创作者可以在稀缺内容工具栏查看各热点话题的热度指数、话题时效、稀缺程度、样本文章数据，全方位了解热点话题情况，做优质选题刷选，还可以通过稀缺话题榜找各领域稀缺性强的热点话题，以降低内容重复率，获取更多平台推荐量及用户点击量。\n" +
                "\n" +
                "3、排行榜功能：\n" +
                "\n" +
                "排行榜旨在为创作者提供不同平台不同领域作者榜单数据，创作者可以在此随意查询各平台、各领域大咖排名数据，及自身账号排名数据，分日榜、周榜、月榜，助力创作者了解不同领域作者运营情况，轻松找各行大咖。\n" +
                "\n" +
                "4、编辑器是易撰自创文章创作工具：\n" +
                "\n" +
                "可以实现全平台热点数据实时共享，稿件编辑、质量评测一站式服务。\n" +
                "\n" +
                "还有爆文标题助手、文章风险检测、文章原创性检测、内容转繁体、视频下载5项实用工具，可以帮助创作者解决创作过程中遇见的创作难题，有效检测出稿件中所存在的风险因素及稿件原创情况，以规避账号风险及平台消重问题，助力创作者实现更优、更快、更安全的创作。");
        long l2 = System.currentTimeMillis();

        System.out.println("------"+integer1);
        System.out.println("------"+integer2);
        double dist = SimHash.compare(integer1, integer2);
        long l3 = System.currentTimeMillis();

        System.out.println(dist);
        System.out.println("总耗时->"+(l1-l));
        System.out.println("总耗时->"+(l2 -l1));
        System.out.println("总耗时->"+(l3-l2));
        System.out.println("总耗时->"+(System.currentTimeMillis()-l));
    }
}
