package com.diandian.hr.service;

import java.util.List;
import com.diandian.hr.domain.HrSalary;

/**
 * 薪资账套管理Service接口
 * 
 * @author diandian
 * @date 2023-02-13
 */
public interface IHrSalaryService 
{
    /**
     * 查询薪资账套管理
     * 
     * @param salaryId 薪资账套管理主键
     * @return 薪资账套管理
     */
    public HrSalary selectHrSalaryBySalaryId(Long salaryId);

    /**
     * 查询薪资账套管理列表
     * 
     * @param hrSalary 薪资账套管理
     * @return 薪资账套管理集合
     */
    public List<HrSalary> selectHrSalaryList(HrSalary hrSalary);

    /**
     * 新增薪资账套管理
     * 
     * @param hrSalary 薪资账套管理
     * @return 结果
     */
    public int insertHrSalary(HrSalary hrSalary);

    /**
     * 修改薪资账套管理
     * 
     * @param hrSalary 薪资账套管理
     * @return 结果
     */
    public int updateHrSalary(HrSalary hrSalary);

    /**
     * 批量删除薪资账套管理
     * 
     * @param salaryIds 需要删除的薪资账套管理主键集合
     * @return 结果
     */
    public int deleteHrSalaryBySalaryIds(Long[] salaryIds);

    /**
     * 删除薪资账套管理信息
     * 
     * @param salaryId 薪资账套管理主键
     * @return 结果
     */
    public int deleteHrSalaryBySalaryId(Long salaryId);
}
