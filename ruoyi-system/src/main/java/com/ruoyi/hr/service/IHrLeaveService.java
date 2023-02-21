package com.ruoyi.hr.service;

import java.util.List;
import com.ruoyi.hr.domain.HrLeave;

/**
 * 请假审批管理Service接口
 *
 * @author 点点
 * @date 2023-02-21
 */
public interface IHrLeaveService
{
    /**
     * 查询请假审批管理
     *
     * @param leaveId 请假审批管理主键
     * @return 请假审批管理
     */
    public HrLeave selectHrLeaveByLeaveId(Long leaveId);

    /**
     * 查询请假审批管理列表
     *
     * @param hrLeave 请假审批管理
     * @return 请假审批管理集合
     */
    public List<HrLeave> selectHrLeaveList(HrLeave hrLeave);

    /**
     * 新增请假审批管理
     *
     * @param hrLeave 请假审批管理
     * @return 结果
     */
    public int insertHrLeave(HrLeave hrLeave);

    /**
     * 修改请假审批管理
     *
     * @param hrLeave 请假审批管理
     * @return 结果
     */
    public int updateHrLeave(HrLeave hrLeave);

    /**
     * 批量删除请假审批管理
     *
     * @param leaveIds 需要删除的请假审批管理主键集合
     * @return 结果
     */
    public int deleteHrLeaveByLeaveIds(Long[] leaveIds);

    /**
     * 删除请假审批管理信息
     *
     * @param leaveId 请假审批管理主键
     * @return 结果
     */
    public int deleteHrLeaveByLeaveId(Long leaveId);
}
