package com.ruoyi.hr.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.domain.entity.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 工作时间管理对象 hr_work_time
 * 
 * @author 点点
 * @date 2023-02-13
 */
public class HrWorkTime extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 工作时间编号 */
    private Long id;

    /** 部门编号 */
    @Excel(name = "部门编号")
    private Long deptId;

    /** 上午上班时间 */
    @JsonFormat(pattern = "HH:mm")
    @Excel(name = "上午上班时间", width = 30, dateFormat = "HH:mm")
    private Date morStartTime;

    /** 上午下班时间 */
    @JsonFormat(pattern = "HH:mm")
    @Excel(name = "上午下班时间", width = 30, dateFormat = "HH:mm")
    private Date morEndTime;

    /** 下午上班时间 */
    @JsonFormat(pattern = "HH:mm")
    @Excel(name = "下午上班时间", width = 30, dateFormat = "HH:mm")
    private Date aftStartTime;

    /** 下午下班时间 */
    @JsonFormat(pattern = "HH:mm")
    @Excel(name = "下午下班时间", width = 30, dateFormat = "HH:mm")
    private Date aftEndTime;

    /** 员工总工作时长 */
    @Excel(name = "员工总工作时长")
    private BigDecimal totalWorkTime;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    private SysDept dept;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeptId(Long deptId) 
    {
        this.deptId = deptId;
    }

    public Long getDeptId() 
    {
        return deptId;
    }
    public void setMorStartTime(Date morStartTime) 
    {
        this.morStartTime = morStartTime;
    }

    public Date getMorStartTime() 
    {
        return morStartTime;
    }
    public void setMorEndTime(Date morEndTime) 
    {
        this.morEndTime = morEndTime;
    }

    public Date getMorEndTime() 
    {
        return morEndTime;
    }
    public void setAftStartTime(Date aftStartTime) 
    {
        this.aftStartTime = aftStartTime;
    }

    public Date getAftStartTime() 
    {
        return aftStartTime;
    }
    public void setAftEndTime(Date aftEndTime) 
    {
        this.aftEndTime = aftEndTime;
    }

    public Date getAftEndTime() 
    {
        return aftEndTime;
    }
    public void setTotalWorkTime(BigDecimal totalWorkTime) 
    {
        this.totalWorkTime = totalWorkTime;
    }

    public BigDecimal getTotalWorkTime()
    {
        return totalWorkTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SysDept getDept() {
        return dept;
    }

    public void setDept(SysDept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deptId", getDeptId())
            .append("morStartTime", getMorStartTime())
            .append("morEndTime", getMorEndTime())
            .append("aftStartTime", getAftStartTime())
            .append("aftEndTime", getAftEndTime())
            .append("totalWorkTime", getTotalWorkTime())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
             .append("dept", getDept())
            .toString();
    }
}
