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
import com.ruoyi.Greenfarm.domain.TzProd;
import com.ruoyi.Greenfarm.service.ITzProdService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_prod")
public class TzProdController extends BaseController
{
    @Autowired
    private ITzProdService tzProdService;

    /**
     * 查询商品列表
     */
    @RequiresPermissions("Greenfarm:tz_prod:list")
    @GetMapping("/list")
    public TableDataInfo list(TzProd tzProd)
    {
        startPage();
        List<TzProd> list = tzProdService.selectTzProdList(tzProd);
        return getDataTable(list);
    }

    /**
     * 导出商品列表
     */
    @RequiresPermissions("Greenfarm:tz_prod:export")
    @Log(title = "商品", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzProd tzProd)
    {
        List<TzProd> list = tzProdService.selectTzProdList(tzProd);
        ExcelUtil<TzProd> util = new ExcelUtil<TzProd>(TzProd.class);
        util.exportExcel(response, list, "商品数据");
    }

    /**
     * 获取商品详细信息
     */
    @RequiresPermissions("Greenfarm:tz_prod:query")
    @GetMapping(value = "/{prodId}")
    public AjaxResult getInfo(@PathVariable("prodId") Long prodId)
    {
        return AjaxResult.success(tzProdService.selectTzProdByProdId(prodId));
    }

    /**
     * 新增商品
     */
    @RequiresPermissions("Greenfarm:tz_prod:add")
    @Log(title = "商品", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzProd tzProd)
    {
        return toAjax(tzProdService.insertTzProd(tzProd));
    }

    /**
     * 修改商品
     */
    @RequiresPermissions("Greenfarm:tz_prod:edit")
    @Log(title = "商品", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzProd tzProd)
    {
        return toAjax(tzProdService.updateTzProd(tzProd));
    }

    /**
     * 删除商品
     */
    @RequiresPermissions("Greenfarm:tz_prod:remove")
    @Log(title = "商品", businessType = BusinessType.DELETE)
	@DeleteMapping("/{prodIds}")
    public AjaxResult remove(@PathVariable Long[] prodIds)
    {
        return toAjax(tzProdService.deleteTzProdByProdIds(prodIds));
    }
}
