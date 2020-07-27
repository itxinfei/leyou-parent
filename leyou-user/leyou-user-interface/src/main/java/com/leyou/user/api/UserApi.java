package com.leyou.user.api;

import com.leyou.user.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 登录接口
 */
public interface UserApi {

    /**
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/query")
    User queryUser(
            @RequestParam("username") String username,
            @RequestParam("password") String password
    );

}
