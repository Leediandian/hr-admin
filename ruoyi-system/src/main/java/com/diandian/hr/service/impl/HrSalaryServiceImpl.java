package com.diandian.hr.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.diandian.hr.mapper.HrSalaryMapper;
import com.diandian.hr.domain.HrSalary;
import com.diandian.hr.service.IHrSalaryService;

/**
 * 薪资账套管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-02-13
 */
@Service
public class HrSalaryServiceImpl implements IHrSalaryService 
{
    @Autowired
    private HrSalaryMapper hrSalaryMapper;

    /**
     * 查询薪资账套管理
     * 
     * @param salaryId 薪资账套管理主键
     * @return 薪资账套管理
     */
    @Override
    public HrSalary selectHrSalaryBySalaryId(Long salaryId)
    {
        return hrSalaryMapper.selectHrSalaryBySalaryId(salaryId);
    }

    /**
     * 查询薪资账套管理列表
     * 
     * @param hrSalary 薪资账套管理
     * @return 薪资账套管理
     */
    @Override
    public List<HrSalary> selectHrSalaryList(HrSalary hrSalary)
    {
        return hrSalaryMapper.selectHrSalaryList(hrSalary);
    }

    /**
     * 新增薪资账套管理
     * 
     * @param hrSalary 薪资账套管理
     * @return 结果
     */
    @Override
    public int insertHrSalary(HrSalary hrSalary)
    {
        return hrSalaryMapper.insertHrSalary(hrSalary);
    }

    /**
     * 修改薪资账套管理
     * 
     * @param hrSalary 薪资账套管理
     * @return 结果
     */
    @Override
    public int updateHrSalary(HrSalary hrSalary)
    {
        return hrSalaryMapper.updateHrSalary(hrSalary);
    }

    /**
     * 批量删除薪资账套管理
     * 
     * @param salaryIds 需要删除的薪资账套管理主键
     * @return 结果
     */
    @Override
    public int deleteHrSalaryBySalaryIds(Long[] salaryIds)
    {
        return hrSalaryMapper.deleteHrSalaryBySalaryIds(salaryIds);
    }

    /**
     * 删除薪资账套管理信息
     * 
     * @param salaryId 薪资账套管理主键
     * @return 结果
     */
    @Override
    public int deleteHrSalaryBySalaryId(Long salaryId)
    {
        return hrSalaryMapper.deleteHrSalaryBySalaryId(salaryId);
    }
}
