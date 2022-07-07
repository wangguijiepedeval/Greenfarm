package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzDelivery;

/**
 * 物流公司Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface TzDeliveryMapper 
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
     * 删除物流公司
     * 
     * @param dvyId 物流公司主键
     * @return 结果
     */
    public int deleteTzDeliveryByDvyId(Long dvyId);

    /**
     * 批量删除物流公司
     * 
     * @param dvyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzDeliveryByDvyIds(Long[] dvyIds);
}
