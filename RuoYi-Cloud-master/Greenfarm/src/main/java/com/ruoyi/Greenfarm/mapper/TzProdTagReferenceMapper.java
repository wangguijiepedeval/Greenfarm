package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzProdTagReference;

/**
 * 店铺分组Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface TzProdTagReferenceMapper 
{
    /**
     * 查询店铺分组
     * 
     * @param referenceId 店铺分组主键
     * @return 店铺分组
     */
    public TzProdTagReference selectTzProdTagReferenceByReferenceId(Long referenceId);

    /**
     * 查询店铺分组列表
     * 
     * @param tzProdTagReference 店铺分组
     * @return 店铺分组集合
     */
    public List<TzProdTagReference> selectTzProdTagReferenceList(TzProdTagReference tzProdTagReference);

    /**
     * 新增店铺分组
     * 
     * @param tzProdTagReference 店铺分组
     * @return 结果
     */
    public int insertTzProdTagReference(TzProdTagReference tzProdTagReference);

    /**
     * 修改店铺分组
     * 
     * @param tzProdTagReference 店铺分组
     * @return 结果
     */
    public int updateTzProdTagReference(TzProdTagReference tzProdTagReference);

    /**
     * 删除店铺分组
     * 
     * @param referenceId 店铺分组主键
     * @return 结果
     */
    public int deleteTzProdTagReferenceByReferenceId(Long referenceId);

    /**
     * 批量删除店铺分组
     * 
     * @param referenceIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzProdTagReferenceByReferenceIds(Long[] referenceIds);
}
