package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzSysConfigMapper;
import com.ruoyi.Greenfarm.domain.TzSysConfig;
import com.ruoyi.Greenfarm.service.ITzSysConfigService;

/**
 * 系统配置信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class TzSysConfigServiceImpl implements ITzSysConfigService 
{
    @Autowired
    private TzSysConfigMapper tzSysConfigMapper;

    /**
     * 查询系统配置信息
     * 
     * @param id 系统配置信息主键
     * @return 系统配置信息
     */
    @Override
    public TzSysConfig selectTzSysConfigById(Long id)
    {
        return tzSysConfigMapper.selectTzSysConfigById(id);
    }

    /**
     * 查询系统配置信息列表
     * 
     * @param tzSysConfig 系统配置信息
     * @return 系统配置信息
     */
    @Override
    public List<TzSysConfig> selectTzSysConfigList(TzSysConfig tzSysConfig)
    {
        return tzSysConfigMapper.selectTzSysConfigList(tzSysConfig);
    }

    /**
     * 新增系统配置信息
     * 
     * @param tzSysConfig 系统配置信息
     * @return 结果
     */
    @Override
    public int insertTzSysConfig(TzSysConfig tzSysConfig)
    {
        return tzSysConfigMapper.insertTzSysConfig(tzSysConfig);
    }

    /**
     * 修改系统配置信息
     * 
     * @param tzSysConfig 系统配置信息
     * @return 结果
     */
    @Override
    public int updateTzSysConfig(TzSysConfig tzSysConfig)
    {
        return tzSysConfigMapper.updateTzSysConfig(tzSysConfig);
    }

    /**
     * 批量删除系统配置信息
     * 
     * @param ids 需要删除的系统配置信息主键
     * @return 结果
     */
    @Override
    public int deleteTzSysConfigByIds(Long[] ids)
    {
        return tzSysConfigMapper.deleteTzSysConfigByIds(ids);
    }

    /**
     * 删除系统配置信息信息
     * 
     * @param id 系统配置信息主键
     * @return 结果
     */
    @Override
    public int deleteTzSysConfigById(Long id)
    {
        return tzSysConfigMapper.deleteTzSysConfigById(id);
    }
}
