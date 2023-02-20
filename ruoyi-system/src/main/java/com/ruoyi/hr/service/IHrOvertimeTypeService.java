package com.ruoyi.hr.service;

import java.util.List;
import com.ruoyi.hr.domain.HrOvertimeType;

/**
 * 加班类型Service接口
 * 
 * @author 点点
 * @date 2023-02-13
 */
public interface IHrOvertimeTypeService 
{
    /**
     * 查询加班类型
     * 
     * @param overtimeTypeId 加班类型主键
     * @return 加班类型
     */
    public HrOvertimeType selectHrOvertimeTypeByOvertimeTypeId(Long overtimeTypeId);

    /**
     * 查询加班类型列表
     * 
     * @param hrOvertimeType 加班类型
     * @return 加班类型集合
     */
    public List<HrOvertimeType> selectHrOvertimeTypeList(HrOvertimeType hrOvertimeType);

    /**
     * 新增加班类型
     * 
     * @param hrOvertimeType 加班类型
     * @return 结果
     */
    public int insertHrOvertimeType(HrOvertimeType hrOvertimeType);

    /**
     * 修改加班类型
     * 
     * @param hrOvertimeType 加班类型
     * @return 结果
     */
    public int updateHrOvertimeType(HrOvertimeType hrOvertimeType);

    /**
     * 批量删除加班类型
     * 
     * @param overtimeTypeIds 需要删除的加班类型主键集合
     * @return 结果
     */
    public int deleteHrOvertimeTypeByOvertimeTypeIds(Long[] overtimeTypeIds);

    /**
     * 删除加班类型信息
     * 
     * @param overtimeTypeId 加班类型主键
     * @return 结果
     */
    public int deleteHrOvertimeTypeByOvertimeTypeId(Long overtimeTypeId);
}
