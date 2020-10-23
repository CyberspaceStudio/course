package com.qingyuan.course.service.impl;

import com.qingyuan.course.enums.ResponseResultEnum;
import com.qingyuan.course.mapper.UserMessageMapper;
import com.qingyuan.course.pojo.PO.TokenPO;
import com.qingyuan.course.pojo.PO.WxResponseInfo;
import com.qingyuan.course.pojo.User;
import com.qingyuan.course.service.UserService;
import com.qingyuan.course.utils.TokenUtil;
import com.qingyuan.course.utils.UniversalResponseBody;
import com.qingyuan.course.utils.WeChatUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户登录接口实现类
 * @program: course
 * @author: GuoShuSong
 * @create: 2020-10-22 10:39
 **/
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private WeChatUtil weChatUtil;
    @Resource
    private UserMessageMapper userMessageMapper;
    @Resource
    private TokenUtil tokenutil;

    @Override
    public UniversalResponseBody<TokenPO> userLogin(String code) {
        WxResponseInfo wxResponseInfo = weChatUtil.getWeChatResponseBody(code);
        //Code无效
        if (wxResponseInfo.getErrcode() != null) {
            //将微信返回错误代码及结果记录到日志中
            log.error("微信登录出错" + code + wxResponseInfo.getErrcode() + "\t" + wxResponseInfo.getErrmsg());
            return new UniversalResponseBody(ResponseResultEnum.CODE_IS_INVALID.getCode(), ResponseResultEnum.CODE_IS_INVALID.getMsg());
        }
        String token = null;
        TokenPO tokenPO = null;
        User user = userMessageMapper.getUserByopenid(wxResponseInfo.getOpenid());
        //数据库中已经存在该用户
        if (user == null) {
            //插入用户
            user = new User(wxResponseInfo.getOpenid());
            userMessageMapper.insertUser(user);
        }
        token = tokenutil.TokenByUserId(user.getUserId());
        tokenPO = new TokenPO(token,user);
        return new UniversalResponseBody<TokenPO>(ResponseResultEnum.USER_LOGIN_SUCCESS.getCode(), ResponseResultEnum.USER_LOGIN_SUCCESS.getMsg(), tokenPO);
    }
}
