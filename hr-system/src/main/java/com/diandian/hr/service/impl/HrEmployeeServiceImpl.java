package com.diandian.hr.service.impl;

import java.util.List;

import com.diandian.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.diandian.hr.mapper.HrEmployeeMapper;
import com.diandian.hr.domain.HrEmployee;
import com.diandian.hr.service.IHrEmployeeService;

/**
 * 员工档案管理Service业务层处理
 * 
 * @author diandian
 * @date 2023-02-13
 */
@Service
public class HrEmployeeServiceImpl implements IHrEmployeeService 
{
    @Autowired
    private HrEmployeeMapper hrEmployeeMapper;

    /**
     * 查询员工档案管理
     * 
     * @param employeeId 员工档案管理主键
     * @return 员工档案管理
     */
    @Override
    public HrEmployee selectHrEmployeeByEmployeeId(Long employeeId)
    {
        return hrEmployeeMapper.selectHrEmployeeByEmployeeId(employeeId);
    }

    /**
     * 查询员工档案管理列表
     * 
     * @param hrEmployee 员工档案管理
     * @return 员工档案管理
     */
    @Override
    public List<HrEmployee> selectHrEmployeeList(HrEmployee hrEmployee)
    {
        return hrEmployeeMapper.selectHrEmployeeList(hrEmployee);
    }

    /**
     * 新增员工档案管理
     * 
     * @param hrEmployee 员工档案管理
     * @return 结果
     */
    @Override
    public AjaxResult insertHrEmployee(HrEmployee hrEmployee)
    {
        HrEmployee item = new HrEmployee();
        item.setWorkId(hrEmployee.getWorkId());
        List<HrEmployee> list  = hrEmployeeMapper.selectHrEmployeeList(hrEmployee);
        if(list.size()>0){
            return AjaxResult.error("工号已存在");
        }
        return hrEmployeeMapper.insertHrEmployee(hrEmployee) > 0 ? AjaxResult.success() : AjaxResult.error();


    }

    /**
     * 修改员工档案管理
     * 
     * @param hrEmployee 员工档案管理
     * @return 结果
     */
    @Override
    public int updateHrEmployee(HrEmployee hrEmployee)
    {
        return hrEmployeeMapper.updateHrEmployee(hrEmployee);
    }

    /**
     * 批量删除员工档案管理
     * 
     * @param employeeIds 需要删除的员工档案管理主键
     * @return 结果
     */
    @Override
    public int deleteHrEmployeeByEmployeeIds(Long[] employeeIds)
    {
        return hrEmployeeMapper.deleteHrEmployeeByEmployeeIds(employeeIds);
    }

    /**
     * 删除员工档案管理信息
     * 
     * @param employeeId 员工档案管理主键
     * @return 结果
     */
    @Override
    public int deleteHrEmployeeByEmployeeId(Long employeeId)
    {
        return hrEmployeeMapper.deleteHrEmployeeByEmployeeId(employeeId);
    }
}
