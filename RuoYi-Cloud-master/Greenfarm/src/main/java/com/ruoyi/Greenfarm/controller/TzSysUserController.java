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
import com.ruoyi.Greenfarm.domain.TzSysUser;
import com.ruoyi.Greenfarm.service.ITzSysUserService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 系统用户Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/tz_sys_user")
public class TzSysUserController extends BaseController
{
    @Autowired
    private ITzSysUserService tzSysUserService;

    /**
     * 查询系统用户列表
     */
    @RequiresPermissions("Greenfarm:tz_sys_user:list")
    @GetMapping("/list")
    public TableDataInfo list(TzSysUser tzSysUser)
    {
        startPage();
        List<TzSysUser> list = tzSysUserService.selectTzSysUserList(tzSysUser);
        return getDataTable(list);
    }

    /**
     * 导出系统用户列表
     */
    @RequiresPermissions("Greenfarm:tz_sys_user:export")
    @Log(title = "系统用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzSysUser tzSysUser)
    {
        List<TzSysUser> list = tzSysUserService.selectTzSysUserList(tzSysUser);
        ExcelUtil<TzSysUser> util = new ExcelUtil<TzSysUser>(TzSysUser.class);
        util.exportExcel(response, list, "系统用户数据");
    }

    /**
     * 获取系统用户详细信息
     */
    @RequiresPermissions("Greenfarm:tz_sys_user:query")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId)
    {
        return AjaxResult.success(tzSysUserService.selectTzSysUserByUserId(userId));
    }

    /**
     * 新增系统用户
     */
    @RequiresPermissions("Greenfarm:tz_sys_user:add")
    @Log(title = "系统用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzSysUser tzSysUser)
    {
        return toAjax(tzSysUserService.insertTzSysUser(tzSysUser));
    }

    /**
     * 修改系统用户
     */
    @RequiresPermissions("Greenfarm:tz_sys_user:edit")
    @Log(title = "系统用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzSysUser tzSysUser)
    {
        return toAjax(tzSysUserService.updateTzSysUser(tzSysUser));
    }

    /**
     * 删除系统用户
     */
    @RequiresPermissions("Greenfarm:tz_sys_user:remove")
    @Log(title = "系统用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds)
    {
        return toAjax(tzSysUserService.deleteTzSysUserByUserIds(userIds));
    }
}
