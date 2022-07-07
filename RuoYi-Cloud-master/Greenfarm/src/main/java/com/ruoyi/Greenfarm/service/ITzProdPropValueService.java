package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzProdPropValue;

/**
 * 属性值Service接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface ITzProdPropValueService 
{
    /**
     * 查询属性值
     * 
     * @param valueId 属性值主键
     * @return 属性值
     */
    public TzProdPropValue selectTzProdPropValueByValueId(Long valueId);

    /**
     * 查询属性值列表
     * 
     * @param tzProdPropValue 属性值
     * @return 属性值集合
     */
    public List<TzProdPropValue> selectTzProdPropValueList(TzProdPropValue tzProdPropValue);

    /**
     * 新增属性值
     * 
     * @param tzProdPropValue 属性值
     * @return 结果
     */
    public int insertTzProdPropValue(TzProdPropValue tzProdPropValue);

    /**
     * 修改属性值
     * 
     * @param tzProdPropValue 属性值
     * @return 结果
     */
    public int updateTzProdPropValue(TzProdPropValue tzProdPropValue);

    /**
     * 批量删除属性值
     * 
     * @param valueIds 需要删除的属性值主键集合
     * @return 结果
     */
    public int deleteTzProdPropValueByValueIds(Long[] valueIds);

    /**
     * 删除属性值信息
     * 
     * @param valueId 属性值主键
     * @return 结果
     */
    public int deleteTzProdPropValueByValueId(Long valueId);
}
