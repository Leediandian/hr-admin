package com.ruoyi.hr.domain;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工账套管理对象 hr_emp_salary
 *
 * @author 点点
 * @date 2023-02-13
 */
public class HrEmpSalary extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 员工薪资编号
     */
    private Long id;

    /**
     * 薪资账套名称
     */
    @Excel(name = "薪资账套名称")
    private String salaryName;
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
     * 薪资编号
     */
    @Excel(name = "薪资编号")
    private Long salaryId;

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

    public void setSalaryId(Long salaryId) {
        this.salaryId = salaryId;
    }

    public Long getSalaryId() {
        return salaryId;
    }

    public String getSalaryName() {
        return salaryName;
    }

    public void setSalaryName(String salaryName) {
        this.salaryName = salaryName;
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
                .append("salaryId", getSalaryId())
                .append("salaryName", getSalaryName())
                .append("employeeName", getEmployeeName())
                .toString();
    }
}
