package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzTranscityFree;

/**
 * 包邮信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface TzTranscityFreeMapper 
{
    /**
     * 查询包邮信息
     * 
     * @param transcityFreeId 包邮信息主键
     * @return 包邮信息
     */
    public TzTranscityFree selectTzTranscityFreeByTranscityFreeId(Long transcityFreeId);

    /**
     * 查询包邮信息列表
     * 
     * @param tzTranscityFree 包邮信息
     * @return 包邮信息集合
     */
    public List<TzTranscityFree> selectTzTranscityFreeList(TzTranscityFree tzTranscityFree);

    /**
     * 新增包邮信息
     * 
     * @param tzTranscityFree 包邮信息
     * @return 结果
     */
    public int insertTzTranscityFree(TzTranscityFree tzTranscityFree);

    /**
     * 修改包邮信息
     * 
     * @param tzTranscityFree 包邮信息
     * @return 结果
     */
    public int updateTzTranscityFree(TzTranscityFree tzTranscityFree);

    /**
     * 删除包邮信息
     * 
     * @param transcityFreeId 包邮信息主键
     * @return 结果
     */
    public int deleteTzTranscityFreeByTranscityFreeId(Long transcityFreeId);

    /**
     * 批量删除包邮信息
     * 
     * @param transcityFreeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzTranscityFreeByTranscityFreeIds(Long[] transcityFreeIds);
}
