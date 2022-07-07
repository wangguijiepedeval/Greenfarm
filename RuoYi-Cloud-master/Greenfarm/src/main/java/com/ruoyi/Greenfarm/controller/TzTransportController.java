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
import com.ruoyi.Greenfarm.domain.TzTransport;
import com.ruoyi.Greenfarm.service.ITzTransportService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 订单详情Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_transport")
public class TzTransportController extends BaseController
{
    @Autowired
    private ITzTransportService tzTransportService;

    /**
     * 查询订单详情列表
     */
    @RequiresPermissions("Greenfarm:tz_transport:list")
    @GetMapping("/list")
    public TableDataInfo list(TzTransport tzTransport)
    {
        startPage();
        List<TzTransport> list = tzTransportService.selectTzTransportList(tzTransport);
        return getDataTable(list);
    }

    /**
     * 导出订单详情列表
     */
    @RequiresPermissions("Greenfarm:tz_transport:export")
    @Log(title = "订单详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzTransport tzTransport)
    {
        List<TzTransport> list = tzTransportService.selectTzTransportList(tzTransport);
        ExcelUtil<TzTransport> util = new ExcelUtil<TzTransport>(TzTransport.class);
        util.exportExcel(response, list, "订单详情数据");
    }

    /**
     * 获取订单详情详细信息
     */
    @RequiresPermissions("Greenfarm:tz_transport:query")
    @GetMapping(value = "/{transportId}")
    public AjaxResult getInfo(@PathVariable("transportId") Long transportId)
    {
        return AjaxResult.success(tzTransportService.selectTzTransportByTransportId(transportId));
    }

    /**
     * 新增订单详情
     */
    @RequiresPermissions("Greenfarm:tz_transport:add")
    @Log(title = "订单详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzTransport tzTransport)
    {
        return toAjax(tzTransportService.insertTzTransport(tzTransport));
    }

    /**
     * 修改订单详情
     */
    @RequiresPermissions("Greenfarm:tz_transport:edit")
    @Log(title = "订单详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzTransport tzTransport)
    {
        return toAjax(tzTransportService.updateTzTransport(tzTransport));
    }

    /**
     * 删除订单详情
     */
    @RequiresPermissions("Greenfarm:tz_transport:remove")
    @Log(title = "订单详情", businessType = BusinessType.DELETE)
	@DeleteMapping("/{transportIds}")
    public AjaxResult remove(@PathVariable Long[] transportIds)
    {
        return toAjax(tzTransportService.deleteTzTransportByTransportIds(transportIds));
    }
}
