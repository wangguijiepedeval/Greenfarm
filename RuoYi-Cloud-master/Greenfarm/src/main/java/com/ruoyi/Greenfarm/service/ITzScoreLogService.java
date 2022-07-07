package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzScoreLog;

/**
 * 用户积分管理Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzScoreLogService 
{
    /**
     * 查询用户积分管理
     * 
     * @param id 用户积分管理主键
     * @return 用户积分管理
     */
    public TzScoreLog selectTzScoreLogById(Long id);

    /**
     * 查询用户积分管理列表
     * 
     * @param tzScoreLog 用户积分管理
     * @return 用户积分管理集合
     */
    public List<TzScoreLog> selectTzScoreLogList(TzScoreLog tzScoreLog);

    /**
     * 新增用户积分管理
     * 
     * @param tzScoreLog 用户积分管理
     * @return 结果
     */
    public int insertTzScoreLog(TzScoreLog tzScoreLog);

    /**
     * 修改用户积分管理
     * 
     * @param tzScoreLog 用户积分管理
     * @return 结果
     */
    public int updateTzScoreLog(TzScoreLog tzScoreLog);

    /**
     * 批量删除用户积分管理
     * 
     * @param ids 需要删除的用户积分管理主键集合
     * @return 结果
     */
    public int deleteTzScoreLogByIds(Long[] ids);

    /**
     * 删除用户积分管理信息
     * 
     * @param id 用户积分管理主键
     * @return 结果
     */
    public int deleteTzScoreLogById(Long id);
}
