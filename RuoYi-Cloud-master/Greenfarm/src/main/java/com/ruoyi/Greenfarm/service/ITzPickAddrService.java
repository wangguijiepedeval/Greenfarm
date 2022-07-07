package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzPickAddr;

/**
 * 用户配送地址Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzPickAddrService 
{
    /**
     * 查询用户配送地址
     * 
     * @param addrId 用户配送地址主键
     * @return 用户配送地址
     */
    public TzPickAddr selectTzPickAddrByAddrId(Long addrId);

    /**
     * 查询用户配送地址列表
     * 
     * @param tzPickAddr 用户配送地址
     * @return 用户配送地址集合
     */
    public List<TzPickAddr> selectTzPickAddrList(TzPickAddr tzPickAddr);

    /**
     * 新增用户配送地址
     * 
     * @param tzPickAddr 用户配送地址
     * @return 结果
     */
    public int insertTzPickAddr(TzPickAddr tzPickAddr);

    /**
     * 修改用户配送地址
     * 
     * @param tzPickAddr 用户配送地址
     * @return 结果
     */
    public int updateTzPickAddr(TzPickAddr tzPickAddr);

    /**
     * 批量删除用户配送地址
     * 
     * @param addrIds 需要删除的用户配送地址主键集合
     * @return 结果
     */
    public int deleteTzPickAddrByAddrIds(Long[] addrIds);

    /**
     * 删除用户配送地址信息
     * 
     * @param addrId 用户配送地址主键
     * @return 结果
     */
    public int deleteTzPickAddrByAddrId(Long addrId);
}
