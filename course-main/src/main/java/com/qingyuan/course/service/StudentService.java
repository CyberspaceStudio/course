package com.qingyuan.course.service;

import com.qingyuan.course.pojo.Course;
import com.qingyuan.course.utils.UniversalResponseBody;

import java.util.List;

/**
 * 学生相关接口
 * @author 24605
 */
public interface StudentService {


    /**
     * 查询该学生报名的所有课程
     * @param userId
     * @return
     */
    UniversalResponseBody<List<Course>> applyEdCourse(Integer userId);


    /**
     * 报名课程
     * @param courseId
     * @param userId
     * @return
     */
    UniversalResponseBody applyCourse(Integer courseId,Integer userId);
}
