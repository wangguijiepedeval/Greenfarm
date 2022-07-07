package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzDeliveryMapper;
import com.ruoyi.Greenfarm.domain.TzDelivery;
import com.ruoyi.Greenfarm.service.ITzDeliveryService;

/**
 * 物流公司Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class TzDeliveryServiceImpl implements ITzDeliveryService 
{
    @Autowired
    private TzDeliveryMapper tzDeliveryMapper;

    /**
     * 查询物流公司
     * 
     * @param dvyId 物流公司主键
     * @return 物流公司
     */
    @Override
    public TzDelivery selectTzDeliveryByDvyId(Long dvyId)
    {
        return tzDeliveryMapper.selectTzDeliveryByDvyId(dvyId);
    }

    /**
     * 查询物流公司列表
     * 
     * @param tzDelivery 物流公司
     * @return 物流公司
     */
    @Override
    public List<TzDelivery> selectTzDeliveryList(TzDelivery tzDelivery)
    {
        return tzDeliveryMapper.selectTzDeliveryList(tzDelivery);
    }

    /**
     * 新增物流公司
     * 
     * @param tzDelivery 物流公司
     * @return 结果
     */
    @Override
    public int insertTzDelivery(TzDelivery tzDelivery)
    {
        return tzDeliveryMapper.insertTzDelivery(tzDelivery);
    }

    /**
     * 修改物流公司
     * 
     * @param tzDelivery 物流公司
     * @return 结果
     */
    @Override
    public int updateTzDelivery(TzDelivery tzDelivery)
    {
        return tzDeliveryMapper.updateTzDelivery(tzDelivery);
    }

    /**
     * 批量删除物流公司
     * 
     * @param dvyIds 需要删除的物流公司主键
     * @return 结果
     */
    @Override
    public int deleteTzDeliveryByDvyIds(Long[] dvyIds)
    {
        return tzDeliveryMapper.deleteTzDeliveryByDvyIds(dvyIds);
    }

    /**
     * 删除物流公司信息
     * 
     * @param dvyId 物流公司主键
     * @return 结果
     */
    @Override
    public int deleteTzDeliveryByDvyId(Long dvyId)
    {
        return tzDeliveryMapper.deleteTzDeliveryByDvyId(dvyId);
    }
}
