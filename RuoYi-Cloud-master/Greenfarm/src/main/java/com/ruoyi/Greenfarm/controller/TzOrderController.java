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
import com.ruoyi.Greenfarm.domain.TzOrder;
import com.ruoyi.Greenfarm.service.ITzOrderService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 订单Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/tz_order")
public class TzOrderController extends BaseController
{
    @Autowired
    private ITzOrderService tzOrderService;

    /**
     * 查询订单列表
     */
    @RequiresPermissions("Greenfarm:tz_order:list")
    @GetMapping("/list")
    public TableDataInfo list(TzOrder tzOrder)
    {
        startPage();
        List<TzOrder> list = tzOrderService.selectTzOrderList(tzOrder);
        return getDataTable(list);
    }

    /**
     * 导出订单列表
     */
    @RequiresPermissions("Greenfarm:tz_order:export")
    @Log(title = "订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzOrder tzOrder)
    {
        List<TzOrder> list = tzOrderService.selectTzOrderList(tzOrder);
        ExcelUtil<TzOrder> util = new ExcelUtil<TzOrder>(TzOrder.class);
        util.exportExcel(response, list, "订单数据");
    }

    /**
     * 获取订单详细信息
     */
    @RequiresPermissions("Greenfarm:tz_order:query")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") Long orderId)
    {
        return AjaxResult.success(tzOrderService.selectTzOrderByOrderId(orderId));
    }

    /**
     * 新增订单
     */
    @RequiresPermissions("Greenfarm:tz_order:add")
    @Log(title = "订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzOrder tzOrder)
    {
        return toAjax(tzOrderService.insertTzOrder(tzOrder));
    }

    /**
     * 修改订单
     */
    @RequiresPermissions("Greenfarm:tz_order:edit")
    @Log(title = "订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzOrder tzOrder)
    {
        return toAjax(tzOrderService.updateTzOrder(tzOrder));
    }

    /**
     * 删除订单
     */
    @RequiresPermissions("Greenfarm:tz_order:remove")
    @Log(title = "订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable Long[] orderIds)
    {
        return toAjax(tzOrderService.deleteTzOrderByOrderIds(orderIds));
    }
}
