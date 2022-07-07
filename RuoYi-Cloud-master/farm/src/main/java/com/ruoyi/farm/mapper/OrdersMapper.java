package com.ruoyi.farm.mapper;

import java.util.List;
import com.ruoyi.farm.domain.Orders;

/**
 * orders管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface OrdersMapper 
{
    /**
     * 查询orders管理
     * 
     * @param orderid orders管理主键
     * @return orders管理
     */
    public Orders selectOrdersByOrderid(String orderid);

    /**
     * 查询orders管理列表
     * 
     * @param orders orders管理
     * @return orders管理集合
     */
    public List<Orders> selectOrdersList(Orders orders);

    /**
     * 新增orders管理
     * 
     * @param orders orders管理
     * @return 结果
     */
    public int insertOrders(Orders orders);

    /**
     * 修改orders管理
     * 
     * @param orders orders管理
     * @return 结果
     */
    public int updateOrders(Orders orders);

    /**
     * 删除orders管理
     * 
     * @param orderid orders管理主键
     * @return 结果
     */
    public int deleteOrdersByOrderid(String orderid);

    /**
     * 批量删除orders管理
     * 
     * @param orderids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrdersByOrderids(String[] orderids);
}
