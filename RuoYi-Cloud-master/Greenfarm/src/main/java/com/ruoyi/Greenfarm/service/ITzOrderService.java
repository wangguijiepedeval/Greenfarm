package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzOrder;

/**
 * 订单Service接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface ITzOrderService 
{
    /**
     * 查询订单
     * 
     * @param orderId 订单主键
     * @return 订单
     */
    public TzOrder selectTzOrderByOrderId(Long orderId);

    /**
     * 查询订单列表
     * 
     * @param tzOrder 订单
     * @return 订单集合
     */
    public List<TzOrder> selectTzOrderList(TzOrder tzOrder);

    /**
     * 新增订单
     * 
     * @param tzOrder 订单
     * @return 结果
     */
    public int insertTzOrder(TzOrder tzOrder);

    /**
     * 修改订单
     * 
     * @param tzOrder 订单
     * @return 结果
     */
    public int updateTzOrder(TzOrder tzOrder);

    /**
     * 批量删除订单
     * 
     * @param orderIds 需要删除的订单主键集合
     * @return 结果
     */
    public int deleteTzOrderByOrderIds(Long[] orderIds);

    /**
     * 删除订单信息
     * 
     * @param orderId 订单主键
     * @return 结果
     */
    public int deleteTzOrderByOrderId(Long orderId);
}
