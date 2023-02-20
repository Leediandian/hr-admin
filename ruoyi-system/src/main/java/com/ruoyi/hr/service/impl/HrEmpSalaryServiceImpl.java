package com.ruoyi.hr.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.hr.domain.HrEmployee;
import com.ruoyi.hr.mapper.HrEmpSalaryMapper;
import com.ruoyi.hr.domain.HrEmpSalary;
import com.ruoyi.hr.service.IHrEmpSalaryService;

/**
 * 员工账套管理Service业务层处理
 * 
 * @author 点点
 * @date 2023-02-13
 */
@Service
public class HrEmpSalaryServiceImpl implements IHrEmpSalaryService 
{
    @Autowired
    private HrEmpSalaryMapper hrEmpSalaryMapper;

    /**
     * 查询员工账套管理
     * 
     * @param id 员工账套管理主键
     * @return 员工账套管理
     */
    @Override
    public HrEmpSalary selectHrEmpSalaryById(Long id)
    {
        return hrEmpSalaryMapper.selectHrEmpSalaryById(id);
    }

    /**
     * 查询员工账套管理列表
     * 
     * @param hrEmpSalary 员工账套管理
     * @return 员工账套管理
     */
    @Override
    public List<HrEmpSalary> selectHrEmpSalaryList(HrEmpSalary hrEmpSalary)
    {
        return hrEmpSalaryMapper.selectHrEmpSalaryList(hrEmpSalary);
    }

    /**
     * 新增员工账套管理
     * 
     * @param hrEmpSalary 员工账套管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertHrEmpSalary(HrEmpSalary hrEmpSalary)
    {
        int rows = hrEmpSalaryMapper.insertHrEmpSalary(hrEmpSalary);
        insertHrEmployee(hrEmpSalary);
        return rows;
    }

    /**
     * 修改员工账套管理
     * 
     * @param hrEmpSalary 员工账套管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateHrEmpSalary(HrEmpSalary hrEmpSalary)
    {
        hrEmpSalaryMapper.deleteHrEmployeeByEmployeeId(hrEmpSalary.getId());
        insertHrEmployee(hrEmpSalary);
        return hrEmpSalaryMapper.updateHrEmpSalary(hrEmpSalary);
    }

    /**
     * 批量删除员工账套管理
     * 
     * @param ids 需要删除的员工账套管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHrEmpSalaryByIds(Long[] ids)
    {
        hrEmpSalaryMapper.deleteHrEmployeeByEmployeeIds(ids);
        return hrEmpSalaryMapper.deleteHrEmpSalaryByIds(ids);
    }

    /**
     * 删除员工账套管理信息
     * 
     * @param id 员工账套管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHrEmpSalaryById(Long id)
    {
        hrEmpSalaryMapper.deleteHrEmployeeByEmployeeId(id);
        return hrEmpSalaryMapper.deleteHrEmpSalaryById(id);
    }

    /**
     * 新增员工档案管理信息
     * 
     * @param hrEmpSalary 员工账套管理对象
     */
    public void insertHrEmployee(HrEmpSalary hrEmpSalary)
    {
        List<HrEmployee> hrEmployeeList = hrEmpSalary.getHrEmployeeList();
        Long id = hrEmpSalary.getId();
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
                hrEmpSalaryMapper.batchHrEmployee(list);
            }
        }
    }
}
