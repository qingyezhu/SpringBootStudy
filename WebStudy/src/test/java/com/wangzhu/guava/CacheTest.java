package com.wangzhu.guava;

import com.google.common.cache.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangzhu on 2024/12/13 12:09.
 **/
public class CacheTest {

    private static final Logger logger = LoggerFactory.getLogger(CacheTest.class);

    public static void main(String[] args) {

        LoadingCache<Integer, Integer> cache = CacheBuilder.newBuilder()
                .removalListener(new RemovalListener<Integer, Integer>() {

                    @Override
                    public void onRemoval(RemovalNotification<Integer, Integer> notification) {
                        logger.info("onRemoval cause:{}, evict:{},  key:{}, value:{}",
                                notification.getCause(), notification.wasEvicted(), notification.getKey(), notification.getValue());
                    }
                })
                .maximumSize(8)
                .expireAfterWrite(5, TimeUnit.SECONDS)
                .refreshAfterWrite(3, TimeUnit.SECONDS)
                .build(new CacheLoader<Integer, Integer>() {
                    @Override
                    public Integer load(Integer key) throws Exception {
                        int n = new Random().nextInt(1000);
                        logger.info("load key:{}, n:{}", key, n);
                        return n;
                    }
                });

        int[] arr = {1, 3, 5, 7, 9, 2, 4, 8};
        for (int i = 0; i < 30; i++) {
            try {
                int key = arr[i % arr.length];
                Integer value = cache.get(key);
                logger.info("get key:{}, value:{}", key, value);
                Thread.sleep(350 * key);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
