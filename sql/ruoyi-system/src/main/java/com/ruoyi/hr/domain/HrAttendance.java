package com.ruoyi.hr.domain;


import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工考勤管理对象 hr_attendance
 *
 * @author diandian
 * @date 2023-02-13
 */
public class HrAttendance extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 员工考勤编号
     */
    private Long id;
    /**
     * 员工名称
     */
    @Excel(name = "员工名称")
    private String employeeName;

    /**
     * 员工编号
     */
    @Excel(name = "员工编号")
    private Long employeeId;

    /**
     * 上午上班时间
     */
    @JsonFormat(pattern = "HH:mm:ss")
    @Excel(name = "上午上班时间", width = 30, dateFormat = "HH:mm:ss")
    private Date morStartTime;

    /**
     * 上午下班时间
     */
    @JsonFormat(pattern = "HH:mm:ss")
    @Excel(name = "上午下班时间", width = 30, dateFormat = "HH:mm:ss")
    private Date morEndTime;

    /**
     * 下午上班时间
     */
    @JsonFormat(pattern = "HH:mm:ss")
    @Excel(name = "下午上班时间", width = 30, dateFormat = "HH:mm:ss")
    private Date aftStartTime;

    /**
     * 下午下班时间
     */
    @JsonFormat(pattern = "HH:mm:ss")
    @Excel(name = "下午下班时间", width = 30, dateFormat = "HH:mm:ss")
    private Date aftEndTime;

    /**
     * 考勤日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "考勤日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date attendanceDate;

    /**
     * 考勤状态
     */
    @Excel(name = "考勤状态", readConverterExp = "0正常，1迟到，2早退，3旷工，4休假")
    private String attendanceStatus;

    /**
     * 逻辑删除
     */
    private Integer isDeleted;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setMorStartTime(Date morStartTime) {
        this.morStartTime = morStartTime;
    }

    public Date getMorStartTime() {
        return morStartTime;
    }

    public void setMorEndTime(Date morEndTime) {
        this.morEndTime = morEndTime;
    }

    public Date getMorEndTime() {
        return morEndTime;
    }

    public void setAftStartTime(Date aftStartTime) {
        this.aftStartTime = aftStartTime;
    }

    public Date getAftStartTime() {
        return aftStartTime;
    }

    public void setAftEndTime(Date aftEndTime) {
        this.aftEndTime = aftEndTime;
    }

    public Date getAftEndTime() {
        return aftEndTime;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceStatus(String attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public String getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("employeeId", getEmployeeId())
                .append("morStartTime", getMorStartTime())
                .append("morEndTime", getMorEndTime())
                .append("aftStartTime", getAftStartTime())
                .append("aftEndTime", getAftEndTime())
                .append("attendanceDate", getAttendanceDate())
                .append("attendanceStatus", getAttendanceStatus())
                .append("remark", getRemark())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("isDeleted", getIsDeleted())
                .append("employeeName", getEmployeeName())
                .toString();
    }
}
