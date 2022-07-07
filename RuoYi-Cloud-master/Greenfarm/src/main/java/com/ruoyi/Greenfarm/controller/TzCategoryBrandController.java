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
import com.ruoyi.Greenfarm.domain.TzCategoryBrand;
import com.ruoyi.Greenfarm.service.ITzCategoryBrandService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 购物车与品牌Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_category_brand")
public class TzCategoryBrandController extends BaseController
{
    @Autowired
    private ITzCategoryBrandService tzCategoryBrandService;

    /**
     * 查询购物车与品牌列表
     */
    @RequiresPermissions("Greenfarm:tz_category_brand:list")
    @GetMapping("/list")
    public TableDataInfo list(TzCategoryBrand tzCategoryBrand)
    {
        startPage();
        List<TzCategoryBrand> list = tzCategoryBrandService.selectTzCategoryBrandList(tzCategoryBrand);
        return getDataTable(list);
    }

    /**
     * 导出购物车与品牌列表
     */
    @RequiresPermissions("Greenfarm:tz_category_brand:export")
    @Log(title = "购物车与品牌", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzCategoryBrand tzCategoryBrand)
    {
        List<TzCategoryBrand> list = tzCategoryBrandService.selectTzCategoryBrandList(tzCategoryBrand);
        ExcelUtil<TzCategoryBrand> util = new ExcelUtil<TzCategoryBrand>(TzCategoryBrand.class);
        util.exportExcel(response, list, "购物车与品牌数据");
    }

    /**
     * 获取购物车与品牌详细信息
     */
    @RequiresPermissions("Greenfarm:tz_category_brand:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tzCategoryBrandService.selectTzCategoryBrandById(id));
    }

    /**
     * 新增购物车与品牌
     */
    @RequiresPermissions("Greenfarm:tz_category_brand:add")
    @Log(title = "购物车与品牌", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzCategoryBrand tzCategoryBrand)
    {
        return toAjax(tzCategoryBrandService.insertTzCategoryBrand(tzCategoryBrand));
    }

    /**
     * 修改购物车与品牌
     */
    @RequiresPermissions("Greenfarm:tz_category_brand:edit")
    @Log(title = "购物车与品牌", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzCategoryBrand tzCategoryBrand)
    {
        return toAjax(tzCategoryBrandService.updateTzCategoryBrand(tzCategoryBrand));
    }

    /**
     * 删除购物车与品牌
     */
    @RequiresPermissions("Greenfarm:tz_category_brand:remove")
    @Log(title = "购物车与品牌", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tzCategoryBrandService.deleteTzCategoryBrandByIds(ids));
    }
}
