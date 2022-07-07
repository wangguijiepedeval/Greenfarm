package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzTransportMapper;
import com.ruoyi.Greenfarm.domain.TzTransport;
import com.ruoyi.Greenfarm.service.ITzTransportService;

/**
 * 订单详情Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzTransportServiceImpl implements ITzTransportService 
{
    @Autowired
    private TzTransportMapper tzTransportMapper;

    /**
     * 查询订单详情
     * 
     * @param transportId 订单详情主键
     * @return 订单详情
     */
    @Override
    public TzTransport selectTzTransportByTransportId(Long transportId)
    {
        return tzTransportMapper.selectTzTransportByTransportId(transportId);
    }

    /**
     * 查询订单详情列表
     * 
     * @param tzTransport 订单详情
     * @return 订单详情
     */
    @Override
    public List<TzTransport> selectTzTransportList(TzTransport tzTransport)
    {
        return tzTransportMapper.selectTzTransportList(tzTransport);
    }

    /**
     * 新增订单详情
     * 
     * @param tzTransport 订单详情
     * @return 结果
     */
    @Override
    public int insertTzTransport(TzTransport tzTransport)
    {
        tzTransport.setCreateTime(DateUtils.getNowDate());
        return tzTransportMapper.insertTzTransport(tzTransport);
    }

    /**
     * 修改订单详情
     * 
     * @param tzTransport 订单详情
     * @return 结果
     */
    @Override
    public int updateTzTransport(TzTransport tzTransport)
    {
        return tzTransportMapper.updateTzTransport(tzTransport);
    }

    /**
     * 批量删除订单详情
     * 
     * @param transportIds 需要删除的订单详情主键
     * @return 结果
     */
    @Override
    public int deleteTzTransportByTransportIds(Long[] transportIds)
    {
        return tzTransportMapper.deleteTzTransportByTransportIds(transportIds);
    }

    /**
     * 删除订单详情信息
     * 
     * @param transportId 订单详情主键
     * @return 结果
     */
    @Override
    public int deleteTzTransportByTransportId(Long transportId)
    {
        return tzTransportMapper.deleteTzTransportByTransportId(transportId);
    }
}
