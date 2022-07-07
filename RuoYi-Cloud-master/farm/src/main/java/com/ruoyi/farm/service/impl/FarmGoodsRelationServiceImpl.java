package com.ruoyi.farm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.farm.mapper.FarmGoodsRelationMapper;
import com.ruoyi.farm.domain.FarmGoodsRelation;
import com.ruoyi.farm.service.IFarmGoodsRelationService;

/**
 * goods_relation管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class FarmGoodsRelationServiceImpl implements IFarmGoodsRelationService 
{
    @Autowired
    private FarmGoodsRelationMapper farmGoodsRelationMapper;

    /**
     * 查询goods_relation管理
     * 
     * @param farmid goods_relation管理主键
     * @return goods_relation管理
     */
    @Override
    public FarmGoodsRelation selectFarmGoodsRelationByFarmid(String farmid)
    {
        return farmGoodsRelationMapper.selectFarmGoodsRelationByFarmid(farmid);
    }

    /**
     * 查询goods_relation管理列表
     * 
     * @param farmGoodsRelation goods_relation管理
     * @return goods_relation管理
     */
    @Override
    public List<FarmGoodsRelation> selectFarmGoodsRelationList(FarmGoodsRelation farmGoodsRelation)
    {
        return farmGoodsRelationMapper.selectFarmGoodsRelationList(farmGoodsRelation);
    }

    /**
     * 新增goods_relation管理
     * 
     * @param farmGoodsRelation goods_relation管理
     * @return 结果
     */
    @Override
    public int insertFarmGoodsRelation(FarmGoodsRelation farmGoodsRelation)
    {
        farmGoodsRelation.setCreateTime(DateUtils.getNowDate());
        return farmGoodsRelationMapper.insertFarmGoodsRelation(farmGoodsRelation);
    }

    /**
     * 修改goods_relation管理
     * 
     * @param farmGoodsRelation goods_relation管理
     * @return 结果
     */
    @Override
    public int updateFarmGoodsRelation(FarmGoodsRelation farmGoodsRelation)
    {
        farmGoodsRelation.setUpdateTime(DateUtils.getNowDate());
        return farmGoodsRelationMapper.updateFarmGoodsRelation(farmGoodsRelation);
    }

    /**
     * 批量删除goods_relation管理
     * 
     * @param farmids 需要删除的goods_relation管理主键
     * @return 结果
     */
    @Override
    public int deleteFarmGoodsRelationByFarmids(String[] farmids)
    {
        return farmGoodsRelationMapper.deleteFarmGoodsRelationByFarmids(farmids);
    }

    /**
     * 删除goods_relation管理信息
     * 
     * @param farmid goods_relation管理主键
     * @return 结果
     */
    @Override
    public int deleteFarmGoodsRelationByFarmid(String farmid)
    {
        return farmGoodsRelationMapper.deleteFarmGoodsRelationByFarmid(farmid);
    }
}
