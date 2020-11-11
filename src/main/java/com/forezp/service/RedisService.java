package com.forezp.service;

public interface RedisService {
    public String getValue(String key);

    public void setValue(String key,String value);

}
