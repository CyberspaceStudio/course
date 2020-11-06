package com.qingyuan.course.controller;

import com.qingyuan.course.pojo.PO.TokenPO;
import com.qingyuan.course.pojo.User;
import com.qingyuan.course.service.UserService;
import com.qingyuan.course.utils.UniversalResponseBody;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 用户相关接口
 * @program: course
 * @author: GuoShuSong
 * @create: 2020-10-21 19:25
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    @Qualifier("userServiceImpl")
    private UserService userService;

    /**
     * 登录
     * @param code
     * @return
     */
    @PostMapping("/login")
    public UniversalResponseBody<TokenPO> userLogin(String code){
        return userService.userLogin(code);
    }

    /**
     * 更新用户基本信息
     * @param user
     * @return
     */
    @PostMapping("/message")
    public UniversalResponseBody<User> updateUserMessage(User user){
        return userService.updateUserMessage(user);
    }

    /**
     * 获取用户信息
     * @param userId
     * @return
     */
    @GetMapping("/message")
    public UniversalResponseBody<User> getUserMessage(Integer userId){
        return userService.getUserMessage(userId);
    }

    /**
     * 上传用户头像
     * @apiNote 注意这里只是上传用户头像并得到路径，并不会更新数据库中的用户头像路径，所以应当调用更新用户基本信息接口进行更新
     * @param multipartFile
     * @param userId
     * @return 用户头像路径
     */
    @PostMapping("/avatar")
    public UniversalResponseBody<String> updateUserAvatar(MultipartFile multipartFile,Integer userId){
        return null;
    }
}
