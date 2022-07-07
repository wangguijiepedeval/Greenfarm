package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzShopDetailMapper;
import com.ruoyi.Greenfarm.domain.TzShopDetail;
import com.ruoyi.Greenfarm.service.ITzShopDetailService;

/**
 * 商家管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class TzShopDetailServiceImpl implements ITzShopDetailService 
{
    @Autowired
    private TzShopDetailMapper tzShopDetailMapper;

    /**
     * 查询商家管理
     * 
     * @param shopId 商家管理主键
     * @return 商家管理
     */
    @Override
    public TzShopDetail selectTzShopDetailByShopId(Long shopId)
    {
        return tzShopDetailMapper.selectTzShopDetailByShopId(shopId);
    }

    /**
     * 查询商家管理列表
     * 
     * @param tzShopDetail 商家管理
     * @return 商家管理
     */
    @Override
    public List<TzShopDetail> selectTzShopDetailList(TzShopDetail tzShopDetail)
    {
        return tzShopDetailMapper.selectTzShopDetailList(tzShopDetail);
    }

    /**
     * 新增商家管理
     * 
     * @param tzShopDetail 商家管理
     * @return 结果
     */
    @Override
    public int insertTzShopDetail(TzShopDetail tzShopDetail)
    {
        tzShopDetail.setCreateTime(DateUtils.getNowDate());
        return tzShopDetailMapper.insertTzShopDetail(tzShopDetail);
    }

    /**
     * 修改商家管理
     * 
     * @param tzShopDetail 商家管理
     * @return 结果
     */
    @Override
    public int updateTzShopDetail(TzShopDetail tzShopDetail)
    {
        tzShopDetail.setUpdateTime(DateUtils.getNowDate());
        return tzShopDetailMapper.updateTzShopDetail(tzShopDetail);
    }

    /**
     * 批量删除商家管理
     * 
     * @param shopIds 需要删除的商家管理主键
     * @return 结果
     */
    @Override
    public int deleteTzShopDetailByShopIds(Long[] shopIds)
    {
        return tzShopDetailMapper.deleteTzShopDetailByShopIds(shopIds);
    }

    /**
     * 删除商家管理信息
     * 
     * @param shopId 商家管理主键
     * @return 结果
     */
    @Override
    public int deleteTzShopDetailByShopId(Long shopId)
    {
        return tzShopDetailMapper.deleteTzShopDetailByShopId(shopId);
    }
}
