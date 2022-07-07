package com.ruoyi.farm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.farm.mapper.FarmMapper;
import com.ruoyi.farm.domain.Farm;
import com.ruoyi.farm.service.IFarmService;

/**
 * farm管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class FarmServiceImpl implements IFarmService 
{
    @Autowired
    private FarmMapper farmMapper;

    /**
     * 查询farm管理
     * 
     * @param farmid farm管理主键
     * @return farm管理
     */
    @Override
    public Farm selectFarmByFarmid(String farmid)
    {
        return farmMapper.selectFarmByFarmid(farmid);
    }

    /**
     * 查询farm管理列表
     * 
     * @param farm farm管理
     * @return farm管理
     */
    @Override
    public List<Farm> selectFarmList(Farm farm)
    {
        return farmMapper.selectFarmList(farm);
    }

    /**
     * 新增farm管理
     * 
     * @param farm farm管理
     * @return 结果
     */
    @Override
    public int insertFarm(Farm farm)
    {
        farm.setCreateTime(DateUtils.getNowDate());
        return farmMapper.insertFarm(farm);
    }

    /**
     * 修改farm管理
     * 
     * @param farm farm管理
     * @return 结果
     */
    @Override
    public int updateFarm(Farm farm)
    {
        farm.setUpdateTime(DateUtils.getNowDate());
        return farmMapper.updateFarm(farm);
    }

    /**
     * 批量删除farm管理
     * 
     * @param farmids 需要删除的farm管理主键
     * @return 结果
     */
    @Override
    public int deleteFarmByFarmids(String[] farmids)
    {
        return farmMapper.deleteFarmByFarmids(farmids);
    }

    /**
     * 删除farm管理信息
     * 
     * @param farmid farm管理主键
     * @return 结果
     */
    @Override
    public int deleteFarmByFarmid(String farmid)
    {
        return farmMapper.deleteFarmByFarmid(farmid);
    }
}
