package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzOrderSettlement;

/**
 * 支付信息Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzOrderSettlementService 
{
    /**
     * 查询支付信息
     * 
     * @param settlementId 支付信息主键
     * @return 支付信息
     */
    public TzOrderSettlement selectTzOrderSettlementBySettlementId(Long settlementId);

    /**
     * 查询支付信息列表
     * 
     * @param tzOrderSettlement 支付信息
     * @return 支付信息集合
     */
    public List<TzOrderSettlement> selectTzOrderSettlementList(TzOrderSettlement tzOrderSettlement);

    /**
     * 新增支付信息
     * 
     * @param tzOrderSettlement 支付信息
     * @return 结果
     */
    public int insertTzOrderSettlement(TzOrderSettlement tzOrderSettlement);

    /**
     * 修改支付信息
     * 
     * @param tzOrderSettlement 支付信息
     * @return 结果
     */
    public int updateTzOrderSettlement(TzOrderSettlement tzOrderSettlement);

    /**
     * 批量删除支付信息
     * 
     * @param settlementIds 需要删除的支付信息主键集合
     * @return 结果
     */
    public int deleteTzOrderSettlementBySettlementIds(Long[] settlementIds);

    /**
     * 删除支付信息信息
     * 
     * @param settlementId 支付信息主键
     * @return 结果
     */
    public int deleteTzOrderSettlementBySettlementId(Long settlementId);
}
