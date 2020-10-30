package com.qingyuan.course.service.impl;

import com.qingyuan.course.enums.ResponseResultEnum;
import com.qingyuan.course.mapper.StuMessageMapper;
import com.qingyuan.course.pojo.Course;
import com.qingyuan.course.pojo.Student;
import com.qingyuan.course.service.StudentService;
import com.qingyuan.course.utils.UniversalResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public List<Course> applyEdCourse(Integer userId) {
        List<Course> courseList = new ArrayList();
        List<Integer> courseIdList = this.stuMessageMapper.selectCourse(userId);
        for (Integer courseId : courseIdList) {
            courseList.add(this.stuMessageMapper.getCourse(courseId).get(0));
        }
        if(true)
            return null;
        //test
        return courseList;


    }

    @Override
    public UniversalResponseBody<Course> applyCourse(Integer courseId, Integer userId) {
        this.stuMessageMapper.insertApplication(courseId, userId);
        this.stuMessageMapper.updateCourseApplyCount(courseId);
        Course course = this.stuMessageMapper.getCourse(courseId).get(0);
        return new UniversalResponseBody<>(ResponseResultEnum.SUCCESS.getCode(),ResponseResultEnum.SUCCESS.getMsg(),course);
    }

    @Override
    public Student changeStudentInfo(Integer userId, String userGrade, String userSchool) {
        this.stuMessageMapper.updateStudentInfo(userId, userGrade, userSchool);
        Student student = this.stuMessageMapper.getStudent(userId).get(0);
        return student;
    }
}
