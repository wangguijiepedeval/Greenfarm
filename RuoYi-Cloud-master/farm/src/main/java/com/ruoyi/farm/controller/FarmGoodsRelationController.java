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
import com.ruoyi.farm.domain.FarmGoodsRelation;
import com.ruoyi.farm.service.IFarmGoodsRelationService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * goods_relation管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@RestController
@RequestMapping("/goods_relation")
public class FarmGoodsRelationController extends BaseController
{
    @Autowired
    private IFarmGoodsRelationService farmGoodsRelationService;

    /**
     * 查询goods_relation管理列表
     */
    @RequiresPermissions("farm:goods_relation:list")
    @GetMapping("/list")
    public TableDataInfo list(FarmGoodsRelation farmGoodsRelation)
    {
        startPage();
        List<FarmGoodsRelation> list = farmGoodsRelationService.selectFarmGoodsRelationList(farmGoodsRelation);
        return getDataTable(list);
    }

    /**
     * 导出goods_relation管理列表
     */
    @RequiresPermissions("farm:goods_relation:export")
    @Log(title = "goods_relation管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FarmGoodsRelation farmGoodsRelation)
    {
        List<FarmGoodsRelation> list = farmGoodsRelationService.selectFarmGoodsRelationList(farmGoodsRelation);
        ExcelUtil<FarmGoodsRelation> util = new ExcelUtil<FarmGoodsRelation>(FarmGoodsRelation.class);
        util.exportExcel(response, list, "goods_relation管理数据");
    }

    /**
     * 获取goods_relation管理详细信息
     */
    @RequiresPermissions("farm:goods_relation:query")
    @GetMapping(value = "/{farmid}")
    public AjaxResult getInfo(@PathVariable("farmid") String farmid)
    {
        return AjaxResult.success(farmGoodsRelationService.selectFarmGoodsRelationByFarmid(farmid));
    }

    /**
     * 新增goods_relation管理
     */
    @RequiresPermissions("farm:goods_relation:add")
    @Log(title = "goods_relation管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FarmGoodsRelation farmGoodsRelation)
    {
        return toAjax(farmGoodsRelationService.insertFarmGoodsRelation(farmGoodsRelation));
    }

    /**
     * 修改goods_relation管理
     */
    @RequiresPermissions("farm:goods_relation:edit")
    @Log(title = "goods_relation管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FarmGoodsRelation farmGoodsRelation)
    {
        return toAjax(farmGoodsRelationService.updateFarmGoodsRelation(farmGoodsRelation));
    }

    /**
     * 删除goods_relation管理
     */
    @RequiresPermissions("farm:goods_relation:remove")
    @Log(title = "goods_relation管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{farmids}")
    public AjaxResult remove(@PathVariable String[] farmids)
    {
        return toAjax(farmGoodsRelationService.deleteFarmGoodsRelationByFarmids(farmids));
    }
}
