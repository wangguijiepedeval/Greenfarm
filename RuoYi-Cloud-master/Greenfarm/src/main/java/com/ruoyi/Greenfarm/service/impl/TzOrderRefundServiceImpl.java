package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzOrderRefundMapper;
import com.ruoyi.Greenfarm.domain.TzOrderRefund;
import com.ruoyi.Greenfarm.service.ITzOrderRefundService;

/**
 * 记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class TzOrderRefundServiceImpl implements ITzOrderRefundService 
{
    @Autowired
    private TzOrderRefundMapper tzOrderRefundMapper;

    /**
     * 查询记录
     * 
     * @param refundId 记录主键
     * @return 记录
     */
    @Override
    public TzOrderRefund selectTzOrderRefundByRefundId(Long refundId)
    {
        return tzOrderRefundMapper.selectTzOrderRefundByRefundId(refundId);
    }

    /**
     * 查询记录列表
     * 
     * @param tzOrderRefund 记录
     * @return 记录
     */
    @Override
    public List<TzOrderRefund> selectTzOrderRefundList(TzOrderRefund tzOrderRefund)
    {
        return tzOrderRefundMapper.selectTzOrderRefundList(tzOrderRefund);
    }

    /**
     * 新增记录
     * 
     * @param tzOrderRefund 记录
     * @return 结果
     */
    @Override
    public int insertTzOrderRefund(TzOrderRefund tzOrderRefund)
    {
        return tzOrderRefundMapper.insertTzOrderRefund(tzOrderRefund);
    }

    /**
     * 修改记录
     * 
     * @param tzOrderRefund 记录
     * @return 结果
     */
    @Override
    public int updateTzOrderRefund(TzOrderRefund tzOrderRefund)
    {
        return tzOrderRefundMapper.updateTzOrderRefund(tzOrderRefund);
    }

    /**
     * 批量删除记录
     * 
     * @param refundIds 需要删除的记录主键
     * @return 结果
     */
    @Override
    public int deleteTzOrderRefundByRefundIds(Long[] refundIds)
    {
        return tzOrderRefundMapper.deleteTzOrderRefundByRefundIds(refundIds);
    }

    /**
     * 删除记录信息
     * 
     * @param refundId 记录主键
     * @return 结果
     */
    @Override
    public int deleteTzOrderRefundByRefundId(Long refundId)
    {
        return tzOrderRefundMapper.deleteTzOrderRefundByRefundId(refundId);
    }
}
