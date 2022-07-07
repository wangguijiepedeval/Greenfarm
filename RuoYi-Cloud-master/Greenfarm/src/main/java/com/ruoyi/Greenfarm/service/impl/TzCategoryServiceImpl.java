package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzCategoryMapper;
import com.ruoyi.Greenfarm.domain.TzCategory;
import com.ruoyi.Greenfarm.service.ITzCategoryService;

/**
 * 产品类目Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzCategoryServiceImpl implements ITzCategoryService 
{
    @Autowired
    private TzCategoryMapper tzCategoryMapper;

    /**
     * 查询产品类目
     * 
     * @param categoryId 产品类目主键
     * @return 产品类目
     */
    @Override
    public TzCategory selectTzCategoryByCategoryId(Long categoryId)
    {
        return tzCategoryMapper.selectTzCategoryByCategoryId(categoryId);
    }

    /**
     * 查询产品类目列表
     * 
     * @param tzCategory 产品类目
     * @return 产品类目
     */
    @Override
    public List<TzCategory> selectTzCategoryList(TzCategory tzCategory)
    {
        return tzCategoryMapper.selectTzCategoryList(tzCategory);
    }

    /**
     * 新增产品类目
     * 
     * @param tzCategory 产品类目
     * @return 结果
     */
    @Override
    public int insertTzCategory(TzCategory tzCategory)
    {
        return tzCategoryMapper.insertTzCategory(tzCategory);
    }

    /**
     * 修改产品类目
     * 
     * @param tzCategory 产品类目
     * @return 结果
     */
    @Override
    public int updateTzCategory(TzCategory tzCategory)
    {
        tzCategory.setUpdateTime(DateUtils.getNowDate());
        return tzCategoryMapper.updateTzCategory(tzCategory);
    }

    /**
     * 批量删除产品类目
     * 
     * @param categoryIds 需要删除的产品类目主键
     * @return 结果
     */
    @Override
    public int deleteTzCategoryByCategoryIds(Long[] categoryIds)
    {
        return tzCategoryMapper.deleteTzCategoryByCategoryIds(categoryIds);
    }

    /**
     * 删除产品类目信息
     * 
     * @param categoryId 产品类目主键
     * @return 结果
     */
    @Override
    public int deleteTzCategoryByCategoryId(Long categoryId)
    {
        return tzCategoryMapper.deleteTzCategoryByCategoryId(categoryId);
    }
}
