package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzProdPropMapper;
import com.ruoyi.Greenfarm.domain.TzProdProp;
import com.ruoyi.Greenfarm.service.ITzProdPropService;

/**
 * 店铺信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzProdPropServiceImpl implements ITzProdPropService 
{
    @Autowired
    private TzProdPropMapper tzProdPropMapper;

    /**
     * 查询店铺信息
     * 
     * @param propId 店铺信息主键
     * @return 店铺信息
     */
    @Override
    public TzProdProp selectTzProdPropByPropId(Long propId)
    {
        return tzProdPropMapper.selectTzProdPropByPropId(propId);
    }

    /**
     * 查询店铺信息列表
     * 
     * @param tzProdProp 店铺信息
     * @return 店铺信息
     */
    @Override
    public List<TzProdProp> selectTzProdPropList(TzProdProp tzProdProp)
    {
        return tzProdPropMapper.selectTzProdPropList(tzProdProp);
    }

    /**
     * 新增店铺信息
     * 
     * @param tzProdProp 店铺信息
     * @return 结果
     */
    @Override
    public int insertTzProdProp(TzProdProp tzProdProp)
    {
        return tzProdPropMapper.insertTzProdProp(tzProdProp);
    }

    /**
     * 修改店铺信息
     * 
     * @param tzProdProp 店铺信息
     * @return 结果
     */
    @Override
    public int updateTzProdProp(TzProdProp tzProdProp)
    {
        return tzProdPropMapper.updateTzProdProp(tzProdProp);
    }

    /**
     * 批量删除店铺信息
     * 
     * @param propIds 需要删除的店铺信息主键
     * @return 结果
     */
    @Override
    public int deleteTzProdPropByPropIds(Long[] propIds)
    {
        return tzProdPropMapper.deleteTzProdPropByPropIds(propIds);
    }

    /**
     * 删除店铺信息信息
     * 
     * @param propId 店铺信息主键
     * @return 结果
     */
    @Override
    public int deleteTzProdPropByPropId(Long propId)
    {
        return tzProdPropMapper.deleteTzProdPropByPropId(propId);
    }
}
