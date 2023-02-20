package com.ruoyi.hr.mapper;

import java.util.List;
import com.ruoyi.hr.domain.HrAdjustSalary;
import com.ruoyi.hr.domain.HrEmployee;

/**
 * 员工调薪Mapper接口
 * 
 * @author diandian
 * @date 2023-02-13
 */
public interface HrAdjustSalaryMapper 
{
    /**
     * 查询员工调薪
     * 
     * @param id 员工调薪主键
     * @return 员工调薪
     */
    public HrAdjustSalary selectHrAdjustSalaryById(Long id);

    /**
     * 查询员工调薪列表
     * 
     * @param hrAdjustSalary 员工调薪
     * @return 员工调薪集合
     */
    public List<HrAdjustSalary> selectHrAdjustSalaryList(HrAdjustSalary hrAdjustSalary);

    /**
     * 新增员工调薪
     * 
     * @param hrAdjustSalary 员工调薪
     * @return 结果
     */
    public int insertHrAdjustSalary(HrAdjustSalary hrAdjustSalary);

    /**
     * 修改员工调薪
     * 
     * @param hrAdjustSalary 员工调薪
     * @return 结果
     */
    public int updateHrAdjustSalary(HrAdjustSalary hrAdjustSalary);

    /**
     * 删除员工调薪
     * 
     * @param id 员工调薪主键
     * @return 结果
     */
    public int deleteHrAdjustSalaryById(Long id);

    /**
     * 批量删除员工调薪
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHrAdjustSalaryByIds(Long[] ids);

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
     * 通过员工调薪主键删除员工档案管理信息
     * 
     * @param id 员工调薪ID
     * @return 结果
     */
    public int deleteHrEmployeeByEmployeeId(Long id);
}
