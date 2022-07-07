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
import com.ruoyi.farm.domain.Cart;
import com.ruoyi.farm.service.ICartService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * cart管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@RestController
@RequestMapping("/cart")
public class CartController extends BaseController
{
    @Autowired
    private ICartService cartService;

    /**
     * 查询cart管理列表
     */
    @RequiresPermissions("farm:cart:list")
    @GetMapping("/list")
    public TableDataInfo list(Cart cart)
    {
        startPage();
        List<Cart> list = cartService.selectCartList(cart);
        return getDataTable(list);
    }

    /**
     * 导出cart管理列表
     */
    @RequiresPermissions("farm:cart:export")
    @Log(title = "cart管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Cart cart)
    {
        List<Cart> list = cartService.selectCartList(cart);
        ExcelUtil<Cart> util = new ExcelUtil<Cart>(Cart.class);
        util.exportExcel(response, list, "cart管理数据");
    }

    /**
     * 获取cart管理详细信息
     */
    @RequiresPermissions("farm:cart:query")
    @GetMapping(value = "/{userid}")
    public AjaxResult getInfo(@PathVariable("userid") String userid)
    {
        return AjaxResult.success(cartService.selectCartByUserid(userid));
    }

    /**
     * 新增cart管理
     */
    @RequiresPermissions("farm:cart:add")
    @Log(title = "cart管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Cart cart)
    {
        return toAjax(cartService.insertCart(cart));
    }

    /**
     * 修改cart管理
     */
    @RequiresPermissions("farm:cart:edit")
    @Log(title = "cart管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Cart cart)
    {
        return toAjax(cartService.updateCart(cart));
    }

    /**
     * 删除cart管理
     */
    @RequiresPermissions("farm:cart:remove")
    @Log(title = "cart管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userids}")
    public AjaxResult remove(@PathVariable String[] userids)
    {
        return toAjax(cartService.deleteCartByUserids(userids));
    }
}
