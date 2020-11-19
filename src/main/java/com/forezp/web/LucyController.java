package com.forezp.web;

import com.forezp.bean.ConfigBean;
import com.forezp.bean.User;
import com.forezp.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * Created by fangzhipeng on 2017/4/18.
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class,User.class})
public class LucyController {
    @Autowired
    ConfigBean configBean;

    @Autowired
    RedisService redisService;

    @RequestMapping(value = "/lucy")
    public String miya(){
        return configBean.getGreeting()+" >>>>"+configBean.getName()+" >>>>"+ configBean.getUuid()+" >>>>"+configBean.getMax();
    }

    @Autowired
    User user;
    @RequestMapping(value = "/user")
    public String user(){
        return user.getName()+"--:"+user.getAge() + ":BMS2的现有业务：主要就是这两大块: 订单流转（销售单/物流单/收款单）以及 商品出入库";
    }

    @RequestMapping(value = "/redis")
    public String getRedisContent(){
        redisService.setValue("0724",user.getName()+":"+user.getAge());
        return redisService.getValue("0724");
    }

}
