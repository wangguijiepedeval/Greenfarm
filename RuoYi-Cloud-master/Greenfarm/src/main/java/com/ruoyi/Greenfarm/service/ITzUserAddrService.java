package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzUserAddr;

/**
 * 用户配送地址Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzUserAddrService 
{
    /**
     * 查询用户配送地址
     * 
     * @param addrId 用户配送地址主键
     * @return 用户配送地址
     */
    public TzUserAddr selectTzUserAddrByAddrId(Long addrId);

    /**
     * 查询用户配送地址列表
     * 
     * @param tzUserAddr 用户配送地址
     * @return 用户配送地址集合
     */
    public List<TzUserAddr> selectTzUserAddrList(TzUserAddr tzUserAddr);

    /**
     * 新增用户配送地址
     * 
     * @param tzUserAddr 用户配送地址
     * @return 结果
     */
    public int insertTzUserAddr(TzUserAddr tzUserAddr);

    /**
     * 修改用户配送地址
     * 
     * @param tzUserAddr 用户配送地址
     * @return 结果
     */
    public int updateTzUserAddr(TzUserAddr tzUserAddr);

    /**
     * 批量删除用户配送地址
     * 
     * @param addrIds 需要删除的用户配送地址主键集合
     * @return 结果
     */
    public int deleteTzUserAddrByAddrIds(Long[] addrIds);

    /**
     * 删除用户配送地址信息
     * 
     * @param addrId 用户配送地址主键
     * @return 结果
     */
    public int deleteTzUserAddrByAddrId(Long addrId);
}
