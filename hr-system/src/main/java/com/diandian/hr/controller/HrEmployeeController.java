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
import com.diandian.hr.domain.HrEmployee;
import com.diandian.hr.service.IHrEmployeeService;
import com.diandian.common.utils.poi.ExcelUtil;
import com.diandian.common.core.page.TableDataInfo;

/**
 * 员工档案管理Controller
 * 
 * @author diandian
 * @date 2023-02-13
 */
@RestController
@RequestMapping("/hr/employee")
public class HrEmployeeController extends BaseController
{
    @Autowired
    private IHrEmployeeService hrEmployeeService;

    /**
     * 查询员工档案管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:employee:list')")
    @GetMapping("/list")
    public TableDataInfo list(HrEmployee hrEmployee)
    {
        startPage();
        List<HrEmployee> list = hrEmployeeService.selectHrEmployeeList(hrEmployee);
        return getDataTable(list);
    }

    /**
     * 导出员工档案管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:employee:export')")
    @Log(title = "员工档案管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HrEmployee hrEmployee)
    {
        List<HrEmployee> list = hrEmployeeService.selectHrEmployeeList(hrEmployee);
        ExcelUtil<HrEmployee> util = new ExcelUtil<HrEmployee>(HrEmployee.class);
        util.exportExcel(response, list, "员工档案管理数据");
    }

    /**
     * 获取员工档案管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hr:employee:query')")
    @GetMapping(value = "/{employeeId}")
    public AjaxResult getInfo(@PathVariable("employeeId") Long employeeId)
    {
        return success(hrEmployeeService.selectHrEmployeeByEmployeeId(employeeId));
    }

    /**
     * 新增员工档案管理
     */
    @PreAuthorize("@ss.hasPermi('hr:employee:add')")
    @Log(title = "员工档案管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HrEmployee hrEmployee)
    {
        return hrEmployeeService.insertHrEmployee(hrEmployee);
    }

    /**
     * 修改员工档案管理
     */
    @PreAuthorize("@ss.hasPermi('hr:employee:edit')")
    @Log(title = "员工档案管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HrEmployee hrEmployee)
    {
        return toAjax(hrEmployeeService.updateHrEmployee(hrEmployee));
    }

    /**
     * 删除员工档案管理
     */
    @PreAuthorize("@ss.hasPermi('hr:employee:remove')")
    @Log(title = "员工档案管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{employeeIds}")
    public AjaxResult remove(@PathVariable Long[] employeeIds)
    {
        return toAjax(hrEmployeeService.deleteHrEmployeeByEmployeeIds(employeeIds));
    }
}
