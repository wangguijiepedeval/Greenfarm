package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzAreaMapper;
import com.ruoyi.Greenfarm.domain.TzArea;
import com.ruoyi.Greenfarm.service.ITzAreaService;

/**
 * 地址信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzAreaServiceImpl implements ITzAreaService 
{
    @Autowired
    private TzAreaMapper tzAreaMapper;

    /**
     * 查询地址信息
     * 
     * @param areaId 地址信息主键
     * @return 地址信息
     */
    @Override
    public TzArea selectTzAreaByAreaId(Long areaId)
    {
        return tzAreaMapper.selectTzAreaByAreaId(areaId);
    }

    /**
     * 查询地址信息列表
     * 
     * @param tzArea 地址信息
     * @return 地址信息
     */
    @Override
    public List<TzArea> selectTzAreaList(TzArea tzArea)
    {
        return tzAreaMapper.selectTzAreaList(tzArea);
    }

    /**
     * 新增地址信息
     * 
     * @param tzArea 地址信息
     * @return 结果
     */
    @Override
    public int insertTzArea(TzArea tzArea)
    {
        return tzAreaMapper.insertTzArea(tzArea);
    }

    /**
     * 修改地址信息
     * 
     * @param tzArea 地址信息
     * @return 结果
     */
    @Override
    public int updateTzArea(TzArea tzArea)
    {
        return tzAreaMapper.updateTzArea(tzArea);
    }

    /**
     * 批量删除地址信息
     * 
     * @param areaIds 需要删除的地址信息主键
     * @return 结果
     */
    @Override
    public int deleteTzAreaByAreaIds(Long[] areaIds)
    {
        return tzAreaMapper.deleteTzAreaByAreaIds(areaIds);
    }

    /**
     * 删除地址信息信息
     * 
     * @param areaId 地址信息主键
     * @return 结果
     */
    @Override
    public int deleteTzAreaByAreaId(Long areaId)
    {
        return tzAreaMapper.deleteTzAreaByAreaId(areaId);
    }
}
