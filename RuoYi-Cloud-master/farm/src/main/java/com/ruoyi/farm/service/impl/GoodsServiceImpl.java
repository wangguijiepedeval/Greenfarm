package com.ruoyi.farm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.farm.mapper.GoodsMapper;
import com.ruoyi.farm.domain.Goods;
import com.ruoyi.farm.service.IGoodsService;

/**
 * goods管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class GoodsServiceImpl implements IGoodsService 
{
    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * 查询goods管理
     * 
     * @param goodsid goods管理主键
     * @return goods管理
     */
    @Override
    public Goods selectGoodsByGoodsid(String goodsid)
    {
        return goodsMapper.selectGoodsByGoodsid(goodsid);
    }

    /**
     * 查询goods管理列表
     * 
     * @param goods goods管理
     * @return goods管理
     */
    @Override
    public List<Goods> selectGoodsList(Goods goods)
    {
        return goodsMapper.selectGoodsList(goods);
    }

    /**
     * 新增goods管理
     * 
     * @param goods goods管理
     * @return 结果
     */
    @Override
    public int insertGoods(Goods goods)
    {
        goods.setCreateTime(DateUtils.getNowDate());
        return goodsMapper.insertGoods(goods);
    }

    /**
     * 修改goods管理
     * 
     * @param goods goods管理
     * @return 结果
     */
    @Override
    public int updateGoods(Goods goods)
    {
        goods.setUpdateTime(DateUtils.getNowDate());
        return goodsMapper.updateGoods(goods);
    }

    /**
     * 批量删除goods管理
     * 
     * @param goodsids 需要删除的goods管理主键
     * @return 结果
     */
    @Override
    public int deleteGoodsByGoodsids(String[] goodsids)
    {
        return goodsMapper.deleteGoodsByGoodsids(goodsids);
    }

    /**
     * 删除goods管理信息
     * 
     * @param goodsid goods管理主键
     * @return 结果
     */
    @Override
    public int deleteGoodsByGoodsid(String goodsid)
    {
        return goodsMapper.deleteGoodsByGoodsid(goodsid);
    }
}
