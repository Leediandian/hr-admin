package com.diandian.hr.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.diandian.hr.mapper.HrJobLevelMapper;
import com.diandian.hr.domain.HrJobLevel;
import com.diandian.hr.service.IHrJobLevelService;

/**
 * 职称管理Service业务层处理
 * 
 * @author 点点
 * @date 2023-02-13
 */
@Service
public class HrJobLevelServiceImpl implements IHrJobLevelService 
{
    @Autowired
    private HrJobLevelMapper hrJobLevelMapper;

    /**
     * 查询职称管理
     * 
     * @param jobLevelId 职称管理主键
     * @return 职称管理
     */
    @Override
    public HrJobLevel selectHrJobLevelByJobLevelId(Long jobLevelId)
    {
        return hrJobLevelMapper.selectHrJobLevelByJobLevelId(jobLevelId);
    }

    /**
     * 查询职称管理列表
     * 
     * @param hrJobLevel 职称管理
     * @return 职称管理
     */
    @Override
    public List<HrJobLevel> selectHrJobLevelList(HrJobLevel hrJobLevel)
    {
        return hrJobLevelMapper.selectHrJobLevelList(hrJobLevel);
    }

    /**
     * 新增职称管理
     * 
     * @param hrJobLevel 职称管理
     * @return 结果
     */
    @Override
    public int insertHrJobLevel(HrJobLevel hrJobLevel)
    {
        return hrJobLevelMapper.insertHrJobLevel(hrJobLevel);
    }

    /**
     * 修改职称管理
     * 
     * @param hrJobLevel 职称管理
     * @return 结果
     */
    @Override
    public int updateHrJobLevel(HrJobLevel hrJobLevel)
    {
        return hrJobLevelMapper.updateHrJobLevel(hrJobLevel);
    }

    /**
     * 批量删除职称管理
     * 
     * @param jobLevelIds 需要删除的职称管理主键
     * @return 结果
     */
    @Override
    public int deleteHrJobLevelByJobLevelIds(Long[] jobLevelIds)
    {
        return hrJobLevelMapper.deleteHrJobLevelByJobLevelIds(jobLevelIds);
    }

    /**
     * 删除职称管理信息
     * 
     * @param jobLevelId 职称管理主键
     * @return 结果
     */
    @Override
    public int deleteHrJobLevelByJobLevelId(Long jobLevelId)
    {
        return hrJobLevelMapper.deleteHrJobLevelByJobLevelId(jobLevelId);
    }
}
