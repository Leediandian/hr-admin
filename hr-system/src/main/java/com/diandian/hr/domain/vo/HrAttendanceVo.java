package com.diandian.hr.domain.vo;

import com.diandian.common.annotation.Excel;
import com.diandian.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 员工考勤表现
 *
 * @author 点点
 * @date 2023-02-22
 */
public class HrAttendanceVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    private Long employeeId;

    /**
     * 员工姓名
     */
    @Excel(name = "员工姓名")
    private String name;

    /**
     * 电话号码
     */
    @Excel(name = "电话号码")
    private String phone;

    /**
     * 联系地址
     */
    @Excel(name = "联系地址")
    private String address;

    /**
     * 所属部门
     */
    @Excel(name = "所属部门")
    private Long deptId;

    /**
     * 职位ID
     */
    @Excel(name = "职位ID")
    private Long postId;

    /**
     * 职位名称
     */
    @Excel(name = "职位名称")
    private Long postName;

    /**
     * 聘用形式
     */
    @Excel(name = "聘用形式")
    private String engageForm;

    /**
     * 在职状态
     */
    @Excel(name = "在职状态")
    private String workState;

    /**
     * 工号
     */
    @Excel(name = "工号")
    private String workId;

    /**
     * 迟到次数
     */
    @Excel(name = "迟到次数")
    private Integer lateTimes;

    /**
     * 早退次数
     */
    @Excel(name = "早退次数")
    private Integer leaveEarlyTimes;

    /**
     * 旷工次数
     */
    @Excel(name = "旷工次数")
    private Integer absenteeismTimes;

    /**
     * 休假天数
     */
    @Excel(name = "休假天数")
    private Integer leaveDays;


    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getPostName() {
        return postName;
    }

    public void setPostName(Long postName) {
        this.postName = postName;
    }

    public String getEngageForm() {
        return engageForm;
    }

    public void setEngageForm(String engageForm) {
        this.engageForm = engageForm;
    }

    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public Integer getLateTimes() {
        return lateTimes;
    }

    public void setLateTimes(Integer lateTimes) {
        this.lateTimes = lateTimes;
    }

    public Integer getLeaveEarlyTimes() {
        return leaveEarlyTimes;
    }

    public void setLeaveEarlyTimes(Integer leaveEarlyTimes) {
        this.leaveEarlyTimes = leaveEarlyTimes;
    }

    public Integer getAbsenteeismTimes() {
        return absenteeismTimes;
    }

    public void setAbsenteeismTimes(Integer absenteeismTimes) {
        this.absenteeismTimes = absenteeismTimes;
    }

    public Integer getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(Integer leaveDays) {
        this.leaveDays = leaveDays;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("employeeId", getEmployeeId())
                .append("name", getName())
                .append("phone", getPhone())
                .append("address", getAddress())
                .append("deptId", getDeptId())
                .append("postId", getPostId())
                .append("postName", getPostName())
                .append("engageForm", getEngageForm())
                .append("workState", getWorkState())
                .append("workId", getWorkId())
                .append("lateTimes", getLateTimes())
                .append("leaveEarlyTimes", getLeaveEarlyTimes())
                .append("absenteeismTimes", getAbsenteeismTimes())
                .append("leaveDays", getLeaveDays())
                .toString();
    }
}
