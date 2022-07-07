package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzOrder;

/**
 * 订单Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface TzOrderMapper 
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
     * 删除订单
     * 
     * @param orderId 订单主键
     * @return 结果
     */
    public int deleteTzOrderByOrderId(Long orderId);

    /**
     * 批量删除订单
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzOrderByOrderIds(Long[] orderIds);
}
