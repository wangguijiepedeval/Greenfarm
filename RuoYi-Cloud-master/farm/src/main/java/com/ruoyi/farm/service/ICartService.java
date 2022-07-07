package com.ruoyi.farm.service;

import java.util.List;
import com.ruoyi.farm.domain.Cart;

/**
 * cart管理Service接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface ICartService 
{
    /**
     * 查询cart管理
     * 
     * @param userid cart管理主键
     * @return cart管理
     */
    public Cart selectCartByUserid(String userid);

    /**
     * 查询cart管理列表
     * 
     * @param cart cart管理
     * @return cart管理集合
     */
    public List<Cart> selectCartList(Cart cart);

    /**
     * 新增cart管理
     * 
     * @param cart cart管理
     * @return 结果
     */
    public int insertCart(Cart cart);

    /**
     * 修改cart管理
     * 
     * @param cart cart管理
     * @return 结果
     */
    public int updateCart(Cart cart);

    /**
     * 批量删除cart管理
     * 
     * @param userids 需要删除的cart管理主键集合
     * @return 结果
     */
    public int deleteCartByUserids(String[] userids);

    /**
     * 删除cart管理信息
     * 
     * @param userid cart管理主键
     * @return 结果
     */
    public int deleteCartByUserid(String userid);
}
