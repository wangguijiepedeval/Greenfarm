package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzUserAddrOrderMapper;
import com.ruoyi.Greenfarm.domain.TzUserAddrOrder;
import com.ruoyi.Greenfarm.service.ITzUserAddrOrderService;

/**
 * 用户订单配送地址Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzUserAddrOrderServiceImpl implements ITzUserAddrOrderService 
{
    @Autowired
    private TzUserAddrOrderMapper tzUserAddrOrderMapper;

    /**
     * 查询用户订单配送地址
     * 
     * @param addrOrderId 用户订单配送地址主键
     * @return 用户订单配送地址
     */
    @Override
    public TzUserAddrOrder selectTzUserAddrOrderByAddrOrderId(Long addrOrderId)
    {
        return tzUserAddrOrderMapper.selectTzUserAddrOrderByAddrOrderId(addrOrderId);
    }

    /**
     * 查询用户订单配送地址列表
     * 
     * @param tzUserAddrOrder 用户订单配送地址
     * @return 用户订单配送地址
     */
    @Override
    public List<TzUserAddrOrder> selectTzUserAddrOrderList(TzUserAddrOrder tzUserAddrOrder)
    {
        return tzUserAddrOrderMapper.selectTzUserAddrOrderList(tzUserAddrOrder);
    }

    /**
     * 新增用户订单配送地址
     * 
     * @param tzUserAddrOrder 用户订单配送地址
     * @return 结果
     */
    @Override
    public int insertTzUserAddrOrder(TzUserAddrOrder tzUserAddrOrder)
    {
        tzUserAddrOrder.setCreateTime(DateUtils.getNowDate());
        return tzUserAddrOrderMapper.insertTzUserAddrOrder(tzUserAddrOrder);
    }

    /**
     * 修改用户订单配送地址
     * 
     * @param tzUserAddrOrder 用户订单配送地址
     * @return 结果
     */
    @Override
    public int updateTzUserAddrOrder(TzUserAddrOrder tzUserAddrOrder)
    {
        return tzUserAddrOrderMapper.updateTzUserAddrOrder(tzUserAddrOrder);
    }

    /**
     * 批量删除用户订单配送地址
     * 
     * @param addrOrderIds 需要删除的用户订单配送地址主键
     * @return 结果
     */
    @Override
    public int deleteTzUserAddrOrderByAddrOrderIds(Long[] addrOrderIds)
    {
        return tzUserAddrOrderMapper.deleteTzUserAddrOrderByAddrOrderIds(addrOrderIds);
    }

    /**
     * 删除用户订单配送地址信息
     * 
     * @param addrOrderId 用户订单配送地址主键
     * @return 结果
     */
    @Override
    public int deleteTzUserAddrOrderByAddrOrderId(Long addrOrderId)
    {
        return tzUserAddrOrderMapper.deleteTzUserAddrOrderByAddrOrderId(addrOrderId);
    }
}
