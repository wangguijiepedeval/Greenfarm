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
import com.ruoyi.Greenfarm.domain.TzSensWord;
import com.ruoyi.Greenfarm.service.ITzSensWordService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 敏感字过滤Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_sens_word")
public class TzSensWordController extends BaseController
{
    @Autowired
    private ITzSensWordService tzSensWordService;

    /**
     * 查询敏感字过滤列表
     */
    @RequiresPermissions("Greenfarm:tz_sens_word:list")
    @GetMapping("/list")
    public TableDataInfo list(TzSensWord tzSensWord)
    {
        startPage();
        List<TzSensWord> list = tzSensWordService.selectTzSensWordList(tzSensWord);
        return getDataTable(list);
    }

    /**
     * 导出敏感字过滤列表
     */
    @RequiresPermissions("Greenfarm:tz_sens_word:export")
    @Log(title = "敏感字过滤", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzSensWord tzSensWord)
    {
        List<TzSensWord> list = tzSensWordService.selectTzSensWordList(tzSensWord);
        ExcelUtil<TzSensWord> util = new ExcelUtil<TzSensWord>(TzSensWord.class);
        util.exportExcel(response, list, "敏感字过滤数据");
    }

    /**
     * 获取敏感字过滤详细信息
     */
    @RequiresPermissions("Greenfarm:tz_sens_word:query")
    @GetMapping(value = "/{sensId}")
    public AjaxResult getInfo(@PathVariable("sensId") Long sensId)
    {
        return AjaxResult.success(tzSensWordService.selectTzSensWordBySensId(sensId));
    }

    /**
     * 新增敏感字过滤
     */
    @RequiresPermissions("Greenfarm:tz_sens_word:add")
    @Log(title = "敏感字过滤", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzSensWord tzSensWord)
    {
        return toAjax(tzSensWordService.insertTzSensWord(tzSensWord));
    }

    /**
     * 修改敏感字过滤
     */
    @RequiresPermissions("Greenfarm:tz_sens_word:edit")
    @Log(title = "敏感字过滤", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzSensWord tzSensWord)
    {
        return toAjax(tzSensWordService.updateTzSensWord(tzSensWord));
    }

    /**
     * 删除敏感字过滤
     */
    @RequiresPermissions("Greenfarm:tz_sens_word:remove")
    @Log(title = "敏感字过滤", businessType = BusinessType.DELETE)
	@DeleteMapping("/{sensIds}")
    public AjaxResult remove(@PathVariable Long[] sensIds)
    {
        return toAjax(tzSensWordService.deleteTzSensWordBySensIds(sensIds));
    }
}
