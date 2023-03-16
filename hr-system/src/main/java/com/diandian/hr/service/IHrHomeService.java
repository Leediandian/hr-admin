package com.diandian.hr.service;

import com.diandian.common.core.domain.AjaxResult;


/**
 * 首页可视化Service接口
 *
 * @author diandian
 * @date 2023-02-13
 */
public interface IHrHomeService {

    /**
     * 通过工号获取员工的当月考勤信息
     * @param wodkId
     * @param month
     * @return
     */
    AjaxResult getAttendanceData(String wodkId, String month);

    /**
     * 获取公司所有部门情况
     * @return
     */
    AjaxResult getDepartmentData();

    /**
     * 统计员工总数/用户总数
     * @return
     */
    AjaxResult getCountData() throws Exception;
}
