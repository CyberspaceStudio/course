package com.qingyuan.course.service.impl;

import com.qingyuan.course.enums.ResponseResultEnum;
import com.qingyuan.course.mapper.StuMessageMapper;
import com.qingyuan.course.pojo.Course;
import com.qingyuan.course.pojo.Student;
import com.qingyuan.course.service.StudentService;
import com.qingyuan.course.utils.UniversalResponseBody;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Resource
    private StuMessageMapper stuMessageMapper;
    //查询已选课程
    @Override
    public UniversalResponseBody<List<Course>> applyEdCourse(Integer userId) {
        try {
            List<Course> courseList = new ArrayList();
            List<Integer> courseIdList = this.stuMessageMapper.selectCourse(userId);
            for (Integer courseId : courseIdList) {
                courseList.add(this.stuMessageMapper.getCourse(courseId));
            }
            return new UniversalResponseBody<List<Course>>(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg(),courseList);
        } catch (Exception e) {
            return new UniversalResponseBody<>(ResponseResultEnum.FAILED.getCode(),ResponseResultEnum.FAILED.getMsg());
        }
    }
    //选择课程
    @Override
    public UniversalResponseBody<?> applyCourse(Integer courseId, Integer userId) {
        try {
            List<Integer> courseIdList = this.stuMessageMapper.selectCourse(userId);
            if(courseIdList.contains(courseId)){
                return new UniversalResponseBody<String>(ResponseResultEnum.FAILED.getCode(),ResponseResultEnum.FAILED.getMsg(),"课程已选择");
            }
            this.stuMessageMapper.insertApplication(courseId, userId);
            this.stuMessageMapper.updateCourseApplyCount(courseId);
            Course course = this.stuMessageMapper.getCourse(courseId);
            return new UniversalResponseBody<>(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg(),course);
        } catch (Exception e) {
            return new UniversalResponseBody<>(ResponseResultEnum.FAILED.getCode(),ResponseResultEnum.FAILED.getMsg());
        }
    }
    //更改学生信息
    @Override
    public UniversalResponseBody<Student> changeStudentInfo(Integer userId, String userGrade, String userSchool) {
        try {
            this.stuMessageMapper.updateStudentInfo(userId, userGrade, userSchool);
            Student student = this.stuMessageMapper.getStudent(userId);
            return new UniversalResponseBody<>(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg(),student);
        } catch (Exception e) {
            return new UniversalResponseBody<>(ResponseResultEnum.FAILED.getCode(),ResponseResultEnum.FAILED.getMsg());
        }
    }
}
