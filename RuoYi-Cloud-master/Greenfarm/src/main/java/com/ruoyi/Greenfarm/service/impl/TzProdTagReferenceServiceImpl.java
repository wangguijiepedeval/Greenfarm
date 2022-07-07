package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzProdTagReferenceMapper;
import com.ruoyi.Greenfarm.domain.TzProdTagReference;
import com.ruoyi.Greenfarm.service.ITzProdTagReferenceService;

/**
 * 店铺分组Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzProdTagReferenceServiceImpl implements ITzProdTagReferenceService 
{
    @Autowired
    private TzProdTagReferenceMapper tzProdTagReferenceMapper;

    /**
     * 查询店铺分组
     * 
     * @param referenceId 店铺分组主键
     * @return 店铺分组
     */
    @Override
    public TzProdTagReference selectTzProdTagReferenceByReferenceId(Long referenceId)
    {
        return tzProdTagReferenceMapper.selectTzProdTagReferenceByReferenceId(referenceId);
    }

    /**
     * 查询店铺分组列表
     * 
     * @param tzProdTagReference 店铺分组
     * @return 店铺分组
     */
    @Override
    public List<TzProdTagReference> selectTzProdTagReferenceList(TzProdTagReference tzProdTagReference)
    {
        return tzProdTagReferenceMapper.selectTzProdTagReferenceList(tzProdTagReference);
    }

    /**
     * 新增店铺分组
     * 
     * @param tzProdTagReference 店铺分组
     * @return 结果
     */
    @Override
    public int insertTzProdTagReference(TzProdTagReference tzProdTagReference)
    {
        tzProdTagReference.setCreateTime(DateUtils.getNowDate());
        return tzProdTagReferenceMapper.insertTzProdTagReference(tzProdTagReference);
    }

    /**
     * 修改店铺分组
     * 
     * @param tzProdTagReference 店铺分组
     * @return 结果
     */
    @Override
    public int updateTzProdTagReference(TzProdTagReference tzProdTagReference)
    {
        return tzProdTagReferenceMapper.updateTzProdTagReference(tzProdTagReference);
    }

    /**
     * 批量删除店铺分组
     * 
     * @param referenceIds 需要删除的店铺分组主键
     * @return 结果
     */
    @Override
    public int deleteTzProdTagReferenceByReferenceIds(Long[] referenceIds)
    {
        return tzProdTagReferenceMapper.deleteTzProdTagReferenceByReferenceIds(referenceIds);
    }

    /**
     * 删除店铺分组信息
     * 
     * @param referenceId 店铺分组主键
     * @return 结果
     */
    @Override
    public int deleteTzProdTagReferenceByReferenceId(Long referenceId)
    {
        return tzProdTagReferenceMapper.deleteTzProdTagReferenceByReferenceId(referenceId);
    }
}
