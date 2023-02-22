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
import com.diandian.hr.domain.HrOvertimeType;
import com.diandian.hr.service.IHrOvertimeTypeService;
import com.diandian.common.utils.poi.ExcelUtil;
import com.diandian.common.core.page.TableDataInfo;

/**
 * 加班类型Controller
 * 
 * @author 点点
 * @date 2023-02-13
 */
@RestController
@RequestMapping("/hr/overtimeType")
public class HrOvertimeTypeController extends BaseController
{
    @Autowired
    private IHrOvertimeTypeService hrOvertimeTypeService;

    /**
     * 查询全部加班类型列表
     */
    @PreAuthorize("@ss.hasPermi('hr:overtimeType:allList')")
    @GetMapping("/allList")
    public AjaxResult allList(HrOvertimeType hrOvertimeType)
    {
        List<HrOvertimeType> list = hrOvertimeTypeService.selectHrOvertimeTypeList(hrOvertimeType);
        return success(list);
    }

    /**
     * 查询加班类型列表
     */
    @PreAuthorize("@ss.hasPermi('hr:overtimeType:list')")
    @GetMapping("/list")
    public TableDataInfo list(HrOvertimeType hrOvertimeType)
    {
        startPage();
        List<HrOvertimeType> list = hrOvertimeTypeService.selectHrOvertimeTypeList(hrOvertimeType);
        return getDataTable(list);
    }

    /**
     * 导出加班类型列表
     */
    @PreAuthorize("@ss.hasPermi('hr:overtimeType:export')")
    @Log(title = "加班类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HrOvertimeType hrOvertimeType)
    {
        List<HrOvertimeType> list = hrOvertimeTypeService.selectHrOvertimeTypeList(hrOvertimeType);
        ExcelUtil<HrOvertimeType> util = new ExcelUtil<HrOvertimeType>(HrOvertimeType.class);
        util.exportExcel(response, list, "加班类型数据");
    }

    /**
     * 获取加班类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('hr:overtimeType:query')")
    @GetMapping(value = "/{overtimeTypeId}")
    public AjaxResult getInfo(@PathVariable("overtimeTypeId") Long overtimeTypeId)
    {
        return success(hrOvertimeTypeService.selectHrOvertimeTypeByOvertimeTypeId(overtimeTypeId));
    }

    /**
     * 新增加班类型
     */
    @PreAuthorize("@ss.hasPermi('hr:overtimeType:add')")
    @Log(title = "加班类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HrOvertimeType hrOvertimeType)
    {
        return toAjax(hrOvertimeTypeService.insertHrOvertimeType(hrOvertimeType));
    }

    /**
     * 修改加班类型
     */
    @PreAuthorize("@ss.hasPermi('hr:overtimeType:edit')")
    @Log(title = "加班类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HrOvertimeType hrOvertimeType)
    {
        return toAjax(hrOvertimeTypeService.updateHrOvertimeType(hrOvertimeType));
    }

    /**
     * 删除加班类型
     */
    @PreAuthorize("@ss.hasPermi('hr:overtimeType:remove')")
    @Log(title = "加班类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{overtimeTypeIds}")
    public AjaxResult remove(@PathVariable Long[] overtimeTypeIds)
    {
        return toAjax(hrOvertimeTypeService.deleteHrOvertimeTypeByOvertimeTypeIds(overtimeTypeIds));
    }
}
