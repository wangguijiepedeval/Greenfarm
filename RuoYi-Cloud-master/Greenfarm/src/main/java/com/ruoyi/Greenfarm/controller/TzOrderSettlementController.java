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
import com.ruoyi.Greenfarm.domain.TzOrderSettlement;
import com.ruoyi.Greenfarm.service.ITzOrderSettlementService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 支付信息Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_order_settlement")
public class TzOrderSettlementController extends BaseController
{
    @Autowired
    private ITzOrderSettlementService tzOrderSettlementService;

    /**
     * 查询支付信息列表
     */
    @RequiresPermissions("Greenfarm:tz_order_settlement:list")
    @GetMapping("/list")
    public TableDataInfo list(TzOrderSettlement tzOrderSettlement)
    {
        startPage();
        List<TzOrderSettlement> list = tzOrderSettlementService.selectTzOrderSettlementList(tzOrderSettlement);
        return getDataTable(list);
    }

    /**
     * 导出支付信息列表
     */
    @RequiresPermissions("Greenfarm:tz_order_settlement:export")
    @Log(title = "支付信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzOrderSettlement tzOrderSettlement)
    {
        List<TzOrderSettlement> list = tzOrderSettlementService.selectTzOrderSettlementList(tzOrderSettlement);
        ExcelUtil<TzOrderSettlement> util = new ExcelUtil<TzOrderSettlement>(TzOrderSettlement.class);
        util.exportExcel(response, list, "支付信息数据");
    }

    /**
     * 获取支付信息详细信息
     */
    @RequiresPermissions("Greenfarm:tz_order_settlement:query")
    @GetMapping(value = "/{settlementId}")
    public AjaxResult getInfo(@PathVariable("settlementId") Long settlementId)
    {
        return AjaxResult.success(tzOrderSettlementService.selectTzOrderSettlementBySettlementId(settlementId));
    }

    /**
     * 新增支付信息
     */
    @RequiresPermissions("Greenfarm:tz_order_settlement:add")
    @Log(title = "支付信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzOrderSettlement tzOrderSettlement)
    {
        return toAjax(tzOrderSettlementService.insertTzOrderSettlement(tzOrderSettlement));
    }

    /**
     * 修改支付信息
     */
    @RequiresPermissions("Greenfarm:tz_order_settlement:edit")
    @Log(title = "支付信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzOrderSettlement tzOrderSettlement)
    {
        return toAjax(tzOrderSettlementService.updateTzOrderSettlement(tzOrderSettlement));
    }

    /**
     * 删除支付信息
     */
    @RequiresPermissions("Greenfarm:tz_order_settlement:remove")
    @Log(title = "支付信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{settlementIds}")
    public AjaxResult remove(@PathVariable Long[] settlementIds)
    {
        return toAjax(tzOrderSettlementService.deleteTzOrderSettlementBySettlementIds(settlementIds));
    }
}
