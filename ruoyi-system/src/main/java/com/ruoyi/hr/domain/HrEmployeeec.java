package com.ruoyi.hr.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工奖惩管理对象 hr_employeeec
 *
 * @author 点点
 * @date 2023-02-13
 */
public class HrEmployeeec extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 奖惩编号
     */
    private Long employeeecId;
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
     * 奖罚日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "奖罚日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date ecDate;

    /**
     * 奖罚原因
     */
    @Excel(name = "奖罚原因")
    private String ecReason;

    /**
     * 奖惩类别
     */
    @Excel(name = "奖惩类别",readConverterExp ="0迟到1早退2旷工3休假4绩效5项目提成6年终奖")
    private String generalType;

    /**
     * 奖惩类型，0：奖，1：罚
     */
    @Excel(name = "奖惩类型" ,readConverterExp ="0：奖，1：罚")
    private String ecType;

    @Excel(name = "奖惩金额")
    private BigDecimal ecNum;



    public void setEmployeeecId(Long employeeecId) {
        this.employeeecId = employeeecId;
    }

    public Long getEmployeeecId() {
        return employeeecId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEcDate(Date ecDate) {
        this.ecDate = ecDate;
    }

    public Date getEcDate() {
        return ecDate;
    }

    public void setEcReason(String ecReason) {
        this.ecReason = ecReason;
    }

    public String getEcReason() {
        return ecReason;
    }

    public void setEcType(String ecType) {
        this.ecType = ecType;
    }

    public String getEcType() {
        return ecType;
    }

    public String getGeneralType() {
        return generalType;
    }

    public void setGeneralType(String generalType) {
        this.generalType = generalType;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public BigDecimal getEcNum() {
        return ecNum;
    }

    public void setEcNum(BigDecimal ecNum) {
        this.ecNum = ecNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("employeeecId", getEmployeeecId())
                .append("employeeId", getEmployeeId())
                .append("ecDate", getEcDate())
                .append("ecReason", getEcReason())
                .append("generalType", getGeneralType())
                .append("ecType", getEcType())
                .append("remark", getRemark())
                .append("employeeName", getEmployeeName())
                .append("ecNum", getEcNum())
                .toString();
    }
}
