package com.example.springbucks.controller;

import com.example.springbucks.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gary
 * @className TestController
 * @description TODO
 * @date 2019-04-14 23:22
 **/
@RestController
@Slf4j
public class TestController {

    @Autowired
    private CoffeeService coffeeService;

//    @Autowired
//    private MongoTemplate mongoTemplate;

//    @Autowired
//    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/test")
    public void test() throws Exception {
//        Coffee coffee = coffeeService.findById(1L);
//        mongoTemplate.save(coffee);
//        List<Coffee> list = mongoTemplate.find(
//                query(where("name").is("espresso")), Coffee.class
//        );
//
//        list.forEach(c -> log.info("Coffee: {}", c));
//
//        Thread.sleep(1000);
//        UpdateResult result = mongoTemplate.updateFirst(query(where("name").is("espresso")),
//                new Update().set("price", Money.ofMajor(CurrencyUnit.of("CNY"), 30))
//                        .currentDate("updateTime"),
//                Coffee.class);
//        log.info("Update Result: {}", result.getModifiedCount());
//        Coffee updateOne = mongoTemplate.findById(coffee.getId(), Coffee.class);
//        log.info("Update Result: {}", updateOne);

        //mongoTemplate.remove(updateOne);

    }

    @RequestMapping("/testRedis")
    public void testRedis() {
//        try (Jedis jedis = jedisPool.getResource()) {
//            coffeeService.findAllByPage(1, 3).forEach(coffee -> {
//                jedis.hset("springbucks-menu",
//                        coffee.getName(),
//                        Long.toString(coffee.getPrice().getAmountMinorLong()));
//            });
//            Map<String, String> menu = jedis.hgetAll("springbucks-menu");
//            log.info("menu: {}", menu);
//
//            String price = jedis.hget("springbucks-menu", "espresso");
//            log.info("espresso - {}", Money.ofMinor(CurrencyUnit.of("CNY"), Long.parseLong(price)));
//        }
//        try {
//            coffeeService.findAllByPage(1, 5).forEach(coffee -> {
////                redisUtil.set("springbucks-" + coffee.getName(), coffee,1);
//                String key = "springbucks-" + coffee.getName();
//                redisTemplate.opsForValue().set(key, coffee);
//            });
////            log.info("espresso - {}", redisUtil.get("springbucks-espresso", 1));
//            Coffee coffee = (Coffee) redisTemplate.opsForValue().get("springbucks-espresso");
//            if (null != coffee.getName()) {
//                log.info("espresso: {}", coffee.getName() + "-" + coffee.getPrice());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) {

//        String id = UUIDUtil.getUUID();
//        System.out.println(id);
//        int hashCodeVa = "23c4bcec-c781-40ca-8d41-a1c498052c36".hashCode();
//        int hashCodeVb = "3b0b731b-bad2-4bfd-b305-444fc482fa21".hashCode();
//        System.out.println(hashCodeVa);
//        System.out.println(hashCodeVb);
//        String s1 = System.currentTimeMillis() + "";
//        String s2 = System.nanoTime() + "";
//        System.out.println(s1);
//        System.out.println(s1.substring(1));
//        System.out.println(s2);
//        System.out.println(s2.substring(7,10));

//        System.out.println("：哈哈：：".replaceAll("[\uFE30-\uFFA0]+$", ""));

        System.out.println("2000".compareTo("301"));

    }
}
