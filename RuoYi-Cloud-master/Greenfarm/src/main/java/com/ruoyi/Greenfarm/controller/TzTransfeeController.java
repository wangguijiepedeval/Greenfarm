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
import com.ruoyi.Greenfarm.domain.TzTransfee;
import com.ruoyi.Greenfarm.service.ITzTransfeeService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 运费信息Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_transfee")
public class TzTransfeeController extends BaseController
{
    @Autowired
    private ITzTransfeeService tzTransfeeService;

    /**
     * 查询运费信息列表
     */
    @RequiresPermissions("Greenfarm:tz_transfee:list")
    @GetMapping("/list")
    public TableDataInfo list(TzTransfee tzTransfee)
    {
        startPage();
        List<TzTransfee> list = tzTransfeeService.selectTzTransfeeList(tzTransfee);
        return getDataTable(list);
    }

    /**
     * 导出运费信息列表
     */
    @RequiresPermissions("Greenfarm:tz_transfee:export")
    @Log(title = "运费信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzTransfee tzTransfee)
    {
        List<TzTransfee> list = tzTransfeeService.selectTzTransfeeList(tzTransfee);
        ExcelUtil<TzTransfee> util = new ExcelUtil<TzTransfee>(TzTransfee.class);
        util.exportExcel(response, list, "运费信息数据");
    }

    /**
     * 获取运费信息详细信息
     */
    @RequiresPermissions("Greenfarm:tz_transfee:query")
    @GetMapping(value = "/{transfeeId}")
    public AjaxResult getInfo(@PathVariable("transfeeId") Long transfeeId)
    {
        return AjaxResult.success(tzTransfeeService.selectTzTransfeeByTransfeeId(transfeeId));
    }

    /**
     * 新增运费信息
     */
    @RequiresPermissions("Greenfarm:tz_transfee:add")
    @Log(title = "运费信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzTransfee tzTransfee)
    {
        return toAjax(tzTransfeeService.insertTzTransfee(tzTransfee));
    }

    /**
     * 修改运费信息
     */
    @RequiresPermissions("Greenfarm:tz_transfee:edit")
    @Log(title = "运费信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzTransfee tzTransfee)
    {
        return toAjax(tzTransfeeService.updateTzTransfee(tzTransfee));
    }

    /**
     * 删除运费信息
     */
    @RequiresPermissions("Greenfarm:tz_transfee:remove")
    @Log(title = "运费信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{transfeeIds}")
    public AjaxResult remove(@PathVariable Long[] transfeeIds)
    {
        return toAjax(tzTransfeeService.deleteTzTransfeeByTransfeeIds(transfeeIds));
    }
}
