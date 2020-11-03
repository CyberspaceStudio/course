package com.qingyuan.course.controller;

import com.qingyuan.course.pojo.Course;
import com.qingyuan.course.pojo.Student;
import com.qingyuan.course.service.TeacherService;
import com.qingyuan.course.utils.UniversalResponseBody;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 教师相关接口
 * @program: course
 * @author: GuoShuSong
 * @create: 2020-10-22 21:38
 **/
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    @Qualifier("teacherServiceImpl")
    private TeacherService teacherService;

    /**
     * 查询某一课程的全部学生
     * @param courseId
     * @return
     */
    public UniversalResponseBody<List<Student>> getCourseStudent(Integer courseId){
        return null;
    }

    /**
     * 查看某一老师教授的课程
     * @param courseId 课程id
     * @param userId 教师id
     * @return
     */
    public UniversalResponseBody<List<Course>> getTeachCourse(Integer courseId,Integer userId){
        return null;
    }

    /**
     * 增加课程
     * @param course
     * @return
     */
    @PostMapping("/add")
    public UniversalResponseBody<Course> addCourse(Course course){
        return teacherService.addCourse(course);
    }

    /**
     * 修改课程状态
     * @param courseId 课程id
     * @param courseStatus 具体见课程状态字典
     * @return
     */
    @PutMapping("/change")
    public UniversalResponseBody<Course> changeCourseStatus(Integer courseId,Integer courseStatus){
        return teacherService.changeCourseStatus(courseId, courseStatus);
    }

}
