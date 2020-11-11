package com.forezp.web;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Created by fangzhipeng on 2017/4/18.
 */
@RestController
public class MiyaController {

    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;

    @RequestMapping(value = "/miya")
    public String miya(){
        return name+":"+age;
    }

    public static void main(String[] args) throws InterruptedException {

        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        config.useSingleServer().setPassword("redis1234");

        final RedissonClient client = Redisson.create(config);
        RLock lock = client.getLock("lock1");

        try{
            lock.tryLock(1,1, TimeUnit.SECONDS);
            lock.lock(30, TimeUnit.SECONDS);
        }finally{
            lock.unlock();
        }
    }
}
