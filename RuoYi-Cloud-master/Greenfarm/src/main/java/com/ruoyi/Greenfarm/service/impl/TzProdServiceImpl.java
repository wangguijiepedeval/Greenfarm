package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzProdMapper;
import com.ruoyi.Greenfarm.domain.TzProd;
import com.ruoyi.Greenfarm.service.ITzProdService;

/**
 * 商品Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzProdServiceImpl implements ITzProdService 
{
    @Autowired
    private TzProdMapper tzProdMapper;

    /**
     * 查询商品
     * 
     * @param prodId 商品主键
     * @return 商品
     */
    @Override
    public TzProd selectTzProdByProdId(Long prodId)
    {
        return tzProdMapper.selectTzProdByProdId(prodId);
    }

    /**
     * 查询商品列表
     * 
     * @param tzProd 商品
     * @return 商品
     */
    @Override
    public List<TzProd> selectTzProdList(TzProd tzProd)
    {
        return tzProdMapper.selectTzProdList(tzProd);
    }

    /**
     * 新增商品
     * 
     * @param tzProd 商品
     * @return 结果
     */
    @Override
    public int insertTzProd(TzProd tzProd)
    {
        tzProd.setCreateTime(DateUtils.getNowDate());
        return tzProdMapper.insertTzProd(tzProd);
    }

    /**
     * 修改商品
     * 
     * @param tzProd 商品
     * @return 结果
     */
    @Override
    public int updateTzProd(TzProd tzProd)
    {
        tzProd.setUpdateTime(DateUtils.getNowDate());
        return tzProdMapper.updateTzProd(tzProd);
    }

    /**
     * 批量删除商品
     * 
     * @param prodIds 需要删除的商品主键
     * @return 结果
     */
    @Override
    public int deleteTzProdByProdIds(Long[] prodIds)
    {
        return tzProdMapper.deleteTzProdByProdIds(prodIds);
    }

    /**
     * 删除商品信息
     * 
     * @param prodId 商品主键
     * @return 结果
     */
    @Override
    public int deleteTzProdByProdId(Long prodId)
    {
        return tzProdMapper.deleteTzProdByProdId(prodId);
    }
}
