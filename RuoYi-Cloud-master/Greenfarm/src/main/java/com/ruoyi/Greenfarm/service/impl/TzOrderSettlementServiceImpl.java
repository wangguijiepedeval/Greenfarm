package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzOrderSettlementMapper;
import com.ruoyi.Greenfarm.domain.TzOrderSettlement;
import com.ruoyi.Greenfarm.service.ITzOrderSettlementService;

/**
 * 支付信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzOrderSettlementServiceImpl implements ITzOrderSettlementService 
{
    @Autowired
    private TzOrderSettlementMapper tzOrderSettlementMapper;

    /**
     * 查询支付信息
     * 
     * @param settlementId 支付信息主键
     * @return 支付信息
     */
    @Override
    public TzOrderSettlement selectTzOrderSettlementBySettlementId(Long settlementId)
    {
        return tzOrderSettlementMapper.selectTzOrderSettlementBySettlementId(settlementId);
    }

    /**
     * 查询支付信息列表
     * 
     * @param tzOrderSettlement 支付信息
     * @return 支付信息
     */
    @Override
    public List<TzOrderSettlement> selectTzOrderSettlementList(TzOrderSettlement tzOrderSettlement)
    {
        return tzOrderSettlementMapper.selectTzOrderSettlementList(tzOrderSettlement);
    }

    /**
     * 新增支付信息
     * 
     * @param tzOrderSettlement 支付信息
     * @return 结果
     */
    @Override
    public int insertTzOrderSettlement(TzOrderSettlement tzOrderSettlement)
    {
        tzOrderSettlement.setCreateTime(DateUtils.getNowDate());
        return tzOrderSettlementMapper.insertTzOrderSettlement(tzOrderSettlement);
    }

    /**
     * 修改支付信息
     * 
     * @param tzOrderSettlement 支付信息
     * @return 结果
     */
    @Override
    public int updateTzOrderSettlement(TzOrderSettlement tzOrderSettlement)
    {
        return tzOrderSettlementMapper.updateTzOrderSettlement(tzOrderSettlement);
    }

    /**
     * 批量删除支付信息
     * 
     * @param settlementIds 需要删除的支付信息主键
     * @return 结果
     */
    @Override
    public int deleteTzOrderSettlementBySettlementIds(Long[] settlementIds)
    {
        return tzOrderSettlementMapper.deleteTzOrderSettlementBySettlementIds(settlementIds);
    }

    /**
     * 删除支付信息信息
     * 
     * @param settlementId 支付信息主键
     * @return 结果
     */
    @Override
    public int deleteTzOrderSettlementBySettlementId(Long settlementId)
    {
        return tzOrderSettlementMapper.deleteTzOrderSettlementBySettlementId(settlementId);
    }
}
