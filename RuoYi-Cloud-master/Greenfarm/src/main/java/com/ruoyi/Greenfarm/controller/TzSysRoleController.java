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
import com.ruoyi.Greenfarm.domain.TzSysRole;
import com.ruoyi.Greenfarm.service.ITzSysRoleService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 角色Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/tz_sys_role")
public class TzSysRoleController extends BaseController
{
    @Autowired
    private ITzSysRoleService tzSysRoleService;

    /**
     * 查询角色列表
     */
    @RequiresPermissions("Greenfarm:tz_sys_role:list")
    @GetMapping("/list")
    public TableDataInfo list(TzSysRole tzSysRole)
    {
        startPage();
        List<TzSysRole> list = tzSysRoleService.selectTzSysRoleList(tzSysRole);
        return getDataTable(list);
    }

    /**
     * 导出角色列表
     */
    @RequiresPermissions("Greenfarm:tz_sys_role:export")
    @Log(title = "角色", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzSysRole tzSysRole)
    {
        List<TzSysRole> list = tzSysRoleService.selectTzSysRoleList(tzSysRole);
        ExcelUtil<TzSysRole> util = new ExcelUtil<TzSysRole>(TzSysRole.class);
        util.exportExcel(response, list, "角色数据");
    }

    /**
     * 获取角色详细信息
     */
    @RequiresPermissions("Greenfarm:tz_sys_role:query")
    @GetMapping(value = "/{roleId}")
    public AjaxResult getInfo(@PathVariable("roleId") Long roleId)
    {
        return AjaxResult.success(tzSysRoleService.selectTzSysRoleByRoleId(roleId));
    }

    /**
     * 新增角色
     */
    @RequiresPermissions("Greenfarm:tz_sys_role:add")
    @Log(title = "角色", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzSysRole tzSysRole)
    {
        return toAjax(tzSysRoleService.insertTzSysRole(tzSysRole));
    }

    /**
     * 修改角色
     */
    @RequiresPermissions("Greenfarm:tz_sys_role:edit")
    @Log(title = "角色", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzSysRole tzSysRole)
    {
        return toAjax(tzSysRoleService.updateTzSysRole(tzSysRole));
    }

    /**
     * 删除角色
     */
    @RequiresPermissions("Greenfarm:tz_sys_role:remove")
    @Log(title = "角色", businessType = BusinessType.DELETE)
	@DeleteMapping("/{roleIds}")
    public AjaxResult remove(@PathVariable Long[] roleIds)
    {
        return toAjax(tzSysRoleService.deleteTzSysRoleByRoleIds(roleIds));
    }
}
