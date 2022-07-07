package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzCategoryProp;

/**
 * 购物车商品Service接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface ITzCategoryPropService 
{
    /**
     * 查询购物车商品
     * 
     * @param id 购物车商品主键
     * @return 购物车商品
     */
    public TzCategoryProp selectTzCategoryPropById(Long id);

    /**
     * 查询购物车商品列表
     * 
     * @param tzCategoryProp 购物车商品
     * @return 购物车商品集合
     */
    public List<TzCategoryProp> selectTzCategoryPropList(TzCategoryProp tzCategoryProp);

    /**
     * 新增购物车商品
     * 
     * @param tzCategoryProp 购物车商品
     * @return 结果
     */
    public int insertTzCategoryProp(TzCategoryProp tzCategoryProp);

    /**
     * 修改购物车商品
     * 
     * @param tzCategoryProp 购物车商品
     * @return 结果
     */
    public int updateTzCategoryProp(TzCategoryProp tzCategoryProp);

    /**
     * 批量删除购物车商品
     * 
     * @param ids 需要删除的购物车商品主键集合
     * @return 结果
     */
    public int deleteTzCategoryPropByIds(Long[] ids);

    /**
     * 删除购物车商品信息
     * 
     * @param id 购物车商品主键
     * @return 结果
     */
    public int deleteTzCategoryPropById(Long id);
}
