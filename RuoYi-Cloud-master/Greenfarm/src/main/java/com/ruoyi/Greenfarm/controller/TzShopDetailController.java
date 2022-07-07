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
import com.ruoyi.Greenfarm.domain.TzShopDetail;
import com.ruoyi.Greenfarm.service.ITzShopDetailService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 商家管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@RestController
@RequestMapping("/tz_shop_detail")
public class TzShopDetailController extends BaseController
{
    @Autowired
    private ITzShopDetailService tzShopDetailService;

    /**
     * 查询商家管理列表
     */
    @RequiresPermissions("Greenfarm:tz_shop_detail:list")
    @GetMapping("/list")
    public TableDataInfo list(TzShopDetail tzShopDetail)
    {
        startPage();
        List<TzShopDetail> list = tzShopDetailService.selectTzShopDetailList(tzShopDetail);
        return getDataTable(list);
    }

    /**
     * 导出商家管理列表
     */
    @RequiresPermissions("Greenfarm:tz_shop_detail:export")
    @Log(title = "商家管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TzShopDetail tzShopDetail)
    {
        List<TzShopDetail> list = tzShopDetailService.selectTzShopDetailList(tzShopDetail);
        ExcelUtil<TzShopDetail> util = new ExcelUtil<TzShopDetail>(TzShopDetail.class);
        util.exportExcel(response, list, "商家管理数据");
    }

    /**
     * 获取商家管理详细信息
     */
    @RequiresPermissions("Greenfarm:tz_shop_detail:query")
    @GetMapping(value = "/{shopId}")
    public AjaxResult getInfo(@PathVariable("shopId") Long shopId)
    {
        return AjaxResult.success(tzShopDetailService.selectTzShopDetailByShopId(shopId));
    }

    /**
     * 新增商家管理
     */
    @RequiresPermissions("Greenfarm:tz_shop_detail:add")
    @Log(title = "商家管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TzShopDetail tzShopDetail)
    {
        return toAjax(tzShopDetailService.insertTzShopDetail(tzShopDetail));
    }

    /**
     * 修改商家管理
     */
    @RequiresPermissions("Greenfarm:tz_shop_detail:edit")
    @Log(title = "商家管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TzShopDetail tzShopDetail)
    {
        return toAjax(tzShopDetailService.updateTzShopDetail(tzShopDetail));
    }

    /**
     * 删除商家管理
     */
    @RequiresPermissions("Greenfarm:tz_shop_detail:remove")
    @Log(title = "商家管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{shopIds}")
    public AjaxResult remove(@PathVariable Long[] shopIds)
    {
        return toAjax(tzShopDetailService.deleteTzShopDetailByShopIds(shopIds));
    }
}
