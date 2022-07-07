package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzOrderMapper;
import com.ruoyi.Greenfarm.domain.TzOrder;
import com.ruoyi.Greenfarm.service.ITzOrderService;

/**
 * 订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class TzOrderServiceImpl implements ITzOrderService 
{
    @Autowired
    private TzOrderMapper tzOrderMapper;

    /**
     * 查询订单
     * 
     * @param orderId 订单主键
     * @return 订单
     */
    @Override
    public TzOrder selectTzOrderByOrderId(Long orderId)
    {
        return tzOrderMapper.selectTzOrderByOrderId(orderId);
    }

    /**
     * 查询订单列表
     * 
     * @param tzOrder 订单
     * @return 订单
     */
    @Override
    public List<TzOrder> selectTzOrderList(TzOrder tzOrder)
    {
        return tzOrderMapper.selectTzOrderList(tzOrder);
    }

    /**
     * 新增订单
     * 
     * @param tzOrder 订单
     * @return 结果
     */
    @Override
    public int insertTzOrder(TzOrder tzOrder)
    {
        tzOrder.setCreateTime(DateUtils.getNowDate());
        return tzOrderMapper.insertTzOrder(tzOrder);
    }

    /**
     * 修改订单
     * 
     * @param tzOrder 订单
     * @return 结果
     */
    @Override
    public int updateTzOrder(TzOrder tzOrder)
    {
        tzOrder.setUpdateTime(DateUtils.getNowDate());
        return tzOrderMapper.updateTzOrder(tzOrder);
    }

    /**
     * 批量删除订单
     * 
     * @param orderIds 需要删除的订单主键
     * @return 结果
     */
    @Override
    public int deleteTzOrderByOrderIds(Long[] orderIds)
    {
        return tzOrderMapper.deleteTzOrderByOrderIds(orderIds);
    }

    /**
     * 删除订单信息
     * 
     * @param orderId 订单主键
     * @return 结果
     */
    @Override
    public int deleteTzOrderByOrderId(Long orderId)
    {
        return tzOrderMapper.deleteTzOrderByOrderId(orderId);
    }
}
