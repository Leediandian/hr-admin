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
import com.ruoyi.hr.domain.HrAdjustSalary;
import com.ruoyi.hr.service.IHrAdjustSalaryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 员工调薪Controller
 * 
 * @author diandian
 * @date 2023-02-13
 */
@RestController
@RequestMapping("/hr/adjustSalary")
public class HrAdjustSalaryController extends BaseController
{
    @Autowired
    private IHrAdjustSalaryService hrAdjustSalaryService;

    /**
     * 查询员工调薪列表
     */
    @PreAuthorize("@ss.hasPermi('hr:adjustSalary:list')")
    @GetMapping("/list")
    public TableDataInfo list(HrAdjustSalary hrAdjustSalary)
    {
        startPage();
        List<HrAdjustSalary> list = hrAdjustSalaryService.selectHrAdjustSalaryList(hrAdjustSalary);
        return getDataTable(list);
    }

    /**
     * 导出员工调薪列表
     */
    @PreAuthorize("@ss.hasPermi('hr:adjustSalary:export')")
    @Log(title = "员工调薪", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HrAdjustSalary hrAdjustSalary)
    {
        List<HrAdjustSalary> list = hrAdjustSalaryService.selectHrAdjustSalaryList(hrAdjustSalary);
        ExcelUtil<HrAdjustSalary> util = new ExcelUtil<HrAdjustSalary>(HrAdjustSalary.class);
        util.exportExcel(response, list, "员工调薪数据");
    }

    /**
     * 获取员工调薪详细信息
     */
    @PreAuthorize("@ss.hasPermi('hr:adjustSalary:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hrAdjustSalaryService.selectHrAdjustSalaryById(id));
    }

    /**
     * 新增员工调薪
     */
    @PreAuthorize("@ss.hasPermi('hr:adjustSalary:add')")
    @Log(title = "员工调薪", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HrAdjustSalary hrAdjustSalary)
    {
        return toAjax(hrAdjustSalaryService.insertHrAdjustSalary(hrAdjustSalary));
    }

    /**
     * 修改员工调薪
     */
    @PreAuthorize("@ss.hasPermi('hr:adjustSalary:edit')")
    @Log(title = "员工调薪", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HrAdjustSalary hrAdjustSalary)
    {
        return toAjax(hrAdjustSalaryService.updateHrAdjustSalary(hrAdjustSalary));
    }

    /**
     * 删除员工调薪
     */
    @PreAuthorize("@ss.hasPermi('hr:adjustSalary:remove')")
    @Log(title = "员工调薪", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hrAdjustSalaryService.deleteHrAdjustSalaryByIds(ids));
    }
}
