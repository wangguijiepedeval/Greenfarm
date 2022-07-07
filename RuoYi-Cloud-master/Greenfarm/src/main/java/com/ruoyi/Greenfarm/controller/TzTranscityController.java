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
import com.ruoyi.Greenfarm.domain.TzTranscity;
import com.ruoyi.Greenfarm.service.ITzTranscityService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * tz_transcityController
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/tz_transcity")
public class TzTranscityController extends BaseController
{
    @Autowired
    private ITzTranscityService tzTranscityService;

    /**
     * 查询tz_transcity列表
     */
    @RequiresPermissions("Greenfarm:tz_transcity:list")
    @GetMapping("/list")
    public TableDataInfo list(TzTranscity tzTranscity)
    {
        startPage();
        List<TzTranscity> list = tzTranscityService.selectTzTranscityList(tzTranscity);
        return getDataTable(list);
    }

    /**
     * 导出tz_transcity列表
     */
    @RequiresPermissions("Greenfarm:tz_transcity:export")
    @Log(title = "tz_transcity", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzTranscity tzTranscity)
    {
        List<TzTranscity> list = tzTranscityService.selectTzTranscityList(tzTranscity);
        ExcelUtil<TzTranscity> util = new ExcelUtil<TzTranscity>(TzTranscity.class);
        util.exportExcel(response, list, "tz_transcity数据");
    }

    /**
     * 获取tz_transcity详细信息
     */
    @RequiresPermissions("Greenfarm:tz_transcity:query")
    @GetMapping(value = "/{transcityId}")
    public AjaxResult getInfo(@PathVariable("transcityId") Long transcityId)
    {
        return AjaxResult.success(tzTranscityService.selectTzTranscityByTranscityId(transcityId));
    }

    /**
     * 新增tz_transcity
     */
    @RequiresPermissions("Greenfarm:tz_transcity:add")
    @Log(title = "tz_transcity", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzTranscity tzTranscity)
    {
        return toAjax(tzTranscityService.insertTzTranscity(tzTranscity));
    }

    /**
     * 修改tz_transcity
     */
    @RequiresPermissions("Greenfarm:tz_transcity:edit")
    @Log(title = "tz_transcity", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzTranscity tzTranscity)
    {
        return toAjax(tzTranscityService.updateTzTranscity(tzTranscity));
    }

    /**
     * 删除tz_transcity
     */
    @RequiresPermissions("Greenfarm:tz_transcity:remove")
    @Log(title = "tz_transcity", businessType = BusinessType.DELETE)
	@DeleteMapping("/{transcityIds}")
    public AjaxResult remove(@PathVariable Long[] transcityIds)
    {
        return toAjax(tzTranscityService.deleteTzTranscityByTranscityIds(transcityIds));
    }
}
