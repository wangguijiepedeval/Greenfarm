package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzOrderItemMapper;
import com.ruoyi.Greenfarm.domain.TzOrderItem;
import com.ruoyi.Greenfarm.service.ITzOrderItemService;

/**
 * 订单项Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class TzOrderItemServiceImpl implements ITzOrderItemService 
{
    @Autowired
    private TzOrderItemMapper tzOrderItemMapper;

    /**
     * 查询订单项
     * 
     * @param orderItemId 订单项主键
     * @return 订单项
     */
    @Override
    public TzOrderItem selectTzOrderItemByOrderItemId(Long orderItemId)
    {
        return tzOrderItemMapper.selectTzOrderItemByOrderItemId(orderItemId);
    }

    /**
     * 查询订单项列表
     * 
     * @param tzOrderItem 订单项
     * @return 订单项
     */
    @Override
    public List<TzOrderItem> selectTzOrderItemList(TzOrderItem tzOrderItem)
    {
        return tzOrderItemMapper.selectTzOrderItemList(tzOrderItem);
    }

    /**
     * 新增订单项
     * 
     * @param tzOrderItem 订单项
     * @return 结果
     */
    @Override
    public int insertTzOrderItem(TzOrderItem tzOrderItem)
    {
        return tzOrderItemMapper.insertTzOrderItem(tzOrderItem);
    }

    /**
     * 修改订单项
     * 
     * @param tzOrderItem 订单项
     * @return 结果
     */
    @Override
    public int updateTzOrderItem(TzOrderItem tzOrderItem)
    {
        return tzOrderItemMapper.updateTzOrderItem(tzOrderItem);
    }

    /**
     * 批量删除订单项
     * 
     * @param orderItemIds 需要删除的订单项主键
     * @return 结果
     */
    @Override
    public int deleteTzOrderItemByOrderItemIds(Long[] orderItemIds)
    {
        return tzOrderItemMapper.deleteTzOrderItemByOrderItemIds(orderItemIds);
    }

    /**
     * 删除订单项信息
     * 
     * @param orderItemId 订单项主键
     * @return 结果
     */
    @Override
    public int deleteTzOrderItemByOrderItemId(Long orderItemId)
    {
        return tzOrderItemMapper.deleteTzOrderItemByOrderItemId(orderItemId);
    }
}
