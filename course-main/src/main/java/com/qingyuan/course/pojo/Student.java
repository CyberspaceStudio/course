package com.qingyuan.course.pojo;

import lombok.Data;

/**
 * @program: course
 * @author: GuoShuSong
 * @create: 2020-10-21 19:09
 **/
@Data
public class Student extends User {

    /**
     * 用户年级
     */
    private String userGrade;

    /**
     * 用户学校
     */
    private String userSchool;
}
