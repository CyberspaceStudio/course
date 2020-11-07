package com.qingyuan.course.exception;

/**
 * @program: course
 * @author: GuoShuSong
 * @create: 2020-10-23 10:38
 **/
public class TokenException extends ResponseException{

    public TokenException(String message, Integer code, String msg) {
        super(message, code, msg);
    }
}
