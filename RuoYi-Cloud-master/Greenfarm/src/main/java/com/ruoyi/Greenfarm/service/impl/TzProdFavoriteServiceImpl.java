package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzProdFavoriteMapper;
import com.ruoyi.Greenfarm.domain.TzProdFavorite;
import com.ruoyi.Greenfarm.service.ITzProdFavoriteService;

/**
 * 商品收藏Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzProdFavoriteServiceImpl implements ITzProdFavoriteService 
{
    @Autowired
    private TzProdFavoriteMapper tzProdFavoriteMapper;

    /**
     * 查询商品收藏
     * 
     * @param favoriteId 商品收藏主键
     * @return 商品收藏
     */
    @Override
    public TzProdFavorite selectTzProdFavoriteByFavoriteId(Long favoriteId)
    {
        return tzProdFavoriteMapper.selectTzProdFavoriteByFavoriteId(favoriteId);
    }

    /**
     * 查询商品收藏列表
     * 
     * @param tzProdFavorite 商品收藏
     * @return 商品收藏
     */
    @Override
    public List<TzProdFavorite> selectTzProdFavoriteList(TzProdFavorite tzProdFavorite)
    {
        return tzProdFavoriteMapper.selectTzProdFavoriteList(tzProdFavorite);
    }

    /**
     * 新增商品收藏
     * 
     * @param tzProdFavorite 商品收藏
     * @return 结果
     */
    @Override
    public int insertTzProdFavorite(TzProdFavorite tzProdFavorite)
    {
        return tzProdFavoriteMapper.insertTzProdFavorite(tzProdFavorite);
    }

    /**
     * 修改商品收藏
     * 
     * @param tzProdFavorite 商品收藏
     * @return 结果
     */
    @Override
    public int updateTzProdFavorite(TzProdFavorite tzProdFavorite)
    {
        return tzProdFavoriteMapper.updateTzProdFavorite(tzProdFavorite);
    }

    /**
     * 批量删除商品收藏
     * 
     * @param favoriteIds 需要删除的商品收藏主键
     * @return 结果
     */
    @Override
    public int deleteTzProdFavoriteByFavoriteIds(Long[] favoriteIds)
    {
        return tzProdFavoriteMapper.deleteTzProdFavoriteByFavoriteIds(favoriteIds);
    }

    /**
     * 删除商品收藏信息
     * 
     * @param favoriteId 商品收藏主键
     * @return 结果
     */
    @Override
    public int deleteTzProdFavoriteByFavoriteId(Long favoriteId)
    {
        return tzProdFavoriteMapper.deleteTzProdFavoriteByFavoriteId(favoriteId);
    }
}
