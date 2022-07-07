package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzTranscity;

/**
 * tz_transcityMapper接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface TzTranscityMapper 
{
    /**
     * 查询tz_transcity
     * 
     * @param transcityId tz_transcity主键
     * @return tz_transcity
     */
    public TzTranscity selectTzTranscityByTranscityId(Long transcityId);

    /**
     * 查询tz_transcity列表
     * 
     * @param tzTranscity tz_transcity
     * @return tz_transcity集合
     */
    public List<TzTranscity> selectTzTranscityList(TzTranscity tzTranscity);

    /**
     * 新增tz_transcity
     * 
     * @param tzTranscity tz_transcity
     * @return 结果
     */
    public int insertTzTranscity(TzTranscity tzTranscity);

    /**
     * 修改tz_transcity
     * 
     * @param tzTranscity tz_transcity
     * @return 结果
     */
    public int updateTzTranscity(TzTranscity tzTranscity);

    /**
     * 删除tz_transcity
     * 
     * @param transcityId tz_transcity主键
     * @return 结果
     */
    public int deleteTzTranscityByTranscityId(Long transcityId);

    /**
     * 批量删除tz_transcity
     * 
     * @param transcityIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzTranscityByTranscityIds(Long[] transcityIds);
}
