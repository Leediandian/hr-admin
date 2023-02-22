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
import com.diandian.hr.domain.HrAttendance;
import com.diandian.hr.service.IHrAttendanceService;
import com.diandian.common.utils.poi.ExcelUtil;
import com.diandian.common.core.page.TableDataInfo;

/**
 * 员工考勤管理Controller
 * 
 * @author diandian
 * @date 2023-02-13
 */
@RestController
@RequestMapping("/hr/attendance")
public class HrAttendanceController extends BaseController
{
    @Autowired
    private IHrAttendanceService hrAttendanceService;

    /**
     * 查询员工考勤管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:attendance:list')")
    @GetMapping("/list")
    public TableDataInfo list(HrAttendance hrAttendance)
    {
        startPage();
        List<HrAttendance> list = hrAttendanceService.selectHrAttendanceList(hrAttendance);
        return getDataTable(list);
    }

    /**
     * 导出员工考勤管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:attendance:export')")
    @Log(title = "员工考勤管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HrAttendance hrAttendance)
    {
        List<HrAttendance> list = hrAttendanceService.selectHrAttendanceList(hrAttendance);
        ExcelUtil<HrAttendance> util = new ExcelUtil<HrAttendance>(HrAttendance.class);
        util.exportExcel(response, list, "员工考勤管理数据");
    }

    /**
     * 获取员工考勤管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hr:attendance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hrAttendanceService.selectHrAttendanceById(id));
    }

    /**
     * 新增员工考勤管理
     */
    @PreAuthorize("@ss.hasPermi('hr:attendance:add')")
    @Log(title = "员工考勤管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HrAttendance hrAttendance)
    {
        return toAjax(hrAttendanceService.insertHrAttendance(hrAttendance));
    }

    /**
     * 修改员工考勤管理
     */
    @PreAuthorize("@ss.hasPermi('hr:attendance:edit')")
    @Log(title = "员工考勤管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HrAttendance hrAttendance)
    {
        return toAjax(hrAttendanceService.updateHrAttendance(hrAttendance));
    }

    /**
     * 删除员工考勤管理
     */
    @PreAuthorize("@ss.hasPermi('hr:attendance:remove')")
    @Log(title = "员工考勤管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hrAttendanceService.deleteHrAttendanceByIds(ids));
    }
}
