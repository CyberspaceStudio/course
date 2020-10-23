package com.qingyuan.course.pojo;

import lombok.Data;

/**
 * @program: course
 * @author: GuoShuSong
 * @create: 2020-10-21 19:07
 **/
@Data
public class User {

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * openid
     */
    private String openid;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户性别
     */
    private String userSex;

    /**
     * 用户电话
     */
    private String userTel;

    /**
     * 用户权限
     */
    private Integer userAuthority;

    /**
     * 用户头像
     */
    private String userImageUrl;

    public User(String openid) {
        this.openid = openid;
    }
}
