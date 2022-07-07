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
import com.ruoyi.Greenfarm.domain.TzTransfeeFree;
import com.ruoyi.Greenfarm.service.ITzTransfeeFreeService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 运费信息Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_transfee_free")
public class TzTransfeeFreeController extends BaseController
{
    @Autowired
    private ITzTransfeeFreeService tzTransfeeFreeService;

    /**
     * 查询运费信息列表
     */
    @RequiresPermissions("Greenfarm:tz_transfee_free:list")
    @GetMapping("/list")
    public TableDataInfo list(TzTransfeeFree tzTransfeeFree)
    {
        startPage();
        List<TzTransfeeFree> list = tzTransfeeFreeService.selectTzTransfeeFreeList(tzTransfeeFree);
        return getDataTable(list);
    }

    /**
     * 导出运费信息列表
     */
    @RequiresPermissions("Greenfarm:tz_transfee_free:export")
    @Log(title = "运费信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzTransfeeFree tzTransfeeFree)
    {
        List<TzTransfeeFree> list = tzTransfeeFreeService.selectTzTransfeeFreeList(tzTransfeeFree);
        ExcelUtil<TzTransfeeFree> util = new ExcelUtil<TzTransfeeFree>(TzTransfeeFree.class);
        util.exportExcel(response, list, "运费信息数据");
    }

    /**
     * 获取运费信息详细信息
     */
    @RequiresPermissions("Greenfarm:tz_transfee_free:query")
    @GetMapping(value = "/{transfeeFreeId}")
    public AjaxResult getInfo(@PathVariable("transfeeFreeId") Long transfeeFreeId)
    {
        return AjaxResult.success(tzTransfeeFreeService.selectTzTransfeeFreeByTransfeeFreeId(transfeeFreeId));
    }

    /**
     * 新增运费信息
     */
    @RequiresPermissions("Greenfarm:tz_transfee_free:add")
    @Log(title = "运费信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzTransfeeFree tzTransfeeFree)
    {
        return toAjax(tzTransfeeFreeService.insertTzTransfeeFree(tzTransfeeFree));
    }

    /**
     * 修改运费信息
     */
    @RequiresPermissions("Greenfarm:tz_transfee_free:edit")
    @Log(title = "运费信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzTransfeeFree tzTransfeeFree)
    {
        return toAjax(tzTransfeeFreeService.updateTzTransfeeFree(tzTransfeeFree));
    }

    /**
     * 删除运费信息
     */
    @RequiresPermissions("Greenfarm:tz_transfee_free:remove")
    @Log(title = "运费信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{transfeeFreeIds}")
    public AjaxResult remove(@PathVariable Long[] transfeeFreeIds)
    {
        return toAjax(tzTransfeeFreeService.deleteTzTransfeeFreeByTransfeeFreeIds(transfeeFreeIds));
    }
}
