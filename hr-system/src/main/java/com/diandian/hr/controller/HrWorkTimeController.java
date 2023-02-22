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
import com.diandian.hr.domain.HrWorkTime;
import com.diandian.hr.service.IHrWorkTimeService;
import com.diandian.common.utils.poi.ExcelUtil;
import com.diandian.common.core.page.TableDataInfo;

/**
 * 工作时间管理Controller
 * 
 * @author 点点
 * @date 2023-02-13
 */
@RestController
@RequestMapping("/hr/workTime")
public class HrWorkTimeController extends BaseController
{
    @Autowired
    private IHrWorkTimeService hrWorkTimeService;

    /**
     * 查询工作时间管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:workTime:list')")
    @GetMapping("/list")
    public TableDataInfo list(HrWorkTime hrWorkTime)
    {
        startPage();
        List<HrWorkTime> list = hrWorkTimeService.selectHrWorkTimeList(hrWorkTime);
        return getDataTable(list);
    }

    /**
     * 导出工作时间管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:workTime:export')")
    @Log(title = "工作时间管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HrWorkTime hrWorkTime)
    {
        List<HrWorkTime> list = hrWorkTimeService.selectHrWorkTimeList(hrWorkTime);
        ExcelUtil<HrWorkTime> util = new ExcelUtil<HrWorkTime>(HrWorkTime.class);
        util.exportExcel(response, list, "工作时间管理数据");
    }

    /**
     * 获取工作时间管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hr:workTime:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hrWorkTimeService.selectHrWorkTimeById(id));
    }

    /**
     * 新增工作时间管理
     */
    @PreAuthorize("@ss.hasPermi('hr:workTime:add')")
    @Log(title = "工作时间管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HrWorkTime hrWorkTime)
    {
        return toAjax(hrWorkTimeService.insertHrWorkTime(hrWorkTime));
    }

    /**
     * 修改工作时间管理
     */
    @PreAuthorize("@ss.hasPermi('hr:workTime:edit')")
    @Log(title = "工作时间管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HrWorkTime hrWorkTime)
    {
        return toAjax(hrWorkTimeService.updateHrWorkTime(hrWorkTime));
    }

    /**
     * 删除工作时间管理
     */
    @PreAuthorize("@ss.hasPermi('hr:workTime:remove')")
    @Log(title = "工作时间管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hrWorkTimeService.deleteHrWorkTimeByIds(ids));
    }
}
