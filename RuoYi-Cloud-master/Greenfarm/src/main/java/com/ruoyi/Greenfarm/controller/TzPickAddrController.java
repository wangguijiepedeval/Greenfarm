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
import com.ruoyi.Greenfarm.domain.TzPickAddr;
import com.ruoyi.Greenfarm.service.ITzPickAddrService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 用户配送地址Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_pick_addr")
public class TzPickAddrController extends BaseController
{
    @Autowired
    private ITzPickAddrService tzPickAddrService;

    /**
     * 查询用户配送地址列表
     */
    @RequiresPermissions("Greenfarm:tz_pick_addr:list")
    @GetMapping("/list")
    public TableDataInfo list(TzPickAddr tzPickAddr)
    {
        startPage();
        List<TzPickAddr> list = tzPickAddrService.selectTzPickAddrList(tzPickAddr);
        return getDataTable(list);
    }

    /**
     * 导出用户配送地址列表
     */
    @RequiresPermissions("Greenfarm:tz_pick_addr:export")
    @Log(title = "用户配送地址", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzPickAddr tzPickAddr)
    {
        List<TzPickAddr> list = tzPickAddrService.selectTzPickAddrList(tzPickAddr);
        ExcelUtil<TzPickAddr> util = new ExcelUtil<TzPickAddr>(TzPickAddr.class);
        util.exportExcel(response, list, "用户配送地址数据");
    }

    /**
     * 获取用户配送地址详细信息
     */
    @RequiresPermissions("Greenfarm:tz_pick_addr:query")
    @GetMapping(value = "/{addrId}")
    public AjaxResult getInfo(@PathVariable("addrId") Long addrId)
    {
        return AjaxResult.success(tzPickAddrService.selectTzPickAddrByAddrId(addrId));
    }

    /**
     * 新增用户配送地址
     */
    @RequiresPermissions("Greenfarm:tz_pick_addr:add")
    @Log(title = "用户配送地址", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzPickAddr tzPickAddr)
    {
        return toAjax(tzPickAddrService.insertTzPickAddr(tzPickAddr));
    }

    /**
     * 修改用户配送地址
     */
    @RequiresPermissions("Greenfarm:tz_pick_addr:edit")
    @Log(title = "用户配送地址", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzPickAddr tzPickAddr)
    {
        return toAjax(tzPickAddrService.updateTzPickAddr(tzPickAddr));
    }

    /**
     * 删除用户配送地址
     */
    @RequiresPermissions("Greenfarm:tz_pick_addr:remove")
    @Log(title = "用户配送地址", businessType = BusinessType.DELETE)
	@DeleteMapping("/{addrIds}")
    public AjaxResult remove(@PathVariable Long[] addrIds)
    {
        return toAjax(tzPickAddrService.deleteTzPickAddrByAddrIds(addrIds));
    }
}
