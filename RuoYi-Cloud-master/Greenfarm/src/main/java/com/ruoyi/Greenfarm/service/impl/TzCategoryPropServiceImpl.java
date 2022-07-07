package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzCategoryPropMapper;
import com.ruoyi.Greenfarm.domain.TzCategoryProp;
import com.ruoyi.Greenfarm.service.ITzCategoryPropService;

/**
 * 购物车商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class TzCategoryPropServiceImpl implements ITzCategoryPropService 
{
    @Autowired
    private TzCategoryPropMapper tzCategoryPropMapper;

    /**
     * 查询购物车商品
     * 
     * @param id 购物车商品主键
     * @return 购物车商品
     */
    @Override
    public TzCategoryProp selectTzCategoryPropById(Long id)
    {
        return tzCategoryPropMapper.selectTzCategoryPropById(id);
    }

    /**
     * 查询购物车商品列表
     * 
     * @param tzCategoryProp 购物车商品
     * @return 购物车商品
     */
    @Override
    public List<TzCategoryProp> selectTzCategoryPropList(TzCategoryProp tzCategoryProp)
    {
        return tzCategoryPropMapper.selectTzCategoryPropList(tzCategoryProp);
    }

    /**
     * 新增购物车商品
     * 
     * @param tzCategoryProp 购物车商品
     * @return 结果
     */
    @Override
    public int insertTzCategoryProp(TzCategoryProp tzCategoryProp)
    {
        return tzCategoryPropMapper.insertTzCategoryProp(tzCategoryProp);
    }

    /**
     * 修改购物车商品
     * 
     * @param tzCategoryProp 购物车商品
     * @return 结果
     */
    @Override
    public int updateTzCategoryProp(TzCategoryProp tzCategoryProp)
    {
        return tzCategoryPropMapper.updateTzCategoryProp(tzCategoryProp);
    }

    /**
     * 批量删除购物车商品
     * 
     * @param ids 需要删除的购物车商品主键
     * @return 结果
     */
    @Override
    public int deleteTzCategoryPropByIds(Long[] ids)
    {
        return tzCategoryPropMapper.deleteTzCategoryPropByIds(ids);
    }

    /**
     * 删除购物车商品信息
     * 
     * @param id 购物车商品主键
     * @return 结果
     */
    @Override
    public int deleteTzCategoryPropById(Long id)
    {
        return tzCategoryPropMapper.deleteTzCategoryPropById(id);
    }
}
