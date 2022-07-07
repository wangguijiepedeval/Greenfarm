package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzProdProp;

/**
 * 店铺信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface TzProdPropMapper 
{
    /**
     * 查询店铺信息
     * 
     * @param propId 店铺信息主键
     * @return 店铺信息
     */
    public TzProdProp selectTzProdPropByPropId(Long propId);

    /**
     * 查询店铺信息列表
     * 
     * @param tzProdProp 店铺信息
     * @return 店铺信息集合
     */
    public List<TzProdProp> selectTzProdPropList(TzProdProp tzProdProp);

    /**
     * 新增店铺信息
     * 
     * @param tzProdProp 店铺信息
     * @return 结果
     */
    public int insertTzProdProp(TzProdProp tzProdProp);

    /**
     * 修改店铺信息
     * 
     * @param tzProdProp 店铺信息
     * @return 结果
     */
    public int updateTzProdProp(TzProdProp tzProdProp);

    /**
     * 删除店铺信息
     * 
     * @param propId 店铺信息主键
     * @return 结果
     */
    public int deleteTzProdPropByPropId(Long propId);

    /**
     * 批量删除店铺信息
     * 
     * @param propIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzProdPropByPropIds(Long[] propIds);
}
