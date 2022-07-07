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
import com.ruoyi.Greenfarm.domain.TzAttachFile;
import com.ruoyi.Greenfarm.service.ITzAttachFileService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 文件管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_attach_file")
public class TzAttachFileController extends BaseController
{
    @Autowired
    private ITzAttachFileService tzAttachFileService;

    /**
     * 查询文件管理列表
     */
    @RequiresPermissions("Greenfarm:tz_attach_file:list")
    @GetMapping("/list")
    public TableDataInfo list(TzAttachFile tzAttachFile)
    {
        startPage();
        List<TzAttachFile> list = tzAttachFileService.selectTzAttachFileList(tzAttachFile);
        return getDataTable(list);
    }

    /**
     * 导出文件管理列表
     */
    @RequiresPermissions("Greenfarm:tz_attach_file:export")
    @Log(title = "文件管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzAttachFile tzAttachFile)
    {
        List<TzAttachFile> list = tzAttachFileService.selectTzAttachFileList(tzAttachFile);
        ExcelUtil<TzAttachFile> util = new ExcelUtil<TzAttachFile>(TzAttachFile.class);
        util.exportExcel(response, list, "文件管理数据");
    }

    /**
     * 获取文件管理详细信息
     */
    @RequiresPermissions("Greenfarm:tz_attach_file:query")
    @GetMapping(value = "/{fileId}")
    public AjaxResult getInfo(@PathVariable("fileId") Long fileId)
    {
        return AjaxResult.success(tzAttachFileService.selectTzAttachFileByFileId(fileId));
    }

    /**
     * 新增文件管理
     */
    @RequiresPermissions("Greenfarm:tz_attach_file:add")
    @Log(title = "文件管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzAttachFile tzAttachFile)
    {
        return toAjax(tzAttachFileService.insertTzAttachFile(tzAttachFile));
    }

    /**
     * 修改文件管理
     */
    @RequiresPermissions("Greenfarm:tz_attach_file:edit")
    @Log(title = "文件管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzAttachFile tzAttachFile)
    {
        return toAjax(tzAttachFileService.updateTzAttachFile(tzAttachFile));
    }

    /**
     * 删除文件管理
     */
    @RequiresPermissions("Greenfarm:tz_attach_file:remove")
    @Log(title = "文件管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fileIds}")
    public AjaxResult remove(@PathVariable Long[] fileIds)
    {
        return toAjax(tzAttachFileService.deleteTzAttachFileByFileIds(fileIds));
    }
}
