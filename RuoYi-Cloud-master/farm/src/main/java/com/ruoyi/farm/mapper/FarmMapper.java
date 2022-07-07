package com.ruoyi.farm.mapper;

import java.util.List;
import com.ruoyi.farm.domain.Farm;

/**
 * farm管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface FarmMapper 
{
    /**
     * 查询farm管理
     * 
     * @param farmid farm管理主键
     * @return farm管理
     */
    public Farm selectFarmByFarmid(String farmid);

    /**
     * 查询farm管理列表
     * 
     * @param farm farm管理
     * @return farm管理集合
     */
    public List<Farm> selectFarmList(Farm farm);

    /**
     * 新增farm管理
     * 
     * @param farm farm管理
     * @return 结果
     */
    public int insertFarm(Farm farm);

    /**
     * 修改farm管理
     * 
     * @param farm farm管理
     * @return 结果
     */
    public int updateFarm(Farm farm);

    /**
     * 删除farm管理
     * 
     * @param farmid farm管理主键
     * @return 结果
     */
    public int deleteFarmByFarmid(String farmid);

    /**
     * 批量删除farm管理
     * 
     * @param farmids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFarmByFarmids(String[] farmids);
}
