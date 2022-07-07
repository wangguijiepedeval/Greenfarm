package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzArea;

/**
 * 地址信息Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzAreaService 
{
    /**
     * 查询地址信息
     * 
     * @param areaId 地址信息主键
     * @return 地址信息
     */
    public TzArea selectTzAreaByAreaId(Long areaId);

    /**
     * 查询地址信息列表
     * 
     * @param tzArea 地址信息
     * @return 地址信息集合
     */
    public List<TzArea> selectTzAreaList(TzArea tzArea);

    /**
     * 新增地址信息
     * 
     * @param tzArea 地址信息
     * @return 结果
     */
    public int insertTzArea(TzArea tzArea);

    /**
     * 修改地址信息
     * 
     * @param tzArea 地址信息
     * @return 结果
     */
    public int updateTzArea(TzArea tzArea);

    /**
     * 批量删除地址信息
     * 
     * @param areaIds 需要删除的地址信息主键集合
     * @return 结果
     */
    public int deleteTzAreaByAreaIds(Long[] areaIds);

    /**
     * 删除地址信息信息
     * 
     * @param areaId 地址信息主键
     * @return 结果
     */
    public int deleteTzAreaByAreaId(Long areaId);
}
