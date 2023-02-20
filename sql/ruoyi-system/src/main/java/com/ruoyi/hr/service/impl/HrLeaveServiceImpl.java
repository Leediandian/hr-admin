package com.ruoyi.hr.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.hr.domain.HrEmployee;
import com.ruoyi.hr.mapper.HrLeaveMapper;
import com.ruoyi.hr.domain.HrLeave;
import com.ruoyi.hr.service.IHrLeaveService;

/**
 * 请假审批管理Service业务层处理
 * 
 * @author 点点
 * @date 2023-02-13
 */
@Service
public class HrLeaveServiceImpl implements IHrLeaveService 
{
    @Autowired
    private HrLeaveMapper hrLeaveMapper;

    /**
     * 查询请假审批管理
     * 
     * @param leaveId 请假审批管理主键
     * @return 请假审批管理
     */
    @Override
    public HrLeave selectHrLeaveByLeaveId(Long leaveId)
    {
        return hrLeaveMapper.selectHrLeaveByLeaveId(leaveId);
    }

    /**
     * 查询请假审批管理列表
     * 
     * @param hrLeave 请假审批管理
     * @return 请假审批管理
     */
    @Override
    public List<HrLeave> selectHrLeaveList(HrLeave hrLeave)
    {
        return hrLeaveMapper.selectHrLeaveList(hrLeave);
    }

    /**
     * 新增请假审批管理
     * 
     * @param hrLeave 请假审批管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertHrLeave(HrLeave hrLeave)
    {
        hrLeave.setCreateTime(DateUtils.getNowDate());
        int rows = hrLeaveMapper.insertHrLeave(hrLeave);
        insertHrEmployee(hrLeave);
        return rows;
    }

    /**
     * 修改请假审批管理
     * 
     * @param hrLeave 请假审批管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateHrLeave(HrLeave hrLeave)
    {
        hrLeave.setUpdateTime(DateUtils.getNowDate());
        hrLeaveMapper.deleteHrEmployeeByEmployeeId(hrLeave.getLeaveId());
        insertHrEmployee(hrLeave);
        return hrLeaveMapper.updateHrLeave(hrLeave);
    }

    /**
     * 批量删除请假审批管理
     * 
     * @param leaveIds 需要删除的请假审批管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHrLeaveByLeaveIds(Long[] leaveIds)
    {
        hrLeaveMapper.deleteHrEmployeeByEmployeeIds(leaveIds);
        return hrLeaveMapper.deleteHrLeaveByLeaveIds(leaveIds);
    }

    /**
     * 删除请假审批管理信息
     * 
     * @param leaveId 请假审批管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHrLeaveByLeaveId(Long leaveId)
    {
        hrLeaveMapper.deleteHrEmployeeByEmployeeId(leaveId);
        return hrLeaveMapper.deleteHrLeaveByLeaveId(leaveId);
    }

    /**
     * 新增员工档案管理信息
     * 
     * @param hrLeave 请假审批管理对象
     */
    public void insertHrEmployee(HrLeave hrLeave)
    {
        List<HrEmployee> hrEmployeeList = hrLeave.getHrEmployeeList();
        Long leaveId = hrLeave.getLeaveId();
        if (StringUtils.isNotNull(hrEmployeeList))
        {
            List<HrEmployee> list = new ArrayList<HrEmployee>();
            for (HrEmployee hrEmployee : hrEmployeeList)
            {
                hrEmployee.setEmployeeId(leaveId);
                list.add(hrEmployee);
            }
            if (list.size() > 0)
            {
                hrLeaveMapper.batchHrEmployee(list);
            }
        }
    }
}
