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
import com.ruoyi.Greenfarm.domain.TzTranscityFree;
import com.ruoyi.Greenfarm.service.ITzTranscityFreeService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 包邮信息Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_transcity_free")
public class TzTranscityFreeController extends BaseController
{
    @Autowired
    private ITzTranscityFreeService tzTranscityFreeService;

    /**
     * 查询包邮信息列表
     */
    @RequiresPermissions("Greenfarm:tz_transcity_free:list")
    @GetMapping("/list")
    public TableDataInfo list(TzTranscityFree tzTranscityFree)
    {
        startPage();
        List<TzTranscityFree> list = tzTranscityFreeService.selectTzTranscityFreeList(tzTranscityFree);
        return getDataTable(list);
    }

    /**
     * 导出包邮信息列表
     */
    @RequiresPermissions("Greenfarm:tz_transcity_free:export")
    @Log(title = "包邮信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzTranscityFree tzTranscityFree)
    {
        List<TzTranscityFree> list = tzTranscityFreeService.selectTzTranscityFreeList(tzTranscityFree);
        ExcelUtil<TzTranscityFree> util = new ExcelUtil<TzTranscityFree>(TzTranscityFree.class);
        util.exportExcel(response, list, "包邮信息数据");
    }

    /**
     * 获取包邮信息详细信息
     */
    @RequiresPermissions("Greenfarm:tz_transcity_free:query")
    @GetMapping(value = "/{transcityFreeId}")
    public AjaxResult getInfo(@PathVariable("transcityFreeId") Long transcityFreeId)
    {
        return AjaxResult.success(tzTranscityFreeService.selectTzTranscityFreeByTranscityFreeId(transcityFreeId));
    }

    /**
     * 新增包邮信息
     */
    @RequiresPermissions("Greenfarm:tz_transcity_free:add")
    @Log(title = "包邮信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzTranscityFree tzTranscityFree)
    {
        return toAjax(tzTranscityFreeService.insertTzTranscityFree(tzTranscityFree));
    }

    /**
     * 修改包邮信息
     */
    @RequiresPermissions("Greenfarm:tz_transcity_free:edit")
    @Log(title = "包邮信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzTranscityFree tzTranscityFree)
    {
        return toAjax(tzTranscityFreeService.updateTzTranscityFree(tzTranscityFree));
    }

    /**
     * 删除包邮信息
     */
    @RequiresPermissions("Greenfarm:tz_transcity_free:remove")
    @Log(title = "包邮信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{transcityFreeIds}")
    public AjaxResult remove(@PathVariable Long[] transcityFreeIds)
    {
        return toAjax(tzTranscityFreeService.deleteTzTranscityFreeByTranscityFreeIds(transcityFreeIds));
    }
}
