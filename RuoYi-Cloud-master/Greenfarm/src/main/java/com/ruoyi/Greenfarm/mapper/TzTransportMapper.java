package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzTransport;

/**
 * 订单详情Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface TzTransportMapper 
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
     * 删除订单详情
     * 
     * @param transportId 订单详情主键
     * @return 结果
     */
    public int deleteTzTransportByTransportId(Long transportId);

    /**
     * 批量删除订单详情
     * 
     * @param transportIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzTransportByTransportIds(Long[] transportIds);
}
