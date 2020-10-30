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
    //选课
    void insertApplication(Integer courseId, Integer userId);
    //更新选课人数
    void updateCourseApplyCount(Integer courseId);
    //更新学生信息
    void updateStudentInfo(Integer userId, String userGrade, String userSchool);
    //查找已选课程ID
    List<Integer> selectCourse(Integer userId);
    //获得课程信息
    Course getCourse(Integer courseId);
    //获得学生信息
    Student getStudent(Integer userId);
}
