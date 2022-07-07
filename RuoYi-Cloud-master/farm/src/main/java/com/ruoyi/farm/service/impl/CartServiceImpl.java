package com.ruoyi.farm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.farm.mapper.CartMapper;
import com.ruoyi.farm.domain.Cart;
import com.ruoyi.farm.service.ICartService;

/**
 * cart管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class CartServiceImpl implements ICartService 
{
    @Autowired
    private CartMapper cartMapper;

    /**
     * 查询cart管理
     * 
     * @param userid cart管理主键
     * @return cart管理
     */
    @Override
    public Cart selectCartByUserid(String userid)
    {
        return cartMapper.selectCartByUserid(userid);
    }

    /**
     * 查询cart管理列表
     * 
     * @param cart cart管理
     * @return cart管理
     */
    @Override
    public List<Cart> selectCartList(Cart cart)
    {
        return cartMapper.selectCartList(cart);
    }

    /**
     * 新增cart管理
     * 
     * @param cart cart管理
     * @return 结果
     */
    @Override
    public int insertCart(Cart cart)
    {
        cart.setCreateTime(DateUtils.getNowDate());
        return cartMapper.insertCart(cart);
    }

    /**
     * 修改cart管理
     * 
     * @param cart cart管理
     * @return 结果
     */
    @Override
    public int updateCart(Cart cart)
    {
        cart.setUpdateTime(DateUtils.getNowDate());
        return cartMapper.updateCart(cart);
    }

    /**
     * 批量删除cart管理
     * 
     * @param userids 需要删除的cart管理主键
     * @return 结果
     */
    @Override
    public int deleteCartByUserids(String[] userids)
    {
        return cartMapper.deleteCartByUserids(userids);
    }

    /**
     * 删除cart管理信息
     * 
     * @param userid cart管理主键
     * @return 结果
     */
    @Override
    public int deleteCartByUserid(String userid)
    {
        return cartMapper.deleteCartByUserid(userid);
    }
}
