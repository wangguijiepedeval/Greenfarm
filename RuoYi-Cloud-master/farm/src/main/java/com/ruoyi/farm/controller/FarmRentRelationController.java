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
import com.ruoyi.farm.domain.FarmRentRelation;
import com.ruoyi.farm.service.IFarmRentRelationService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * rent_relation管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@RestController
@RequestMapping("/rent_relation")
public class FarmRentRelationController extends BaseController
{
    @Autowired
    private IFarmRentRelationService farmRentRelationService;

    /**
     * 查询rent_relation管理列表
     */
    @RequiresPermissions("farm:rent_relation:list")
    @GetMapping("/list")
    public TableDataInfo list(FarmRentRelation farmRentRelation)
    {
        startPage();
        List<FarmRentRelation> list = farmRentRelationService.selectFarmRentRelationList(farmRentRelation);
        return getDataTable(list);
    }

    /**
     * 导出rent_relation管理列表
     */
    @RequiresPermissions("farm:rent_relation:export")
    @Log(title = "rent_relation管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FarmRentRelation farmRentRelation)
    {
        List<FarmRentRelation> list = farmRentRelationService.selectFarmRentRelationList(farmRentRelation);
        ExcelUtil<FarmRentRelation> util = new ExcelUtil<FarmRentRelation>(FarmRentRelation.class);
        util.exportExcel(response, list, "rent_relation管理数据");
    }

    /**
     * 获取rent_relation管理详细信息
     */
    @RequiresPermissions("farm:rent_relation:query")
    @GetMapping(value = "/{userid}")
    public AjaxResult getInfo(@PathVariable("userid") String userid)
    {
        return AjaxResult.success(farmRentRelationService.selectFarmRentRelationByUserid(userid));
    }

    /**
     * 新增rent_relation管理
     */
    @RequiresPermissions("farm:rent_relation:add")
    @Log(title = "rent_relation管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FarmRentRelation farmRentRelation)
    {
        return toAjax(farmRentRelationService.insertFarmRentRelation(farmRentRelation));
    }

    /**
     * 修改rent_relation管理
     */
    @RequiresPermissions("farm:rent_relation:edit")
    @Log(title = "rent_relation管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FarmRentRelation farmRentRelation)
    {
        return toAjax(farmRentRelationService.updateFarmRentRelation(farmRentRelation));
    }

    /**
     * 删除rent_relation管理
     */
    @RequiresPermissions("farm:rent_relation:remove")
    @Log(title = "rent_relation管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userids}")
    public AjaxResult remove(@PathVariable String[] userids)
    {
        return toAjax(farmRentRelationService.deleteFarmRentRelationByUserids(userids));
    }
}
