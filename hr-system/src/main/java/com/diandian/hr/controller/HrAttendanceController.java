package com.diandian.hr.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.core.date.DateUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.SyncReadListener;
import com.diandian.common.config.HrConfig;
import com.diandian.common.exception.file.InvalidExtensionException;
import com.diandian.common.utils.file.FileUploadUtils;
import com.diandian.common.utils.file.MimeTypeUtils;
import com.diandian.hr.domain.vo.HrAttendanceMonthVo;
import com.diandian.hr.domain.vo.HrAttendanceVo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.diandian.common.annotation.Log;
import com.diandian.common.core.controller.BaseController;
import com.diandian.common.core.domain.AjaxResult;
import com.diandian.common.enums.BusinessType;
import com.diandian.hr.domain.HrAttendance;
import com.diandian.hr.service.IHrAttendanceService;
import com.diandian.common.utils.poi.ExcelUtil;
import com.diandian.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 员工考勤管理Controller
 * 
 * @author diandian
 * @date 2023-02-13
 */
@RestController
@RequestMapping("/hr/attendance")
public class HrAttendanceController extends BaseController
{
    @Autowired
    private IHrAttendanceService hrAttendanceService;

    /**
     * 查询员工考勤管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:attendance:list')")
    @GetMapping("/list")
    public TableDataInfo list(HrAttendance hrAttendance)
    {
        startPage();
        List<HrAttendance> list = hrAttendanceService.selectHrAttendanceList(hrAttendance);
        return getDataTable(list);
    }

    /**
     * 导出员工考勤管理列表
     */
    @PreAuthorize("@ss.hasPermi('hr:attendance:export')")
    @Log(title = "员工考勤管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HrAttendance hrAttendance)
    {
        List<HrAttendance> list = hrAttendanceService.selectHrAttendanceList(hrAttendance);
        ExcelUtil<HrAttendance> util = new ExcelUtil<HrAttendance>(HrAttendance.class);
        util.exportExcel(response, list, "员工考勤管理数据");
    }

    /**
     * 获取员工考勤管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('hr:attendance:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(hrAttendanceService.selectHrAttendanceById(id));
    }

    /**
     * 新增员工考勤管理
     */
    @PreAuthorize("@ss.hasPermi('hr:attendance:add')")
    @Log(title = "员工考勤管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HrAttendance hrAttendance)
    {
        return toAjax(hrAttendanceService.insertHrAttendance(hrAttendance));
    }

    /**
     * 修改员工考勤管理
     */
    @PreAuthorize("@ss.hasPermi('hr:attendance:edit')")
    @Log(title = "员工考勤管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HrAttendance hrAttendance)
    {
        return toAjax(hrAttendanceService.updateHrAttendance(hrAttendance));
    }

    /**
     * 删除员工考勤管理
     */
    @PreAuthorize("@ss.hasPermi('hr:attendance:remove')")
    @Log(title = "员工考勤管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(hrAttendanceService.deleteHrAttendanceByIds(ids));
    }

    /**
     * 查询员工每月考勤表现列表
     */
    @PreAuthorize("@ss.hasPermi('hr:attendance:monthOfList')")
    @GetMapping("/monthOfList")
    public TableDataInfo monthOfList(HrAttendanceMonthVo hrAttendanceMonthVo)
    {
        startPage();
        List<HrAttendanceMonthVo> list = hrAttendanceService.selectMonthOfHrAttendanceList(hrAttendanceMonthVo);
        return getDataTable(list);
    }

    /**
     * 员工月考勤数据统计
     */
    @PreAuthorize("@ss.hasPermi('hr:attendance:exportMonthList')")
    @PostMapping("/exportMonthList")
    public void exportMonthList(HttpServletResponse response, HrAttendanceVo hrAttendanceVo)
    {
        if (hrAttendanceVo.getMonth() == null) {
            hrAttendanceVo.setMonth( DateUtil.format(new java.util.Date(), "yyyyMM"));
        }
        List<HrAttendanceVo> list = hrAttendanceService.selectHrAttendanceListCount(hrAttendanceVo);
        ExcelUtil<HrAttendanceVo> util = new ExcelUtil<HrAttendanceVo>(HrAttendanceVo.class);

        String yearMonth = hrAttendanceVo.getMonth().substring(0, 4) + "年" + hrAttendanceVo.getMonth().substring(4) + "月";
        util.exportExcel(response, list, yearMonth + "考勤数据");
    }

    /**
     * 导入考勤数据
     */
    @PreAuthorize("@ss.hasPermi('hr:attendance:import')")
    @PostMapping("/import")
    public AjaxResult importList(@RequestParam("importFile") MultipartFile importFile) throws IOException, InvalidExtensionException {
        if (importFile != null) {
            String fileName = FileUploadUtils.upload(HrConfig.getImportPath(), importFile, MimeTypeUtils.EXCEL_EXTENSION);
            List<HrAttendance> list = new ArrayList<>();
            EasyExcel.read(new File(HrConfig.getProfile()+fileName),HrAttendance.class,new SyncReadListener(){
                @Override
                public void invoke(Object object, AnalysisContext context) {
                    list.add((HrAttendance) object);
                }
            }).doReadAll();
            return hrAttendanceService.importList(list);
        }
        return error("上传文件异常，请联系管理员");
    }


    /**
     * 生成导入考勤数据模板
     */
    @PostMapping("/importAttendanceTemplate")
    public void importTemplate(HttpServletResponse response)
    {
        ExcelUtil<HrAttendance> util = new ExcelUtil<HrAttendance>(HrAttendance.class);
        util.importTemplateExcel(response, "考勤数据");
    }
}
