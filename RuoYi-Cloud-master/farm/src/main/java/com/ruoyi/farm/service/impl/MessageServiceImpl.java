package com.ruoyi.farm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.farm.mapper.MessageMapper;
import com.ruoyi.farm.domain.Message;
import com.ruoyi.farm.service.IMessageService;

/**
 * message管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class MessageServiceImpl implements IMessageService 
{
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 查询message管理
     * 
     * @param messageid message管理主键
     * @return message管理
     */
    @Override
    public Message selectMessageByMessageid(Long messageid)
    {
        return messageMapper.selectMessageByMessageid(messageid);
    }

    /**
     * 查询message管理列表
     * 
     * @param message message管理
     * @return message管理
     */
    @Override
    public List<Message> selectMessageList(Message message)
    {
        return messageMapper.selectMessageList(message);
    }

    /**
     * 新增message管理
     * 
     * @param message message管理
     * @return 结果
     */
    @Override
    public int insertMessage(Message message)
    {
        message.setCreateTime(DateUtils.getNowDate());
        return messageMapper.insertMessage(message);
    }

    /**
     * 修改message管理
     * 
     * @param message message管理
     * @return 结果
     */
    @Override
    public int updateMessage(Message message)
    {
        message.setUpdateTime(DateUtils.getNowDate());
        return messageMapper.updateMessage(message);
    }

    /**
     * 批量删除message管理
     * 
     * @param messageids 需要删除的message管理主键
     * @return 结果
     */
    @Override
    public int deleteMessageByMessageids(Long[] messageids)
    {
        return messageMapper.deleteMessageByMessageids(messageids);
    }

    /**
     * 删除message管理信息
     * 
     * @param messageid message管理主键
     * @return 结果
     */
    @Override
    public int deleteMessageByMessageid(Long messageid)
    {
        return messageMapper.deleteMessageByMessageid(messageid);
    }
}
