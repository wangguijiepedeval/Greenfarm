package com.ruoyi.farm.service;

import java.util.List;
import com.ruoyi.farm.domain.OrdersCustomerRelation;

/**
 * orders_customer_relation管理Service接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface IOrdersCustomerRelationService 
{
    /**
     * 查询orders_customer_relation管理
     * 
     * @param ordersid orders_customer_relation管理主键
     * @return orders_customer_relation管理
     */
    public OrdersCustomerRelation selectOrdersCustomerRelationByOrdersid(String ordersid);

    /**
     * 查询orders_customer_relation管理列表
     * 
     * @param ordersCustomerRelation orders_customer_relation管理
     * @return orders_customer_relation管理集合
     */
    public List<OrdersCustomerRelation> selectOrdersCustomerRelationList(OrdersCustomerRelation ordersCustomerRelation);

    /**
     * 新增orders_customer_relation管理
     * 
     * @param ordersCustomerRelation orders_customer_relation管理
     * @return 结果
     */
    public int insertOrdersCustomerRelation(OrdersCustomerRelation ordersCustomerRelation);

    /**
     * 修改orders_customer_relation管理
     * 
     * @param ordersCustomerRelation orders_customer_relation管理
     * @return 结果
     */
    public int updateOrdersCustomerRelation(OrdersCustomerRelation ordersCustomerRelation);

    /**
     * 批量删除orders_customer_relation管理
     * 
     * @param ordersids 需要删除的orders_customer_relation管理主键集合
     * @return 结果
     */
    public int deleteOrdersCustomerRelationByOrdersids(String[] ordersids);

    /**
     * 删除orders_customer_relation管理信息
     * 
     * @param ordersid orders_customer_relation管理主键
     * @return 结果
     */
    public int deleteOrdersCustomerRelationByOrdersid(String ordersid);
}
