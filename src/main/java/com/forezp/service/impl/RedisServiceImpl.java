package com.forezp.service.impl;

import com.forezp.dao.RedisDao;
import com.forezp.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisDao redisDao;

    @Override
    public String getValue(String key) {
        return redisDao.getValue(key);
    }

    @Override
    public void setValue(String key, String value) {
        redisDao.setValue(key, value);
    }
}
