package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzMessage;

/**
 * 个人消息Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface TzMessageMapper 
{
    /**
     * 查询个人消息
     * 
     * @param id 个人消息主键
     * @return 个人消息
     */
    public TzMessage selectTzMessageById(Long id);

    /**
     * 查询个人消息列表
     * 
     * @param tzMessage 个人消息
     * @return 个人消息集合
     */
    public List<TzMessage> selectTzMessageList(TzMessage tzMessage);

    /**
     * 新增个人消息
     * 
     * @param tzMessage 个人消息
     * @return 结果
     */
    public int insertTzMessage(TzMessage tzMessage);

    /**
     * 修改个人消息
     * 
     * @param tzMessage 个人消息
     * @return 结果
     */
    public int updateTzMessage(TzMessage tzMessage);

    /**
     * 删除个人消息
     * 
     * @param id 个人消息主键
     * @return 结果
     */
    public int deleteTzMessageById(Long id);

    /**
     * 批量删除个人消息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzMessageByIds(Long[] ids);
}
