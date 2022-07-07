package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzUserAddrMapper;
import com.ruoyi.Greenfarm.domain.TzUserAddr;
import com.ruoyi.Greenfarm.service.ITzUserAddrService;

/**
 * 用户配送地址Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzUserAddrServiceImpl implements ITzUserAddrService 
{
    @Autowired
    private TzUserAddrMapper tzUserAddrMapper;

    /**
     * 查询用户配送地址
     * 
     * @param addrId 用户配送地址主键
     * @return 用户配送地址
     */
    @Override
    public TzUserAddr selectTzUserAddrByAddrId(Long addrId)
    {
        return tzUserAddrMapper.selectTzUserAddrByAddrId(addrId);
    }

    /**
     * 查询用户配送地址列表
     * 
     * @param tzUserAddr 用户配送地址
     * @return 用户配送地址
     */
    @Override
    public List<TzUserAddr> selectTzUserAddrList(TzUserAddr tzUserAddr)
    {
        return tzUserAddrMapper.selectTzUserAddrList(tzUserAddr);
    }

    /**
     * 新增用户配送地址
     * 
     * @param tzUserAddr 用户配送地址
     * @return 结果
     */
    @Override
    public int insertTzUserAddr(TzUserAddr tzUserAddr)
    {
        tzUserAddr.setCreateTime(DateUtils.getNowDate());
        return tzUserAddrMapper.insertTzUserAddr(tzUserAddr);
    }

    /**
     * 修改用户配送地址
     * 
     * @param tzUserAddr 用户配送地址
     * @return 结果
     */
    @Override
    public int updateTzUserAddr(TzUserAddr tzUserAddr)
    {
        tzUserAddr.setUpdateTime(DateUtils.getNowDate());
        return tzUserAddrMapper.updateTzUserAddr(tzUserAddr);
    }

    /**
     * 批量删除用户配送地址
     * 
     * @param addrIds 需要删除的用户配送地址主键
     * @return 结果
     */
    @Override
    public int deleteTzUserAddrByAddrIds(Long[] addrIds)
    {
        return tzUserAddrMapper.deleteTzUserAddrByAddrIds(addrIds);
    }

    /**
     * 删除用户配送地址信息
     * 
     * @param addrId 用户配送地址主键
     * @return 结果
     */
    @Override
    public int deleteTzUserAddrByAddrId(Long addrId)
    {
        return tzUserAddrMapper.deleteTzUserAddrByAddrId(addrId);
    }
}
