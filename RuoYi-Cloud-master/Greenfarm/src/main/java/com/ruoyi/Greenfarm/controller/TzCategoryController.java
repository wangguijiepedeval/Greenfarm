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
import com.ruoyi.Greenfarm.domain.TzCategory;
import com.ruoyi.Greenfarm.service.ITzCategoryService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 产品类目Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_category")
public class TzCategoryController extends BaseController
{
    @Autowired
    private ITzCategoryService tzCategoryService;

    /**
     * 查询产品类目列表
     */
    @RequiresPermissions("Greenfarm:tz_category:list")
    @GetMapping("/list")
    public TableDataInfo list(TzCategory tzCategory)
    {
        startPage();
        List<TzCategory> list = tzCategoryService.selectTzCategoryList(tzCategory);
        return getDataTable(list);
    }

    /**
     * 导出产品类目列表
     */
    @RequiresPermissions("Greenfarm:tz_category:export")
    @Log(title = "产品类目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzCategory tzCategory)
    {
        List<TzCategory> list = tzCategoryService.selectTzCategoryList(tzCategory);
        ExcelUtil<TzCategory> util = new ExcelUtil<TzCategory>(TzCategory.class);
        util.exportExcel(response, list, "产品类目数据");
    }

    /**
     * 获取产品类目详细信息
     */
    @RequiresPermissions("Greenfarm:tz_category:query")
    @GetMapping(value = "/{categoryId}")
    public AjaxResult getInfo(@PathVariable("categoryId") Long categoryId)
    {
        return AjaxResult.success(tzCategoryService.selectTzCategoryByCategoryId(categoryId));
    }

    /**
     * 新增产品类目
     */
    @RequiresPermissions("Greenfarm:tz_category:add")
    @Log(title = "产品类目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzCategory tzCategory)
    {
        return toAjax(tzCategoryService.insertTzCategory(tzCategory));
    }

    /**
     * 修改产品类目
     */
    @RequiresPermissions("Greenfarm:tz_category:edit")
    @Log(title = "产品类目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzCategory tzCategory)
    {
        return toAjax(tzCategoryService.updateTzCategory(tzCategory));
    }

    /**
     * 删除产品类目
     */
    @RequiresPermissions("Greenfarm:tz_category:remove")
    @Log(title = "产品类目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{categoryIds}")
    public AjaxResult remove(@PathVariable Long[] categoryIds)
    {
        return toAjax(tzCategoryService.deleteTzCategoryByCategoryIds(categoryIds));
    }
}
