package com.meehoo.security.web.service.impl;

import com.meehoo.security.web.ro.UserRO;
import com.meehoo.security.web.service.UserService;
import com.meehoo.security.web.utils.JwtUtil;
import com.meehoo.security.web.utils.MD5Util;
import com.meehoo.security.web.vo.AuthVO;
import com.meehoo.security.web.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public AuthVO login(UserRO ro) throws Exception {
        // 校验用户密码
        String encryptPwd = MD5Util.getUserEncryptPassword(ro.getLoginName(), ro.getUserPwd());
        if (!"".equals(encryptPwd)) {
            throw new RuntimeException("登录失败，密码输入错误");
        }
        // 登录成功，返回用户信息
        AuthVO vo = new AuthVO();
        UserVO userVo = new UserVO();
        userVo.setUuid(UUID.randomUUID().toString().replaceAll("-", ""));
        userVo.setLoginName(ro.getLoginName());
        vo.setToken(JwtUtil.buildJwt(getLoginExpre(), userVo));
        vo.setUser(userVo);
        return vo;
    }

    private Date getLoginExpre() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 7);
        return calendar.getTime();
    }
}