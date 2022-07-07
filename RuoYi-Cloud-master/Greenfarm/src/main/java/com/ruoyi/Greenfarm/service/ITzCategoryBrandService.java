package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzCategoryBrand;

/**
 * 购物车与品牌Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzCategoryBrandService 
{
    /**
     * 查询购物车与品牌
     * 
     * @param id 购物车与品牌主键
     * @return 购物车与品牌
     */
    public TzCategoryBrand selectTzCategoryBrandById(Long id);

    /**
     * 查询购物车与品牌列表
     * 
     * @param tzCategoryBrand 购物车与品牌
     * @return 购物车与品牌集合
     */
    public List<TzCategoryBrand> selectTzCategoryBrandList(TzCategoryBrand tzCategoryBrand);

    /**
     * 新增购物车与品牌
     * 
     * @param tzCategoryBrand 购物车与品牌
     * @return 结果
     */
    public int insertTzCategoryBrand(TzCategoryBrand tzCategoryBrand);

    /**
     * 修改购物车与品牌
     * 
     * @param tzCategoryBrand 购物车与品牌
     * @return 结果
     */
    public int updateTzCategoryBrand(TzCategoryBrand tzCategoryBrand);

    /**
     * 批量删除购物车与品牌
     * 
     * @param ids 需要删除的购物车与品牌主键集合
     * @return 结果
     */
    public int deleteTzCategoryBrandByIds(Long[] ids);

    /**
     * 删除购物车与品牌信息
     * 
     * @param id 购物车与品牌主键
     * @return 结果
     */
    public int deleteTzCategoryBrandById(Long id);
}
