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
import com.ruoyi.Greenfarm.domain.TzSysConfig;
import com.ruoyi.Greenfarm.service.ITzSysConfigService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 系统配置信息Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/tz_sys_config")
public class TzSysConfigController extends BaseController
{
    @Autowired
    private ITzSysConfigService tzSysConfigService;

    /**
     * 查询系统配置信息列表
     */
    @RequiresPermissions("Greenfarm:tz_sys_config:list")
    @GetMapping("/list")
    public TableDataInfo list(TzSysConfig tzSysConfig)
    {
        startPage();
        List<TzSysConfig> list = tzSysConfigService.selectTzSysConfigList(tzSysConfig);
        return getDataTable(list);
    }

    /**
     * 导出系统配置信息列表
     */
    @RequiresPermissions("Greenfarm:tz_sys_config:export")
    @Log(title = "系统配置信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzSysConfig tzSysConfig)
    {
        List<TzSysConfig> list = tzSysConfigService.selectTzSysConfigList(tzSysConfig);
        ExcelUtil<TzSysConfig> util = new ExcelUtil<TzSysConfig>(TzSysConfig.class);
        util.exportExcel(response, list, "系统配置信息数据");
    }

    /**
     * 获取系统配置信息详细信息
     */
    @RequiresPermissions("Greenfarm:tz_sys_config:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tzSysConfigService.selectTzSysConfigById(id));
    }

    /**
     * 新增系统配置信息
     */
    @RequiresPermissions("Greenfarm:tz_sys_config:add")
    @Log(title = "系统配置信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzSysConfig tzSysConfig)
    {
        return toAjax(tzSysConfigService.insertTzSysConfig(tzSysConfig));
    }

    /**
     * 修改系统配置信息
     */
    @RequiresPermissions("Greenfarm:tz_sys_config:edit")
    @Log(title = "系统配置信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzSysConfig tzSysConfig)
    {
        return toAjax(tzSysConfigService.updateTzSysConfig(tzSysConfig));
    }

    /**
     * 删除系统配置信息
     */
    @RequiresPermissions("Greenfarm:tz_sys_config:remove")
    @Log(title = "系统配置信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tzSysConfigService.deleteTzSysConfigByIds(ids));
    }
}
