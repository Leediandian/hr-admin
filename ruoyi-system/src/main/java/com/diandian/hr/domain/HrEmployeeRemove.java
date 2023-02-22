package com.diandian.hr.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.diandian.common.core.domain.entity.SysDept;
import com.diandian.system.domain.SysPost;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.diandian.common.annotation.Excel;
import com.diandian.common.core.domain.BaseEntity;

/**
 * 员工调动对象 hr_employee_remove
 *
 * @author diandian
 * @date 2023-02-19
 */
public class HrEmployeeRemove extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 员工调动编号
     */
    private Long id;

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
     * 调动前部门
     */
    @Excel(name = "调动前部门")
    private Long beforeDeptId;

    /**
     * 调动前职位
     */
    @Excel(name = "调动前职位")
    private Long beforePostId;

    /**
     * 调动后部门
     */
    @Excel(name = "调动后部门")
    private Long afterDeptId;

    /**
     * 调动后职位
     */
    @Excel(name = "调动后职位")
    private Long afterPostId;

    /**
     * 调动日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "调动日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date removeDate;

    /**
     * 调动原因
     */
    @Excel(name = "调动原因")
    private String reason;

    /**
     * 调动前员工部门
     */
    private SysDept beforeDept;
    /**
     * 调动前员工职位
     */
    private SysPost beforePost;

    /**
     * 调动后员工部门
     */
    private SysDept afterDept;
    /**
     * 调动后员工职位
     */
    private SysPost afterPost;


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

    public void setBeforeDeptId(Long beforeDeptId) {
        this.beforeDeptId = beforeDeptId;
    }

    public Long getBeforeDeptId() {
        return beforeDeptId;
    }

    public void setAfterDeptId(Long afterDeptId) {
        this.afterDeptId = afterDeptId;
    }

    public Long getAfterDeptId() {
        return afterDeptId;
    }

    public void setRemoveDate(Date removeDate) {
        this.removeDate = removeDate;
    }

    public Date getRemoveDate() {
        return removeDate;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public SysDept getBeforeDept() {
        return beforeDept;
    }

    public void setBeforeDept(SysDept beforeDept) {
        this.beforeDept = beforeDept;
    }

    public SysPost getBeforePost() {
        return beforePost;
    }

    public void setBeforePost(SysPost beforePost) {
        this.beforePost = beforePost;
    }

    public SysDept getAfterDept() {
        return afterDept;
    }

    public void setAfterDept(SysDept afterDept) {
        this.afterDept = afterDept;
    }

    public SysPost getAfterPost() {
        return afterPost;
    }

    public void setAfterPost(SysPost afterPost) {
        this.afterPost = afterPost;
    }

    public Long getBeforePostId() {
        return beforePostId;
    }

    public void setBeforePostId(Long beforePostId) {
        this.beforePostId = beforePostId;
    }

    public Long getAfterPostId() {
        return afterPostId;
    }

    public void setAfterPostId(Long afterPostId) {
        this.afterPostId = afterPostId;
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
                .append("employeeName", getEmployeeName())
                .append("beforeDeptId", getBeforeDeptId())
                .append("beforePostId", getBeforePostId())
                .append("afterDeptId", getAfterDeptId())
                .append("afterPostId", getAfterPostId())
                .append("removeDate", getRemoveDate())
                .append("reason", getReason())
                .append("remark", getRemark())
                .toString();
    }
}
