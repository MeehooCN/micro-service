package com.meehoo.security.web.service;

import com.meehoo.security.web.ro.UserRO;
import com.meehoo.security.web.vo.AuthVO;

public interface UserService {
    AuthVO login(UserRO ro) throws Exception;
}
