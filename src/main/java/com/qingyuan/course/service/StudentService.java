package com.qingyuan.course.service;

import com.qingyuan.course.pojo.Course;
import com.qingyuan.course.pojo.Student;
import com.qingyuan.course.utils.UniversalResponseBody;

import java.util.List;

/**
 * 学生相关接口
 *
 * @author 24605
 */
public interface StudentService {


    /**
     * 查询该学生报名的所有课程
     *
     * @param userId
     * @return 所报课程信息
     */
    UniversalResponseBody<List<Course>> applyEdCourse(Integer userId);

    /**
     * 报名课程
     *
     * @param courseId
     * @param userId
     * @return 已报课程信息
     */

    UniversalResponseBody<Course> applyCourse(Integer courseId, Integer userId);


    /**
     * 修改信息并返回
     * @param userId
     * @param userGrade
     * @param userSchool
     * @return 该学生信息
     */
    UniversalResponseBody<Student> changeStudentInfo(Integer userId, String userGrade, String userSchool);
}
