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
import com.diandian.hr.domain.HrOvertime;
import com.diandian.hr.service.IHrOvertimeService;
import com.diandian.common.utils.poi.ExcelUtil;
import com.diandian.common.core.page.TableDataInfo;

/**
 * 员工加班管理Controller
 * 
 * @author 点点
 * @date 2023-02-13
 */
@RestController
@RequestMapping("/hr/overtime")
public class HrOvertimeController extends BaseController
{
    @Autowired
    private IHrOvertimeService hrOvertimeService;

    /**
     * 查询员工加班管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:overtime:list')")
    @GetMapping("/list")
    public TableDataInfo list(HrOvertime hrOvertime)
    {
        startPage();
        List<HrOvertime> list = hrOvertimeService.selectHrOvertimeList(hrOvertime);
        return getDataTable(list);
    }

    /**
     * 导出员工加班管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:overtime:export')")
    @Log(title = "员工加班管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HrOvertime hrOvertime)
    {
        List<HrOvertime> list = hrOvertimeService.selectHrOvertimeList(hrOvertime);
        ExcelUtil<HrOvertime> util = new ExcelUtil<HrOvertime>(HrOvertime.class);
        util.exportExcel(response, list, "员工加班管理数据");
    }

    /**
     * 获取员工加班管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hr:overtime:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hrOvertimeService.selectHrOvertimeById(id));
    }

    /**
     * 新增员工加班管理
     */
    @PreAuthorize("@ss.hasPermi('hr:overtime:add')")
    @Log(title = "员工加班管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HrOvertime hrOvertime)
    {
        return toAjax(hrOvertimeService.insertHrOvertime(hrOvertime));
    }

    /**
     * 修改员工加班管理
     */
    @PreAuthorize("@ss.hasPermi('hr:overtime:edit')")
    @Log(title = "员工加班管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HrOvertime hrOvertime)
    {
        return toAjax(hrOvertimeService.updateHrOvertime(hrOvertime));
    }

    /**
     * 删除员工加班管理
     */
    @PreAuthorize("@ss.hasPermi('hr:overtime:remove')")
    @Log(title = "员工加班管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hrOvertimeService.deleteHrOvertimeByIds(ids));
    }
}
