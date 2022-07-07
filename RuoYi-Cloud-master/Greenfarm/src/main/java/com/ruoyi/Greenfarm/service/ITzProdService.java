package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzProd;

/**
 * 商品Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzProdService 
{
    /**
     * 查询商品
     * 
     * @param prodId 商品主键
     * @return 商品
     */
    public TzProd selectTzProdByProdId(Long prodId);

    /**
     * 查询商品列表
     * 
     * @param tzProd 商品
     * @return 商品集合
     */
    public List<TzProd> selectTzProdList(TzProd tzProd);

    /**
     * 新增商品
     * 
     * @param tzProd 商品
     * @return 结果
     */
    public int insertTzProd(TzProd tzProd);

    /**
     * 修改商品
     * 
     * @param tzProd 商品
     * @return 结果
     */
    public int updateTzProd(TzProd tzProd);

    /**
     * 批量删除商品
     * 
     * @param prodIds 需要删除的商品主键集合
     * @return 结果
     */
    public int deleteTzProdByProdIds(Long[] prodIds);

    /**
     * 删除商品信息
     * 
     * @param prodId 商品主键
     * @return 结果
     */
    public int deleteTzProdByProdId(Long prodId);
}