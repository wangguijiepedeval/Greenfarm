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
import com.ruoyi.Greenfarm.domain.TzOrderItem;
import com.ruoyi.Greenfarm.service.ITzOrderItemService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 订单项Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/tz_order_item")
public class TzOrderItemController extends BaseController
{
    @Autowired
    private ITzOrderItemService tzOrderItemService;

    /**
     * 查询订单项列表
     */
    @RequiresPermissions("Greenfarm:tz_order_item:list")
    @GetMapping("/list")
    public TableDataInfo list(TzOrderItem tzOrderItem)
    {
        startPage();
        List<TzOrderItem> list = tzOrderItemService.selectTzOrderItemList(tzOrderItem);
        return getDataTable(list);
    }

    /**
     * 导出订单项列表
     */
    @RequiresPermissions("Greenfarm:tz_order_item:export")
    @Log(title = "订单项", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzOrderItem tzOrderItem)
    {
        List<TzOrderItem> list = tzOrderItemService.selectTzOrderItemList(tzOrderItem);
        ExcelUtil<TzOrderItem> util = new ExcelUtil<TzOrderItem>(TzOrderItem.class);
        util.exportExcel(response, list, "订单项数据");
    }

    /**
     * 获取订单项详细信息
     */
    @RequiresPermissions("Greenfarm:tz_order_item:query")
    @GetMapping(value = "/{orderItemId}")
    public AjaxResult getInfo(@PathVariable("orderItemId") Long orderItemId)
    {
        return AjaxResult.success(tzOrderItemService.selectTzOrderItemByOrderItemId(orderItemId));
    }

    /**
     * 新增订单项
     */
    @RequiresPermissions("Greenfarm:tz_order_item:add")
    @Log(title = "订单项", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzOrderItem tzOrderItem)
    {
        return toAjax(tzOrderItemService.insertTzOrderItem(tzOrderItem));
    }

    /**
     * 修改订单项
     */
    @RequiresPermissions("Greenfarm:tz_order_item:edit")
    @Log(title = "订单项", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzOrderItem tzOrderItem)
    {
        return toAjax(tzOrderItemService.updateTzOrderItem(tzOrderItem));
    }

    /**
     * 删除订单项
     */
    @RequiresPermissions("Greenfarm:tz_order_item:remove")
    @Log(title = "订单项", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderItemIds}")
    public AjaxResult remove(@PathVariable Long[] orderItemIds)
    {
        return toAjax(tzOrderItemService.deleteTzOrderItemByOrderItemIds(orderItemIds));
    }
}
