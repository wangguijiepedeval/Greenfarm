package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzSysConfig;

/**
 * 系统配置信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface TzSysConfigMapper 
{
    /**
     * 查询系统配置信息
     * 
     * @param id 系统配置信息主键
     * @return 系统配置信息
     */
    public TzSysConfig selectTzSysConfigById(Long id);

    /**
     * 查询系统配置信息列表
     * 
     * @param tzSysConfig 系统配置信息
     * @return 系统配置信息集合
     */
    public List<TzSysConfig> selectTzSysConfigList(TzSysConfig tzSysConfig);

    /**
     * 新增系统配置信息
     * 
     * @param tzSysConfig 系统配置信息
     * @return 结果
     */
    public int insertTzSysConfig(TzSysConfig tzSysConfig);

    /**
     * 修改系统配置信息
     * 
     * @param tzSysConfig 系统配置信息
     * @return 结果
     */
    public int updateTzSysConfig(TzSysConfig tzSysConfig);

    /**
     * 删除系统配置信息
     * 
     * @param id 系统配置信息主键
     * @return 结果
     */
    public int deleteTzSysConfigById(Long id);

    /**
     * 批量删除系统配置信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzSysConfigByIds(Long[] ids);
}
