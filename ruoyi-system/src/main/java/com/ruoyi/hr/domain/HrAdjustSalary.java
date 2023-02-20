package com.ruoyi.hr.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工调薪对象 hr_adjust_salary
 * 
 * @author diandian
 * @date 2023-02-13
 */
public class HrAdjustSalary extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 调薪编号 */
    private Long id;

    /** 员工编号 */
    @Excel(name = "员工编号")
    private Long employeeId;

    /** 调薪日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "调薪日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date asDate;

    /** 调前薪资 */
    @Excel(name = "调前薪资")
    private Long beforeSalary;

    /** 调后薪资 */
    @Excel(name = "调后薪资")
    private Long afterSalary;

    /** 调薪原因 */
    @Excel(name = "调薪原因")
    private String reason;

    /** 员工档案管理信息 */
    private List<HrEmployee> hrEmployeeList;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setEmployeeId(Long employeeId) 
    {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() 
    {
        return employeeId;
    }
    public void setAsDate(Date asDate) 
    {
        this.asDate = asDate;
    }

    public Date getAsDate() 
    {
        return asDate;
    }
    public void setBeforeSalary(Long beforeSalary) 
    {
        this.beforeSalary = beforeSalary;
    }

    public Long getBeforeSalary() 
    {
        return beforeSalary;
    }
    public void setAfterSalary(Long afterSalary) 
    {
        this.afterSalary = afterSalary;
    }

    public Long getAfterSalary() 
    {
        return afterSalary;
    }
    public void setReason(String reason) 
    {
        this.reason = reason;
    }

    public String getReason() 
    {
        return reason;
    }

    public List<HrEmployee> getHrEmployeeList()
    {
        return hrEmployeeList;
    }

    public void setHrEmployeeList(List<HrEmployee> hrEmployeeList)
    {
        this.hrEmployeeList = hrEmployeeList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("employeeId", getEmployeeId())
            .append("asDate", getAsDate())
            .append("beforeSalary", getBeforeSalary())
            .append("afterSalary", getAfterSalary())
            .append("reason", getReason())
            .append("remark", getRemark())
            .append("hrEmployeeList", getHrEmployeeList())
            .toString();
    }
}
