package com.ruoyi.hr.mapper;

import java.util.List;
import com.ruoyi.hr.domain.HrEmpSalary;
import com.ruoyi.hr.domain.HrEmployee;

/**
 * 员工账套管理Mapper接口
 * 
 * @author 点点
 * @date 2023-02-13
 */
public interface HrEmpSalaryMapper 
{
    /**
     * 查询员工账套管理
     * 
     * @param id 员工账套管理主键
     * @return 员工账套管理
     */
    public HrEmpSalary selectHrEmpSalaryById(Long id);

    /**
     * 查询员工账套管理列表
     * 
     * @param hrEmpSalary 员工账套管理
     * @return 员工账套管理集合
     */
    public List<HrEmpSalary> selectHrEmpSalaryList(HrEmpSalary hrEmpSalary);

    /**
     * 新增员工账套管理
     * 
     * @param hrEmpSalary 员工账套管理
     * @return 结果
     */
    public int insertHrEmpSalary(HrEmpSalary hrEmpSalary);

    /**
     * 修改员工账套管理
     * 
     * @param hrEmpSalary 员工账套管理
     * @return 结果
     */
    public int updateHrEmpSalary(HrEmpSalary hrEmpSalary);

    /**
     * 删除员工账套管理
     * 
     * @param id 员工账套管理主键
     * @return 结果
     */
    public int deleteHrEmpSalaryById(Long id);

    /**
     * 批量删除员工账套管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHrEmpSalaryByIds(Long[] ids);

    /**
     * 批量删除员工档案管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHrEmployeeByEmployeeIds(Long[] ids);
    
    /**
     * 批量新增员工档案管理
     * 
     * @param hrEmployeeList 员工档案管理列表
     * @return 结果
     */
    public int batchHrEmployee(List<HrEmployee> hrEmployeeList);
    

    /**
     * 通过员工账套管理主键删除员工档案管理信息
     * 
     * @param id 员工账套管理ID
     * @return 结果
     */
    public int deleteHrEmployeeByEmployeeId(Long id);
}
