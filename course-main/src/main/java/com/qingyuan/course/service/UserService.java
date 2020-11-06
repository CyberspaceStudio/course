package com.qingyuan.course.service;

import com.qingyuan.course.pojo.PO.TokenPO;
import com.qingyuan.course.pojo.User;
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

    /**
     * 更新用户基本信息
     * @param user
     * @return
     */
    public UniversalResponseBody<User> updateUserMessage(User user);

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    public UniversalResponseBody<User> getUserMessage(Integer userId);
}
