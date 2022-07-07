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
import com.ruoyi.Greenfarm.domain.TzUserAddrOrder;
import com.ruoyi.Greenfarm.service.ITzUserAddrOrderService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 用户订单配送地址Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_user_addr_order")
public class TzUserAddrOrderController extends BaseController
{
    @Autowired
    private ITzUserAddrOrderService tzUserAddrOrderService;

    /**
     * 查询用户订单配送地址列表
     */
    @RequiresPermissions("Greenfarm:tz_user_addr_order:list")
    @GetMapping("/list")
    public TableDataInfo list(TzUserAddrOrder tzUserAddrOrder)
    {
        startPage();
        List<TzUserAddrOrder> list = tzUserAddrOrderService.selectTzUserAddrOrderList(tzUserAddrOrder);
        return getDataTable(list);
    }

    /**
     * 导出用户订单配送地址列表
     */
    @RequiresPermissions("Greenfarm:tz_user_addr_order:export")
    @Log(title = "用户订单配送地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzUserAddrOrder tzUserAddrOrder)
    {
        List<TzUserAddrOrder> list = tzUserAddrOrderService.selectTzUserAddrOrderList(tzUserAddrOrder);
        ExcelUtil<TzUserAddrOrder> util = new ExcelUtil<TzUserAddrOrder>(TzUserAddrOrder.class);
        util.exportExcel(response, list, "用户订单配送地址数据");
    }

    /**
     * 获取用户订单配送地址详细信息
     */
    @RequiresPermissions("Greenfarm:tz_user_addr_order:query")
    @GetMapping(value = "/{addrOrderId}")
    public AjaxResult getInfo(@PathVariable("addrOrderId") Long addrOrderId)
    {
        return AjaxResult.success(tzUserAddrOrderService.selectTzUserAddrOrderByAddrOrderId(addrOrderId));
    }

    /**
     * 新增用户订单配送地址
     */
    @RequiresPermissions("Greenfarm:tz_user_addr_order:add")
    @Log(title = "用户订单配送地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzUserAddrOrder tzUserAddrOrder)
    {
        return toAjax(tzUserAddrOrderService.insertTzUserAddrOrder(tzUserAddrOrder));
    }

    /**
     * 修改用户订单配送地址
     */
    @RequiresPermissions("Greenfarm:tz_user_addr_order:edit")
    @Log(title = "用户订单配送地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzUserAddrOrder tzUserAddrOrder)
    {
        return toAjax(tzUserAddrOrderService.updateTzUserAddrOrder(tzUserAddrOrder));
    }

    /**
     * 删除用户订单配送地址
     */
    @RequiresPermissions("Greenfarm:tz_user_addr_order:remove")
    @Log(title = "用户订单配送地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{addrOrderIds}")
    public AjaxResult remove(@PathVariable Long[] addrOrderIds)
    {
        return toAjax(tzUserAddrOrderService.deleteTzUserAddrOrderByAddrOrderIds(addrOrderIds));
    }
}
