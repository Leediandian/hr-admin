package com.diandian.hr.mapper;

import java.util.List;
import com.diandian.hr.domain.HrEmployeeec;

/**
 * 员工奖惩管理Mapper接口
 * 
 * @author 点点
 * @date 2023-02-13
 */
public interface HrEmployeeecMapper 
{
    /**
     * 查询员工奖惩管理
     * 
     * @param employeeecId 员工奖惩管理主键
     * @return 员工奖惩管理
     */
    public HrEmployeeec selectHrEmployeeecByEmployeeecId(Long employeeecId);

    /**
     * 查询员工奖惩管理列表
     * 
     * @param hrEmployeeec 员工奖惩管理
     * @return 员工奖惩管理集合
     */
    public List<HrEmployeeec> selectHrEmployeeecList(HrEmployeeec hrEmployeeec);


    /**
     * 新增员工奖惩管理
     * 
     * @param hrEmployeeec 员工奖惩管理
     * @return 结果
     */
    public int insertHrEmployeeec(HrEmployeeec hrEmployeeec);

    /**
     * 修改员工奖惩管理
     * 
     * @param hrEmployeeec 员工奖惩管理
     * @return 结果
     */
    public int updateHrEmployeeec(HrEmployeeec hrEmployeeec);

    /**
     * 删除员工奖惩管理
     * 
     * @param employeeecId 员工奖惩管理主键
     * @return 结果
     */
    public int deleteHrEmployeeecByEmployeeecId(Long employeeecId);

    /**
     * 批量删除员工奖惩管理
     * 
     * @param employeeecIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHrEmployeeecByEmployeeecIds(Long[] employeeecIds);
}
