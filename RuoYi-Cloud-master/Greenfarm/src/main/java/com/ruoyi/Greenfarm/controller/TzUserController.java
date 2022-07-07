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
import com.ruoyi.Greenfarm.domain.TzUser;
import com.ruoyi.Greenfarm.service.ITzUserService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 用户Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_user")
public class TzUserController extends BaseController
{
    @Autowired
    private ITzUserService tzUserService;

    /**
     * 查询用户列表
     */
    @RequiresPermissions("Greenfarm:tz_user:list")
    @GetMapping("/list")
    public TableDataInfo list(TzUser tzUser)
    {
        startPage();
        List<TzUser> list = tzUserService.selectTzUserList(tzUser);
        return getDataTable(list);
    }

    /**
     * 导出用户列表
     */
    @RequiresPermissions("Greenfarm:tz_user:export")
    @Log(title = "用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzUser tzUser)
    {
        List<TzUser> list = tzUserService.selectTzUserList(tzUser);
        ExcelUtil<TzUser> util = new ExcelUtil<TzUser>(TzUser.class);
        util.exportExcel(response, list, "用户数据");
    }

    /**
     * 获取用户详细信息
     */
    @RequiresPermissions("Greenfarm:tz_user:query")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") String userId)
    {
        return AjaxResult.success(tzUserService.selectTzUserByUserId(userId));
    }

    /**
     * 新增用户
     */
    @RequiresPermissions("Greenfarm:tz_user:add")
    @Log(title = "用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzUser tzUser)
    {
        return toAjax(tzUserService.insertTzUser(tzUser));
    }

    /**
     * 修改用户
     */
    @RequiresPermissions("Greenfarm:tz_user:edit")
    @Log(title = "用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzUser tzUser)
    {
        return toAjax(tzUserService.updateTzUser(tzUser));
    }

    /**
     * 删除用户
     */
    @RequiresPermissions("Greenfarm:tz_user:remove")
    @Log(title = "用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable String[] userIds)
    {
        return toAjax(tzUserService.deleteTzUserByUserIds(userIds));
    }
}
