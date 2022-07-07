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
import com.ruoyi.farm.domain.Message;
import com.ruoyi.farm.service.IMessageService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * message管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@RestController
@RequestMapping("/message")
public class MessageController extends BaseController
{
    @Autowired
    private IMessageService messageService;

    /**
     * 查询message管理列表
     */
    @RequiresPermissions("farm:message:list")
    @GetMapping("/list")
    public TableDataInfo list(Message message)
    {
        startPage();
        List<Message> list = messageService.selectMessageList(message);
        return getDataTable(list);
    }

    /**
     * 导出message管理列表
     */
    @RequiresPermissions("farm:message:export")
    @Log(title = "message管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Message message)
    {
        List<Message> list = messageService.selectMessageList(message);
        ExcelUtil<Message> util = new ExcelUtil<Message>(Message.class);
        util.exportExcel(response, list, "message管理数据");
    }

    /**
     * 获取message管理详细信息
     */
    @RequiresPermissions("farm:message:query")
    @GetMapping(value = "/{messageid}")
    public AjaxResult getInfo(@PathVariable("messageid") Long messageid)
    {
        return AjaxResult.success(messageService.selectMessageByMessageid(messageid));
    }

    /**
     * 新增message管理
     */
    @RequiresPermissions("farm:message:add")
    @Log(title = "message管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Message message)
    {
        return toAjax(messageService.insertMessage(message));
    }

    /**
     * 修改message管理
     */
    @RequiresPermissions("farm:message:edit")
    @Log(title = "message管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Message message)
    {
        return toAjax(messageService.updateMessage(message));
    }

    /**
     * 删除message管理
     */
    @RequiresPermissions("farm:message:remove")
    @Log(title = "message管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{messageids}")
    public AjaxResult remove(@PathVariable Long[] messageids)
    {
        return toAjax(messageService.deleteMessageByMessageids(messageids));
    }
}
