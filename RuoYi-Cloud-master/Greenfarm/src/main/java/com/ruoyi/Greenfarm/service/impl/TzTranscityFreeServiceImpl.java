package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzTranscityFreeMapper;
import com.ruoyi.Greenfarm.domain.TzTranscityFree;
import com.ruoyi.Greenfarm.service.ITzTranscityFreeService;

/**
 * 包邮信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzTranscityFreeServiceImpl implements ITzTranscityFreeService 
{
    @Autowired
    private TzTranscityFreeMapper tzTranscityFreeMapper;

    /**
     * 查询包邮信息
     * 
     * @param transcityFreeId 包邮信息主键
     * @return 包邮信息
     */
    @Override
    public TzTranscityFree selectTzTranscityFreeByTranscityFreeId(Long transcityFreeId)
    {
        return tzTranscityFreeMapper.selectTzTranscityFreeByTranscityFreeId(transcityFreeId);
    }

    /**
     * 查询包邮信息列表
     * 
     * @param tzTranscityFree 包邮信息
     * @return 包邮信息
     */
    @Override
    public List<TzTranscityFree> selectTzTranscityFreeList(TzTranscityFree tzTranscityFree)
    {
        return tzTranscityFreeMapper.selectTzTranscityFreeList(tzTranscityFree);
    }

    /**
     * 新增包邮信息
     * 
     * @param tzTranscityFree 包邮信息
     * @return 结果
     */
    @Override
    public int insertTzTranscityFree(TzTranscityFree tzTranscityFree)
    {
        return tzTranscityFreeMapper.insertTzTranscityFree(tzTranscityFree);
    }

    /**
     * 修改包邮信息
     * 
     * @param tzTranscityFree 包邮信息
     * @return 结果
     */
    @Override
    public int updateTzTranscityFree(TzTranscityFree tzTranscityFree)
    {
        return tzTranscityFreeMapper.updateTzTranscityFree(tzTranscityFree);
    }

    /**
     * 批量删除包邮信息
     * 
     * @param transcityFreeIds 需要删除的包邮信息主键
     * @return 结果
     */
    @Override
    public int deleteTzTranscityFreeByTranscityFreeIds(Long[] transcityFreeIds)
    {
        return tzTranscityFreeMapper.deleteTzTranscityFreeByTranscityFreeIds(transcityFreeIds);
    }

    /**
     * 删除包邮信息信息
     * 
     * @param transcityFreeId 包邮信息主键
     * @return 结果
     */
    @Override
    public int deleteTzTranscityFreeByTranscityFreeId(Long transcityFreeId)
    {
        return tzTranscityFreeMapper.deleteTzTranscityFreeByTranscityFreeId(transcityFreeId);
    }
}
