package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzMessageMapper;
import com.ruoyi.Greenfarm.domain.TzMessage;
import com.ruoyi.Greenfarm.service.ITzMessageService;

/**
 * 个人消息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzMessageServiceImpl implements ITzMessageService 
{
    @Autowired
    private TzMessageMapper tzMessageMapper;

    /**
     * 查询个人消息
     * 
     * @param id 个人消息主键
     * @return 个人消息
     */
    @Override
    public TzMessage selectTzMessageById(Long id)
    {
        return tzMessageMapper.selectTzMessageById(id);
    }

    /**
     * 查询个人消息列表
     * 
     * @param tzMessage 个人消息
     * @return 个人消息
     */
    @Override
    public List<TzMessage> selectTzMessageList(TzMessage tzMessage)
    {
        return tzMessageMapper.selectTzMessageList(tzMessage);
    }

    /**
     * 新增个人消息
     * 
     * @param tzMessage 个人消息
     * @return 结果
     */
    @Override
    public int insertTzMessage(TzMessage tzMessage)
    {
        tzMessage.setCreateTime(DateUtils.getNowDate());
        return tzMessageMapper.insertTzMessage(tzMessage);
    }

    /**
     * 修改个人消息
     * 
     * @param tzMessage 个人消息
     * @return 结果
     */
    @Override
    public int updateTzMessage(TzMessage tzMessage)
    {
        return tzMessageMapper.updateTzMessage(tzMessage);
    }

    /**
     * 批量删除个人消息
     * 
     * @param ids 需要删除的个人消息主键
     * @return 结果
     */
    @Override
    public int deleteTzMessageByIds(Long[] ids)
    {
        return tzMessageMapper.deleteTzMessageByIds(ids);
    }

    /**
     * 删除个人消息信息
     * 
     * @param id 个人消息主键
     * @return 结果
     */
    @Override
    public int deleteTzMessageById(Long id)
    {
        return tzMessageMapper.deleteTzMessageById(id);
    }
}
