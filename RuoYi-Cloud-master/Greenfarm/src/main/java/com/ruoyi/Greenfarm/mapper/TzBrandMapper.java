package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzBrand;

/**
 * 品牌Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface TzBrandMapper 
{
    /**
     * 查询品牌
     * 
     * @param brandId 品牌主键
     * @return 品牌
     */
    public TzBrand selectTzBrandByBrandId(Long brandId);

    /**
     * 查询品牌列表
     * 
     * @param tzBrand 品牌
     * @return 品牌集合
     */
    public List<TzBrand> selectTzBrandList(TzBrand tzBrand);

    /**
     * 新增品牌
     * 
     * @param tzBrand 品牌
     * @return 结果
     */
    public int insertTzBrand(TzBrand tzBrand);

    /**
     * 修改品牌
     * 
     * @param tzBrand 品牌
     * @return 结果
     */
    public int updateTzBrand(TzBrand tzBrand);

    /**
     * 删除品牌
     * 
     * @param brandId 品牌主键
     * @return 结果
     */
    public int deleteTzBrandByBrandId(Long brandId);

    /**
     * 批量删除品牌
     * 
     * @param brandIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzBrandByBrandIds(Long[] brandIds);
}