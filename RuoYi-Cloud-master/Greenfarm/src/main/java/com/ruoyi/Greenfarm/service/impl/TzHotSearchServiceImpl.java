package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzHotSearchMapper;
import com.ruoyi.Greenfarm.domain.TzHotSearch;
import com.ruoyi.Greenfarm.service.ITzHotSearchService;

/**
 * 热搜Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class TzHotSearchServiceImpl implements ITzHotSearchService 
{
    @Autowired
    private TzHotSearchMapper tzHotSearchMapper;

    /**
     * 查询热搜
     * 
     * @param hotSearchId 热搜主键
     * @return 热搜
     */
    @Override
    public TzHotSearch selectTzHotSearchByHotSearchId(Long hotSearchId)
    {
        return tzHotSearchMapper.selectTzHotSearchByHotSearchId(hotSearchId);
    }

    /**
     * 查询热搜列表
     * 
     * @param tzHotSearch 热搜
     * @return 热搜
     */
    @Override
    public List<TzHotSearch> selectTzHotSearchList(TzHotSearch tzHotSearch)
    {
        return tzHotSearchMapper.selectTzHotSearchList(tzHotSearch);
    }

    /**
     * 新增热搜
     * 
     * @param tzHotSearch 热搜
     * @return 结果
     */
    @Override
    public int insertTzHotSearch(TzHotSearch tzHotSearch)
    {
        return tzHotSearchMapper.insertTzHotSearch(tzHotSearch);
    }

    /**
     * 修改热搜
     * 
     * @param tzHotSearch 热搜
     * @return 结果
     */
    @Override
    public int updateTzHotSearch(TzHotSearch tzHotSearch)
    {
        return tzHotSearchMapper.updateTzHotSearch(tzHotSearch);
    }

    /**
     * 批量删除热搜
     * 
     * @param hotSearchIds 需要删除的热搜主键
     * @return 结果
     */
    @Override
    public int deleteTzHotSearchByHotSearchIds(Long[] hotSearchIds)
    {
        return tzHotSearchMapper.deleteTzHotSearchByHotSearchIds(hotSearchIds);
    }

    /**
     * 删除热搜信息
     * 
     * @param hotSearchId 热搜主键
     * @return 结果
     */
    @Override
    public int deleteTzHotSearchByHotSearchId(Long hotSearchId)
    {
        return tzHotSearchMapper.deleteTzHotSearchByHotSearchId(hotSearchId);
    }
}
