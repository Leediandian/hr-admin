package com.ruoyi.hr.domain;

import java.util.List;
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
 * @date 2023-02-13
 */
public class HrLeave extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 请假编号 */
    private Long leaveId;

    /** 员工编号 */
    @Excel(name = "员工编号")
    private Long employeeId;

    /** 请假的天数 */
    @Excel(name = "请假的天数")
    private Long days;

    /** 请假类型id */
    @Excel(name = "请假类型id")
    private Long typeNum;

    /** 请假的开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "请假的开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 0未审核，1审核通过，2驳回，3撤销 */
    @Excel(name = "0未审核，1审核通过，2驳回，3撤销")
    private Integer status;

    /** 状态/逻辑删除 */
    @Excel(name = "状态/逻辑删除")
    private Integer isDeleted;

    /** 员工档案管理信息 */
    private List<HrEmployee> hrEmployeeList;

    public void setLeaveId(Long leaveId) 
    {
        this.leaveId = leaveId;
    }

    public Long getLeaveId() 
    {
        return leaveId;
    }
    public void setEmployeeId(Long employeeId) 
    {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() 
    {
        return employeeId;
    }
    public void setDays(Long days) 
    {
        this.days = days;
    }

    public Long getDays() 
    {
        return days;
    }
    public void setTypeNum(Long typeNum) 
    {
        this.typeNum = typeNum;
    }

    public Long getTypeNum() 
    {
        return typeNum;
    }
    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setIsDeleted(Integer isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted() 
    {
        return isDeleted;
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
            .append("leaveId", getLeaveId())
            .append("employeeId", getEmployeeId())
            .append("days", getDays())
            .append("typeNum", getTypeNum())
            .append("startDate", getStartDate())
            .append("status", getStatus())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDeleted", getIsDeleted())
            .append("hrEmployeeList", getHrEmployeeList())
            .toString();
    }
}
