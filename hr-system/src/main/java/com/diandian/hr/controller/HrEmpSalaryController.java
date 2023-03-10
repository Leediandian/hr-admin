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
import com.diandian.hr.domain.HrEmpSalary;
import com.diandian.hr.service.IHrEmpSalaryService;
import com.diandian.common.utils.poi.ExcelUtil;
import com.diandian.common.core.page.TableDataInfo;

/**
 * 员工账套管理Controller
 * 
 * @author 点点
 * @date 2023-02-13
 */
@RestController
@RequestMapping("/hr/empSalary")
public class HrEmpSalaryController extends BaseController
{
    @Autowired
    private IHrEmpSalaryService hrEmpSalaryService;

    /**
     * 查询员工账套管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:empSalary:list')")
    @GetMapping("/list")
    public TableDataInfo list(HrEmpSalary hrEmpSalary)
    {
        startPage();
        List<HrEmpSalary> list = hrEmpSalaryService.selectHrEmpSalaryList(hrEmpSalary);
        return getDataTable(list);
    }

    /**
     * 导出员工账套管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:empSalary:export')")
    @Log(title = "员工账套管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HrEmpSalary hrEmpSalary)
    {
        List<HrEmpSalary> list = hrEmpSalaryService.selectHrEmpSalaryList(hrEmpSalary);
        ExcelUtil<HrEmpSalary> util = new ExcelUtil<HrEmpSalary>(HrEmpSalary.class);
        util.exportExcel(response, list, "员工账套管理数据");
    }

    /**
     * 获取员工账套管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hr:empSalary:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hrEmpSalaryService.selectHrEmpSalaryById(id));
    }

    /**
     * 新增员工账套管理
     */
    @PreAuthorize("@ss.hasPermi('hr:empSalary:add')")
    @Log(title = "员工账套管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HrEmpSalary hrEmpSalary)
    {
        HrEmpSalary item = new HrEmpSalary();
        item.setEmployeeId(hrEmpSalary.getEmployeeId());
        List<HrEmpSalary> list = hrEmpSalaryService.selectHrEmpSalaryList(item);
        if(list.size()>0){
            return error("当前员工"+hrEmpSalary.getEmployeeName()+"已绑定薪资账套");
        }
        return toAjax(hrEmpSalaryService.insertHrEmpSalary(hrEmpSalary));
    }

    /**
     * 修改员工账套管理
     */
    @PreAuthorize("@ss.hasPermi('hr:empSalary:edit')")
    @Log(title = "员工账套管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HrEmpSalary hrEmpSalary)
    {
        return toAjax(hrEmpSalaryService.updateHrEmpSalary(hrEmpSalary));
    }

    /**
     * 删除员工账套管理
     */
    @PreAuthorize("@ss.hasPermi('hr:empSalary:remove')")
    @Log(title = "员工账套管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hrEmpSalaryService.deleteHrEmpSalaryByIds(ids));
    }
}
