package com.ruoyi.farm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.farm.mapper.FarmRentRelationMapper;
import com.ruoyi.farm.domain.FarmRentRelation;
import com.ruoyi.farm.service.IFarmRentRelationService;

/**
 * rent_relation管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class FarmRentRelationServiceImpl implements IFarmRentRelationService 
{
    @Autowired
    private FarmRentRelationMapper farmRentRelationMapper;

    /**
     * 查询rent_relation管理
     * 
     * @param userid rent_relation管理主键
     * @return rent_relation管理
     */
    @Override
    public FarmRentRelation selectFarmRentRelationByUserid(String userid)
    {
        return farmRentRelationMapper.selectFarmRentRelationByUserid(userid);
    }

    /**
     * 查询rent_relation管理列表
     * 
     * @param farmRentRelation rent_relation管理
     * @return rent_relation管理
     */
    @Override
    public List<FarmRentRelation> selectFarmRentRelationList(FarmRentRelation farmRentRelation)
    {
        return farmRentRelationMapper.selectFarmRentRelationList(farmRentRelation);
    }

    /**
     * 新增rent_relation管理
     * 
     * @param farmRentRelation rent_relation管理
     * @return 结果
     */
    @Override
    public int insertFarmRentRelation(FarmRentRelation farmRentRelation)
    {
        farmRentRelation.setCreateTime(DateUtils.getNowDate());
        return farmRentRelationMapper.insertFarmRentRelation(farmRentRelation);
    }

    /**
     * 修改rent_relation管理
     * 
     * @param farmRentRelation rent_relation管理
     * @return 结果
     */
    @Override
    public int updateFarmRentRelation(FarmRentRelation farmRentRelation)
    {
        farmRentRelation.setUpdateTime(DateUtils.getNowDate());
        return farmRentRelationMapper.updateFarmRentRelation(farmRentRelation);
    }

    /**
     * 批量删除rent_relation管理
     * 
     * @param userids 需要删除的rent_relation管理主键
     * @return 结果
     */
    @Override
    public int deleteFarmRentRelationByUserids(String[] userids)
    {
        return farmRentRelationMapper.deleteFarmRentRelationByUserids(userids);
    }

    /**
     * 删除rent_relation管理信息
     * 
     * @param userid rent_relation管理主键
     * @return 结果
     */
    @Override
    public int deleteFarmRentRelationByUserid(String userid)
    {
        return farmRentRelationMapper.deleteFarmRentRelationByUserid(userid);
    }
}
