package com.ruoyi.hr.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.hr.domain.HrEmployee;
import com.ruoyi.hr.mapper.HrOvertimeMapper;
import com.ruoyi.hr.domain.HrOvertime;
import com.ruoyi.hr.service.IHrOvertimeService;

/**
 * 员工加班管理Service业务层处理
 * 
 * @author 点点
 * @date 2023-02-13
 */
@Service
public class HrOvertimeServiceImpl implements IHrOvertimeService 
{
    @Autowired
    private HrOvertimeMapper hrOvertimeMapper;

    /**
     * 查询员工加班管理
     * 
     * @param id 员工加班管理主键
     * @return 员工加班管理
     */
    @Override
    public HrOvertime selectHrOvertimeById(Long id)
    {
        return hrOvertimeMapper.selectHrOvertimeById(id);
    }

    /**
     * 查询员工加班管理列表
     * 
     * @param hrOvertime 员工加班管理
     * @return 员工加班管理
     */
    @Override
    public List<HrOvertime> selectHrOvertimeList(HrOvertime hrOvertime)
    {
        return hrOvertimeMapper.selectHrOvertimeList(hrOvertime);
    }

    /**
     * 新增员工加班管理
     * 
     * @param hrOvertime 员工加班管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertHrOvertime(HrOvertime hrOvertime)
    {
        hrOvertime.setCreateTime(DateUtils.getNowDate());
        int rows = hrOvertimeMapper.insertHrOvertime(hrOvertime);
        return rows;
    }

    /**
     * 修改员工加班管理
     * 
     * @param hrOvertime 员工加班管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateHrOvertime(HrOvertime hrOvertime)
    {
        hrOvertime.setUpdateTime(DateUtils.getNowDate());
        return hrOvertimeMapper.updateHrOvertime(hrOvertime);
    }

    /**
     * 批量删除员工加班管理
     * 
     * @param ids 需要删除的员工加班管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHrOvertimeByIds(Long[] ids)
    {
        return hrOvertimeMapper.deleteHrOvertimeByIds(ids);
    }

    /**
     * 删除员工加班管理信息
     * 
     * @param id 员工加班管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHrOvertimeById(Long id)
    {
        return hrOvertimeMapper.deleteHrOvertimeById(id);
    }


}
