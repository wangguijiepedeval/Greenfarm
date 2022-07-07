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
import com.ruoyi.Greenfarm.domain.TzScoreLog;
import com.ruoyi.Greenfarm.service.ITzScoreLogService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 用户积分管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_score_log")
public class TzScoreLogController extends BaseController
{
    @Autowired
    private ITzScoreLogService tzScoreLogService;

    /**
     * 查询用户积分管理列表
     */
    @RequiresPermissions("Greenfarm:tz_score_log:list")
    @GetMapping("/list")
    public TableDataInfo list(TzScoreLog tzScoreLog)
    {
        startPage();
        List<TzScoreLog> list = tzScoreLogService.selectTzScoreLogList(tzScoreLog);
        return getDataTable(list);
    }

    /**
     * 导出用户积分管理列表
     */
    @RequiresPermissions("Greenfarm:tz_score_log:export")
    @Log(title = "用户积分管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzScoreLog tzScoreLog)
    {
        List<TzScoreLog> list = tzScoreLogService.selectTzScoreLogList(tzScoreLog);
        ExcelUtil<TzScoreLog> util = new ExcelUtil<TzScoreLog>(TzScoreLog.class);
        util.exportExcel(response, list, "用户积分管理数据");
    }

    /**
     * 获取用户积分管理详细信息
     */
    @RequiresPermissions("Greenfarm:tz_score_log:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tzScoreLogService.selectTzScoreLogById(id));
    }

    /**
     * 新增用户积分管理
     */
    @RequiresPermissions("Greenfarm:tz_score_log:add")
    @Log(title = "用户积分管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzScoreLog tzScoreLog)
    {
        return toAjax(tzScoreLogService.insertTzScoreLog(tzScoreLog));
    }

    /**
     * 修改用户积分管理
     */
    @RequiresPermissions("Greenfarm:tz_score_log:edit")
    @Log(title = "用户积分管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzScoreLog tzScoreLog)
    {
        return toAjax(tzScoreLogService.updateTzScoreLog(tzScoreLog));
    }

    /**
     * 删除用户积分管理
     */
    @RequiresPermissions("Greenfarm:tz_score_log:remove")
    @Log(title = "用户积分管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tzScoreLogService.deleteTzScoreLogByIds(ids));
    }
}
