package com.diandian.hr.domain.vo;

import com.diandian.common.annotation.Excel;
import com.diandian.common.core.domain.BaseEntity;
import com.diandian.common.core.domain.entity.SysDept;
import com.diandian.hr.domain.HrJobLevel;
import com.diandian.system.domain.SysPost;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 员工每月考勤表现
 *
 * @author 点点
 * @date 2023-02-22
 */
public class HrAttendanceMonthVo extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    private Long employeeId;

    /**
     * 员工姓名
     */
    @Excel(name = "员工姓名")
    private String employeeName;


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
    private Long deptId;

    /**
     * 职位ID
     */
    private Long postId;

    /**
     * 职位名称
     */
    @Excel(name = "职位名称")
    private String postName;

    /**
     * 所属部门名称
     */
    @Excel(name = "部门名称")
    private String deptName;

    /**
     * 工号
     */
    @Excel(name = "工号")
    private String workId;
    /**
     * 月份参数
     */
    private String month;
    /**
     * 每月天数
     */
    private Integer dayNum;

    /**
     * 员工考勤数据
     */
    private List<HashMap<String, Object>> attendanceList;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public List<HashMap<String, Object>> getAttendanceList() {
        return attendanceList;
    }

    public void setAttendanceList(List<HashMap<String, Object>> attendanceList) {
        this.attendanceList = attendanceList;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getDayNum() {
        return dayNum;
    }

    public void setDayNum(Integer dayNum) {
        this.dayNum = dayNum;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("employeeId", getEmployeeId())
                .append("employeeName", getEmployeeName())
                .append("phone", getPhone())
                .append("address", getAddress())
                .append("deptId", getDeptId())
                .append("postId", getPostId())
                .append("postName", getPostName())
                .append("deptName", getDeptName())
                .append("workId", getWorkId())
                .append("attendanceList", getAttendanceList())
                .toString();
    }
}
