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
import com.ruoyi.Greenfarm.domain.TzArea;
import com.ruoyi.Greenfarm.service.ITzAreaService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 地址信息Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_area")
public class TzAreaController extends BaseController
{
    @Autowired
    private ITzAreaService tzAreaService;

    /**
     * 查询地址信息列表
     */
    @RequiresPermissions("Greenfarm:tz_area:list")
    @GetMapping("/list")
    public TableDataInfo list(TzArea tzArea)
    {
        startPage();
        List<TzArea> list = tzAreaService.selectTzAreaList(tzArea);
        return getDataTable(list);
    }

    /**
     * 导出地址信息列表
     */
    @RequiresPermissions("Greenfarm:tz_area:export")
    @Log(title = "地址信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzArea tzArea)
    {
        List<TzArea> list = tzAreaService.selectTzAreaList(tzArea);
        ExcelUtil<TzArea> util = new ExcelUtil<TzArea>(TzArea.class);
        util.exportExcel(response, list, "地址信息数据");
    }

    /**
     * 获取地址信息详细信息
     */
    @RequiresPermissions("Greenfarm:tz_area:query")
    @GetMapping(value = "/{areaId}")
    public AjaxResult getInfo(@PathVariable("areaId") Long areaId)
    {
        return AjaxResult.success(tzAreaService.selectTzAreaByAreaId(areaId));
    }

    /**
     * 新增地址信息
     */
    @RequiresPermissions("Greenfarm:tz_area:add")
    @Log(title = "地址信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzArea tzArea)
    {
        return toAjax(tzAreaService.insertTzArea(tzArea));
    }

    /**
     * 修改地址信息
     */
    @RequiresPermissions("Greenfarm:tz_area:edit")
    @Log(title = "地址信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzArea tzArea)
    {
        return toAjax(tzAreaService.updateTzArea(tzArea));
    }

    /**
     * 删除地址信息
     */
    @RequiresPermissions("Greenfarm:tz_area:remove")
    @Log(title = "地址信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{areaIds}")
    public AjaxResult remove(@PathVariable Long[] areaIds)
    {
        return toAjax(tzAreaService.deleteTzAreaByAreaIds(areaIds));
    }
}
