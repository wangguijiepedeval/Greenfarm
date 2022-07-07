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
import com.ruoyi.Greenfarm.domain.TzProdProp;
import com.ruoyi.Greenfarm.service.ITzProdPropService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 店铺信息Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_prod_prop")
public class TzProdPropController extends BaseController
{
    @Autowired
    private ITzProdPropService tzProdPropService;

    /**
     * 查询店铺信息列表
     */
    @RequiresPermissions("Greenfarm:tz_prod_prop:list")
    @GetMapping("/list")
    public TableDataInfo list(TzProdProp tzProdProp)
    {
        startPage();
        List<TzProdProp> list = tzProdPropService.selectTzProdPropList(tzProdProp);
        return getDataTable(list);
    }

    /**
     * 导出店铺信息列表
     */
    @RequiresPermissions("Greenfarm:tz_prod_prop:export")
    @Log(title = "店铺信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzProdProp tzProdProp)
    {
        List<TzProdProp> list = tzProdPropService.selectTzProdPropList(tzProdProp);
        ExcelUtil<TzProdProp> util = new ExcelUtil<TzProdProp>(TzProdProp.class);
        util.exportExcel(response, list, "店铺信息数据");
    }

    /**
     * 获取店铺信息详细信息
     */
    @RequiresPermissions("Greenfarm:tz_prod_prop:query")
    @GetMapping(value = "/{propId}")
    public AjaxResult getInfo(@PathVariable("propId") Long propId)
    {
        return AjaxResult.success(tzProdPropService.selectTzProdPropByPropId(propId));
    }

    /**
     * 新增店铺信息
     */
    @RequiresPermissions("Greenfarm:tz_prod_prop:add")
    @Log(title = "店铺信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzProdProp tzProdProp)
    {
        return toAjax(tzProdPropService.insertTzProdProp(tzProdProp));
    }

    /**
     * 修改店铺信息
     */
    @RequiresPermissions("Greenfarm:tz_prod_prop:edit")
    @Log(title = "店铺信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzProdProp tzProdProp)
    {
        return toAjax(tzProdPropService.updateTzProdProp(tzProdProp));
    }

    /**
     * 删除店铺信息
     */
    @RequiresPermissions("Greenfarm:tz_prod_prop:remove")
    @Log(title = "店铺信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{propIds}")
    public AjaxResult remove(@PathVariable Long[] propIds)
    {
        return toAjax(tzProdPropService.deleteTzProdPropByPropIds(propIds));
    }
}
