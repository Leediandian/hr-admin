package com.ruoyi.hr.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hr.mapper.HrEmployeeecMapper;
import com.ruoyi.hr.domain.HrEmployeeec;
import com.ruoyi.hr.service.IHrEmployeeecService;

/**
 * 员工奖惩管理Service业务层处理
 * 
 * @author 点点
 * @date 2023-02-13
 */
@Service
public class HrEmployeeecServiceImpl implements IHrEmployeeecService 
{
    @Autowired
    private HrEmployeeecMapper hrEmployeeecMapper;

    /**
     * 查询员工奖惩管理
     * 
     * @param employeeecId 员工奖惩管理主键
     * @return 员工奖惩管理
     */
    @Override
    public HrEmployeeec selectHrEmployeeecByEmployeeecId(Long employeeecId)
    {
        return hrEmployeeecMapper.selectHrEmployeeecByEmployeeecId(employeeecId);
    }

    /**
     * 查询员工奖惩管理列表
     * 
     * @param hrEmployeeec 员工奖惩管理
     * @return 员工奖惩管理
     */
    @Override
    public List<HrEmployeeec> selectHrEmployeeecList(HrEmployeeec hrEmployeeec)
    {
        return hrEmployeeecMapper.selectHrEmployeeecList(hrEmployeeec);
    }

    /**
     * 新增员工奖惩管理
     * 
     * @param hrEmployeeec 员工奖惩管理
     * @return 结果
     */
    @Override
    public int insertHrEmployeeec(HrEmployeeec hrEmployeeec)
    {
        return hrEmployeeecMapper.insertHrEmployeeec(hrEmployeeec);
    }

    /**
     * 修改员工奖惩管理
     * 
     * @param hrEmployeeec 员工奖惩管理
     * @return 结果
     */
    @Override
    public int updateHrEmployeeec(HrEmployeeec hrEmployeeec)
    {
        return hrEmployeeecMapper.updateHrEmployeeec(hrEmployeeec);
    }

    /**
     * 批量删除员工奖惩管理
     * 
     * @param employeeecIds 需要删除的员工奖惩管理主键
     * @return 结果
     */
    @Override
    public int deleteHrEmployeeecByEmployeeecIds(Long[] employeeecIds)
    {
        return hrEmployeeecMapper.deleteHrEmployeeecByEmployeeecIds(employeeecIds);
    }

    /**
     * 删除员工奖惩管理信息
     * 
     * @param employeeecId 员工奖惩管理主键
     * @return 结果
     */
    @Override
    public int deleteHrEmployeeecByEmployeeecId(Long employeeecId)
    {
        return hrEmployeeecMapper.deleteHrEmployeeecByEmployeeecId(employeeecId);
    }
}
