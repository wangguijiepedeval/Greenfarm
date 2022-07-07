package com.ruoyi.farm.mapper;

import java.util.List;
import com.ruoyi.farm.domain.Goods;

/**
 * goods管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface GoodsMapper 
{
    /**
     * 查询goods管理
     * 
     * @param goodsid goods管理主键
     * @return goods管理
     */
    public Goods selectGoodsByGoodsid(String goodsid);

    /**
     * 查询goods管理列表
     * 
     * @param goods goods管理
     * @return goods管理集合
     */
    public List<Goods> selectGoodsList(Goods goods);

    /**
     * 新增goods管理
     * 
     * @param goods goods管理
     * @return 结果
     */
    public int insertGoods(Goods goods);

    /**
     * 修改goods管理
     * 
     * @param goods goods管理
     * @return 结果
     */
    public int updateGoods(Goods goods);

    /**
     * 删除goods管理
     * 
     * @param goodsid goods管理主键
     * @return 结果
     */
    public int deleteGoodsByGoodsid(String goodsid);

    /**
     * 批量删除goods管理
     * 
     * @param goodsids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteGoodsByGoodsids(String[] goodsids);
}
