package com.qingyuan.course.service;

import com.qingyuan.course.pojo.Course;
import com.qingyuan.course.utils.UniversalResponseBody;

/**
 * 教师相关接口
 * @author 24605
 */
public interface TeacherService {

    /**
     * 添加课程
     * @param course
     * @return
     */
    UniversalResponseBody<Course> addCourse(Course course);

    /**
     * 更改课程状态
     * @param courseId
     * @param courseStatus
     * @return
     */
    UniversalResponseBody<Course> changeCourseStatus(Integer courseId, Integer courseStatus);
}
