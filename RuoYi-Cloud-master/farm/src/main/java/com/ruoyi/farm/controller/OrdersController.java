package com.ruoyi.farm.controller;

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
import com.ruoyi.farm.domain.Orders;
import com.ruoyi.farm.service.IOrdersService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * orders管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@RestController
@RequestMapping("/orders")
public class OrdersController extends BaseController
{
    @Autowired
    private IOrdersService ordersService;

    /**
     * 查询orders管理列表
     */
    @RequiresPermissions("farm:orders:list")
    @GetMapping("/list")
    public TableDataInfo list(Orders orders)
    {
        startPage();
        List<Orders> list = ordersService.selectOrdersList(orders);
        return getDataTable(list);
    }

    /**
     * 导出orders管理列表
     */
    @RequiresPermissions("farm:orders:export")
    @Log(title = "orders管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Orders orders)
    {
        List<Orders> list = ordersService.selectOrdersList(orders);
        ExcelUtil<Orders> util = new ExcelUtil<Orders>(Orders.class);
        util.exportExcel(response, list, "orders管理数据");
    }

    /**
     * 获取orders管理详细信息
     */
    @RequiresPermissions("farm:orders:query")
    @GetMapping(value = "/{orderid}")
    public AjaxResult getInfo(@PathVariable("orderid") String orderid)
    {
        return AjaxResult.success(ordersService.selectOrdersByOrderid(orderid));
    }

    /**
     * 新增orders管理
     */
    @RequiresPermissions("farm:orders:add")
    @Log(title = "orders管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Orders orders)
    {
        return toAjax(ordersService.insertOrders(orders));
    }

    /**
     * 修改orders管理
     */
    @RequiresPermissions("farm:orders:edit")
    @Log(title = "orders管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Orders orders)
    {
        return toAjax(ordersService.updateOrders(orders));
    }

    /**
     * 删除orders管理
     */
    @RequiresPermissions("farm:orders:remove")
    @Log(title = "orders管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderids}")
    public AjaxResult remove(@PathVariable String[] orderids)
    {
        return toAjax(ordersService.deleteOrdersByOrderids(orderids));
    }
}
