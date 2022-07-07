package com.ruoyi.farm.mapper;

import java.util.List;
import com.ruoyi.farm.domain.FarmGoodsRelation;

/**
 * goods_relation管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface FarmGoodsRelationMapper 
{
    /**
     * 查询goods_relation管理
     * 
     * @param farmid goods_relation管理主键
     * @return goods_relation管理
     */
    public FarmGoodsRelation selectFarmGoodsRelationByFarmid(String farmid);

    /**
     * 查询goods_relation管理列表
     * 
     * @param farmGoodsRelation goods_relation管理
     * @return goods_relation管理集合
     */
    public List<FarmGoodsRelation> selectFarmGoodsRelationList(FarmGoodsRelation farmGoodsRelation);

    /**
     * 新增goods_relation管理
     * 
     * @param farmGoodsRelation goods_relation管理
     * @return 结果
     */
    public int insertFarmGoodsRelation(FarmGoodsRelation farmGoodsRelation);

    /**
     * 修改goods_relation管理
     * 
     * @param farmGoodsRelation goods_relation管理
     * @return 结果
     */
    public int updateFarmGoodsRelation(FarmGoodsRelation farmGoodsRelation);

    /**
     * 删除goods_relation管理
     * 
     * @param farmid goods_relation管理主键
     * @return 结果
     */
    public int deleteFarmGoodsRelationByFarmid(String farmid);

    /**
     * 批量删除goods_relation管理
     * 
     * @param farmids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFarmGoodsRelationByFarmids(String[] farmids);
}
