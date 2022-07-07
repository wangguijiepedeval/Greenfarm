package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzSku;

/**
 * 单品SKUMapper接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface TzSkuMapper 
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
     * 删除单品SKU
     * 
     * @param skuId 单品SKU主键
     * @return 结果
     */
    public int deleteTzSkuBySkuId(Long skuId);

    /**
     * 批量删除单品SKU
     * 
     * @param skuIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzSkuBySkuIds(Long[] skuIds);
}
