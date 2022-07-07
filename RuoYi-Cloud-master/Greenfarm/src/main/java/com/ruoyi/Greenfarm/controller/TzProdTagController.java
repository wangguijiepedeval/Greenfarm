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
import com.ruoyi.Greenfarm.domain.TzProdTag;
import com.ruoyi.Greenfarm.service.ITzProdTagService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品分组Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_prod_tag")
public class TzProdTagController extends BaseController
{
    @Autowired
    private ITzProdTagService tzProdTagService;

    /**
     * 查询商品分组列表
     */
    @RequiresPermissions("Greenfarm:tz_prod_tag:list")
    @GetMapping("/list")
    public TableDataInfo list(TzProdTag tzProdTag)
    {
        startPage();
        List<TzProdTag> list = tzProdTagService.selectTzProdTagList(tzProdTag);
        return getDataTable(list);
    }

    /**
     * 导出商品分组列表
     */
    @RequiresPermissions("Greenfarm:tz_prod_tag:export")
    @Log(title = "商品分组", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzProdTag tzProdTag)
    {
        List<TzProdTag> list = tzProdTagService.selectTzProdTagList(tzProdTag);
        ExcelUtil<TzProdTag> util = new ExcelUtil<TzProdTag>(TzProdTag.class);
        util.exportExcel(response, list, "商品分组数据");
    }

    /**
     * 获取商品分组详细信息
     */
    @RequiresPermissions("Greenfarm:tz_prod_tag:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tzProdTagService.selectTzProdTagById(id));
    }

    /**
     * 新增商品分组
     */
    @RequiresPermissions("Greenfarm:tz_prod_tag:add")
    @Log(title = "商品分组", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzProdTag tzProdTag)
    {
        return toAjax(tzProdTagService.insertTzProdTag(tzProdTag));
    }

    /**
     * 修改商品分组
     */
    @RequiresPermissions("Greenfarm:tz_prod_tag:edit")
    @Log(title = "商品分组", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzProdTag tzProdTag)
    {
        return toAjax(tzProdTagService.updateTzProdTag(tzProdTag));
    }

    /**
     * 删除商品分组
     */
    @RequiresPermissions("Greenfarm:tz_prod_tag:remove")
    @Log(title = "商品分组", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tzProdTagService.deleteTzProdTagByIds(ids));
    }
}
