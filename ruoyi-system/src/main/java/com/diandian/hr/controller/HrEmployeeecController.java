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
import com.diandian.hr.domain.HrEmployeeec;
import com.diandian.hr.service.IHrEmployeeecService;
import com.diandian.common.utils.poi.ExcelUtil;
import com.diandian.common.core.page.TableDataInfo;

/**
 * 员工奖惩管理Controller
 * 
 * @author 点点
 * @date 2023-02-13
 */
@RestController
@RequestMapping("/hr/employeeec")
public class HrEmployeeecController extends BaseController
{
    @Autowired
    private IHrEmployeeecService hrEmployeeecService;

    /**
     * 查询员工奖惩管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:employeeec:list')")
    @GetMapping("/list")
    public TableDataInfo list(HrEmployeeec hrEmployeeec)
    {
        startPage();
        List<HrEmployeeec> list = hrEmployeeecService.selectHrEmployeeecList(hrEmployeeec);
        return getDataTable(list);
    }

    /**
     * 导出员工奖惩管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:employeeec:export')")
    @Log(title = "员工奖惩管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HrEmployeeec hrEmployeeec)
    {
        List<HrEmployeeec> list = hrEmployeeecService.selectHrEmployeeecList(hrEmployeeec);
        ExcelUtil<HrEmployeeec> util = new ExcelUtil<HrEmployeeec>(HrEmployeeec.class);
        util.exportExcel(response, list, "员工奖惩管理数据");
    }

    /**
     * 获取员工奖惩管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hr:employeeec:query')")
    @GetMapping(value = "/{employeeecId}")
    public AjaxResult getInfo(@PathVariable("employeeecId") Long employeeecId)
    {
        return success(hrEmployeeecService.selectHrEmployeeecByEmployeeecId(employeeecId));
    }

    /**
     * 新增员工奖惩管理
     */
    @PreAuthorize("@ss.hasPermi('hr:employeeec:add')")
    @Log(title = "员工奖惩管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HrEmployeeec hrEmployeeec)
    {
        return toAjax(hrEmployeeecService.insertHrEmployeeec(hrEmployeeec));
    }

    /**
     * 修改员工奖惩管理
     */
    @PreAuthorize("@ss.hasPermi('hr:employeeec:edit')")
    @Log(title = "员工奖惩管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HrEmployeeec hrEmployeeec)
    {
        return toAjax(hrEmployeeecService.updateHrEmployeeec(hrEmployeeec));
    }

    /**
     * 删除员工奖惩管理
     */
    @PreAuthorize("@ss.hasPermi('hr:employeeec:remove')")
    @Log(title = "员工奖惩管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{employeeecIds}")
    public AjaxResult remove(@PathVariable Long[] employeeecIds)
    {
        return toAjax(hrEmployeeecService.deleteHrEmployeeecByEmployeeecIds(employeeecIds));
    }
}
