package com.qingyuan.course.controller;

import com.qingyuan.course.pojo.Course;
import com.qingyuan.course.pojo.Student;
import com.qingyuan.course.service.StudentService;
import com.qingyuan.course.service.impl.StudentServiceImpl;
import com.qingyuan.course.utils.UniversalResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @program: course
 * @author: GuoShuSong
 * @create: 2020-10-21 20:18
 **/
@RestController
@Validated
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 报名课程
     *
     * @param courseId
     * @param userId   学生id
     * @return
     */
    @PostMapping("/apply")
    public UniversalResponseBody applyCourse(@RequestParam("courseId") @NotNull(message = "参数courseId不能为空") Integer courseId, @RequestParam("userId") @NotNull(message = "参数userId不能为空") Integer userId) {
        return this.studentService.applyCourse(courseId, userId);
    }


    /**
     * 查询该生报名的所有课程
     *
     * @param userId
     * @return
     */
    @GetMapping("/applyEd")
    public UniversalResponseBody<List<Course>> applyEdCourses(@RequestParam("userId") @NotNull(message = "参数userId不能为空") Integer userId) {
        return this.studentService.applyEdCourse(userId);
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
    public UniversalResponseBody<Student> updateStudentMessage(@RequestParam("userId") @NotNull(message = "参数userId不能为空") Integer userId, @RequestParam("userGrade") @NotBlank(message = "参数不能为空") String userGrade, @RequestParam("userSchool") @NotBlank(message = "参数不能为空") String userSchool) {
        return this.studentService.changeStudentInfo(userId, userGrade, userSchool);
    }
}
