package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzProdFavorite;

/**
 * 商品收藏Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzProdFavoriteService 
{
    /**
     * 查询商品收藏
     * 
     * @param favoriteId 商品收藏主键
     * @return 商品收藏
     */
    public TzProdFavorite selectTzProdFavoriteByFavoriteId(Long favoriteId);

    /**
     * 查询商品收藏列表
     * 
     * @param tzProdFavorite 商品收藏
     * @return 商品收藏集合
     */
    public List<TzProdFavorite> selectTzProdFavoriteList(TzProdFavorite tzProdFavorite);

    /**
     * 新增商品收藏
     * 
     * @param tzProdFavorite 商品收藏
     * @return 结果
     */
    public int insertTzProdFavorite(TzProdFavorite tzProdFavorite);

    /**
     * 修改商品收藏
     * 
     * @param tzProdFavorite 商品收藏
     * @return 结果
     */
    public int updateTzProdFavorite(TzProdFavorite tzProdFavorite);

    /**
     * 批量删除商品收藏
     * 
     * @param favoriteIds 需要删除的商品收藏主键集合
     * @return 结果
     */
    public int deleteTzProdFavoriteByFavoriteIds(Long[] favoriteIds);

    /**
     * 删除商品收藏信息
     * 
     * @param favoriteId 商品收藏主键
     * @return 结果
     */
    public int deleteTzProdFavoriteByFavoriteId(Long favoriteId);
}
