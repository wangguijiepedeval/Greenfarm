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
import com.ruoyi.Greenfarm.domain.TzProdComm;
import com.ruoyi.Greenfarm.service.ITzProdCommService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商品评论Controller
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@RestController
@RequestMapping("/tz_prod_comm")
public class TzProdCommController extends BaseController
{
    @Autowired
    private ITzProdCommService tzProdCommService;

    /**
     * 查询商品评论列表
     */
    @RequiresPermissions("Greenfarm:tz_prod_comm:list")
    @GetMapping("/list")
    public TableDataInfo list(TzProdComm tzProdComm)
    {
        startPage();
        List<TzProdComm> list = tzProdCommService.selectTzProdCommList(tzProdComm);
        return getDataTable(list);
    }

    /**
     * 导出商品评论列表
     */
    @RequiresPermissions("Greenfarm:tz_prod_comm:export")
    @Log(title = "商品评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzProdComm tzProdComm)
    {
        List<TzProdComm> list = tzProdCommService.selectTzProdCommList(tzProdComm);
        ExcelUtil<TzProdComm> util = new ExcelUtil<TzProdComm>(TzProdComm.class);
        util.exportExcel(response, list, "商品评论数据");
    }

    /**
     * 获取商品评论详细信息
     */
    @RequiresPermissions("Greenfarm:tz_prod_comm:query")
    @GetMapping(value = "/{prodCommId}")
    public AjaxResult getInfo(@PathVariable("prodCommId") Long prodCommId)
    {
        return AjaxResult.success(tzProdCommService.selectTzProdCommByProdCommId(prodCommId));
    }

    /**
     * 新增商品评论
     */
    @RequiresPermissions("Greenfarm:tz_prod_comm:add")
    @Log(title = "商品评论", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzProdComm tzProdComm)
    {
        return toAjax(tzProdCommService.insertTzProdComm(tzProdComm));
    }

    /**
     * 修改商品评论
     */
    @RequiresPermissions("Greenfarm:tz_prod_comm:edit")
    @Log(title = "商品评论", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzProdComm tzProdComm)
    {
        return toAjax(tzProdCommService.updateTzProdComm(tzProdComm));
    }

    /**
     * 删除商品评论
     */
    @RequiresPermissions("Greenfarm:tz_prod_comm:remove")
    @Log(title = "商品评论", businessType = BusinessType.DELETE)
	@DeleteMapping("/{prodCommIds}")
    public AjaxResult remove(@PathVariable Long[] prodCommIds)
    {
        return toAjax(tzProdCommService.deleteTzProdCommByProdCommIds(prodCommIds));
    }
}
