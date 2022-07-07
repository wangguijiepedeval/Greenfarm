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
import com.ruoyi.Greenfarm.domain.TzCategoryProp;
import com.ruoyi.Greenfarm.service.ITzCategoryPropService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 购物车商品Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/tz_category_prop")
public class TzCategoryPropController extends BaseController
{
    @Autowired
    private ITzCategoryPropService tzCategoryPropService;

    /**
     * 查询购物车商品列表
     */
    @RequiresPermissions("Greenfarm:tz_category_prop:list")
    @GetMapping("/list")
    public TableDataInfo list(TzCategoryProp tzCategoryProp)
    {
        startPage();
        List<TzCategoryProp> list = tzCategoryPropService.selectTzCategoryPropList(tzCategoryProp);
        return getDataTable(list);
    }

    /**
     * 导出购物车商品列表
     */
    @RequiresPermissions("Greenfarm:tz_category_prop:export")
    @Log(title = "购物车商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzCategoryProp tzCategoryProp)
    {
        List<TzCategoryProp> list = tzCategoryPropService.selectTzCategoryPropList(tzCategoryProp);
        ExcelUtil<TzCategoryProp> util = new ExcelUtil<TzCategoryProp>(TzCategoryProp.class);
        util.exportExcel(response, list, "购物车商品数据");
    }

    /**
     * 获取购物车商品详细信息
     */
    @RequiresPermissions("Greenfarm:tz_category_prop:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tzCategoryPropService.selectTzCategoryPropById(id));
    }

    /**
     * 新增购物车商品
     */
    @RequiresPermissions("Greenfarm:tz_category_prop:add")
    @Log(title = "购物车商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzCategoryProp tzCategoryProp)
    {
        return toAjax(tzCategoryPropService.insertTzCategoryProp(tzCategoryProp));
    }

    /**
     * 修改购物车商品
     */
    @RequiresPermissions("Greenfarm:tz_category_prop:edit")
    @Log(title = "购物车商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzCategoryProp tzCategoryProp)
    {
        return toAjax(tzCategoryPropService.updateTzCategoryProp(tzCategoryProp));
    }

    /**
     * 删除购物车商品
     */
    @RequiresPermissions("Greenfarm:tz_category_prop:remove")
    @Log(title = "购物车商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tzCategoryPropService.deleteTzCategoryPropByIds(ids));
    }
}
