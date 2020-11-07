package com.qingyuan.course.exception;

import com.qingyuan.course.enums.ResponseResultEnum;
import com.qingyuan.course.utils.UniversalResponseBody;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *
 * @program: course
 * @author: GuoShuSong
 * @create: 2020-10-23 10:28
 **/
@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(value = TokenException.class)
    public UniversalResponseBody tokenException(TokenException e){
        return new UniversalResponseBody(e.getCode(),e.getMsg());
    }

}
