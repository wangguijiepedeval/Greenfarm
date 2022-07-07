package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzBrandMapper;
import com.ruoyi.Greenfarm.domain.TzBrand;
import com.ruoyi.Greenfarm.service.ITzBrandService;

/**
 * 品牌Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzBrandServiceImpl implements ITzBrandService 
{
    @Autowired
    private TzBrandMapper tzBrandMapper;

    /**
     * 查询品牌
     * 
     * @param brandId 品牌主键
     * @return 品牌
     */
    @Override
    public TzBrand selectTzBrandByBrandId(Long brandId)
    {
        return tzBrandMapper.selectTzBrandByBrandId(brandId);
    }

    /**
     * 查询品牌列表
     * 
     * @param tzBrand 品牌
     * @return 品牌
     */
    @Override
    public List<TzBrand> selectTzBrandList(TzBrand tzBrand)
    {
        return tzBrandMapper.selectTzBrandList(tzBrand);
    }

    /**
     * 新增品牌
     * 
     * @param tzBrand 品牌
     * @return 结果
     */
    @Override
    public int insertTzBrand(TzBrand tzBrand)
    {
        return tzBrandMapper.insertTzBrand(tzBrand);
    }

    /**
     * 修改品牌
     * 
     * @param tzBrand 品牌
     * @return 结果
     */
    @Override
    public int updateTzBrand(TzBrand tzBrand)
    {
        tzBrand.setUpdateTime(DateUtils.getNowDate());
        return tzBrandMapper.updateTzBrand(tzBrand);
    }

    /**
     * 批量删除品牌
     * 
     * @param brandIds 需要删除的品牌主键
     * @return 结果
     */
    @Override
    public int deleteTzBrandByBrandIds(Long[] brandIds)
    {
        return tzBrandMapper.deleteTzBrandByBrandIds(brandIds);
    }

    /**
     * 删除品牌信息
     * 
     * @param brandId 品牌主键
     * @return 结果
     */
    @Override
    public int deleteTzBrandByBrandId(Long brandId)
    {
        return tzBrandMapper.deleteTzBrandByBrandId(brandId);
    }
}
