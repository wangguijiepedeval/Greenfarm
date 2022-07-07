package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzSku;

/**
 * 单品SKUService接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface ITzSkuService 
{
    /**
     * 查询单品SKU
     * 
     * @param skuId 单品SKU主键
     * @return 单品SKU
     */
    public TzSku selectTzSkuBySkuId(Long skuId);

    /**
     * 查询单品SKU列表
     * 
     * @param tzSku 单品SKU
     * @return 单品SKU集合
     */
    public List<TzSku> selectTzSkuList(TzSku tzSku);

    /**
     * 新增单品SKU
     * 
     * @param tzSku 单品SKU
     * @return 结果
     */
    public int insertTzSku(TzSku tzSku);

    /**
     * 修改单品SKU
     * 
     * @param tzSku 单品SKU
     * @return 结果
     */
    public int updateTzSku(TzSku tzSku);

    /**
     * 批量删除单品SKU
     * 
     * @param skuIds 需要删除的单品SKU主键集合
     * @return 结果
     */
    public int deleteTzSkuBySkuIds(Long[] skuIds);

    /**
     * 删除单品SKU信息
     * 
     * @param skuId 单品SKU主键
     * @return 结果
     */
    public int deleteTzSkuBySkuId(Long skuId);
}
