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
import com.ruoyi.Greenfarm.domain.TzSku;
import com.ruoyi.Greenfarm.service.ITzSkuService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 单品SKUController
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/tz_sku")
public class TzSkuController extends BaseController
{
    @Autowired
    private ITzSkuService tzSkuService;

    /**
     * 查询单品SKU列表
     */
    @RequiresPermissions("Greenfarm:tz_sku:list")
    @GetMapping("/list")
    public TableDataInfo list(TzSku tzSku)
    {
        startPage();
        List<TzSku> list = tzSkuService.selectTzSkuList(tzSku);
        return getDataTable(list);
    }

    /**
     * 导出单品SKU列表
     */
    @RequiresPermissions("Greenfarm:tz_sku:export")
    @Log(title = "单品SKU", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzSku tzSku)
    {
        List<TzSku> list = tzSkuService.selectTzSkuList(tzSku);
        ExcelUtil<TzSku> util = new ExcelUtil<TzSku>(TzSku.class);
        util.exportExcel(response, list, "单品SKU数据");
    }

    /**
     * 获取单品SKU详细信息
     */
    @RequiresPermissions("Greenfarm:tz_sku:query")
    @GetMapping(value = "/{skuId}")
    public AjaxResult getInfo(@PathVariable("skuId") Long skuId)
    {
        return AjaxResult.success(tzSkuService.selectTzSkuBySkuId(skuId));
    }

    /**
     * 新增单品SKU
     */
    @RequiresPermissions("Greenfarm:tz_sku:add")
    @Log(title = "单品SKU", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzSku tzSku)
    {
        return toAjax(tzSkuService.insertTzSku(tzSku));
    }

    /**
     * 修改单品SKU
     */
    @RequiresPermissions("Greenfarm:tz_sku:edit")
    @Log(title = "单品SKU", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzSku tzSku)
    {
        return toAjax(tzSkuService.updateTzSku(tzSku));
    }

    /**
     * 删除单品SKU
     */
    @RequiresPermissions("Greenfarm:tz_sku:remove")
    @Log(title = "单品SKU", businessType = BusinessType.DELETE)
	@DeleteMapping("/{skuIds}")
    public AjaxResult remove(@PathVariable Long[] skuIds)
    {
        return toAjax(tzSkuService.deleteTzSkuBySkuIds(skuIds));
    }
}
