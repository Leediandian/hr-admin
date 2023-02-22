package com.diandian.hr.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.diandian.common.annotation.Log;
import com.diandian.common.core.controller.BaseController;
import com.diandian.common.core.domain.AjaxResult;
import com.diandian.common.enums.BusinessType;
import com.diandian.hr.domain.HrLeave;
import com.diandian.hr.service.IHrLeaveService;
import com.diandian.common.utils.poi.ExcelUtil;
import com.diandian.common.core.page.TableDataInfo;

/**
 * 请假审批管理Controller
 *
 * @author 点点
 * @date 2023-02-21
 */
@RestController
@RequestMapping("/hr/leave")
public class HrLeaveController extends BaseController
{
    @Autowired
    private IHrLeaveService hrLeaveService;

    /**
     * 查询请假审批管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:leave:list')")
    @GetMapping("/list")
    public TableDataInfo list(HrLeave hrLeave)
    {
        startPage();
        List<HrLeave> list = hrLeaveService.selectHrLeaveList(hrLeave);
        return getDataTable(list);
    }

    /**
     * 导出请假审批管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:leave:export')")
    @Log(title = "请假审批管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HrLeave hrLeave)
    {
        List<HrLeave> list = hrLeaveService.selectHrLeaveList(hrLeave);
        ExcelUtil<HrLeave> util = new ExcelUtil<HrLeave>(HrLeave.class);
        util.exportExcel(response, list, "请假审批管理数据");
    }

    /**
     * 获取请假审批管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hr:leave:query')")
    @GetMapping(value = "/{leaveId}")
    public AjaxResult getInfo(@PathVariable("leaveId") Long leaveId)
    {
        return success(hrLeaveService.selectHrLeaveByLeaveId(leaveId));
    }

    /**
     * 新增请假审批管理
     */
    @PreAuthorize("@ss.hasPermi('hr:leave:add')")
    @Log(title = "请假审批管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HrLeave hrLeave)
    {
        return toAjax(hrLeaveService.insertHrLeave(hrLeave));
    }

    /**
     * 修改请假审批管理
     */
    @PreAuthorize("@ss.hasPermi('hr:leave:edit')")
    @Log(title = "请假审批管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HrLeave hrLeave)
    {
        return toAjax(hrLeaveService.updateHrLeave(hrLeave));
    }

    /**
     * 删除请假审批管理
     */
    @PreAuthorize("@ss.hasPermi('hr:leave:remove')")
    @Log(title = "请假审批管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{leaveIds}")
    public AjaxResult remove(@PathVariable Long[] leaveIds)
    {
        return toAjax(hrLeaveService.deleteHrLeaveByLeaveIds(leaveIds));
    }
}
