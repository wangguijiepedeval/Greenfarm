package com.ruoyi.farm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.farm.mapper.OrdersCustomerRelationMapper;
import com.ruoyi.farm.domain.OrdersCustomerRelation;
import com.ruoyi.farm.service.IOrdersCustomerRelationService;

/**
 * orders_customer_relation管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class OrdersCustomerRelationServiceImpl implements IOrdersCustomerRelationService 
{
    @Autowired
    private OrdersCustomerRelationMapper ordersCustomerRelationMapper;

    /**
     * 查询orders_customer_relation管理
     * 
     * @param ordersid orders_customer_relation管理主键
     * @return orders_customer_relation管理
     */
    @Override
    public OrdersCustomerRelation selectOrdersCustomerRelationByOrdersid(String ordersid)
    {
        return ordersCustomerRelationMapper.selectOrdersCustomerRelationByOrdersid(ordersid);
    }

    /**
     * 查询orders_customer_relation管理列表
     * 
     * @param ordersCustomerRelation orders_customer_relation管理
     * @return orders_customer_relation管理
     */
    @Override
    public List<OrdersCustomerRelation> selectOrdersCustomerRelationList(OrdersCustomerRelation ordersCustomerRelation)
    {
        return ordersCustomerRelationMapper.selectOrdersCustomerRelationList(ordersCustomerRelation);
    }

    /**
     * 新增orders_customer_relation管理
     * 
     * @param ordersCustomerRelation orders_customer_relation管理
     * @return 结果
     */
    @Override
    public int insertOrdersCustomerRelation(OrdersCustomerRelation ordersCustomerRelation)
    {
        ordersCustomerRelation.setCreateTime(DateUtils.getNowDate());
        return ordersCustomerRelationMapper.insertOrdersCustomerRelation(ordersCustomerRelation);
    }

    /**
     * 修改orders_customer_relation管理
     * 
     * @param ordersCustomerRelation orders_customer_relation管理
     * @return 结果
     */
    @Override
    public int updateOrdersCustomerRelation(OrdersCustomerRelation ordersCustomerRelation)
    {
        ordersCustomerRelation.setUpdateTime(DateUtils.getNowDate());
        return ordersCustomerRelationMapper.updateOrdersCustomerRelation(ordersCustomerRelation);
    }

    /**
     * 批量删除orders_customer_relation管理
     * 
     * @param ordersids 需要删除的orders_customer_relation管理主键
     * @return 结果
     */
    @Override
    public int deleteOrdersCustomerRelationByOrdersids(String[] ordersids)
    {
        return ordersCustomerRelationMapper.deleteOrdersCustomerRelationByOrdersids(ordersids);
    }

    /**
     * 删除orders_customer_relation管理信息
     * 
     * @param ordersid orders_customer_relation管理主键
     * @return 结果
     */
    @Override
    public int deleteOrdersCustomerRelationByOrdersid(String ordersid)
    {
        return ordersCustomerRelationMapper.deleteOrdersCustomerRelationByOrdersid(ordersid);
    }
}
