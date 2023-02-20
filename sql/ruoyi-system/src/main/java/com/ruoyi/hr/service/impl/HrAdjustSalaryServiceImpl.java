package com.ruoyi.hr.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.hr.domain.HrEmployee;
import com.ruoyi.hr.mapper.HrAdjustSalaryMapper;
import com.ruoyi.hr.domain.HrAdjustSalary;
import com.ruoyi.hr.service.IHrAdjustSalaryService;

/**
 * 员工调薪Service业务层处理
 * 
 * @author diandian
 * @date 2023-02-13
 */
@Service
public class HrAdjustSalaryServiceImpl implements IHrAdjustSalaryService 
{
    @Autowired
    private HrAdjustSalaryMapper hrAdjustSalaryMapper;

    /**
     * 查询员工调薪
     * 
     * @param id 员工调薪主键
     * @return 员工调薪
     */
    @Override
    public HrAdjustSalary selectHrAdjustSalaryById(Long id)
    {
        return hrAdjustSalaryMapper.selectHrAdjustSalaryById(id);
    }

    /**
     * 查询员工调薪列表
     * 
     * @param hrAdjustSalary 员工调薪
     * @return 员工调薪
     */
    @Override
    public List<HrAdjustSalary> selectHrAdjustSalaryList(HrAdjustSalary hrAdjustSalary)
    {
        return hrAdjustSalaryMapper.selectHrAdjustSalaryList(hrAdjustSalary);
    }

    /**
     * 新增员工调薪
     * 
     * @param hrAdjustSalary 员工调薪
     * @return 结果
     */
    @Transactional
    @Override
    public int insertHrAdjustSalary(HrAdjustSalary hrAdjustSalary)
    {
        int rows = hrAdjustSalaryMapper.insertHrAdjustSalary(hrAdjustSalary);
        insertHrEmployee(hrAdjustSalary);
        return rows;
    }

    /**
     * 修改员工调薪
     * 
     * @param hrAdjustSalary 员工调薪
     * @return 结果
     */
    @Transactional
    @Override
    public int updateHrAdjustSalary(HrAdjustSalary hrAdjustSalary)
    {
        hrAdjustSalaryMapper.deleteHrEmployeeByEmployeeId(hrAdjustSalary.getId());
        insertHrEmployee(hrAdjustSalary);
        return hrAdjustSalaryMapper.updateHrAdjustSalary(hrAdjustSalary);
    }

    /**
     * 批量删除员工调薪
     * 
     * @param ids 需要删除的员工调薪主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHrAdjustSalaryByIds(Long[] ids)
    {
        hrAdjustSalaryMapper.deleteHrEmployeeByEmployeeIds(ids);
        return hrAdjustSalaryMapper.deleteHrAdjustSalaryByIds(ids);
    }

    /**
     * 删除员工调薪信息
     * 
     * @param id 员工调薪主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHrAdjustSalaryById(Long id)
    {
        hrAdjustSalaryMapper.deleteHrEmployeeByEmployeeId(id);
        return hrAdjustSalaryMapper.deleteHrAdjustSalaryById(id);
    }

    /**
     * 新增员工档案管理信息
     * 
     * @param hrAdjustSalary 员工调薪对象
     */
    public void insertHrEmployee(HrAdjustSalary hrAdjustSalary)
    {
        List<HrEmployee> hrEmployeeList = hrAdjustSalary.getHrEmployeeList();
        Long id = hrAdjustSalary.getId();
        if (StringUtils.isNotNull(hrEmployeeList))
        {
            List<HrEmployee> list = new ArrayList<HrEmployee>();
            for (HrEmployee hrEmployee : hrEmployeeList)
            {
                hrEmployee.setEmployeeId(id);
                list.add(hrEmployee);
            }
            if (list.size() > 0)
            {
                hrAdjustSalaryMapper.batchHrEmployee(list);
            }
        }
    }
}
