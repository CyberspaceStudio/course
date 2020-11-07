package com.qingyuan.course.enums;

/**
 * 课程状态枚举类
 * @author GuoShuSong
 */
public enum CourseStatusEnum {
    CREATED(0,"创建完成"),
    APPLYING(1,"报名中"),
    EXPIRED(2,"已经过期");

    /**
     * 课程状态
     */
    private Integer CourseStatus;

    /**
     * 课程状态名称
     */
    private String CourseStatusName;


    CourseStatusEnum(Integer courseStatus, String courseStatusName) {
        CourseStatus = courseStatus;
        CourseStatusName = courseStatusName;
    }

    public Integer getCourseStatus() {
        return CourseStatus;
    }

    public void setCourseStatus(Integer courseStatus) {
        CourseStatus = courseStatus;
    }

    public String getCourseStatusName() {
        return CourseStatusName;
    }

    public void setCourseStatusName(String courseStatusName) {
        CourseStatusName = courseStatusName;
    }
}
