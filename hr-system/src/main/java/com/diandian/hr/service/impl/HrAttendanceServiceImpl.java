package com.diandian.hr.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import com.diandian.common.core.domain.AjaxResult;
import com.diandian.common.utils.DateUtils;
import com.diandian.hr.domain.HrEmployee;
import com.diandian.hr.domain.HrWorkTime;
import com.diandian.hr.domain.vo.HrAttendanceMonthVo;
import com.diandian.hr.domain.vo.HrAttendanceVo;
import com.diandian.hr.mapper.HrEmployeeMapper;
import com.diandian.hr.mapper.HrWorkTimeMapper;
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
public class HrAttendanceServiceImpl implements IHrAttendanceService {
    @Autowired
    private HrAttendanceMapper hrAttendanceMapper;
    @Autowired
    private HrEmployeeMapper hrEmployeeMapper;
    @Autowired
    private HrWorkTimeMapper hrWorkTimeMapper;

    /**
     * 查询员工考勤管理
     *
     * @param id 员工考勤管理主键
     * @return 员工考勤管理
     */
    @Override
    public HrAttendance selectHrAttendanceById(Long id) {
        return hrAttendanceMapper.selectHrAttendanceById(id);
    }

    /**
     * 查询员工考勤管理列表
     *
     * @param hrAttendance 员工考勤管理
     * @return 员工考勤管理
     */
    @Override
    public List<HrAttendance> selectHrAttendanceList(HrAttendance hrAttendance) {
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
    public int insertHrAttendance(HrAttendance hrAttendance) {
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
    public int updateHrAttendance(HrAttendance hrAttendance) {
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
    public int deleteHrAttendanceByIds(Long[] ids) {
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
    public int deleteHrAttendanceById(Long id) {
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
            hrAttendanceMonthVo.setMonth(DateUtil.format(new java.util.Date(), "yyyyMM"));
        }
        //获取员工列表
        List<HrAttendanceMonthVo> emlist = hrEmployeeMapper.selectHrEmployeeListMonth(hrAttendanceMonthVo);

        //生成时间列表 获取当前月下的日期
        String[] monthDayList = DateUtils.getMonthDayList(hrAttendanceMonthVo.getMonth());

        //迭代员工列表
        for (HrAttendanceMonthVo empItem : emlist) {
            empItem.setMonth(hrAttendanceMonthVo.getMonth());
            // 获取当前月的日期，格式为yyyyMMdd
            List<HashMap<String, Object>> list = new ArrayList<>();
            for (String day : monthDayList) {
                HashMap<String, Object> map = new HashMap<>();
                HrAttendance attendance = hrAttendanceMapper.selectHrAttendanceByIdAndDay(empItem.getEmployeeId(), day);
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
            //每月天数
            empItem.setDayNum(list.size());
        }
        return emlist;
    }

    /**
     * 员工月考勤数据统计
     *
     * @param hrAttendanceVo 员工考勤数据
     * @return 结果
     */
    @Override
    public List<HrAttendanceVo> selectHrAttendanceListCount(HrAttendanceVo hrAttendanceVo) {
        // 如果没有指明月份，就默认显示当前月份的考勤数据
        if (hrAttendanceVo.getMonth() == null) {
            hrAttendanceVo.setMonth(DateUtil.format(new java.util.Date(), "yyyyMM"));
        }
        //获取员工列表
        List<HrAttendanceVo> attendanceVolist = hrEmployeeMapper.selectHrEmployeeListMonthCount(hrAttendanceVo);

        //迭代员工列表
        for (HrAttendanceVo item : attendanceVolist) {
            // 设置迟到次数
            item.setLateTimes(hrAttendanceMapper.countTimes(item.getEmployeeId(), "1", hrAttendanceVo.getMonth()));
            // 设置早退次数
            item.setLeaveEarlyTimes(hrAttendanceMapper.countTimes(item.getEmployeeId(), "2", hrAttendanceVo.getMonth()));
            // 设置旷工次数
            item.setAbsenteeismTimes(hrAttendanceMapper.countTimes(item.getEmployeeId(), "3", hrAttendanceVo.getMonth()));
            // 设置休假天数
            List<Date> leaveDateList = hrAttendanceMapper.findLeaveDate(item.getEmployeeId(), "4", hrAttendanceVo.getMonth());

            int count = 0;
            for (Date date : leaveDateList) {
                // 不包括周末
                if (!DateUtil.isWeekend(date)) {
                    count++;
                }
            }
            item.setLeaveDays(count);


        }
        return attendanceVolist;
    }

    /**
     * 导入考勤数据
     *
     * @param list 员工考勤数据 excel
     * @return 结果
     */
    @Override
    public AjaxResult importList(List<HrAttendance> list) {
        //更新或者添加
        for (HrAttendance item : list) {
            //获取员工对象
            HrEmployee employee = hrEmployeeMapper.selectHrEmployeeByEmployeeId(item.getEmployeeId());
            //创建空的工作时间参数对象
            HrWorkTime witem = new HrWorkTime();
            witem.setDeptId(employee.getDeptId());
            //根据部门id查找的工作时间对象
            List<HrWorkTime> wlist = hrWorkTimeMapper.selectHrWorkTimeList(witem);
            if (wlist.size() == 0) {
                return AjaxResult.error("导入失败:该员工所在部门未设置工作时间");
            }

            // 判断是否是周末，如果是周末就不用记录考勤情况，如果不是周末就判断员工是否请假
            if (item.getEmployeeId() == null || item.getAttendanceDate() == null || DateUtil.isWeekend(item.getAttendanceDate()) || isLeave(item)) {

            } else {
                HrWorkTime deptWorkTime = wlist.get(0);
                if (isAbsenteeism(item, deptWorkTime)) {
                    item.setAttendanceStatus("3");
                } else if (isLate(item, deptWorkTime)) {
                    item.setAttendanceStatus("1");
                } else if (isLeaveEarly(item, deptWorkTime)) {
                    item.setAttendanceStatus("2");
                } else {
                    item.setAttendanceStatus("0");
                }
                //查找是否存在 存在就修改 不存在就新增
                HrAttendance result = hrAttendanceMapper.selectHrAttendanceByIdAndDay(item.getEmployeeId(), DateUtil.format(item.getAttendanceDate(), "yyyyMMdd"));

                //员工考勤编号
                if (result==null || result.getId() == null ||  result.getId().longValue() == 0) {
                    hrAttendanceMapper.insertHrAttendance(item);
                } else {
                    result.setMorStartTime(item.getMorStartTime());
                    result.setMorEndTime(item.getMorEndTime());
                    result.setAftEndTime(item.getAftEndTime());
                    result.setAftStartTime(item.getAftStartTime());
                    result.setAttendanceStatus(item.getAttendanceStatus());
                    hrAttendanceMapper.updateHrAttendance(result);
                }
            }
        }
        return AjaxResult.success("插入成功");
    }

    /**
     * 判断员工是否请假
     *
     * @param attendance
     * @return
     */
    private boolean isLeave(HrAttendance attendance) {
        HrAttendance one = hrAttendanceMapper.selectHrAttendanceOne(attendance);
        if (one != null) {
            if (one.getAttendanceStatus() == "4") {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * 是否迟到
     *
     * @param attendance
     * @param attendance deptWorkTime
     * @return
     */
    private boolean isLate(HrAttendance attendance, HrWorkTime deptWorkTime) {
        if (DateUtil.compare(attendance.getMorStartTime(), deptWorkTime.getMorStartTime(), "HH:mm:ss") > 0) {
            return true;
        } else if (DateUtil.compare(attendance.getAftStartTime(), deptWorkTime.getAftStartTime(), "HH:mm:ss") > 0) {
            return true;
        }
        return false;
    }

    /**
     * 是否早退
     *
     * @param attendance
     * @param attendance deptWorkTime
     * @return
     */
    private boolean isLeaveEarly(HrAttendance attendance, HrWorkTime deptWorkTime) {
        if (DateUtil.compare(attendance.getMorEndTime(), deptWorkTime.getMorEndTime(), "HH:mm:ss") < 0) {
            return true;
        } else if (DateUtil.compare(attendance.getAftEndTime(), deptWorkTime.getAftEndTime(), "HH:mm:ss") < 0) {
            return true;
        }
        return false;
    }

    /**
     * 是否旷工，如果4个打卡，有一个没打卡，就视为旷工，如果既迟到又早退，也使视为旷工
     *
     * @param attendance
     * @param attendance deptWorkTime
     * @return
     */
    private boolean isAbsenteeism(HrAttendance attendance, HrWorkTime deptWorkTime) {
        if (attendance.getMorStartTime() == null || attendance.getMorEndTime() == null
                || attendance.getAftStartTime() == null || attendance.getAftEndTime() == null) {
            return true;
        }
        return isLate(attendance, deptWorkTime) && isLeaveEarly(attendance, deptWorkTime);
    }

}
