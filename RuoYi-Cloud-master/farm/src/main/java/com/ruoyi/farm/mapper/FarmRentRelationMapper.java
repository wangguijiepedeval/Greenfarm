package com.ruoyi.farm.mapper;

import java.util.List;
import com.ruoyi.farm.domain.FarmRentRelation;

/**
 * rent_relation管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface FarmRentRelationMapper 
{
    /**
     * 查询rent_relation管理
     * 
     * @param userid rent_relation管理主键
     * @return rent_relation管理
     */
    public FarmRentRelation selectFarmRentRelationByUserid(String userid);

    /**
     * 查询rent_relation管理列表
     * 
     * @param farmRentRelation rent_relation管理
     * @return rent_relation管理集合
     */
    public List<FarmRentRelation> selectFarmRentRelationList(FarmRentRelation farmRentRelation);

    /**
     * 新增rent_relation管理
     * 
     * @param farmRentRelation rent_relation管理
     * @return 结果
     */
    public int insertFarmRentRelation(FarmRentRelation farmRentRelation);

    /**
     * 修改rent_relation管理
     * 
     * @param farmRentRelation rent_relation管理
     * @return 结果
     */
    public int updateFarmRentRelation(FarmRentRelation farmRentRelation);

    /**
     * 删除rent_relation管理
     * 
     * @param userid rent_relation管理主键
     * @return 结果
     */
    public int deleteFarmRentRelationByUserid(String userid);

    /**
     * 批量删除rent_relation管理
     * 
     * @param userids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFarmRentRelationByUserids(String[] userids);
}
