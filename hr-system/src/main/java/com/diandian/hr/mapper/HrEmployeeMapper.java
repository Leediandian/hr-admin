package com.diandian.hr.mapper;

import java.util.List;
import com.diandian.hr.domain.HrEmployee;

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
}
