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
import com.ruoyi.farm.domain.Goods;
import com.ruoyi.farm.service.IGoodsService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * goods管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@RestController
@RequestMapping("/goods")
public class GoodsController extends BaseController
{
    @Autowired
    private IGoodsService goodsService;

    /**
     * 查询goods管理列表
     */
    @RequiresPermissions("farm:goods:list")
    @GetMapping("/list")
    public TableDataInfo list(Goods goods)
    {
        startPage();
        List<Goods> list = goodsService.selectGoodsList(goods);
        return getDataTable(list);
    }

    /**
     * 导出goods管理列表
     */
    @RequiresPermissions("farm:goods:export")
    @Log(title = "goods管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Goods goods)
    {
        List<Goods> list = goodsService.selectGoodsList(goods);
        ExcelUtil<Goods> util = new ExcelUtil<Goods>(Goods.class);
        util.exportExcel(response, list, "goods管理数据");
    }

    /**
     * 获取goods管理详细信息
     */
    @RequiresPermissions("farm:goods:query")
    @GetMapping(value = "/{goodsid}")
    public AjaxResult getInfo(@PathVariable("goodsid") String goodsid)
    {
        return AjaxResult.success(goodsService.selectGoodsByGoodsid(goodsid));
    }

    /**
     * 新增goods管理
     */
    @RequiresPermissions("farm:goods:add")
    @Log(title = "goods管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Goods goods)
    {
        return toAjax(goodsService.insertGoods(goods));
    }

    /**
     * 修改goods管理
     */
    @RequiresPermissions("farm:goods:edit")
    @Log(title = "goods管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Goods goods)
    {
        return toAjax(goodsService.updateGoods(goods));
    }

    /**
     * 删除goods管理
     */
    @RequiresPermissions("farm:goods:remove")
    @Log(title = "goods管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{goodsids}")
    public AjaxResult remove(@PathVariable String[] goodsids)
    {
        return toAjax(goodsService.deleteGoodsByGoodsids(goodsids));
    }
}
