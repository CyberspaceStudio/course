package com.qingyuan.course.service;

import com.qingyuan.course.pojo.PO.TokenPO;
import com.qingyuan.course.utils.UniversalResponseBody;

/**
 * 用户相关接口
 * @author GuoShuSong
 */
public interface UserService {

    /**
     * 用户登录
     * @param code
     * @return
     */
    public UniversalResponseBody<TokenPO> userLogin(String code);
}
