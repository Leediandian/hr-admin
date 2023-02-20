package com.ruoyi.hr.service;

import java.util.List;
import com.ruoyi.hr.domain.HrEmpSalary;

/**
 * 员工账套管理Service接口
 * 
 * @author 点点
 * @date 2023-02-13
 */
public interface IHrEmpSalaryService 
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
     * 批量删除员工账套管理
     * 
     * @param ids 需要删除的员工账套管理主键集合
     * @return 结果
     */
    public int deleteHrEmpSalaryByIds(Long[] ids);

    /**
     * 删除员工账套管理信息
     * 
     * @param id 员工账套管理主键
     * @return 结果
     */
    public int deleteHrEmpSalaryById(Long id);
}
