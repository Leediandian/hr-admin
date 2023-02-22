package com.diandian.hr.service;

import java.util.List;
import com.diandian.hr.domain.HrEmployeeRemove;

/**
 * 员工调动Service接口
 *
 * @author diandian
 * @date 2023-02-19
 */
public interface IHrEmployeeRemoveService
{
    /**
     * 查询员工调动
     *
     * @param id 员工调动主键
     * @return 员工调动
     */
    public HrEmployeeRemove selectHrEmployeeRemoveById(Long id);

    /**
     * 查询员工调动列表
     *
     * @param hrEmployeeRemove 员工调动
     * @return 员工调动集合
     */
    public List<HrEmployeeRemove> selectHrEmployeeRemoveList(HrEmployeeRemove hrEmployeeRemove);

    /**
     * 新增员工调动
     *
     * @param hrEmployeeRemove 员工调动
     * @return 结果
     */
    public int insertHrEmployeeRemove(HrEmployeeRemove hrEmployeeRemove);

    /**
     * 修改员工调动
     *
     * @param hrEmployeeRemove 员工调动
     * @return 结果
     */
    public int updateHrEmployeeRemove(HrEmployeeRemove hrEmployeeRemove);

    /**
     * 批量删除员工调动
     *
     * @param ids 需要删除的员工调动主键集合
     * @return 结果
     */
    public int deleteHrEmployeeRemoveByIds(Long[] ids);

    /**
     * 删除员工调动信息
     *
     * @param id 员工调动主键
     * @return 结果
     */
    public int deleteHrEmployeeRemoveById(Long id);
}
