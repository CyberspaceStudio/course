package com.qingyuan.course.pojo;

import lombok.Data;

/**
 * @program: course
 * @author: GuoShuSong
 * @create: 2020-10-21 19:11
 **/
@Data
public class Teacher extends User {

    /**
     * 教授科目
     */
    private String teachSubject;

    /**
     * 教师介绍
     */
    private String teachIntroduction;
}
