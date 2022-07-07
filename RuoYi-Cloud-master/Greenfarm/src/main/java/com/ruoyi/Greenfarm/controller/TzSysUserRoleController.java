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
import com.ruoyi.Greenfarm.domain.TzSysUserRole;
import com.ruoyi.Greenfarm.service.ITzSysUserRoleService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 用户与角色对应关系Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/tz_sys_user_role")
public class TzSysUserRoleController extends BaseController
{
    @Autowired
    private ITzSysUserRoleService tzSysUserRoleService;

    /**
     * 查询用户与角色对应关系列表
     */
    @RequiresPermissions("Greenfarm:tz_sys_user_role:list")
    @GetMapping("/list")
    public TableDataInfo list(TzSysUserRole tzSysUserRole)
    {
        startPage();
        List<TzSysUserRole> list = tzSysUserRoleService.selectTzSysUserRoleList(tzSysUserRole);
        return getDataTable(list);
    }

    /**
     * 导出用户与角色对应关系列表
     */
    @RequiresPermissions("Greenfarm:tz_sys_user_role:export")
    @Log(title = "用户与角色对应关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzSysUserRole tzSysUserRole)
    {
        List<TzSysUserRole> list = tzSysUserRoleService.selectTzSysUserRoleList(tzSysUserRole);
        ExcelUtil<TzSysUserRole> util = new ExcelUtil<TzSysUserRole>(TzSysUserRole.class);
        util.exportExcel(response, list, "用户与角色对应关系数据");
    }

    /**
     * 获取用户与角色对应关系详细信息
     */
    @RequiresPermissions("Greenfarm:tz_sys_user_role:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tzSysUserRoleService.selectTzSysUserRoleById(id));
    }

    /**
     * 新增用户与角色对应关系
     */
    @RequiresPermissions("Greenfarm:tz_sys_user_role:add")
    @Log(title = "用户与角色对应关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzSysUserRole tzSysUserRole)
    {
        return toAjax(tzSysUserRoleService.insertTzSysUserRole(tzSysUserRole));
    }

    /**
     * 修改用户与角色对应关系
     */
    @RequiresPermissions("Greenfarm:tz_sys_user_role:edit")
    @Log(title = "用户与角色对应关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzSysUserRole tzSysUserRole)
    {
        return toAjax(tzSysUserRoleService.updateTzSysUserRole(tzSysUserRole));
    }

    /**
     * 删除用户与角色对应关系
     */
    @RequiresPermissions("Greenfarm:tz_sys_user_role:remove")
    @Log(title = "用户与角色对应关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tzSysUserRoleService.deleteTzSysUserRoleByIds(ids));
    }
}
