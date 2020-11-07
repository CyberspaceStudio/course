package com.qingyuan.course.pojo.PO;

import com.qingyuan.course.pojo.User;
import lombok.Data;

/**
 * @program: course
 * @author: GuoShuSong
 * @create: 2020-10-21 19:28
 **/
@Data
public class TokenPO {


    /**
     * token
     */
    private String token;

    /**
     * 用户id
     */
    private User user;

    public TokenPO(String token, User user) {
        this.token = token;
        this.user = user;
    }
}
