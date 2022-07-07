package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzCategory;

/**
 * 产品类目Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface TzCategoryMapper 
{
    /**
     * 查询产品类目
     * 
     * @param categoryId 产品类目主键
     * @return 产品类目
     */
    public TzCategory selectTzCategoryByCategoryId(Long categoryId);

    /**
     * 查询产品类目列表
     * 
     * @param tzCategory 产品类目
     * @return 产品类目集合
     */
    public List<TzCategory> selectTzCategoryList(TzCategory tzCategory);

    /**
     * 新增产品类目
     * 
     * @param tzCategory 产品类目
     * @return 结果
     */
    public int insertTzCategory(TzCategory tzCategory);

    /**
     * 修改产品类目
     * 
     * @param tzCategory 产品类目
     * @return 结果
     */
    public int updateTzCategory(TzCategory tzCategory);

    /**
     * 删除产品类目
     * 
     * @param categoryId 产品类目主键
     * @return 结果
     */
    public int deleteTzCategoryByCategoryId(Long categoryId);

    /**
     * 批量删除产品类目
     * 
     * @param categoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzCategoryByCategoryIds(Long[] categoryIds);
}
