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
import com.ruoyi.farm.domain.Comment;
import com.ruoyi.farm.service.ICommentService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * comment管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@RestController
@RequestMapping("/comment")
public class CommentController extends BaseController
{
    @Autowired
    private ICommentService commentService;

    /**
     * 查询comment管理列表
     */
    @RequiresPermissions("farm:comment:list")
    @GetMapping("/list")
    public TableDataInfo list(Comment comment)
    {
        startPage();
        List<Comment> list = commentService.selectCommentList(comment);
        return getDataTable(list);
    }

    /**
     * 导出comment管理列表
     */
    @RequiresPermissions("farm:comment:export")
    @Log(title = "comment管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Comment comment)
    {
        List<Comment> list = commentService.selectCommentList(comment);
        ExcelUtil<Comment> util = new ExcelUtil<Comment>(Comment.class);
        util.exportExcel(response, list, "comment管理数据");
    }

    /**
     * 获取comment管理详细信息
     */
    @RequiresPermissions("farm:comment:query")
    @GetMapping(value = "/{commentatorid}")
    public AjaxResult getInfo(@PathVariable("commentatorid") String commentatorid)
    {
        return AjaxResult.success(commentService.selectCommentByCommentatorid(commentatorid));
    }

    /**
     * 新增comment管理
     */
    @RequiresPermissions("farm:comment:add")
    @Log(title = "comment管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Comment comment)
    {
        return toAjax(commentService.insertComment(comment));
    }

    /**
     * 修改comment管理
     */
    @RequiresPermissions("farm:comment:edit")
    @Log(title = "comment管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Comment comment)
    {
        return toAjax(commentService.updateComment(comment));
    }

    /**
     * 删除comment管理
     */
    @RequiresPermissions("farm:comment:remove")
    @Log(title = "comment管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{commentatorids}")
    public AjaxResult remove(@PathVariable String[] commentatorids)
    {
        return toAjax(commentService.deleteCommentByCommentatorids(commentatorids));
    }
}
