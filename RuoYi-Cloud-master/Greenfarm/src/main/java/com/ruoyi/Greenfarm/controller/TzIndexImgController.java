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
import com.ruoyi.Greenfarm.domain.TzIndexImg;
import com.ruoyi.Greenfarm.service.ITzIndexImgService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 主页轮播图Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_index_img")
public class TzIndexImgController extends BaseController
{
    @Autowired
    private ITzIndexImgService tzIndexImgService;

    /**
     * 查询主页轮播图列表
     */
    @RequiresPermissions("Greenfarm:tz_index_img:list")
    @GetMapping("/list")
    public TableDataInfo list(TzIndexImg tzIndexImg)
    {
        startPage();
        List<TzIndexImg> list = tzIndexImgService.selectTzIndexImgList(tzIndexImg);
        return getDataTable(list);
    }

    /**
     * 导出主页轮播图列表
     */
    @RequiresPermissions("Greenfarm:tz_index_img:export")
    @Log(title = "主页轮播图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzIndexImg tzIndexImg)
    {
        List<TzIndexImg> list = tzIndexImgService.selectTzIndexImgList(tzIndexImg);
        ExcelUtil<TzIndexImg> util = new ExcelUtil<TzIndexImg>(TzIndexImg.class);
        util.exportExcel(response, list, "主页轮播图数据");
    }

    /**
     * 获取主页轮播图详细信息
     */
    @RequiresPermissions("Greenfarm:tz_index_img:query")
    @GetMapping(value = "/{imgId}")
    public AjaxResult getInfo(@PathVariable("imgId") Long imgId)
    {
        return AjaxResult.success(tzIndexImgService.selectTzIndexImgByImgId(imgId));
    }

    /**
     * 新增主页轮播图
     */
    @RequiresPermissions("Greenfarm:tz_index_img:add")
    @Log(title = "主页轮播图", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzIndexImg tzIndexImg)
    {
        return toAjax(tzIndexImgService.insertTzIndexImg(tzIndexImg));
    }

    /**
     * 修改主页轮播图
     */
    @RequiresPermissions("Greenfarm:tz_index_img:edit")
    @Log(title = "主页轮播图", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzIndexImg tzIndexImg)
    {
        return toAjax(tzIndexImgService.updateTzIndexImg(tzIndexImg));
    }

    /**
     * 删除主页轮播图
     */
    @RequiresPermissions("Greenfarm:tz_index_img:remove")
    @Log(title = "主页轮播图", businessType = BusinessType.DELETE)
	@DeleteMapping("/{imgIds}")
    public AjaxResult remove(@PathVariable Long[] imgIds)
    {
        return toAjax(tzIndexImgService.deleteTzIndexImgByImgIds(imgIds));
    }
}
