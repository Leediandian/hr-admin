package com.diandian.hr.mapper;

import java.sql.Date;
import java.util.List;
import com.diandian.hr.domain.HrAttendance;
import org.apache.ibatis.annotations.Param;

/**
 * 员工考勤管理Mapper接口
 * 
 * @author diandian
 * @date 2023-02-13
 */
public interface HrAttendanceMapper 
{
    /**
     * 查询员工考勤管理
     * 
     * @param id 员工考勤管理主键
     * @return 员工考勤管理
     */
    public HrAttendance selectHrAttendanceById(Long id);

    /**
     * 查询员工考勤管理
     *
     * @param id 员工考勤管理主键 day 月份时间
     * @return 员工考勤管理
     */
    public HrAttendance selectHrAttendanceByIdAndDay(@Param("id") Long id, @Param("day") String day);

    /**
     * 查询员工考勤管理
     *
     * @param  hrAttendance
     * @return 员工考勤管理
     */
    public HrAttendance selectHrAttendanceOne(HrAttendance hrAttendance);

    /**
     * 查询员工考勤管理列表
     * 
     * @param hrAttendance 员工考勤管理
     * @return 员工考勤管理集合
     */
    public List<HrAttendance> selectHrAttendanceList(HrAttendance hrAttendance);

    /**
     * 新增员工考勤管理
     * 
     * @param hrAttendance 员工考勤管理
     * @return 结果
     */
    public int insertHrAttendance(HrAttendance hrAttendance);

    /**
     * 修改员工考勤管理
     * 
     * @param hrAttendance 员工考勤管理
     * @return 结果
     */
    public int updateHrAttendance(HrAttendance hrAttendance);

    /**
     * 删除员工考勤管理
     * 
     * @param id 员工考勤管理主键
     * @return 结果
     */
    public int deleteHrAttendanceById(Long id);

    /**
     * 批量删除员工考勤管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHrAttendanceByIds(Long[] ids);


    /**
     * 统计员工迟到、早退、旷工的次数
     *
     * @param employeeId     员工id
     * @param status 状态
     * @param month  月份
     * @return
     */
    Integer countTimes(@Param("employeeId") Long employeeId, @Param("status") String status, @Param("month") String month);

    /**
     * 查找员工休假的日期
     *
     * @param employeeId
     * @param month
     * @return
     */
    List<Date> findLeaveDate(@Param("employeeId") Long employeeId, @Param("status") String status, @Param("month") String month);
}
