package com.diandian.hr.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.diandian.common.annotation.Excel;
import com.diandian.common.core.domain.BaseEntity;

/**
 * 职称管理对象 hr_job_level
 * 
 * @author 点点
 * @date 2023-02-13
 */
public class HrJobLevel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 职称编号 */
    private Long jobLevelId;

    /** 职称名称 */
    @Excel(name = "职称名称")
    private String jobLevelName;

    /** 职称等级 */
    @Excel(name = "职称等级")
    private String titleLevel;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    public void setJobLevelId(Long jobLevelId) 
    {
        this.jobLevelId = jobLevelId;
    }

    public Long getJobLevelId() 
    {
        return jobLevelId;
    }
    public void setJobLevelName(String jobLevelName) 
    {
        this.jobLevelName = jobLevelName;
    }

    public String getJobLevelName() 
    {
        return jobLevelName;
    }
    public void setTitleLevel(String titleLevel) 
    {
        this.titleLevel = titleLevel;
    }

    public String getTitleLevel() 
    {
        return titleLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("jobLevelId", getJobLevelId())
            .append("jobLevelName", getJobLevelName())
            .append("titleLevel", getTitleLevel())
            .append("status", getStatus())
            .toString();
    }
}
