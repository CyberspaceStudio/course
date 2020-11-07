package com.qingyuan.course.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.qingyuan.course.annoation.PassToken;
import com.qingyuan.course.annoation.TeacherLogin;
import com.qingyuan.course.annoation.UserLogin;
import com.qingyuan.course.enums.ResponseResultEnum;
import com.qingyuan.course.enums.UserAuthorityEnum;
import com.qingyuan.course.exception.TokenException;
import com.qingyuan.course.mapper.UserMessageMapper;
import com.qingyuan.course.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author 郭树耸
 * @version 1.0
 * @date 2020/2/2 20:01
 */
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {


    @Resource
    private UserMessageMapper userMessageMapper;


    public AuthenticationInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        // 从 http 请求头中取出 token
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod=(HandlerMethod)object;
        Method method=handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLogin.class)) {
            UserLogin userLogin = method.getAnnotation(UserLogin.class);
            if (userLogin.required()) {
                // 执行认证
                if (token == null) {
                    log.error("token为空,访问路径为"+request.getRequestURL());
                    throw new TokenException("token为空", ResponseResultEnum.USER_NO_TOKEN.getCode(), ResponseResultEnum.USER_NO_TOKEN.getMsg());
                }
                // 获取 token 中的userId
                Integer userId = null;
                try {
                    userId = Integer.valueOf(JWT.decode(token).getAudience().get(0));
                } catch (JWTDecodeException j) {
                    log.error("token解析出错,访问路径为"+request.getRequestURL());
                }
                User user = userMessageMapper.getUserByUserId(userId);
                if (user == null) {
                    //用户不存在
                    log.error("用户不存在,访问路径为"+request.getRequestURL());
                    throw new TokenException("token无效", ResponseResultEnum.USER_TOKEN_ILLEGAL.getCode(), ResponseResultEnum.USER_TOKEN_ILLEGAL.getMsg());
                } else {
                    return true;
                }
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(TeacherLogin.class)) {
            TeacherLogin teacherLogin = method.getAnnotation(TeacherLogin.class);
            if (teacherLogin.required()) {
                // 执行认证
                if (token == null) {
                    log.error("token为空,访问路径为"+request.getRequestURL());
                    throw new TokenException("token为空", ResponseResultEnum.USER_NO_TOKEN.getCode(), ResponseResultEnum.USER_NO_TOKEN.getMsg());
                }
                // 获取 token 中的userId
                Integer userId = null;
                try {
                    userId = Integer.valueOf(JWT.decode(token).getAudience().get(0));
                } catch (JWTDecodeException j) {
                    log.error("token解析出错,访问路径为"+request.getRequestURL());
                }
                User user = userMessageMapper.getUserByUserId(userId);
                if (user == null) {
                    //用户不存在
                    log.error("用户不存在,访问路径为"+request.getRequestURL());
                    throw new TokenException("token无效", ResponseResultEnum.USER_TOKEN_ILLEGAL.getCode(), ResponseResultEnum.USER_TOKEN_ILLEGAL.getMsg());
                }else if(!UserAuthorityEnum.TEACHER.getUserAuthority().equals(user.getUserAuthority())) {
                    log.error("用户权限不足,访问路径为"+request.getRequestURL());
                    throw new TokenException("权限不足", ResponseResultEnum.USER_NO_PERMISSION.getCode(), ResponseResultEnum.USER_NO_PERMISSION.getMsg());
                }
                else {
                    return true;
                }
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
