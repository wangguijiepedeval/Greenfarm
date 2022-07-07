package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzOrderRefund;

/**
 * 记录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface TzOrderRefundMapper 
{
    /**
     * 查询记录
     * 
     * @param refundId 记录主键
     * @return 记录
     */
    public TzOrderRefund selectTzOrderRefundByRefundId(Long refundId);

    /**
     * 查询记录列表
     * 
     * @param tzOrderRefund 记录
     * @return 记录集合
     */
    public List<TzOrderRefund> selectTzOrderRefundList(TzOrderRefund tzOrderRefund);

    /**
     * 新增记录
     * 
     * @param tzOrderRefund 记录
     * @return 结果
     */
    public int insertTzOrderRefund(TzOrderRefund tzOrderRefund);

    /**
     * 修改记录
     * 
     * @param tzOrderRefund 记录
     * @return 结果
     */
    public int updateTzOrderRefund(TzOrderRefund tzOrderRefund);

    /**
     * 删除记录
     * 
     * @param refundId 记录主键
     * @return 结果
     */
    public int deleteTzOrderRefundByRefundId(Long refundId);

    /**
     * 批量删除记录
     * 
     * @param refundIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzOrderRefundByRefundIds(Long[] refundIds);
}
