package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzTransport;

/**
 * 订单详情Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzTransportService 
{
    /**
     * 查询订单详情
     * 
     * @param transportId 订单详情主键
     * @return 订单详情
     */
    public TzTransport selectTzTransportByTransportId(Long transportId);

    /**
     * 查询订单详情列表
     * 
     * @param tzTransport 订单详情
     * @return 订单详情集合
     */
    public List<TzTransport> selectTzTransportList(TzTransport tzTransport);

    /**
     * 新增订单详情
     * 
     * @param tzTransport 订单详情
     * @return 结果
     */
    public int insertTzTransport(TzTransport tzTransport);

    /**
     * 修改订单详情
     * 
     * @param tzTransport 订单详情
     * @return 结果
     */
    public int updateTzTransport(TzTransport tzTransport);

    /**
     * 批量删除订单详情
     * 
     * @param transportIds 需要删除的订单详情主键集合
     * @return 结果
     */
    public int deleteTzTransportByTransportIds(Long[] transportIds);

    /**
     * 删除订单详情信息
     * 
     * @param transportId 订单详情主键
     * @return 结果
     */
    public int deleteTzTransportByTransportId(Long transportId);
}
