package com.qingyuan.course.service.impl;

import com.qingyuan.course.enums.ResponseResultEnum;
import com.qingyuan.course.mapper.CourseMessageMapper;
import com.qingyuan.course.pojo.Course;
import com.qingyuan.course.service.TeacherService;
import com.qingyuan.course.utils.UniversalResponseBody;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: course
 * @author: GuoShuSong
 * @create: 2020-10-23 14:51
 **/
@Service
public class TeacherServiceImpl  implements TeacherService {

    @Resource
    private CourseMessageMapper courseMessageMapper;

    @Override
    public UniversalResponseBody<Course> addCourse(Course course) {
        Course c = courseMessageMapper.getCourseById(course.getCourseId());
        if(c != null) {
            return new UniversalResponseBody<Course>(ResponseResultEnum.COURSE_IS_EXISTED.getCode(), ResponseResultEnum.COURSE_IS_EXISTED.getMsg());
        }
        int id = courseMessageMapper.addCourse(course);
        if(id > 0) {
            return new UniversalResponseBody<Course>(ResponseResultEnum.SUCCESS.getCode(), ResponseResultEnum.SUCCESS.getMsg(), course);
        }
        return new UniversalResponseBody<Course>(ResponseResultEnum.COURSE_ADD_FAILED.getCode(), ResponseResultEnum.COURSE_ADD_FAILED.getMsg());
    }

    @Override
    public UniversalResponseBody<Course> changeCourseStatus(Integer courseId, Integer courseStatus) {
        Course course = courseMessageMapper.getCourseById(courseId);
        if(course == null) {
            return new UniversalResponseBody<Course>(ResponseResultEnum.COURSE_NOT_EXISTED.getCode(), ResponseResultEnum.COURSE_NOT_EXISTED.getMsg());
        }

        int id = courseMessageMapper.changeCourseStatus(courseId, courseStatus);
        if(id > 0) {
            course.setCourseStatus(courseStatus);
            return new UniversalResponseBody<Course>(ResponseResultEnum.SUCCESS.getCode(), ResponseResultEnum.SUCCESS.getMsg(), course);

        }
        return new UniversalResponseBody<Course>(ResponseResultEnum.COURSE_STATUS_CHANGE_FAILED.getCode(), ResponseResultEnum.COURSE_STATUS_CHANGE_FAILED.getMsg());
    }
}
