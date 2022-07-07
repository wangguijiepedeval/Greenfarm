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
import com.ruoyi.Greenfarm.domain.TzHotSearch;
import com.ruoyi.Greenfarm.service.ITzHotSearchService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 热搜Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/tz_hot_search")
public class TzHotSearchController extends BaseController
{
    @Autowired
    private ITzHotSearchService tzHotSearchService;

    /**
     * 查询热搜列表
     */
    @RequiresPermissions("Greenfarm:tz_hot_search:list")
    @GetMapping("/list")
    public TableDataInfo list(TzHotSearch tzHotSearch)
    {
        startPage();
        List<TzHotSearch> list = tzHotSearchService.selectTzHotSearchList(tzHotSearch);
        return getDataTable(list);
    }

    /**
     * 导出热搜列表
     */
    @RequiresPermissions("Greenfarm:tz_hot_search:export")
    @Log(title = "热搜", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzHotSearch tzHotSearch)
    {
        List<TzHotSearch> list = tzHotSearchService.selectTzHotSearchList(tzHotSearch);
        ExcelUtil<TzHotSearch> util = new ExcelUtil<TzHotSearch>(TzHotSearch.class);
        util.exportExcel(response, list, "热搜数据");
    }

    /**
     * 获取热搜详细信息
     */
    @RequiresPermissions("Greenfarm:tz_hot_search:query")
    @GetMapping(value = "/{hotSearchId}")
    public AjaxResult getInfo(@PathVariable("hotSearchId") Long hotSearchId)
    {
        return AjaxResult.success(tzHotSearchService.selectTzHotSearchByHotSearchId(hotSearchId));
    }

    /**
     * 新增热搜
     */
    @RequiresPermissions("Greenfarm:tz_hot_search:add")
    @Log(title = "热搜", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzHotSearch tzHotSearch)
    {
        return toAjax(tzHotSearchService.insertTzHotSearch(tzHotSearch));
    }

    /**
     * 修改热搜
     */
    @RequiresPermissions("Greenfarm:tz_hot_search:edit")
    @Log(title = "热搜", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzHotSearch tzHotSearch)
    {
        return toAjax(tzHotSearchService.updateTzHotSearch(tzHotSearch));
    }

    /**
     * 删除热搜
     */
    @RequiresPermissions("Greenfarm:tz_hot_search:remove")
    @Log(title = "热搜", businessType = BusinessType.DELETE)
	@DeleteMapping("/{hotSearchIds}")
    public AjaxResult remove(@PathVariable Long[] hotSearchIds)
    {
        return toAjax(tzHotSearchService.deleteTzHotSearchByHotSearchIds(hotSearchIds));
    }
}
