package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzSmsLog;

/**
 * 短信记录Service接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface ITzSmsLogService 
{
    /**
     * 查询短信记录
     * 
     * @param id 短信记录主键
     * @return 短信记录
     */
    public TzSmsLog selectTzSmsLogById(Long id);

    /**
     * 查询短信记录列表
     * 
     * @param tzSmsLog 短信记录
     * @return 短信记录集合
     */
    public List<TzSmsLog> selectTzSmsLogList(TzSmsLog tzSmsLog);

    /**
     * 新增短信记录
     * 
     * @param tzSmsLog 短信记录
     * @return 结果
     */
    public int insertTzSmsLog(TzSmsLog tzSmsLog);

    /**
     * 修改短信记录
     * 
     * @param tzSmsLog 短信记录
     * @return 结果
     */
    public int updateTzSmsLog(TzSmsLog tzSmsLog);

    /**
     * 批量删除短信记录
     * 
     * @param ids 需要删除的短信记录主键集合
     * @return 结果
     */
    public int deleteTzSmsLogByIds(Long[] ids);

    /**
     * 删除短信记录信息
     * 
     * @param id 短信记录主键
     * @return 结果
     */
    public int deleteTzSmsLogById(Long id);
}
