package com.diandian.hr.service.impl;

import java.util.List;
import com.diandian.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.diandian.hr.mapper.HrAttendanceMapper;
import com.diandian.hr.domain.HrAttendance;
import com.diandian.hr.service.IHrAttendanceService;

/**
 * 员工考勤管理Service业务层处理
 * 
 * @author diandian
 * @date 2023-02-13
 */
@Service
public class HrAttendanceServiceImpl implements IHrAttendanceService 
{
    @Autowired
    private HrAttendanceMapper hrAttendanceMapper;

    /**
     * 查询员工考勤管理
     * 
     * @param id 员工考勤管理主键
     * @return 员工考勤管理
     */
    @Override
    public HrAttendance selectHrAttendanceById(Long id)
    {
        return hrAttendanceMapper.selectHrAttendanceById(id);
    }

    /**
     * 查询员工考勤管理列表
     * 
     * @param hrAttendance 员工考勤管理
     * @return 员工考勤管理
     */
    @Override
    public List<HrAttendance> selectHrAttendanceList(HrAttendance hrAttendance)
    {
        return hrAttendanceMapper.selectHrAttendanceList(hrAttendance);
    }

    /**
     * 新增员工考勤管理
     * 
     * @param hrAttendance 员工考勤管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertHrAttendance(HrAttendance hrAttendance)
    {
        hrAttendance.setCreateTime(DateUtils.getNowDate());
        int rows = hrAttendanceMapper.insertHrAttendance(hrAttendance);

        return rows;
    }

    /**
     * 修改员工考勤管理
     * 
     * @param hrAttendance 员工考勤管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateHrAttendance(HrAttendance hrAttendance)
    {
        hrAttendance.setUpdateTime(DateUtils.getNowDate());
        return hrAttendanceMapper.updateHrAttendance(hrAttendance);
    }

    /**
     * 批量删除员工考勤管理
     * 
     * @param ids 需要删除的员工考勤管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHrAttendanceByIds(Long[] ids)
    {
        return hrAttendanceMapper.deleteHrAttendanceByIds(ids);
    }

    /**
     * 删除员工考勤管理信息
     * 
     * @param id 员工考勤管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHrAttendanceById(Long id)
    {
        return hrAttendanceMapper.deleteHrAttendanceById(id);
    }


}
