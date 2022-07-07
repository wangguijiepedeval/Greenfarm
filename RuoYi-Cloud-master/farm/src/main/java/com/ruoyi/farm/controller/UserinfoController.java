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
import com.ruoyi.farm.domain.Userinfo;
import com.ruoyi.farm.service.IUserinfoService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * userinfo管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@RestController
@RequestMapping("/userinfo")
public class UserinfoController extends BaseController
{
    @Autowired
    private IUserinfoService userinfoService;

    /**
     * 查询userinfo管理列表
     */
    @RequiresPermissions("farm:userinfo:list")
    @GetMapping("/list")
    public TableDataInfo list(Userinfo userinfo)
    {
        startPage();
        List<Userinfo> list = userinfoService.selectUserinfoList(userinfo);
        return getDataTable(list);
    }

    /**
     * 导出userinfo管理列表
     */
    @RequiresPermissions("farm:userinfo:export")
    @Log(title = "userinfo管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Userinfo userinfo)
    {
        List<Userinfo> list = userinfoService.selectUserinfoList(userinfo);
        ExcelUtil<Userinfo> util = new ExcelUtil<Userinfo>(Userinfo.class);
        util.exportExcel(response, list, "userinfo管理数据");
    }

    /**
     * 获取userinfo管理详细信息
     */
    @RequiresPermissions("farm:userinfo:query")
    @GetMapping(value = "/{uesrid}")
    public AjaxResult getInfo(@PathVariable("uesrid") String uesrid)
    {
        return AjaxResult.success(userinfoService.selectUserinfoByUesrid(uesrid));
    }

    /**
     * 新增userinfo管理
     */
    @RequiresPermissions("farm:userinfo:add")
    @Log(title = "userinfo管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Userinfo userinfo)
    {
        return toAjax(userinfoService.insertUserinfo(userinfo));
    }

    /**
     * 修改userinfo管理
     */
    @RequiresPermissions("farm:userinfo:edit")
    @Log(title = "userinfo管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Userinfo userinfo)
    {
        return toAjax(userinfoService.updateUserinfo(userinfo));
    }

    /**
     * 删除userinfo管理
     */
    @RequiresPermissions("farm:userinfo:remove")
    @Log(title = "userinfo管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{uesrids}")
    public AjaxResult remove(@PathVariable String[] uesrids)
    {
        return toAjax(userinfoService.deleteUserinfoByUesrids(uesrids));
    }
}
