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
import com.ruoyi.Greenfarm.domain.TzBrand;
import com.ruoyi.Greenfarm.service.ITzBrandService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 品牌Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_brand")
public class TzBrandController extends BaseController
{
    @Autowired
    private ITzBrandService tzBrandService;

    /**
     * 查询品牌列表
     */
    @RequiresPermissions("Greenfarm:tz_brand:list")
    @GetMapping("/list")
    public TableDataInfo list(TzBrand tzBrand)
    {
        startPage();
        List<TzBrand> list = tzBrandService.selectTzBrandList(tzBrand);
        return getDataTable(list);
    }

    /**
     * 导出品牌列表
     */
    @RequiresPermissions("Greenfarm:tz_brand:export")
    @Log(title = "品牌", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzBrand tzBrand)
    {
        List<TzBrand> list = tzBrandService.selectTzBrandList(tzBrand);
        ExcelUtil<TzBrand> util = new ExcelUtil<TzBrand>(TzBrand.class);
        util.exportExcel(response, list, "品牌数据");
    }

    /**
     * 获取品牌详细信息
     */
    @RequiresPermissions("Greenfarm:tz_brand:query")
    @GetMapping(value = "/{brandId}")
    public AjaxResult getInfo(@PathVariable("brandId") Long brandId)
    {
        return AjaxResult.success(tzBrandService.selectTzBrandByBrandId(brandId));
    }

    /**
     * 新增品牌
     */
    @RequiresPermissions("Greenfarm:tz_brand:add")
    @Log(title = "品牌", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzBrand tzBrand)
    {
        return toAjax(tzBrandService.insertTzBrand(tzBrand));
    }

    /**
     * 修改品牌
     */
    @RequiresPermissions("Greenfarm:tz_brand:edit")
    @Log(title = "品牌", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzBrand tzBrand)
    {
        return toAjax(tzBrandService.updateTzBrand(tzBrand));
    }

    /**
     * 删除品牌
     */
    @RequiresPermissions("Greenfarm:tz_brand:remove")
    @Log(title = "品牌", businessType = BusinessType.DELETE)
	@DeleteMapping("/{brandIds}")
    public AjaxResult remove(@PathVariable Long[] brandIds)
    {
        return toAjax(tzBrandService.deleteTzBrandByBrandIds(brandIds));
    }
}
