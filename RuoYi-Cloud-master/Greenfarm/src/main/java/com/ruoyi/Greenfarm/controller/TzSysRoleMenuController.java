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
import com.ruoyi.Greenfarm.domain.TzSysRoleMenu;
import com.ruoyi.Greenfarm.service.ITzSysRoleMenuService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 角色与菜单对应关系Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/tz_sys_role_menu")
public class TzSysRoleMenuController extends BaseController
{
    @Autowired
    private ITzSysRoleMenuService tzSysRoleMenuService;

    /**
     * 查询角色与菜单对应关系列表
     */
    @RequiresPermissions("Greenfarm:tz_sys_role_menu:list")
    @GetMapping("/list")
    public TableDataInfo list(TzSysRoleMenu tzSysRoleMenu)
    {
        startPage();
        List<TzSysRoleMenu> list = tzSysRoleMenuService.selectTzSysRoleMenuList(tzSysRoleMenu);
        return getDataTable(list);
    }

    /**
     * 导出角色与菜单对应关系列表
     */
    @RequiresPermissions("Greenfarm:tz_sys_role_menu:export")
    @Log(title = "角色与菜单对应关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzSysRoleMenu tzSysRoleMenu)
    {
        List<TzSysRoleMenu> list = tzSysRoleMenuService.selectTzSysRoleMenuList(tzSysRoleMenu);
        ExcelUtil<TzSysRoleMenu> util = new ExcelUtil<TzSysRoleMenu>(TzSysRoleMenu.class);
        util.exportExcel(response, list, "角色与菜单对应关系数据");
    }

    /**
     * 获取角色与菜单对应关系详细信息
     */
    @RequiresPermissions("Greenfarm:tz_sys_role_menu:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tzSysRoleMenuService.selectTzSysRoleMenuById(id));
    }

    /**
     * 新增角色与菜单对应关系
     */
    @RequiresPermissions("Greenfarm:tz_sys_role_menu:add")
    @Log(title = "角色与菜单对应关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzSysRoleMenu tzSysRoleMenu)
    {
        return toAjax(tzSysRoleMenuService.insertTzSysRoleMenu(tzSysRoleMenu));
    }

    /**
     * 修改角色与菜单对应关系
     */
    @RequiresPermissions("Greenfarm:tz_sys_role_menu:edit")
    @Log(title = "角色与菜单对应关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzSysRoleMenu tzSysRoleMenu)
    {
        return toAjax(tzSysRoleMenuService.updateTzSysRoleMenu(tzSysRoleMenu));
    }

    /**
     * 删除角色与菜单对应关系
     */
    @RequiresPermissions("Greenfarm:tz_sys_role_menu:remove")
    @Log(title = "角色与菜单对应关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tzSysRoleMenuService.deleteTzSysRoleMenuByIds(ids));
    }
}
