package com.ruoyi.farm.service;

import java.util.List;
import com.ruoyi.farm.domain.Message;

/**
 * message管理Service接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface IMessageService 
{
    /**
     * 查询message管理
     * 
     * @param messageid message管理主键
     * @return message管理
     */
    public Message selectMessageByMessageid(Long messageid);

    /**
     * 查询message管理列表
     * 
     * @param message message管理
     * @return message管理集合
     */
    public List<Message> selectMessageList(Message message);

    /**
     * 新增message管理
     * 
     * @param message message管理
     * @return 结果
     */
    public int insertMessage(Message message);

    /**
     * 修改message管理
     * 
     * @param message message管理
     * @return 结果
     */
    public int updateMessage(Message message);

    /**
     * 批量删除message管理
     * 
     * @param messageids 需要删除的message管理主键集合
     * @return 结果
     */
    public int deleteMessageByMessageids(Long[] messageids);

    /**
     * 删除message管理信息
     * 
     * @param messageid message管理主键
     * @return 结果
     */
    public int deleteMessageByMessageid(Long messageid);
}
