package com.diandian.hr.controller;


import com.diandian.common.core.controller.BaseController;
import com.diandian.common.core.domain.AjaxResult;
import com.diandian.hr.domain.vo.HrAttendanceMonthVo;
import com.diandian.hr.service.IHrHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 首页可视化管理Controller
 * 
 * @author diandian
 * @date 2023-02-13
 */
@RestController
@RequestMapping("/hr/home")
public class HrHomeController extends BaseController
{
    @Autowired
    private IHrHomeService hrHomeService;

    /**
     * 通过工号获取员工的当月考勤信息
     * @param workId
     * @param month
     * @return
     */
    @GetMapping("/attendance")
    public AjaxResult getAttendanceData(@RequestParam String workId,  String month) {
        return hrHomeService.getAttendanceData(workId, month);
    }

    /**
     * 获取公司所有部门情况
     * @return
     */
    @GetMapping("/department")
    public AjaxResult getDepartmentData() {
        return hrHomeService.getDepartmentData();
    }

    /**
     * 统计员工总数/用户总数
     * @return
     */
    @GetMapping("/count")
    public AjaxResult getCountData() throws Exception {
        return hrHomeService.getCountData();
    }


}
