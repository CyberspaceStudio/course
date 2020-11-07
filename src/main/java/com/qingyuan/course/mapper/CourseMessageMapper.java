package com.qingyuan.course.mapper;

import com.qingyuan.course.pojo.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 对应数据库:course_message
 * 对应实体类:Student
 * @author
 */
@Mapper
public interface CourseMessageMapper {

    /**
     * 添加课程
     * @param course
     * @return
     */
    int addCourse(Course course);

    /**
     * 更改课程状态
     * @param courseId
     * @param courseStatus
     * @return
     */
    int changeCourseStatus(@Param("courseId") Integer courseId, @Param("courseStatus") Integer courseStatus);


    /**
     * 通过Id查找课程
     * @param courseId
     * @return
     */
    Course getCourseById(int courseId);
}
