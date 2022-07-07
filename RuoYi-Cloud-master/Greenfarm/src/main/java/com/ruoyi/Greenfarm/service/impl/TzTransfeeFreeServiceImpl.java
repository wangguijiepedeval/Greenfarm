package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzTransfeeFreeMapper;
import com.ruoyi.Greenfarm.domain.TzTransfeeFree;
import com.ruoyi.Greenfarm.service.ITzTransfeeFreeService;

/**
 * 运费信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzTransfeeFreeServiceImpl implements ITzTransfeeFreeService 
{
    @Autowired
    private TzTransfeeFreeMapper tzTransfeeFreeMapper;

    /**
     * 查询运费信息
     * 
     * @param transfeeFreeId 运费信息主键
     * @return 运费信息
     */
    @Override
    public TzTransfeeFree selectTzTransfeeFreeByTransfeeFreeId(Long transfeeFreeId)
    {
        return tzTransfeeFreeMapper.selectTzTransfeeFreeByTransfeeFreeId(transfeeFreeId);
    }

    /**
     * 查询运费信息列表
     * 
     * @param tzTransfeeFree 运费信息
     * @return 运费信息
     */
    @Override
    public List<TzTransfeeFree> selectTzTransfeeFreeList(TzTransfeeFree tzTransfeeFree)
    {
        return tzTransfeeFreeMapper.selectTzTransfeeFreeList(tzTransfeeFree);
    }

    /**
     * 新增运费信息
     * 
     * @param tzTransfeeFree 运费信息
     * @return 结果
     */
    @Override
    public int insertTzTransfeeFree(TzTransfeeFree tzTransfeeFree)
    {
        return tzTransfeeFreeMapper.insertTzTransfeeFree(tzTransfeeFree);
    }

    /**
     * 修改运费信息
     * 
     * @param tzTransfeeFree 运费信息
     * @return 结果
     */
    @Override
    public int updateTzTransfeeFree(TzTransfeeFree tzTransfeeFree)
    {
        return tzTransfeeFreeMapper.updateTzTransfeeFree(tzTransfeeFree);
    }

    /**
     * 批量删除运费信息
     * 
     * @param transfeeFreeIds 需要删除的运费信息主键
     * @return 结果
     */
    @Override
    public int deleteTzTransfeeFreeByTransfeeFreeIds(Long[] transfeeFreeIds)
    {
        return tzTransfeeFreeMapper.deleteTzTransfeeFreeByTransfeeFreeIds(transfeeFreeIds);
    }

    /**
     * 删除运费信息信息
     * 
     * @param transfeeFreeId 运费信息主键
     * @return 结果
     */
    @Override
    public int deleteTzTransfeeFreeByTransfeeFreeId(Long transfeeFreeId)
    {
        return tzTransfeeFreeMapper.deleteTzTransfeeFreeByTransfeeFreeId(transfeeFreeId);
    }
}
