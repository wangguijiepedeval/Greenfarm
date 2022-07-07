package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzProdPropValue;

/**
 * 属性值Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface TzProdPropValueMapper 
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
     * 删除属性值
     * 
     * @param valueId 属性值主键
     * @return 结果
     */
    public int deleteTzProdPropValueByValueId(Long valueId);

    /**
     * 批量删除属性值
     * 
     * @param valueIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzProdPropValueByValueIds(Long[] valueIds);
}
