package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzTranscityMapper;
import com.ruoyi.Greenfarm.domain.TzTranscity;
import com.ruoyi.Greenfarm.service.ITzTranscityService;

/**
 * tz_transcityService业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class TzTranscityServiceImpl implements ITzTranscityService 
{
    @Autowired
    private TzTranscityMapper tzTranscityMapper;

    /**
     * 查询tz_transcity
     * 
     * @param transcityId tz_transcity主键
     * @return tz_transcity
     */
    @Override
    public TzTranscity selectTzTranscityByTranscityId(Long transcityId)
    {
        return tzTranscityMapper.selectTzTranscityByTranscityId(transcityId);
    }

    /**
     * 查询tz_transcity列表
     * 
     * @param tzTranscity tz_transcity
     * @return tz_transcity
     */
    @Override
    public List<TzTranscity> selectTzTranscityList(TzTranscity tzTranscity)
    {
        return tzTranscityMapper.selectTzTranscityList(tzTranscity);
    }

    /**
     * 新增tz_transcity
     * 
     * @param tzTranscity tz_transcity
     * @return 结果
     */
    @Override
    public int insertTzTranscity(TzTranscity tzTranscity)
    {
        return tzTranscityMapper.insertTzTranscity(tzTranscity);
    }

    /**
     * 修改tz_transcity
     * 
     * @param tzTranscity tz_transcity
     * @return 结果
     */
    @Override
    public int updateTzTranscity(TzTranscity tzTranscity)
    {
        return tzTranscityMapper.updateTzTranscity(tzTranscity);
    }

    /**
     * 批量删除tz_transcity
     * 
     * @param transcityIds 需要删除的tz_transcity主键
     * @return 结果
     */
    @Override
    public int deleteTzTranscityByTranscityIds(Long[] transcityIds)
    {
        return tzTranscityMapper.deleteTzTranscityByTranscityIds(transcityIds);
    }

    /**
     * 删除tz_transcity信息
     * 
     * @param transcityId tz_transcity主键
     * @return 结果
     */
    @Override
    public int deleteTzTranscityByTranscityId(Long transcityId)
    {
        return tzTranscityMapper.deleteTzTranscityByTranscityId(transcityId);
    }
}
