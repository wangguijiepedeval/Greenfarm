package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzUserAddr;

/**
 * 用户配送地址Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface TzUserAddrMapper 
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
     * 删除用户配送地址
     * 
     * @param addrId 用户配送地址主键
     * @return 结果
     */
    public int deleteTzUserAddrByAddrId(Long addrId);

    /**
     * 批量删除用户配送地址
     * 
     * @param addrIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzUserAddrByAddrIds(Long[] addrIds);
}
