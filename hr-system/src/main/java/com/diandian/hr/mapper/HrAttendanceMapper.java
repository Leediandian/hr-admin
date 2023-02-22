package com.diandian.hr.mapper;

import java.util.List;
import com.diandian.hr.domain.HrAttendance;

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



}
