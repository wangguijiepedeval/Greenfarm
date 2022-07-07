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
import com.ruoyi.Greenfarm.domain.TzUserCollection;
import com.ruoyi.Greenfarm.service.ITzUserCollectionService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 用户收藏管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_user_collection")
public class TzUserCollectionController extends BaseController
{
    @Autowired
    private ITzUserCollectionService tzUserCollectionService;

    /**
     * 查询用户收藏管理列表
     */
    @RequiresPermissions("Greenfarm:tz_user_collection:list")
    @GetMapping("/list")
    public TableDataInfo list(TzUserCollection tzUserCollection)
    {
        startPage();
        List<TzUserCollection> list = tzUserCollectionService.selectTzUserCollectionList(tzUserCollection);
        return getDataTable(list);
    }

    /**
     * 导出用户收藏管理列表
     */
    @RequiresPermissions("Greenfarm:tz_user_collection:export")
    @Log(title = "用户收藏管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzUserCollection tzUserCollection)
    {
        List<TzUserCollection> list = tzUserCollectionService.selectTzUserCollectionList(tzUserCollection);
        ExcelUtil<TzUserCollection> util = new ExcelUtil<TzUserCollection>(TzUserCollection.class);
        util.exportExcel(response, list, "用户收藏管理数据");
    }

    /**
     * 获取用户收藏管理详细信息
     */
    @RequiresPermissions("Greenfarm:tz_user_collection:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tzUserCollectionService.selectTzUserCollectionById(id));
    }

    /**
     * 新增用户收藏管理
     */
    @RequiresPermissions("Greenfarm:tz_user_collection:add")
    @Log(title = "用户收藏管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzUserCollection tzUserCollection)
    {
        return toAjax(tzUserCollectionService.insertTzUserCollection(tzUserCollection));
    }

    /**
     * 修改用户收藏管理
     */
    @RequiresPermissions("Greenfarm:tz_user_collection:edit")
    @Log(title = "用户收藏管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzUserCollection tzUserCollection)
    {
        return toAjax(tzUserCollectionService.updateTzUserCollection(tzUserCollection));
    }

    /**
     * 删除用户收藏管理
     */
    @RequiresPermissions("Greenfarm:tz_user_collection:remove")
    @Log(title = "用户收藏管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tzUserCollectionService.deleteTzUserCollectionByIds(ids));
    }
}
