package com.qingyuan.course.config;

import com.qingyuan.course.enums.ResponseResultEnum;
import com.qingyuan.course.utils.UniversalResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * 全局异常处理器
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 用来处理bean validation异常
     * @param ex
     * @return
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public UniversalResponseBody<String> resolveConstraintViolationException(ConstraintViolationException ex){
        Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
        if(!CollectionUtils.isEmpty(constraintViolations)){
            StringBuilder msgBuilder = new StringBuilder();
            for(ConstraintViolation constraintViolation :constraintViolations){
                msgBuilder.append(constraintViolation.getMessage()).append(",");
            }
            String errorMessage = msgBuilder.toString();
            if(errorMessage.length()>1){
                errorMessage = errorMessage.substring(0,errorMessage.length()-1);
            }
            return new UniversalResponseBody<String>(ResponseResultEnum.PARAM_IS_BLANK.getCode(),ResponseResultEnum.PARAM_IS_BLANK.getMsg(),errorMessage);
        }
        return new UniversalResponseBody<String>(ResponseResultEnum.PARAM_IS_BLANK.getCode(),ResponseResultEnum.PARAM_IS_BLANK.getMsg(),ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public UniversalResponseBody<String> resolveMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        List<ObjectError>  objectErrors = ex.getBindingResult().getAllErrors();
        if(!CollectionUtils.isEmpty(objectErrors)) {
            StringBuilder msgBuilder = new StringBuilder();
            for (ObjectError objectError : objectErrors) {
                msgBuilder.append(objectError.getCode()).append(":");
                msgBuilder.append(objectError.getDefaultMessage()).append(",");
            }
            String errorMessage = msgBuilder.toString();
            if (errorMessage.length() > 1) {
                errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
            }
            return new UniversalResponseBody<String>(ResponseResultEnum.PARAM_IS_BLANK.getCode(),ResponseResultEnum.PARAM_IS_BLANK.getMsg(),errorMessage);
        }
        return new UniversalResponseBody<String>(ResponseResultEnum.PARAM_IS_BLANK.getCode(),ResponseResultEnum.PARAM_IS_BLANK.getMsg(),ex.getMessage());
    }
}