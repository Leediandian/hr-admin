package com.ruoyi.hr.controller;

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
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.hr.domain.HrSalary;
import com.ruoyi.hr.service.IHrSalaryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 薪资账套管理Controller
 * 
 * @author ruoyi
 * @date 2023-02-13
 */
@RestController
@RequestMapping("/hr/salary")
public class HrSalaryController extends BaseController
{
    @Autowired
    private IHrSalaryService hrSalaryService;

    /**
     * 查询薪资账套管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:salary:list')")
    @GetMapping("/list")
    public TableDataInfo list(HrSalary hrSalary)
    {
        startPage();
        List<HrSalary> list = hrSalaryService.selectHrSalaryList(hrSalary);
        return getDataTable(list);
    }

    /**
     * 导出薪资账套管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:salary:export')")
    @Log(title = "薪资账套管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HrSalary hrSalary)
    {
        List<HrSalary> list = hrSalaryService.selectHrSalaryList(hrSalary);
        ExcelUtil<HrSalary> util = new ExcelUtil<HrSalary>(HrSalary.class);
        util.exportExcel(response, list, "薪资账套管理数据");
    }

    /**
     * 获取薪资账套管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hr:salary:query')")
    @GetMapping(value = "/{salaryId}")
    public AjaxResult getInfo(@PathVariable("salaryId") Long salaryId)
    {
        return success(hrSalaryService.selectHrSalaryBySalaryId(salaryId));
    }

    /**
     * 新增薪资账套管理
     */
    @PreAuthorize("@ss.hasPermi('hr:salary:add')")
    @Log(title = "薪资账套管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HrSalary hrSalary)
    {
        return toAjax(hrSalaryService.insertHrSalary(hrSalary));
    }

    /**
     * 修改薪资账套管理
     */
    @PreAuthorize("@ss.hasPermi('hr:salary:edit')")
    @Log(title = "薪资账套管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HrSalary hrSalary)
    {
        return toAjax(hrSalaryService.updateHrSalary(hrSalary));
    }

    /**
     * 删除薪资账套管理
     */
    @PreAuthorize("@ss.hasPermi('hr:salary:remove')")
    @Log(title = "薪资账套管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{salaryIds}")
    public AjaxResult remove(@PathVariable Long[] salaryIds)
    {
        return toAjax(hrSalaryService.deleteHrSalaryBySalaryIds(salaryIds));
    }
}
