package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzUserCollectionMapper;
import com.ruoyi.Greenfarm.domain.TzUserCollection;
import com.ruoyi.Greenfarm.service.ITzUserCollectionService;

/**
 * 用户收藏管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzUserCollectionServiceImpl implements ITzUserCollectionService 
{
    @Autowired
    private TzUserCollectionMapper tzUserCollectionMapper;

    /**
     * 查询用户收藏管理
     * 
     * @param id 用户收藏管理主键
     * @return 用户收藏管理
     */
    @Override
    public TzUserCollection selectTzUserCollectionById(Long id)
    {
        return tzUserCollectionMapper.selectTzUserCollectionById(id);
    }

    /**
     * 查询用户收藏管理列表
     * 
     * @param tzUserCollection 用户收藏管理
     * @return 用户收藏管理
     */
    @Override
    public List<TzUserCollection> selectTzUserCollectionList(TzUserCollection tzUserCollection)
    {
        return tzUserCollectionMapper.selectTzUserCollectionList(tzUserCollection);
    }

    /**
     * 新增用户收藏管理
     * 
     * @param tzUserCollection 用户收藏管理
     * @return 结果
     */
    @Override
    public int insertTzUserCollection(TzUserCollection tzUserCollection)
    {
        tzUserCollection.setCreateTime(DateUtils.getNowDate());
        return tzUserCollectionMapper.insertTzUserCollection(tzUserCollection);
    }

    /**
     * 修改用户收藏管理
     * 
     * @param tzUserCollection 用户收藏管理
     * @return 结果
     */
    @Override
    public int updateTzUserCollection(TzUserCollection tzUserCollection)
    {
        return tzUserCollectionMapper.updateTzUserCollection(tzUserCollection);
    }

    /**
     * 批量删除用户收藏管理
     * 
     * @param ids 需要删除的用户收藏管理主键
     * @return 结果
     */
    @Override
    public int deleteTzUserCollectionByIds(Long[] ids)
    {
        return tzUserCollectionMapper.deleteTzUserCollectionByIds(ids);
    }

    /**
     * 删除用户收藏管理信息
     * 
     * @param id 用户收藏管理主键
     * @return 结果
     */
    @Override
    public int deleteTzUserCollectionById(Long id)
    {
        return tzUserCollectionMapper.deleteTzUserCollectionById(id);
    }
}
