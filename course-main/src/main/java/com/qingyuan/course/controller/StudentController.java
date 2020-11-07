package com.qingyuan.course.controller;

import com.qingyuan.course.pojo.Course;
import com.qingyuan.course.pojo.Student;
import com.qingyuan.course.utils.UniversalResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: course
 * @author: GuoShuSong
 * @create: 2020-10-21 20:18
 **/
@RestController
@RequestMapping("/student")
public class StudentController {

    /**
     * 报名课程
     * @param stuId 学生id
     * @param courseId
     * @return
     */
    @PostMapping("/apply")
    public UniversalResponseBody applyCourse(Integer stuId,Integer courseId){
        return null;
    }

    /**
     * 查询该生报名的所有课程
     * @param userId
     * @return
     */
    @GetMapping("/applyEd")
    public UniversalResponseBody<List<Course>> applyEdCourses(Integer userId){
        return null;
    }


    /**
     * 更新学生信息
     * @param userId
     * @param userGrade
     * @param userSchool
     * @return
     */
    public UniversalResponseBody<Student> updateStudentMessage(Integer userId,String userGrade,String userSchool){
        return null;
    }
}
