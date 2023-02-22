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
import com.diandian.hr.domain.HrEmployeeRemove;
import com.diandian.hr.service.IHrEmployeeRemoveService;
import com.diandian.common.utils.poi.ExcelUtil;
import com.diandian.common.core.page.TableDataInfo;

/**
 * 员工调动Controller
 *
 * @author diandian
 * @date 2023-02-19
 */
@RestController
@RequestMapping("/hr/employeeRemove")
public class HrEmployeeRemoveController extends BaseController
{
    @Autowired
    private IHrEmployeeRemoveService hrEmployeeRemoveService;

    /**
     * 查询员工调动列表
     */
    @PreAuthorize("@ss.hasPermi('hr:employeeRemove:list')")
    @GetMapping("/list")
    public TableDataInfo list(HrEmployeeRemove hrEmployeeRemove)
    {
        startPage();
        List<HrEmployeeRemove> list = hrEmployeeRemoveService.selectHrEmployeeRemoveList(hrEmployeeRemove);
        return getDataTable(list);
    }

    /**
     * 导出员工调动列表
     */
    @PreAuthorize("@ss.hasPermi('hr:employeeRemove:export')")
    @Log(title = "员工调动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HrEmployeeRemove hrEmployeeRemove)
    {
        List<HrEmployeeRemove> list = hrEmployeeRemoveService.selectHrEmployeeRemoveList(hrEmployeeRemove);
        ExcelUtil<HrEmployeeRemove> util = new ExcelUtil<HrEmployeeRemove>(HrEmployeeRemove.class);
        util.exportExcel(response, list, "员工调动数据");
    }

    /**
     * 获取员工调动详细信息
     */
    @PreAuthorize("@ss.hasPermi('hr:employeeRemove:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hrEmployeeRemoveService.selectHrEmployeeRemoveById(id));
    }

    /**
     * 新增员工调动
     */
    @PreAuthorize("@ss.hasPermi('hr:employeeRemove:add')")
    @Log(title = "员工调动", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HrEmployeeRemove hrEmployeeRemove)
    {
        return toAjax(hrEmployeeRemoveService.insertHrEmployeeRemove(hrEmployeeRemove));
    }

    /**
     * 修改员工调动
     */
    @PreAuthorize("@ss.hasPermi('hr:employeeRemove:edit')")
    @Log(title = "员工调动", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HrEmployeeRemove hrEmployeeRemove)
    {
        return toAjax(hrEmployeeRemoveService.updateHrEmployeeRemove(hrEmployeeRemove));
    }

    /**
     * 删除员工调动
     */
    @PreAuthorize("@ss.hasPermi('hr:employeeRemove:remove')")
    @Log(title = "员工调动", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hrEmployeeRemoveService.deleteHrEmployeeRemoveByIds(ids));
    }
}
