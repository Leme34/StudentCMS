package com.lee.cms.dto;

public class AverageScoreVo{
    private Integer cid;
    private String cname;
    private String major;
    private String grade;
    private String stu_number;
    private String average;
    private String max;
    private String min;
    private String pass_rate;


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getStu_number() {
        return stu_number;
    }

    public void setStu_number(String stu_number) {
        this.stu_number = stu_number;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getPass_rate() {
        return pass_rate;
    }

    public void setPass_rate(String pass_rate) {
        this.pass_rate = pass_rate;
    }

    @Override
    public String toString() {
        return "AverageScoreVo{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", major='" + major + '\'' +
                ", grade='" + grade + '\'' +
                ", stu_number='" + stu_number + '\'' +
                ", average='" + average + '\'' +
                ", max='" + max + '\'' +
                ", min='" + min + '\'' +
                ", pass_rate='" + pass_rate + '\'' +
                '}';
    }

}
