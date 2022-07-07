package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzHotSearch;

/**
 * 热搜Service接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface ITzHotSearchService 
{
    /**
     * 查询热搜
     * 
     * @param hotSearchId 热搜主键
     * @return 热搜
     */
    public TzHotSearch selectTzHotSearchByHotSearchId(Long hotSearchId);

    /**
     * 查询热搜列表
     * 
     * @param tzHotSearch 热搜
     * @return 热搜集合
     */
    public List<TzHotSearch> selectTzHotSearchList(TzHotSearch tzHotSearch);

    /**
     * 新增热搜
     * 
     * @param tzHotSearch 热搜
     * @return 结果
     */
    public int insertTzHotSearch(TzHotSearch tzHotSearch);

    /**
     * 修改热搜
     * 
     * @param tzHotSearch 热搜
     * @return 结果
     */
    public int updateTzHotSearch(TzHotSearch tzHotSearch);

    /**
     * 批量删除热搜
     * 
     * @param hotSearchIds 需要删除的热搜主键集合
     * @return 结果
     */
    public int deleteTzHotSearchByHotSearchIds(Long[] hotSearchIds);

    /**
     * 删除热搜信息
     * 
     * @param hotSearchId 热搜主键
     * @return 结果
     */
    public int deleteTzHotSearchByHotSearchId(Long hotSearchId);
}
