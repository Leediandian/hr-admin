package com.ruoyi.hr.domain;

import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 员工加班管理对象 hr_overtime
 * 
 * @author 点点
 * @date 2023-02-13
 */
public class HrOvertime extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 加班编号 */
    private Long id;

    /** 工资倍数，如按照小时计算，就是员工平均小时工资乘以倍数 */
    @Excel(name = "工资倍数，如按照小时计算，就是员工平均小时工资乘以倍数")
    private BigDecimal salaryMultiple;

    /** 加班奖金 */
    @Excel(name = "加班奖金")
    private BigDecimal bonus;

    /** 加班类型 */
    @Excel(name = "加班类型")
    private Long overtimeTypeId;

    /** 员工编号 */
    @Excel(name = "员工编号")
    private Long employeeId;

    /** 0小时，1天，默认0，计数加班工资的类型 */
    @Excel(name = "0小时，1天，默认0，计数加班工资的类型")
    private Integer countType;

    /** 1启用，0禁用，默认1 */
    @Excel(name = "1启用，0禁用，默认1")
    private Integer status;

    /** 0不补休，1补休，默认0 */
    @Excel(name = "0不补休，1补休，默认0")
    private Integer isTimeOff;

    /** 状态/逻辑删除 */
    @Excel(name = "状态/逻辑删除")
    private Integer isDeleted;

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
    public void setSalaryMultiple(BigDecimal salaryMultiple) 
    {
        this.salaryMultiple = salaryMultiple;
    }

    public BigDecimal getSalaryMultiple() 
    {
        return salaryMultiple;
    }
    public void setBonus(BigDecimal bonus) 
    {
        this.bonus = bonus;
    }

    public BigDecimal getBonus() 
    {
        return bonus;
    }
    public void setOvertimeTypeId(Long overtimeTypeId) 
    {
        this.overtimeTypeId = overtimeTypeId;
    }

    public Long getOvertimeTypeId() 
    {
        return overtimeTypeId;
    }
    public void setEmployeeId(Long employeeId) 
    {
        this.employeeId = employeeId;
    }

    public Long getEmployeeId() 
    {
        return employeeId;
    }
    public void setCountType(Integer countType) 
    {
        this.countType = countType;
    }

    public Integer getCountType() 
    {
        return countType;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setIsTimeOff(Integer isTimeOff) 
    {
        this.isTimeOff = isTimeOff;
    }

    public Integer getIsTimeOff() 
    {
        return isTimeOff;
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
            .append("id", getId())
            .append("salaryMultiple", getSalaryMultiple())
            .append("bonus", getBonus())
            .append("overtimeTypeId", getOvertimeTypeId())
            .append("employeeId", getEmployeeId())
            .append("countType", getCountType())
            .append("remark", getRemark())
            .append("status", getStatus())
            .append("isTimeOff", getIsTimeOff())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDeleted", getIsDeleted())
            .append("hrEmployeeList", getHrEmployeeList())
            .toString();
    }
}
