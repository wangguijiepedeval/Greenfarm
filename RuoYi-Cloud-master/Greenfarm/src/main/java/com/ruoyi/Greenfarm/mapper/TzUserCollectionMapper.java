package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzUserCollection;

/**
 * 用户收藏管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface TzUserCollectionMapper 
{
    /**
     * 查询用户收藏管理
     * 
     * @param id 用户收藏管理主键
     * @return 用户收藏管理
     */
    public TzUserCollection selectTzUserCollectionById(Long id);

    /**
     * 查询用户收藏管理列表
     * 
     * @param tzUserCollection 用户收藏管理
     * @return 用户收藏管理集合
     */
    public List<TzUserCollection> selectTzUserCollectionList(TzUserCollection tzUserCollection);

    /**
     * 新增用户收藏管理
     * 
     * @param tzUserCollection 用户收藏管理
     * @return 结果
     */
    public int insertTzUserCollection(TzUserCollection tzUserCollection);

    /**
     * 修改用户收藏管理
     * 
     * @param tzUserCollection 用户收藏管理
     * @return 结果
     */
    public int updateTzUserCollection(TzUserCollection tzUserCollection);

    /**
     * 删除用户收藏管理
     * 
     * @param id 用户收藏管理主键
     * @return 结果
     */
    public int deleteTzUserCollectionById(Long id);

    /**
     * 批量删除用户收藏管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzUserCollectionByIds(Long[] ids);
}
