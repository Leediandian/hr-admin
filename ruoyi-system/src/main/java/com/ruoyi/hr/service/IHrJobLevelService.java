package com.ruoyi.hr.service;

import java.util.List;
import com.ruoyi.hr.domain.HrJobLevel;

/**
 * 职称管理Service接口
 * 
 * @author 点点
 * @date 2023-02-13
 */
public interface IHrJobLevelService 
{
    /**
     * 查询职称管理
     * 
     * @param jobLevelId 职称管理主键
     * @return 职称管理
     */
    public HrJobLevel selectHrJobLevelByJobLevelId(Long jobLevelId);

    /**
     * 查询职称管理列表
     * 
     * @param hrJobLevel 职称管理
     * @return 职称管理集合
     */
    public List<HrJobLevel> selectHrJobLevelList(HrJobLevel hrJobLevel);

    /**
     * 新增职称管理
     * 
     * @param hrJobLevel 职称管理
     * @return 结果
     */
    public int insertHrJobLevel(HrJobLevel hrJobLevel);

    /**
     * 修改职称管理
     * 
     * @param hrJobLevel 职称管理
     * @return 结果
     */
    public int updateHrJobLevel(HrJobLevel hrJobLevel);

    /**
     * 批量删除职称管理
     * 
     * @param jobLevelIds 需要删除的职称管理主键集合
     * @return 结果
     */
    public int deleteHrJobLevelByJobLevelIds(Long[] jobLevelIds);

    /**
     * 删除职称管理信息
     * 
     * @param jobLevelId 职称管理主键
     * @return 结果
     */
    public int deleteHrJobLevelByJobLevelId(Long jobLevelId);
}
