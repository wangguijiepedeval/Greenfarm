package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzScoreLogMapper;
import com.ruoyi.Greenfarm.domain.TzScoreLog;
import com.ruoyi.Greenfarm.service.ITzScoreLogService;

/**
 * 用户积分管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzScoreLogServiceImpl implements ITzScoreLogService 
{
    @Autowired
    private TzScoreLogMapper tzScoreLogMapper;

    /**
     * 查询用户积分管理
     * 
     * @param id 用户积分管理主键
     * @return 用户积分管理
     */
    @Override
    public TzScoreLog selectTzScoreLogById(Long id)
    {
        return tzScoreLogMapper.selectTzScoreLogById(id);
    }

    /**
     * 查询用户积分管理列表
     * 
     * @param tzScoreLog 用户积分管理
     * @return 用户积分管理
     */
    @Override
    public List<TzScoreLog> selectTzScoreLogList(TzScoreLog tzScoreLog)
    {
        return tzScoreLogMapper.selectTzScoreLogList(tzScoreLog);
    }

    /**
     * 新增用户积分管理
     * 
     * @param tzScoreLog 用户积分管理
     * @return 结果
     */
    @Override
    public int insertTzScoreLog(TzScoreLog tzScoreLog)
    {
        tzScoreLog.setCreateTime(DateUtils.getNowDate());
        return tzScoreLogMapper.insertTzScoreLog(tzScoreLog);
    }

    /**
     * 修改用户积分管理
     * 
     * @param tzScoreLog 用户积分管理
     * @return 结果
     */
    @Override
    public int updateTzScoreLog(TzScoreLog tzScoreLog)
    {
        return tzScoreLogMapper.updateTzScoreLog(tzScoreLog);
    }

    /**
     * 批量删除用户积分管理
     * 
     * @param ids 需要删除的用户积分管理主键
     * @return 结果
     */
    @Override
    public int deleteTzScoreLogByIds(Long[] ids)
    {
        return tzScoreLogMapper.deleteTzScoreLogByIds(ids);
    }

    /**
     * 删除用户积分管理信息
     * 
     * @param id 用户积分管理主键
     * @return 结果
     */
    @Override
    public int deleteTzScoreLogById(Long id)
    {
        return tzScoreLogMapper.deleteTzScoreLogById(id);
    }
}
