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
import com.ruoyi.Greenfarm.domain.TzMessage;
import com.ruoyi.Greenfarm.service.ITzMessageService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 个人消息Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_message")
public class TzMessageController extends BaseController
{
    @Autowired
    private ITzMessageService tzMessageService;

    /**
     * 查询个人消息列表
     */
    @RequiresPermissions("Greenfarm:tz_message:list")
    @GetMapping("/list")
    public TableDataInfo list(TzMessage tzMessage)
    {
        startPage();
        List<TzMessage> list = tzMessageService.selectTzMessageList(tzMessage);
        return getDataTable(list);
    }

    /**
     * 导出个人消息列表
     */
    @RequiresPermissions("Greenfarm:tz_message:export")
    @Log(title = "个人消息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzMessage tzMessage)
    {
        List<TzMessage> list = tzMessageService.selectTzMessageList(tzMessage);
        ExcelUtil<TzMessage> util = new ExcelUtil<TzMessage>(TzMessage.class);
        util.exportExcel(response, list, "个人消息数据");
    }

    /**
     * 获取个人消息详细信息
     */
    @RequiresPermissions("Greenfarm:tz_message:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(tzMessageService.selectTzMessageById(id));
    }

    /**
     * 新增个人消息
     */
    @RequiresPermissions("Greenfarm:tz_message:add")
    @Log(title = "个人消息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzMessage tzMessage)
    {
        return toAjax(tzMessageService.insertTzMessage(tzMessage));
    }

    /**
     * 修改个人消息
     */
    @RequiresPermissions("Greenfarm:tz_message:edit")
    @Log(title = "个人消息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzMessage tzMessage)
    {
        return toAjax(tzMessageService.updateTzMessage(tzMessage));
    }

    /**
     * 删除个人消息
     */
    @RequiresPermissions("Greenfarm:tz_message:remove")
    @Log(title = "个人消息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(tzMessageService.deleteTzMessageByIds(ids));
    }
}
