package com.ruoyi.hr.service;

import java.util.List;
import com.ruoyi.hr.domain.HrAdjustSalary;

/**
 * 员工调薪Service接口
 * 
 * @author diandian
 * @date 2023-02-13
 */
public interface IHrAdjustSalaryService 
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
     * 批量删除员工调薪
     * 
     * @param ids 需要删除的员工调薪主键集合
     * @return 结果
     */
    public int deleteHrAdjustSalaryByIds(Long[] ids);

    /**
     * 删除员工调薪信息
     * 
     * @param id 员工调薪主键
     * @return 结果
     */
    public int deleteHrAdjustSalaryById(Long id);
}
