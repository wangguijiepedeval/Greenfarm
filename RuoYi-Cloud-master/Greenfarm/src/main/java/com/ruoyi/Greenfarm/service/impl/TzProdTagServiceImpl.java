package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzProdTagMapper;
import com.ruoyi.Greenfarm.domain.TzProdTag;
import com.ruoyi.Greenfarm.service.ITzProdTagService;

/**
 * 商品分组Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzProdTagServiceImpl implements ITzProdTagService 
{
    @Autowired
    private TzProdTagMapper tzProdTagMapper;

    /**
     * 查询商品分组
     * 
     * @param id 商品分组主键
     * @return 商品分组
     */
    @Override
    public TzProdTag selectTzProdTagById(Long id)
    {
        return tzProdTagMapper.selectTzProdTagById(id);
    }

    /**
     * 查询商品分组列表
     * 
     * @param tzProdTag 商品分组
     * @return 商品分组
     */
    @Override
    public List<TzProdTag> selectTzProdTagList(TzProdTag tzProdTag)
    {
        return tzProdTagMapper.selectTzProdTagList(tzProdTag);
    }

    /**
     * 新增商品分组
     * 
     * @param tzProdTag 商品分组
     * @return 结果
     */
    @Override
    public int insertTzProdTag(TzProdTag tzProdTag)
    {
        tzProdTag.setCreateTime(DateUtils.getNowDate());
        return tzProdTagMapper.insertTzProdTag(tzProdTag);
    }

    /**
     * 修改商品分组
     * 
     * @param tzProdTag 商品分组
     * @return 结果
     */
    @Override
    public int updateTzProdTag(TzProdTag tzProdTag)
    {
        tzProdTag.setUpdateTime(DateUtils.getNowDate());
        return tzProdTagMapper.updateTzProdTag(tzProdTag);
    }

    /**
     * 批量删除商品分组
     * 
     * @param ids 需要删除的商品分组主键
     * @return 结果
     */
    @Override
    public int deleteTzProdTagByIds(Long[] ids)
    {
        return tzProdTagMapper.deleteTzProdTagByIds(ids);
    }

    /**
     * 删除商品分组信息
     * 
     * @param id 商品分组主键
     * @return 结果
     */
    @Override
    public int deleteTzProdTagById(Long id)
    {
        return tzProdTagMapper.deleteTzProdTagById(id);
    }
}
