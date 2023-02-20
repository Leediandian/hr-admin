package com.ruoyi.hr.mapper;

import java.util.List;
import com.ruoyi.hr.domain.HrWorkTime;

/**
 * 工作时间管理Mapper接口
 * 
 * @author 点点
 * @date 2023-02-13
 */
public interface HrWorkTimeMapper 
{
    /**
     * 查询工作时间管理
     * 
     * @param id 工作时间管理主键
     * @return 工作时间管理
     */
    public HrWorkTime selectHrWorkTimeById(Long id);

    /**
     * 查询工作时间管理列表
     * 
     * @param hrWorkTime 工作时间管理
     * @return 工作时间管理集合
     */
    public List<HrWorkTime> selectHrWorkTimeList(HrWorkTime hrWorkTime);

    /**
     * 新增工作时间管理
     * 
     * @param hrWorkTime 工作时间管理
     * @return 结果
     */
    public int insertHrWorkTime(HrWorkTime hrWorkTime);

    /**
     * 修改工作时间管理
     * 
     * @param hrWorkTime 工作时间管理
     * @return 结果
     */
    public int updateHrWorkTime(HrWorkTime hrWorkTime);

    /**
     * 删除工作时间管理
     * 
     * @param id 工作时间管理主键
     * @return 结果
     */
    public int deleteHrWorkTimeById(Long id);

    /**
     * 批量删除工作时间管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHrWorkTimeByIds(Long[] ids);
}
