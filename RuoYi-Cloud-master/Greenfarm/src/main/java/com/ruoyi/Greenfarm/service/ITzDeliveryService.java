package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzDelivery;

/**
 * 物流公司Service接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface ITzDeliveryService 
{
    /**
     * 查询物流公司
     * 
     * @param dvyId 物流公司主键
     * @return 物流公司
     */
    public TzDelivery selectTzDeliveryByDvyId(Long dvyId);

    /**
     * 查询物流公司列表
     * 
     * @param tzDelivery 物流公司
     * @return 物流公司集合
     */
    public List<TzDelivery> selectTzDeliveryList(TzDelivery tzDelivery);

    /**
     * 新增物流公司
     * 
     * @param tzDelivery 物流公司
     * @return 结果
     */
    public int insertTzDelivery(TzDelivery tzDelivery);

    /**
     * 修改物流公司
     * 
     * @param tzDelivery 物流公司
     * @return 结果
     */
    public int updateTzDelivery(TzDelivery tzDelivery);

    /**
     * 批量删除物流公司
     * 
     * @param dvyIds 需要删除的物流公司主键集合
     * @return 结果
     */
    public int deleteTzDeliveryByDvyIds(Long[] dvyIds);

    /**
     * 删除物流公司信息
     * 
     * @param dvyId 物流公司主键
     * @return 结果
     */
    public int deleteTzDeliveryByDvyId(Long dvyId);
}
