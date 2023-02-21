package com.ruoyi.hr.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 请假审批管理对象 hr_leave
 *
 * @author 点点
 * @date 2023-02-21
 */
public class HrLeave extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 请假编号
     */
    private Long leaveId;
    /**
     * 员工编号
     */
    @Excel(name = "员工编号")
    private Long employeeId;
    /**
     * 员工名称
     */
    @Excel(name = "员工名称")
    private String employeeName;

    /**
     * 请假天数
     */
    @Excel(name = "请假天数")
    private BigDecimal days;

    /**
     * 请假类型
     */
    @Excel(name = "请假类型")
    private String leaveType;

    /**
     * 请假原因描述
     */
    @Excel(name = "请假原因描述")
    private String leaveReason;


    /**
     * 请假的开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "请假的开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /**
     * 请假的结束日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "请假的结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /**
     * 请假状态
     */
    @Excel(name = "请假状态")
    private String leaveStatus;

    /**
     * 逻辑删除
     */
    @Excel(name = "逻辑删除")
    private Integer isDeleted;

    public void setLeaveId(Long leaveId) {
        this.leaveId = leaveId;
    }

    public Long getLeaveId() {
        return leaveId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setDays(BigDecimal days) {
        this.days = days;
    }

    public BigDecimal getDays() {
        return days;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setLeaveStatus(String leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public String getLeaveStatus() {
        return leaveStatus;
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

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("leaveId", getLeaveId())
                .append("employeeId", getEmployeeId())
                .append("days", getDays())
                .append("leaveType", getLeaveType())
                .append("startDate", getStartDate())
                .append("endDate", getEndDate())
                .append("leaveStatus", getLeaveStatus())
                .append("remark", getRemark())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("isDeleted", getIsDeleted())
                .append("employeeName", getEmployeeName())
                .append("leaveReason", getLeaveReason())
                .toString();
    }
}
