package com.ruoyi.hr.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hr.mapper.HrOvertimeTypeMapper;
import com.ruoyi.hr.domain.HrOvertimeType;
import com.ruoyi.hr.service.IHrOvertimeTypeService;

/**
 * 加班类型Service业务层处理
 * 
 * @author 点点
 * @date 2023-02-13
 */
@Service
public class HrOvertimeTypeServiceImpl implements IHrOvertimeTypeService 
{
    @Autowired
    private HrOvertimeTypeMapper hrOvertimeTypeMapper;

    /**
     * 查询加班类型
     * 
     * @param overtimeTypeId 加班类型主键
     * @return 加班类型
     */
    @Override
    public HrOvertimeType selectHrOvertimeTypeByOvertimeTypeId(Long overtimeTypeId)
    {
        return hrOvertimeTypeMapper.selectHrOvertimeTypeByOvertimeTypeId(overtimeTypeId);
    }

    /**
     * 查询加班类型列表
     * 
     * @param hrOvertimeType 加班类型
     * @return 加班类型
     */
    @Override
    public List<HrOvertimeType> selectHrOvertimeTypeList(HrOvertimeType hrOvertimeType)
    {
        return hrOvertimeTypeMapper.selectHrOvertimeTypeList(hrOvertimeType);
    }

    /**
     * 新增加班类型
     * 
     * @param hrOvertimeType 加班类型
     * @return 结果
     */
    @Override
    public int insertHrOvertimeType(HrOvertimeType hrOvertimeType)
    {
        hrOvertimeType.setCreateTime(DateUtils.getNowDate());
        return hrOvertimeTypeMapper.insertHrOvertimeType(hrOvertimeType);
    }

    /**
     * 修改加班类型
     * 
     * @param hrOvertimeType 加班类型
     * @return 结果
     */
    @Override
    public int updateHrOvertimeType(HrOvertimeType hrOvertimeType)
    {
        hrOvertimeType.setUpdateTime(DateUtils.getNowDate());
        return hrOvertimeTypeMapper.updateHrOvertimeType(hrOvertimeType);
    }

    /**
     * 批量删除加班类型
     * 
     * @param overtimeTypeIds 需要删除的加班类型主键
     * @return 结果
     */
    @Override
    public int deleteHrOvertimeTypeByOvertimeTypeIds(Long[] overtimeTypeIds)
    {
        return hrOvertimeTypeMapper.deleteHrOvertimeTypeByOvertimeTypeIds(overtimeTypeIds);
    }

    /**
     * 删除加班类型信息
     * 
     * @param overtimeTypeId 加班类型主键
     * @return 结果
     */
    @Override
    public int deleteHrOvertimeTypeByOvertimeTypeId(Long overtimeTypeId)
    {
        return hrOvertimeTypeMapper.deleteHrOvertimeTypeByOvertimeTypeId(overtimeTypeId);
    }
}
