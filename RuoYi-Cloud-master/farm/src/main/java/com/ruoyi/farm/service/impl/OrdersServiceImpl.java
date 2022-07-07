package com.ruoyi.farm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.farm.mapper.OrdersMapper;
import com.ruoyi.farm.domain.Orders;
import com.ruoyi.farm.service.IOrdersService;

/**
 * orders管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class OrdersServiceImpl implements IOrdersService 
{
    @Autowired
    private OrdersMapper ordersMapper;

    /**
     * 查询orders管理
     * 
     * @param orderid orders管理主键
     * @return orders管理
     */
    @Override
    public Orders selectOrdersByOrderid(String orderid)
    {
        return ordersMapper.selectOrdersByOrderid(orderid);
    }

    /**
     * 查询orders管理列表
     * 
     * @param orders orders管理
     * @return orders管理
     */
    @Override
    public List<Orders> selectOrdersList(Orders orders)
    {
        return ordersMapper.selectOrdersList(orders);
    }

    /**
     * 新增orders管理
     * 
     * @param orders orders管理
     * @return 结果
     */
    @Override
    public int insertOrders(Orders orders)
    {
        orders.setCreateTime(DateUtils.getNowDate());
        return ordersMapper.insertOrders(orders);
    }

    /**
     * 修改orders管理
     * 
     * @param orders orders管理
     * @return 结果
     */
    @Override
    public int updateOrders(Orders orders)
    {
        orders.setUpdateTime(DateUtils.getNowDate());
        return ordersMapper.updateOrders(orders);
    }

    /**
     * 批量删除orders管理
     * 
     * @param orderids 需要删除的orders管理主键
     * @return 结果
     */
    @Override
    public int deleteOrdersByOrderids(String[] orderids)
    {
        return ordersMapper.deleteOrdersByOrderids(orderids);
    }

    /**
     * 删除orders管理信息
     * 
     * @param orderid orders管理主键
     * @return 结果
     */
    @Override
    public int deleteOrdersByOrderid(String orderid)
    {
        return ordersMapper.deleteOrdersByOrderid(orderid);
    }
}
