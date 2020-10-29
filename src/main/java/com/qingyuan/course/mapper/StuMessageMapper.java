package com.qingyuan.course.mapper;

import com.qingyuan.course.pojo.Course;
import com.qingyuan.course.pojo.Student;

import java.util.List;

/**
 * 对应数据库:user_message
 * 对应实体类:Student
 *
 * @author GuoShuSong
 */
public interface StuMessageMapper {
    void insertApplication(Integer courseId, Integer userId);

    void updateCourseApplyCount(Integer courseId);

    void updateStudentInfo(Integer userId, String userGrade, String userSchool);

    List<Integer> selectCourse(Integer userId);

    List<Course> getCourse(Integer courseId);

    List<Student> getStudent(Integer userId);
}
