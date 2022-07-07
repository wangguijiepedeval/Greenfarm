package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzProdPropValueMapper;
import com.ruoyi.Greenfarm.domain.TzProdPropValue;
import com.ruoyi.Greenfarm.service.ITzProdPropValueService;

/**
 * 属性值Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class TzProdPropValueServiceImpl implements ITzProdPropValueService 
{
    @Autowired
    private TzProdPropValueMapper tzProdPropValueMapper;

    /**
     * 查询属性值
     * 
     * @param valueId 属性值主键
     * @return 属性值
     */
    @Override
    public TzProdPropValue selectTzProdPropValueByValueId(Long valueId)
    {
        return tzProdPropValueMapper.selectTzProdPropValueByValueId(valueId);
    }

    /**
     * 查询属性值列表
     * 
     * @param tzProdPropValue 属性值
     * @return 属性值
     */
    @Override
    public List<TzProdPropValue> selectTzProdPropValueList(TzProdPropValue tzProdPropValue)
    {
        return tzProdPropValueMapper.selectTzProdPropValueList(tzProdPropValue);
    }

    /**
     * 新增属性值
     * 
     * @param tzProdPropValue 属性值
     * @return 结果
     */
    @Override
    public int insertTzProdPropValue(TzProdPropValue tzProdPropValue)
    {
        return tzProdPropValueMapper.insertTzProdPropValue(tzProdPropValue);
    }

    /**
     * 修改属性值
     * 
     * @param tzProdPropValue 属性值
     * @return 结果
     */
    @Override
    public int updateTzProdPropValue(TzProdPropValue tzProdPropValue)
    {
        return tzProdPropValueMapper.updateTzProdPropValue(tzProdPropValue);
    }

    /**
     * 批量删除属性值
     * 
     * @param valueIds 需要删除的属性值主键
     * @return 结果
     */
    @Override
    public int deleteTzProdPropValueByValueIds(Long[] valueIds)
    {
        return tzProdPropValueMapper.deleteTzProdPropValueByValueIds(valueIds);
    }

    /**
     * 删除属性值信息
     * 
     * @param valueId 属性值主键
     * @return 结果
     */
    @Override
    public int deleteTzProdPropValueByValueId(Long valueId)
    {
        return tzProdPropValueMapper.deleteTzProdPropValueByValueId(valueId);
    }
}
