package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzTransfeeFree;

/**
 * 运费信息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface TzTransfeeFreeMapper 
{
    /**
     * 查询运费信息
     * 
     * @param transfeeFreeId 运费信息主键
     * @return 运费信息
     */
    public TzTransfeeFree selectTzTransfeeFreeByTransfeeFreeId(Long transfeeFreeId);

    /**
     * 查询运费信息列表
     * 
     * @param tzTransfeeFree 运费信息
     * @return 运费信息集合
     */
    public List<TzTransfeeFree> selectTzTransfeeFreeList(TzTransfeeFree tzTransfeeFree);

    /**
     * 新增运费信息
     * 
     * @param tzTransfeeFree 运费信息
     * @return 结果
     */
    public int insertTzTransfeeFree(TzTransfeeFree tzTransfeeFree);

    /**
     * 修改运费信息
     * 
     * @param tzTransfeeFree 运费信息
     * @return 结果
     */
    public int updateTzTransfeeFree(TzTransfeeFree tzTransfeeFree);

    /**
     * 删除运费信息
     * 
     * @param transfeeFreeId 运费信息主键
     * @return 结果
     */
    public int deleteTzTransfeeFreeByTransfeeFreeId(Long transfeeFreeId);

    /**
     * 批量删除运费信息
     * 
     * @param transfeeFreeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzTransfeeFreeByTransfeeFreeIds(Long[] transfeeFreeIds);
}
