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
import com.ruoyi.Greenfarm.domain.TzProdPropValue;
import com.ruoyi.Greenfarm.service.ITzProdPropValueService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 属性值Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/tz_prod_prop_value")
public class TzProdPropValueController extends BaseController
{
    @Autowired
    private ITzProdPropValueService tzProdPropValueService;

    /**
     * 查询属性值列表
     */
    @RequiresPermissions("Greenfarm:tz_prod_prop_value:list")
    @GetMapping("/list")
    public TableDataInfo list(TzProdPropValue tzProdPropValue)
    {
        startPage();
        List<TzProdPropValue> list = tzProdPropValueService.selectTzProdPropValueList(tzProdPropValue);
        return getDataTable(list);
    }

    /**
     * 导出属性值列表
     */
    @RequiresPermissions("Greenfarm:tz_prod_prop_value:export")
    @Log(title = "属性值", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzProdPropValue tzProdPropValue)
    {
        List<TzProdPropValue> list = tzProdPropValueService.selectTzProdPropValueList(tzProdPropValue);
        ExcelUtil<TzProdPropValue> util = new ExcelUtil<TzProdPropValue>(TzProdPropValue.class);
        util.exportExcel(response, list, "属性值数据");
    }

    /**
     * 获取属性值详细信息
     */
    @RequiresPermissions("Greenfarm:tz_prod_prop_value:query")
    @GetMapping(value = "/{valueId}")
    public AjaxResult getInfo(@PathVariable("valueId") Long valueId)
    {
        return AjaxResult.success(tzProdPropValueService.selectTzProdPropValueByValueId(valueId));
    }

    /**
     * 新增属性值
     */
    @RequiresPermissions("Greenfarm:tz_prod_prop_value:add")
    @Log(title = "属性值", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzProdPropValue tzProdPropValue)
    {
        return toAjax(tzProdPropValueService.insertTzProdPropValue(tzProdPropValue));
    }

    /**
     * 修改属性值
     */
    @RequiresPermissions("Greenfarm:tz_prod_prop_value:edit")
    @Log(title = "属性值", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzProdPropValue tzProdPropValue)
    {
        return toAjax(tzProdPropValueService.updateTzProdPropValue(tzProdPropValue));
    }

    /**
     * 删除属性值
     */
    @RequiresPermissions("Greenfarm:tz_prod_prop_value:remove")
    @Log(title = "属性值", businessType = BusinessType.DELETE)
	@DeleteMapping("/{valueIds}")
    public AjaxResult remove(@PathVariable Long[] valueIds)
    {
        return toAjax(tzProdPropValueService.deleteTzProdPropValueByValueIds(valueIds));
    }
}
