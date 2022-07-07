package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzSmsLogMapper;
import com.ruoyi.Greenfarm.domain.TzSmsLog;
import com.ruoyi.Greenfarm.service.ITzSmsLogService;

/**
 * 短信记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class TzSmsLogServiceImpl implements ITzSmsLogService 
{
    @Autowired
    private TzSmsLogMapper tzSmsLogMapper;

    /**
     * 查询短信记录
     * 
     * @param id 短信记录主键
     * @return 短信记录
     */
    @Override
    public TzSmsLog selectTzSmsLogById(Long id)
    {
        return tzSmsLogMapper.selectTzSmsLogById(id);
    }

    /**
     * 查询短信记录列表
     * 
     * @param tzSmsLog 短信记录
     * @return 短信记录
     */
    @Override
    public List<TzSmsLog> selectTzSmsLogList(TzSmsLog tzSmsLog)
    {
        return tzSmsLogMapper.selectTzSmsLogList(tzSmsLog);
    }

    /**
     * 新增短信记录
     * 
     * @param tzSmsLog 短信记录
     * @return 结果
     */
    @Override
    public int insertTzSmsLog(TzSmsLog tzSmsLog)
    {
        return tzSmsLogMapper.insertTzSmsLog(tzSmsLog);
    }

    /**
     * 修改短信记录
     * 
     * @param tzSmsLog 短信记录
     * @return 结果
     */
    @Override
    public int updateTzSmsLog(TzSmsLog tzSmsLog)
    {
        return tzSmsLogMapper.updateTzSmsLog(tzSmsLog);
    }

    /**
     * 批量删除短信记录
     * 
     * @param ids 需要删除的短信记录主键
     * @return 结果
     */
    @Override
    public int deleteTzSmsLogByIds(Long[] ids)
    {
        return tzSmsLogMapper.deleteTzSmsLogByIds(ids);
    }

    /**
     * 删除短信记录信息
     * 
     * @param id 短信记录主键
     * @return 结果
     */
    @Override
    public int deleteTzSmsLogById(Long id)
    {
        return tzSmsLogMapper.deleteTzSmsLogById(id);
    }
}
