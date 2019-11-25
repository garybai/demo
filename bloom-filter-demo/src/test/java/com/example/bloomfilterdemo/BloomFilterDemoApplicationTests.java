package com.example.bloomfilterdemo;

import com.example.bloomfilterdemo.config.BloomFilterHelper;
import com.example.bloomfilterdemo.service.RedisService;
import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BloomFilterDemoApplicationTests {

    @Autowired
    private RedisService redisService;

    private int size = 100;

    private double fpp = 0.01;

    private BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size, fpp);

    private BloomFilterHelper<String> bloomFilterHelper = new BloomFilterHelper<>((Funnel<String>) (from, into) -> into.putString(from, Charsets.UTF_8)
            .putString(from, Charsets.UTF_8), size, fpp);

    @Test
    public void testGuava() {
        //插入数据
        for (int i = 0; i < size; i++) {
            bloomFilter.put(i);
        }
        int count = 0;
        for (int i = size + 1; i < size * 2; i++) {
            if (bloomFilter.mightContain(i)) {
                count++;
                System.out.println(i + "误判了");
            }
        }
        System.out.println("总共的误判数:" + count);
    }


    @Test
    public void testRedis() {
    	int count = 0;
        for (int i = 0; i < size; i++) {
			long l = System.currentTimeMillis();
			redisService.addByBloomFilter(bloomFilterHelper, "bloomKey", String.valueOf(i));
			long l1 = System.currentTimeMillis();
			System.out.println(l1 - l);
		}
        for (int i = size + 1; i < size * 2; i++) {
            boolean bloomKey = redisService.includeByBloomFilter(bloomFilterHelper, "bloomKey", String.valueOf(i));
            if (bloomKey) {
                count++;
				System.out.println(i + "误判了");
            }
        }
        System.out.println("总共的误判数:" + count);
    }

    @Test
    public void test(){
		int bits = bloomFilterHelper.optimalNumOfBits(size, fpp);
		System.out.println(bits);
		int nums = bloomFilterHelper.optimalNumOfHashFunctions(size, bits);
		System.out.println(nums);
	}

}
