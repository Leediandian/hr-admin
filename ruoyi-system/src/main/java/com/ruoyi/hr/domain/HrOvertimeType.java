package com.ruoyi.hr.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 加班类型对象 hr_overtime_type
 *
 * @author 点点
 * @date 2023-02-13
 */
public class HrOvertimeType extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 加班类型编号
     */
    private Long overtimeTypeId;

    /**
     * 加班类型编码
     */
    @Excel(name = "加班类型编码")
    private String code;

    /**
     * 加班类型名称
     */
    @Excel(name = "加班类型名称")
    private String name;

    /**
     * 状态（0正常 1停用）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /**
     * 工资倍数下限
     */
    @Excel(name = "工资倍数下限")
    private BigDecimal lowerLimit;

    public void setOvertimeTypeId(Long overtimeTypeId) {
        this.overtimeTypeId = overtimeTypeId;
    }

    public Long getOvertimeTypeId() {
        return overtimeTypeId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLowerLimit(BigDecimal lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public BigDecimal getLowerLimit() {
        return lowerLimit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("overtimeTypeId", getOvertimeTypeId())
                .append("code", getCode())
                .append("name", getName())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("lowerLimit", getLowerLimit())
                .toString();
    }
}
