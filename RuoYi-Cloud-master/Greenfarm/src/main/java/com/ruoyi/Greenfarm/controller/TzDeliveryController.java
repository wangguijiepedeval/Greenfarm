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
import com.ruoyi.Greenfarm.domain.TzDelivery;
import com.ruoyi.Greenfarm.service.ITzDeliveryService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 物流公司Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/tz_delivery")
public class TzDeliveryController extends BaseController
{
    @Autowired
    private ITzDeliveryService tzDeliveryService;

    /**
     * 查询物流公司列表
     */
    @RequiresPermissions("Greenfarm:tz_delivery:list")
    @GetMapping("/list")
    public TableDataInfo list(TzDelivery tzDelivery)
    {
        startPage();
        List<TzDelivery> list = tzDeliveryService.selectTzDeliveryList(tzDelivery);
        return getDataTable(list);
    }

    /**
     * 导出物流公司列表
     */
    @RequiresPermissions("Greenfarm:tz_delivery:export")
    @Log(title = "物流公司", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzDelivery tzDelivery)
    {
        List<TzDelivery> list = tzDeliveryService.selectTzDeliveryList(tzDelivery);
        ExcelUtil<TzDelivery> util = new ExcelUtil<TzDelivery>(TzDelivery.class);
        util.exportExcel(response, list, "物流公司数据");
    }

    /**
     * 获取物流公司详细信息
     */
    @RequiresPermissions("Greenfarm:tz_delivery:query")
    @GetMapping(value = "/{dvyId}")
    public AjaxResult getInfo(@PathVariable("dvyId") Long dvyId)
    {
        return AjaxResult.success(tzDeliveryService.selectTzDeliveryByDvyId(dvyId));
    }

    /**
     * 新增物流公司
     */
    @RequiresPermissions("Greenfarm:tz_delivery:add")
    @Log(title = "物流公司", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzDelivery tzDelivery)
    {
        return toAjax(tzDeliveryService.insertTzDelivery(tzDelivery));
    }

    /**
     * 修改物流公司
     */
    @RequiresPermissions("Greenfarm:tz_delivery:edit")
    @Log(title = "物流公司", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzDelivery tzDelivery)
    {
        return toAjax(tzDeliveryService.updateTzDelivery(tzDelivery));
    }

    /**
     * 删除物流公司
     */
    @RequiresPermissions("Greenfarm:tz_delivery:remove")
    @Log(title = "物流公司", businessType = BusinessType.DELETE)
	@DeleteMapping("/{dvyIds}")
    public AjaxResult remove(@PathVariable Long[] dvyIds)
    {
        return toAjax(tzDeliveryService.deleteTzDeliveryByDvyIds(dvyIds));
    }
}
