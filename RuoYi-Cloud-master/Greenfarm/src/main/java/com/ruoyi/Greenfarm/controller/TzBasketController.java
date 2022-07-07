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
import com.ruoyi.Greenfarm.domain.TzBasket;
import com.ruoyi.Greenfarm.service.ITzBasketService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 购物车Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_basket")
public class TzBasketController extends BaseController
{
    @Autowired
    private ITzBasketService tzBasketService;

    /**
     * 查询购物车列表
     */
    @RequiresPermissions("Greenfarm:tz_basket:list")
    @GetMapping("/list")
    public TableDataInfo list(TzBasket tzBasket)
    {
        startPage();
        List<TzBasket> list = tzBasketService.selectTzBasketList(tzBasket);
        return getDataTable(list);
    }

    /**
     * 导出购物车列表
     */
    @RequiresPermissions("Greenfarm:tz_basket:export")
    @Log(title = "购物车", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzBasket tzBasket)
    {
        List<TzBasket> list = tzBasketService.selectTzBasketList(tzBasket);
        ExcelUtil<TzBasket> util = new ExcelUtil<TzBasket>(TzBasket.class);
        util.exportExcel(response, list, "购物车数据");
    }

    /**
     * 获取购物车详细信息
     */
    @RequiresPermissions("Greenfarm:tz_basket:query")
    @GetMapping(value = "/{basketId}")
    public AjaxResult getInfo(@PathVariable("basketId") Long basketId)
    {
        return AjaxResult.success(tzBasketService.selectTzBasketByBasketId(basketId));
    }

    /**
     * 新增购物车
     */
    @RequiresPermissions("Greenfarm:tz_basket:add")
    @Log(title = "购物车", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzBasket tzBasket)
    {
        return toAjax(tzBasketService.insertTzBasket(tzBasket));
    }

    /**
     * 修改购物车
     */
    @RequiresPermissions("Greenfarm:tz_basket:edit")
    @Log(title = "购物车", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzBasket tzBasket)
    {
        return toAjax(tzBasketService.updateTzBasket(tzBasket));
    }

    /**
     * 删除购物车
     */
    @RequiresPermissions("Greenfarm:tz_basket:remove")
    @Log(title = "购物车", businessType = BusinessType.DELETE)
	@DeleteMapping("/{basketIds}")
    public AjaxResult remove(@PathVariable Long[] basketIds)
    {
        return toAjax(tzBasketService.deleteTzBasketByBasketIds(basketIds));
    }
}
