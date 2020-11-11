package com.forezp.dao;

public interface RedisDao {
    public String getValue(String key);

    public void setValue(String key,String value);
}
