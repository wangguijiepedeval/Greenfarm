package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzSkuMapper;
import com.ruoyi.Greenfarm.domain.TzSku;
import com.ruoyi.Greenfarm.service.ITzSkuService;

/**
 * 单品SKUService业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class TzSkuServiceImpl implements ITzSkuService 
{
    @Autowired
    private TzSkuMapper tzSkuMapper;

    /**
     * 查询单品SKU
     * 
     * @param skuId 单品SKU主键
     * @return 单品SKU
     */
    @Override
    public TzSku selectTzSkuBySkuId(Long skuId)
    {
        return tzSkuMapper.selectTzSkuBySkuId(skuId);
    }

    /**
     * 查询单品SKU列表
     * 
     * @param tzSku 单品SKU
     * @return 单品SKU
     */
    @Override
    public List<TzSku> selectTzSkuList(TzSku tzSku)
    {
        return tzSkuMapper.selectTzSkuList(tzSku);
    }

    /**
     * 新增单品SKU
     * 
     * @param tzSku 单品SKU
     * @return 结果
     */
    @Override
    public int insertTzSku(TzSku tzSku)
    {
        return tzSkuMapper.insertTzSku(tzSku);
    }

    /**
     * 修改单品SKU
     * 
     * @param tzSku 单品SKU
     * @return 结果
     */
    @Override
    public int updateTzSku(TzSku tzSku)
    {
        tzSku.setUpdateTime(DateUtils.getNowDate());
        return tzSkuMapper.updateTzSku(tzSku);
    }

    /**
     * 批量删除单品SKU
     * 
     * @param skuIds 需要删除的单品SKU主键
     * @return 结果
     */
    @Override
    public int deleteTzSkuBySkuIds(Long[] skuIds)
    {
        return tzSkuMapper.deleteTzSkuBySkuIds(skuIds);
    }

    /**
     * 删除单品SKU信息
     * 
     * @param skuId 单品SKU主键
     * @return 结果
     */
    @Override
    public int deleteTzSkuBySkuId(Long skuId)
    {
        return tzSkuMapper.deleteTzSkuBySkuId(skuId);
    }
}
