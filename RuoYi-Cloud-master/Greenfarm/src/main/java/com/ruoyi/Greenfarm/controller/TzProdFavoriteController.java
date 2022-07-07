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
import com.ruoyi.Greenfarm.domain.TzProdFavorite;
import com.ruoyi.Greenfarm.service.ITzProdFavoriteService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品收藏Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_prod_favorite")
public class TzProdFavoriteController extends BaseController
{
    @Autowired
    private ITzProdFavoriteService tzProdFavoriteService;

    /**
     * 查询商品收藏列表
     */
    @RequiresPermissions("Greenfarm:tz_prod_favorite:list")
    @GetMapping("/list")
    public TableDataInfo list(TzProdFavorite tzProdFavorite)
    {
        startPage();
        List<TzProdFavorite> list = tzProdFavoriteService.selectTzProdFavoriteList(tzProdFavorite);
        return getDataTable(list);
    }

    /**
     * 导出商品收藏列表
     */
    @RequiresPermissions("Greenfarm:tz_prod_favorite:export")
    @Log(title = "商品收藏", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzProdFavorite tzProdFavorite)
    {
        List<TzProdFavorite> list = tzProdFavoriteService.selectTzProdFavoriteList(tzProdFavorite);
        ExcelUtil<TzProdFavorite> util = new ExcelUtil<TzProdFavorite>(TzProdFavorite.class);
        util.exportExcel(response, list, "商品收藏数据");
    }

    /**
     * 获取商品收藏详细信息
     */
    @RequiresPermissions("Greenfarm:tz_prod_favorite:query")
    @GetMapping(value = "/{favoriteId}")
    public AjaxResult getInfo(@PathVariable("favoriteId") Long favoriteId)
    {
        return AjaxResult.success(tzProdFavoriteService.selectTzProdFavoriteByFavoriteId(favoriteId));
    }

    /**
     * 新增商品收藏
     */
    @RequiresPermissions("Greenfarm:tz_prod_favorite:add")
    @Log(title = "商品收藏", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzProdFavorite tzProdFavorite)
    {
        return toAjax(tzProdFavoriteService.insertTzProdFavorite(tzProdFavorite));
    }

    /**
     * 修改商品收藏
     */
    @RequiresPermissions("Greenfarm:tz_prod_favorite:edit")
    @Log(title = "商品收藏", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzProdFavorite tzProdFavorite)
    {
        return toAjax(tzProdFavoriteService.updateTzProdFavorite(tzProdFavorite));
    }

    /**
     * 删除商品收藏
     */
    @RequiresPermissions("Greenfarm:tz_prod_favorite:remove")
    @Log(title = "商品收藏", businessType = BusinessType.DELETE)
	@DeleteMapping("/{favoriteIds}")
    public AjaxResult remove(@PathVariable Long[] favoriteIds)
    {
        return toAjax(tzProdFavoriteService.deleteTzProdFavoriteByFavoriteIds(favoriteIds));
    }
}
