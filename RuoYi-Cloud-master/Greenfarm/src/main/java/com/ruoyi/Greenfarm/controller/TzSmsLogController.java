package com.ruoyi.Greenfarm.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.RequiresPermissions;
import com.ruoyi.Greenfarm.domain.TzSmsLog;
import com.ruoyi.Greenfarm.service.ITzSmsLogService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 短信记录Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/tz_sms_log")
public class TzSmsLogController extends BaseController
{
    @Autowired
    private ITzSmsLogService tzSmsLogService;

    /**
     * 查询短信记录列表
     */
    @RequiresPermissions("Greenfarm:tz_sms_log:list")
    @GetMapping("/list")
    public TableDataInfo list(TzSmsLog tzSmsLog)
    {
        startPage();
        List<TzSmsLog> list = tzSmsLogService.selectTzSmsLogList(tzSmsLog);
        return getDataTable(list);
    }

    /**
     * 导出短信记录列表
     */
    @RequiresPermissions("Greenfarm:tz_sms_log:export")
    @Log(title = "短信记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzSmsLog tzSmsLog)
    {
        List<TzSmsLog> list = tzSmsLogService.selectTzSmsLogList(tzSmsLog);
        ExcelUtil<TzSmsLog> util = new ExcelUtil<TzSmsLog>(TzSmsLog.class);
        util.exportExcel(response, list, "短信记录数据");
    }

    /**
     * 获取短信记录详细信息
     */
    @RequiresPermissions("Greenfarm:tz_sms_log:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tzSmsLogService.selectTzSmsLogById(id));
    }

    /**
     * 新增短信记录
     */
    @RequiresPermissions("Greenfarm:tz_sms_log:add")
    @Log(title = "短信记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzSmsLog tzSmsLog)
    {
        return toAjax(tzSmsLogService.insertTzSmsLog(tzSmsLog));
    }

    /**
     * 修改短信记录
     */
    @RequiresPermissions("Greenfarm:tz_sms_log:edit")
    @Log(title = "短信记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzSmsLog tzSmsLog)
    {
        return toAjax(tzSmsLogService.updateTzSmsLog(tzSmsLog));
    }

    /**
     * 删除短信记录
     */
    @RequiresPermissions("Greenfarm:tz_sms_log:remove")
    @Log(title = "短信记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tzSmsLogService.deleteTzSmsLogByIds(ids));
    }
}
