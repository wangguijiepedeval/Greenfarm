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
import com.ruoyi.Greenfarm.domain.TzProdTagReference;
import com.ruoyi.Greenfarm.service.ITzProdTagReferenceService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 店铺分组Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_prod_tag_reference")
public class TzProdTagReferenceController extends BaseController
{
    @Autowired
    private ITzProdTagReferenceService tzProdTagReferenceService;

    /**
     * 查询店铺分组列表
     */
    @RequiresPermissions("Greenfarm:tz_prod_tag_reference:list")
    @GetMapping("/list")
    public TableDataInfo list(TzProdTagReference tzProdTagReference)
    {
        startPage();
        List<TzProdTagReference> list = tzProdTagReferenceService.selectTzProdTagReferenceList(tzProdTagReference);
        return getDataTable(list);
    }

    /**
     * 导出店铺分组列表
     */
    @RequiresPermissions("Greenfarm:tz_prod_tag_reference:export")
    @Log(title = "店铺分组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzProdTagReference tzProdTagReference)
    {
        List<TzProdTagReference> list = tzProdTagReferenceService.selectTzProdTagReferenceList(tzProdTagReference);
        ExcelUtil<TzProdTagReference> util = new ExcelUtil<TzProdTagReference>(TzProdTagReference.class);
        util.exportExcel(response, list, "店铺分组数据");
    }

    /**
     * 获取店铺分组详细信息
     */
    @RequiresPermissions("Greenfarm:tz_prod_tag_reference:query")
    @GetMapping(value = "/{referenceId}")
    public AjaxResult getInfo(@PathVariable("referenceId") Long referenceId)
    {
        return AjaxResult.success(tzProdTagReferenceService.selectTzProdTagReferenceByReferenceId(referenceId));
    }

    /**
     * 新增店铺分组
     */
    @RequiresPermissions("Greenfarm:tz_prod_tag_reference:add")
    @Log(title = "店铺分组", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzProdTagReference tzProdTagReference)
    {
        return toAjax(tzProdTagReferenceService.insertTzProdTagReference(tzProdTagReference));
    }

    /**
     * 修改店铺分组
     */
    @RequiresPermissions("Greenfarm:tz_prod_tag_reference:edit")
    @Log(title = "店铺分组", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzProdTagReference tzProdTagReference)
    {
        return toAjax(tzProdTagReferenceService.updateTzProdTagReference(tzProdTagReference));
    }

    /**
     * 删除店铺分组
     */
    @RequiresPermissions("Greenfarm:tz_prod_tag_reference:remove")
    @Log(title = "店铺分组", businessType = BusinessType.DELETE)
	@DeleteMapping("/{referenceIds}")
    public AjaxResult remove(@PathVariable Long[] referenceIds)
    {
        return toAjax(tzProdTagReferenceService.deleteTzProdTagReferenceByReferenceIds(referenceIds));
    }
}
