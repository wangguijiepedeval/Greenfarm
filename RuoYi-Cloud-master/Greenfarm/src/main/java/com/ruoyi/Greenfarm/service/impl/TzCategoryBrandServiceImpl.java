package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzCategoryBrandMapper;
import com.ruoyi.Greenfarm.domain.TzCategoryBrand;
import com.ruoyi.Greenfarm.service.ITzCategoryBrandService;

/**
 * 购物车与品牌Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzCategoryBrandServiceImpl implements ITzCategoryBrandService 
{
    @Autowired
    private TzCategoryBrandMapper tzCategoryBrandMapper;

    /**
     * 查询购物车与品牌
     * 
     * @param id 购物车与品牌主键
     * @return 购物车与品牌
     */
    @Override
    public TzCategoryBrand selectTzCategoryBrandById(Long id)
    {
        return tzCategoryBrandMapper.selectTzCategoryBrandById(id);
    }

    /**
     * 查询购物车与品牌列表
     * 
     * @param tzCategoryBrand 购物车与品牌
     * @return 购物车与品牌
     */
    @Override
    public List<TzCategoryBrand> selectTzCategoryBrandList(TzCategoryBrand tzCategoryBrand)
    {
        return tzCategoryBrandMapper.selectTzCategoryBrandList(tzCategoryBrand);
    }

    /**
     * 新增购物车与品牌
     * 
     * @param tzCategoryBrand 购物车与品牌
     * @return 结果
     */
    @Override
    public int insertTzCategoryBrand(TzCategoryBrand tzCategoryBrand)
    {
        return tzCategoryBrandMapper.insertTzCategoryBrand(tzCategoryBrand);
    }

    /**
     * 修改购物车与品牌
     * 
     * @param tzCategoryBrand 购物车与品牌
     * @return 结果
     */
    @Override
    public int updateTzCategoryBrand(TzCategoryBrand tzCategoryBrand)
    {
        return tzCategoryBrandMapper.updateTzCategoryBrand(tzCategoryBrand);
    }

    /**
     * 批量删除购物车与品牌
     * 
     * @param ids 需要删除的购物车与品牌主键
     * @return 结果
     */
    @Override
    public int deleteTzCategoryBrandByIds(Long[] ids)
    {
        return tzCategoryBrandMapper.deleteTzCategoryBrandByIds(ids);
    }

    /**
     * 删除购物车与品牌信息
     * 
     * @param id 购物车与品牌主键
     * @return 结果
     */
    @Override
    public int deleteTzCategoryBrandById(Long id)
    {
        return tzCategoryBrandMapper.deleteTzCategoryBrandById(id);
    }
}
