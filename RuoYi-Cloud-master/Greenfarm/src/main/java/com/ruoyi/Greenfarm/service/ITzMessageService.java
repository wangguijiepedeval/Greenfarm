package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzMessage;

/**
 * 个人消息Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzMessageService 
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
     * 批量删除个人消息
     * 
     * @param ids 需要删除的个人消息主键集合
     * @return 结果
     */
    public int deleteTzMessageByIds(Long[] ids);

    /**
     * 删除个人消息信息
     * 
     * @param id 个人消息主键
     * @return 结果
     */
    public int deleteTzMessageById(Long id);
}
