package com.example.elasticsearchdemo;

import com.example.elasticsearchdemo.service.ArticleService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticsearchDemoApplicationTests {


    @Autowired
    private ArticleService articleRepository;

//    @Test
//    public void insert() {
//        ArticlePO articlePO = new ArticlePO();
//        articlePO.setId(2L)
//                .setCategory("美食")
//                .setContent("黑椒牛排食材：牛排1块、黑胡椒适量、橄榄油（玉米油、花生油）适量、洋葱少许、西红柿少许、红酒1小杯、盐少许、配菜（西兰花、胡萝卜、西红柿等）制作步骤：1、牛肉（各部位的肉都可以，菜譜最後有科普課）快速洗净，沥干水分，用厨房纸把血水吸干净。如果市场买的牛扒很厚，可以用刀背捶捶，让牛肉更松软，口感会更好。冰冻牛肉要提前半天时间从冷冻室拿出放到冷藏室进行解冻，做牛排前半个小时从冰箱取出，使其升温到室温。极速解冻会导致牛肉中的水分流失，缓慢解冻才能保证牛肉鲜嫩多汁。2、将黑胡椒磨碎，实在没有可用黑胡椒粉代替。在牛排两面撒上黑胡椒，少许盐涂抹均匀，然后淋上橄榄油抹匀（如果没有橄榄油，用玉米油、花生油代替即可）。3、将不粘锅烧热，把牛排放进锅中，用夹子压一压，确保牛肉均匀受热。每面煎1-2分钟（肉厚的可以煎久一点，但再厚的肉也不能超过 4分钟，否则牛肉太老咬不动，这样五成熟，外焦，里面还是粉红色，没有“血水”的牛排就煎好了。4、把煎好的牛肉静至盘中五分钟，部分会被牛肉吸收，部分肉汁会流出，将流出的肉汁保留好，备用。5、调酱汁。利用煎牛排的余油，放入洋葱末煎香，加入番茄末，煮烂。之后淋入红酒，加黑胡椒碎，少量盐。把静至牛排流出的肉汁混入，酱汁就做好了。6、可以烫些西兰花、胡萝卜，切几片西红柿，或者炸些马铃薯条，进行摆盘。（以上图片均来自网络）")
//                .setTitle("在家也能吃上米其林级的黑椒牛排啦！赶快学起来吧！")
//                .setDigest("在家也能吃上米其林级的黑椒牛排啦！赶快学起来吧！");
//        articleRepository.save(articlePO);
//    }

}
