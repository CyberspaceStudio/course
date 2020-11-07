package com.qingyuan.course.enums;

/**
 * 用户权限枚举类
 * @author 24605
 */
public enum UserAuthorityEnum {
    ADMIN(0,"管理员"),
    TEACHER(1,"教师"),
    STUDENT(2,"学生");

    /**
     * 用户权限id
     */
    private Integer UserAuthority;


    private String UserAuthorityName;


    UserAuthorityEnum(Integer userAuthority, String userAuthorityName) {
        UserAuthority = userAuthority;
        UserAuthorityName = userAuthorityName;
    }

    public Integer getUserAuthority() {
        return UserAuthority;
    }

    public void setUserAuthority(Integer userAuthority) {
        UserAuthority = userAuthority;
    }

    public String getUserAuthorityName() {
        return UserAuthorityName;
    }

    public void setUserAuthorityName(String userAuthorityName) {
        UserAuthorityName = userAuthorityName;
    }
}
