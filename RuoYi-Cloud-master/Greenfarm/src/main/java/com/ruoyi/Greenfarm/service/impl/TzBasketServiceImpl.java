package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzBasketMapper;
import com.ruoyi.Greenfarm.domain.TzBasket;
import com.ruoyi.Greenfarm.service.ITzBasketService;

/**
 * 购物车Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzBasketServiceImpl implements ITzBasketService 
{
    @Autowired
    private TzBasketMapper tzBasketMapper;

    /**
     * 查询购物车
     * 
     * @param basketId 购物车主键
     * @return 购物车
     */
    @Override
    public TzBasket selectTzBasketByBasketId(Long basketId)
    {
        return tzBasketMapper.selectTzBasketByBasketId(basketId);
    }

    /**
     * 查询购物车列表
     * 
     * @param tzBasket 购物车
     * @return 购物车
     */
    @Override
    public List<TzBasket> selectTzBasketList(TzBasket tzBasket)
    {
        return tzBasketMapper.selectTzBasketList(tzBasket);
    }

    /**
     * 新增购物车
     * 
     * @param tzBasket 购物车
     * @return 结果
     */
    @Override
    public int insertTzBasket(TzBasket tzBasket)
    {
        return tzBasketMapper.insertTzBasket(tzBasket);
    }

    /**
     * 修改购物车
     * 
     * @param tzBasket 购物车
     * @return 结果
     */
    @Override
    public int updateTzBasket(TzBasket tzBasket)
    {
        return tzBasketMapper.updateTzBasket(tzBasket);
    }

    /**
     * 批量删除购物车
     * 
     * @param basketIds 需要删除的购物车主键
     * @return 结果
     */
    @Override
    public int deleteTzBasketByBasketIds(Long[] basketIds)
    {
        return tzBasketMapper.deleteTzBasketByBasketIds(basketIds);
    }

    /**
     * 删除购物车信息
     * 
     * @param basketId 购物车主键
     * @return 结果
     */
    @Override
    public int deleteTzBasketByBasketId(Long basketId)
    {
        return tzBasketMapper.deleteTzBasketByBasketId(basketId);
    }
}
