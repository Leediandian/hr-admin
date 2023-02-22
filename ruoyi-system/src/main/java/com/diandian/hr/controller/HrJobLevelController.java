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
import com.diandian.hr.domain.HrJobLevel;
import com.diandian.hr.service.IHrJobLevelService;
import com.diandian.common.utils.poi.ExcelUtil;
import com.diandian.common.core.page.TableDataInfo;

/**
 * 职称管理Controller
 * 
 * @author 点点
 * @date 2023-02-13
 */
@RestController
@RequestMapping("/hr/jobLevel")
public class HrJobLevelController extends BaseController
{
    @Autowired
    private IHrJobLevelService hrJobLevelService;

    /**
     * 查询全部职称管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:jobLevel:allList')")
    @GetMapping("/allList")
    public AjaxResult allList(HrJobLevel hrJobLevel)
    {
        List<HrJobLevel> list = hrJobLevelService.selectHrJobLevelList(hrJobLevel);
        return success(list);
    }

    /**
     * 查询职称管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:jobLevel:list')")
    @GetMapping("/list")
    public TableDataInfo list(HrJobLevel hrJobLevel)
    {
        startPage();
        List<HrJobLevel> list = hrJobLevelService.selectHrJobLevelList(hrJobLevel);
        return getDataTable(list);
    }

    /**
     * 导出职称管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:jobLevel:export')")
    @Log(title = "职称管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HrJobLevel hrJobLevel)
    {
        List<HrJobLevel> list = hrJobLevelService.selectHrJobLevelList(hrJobLevel);
        ExcelUtil<HrJobLevel> util = new ExcelUtil<HrJobLevel>(HrJobLevel.class);
        util.exportExcel(response, list, "职称管理数据");
    }

    /**
     * 获取职称管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hr:jobLevel:query')")
    @GetMapping(value = "/{jobLevelId}")
    public AjaxResult getInfo(@PathVariable("jobLevelId") Long jobLevelId)
    {
        return success(hrJobLevelService.selectHrJobLevelByJobLevelId(jobLevelId));
    }

    /**
     * 新增职称管理
     */
    @PreAuthorize("@ss.hasPermi('hr:jobLevel:add')")
    @Log(title = "职称管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HrJobLevel hrJobLevel)
    {
        return toAjax(hrJobLevelService.insertHrJobLevel(hrJobLevel));
    }

    /**
     * 修改职称管理
     */
    @PreAuthorize("@ss.hasPermi('hr:jobLevel:edit')")
    @Log(title = "职称管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HrJobLevel hrJobLevel)
    {
        return toAjax(hrJobLevelService.updateHrJobLevel(hrJobLevel));
    }

    /**
     * 删除职称管理
     */
    @PreAuthorize("@ss.hasPermi('hr:jobLevel:remove')")
    @Log(title = "职称管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{jobLevelIds}")
    public AjaxResult remove(@PathVariable Long[] jobLevelIds)
    {
        return toAjax(hrJobLevelService.deleteHrJobLevelByJobLevelIds(jobLevelIds));
    }
}
