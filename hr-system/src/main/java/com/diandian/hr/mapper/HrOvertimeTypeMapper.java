package com.diandian.hr.mapper;

import java.util.List;
import com.diandian.hr.domain.HrOvertimeType;

/**
 * 加班类型Mapper接口
 * 
 * @author 点点
 * @date 2023-02-13
 */
public interface HrOvertimeTypeMapper 
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
     * 删除加班类型
     * 
     * @param overtimeTypeId 加班类型主键
     * @return 结果
     */
    public int deleteHrOvertimeTypeByOvertimeTypeId(Long overtimeTypeId);

    /**
     * 批量删除加班类型
     * 
     * @param overtimeTypeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHrOvertimeTypeByOvertimeTypeIds(Long[] overtimeTypeIds);
}
