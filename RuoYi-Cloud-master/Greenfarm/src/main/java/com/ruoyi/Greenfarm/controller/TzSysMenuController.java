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
import com.ruoyi.Greenfarm.domain.TzSysMenu;
import com.ruoyi.Greenfarm.service.ITzSysMenuService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 菜单管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/tz_sys_menu")
public class TzSysMenuController extends BaseController
{
    @Autowired
    private ITzSysMenuService tzSysMenuService;

    /**
     * 查询菜单管理列表
     */
    @RequiresPermissions("Greenfarm:tz_sys_menu:list")
    @GetMapping("/list")
    public TableDataInfo list(TzSysMenu tzSysMenu)
    {
        startPage();
        List<TzSysMenu> list = tzSysMenuService.selectTzSysMenuList(tzSysMenu);
        return getDataTable(list);
    }

    /**
     * 导出菜单管理列表
     */
    @RequiresPermissions("Greenfarm:tz_sys_menu:export")
    @Log(title = "菜单管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzSysMenu tzSysMenu)
    {
        List<TzSysMenu> list = tzSysMenuService.selectTzSysMenuList(tzSysMenu);
        ExcelUtil<TzSysMenu> util = new ExcelUtil<TzSysMenu>(TzSysMenu.class);
        util.exportExcel(response, list, "菜单管理数据");
    }

    /**
     * 获取菜单管理详细信息
     */
    @RequiresPermissions("Greenfarm:tz_sys_menu:query")
    @GetMapping(value = "/{menuId}")
    public AjaxResult getInfo(@PathVariable("menuId") Long menuId)
    {
        return AjaxResult.success(tzSysMenuService.selectTzSysMenuByMenuId(menuId));
    }

    /**
     * 新增菜单管理
     */
    @RequiresPermissions("Greenfarm:tz_sys_menu:add")
    @Log(title = "菜单管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzSysMenu tzSysMenu)
    {
        return toAjax(tzSysMenuService.insertTzSysMenu(tzSysMenu));
    }

    /**
     * 修改菜单管理
     */
    @RequiresPermissions("Greenfarm:tz_sys_menu:edit")
    @Log(title = "菜单管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzSysMenu tzSysMenu)
    {
        return toAjax(tzSysMenuService.updateTzSysMenu(tzSysMenu));
    }

    /**
     * 删除菜单管理
     */
    @RequiresPermissions("Greenfarm:tz_sys_menu:remove")
    @Log(title = "菜单管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{menuIds}")
    public AjaxResult remove(@PathVariable Long[] menuIds)
    {
        return toAjax(tzSysMenuService.deleteTzSysMenuByMenuIds(menuIds));
    }
}
