package com.ruoyi.hr.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hr.mapper.HrWorkTimeMapper;
import com.ruoyi.hr.domain.HrWorkTime;
import com.ruoyi.hr.service.IHrWorkTimeService;

/**
 * 工作时间管理Service业务层处理
 * 
 * @author 点点
 * @date 2023-02-13
 */
@Service
public class HrWorkTimeServiceImpl implements IHrWorkTimeService 
{
    @Autowired
    private HrWorkTimeMapper hrWorkTimeMapper;

    /**
     * 查询工作时间管理
     * 
     * @param id 工作时间管理主键
     * @return 工作时间管理
     */
    @Override
    public HrWorkTime selectHrWorkTimeById(Long id)
    {
        return hrWorkTimeMapper.selectHrWorkTimeById(id);
    }

    /**
     * 查询工作时间管理列表
     * 
     * @param hrWorkTime 工作时间管理
     * @return 工作时间管理
     */
    @Override
    public List<HrWorkTime> selectHrWorkTimeList(HrWorkTime hrWorkTime)
    {
        return hrWorkTimeMapper.selectHrWorkTimeList(hrWorkTime);
    }

    /**
     * 新增工作时间管理
     * 
     * @param hrWorkTime 工作时间管理
     * @return 结果
     */
    @Override
    public int insertHrWorkTime(HrWorkTime hrWorkTime)
    {
        hrWorkTime.setCreateTime(DateUtils.getNowDate());
        return hrWorkTimeMapper.insertHrWorkTime(hrWorkTime);
    }

    /**
     * 修改工作时间管理
     * 
     * @param hrWorkTime 工作时间管理
     * @return 结果
     */
    @Override
    public int updateHrWorkTime(HrWorkTime hrWorkTime)
    {
        hrWorkTime.setUpdateTime(DateUtils.getNowDate());
        return hrWorkTimeMapper.updateHrWorkTime(hrWorkTime);
    }

    /**
     * 批量删除工作时间管理
     * 
     * @param ids 需要删除的工作时间管理主键
     * @return 结果
     */
    @Override
    public int deleteHrWorkTimeByIds(Long[] ids)
    {
        return hrWorkTimeMapper.deleteHrWorkTimeByIds(ids);
    }

    /**
     * 删除工作时间管理信息
     * 
     * @param id 工作时间管理主键
     * @return 结果
     */
    @Override
    public int deleteHrWorkTimeById(Long id)
    {
        return hrWorkTimeMapper.deleteHrWorkTimeById(id);
    }
}
