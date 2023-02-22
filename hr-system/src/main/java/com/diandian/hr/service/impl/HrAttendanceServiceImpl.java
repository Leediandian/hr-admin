package com.diandian.hr.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.diandian.common.utils.DateUtils;
import com.diandian.hr.domain.HrEmployee;
import com.diandian.hr.domain.vo.HrAttendanceMonthVo;
import com.diandian.hr.mapper.HrEmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.diandian.hr.mapper.HrAttendanceMapper;
import com.diandian.hr.domain.HrAttendance;
import com.diandian.hr.service.IHrAttendanceService;
import cn.hutool.core.date.DateUtil;
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
    @Autowired
    private HrEmployeeMapper hrEmployeeMapper;

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

    /**
     * 查看员工每月考勤表现列表
     *
     * @param hrAttendanceMonthVo 员工考勤管理主键
     * @return 结果
     */
    @Override
    public List<HrAttendanceMonthVo> selectMonthOfHrAttendanceList(HrAttendanceMonthVo hrAttendanceMonthVo) {
        // 如果没有指明月份，就默认显示当前月份的考勤数据
        if (hrAttendanceMonthVo.getMonth() == null) {
            hrAttendanceMonthVo.setMonth( DateUtil.format(new java.util.Date(), "yyyyMM"));
        }
        //获取员工列表
        List<HrAttendanceMonthVo> emlist = hrEmployeeMapper.selectHrEmployeeListMonth(hrAttendanceMonthVo);

        //生成时间列表 获取当前月下的日期
        String[] monthDayList =  DateUtils.getMonthDayList(hrAttendanceMonthVo.getMonth());

        //迭代员工列表
        for (HrAttendanceMonthVo empItem : emlist) {
            empItem.setMonth(hrAttendanceMonthVo.getMonth());
            // 获取当前月的日期，格式为yyyyMMdd
            List<HashMap<String, Object>> list = new ArrayList<>();
            for (String day : monthDayList) {
                HashMap<String, Object> map = new HashMap<>();
                HrAttendance attendance =  hrAttendanceMapper.selectHrAttendanceByIdAndDay(empItem.getEmployeeId(), day);
                // 如果考勤数据不存在，就重新设置数据
                if (attendance == null) {
                    Date date = DateUtil.parse(day, "yyyyMMdd").toSqlDate();
                    // 如果是周末就休假
                    if (DateUtil.isWeekend(date)) {
                        map.put("value", "4");
                    } else {
                        map.put("value", "0");
                    }
                    map.put("attendanceDate", date);
                } else {
                    map.put("value", attendance.getAttendanceStatus());
                    map.put("attendanceDate", attendance.getAttendanceDate());
                }
                list.add(map);
            }
            empItem.setAttendanceList(list);
            empItem.setDayNum(list.size());
        }
        return emlist;
    }


}
