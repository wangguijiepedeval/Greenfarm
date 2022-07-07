package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzPickAddrMapper;
import com.ruoyi.Greenfarm.domain.TzPickAddr;
import com.ruoyi.Greenfarm.service.ITzPickAddrService;

/**
 * 用户配送地址Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzPickAddrServiceImpl implements ITzPickAddrService 
{
    @Autowired
    private TzPickAddrMapper tzPickAddrMapper;

    /**
     * 查询用户配送地址
     * 
     * @param addrId 用户配送地址主键
     * @return 用户配送地址
     */
    @Override
    public TzPickAddr selectTzPickAddrByAddrId(Long addrId)
    {
        return tzPickAddrMapper.selectTzPickAddrByAddrId(addrId);
    }

    /**
     * 查询用户配送地址列表
     * 
     * @param tzPickAddr 用户配送地址
     * @return 用户配送地址
     */
    @Override
    public List<TzPickAddr> selectTzPickAddrList(TzPickAddr tzPickAddr)
    {
        return tzPickAddrMapper.selectTzPickAddrList(tzPickAddr);
    }

    /**
     * 新增用户配送地址
     * 
     * @param tzPickAddr 用户配送地址
     * @return 结果
     */
    @Override
    public int insertTzPickAddr(TzPickAddr tzPickAddr)
    {
        return tzPickAddrMapper.insertTzPickAddr(tzPickAddr);
    }

    /**
     * 修改用户配送地址
     * 
     * @param tzPickAddr 用户配送地址
     * @return 结果
     */
    @Override
    public int updateTzPickAddr(TzPickAddr tzPickAddr)
    {
        return tzPickAddrMapper.updateTzPickAddr(tzPickAddr);
    }

    /**
     * 批量删除用户配送地址
     * 
     * @param addrIds 需要删除的用户配送地址主键
     * @return 结果
     */
    @Override
    public int deleteTzPickAddrByAddrIds(Long[] addrIds)
    {
        return tzPickAddrMapper.deleteTzPickAddrByAddrIds(addrIds);
    }

    /**
     * 删除用户配送地址信息
     * 
     * @param addrId 用户配送地址主键
     * @return 结果
     */
    @Override
    public int deleteTzPickAddrByAddrId(Long addrId)
    {
        return tzPickAddrMapper.deleteTzPickAddrByAddrId(addrId);
    }
}
