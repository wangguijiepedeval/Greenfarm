package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzShopDetail;

/**
 * 商家管理Service接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface ITzShopDetailService 
{
    /**
     * 查询商家管理
     * 
     * @param shopId 商家管理主键
     * @return 商家管理
     */
    public TzShopDetail selectTzShopDetailByShopId(Long shopId);

    /**
     * 查询商家管理列表
     * 
     * @param tzShopDetail 商家管理
     * @return 商家管理集合
     */
    public List<TzShopDetail> selectTzShopDetailList(TzShopDetail tzShopDetail);

    /**
     * 新增商家管理
     * 
     * @param tzShopDetail 商家管理
     * @return 结果
     */
    public int insertTzShopDetail(TzShopDetail tzShopDetail);

    /**
     * 修改商家管理
     * 
     * @param tzShopDetail 商家管理
     * @return 结果
     */
    public int updateTzShopDetail(TzShopDetail tzShopDetail);

    /**
     * 批量删除商家管理
     * 
     * @param shopIds 需要删除的商家管理主键集合
     * @return 结果
     */
    public int deleteTzShopDetailByShopIds(Long[] shopIds);

    /**
     * 删除商家管理信息
     * 
     * @param shopId 商家管理主键
     * @return 结果
     */
    public int deleteTzShopDetailByShopId(Long shopId);
}
