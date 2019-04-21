package com.mofei.wxlogin.controller;


import com.mofei.wxlogin.common.HttpClientUtil;
import com.mofei.wxlogin.common.IMoocJSONResult;
import com.mofei.wxlogin.common.JsonUtils;
import com.mofei.wxlogin.common.RedisOperator;
import com.mofei.wxlogin.model.WXSessionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
public class WXLoginController {

    @Autowired
    RedisOperator redisOperator;

    @PostMapping("/wxlogin")
    public IMoocJSONResult wxlogin(String code){
        //拆分两个
        String url = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String ,String> param = new HashMap<>();
        param.put("appid","wxdd53151a4ddd1e18");
        param.put("secret","d2bb2c3ef550d32e543c69e40a417bda");
        param.put("js_code",code);
        param.put("grant_type","authorization_code");

        //发送微信的登录请求获取id
        String wxResult = HttpClientUtil.doGet(url, param);
        System.out.println(wxResult);

        //json 转 对象
        WXSessionModel model = JsonUtils.jsonToPojo(wxResult, WXSessionModel.class);

        //存储到redis
        redisOperator.set("user-redis-session: "+model.getOpenid(),model.getSession_key(),10000*60*3);

        return IMoocJSONResult.ok();
    }

}
