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
import com.ruoyi.Greenfarm.domain.TzLoginHist;
import com.ruoyi.Greenfarm.service.ITzLoginHistService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 登录历史Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_login_hist")
public class TzLoginHistController extends BaseController
{
    @Autowired
    private ITzLoginHistService tzLoginHistService;

    /**
     * 查询登录历史列表
     */
    @RequiresPermissions("Greenfarm:tz_login_hist:list")
    @GetMapping("/list")
    public TableDataInfo list(TzLoginHist tzLoginHist)
    {
        startPage();
        List<TzLoginHist> list = tzLoginHistService.selectTzLoginHistList(tzLoginHist);
        return getDataTable(list);
    }

    /**
     * 导出登录历史列表
     */
    @RequiresPermissions("Greenfarm:tz_login_hist:export")
    @Log(title = "登录历史", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzLoginHist tzLoginHist)
    {
        List<TzLoginHist> list = tzLoginHistService.selectTzLoginHistList(tzLoginHist);
        ExcelUtil<TzLoginHist> util = new ExcelUtil<TzLoginHist>(TzLoginHist.class);
        util.exportExcel(response, list, "登录历史数据");
    }

    /**
     * 获取登录历史详细信息
     */
    @RequiresPermissions("Greenfarm:tz_login_hist:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tzLoginHistService.selectTzLoginHistById(id));
    }

    /**
     * 新增登录历史
     */
    @RequiresPermissions("Greenfarm:tz_login_hist:add")
    @Log(title = "登录历史", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzLoginHist tzLoginHist)
    {
        return toAjax(tzLoginHistService.insertTzLoginHist(tzLoginHist));
    }

    /**
     * 修改登录历史
     */
    @RequiresPermissions("Greenfarm:tz_login_hist:edit")
    @Log(title = "登录历史", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzLoginHist tzLoginHist)
    {
        return toAjax(tzLoginHistService.updateTzLoginHist(tzLoginHist));
    }

    /**
     * 删除登录历史
     */
    @RequiresPermissions("Greenfarm:tz_login_hist:remove")
    @Log(title = "登录历史", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tzLoginHistService.deleteTzLoginHistByIds(ids));
    }
}
