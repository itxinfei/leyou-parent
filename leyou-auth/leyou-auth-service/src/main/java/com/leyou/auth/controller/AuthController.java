package com.leyou.auth.controller;

import com.leyou.auth.config.JwtProperties;
import com.leyou.auth.pojo.UserInfo;
import com.leyou.auth.service.AuthService;
import com.leyou.auth.utils.JwtUtils;
import com.leyou.common.utils.CookieUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@EnableConfigurationProperties(JwtProperties.class)
public class AuthController {
    @Autowired
    private JwtProperties prop;
    
    @Autowired
    private AuthService authService;

    /**
     * 登陆授权
     */
    @PostMapping("accredit")
    public ResponseEntity<Void> accredit(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpServletRequest request,
            HttpServletResponse response) {
        //登陆校验
        String token = this.authService.accredit(username, password);
        if (StringUtils.isBlank(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        //将token写入cookie，并指定httpOnly为true，防止通过Js获取和修改
        CookieUtils.setCookie(request, response, this.prop.getCookieName(), token,
                this.prop.getExpire());
        return ResponseEntity.noContent().build();
    }

    @GetMapping("verify")
    public ResponseEntity<UserInfo> verifyUser(@CookieValue("LY_TOKEN") String token,
                                               HttpServletRequest request, HttpServletResponse response) {
        try {
            //从token中解析token信息
            UserInfo userInfo = JwtUtils.getInfoFromToken(token, this.prop.getPublicKey());
            //解析成功要重新刷新token
            token = JwtUtils.generateToken(userInfo, this.prop.getPrivateKey(), this.prop.getExpire());
            //将重新生成的token，写入cookie中
            CookieUtils.setCookie(request, response, this.prop.getCookieName(), token, this.prop.getExpire() * 60);

            //解析成功返回用户信息
            return ResponseEntity.ok(userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //出现异常则响应500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
