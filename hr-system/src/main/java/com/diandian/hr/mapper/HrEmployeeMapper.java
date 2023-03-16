package com.diandian.hr.mapper;

import java.util.List;
import com.diandian.hr.domain.HrEmployee;
import com.diandian.hr.domain.vo.HrAttendanceMonthVo;
import com.diandian.hr.domain.vo.HrAttendanceVo;
import org.apache.ibatis.annotations.Param;

/**
 * 员工档案管理Mapper接口
 * 
 * @author diandian
 * @date 2023-02-13
 */
public interface HrEmployeeMapper 
{
    /**
     * 查询员工档案管理
     * 
     * @param employeeId 员工档案管理主键
     * @return 员工档案管理
     */
    public HrEmployee selectHrEmployeeByEmployeeId(Long employeeId);

    /**
     * 查询员工档案管理列表
     * 
     * @param hrEmployee 员工档案管理
     * @return 员工档案管理集合
     */
    public List<HrEmployee> selectHrEmployeeList(HrEmployee hrEmployee);

    /**
     * 查询员工档案管理列表
     *
     * @param hrEmployee 员工档案管理
     * @return 返回员工列表 到 员工考勤表现列表
     */
    public List<HrAttendanceMonthVo> selectHrEmployeeListMonth(HrAttendanceMonthVo hrEmployee);

    /**
     * 新增员工档案管理
     * 
     * @param hrEmployee 员工档案管理
     * @return 结果
     */
    public int insertHrEmployee(HrEmployee hrEmployee);

    /**
     * 修改员工档案管理
     * 
     * @param hrEmployee 员工档案管理
     * @return 结果
     */
    public int updateHrEmployee(HrEmployee hrEmployee);

    /**
     * 删除员工档案管理
     * 
     * @param employeeId 员工档案管理主键
     * @return 结果
     */
    public int deleteHrEmployeeByEmployeeId(Long employeeId);

    /**
     * 批量删除员工档案管理
     * 
     * @param employeeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHrEmployeeByEmployeeIds(Long[] employeeIds);

    /**
     * 查询员工档案管理列表
     *
     * @param hrAttendanceVo 员工考勤资料
     * @return 返回员工列表 到 员工考勤表现列表
     */
    List<HrAttendanceVo> selectHrEmployeeListMonthCount(HrAttendanceVo hrAttendanceVo);

    /**
     * 查询部门下的员工数
     *
     * @param deptId 部门id
     * @return 返回部门下的总员工数
     */
    Integer countDept(@Param("deptId") Long deptId);


    /**
     * 统计月份下的离职人数
     *
     * @param month 月份
     * @return 月份下的离职人数
     */
    Integer countNotWork(@Param("month")String month);

    /**
     * 统计月份下的离职人数
     *
     * @param month 月份
     * @return 月份下的离职人数
     */
    Integer countBeginWork(@Param("month")String month);
}
