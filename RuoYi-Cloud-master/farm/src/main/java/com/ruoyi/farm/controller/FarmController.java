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
import com.ruoyi.farm.domain.Farm;
import com.ruoyi.farm.service.IFarmService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * farm管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@RestController
@RequestMapping("/farm")
public class FarmController extends BaseController
{
    @Autowired
    private IFarmService farmService;

    /**
     * 查询farm管理列表
     */
    @RequiresPermissions("farm:farm:list")
    @GetMapping("/list")
    public TableDataInfo list(Farm farm)
    {
        startPage();
        List<Farm> list = farmService.selectFarmList(farm);
        return getDataTable(list);
    }

    /**
     * 导出farm管理列表
     */
    @RequiresPermissions("farm:farm:export")
    @Log(title = "farm管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Farm farm)
    {
        List<Farm> list = farmService.selectFarmList(farm);
        ExcelUtil<Farm> util = new ExcelUtil<Farm>(Farm.class);
        util.exportExcel(response, list, "farm管理数据");
    }

    /**
     * 获取farm管理详细信息
     */
    @RequiresPermissions("farm:farm:query")
    @GetMapping(value = "/{farmid}")
    public AjaxResult getInfo(@PathVariable("farmid") String farmid)
    {
        return AjaxResult.success(farmService.selectFarmByFarmid(farmid));
    }

    /**
     * 新增farm管理
     */
    @RequiresPermissions("farm:farm:add")
    @Log(title = "farm管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Farm farm)
    {
        return toAjax(farmService.insertFarm(farm));
    }

    /**
     * 修改farm管理
     */
    @RequiresPermissions("farm:farm:edit")
    @Log(title = "farm管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Farm farm)
    {
        return toAjax(farmService.updateFarm(farm));
    }

    /**
     * 删除farm管理
     */
    @RequiresPermissions("farm:farm:remove")
    @Log(title = "farm管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{farmids}")
    public AjaxResult remove(@PathVariable String[] farmids)
    {
        return toAjax(farmService.deleteFarmByFarmids(farmids));
    }
}
