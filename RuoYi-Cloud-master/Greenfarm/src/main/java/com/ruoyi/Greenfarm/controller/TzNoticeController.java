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
import com.ruoyi.Greenfarm.domain.TzNotice;
import com.ruoyi.Greenfarm.service.ITzNoticeService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 公告Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/tz_notice")
public class TzNoticeController extends BaseController
{
    @Autowired
    private ITzNoticeService tzNoticeService;

    /**
     * 查询公告列表
     */
    @RequiresPermissions("Greenfarm:tz_notice:list")
    @GetMapping("/list")
    public TableDataInfo list(TzNotice tzNotice)
    {
        startPage();
        List<TzNotice> list = tzNoticeService.selectTzNoticeList(tzNotice);
        return getDataTable(list);
    }

    /**
     * 导出公告列表
     */
    @RequiresPermissions("Greenfarm:tz_notice:export")
    @Log(title = "公告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzNotice tzNotice)
    {
        List<TzNotice> list = tzNoticeService.selectTzNoticeList(tzNotice);
        ExcelUtil<TzNotice> util = new ExcelUtil<TzNotice>(TzNotice.class);
        util.exportExcel(response, list, "公告数据");
    }

    /**
     * 获取公告详细信息
     */
    @RequiresPermissions("Greenfarm:tz_notice:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tzNoticeService.selectTzNoticeById(id));
    }

    /**
     * 新增公告
     */
    @RequiresPermissions("Greenfarm:tz_notice:add")
    @Log(title = "公告", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzNotice tzNotice)
    {
        return toAjax(tzNoticeService.insertTzNotice(tzNotice));
    }

    /**
     * 修改公告
     */
    @RequiresPermissions("Greenfarm:tz_notice:edit")
    @Log(title = "公告", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzNotice tzNotice)
    {
        return toAjax(tzNoticeService.updateTzNotice(tzNotice));
    }

    /**
     * 删除公告
     */
    @RequiresPermissions("Greenfarm:tz_notice:remove")
    @Log(title = "公告", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tzNoticeService.deleteTzNoticeByIds(ids));
    }
}
