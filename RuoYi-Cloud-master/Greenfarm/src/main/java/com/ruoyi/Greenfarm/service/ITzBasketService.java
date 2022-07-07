package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzBasket;

/**
 * 购物车Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzBasketService 
{
    /**
     * 查询购物车
     * 
     * @param basketId 购物车主键
     * @return 购物车
     */
    public TzBasket selectTzBasketByBasketId(Long basketId);

    /**
     * 查询购物车列表
     * 
     * @param tzBasket 购物车
     * @return 购物车集合
     */
    public List<TzBasket> selectTzBasketList(TzBasket tzBasket);

    /**
     * 新增购物车
     * 
     * @param tzBasket 购物车
     * @return 结果
     */
    public int insertTzBasket(TzBasket tzBasket);

    /**
     * 修改购物车
     * 
     * @param tzBasket 购物车
     * @return 结果
     */
    public int updateTzBasket(TzBasket tzBasket);

    /**
     * 批量删除购物车
     * 
     * @param basketIds 需要删除的购物车主键集合
     * @return 结果
     */
    public int deleteTzBasketByBasketIds(Long[] basketIds);

    /**
     * 删除购物车信息
     * 
     * @param basketId 购物车主键
     * @return 结果
     */
    public int deleteTzBasketByBasketId(Long basketId);
}
