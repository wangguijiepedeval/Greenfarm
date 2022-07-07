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
import com.ruoyi.Greenfarm.domain.TzOrderRefund;
import com.ruoyi.Greenfarm.service.ITzOrderRefundService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 记录Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/tz_order_refund")
public class TzOrderRefundController extends BaseController
{
    @Autowired
    private ITzOrderRefundService tzOrderRefundService;

    /**
     * 查询记录列表
     */
    @RequiresPermissions("Greenfarm:tz_order_refund:list")
    @GetMapping("/list")
    public TableDataInfo list(TzOrderRefund tzOrderRefund)
    {
        startPage();
        List<TzOrderRefund> list = tzOrderRefundService.selectTzOrderRefundList(tzOrderRefund);
        return getDataTable(list);
    }

    /**
     * 导出记录列表
     */
    @RequiresPermissions("Greenfarm:tz_order_refund:export")
    @Log(title = "记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzOrderRefund tzOrderRefund)
    {
        List<TzOrderRefund> list = tzOrderRefundService.selectTzOrderRefundList(tzOrderRefund);
        ExcelUtil<TzOrderRefund> util = new ExcelUtil<TzOrderRefund>(TzOrderRefund.class);
        util.exportExcel(response, list, "记录数据");
    }

    /**
     * 获取记录详细信息
     */
    @RequiresPermissions("Greenfarm:tz_order_refund:query")
    @GetMapping(value = "/{refundId}")
    public AjaxResult getInfo(@PathVariable("refundId") Long refundId)
    {
        return AjaxResult.success(tzOrderRefundService.selectTzOrderRefundByRefundId(refundId));
    }

    /**
     * 新增记录
     */
    @RequiresPermissions("Greenfarm:tz_order_refund:add")
    @Log(title = "记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzOrderRefund tzOrderRefund)
    {
        return toAjax(tzOrderRefundService.insertTzOrderRefund(tzOrderRefund));
    }

    /**
     * 修改记录
     */
    @RequiresPermissions("Greenfarm:tz_order_refund:edit")
    @Log(title = "记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzOrderRefund tzOrderRefund)
    {
        return toAjax(tzOrderRefundService.updateTzOrderRefund(tzOrderRefund));
    }

    /**
     * 删除记录
     */
    @RequiresPermissions("Greenfarm:tz_order_refund:remove")
    @Log(title = "记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{refundIds}")
    public AjaxResult remove(@PathVariable Long[] refundIds)
    {
        return toAjax(tzOrderRefundService.deleteTzOrderRefundByRefundIds(refundIds));
    }
}
