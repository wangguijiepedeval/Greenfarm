package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzUserAddrOrder;

/**
 * 用户订单配送地址Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzUserAddrOrderService 
{
    /**
     * 查询用户订单配送地址
     * 
     * @param addrOrderId 用户订单配送地址主键
     * @return 用户订单配送地址
     */
    public TzUserAddrOrder selectTzUserAddrOrderByAddrOrderId(Long addrOrderId);

    /**
     * 查询用户订单配送地址列表
     * 
     * @param tzUserAddrOrder 用户订单配送地址
     * @return 用户订单配送地址集合
     */
    public List<TzUserAddrOrder> selectTzUserAddrOrderList(TzUserAddrOrder tzUserAddrOrder);

    /**
     * 新增用户订单配送地址
     * 
     * @param tzUserAddrOrder 用户订单配送地址
     * @return 结果
     */
    public int insertTzUserAddrOrder(TzUserAddrOrder tzUserAddrOrder);

    /**
     * 修改用户订单配送地址
     * 
     * @param tzUserAddrOrder 用户订单配送地址
     * @return 结果
     */
    public int updateTzUserAddrOrder(TzUserAddrOrder tzUserAddrOrder);

    /**
     * 批量删除用户订单配送地址
     * 
     * @param addrOrderIds 需要删除的用户订单配送地址主键集合
     * @return 结果
     */
    public int deleteTzUserAddrOrderByAddrOrderIds(Long[] addrOrderIds);

    /**
     * 删除用户订单配送地址信息
     * 
     * @param addrOrderId 用户订单配送地址主键
     * @return 结果
     */
    public int deleteTzUserAddrOrderByAddrOrderId(Long addrOrderId);
}
