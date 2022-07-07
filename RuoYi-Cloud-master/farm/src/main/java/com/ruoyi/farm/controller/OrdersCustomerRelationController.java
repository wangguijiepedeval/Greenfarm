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
import com.ruoyi.farm.domain.OrdersCustomerRelation;
import com.ruoyi.farm.service.IOrdersCustomerRelationService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * orders_customer_relation管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@RestController
@RequestMapping("/orders_customer_relation")
public class OrdersCustomerRelationController extends BaseController
{
    @Autowired
    private IOrdersCustomerRelationService ordersCustomerRelationService;

    /**
     * 查询orders_customer_relation管理列表
     */
    @RequiresPermissions("farm:orders_customer_relation:list")
    @GetMapping("/list")
    public TableDataInfo list(OrdersCustomerRelation ordersCustomerRelation)
    {
        startPage();
        List<OrdersCustomerRelation> list = ordersCustomerRelationService.selectOrdersCustomerRelationList(ordersCustomerRelation);
        return getDataTable(list);
    }

    /**
     * 导出orders_customer_relation管理列表
     */
    @RequiresPermissions("farm:orders_customer_relation:export")
    @Log(title = "orders_customer_relation管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, OrdersCustomerRelation ordersCustomerRelation)
    {
        List<OrdersCustomerRelation> list = ordersCustomerRelationService.selectOrdersCustomerRelationList(ordersCustomerRelation);
        ExcelUtil<OrdersCustomerRelation> util = new ExcelUtil<OrdersCustomerRelation>(OrdersCustomerRelation.class);
        util.exportExcel(response, list, "orders_customer_relation管理数据");
    }

    /**
     * 获取orders_customer_relation管理详细信息
     */
    @RequiresPermissions("farm:orders_customer_relation:query")
    @GetMapping(value = "/{ordersid}")
    public AjaxResult getInfo(@PathVariable("ordersid") String ordersid)
    {
        return AjaxResult.success(ordersCustomerRelationService.selectOrdersCustomerRelationByOrdersid(ordersid));
    }

    /**
     * 新增orders_customer_relation管理
     */
    @RequiresPermissions("farm:orders_customer_relation:add")
    @Log(title = "orders_customer_relation管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody OrdersCustomerRelation ordersCustomerRelation)
    {
        return toAjax(ordersCustomerRelationService.insertOrdersCustomerRelation(ordersCustomerRelation));
    }

    /**
     * 修改orders_customer_relation管理
     */
    @RequiresPermissions("farm:orders_customer_relation:edit")
    @Log(title = "orders_customer_relation管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody OrdersCustomerRelation ordersCustomerRelation)
    {
        return toAjax(ordersCustomerRelationService.updateOrdersCustomerRelation(ordersCustomerRelation));
    }

    /**
     * 删除orders_customer_relation管理
     */
    @RequiresPermissions("farm:orders_customer_relation:remove")
    @Log(title = "orders_customer_relation管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ordersids}")
    public AjaxResult remove(@PathVariable String[] ordersids)
    {
        return toAjax(ordersCustomerRelationService.deleteOrdersCustomerRelationByOrdersids(ordersids));
    }
}
