package com.qingyuan.course.controller;

import com.qingyuan.course.pojo.Course;
import com.qingyuan.course.pojo.Student;
import com.qingyuan.course.service.StudentService;
import com.qingyuan.course.service.impl.StudentServiceImpl;
import com.qingyuan.course.utils.UniversalResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private StudentService studentService;
    /**
     * 报名课程
     *
     * @param stuId 学生id
     * @param courseId
     * @return
     */
    @PostMapping("/apply")
    public UniversalResponseBody applyCourse(Integer courseId, Integer userId) {
        Course course = this.studentService.applyCourse(courseId, userId);
        return new UniversalResponseBody(1, "课程报名成功", course);
    }

    /**
     * 查询该生报名的所有课程
     *
     * @param userId
     * @return
     */
    @GetMapping("/applyEd")
    public UniversalResponseBody<List<Course>> applyEdCourses(Integer userId) {
        List<Course> courseList = this.studentService.applyEdCourse(userId);
        return new UniversalResponseBody<List<Course>>(1, "查询成功", courseList);
    }

    /**
     * 更新学生信息
     *
     * @param userId
     * @param userGrade
     * @param userSchool
     * @return
     */
    @PostMapping("/change")
    public UniversalResponseBody<Student> updateStudentMessage(Integer userId, String userGrade, String userSchool) {
        Student student = this.studentService.changeStudentInfo(userId, userGrade, userSchool);
        return new UniversalResponseBody<Student>(1, "修改信息成功", student);
    }
}
