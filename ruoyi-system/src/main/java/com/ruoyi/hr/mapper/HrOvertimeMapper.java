package com.ruoyi.hr.mapper;

import java.util.List;
import com.ruoyi.hr.domain.HrOvertime;
import com.ruoyi.hr.domain.HrEmployee;

/**
 * 员工加班管理Mapper接口
 * 
 * @author 点点
 * @date 2023-02-13
 */
public interface HrOvertimeMapper 
{
    /**
     * 查询员工加班管理
     * 
     * @param id 员工加班管理主键
     * @return 员工加班管理
     */
    public HrOvertime selectHrOvertimeById(Long id);

    /**
     * 查询员工加班管理列表
     * 
     * @param hrOvertime 员工加班管理
     * @return 员工加班管理集合
     */
    public List<HrOvertime> selectHrOvertimeList(HrOvertime hrOvertime);

    /**
     * 新增员工加班管理
     * 
     * @param hrOvertime 员工加班管理
     * @return 结果
     */
    public int insertHrOvertime(HrOvertime hrOvertime);

    /**
     * 修改员工加班管理
     * 
     * @param hrOvertime 员工加班管理
     * @return 结果
     */
    public int updateHrOvertime(HrOvertime hrOvertime);

    /**
     * 删除员工加班管理
     * 
     * @param id 员工加班管理主键
     * @return 结果
     */
    public int deleteHrOvertimeById(Long id);

    /**
     * 批量删除员工加班管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHrOvertimeByIds(Long[] ids);




}
