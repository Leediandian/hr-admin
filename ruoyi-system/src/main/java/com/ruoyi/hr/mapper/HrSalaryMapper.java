package com.ruoyi.hr.mapper;

import java.util.List;
import com.ruoyi.hr.domain.HrSalary;

/**
 * 薪资账套管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-02-13
 */
public interface HrSalaryMapper 
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
     * 删除薪资账套管理
     * 
     * @param salaryId 薪资账套管理主键
     * @return 结果
     */
    public int deleteHrSalaryBySalaryId(Long salaryId);

    /**
     * 批量删除薪资账套管理
     * 
     * @param salaryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHrSalaryBySalaryIds(Long[] salaryIds);
}
