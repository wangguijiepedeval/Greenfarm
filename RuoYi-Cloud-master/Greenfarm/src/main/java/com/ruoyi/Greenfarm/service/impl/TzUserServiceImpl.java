package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzUserMapper;
import com.ruoyi.Greenfarm.domain.TzUser;
import com.ruoyi.Greenfarm.service.ITzUserService;

/**
 * 用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzUserServiceImpl implements ITzUserService 
{
    @Autowired
    private TzUserMapper tzUserMapper;

    /**
     * 查询用户
     * 
     * @param userId 用户主键
     * @return 用户
     */
    @Override
    public TzUser selectTzUserByUserId(String userId)
    {
        return tzUserMapper.selectTzUserByUserId(userId);
    }

    /**
     * 查询用户列表
     * 
     * @param tzUser 用户
     * @return 用户
     */
    @Override
    public List<TzUser> selectTzUserList(TzUser tzUser)
    {
        return tzUserMapper.selectTzUserList(tzUser);
    }

    /**
     * 新增用户
     * 
     * @param tzUser 用户
     * @return 结果
     */
    @Override
    public int insertTzUser(TzUser tzUser)
    {
        return tzUserMapper.insertTzUser(tzUser);
    }

    /**
     * 修改用户
     * 
     * @param tzUser 用户
     * @return 结果
     */
    @Override
    public int updateTzUser(TzUser tzUser)
    {
        return tzUserMapper.updateTzUser(tzUser);
    }

    /**
     * 批量删除用户
     * 
     * @param userIds 需要删除的用户主键
     * @return 结果
     */
    @Override
    public int deleteTzUserByUserIds(String[] userIds)
    {
        return tzUserMapper.deleteTzUserByUserIds(userIds);
    }

    /**
     * 删除用户信息
     * 
     * @param userId 用户主键
     * @return 结果
     */
    @Override
    public int deleteTzUserByUserId(String userId)
    {
        return tzUserMapper.deleteTzUserByUserId(userId);
    }
}
