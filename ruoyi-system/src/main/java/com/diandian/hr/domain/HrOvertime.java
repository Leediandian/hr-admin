package com.diandian.hr.domain;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.diandian.common.annotation.Excel;
import com.diandian.common.core.domain.BaseEntity;

/**
 * 员工加班管理对象 hr_overtime
 *
 * @author 点点
 * @date 2023-02-13
 */
public class HrOvertime extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 加班编号
     */
    private Long id;

    /**
     * 工资倍数，如按照小时计算，就是员工平均小时工资乘以倍数
     */
    @Excel(name = "工资倍数，如按照小时计算，就是员工平均小时工资乘以倍数")
    private BigDecimal salaryMultiple;

    /**
     * 加班奖金
     */
    @Excel(name = "加班奖金")
    private BigDecimal bonus;


    /**
     * 加班类型编号
     */
    private Long overtimeTypeId;

    /**
     * 加班类型名称
     */
    @Excel(name = "加班类型名称")
    private String overtimeTypeName;

    /**
     * 员工编号
     */
    private Long employeeId;

    /**
     * 员工名称
     */
    @Excel(name = "员工名称")
    private String employeeName;

    /**
     * 员工加班计数类型
     */
    @Excel(name = "员工加班计数类型")
    private String countType;

    /**
     * 加班时长
     */
    @Excel(name = "加班时长")
    private BigDecimal timeNum;

    /**
     * 员工是否补休
     */
    @Excel(name = "员工是否补休")
    private String isTimeOff;

    /**
     * 逻辑删除
     */
    @Excel(name = "逻辑删除")
    private Integer isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSalaryMultiple() {
        return salaryMultiple;
    }

    public void setSalaryMultiple(BigDecimal salaryMultiple) {
        this.salaryMultiple = salaryMultiple;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public Long getOvertimeTypeId() {
        return overtimeTypeId;
    }

    public void setOvertimeTypeId(Long overtimeTypeId) {
        this.overtimeTypeId = overtimeTypeId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCountType() {
        return countType;
    }

    public void setCountType(String countType) {
        this.countType = countType;
    }

    public String getIsTimeOff() {
        return isTimeOff;
    }

    public void setIsTimeOff(String isTimeOff) {
        this.isTimeOff = isTimeOff;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getOvertimeTypeName() {
        return overtimeTypeName;
    }

    public void setOvertimeTypeName(String overtimeTypeName) {
        this.overtimeTypeName = overtimeTypeName;
    }

    public BigDecimal getTimeNum() {
        return timeNum;
    }

    public void setTimeNum(BigDecimal timeNum) {
        this.timeNum = timeNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("salaryMultiple", getSalaryMultiple())
                .append("bonus", getBonus())
                .append("overtimeTypeId", getOvertimeTypeId())
                .append("overtimeTypeName", getOvertimeTypeName())
                .append("employeeId", getEmployeeId())
                .append("employeeName", getEmployeeName())
                .append("countType", getCountType())
                .append("timeNum", getTimeNum())
                .append("remark", getRemark())
                .append("isTimeOff", getIsTimeOff())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("isDeleted", getIsDeleted())
                .toString();
    }
}
