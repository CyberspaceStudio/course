package com.qingyuan.course.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 课程类
 * @program: course
 * @author: GuoShuSong
 * @create: 2020-10-21 19:18
 **/
@Data
public class Course {

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 教师id
     */
    private Integer userId;

    /**
     * 教师姓名
     */
    private String userName;

    /**
     * 课程名称
     */
    private String courseName;

    /**
     * 课程开始时间(具体到天)
     */
    private String courseStartDay;

    /**
     * 课程结束时间(具体到天)
     */
    private String courseEndDay;

    /**
     * 课程上课时间(eg:周四 15:00-16:00)
     */
    private String courseTime;

    /**
     * 课程学生容量
     */
    private Integer courseStuCount;

    /**
     * 课程报名人数
     */
    private Integer courseApplyCount;

    /**
     * 课程价格
     */
    private BigDecimal coursePrice;

    /**
     * 课程上课次数
     */
    private Integer courseTimes;

    /**
     * 课程标签
     */
    private String courseLabel;


    /**
     * 课程上课地址
     */
    private String courseAddress;

    /**
     * 课程状态
     */
    private Integer courseStatus;
}
