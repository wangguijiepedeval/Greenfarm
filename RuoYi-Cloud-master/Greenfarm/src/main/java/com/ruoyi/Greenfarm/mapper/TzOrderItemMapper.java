package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzOrderItem;

/**
 * 订单项Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface TzOrderItemMapper 
{
    /**
     * 查询订单项
     * 
     * @param orderItemId 订单项主键
     * @return 订单项
     */
    public TzOrderItem selectTzOrderItemByOrderItemId(Long orderItemId);

    /**
     * 查询订单项列表
     * 
     * @param tzOrderItem 订单项
     * @return 订单项集合
     */
    public List<TzOrderItem> selectTzOrderItemList(TzOrderItem tzOrderItem);

    /**
     * 新增订单项
     * 
     * @param tzOrderItem 订单项
     * @return 结果
     */
    public int insertTzOrderItem(TzOrderItem tzOrderItem);

    /**
     * 修改订单项
     * 
     * @param tzOrderItem 订单项
     * @return 结果
     */
    public int updateTzOrderItem(TzOrderItem tzOrderItem);

    /**
     * 删除订单项
     * 
     * @param orderItemId 订单项主键
     * @return 结果
     */
    public int deleteTzOrderItemByOrderItemId(Long orderItemId);

    /**
     * 批量删除订单项
     * 
     * @param orderItemIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzOrderItemByOrderItemIds(Long[] orderItemIds);
}
