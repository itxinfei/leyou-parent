package com.leyou.auth.service;

import com.leyou.auth.client.UserClient;
import com.leyou.auth.config.JwtProperties;
import com.leyou.auth.pojo.UserInfo;
import com.leyou.auth.utils.JwtUtils;
import com.leyou.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class AuthService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private JwtProperties prop;

    /**
     * @param username
     * @param password
     * @return
     */
    public String accredit(String username, String password) {
        //调用用户中心的查询接口，校验用户信息
        System.out.println("调用用户中心的查询接口，校验用户信息");
        User user = this.userClient.queryUser(username, password);
       /* if (user == null) {
            return null;
        }*/
        System.out.println("查询用户：" + user.toString());
        //创建userInfo对象
        UserInfo userInfo = new UserInfo();
        userInfo.setId(user.getId());
        userInfo.setUsername(user.getUsername());
        try {
            return JwtUtils.generateToken(userInfo, this.prop.getPrivateKey(), this.prop.getExpire());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(userInfo.toString());
        return null;
    }
}
