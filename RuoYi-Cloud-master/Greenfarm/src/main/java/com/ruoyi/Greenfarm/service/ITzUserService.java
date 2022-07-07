package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzUser;

/**
 * 用户Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzUserService 
{
    /**
     * 查询用户
     * 
     * @param userId 用户主键
     * @return 用户
     */
    public TzUser selectTzUserByUserId(String userId);

    /**
     * 查询用户列表
     * 
     * @param tzUser 用户
     * @return 用户集合
     */
    public List<TzUser> selectTzUserList(TzUser tzUser);

    /**
     * 新增用户
     * 
     * @param tzUser 用户
     * @return 结果
     */
    public int insertTzUser(TzUser tzUser);

    /**
     * 修改用户
     * 
     * @param tzUser 用户
     * @return 结果
     */
    public int updateTzUser(TzUser tzUser);

    /**
     * 批量删除用户
     * 
     * @param userIds 需要删除的用户主键集合
     * @return 结果
     */
    public int deleteTzUserByUserIds(String[] userIds);

    /**
     * 删除用户信息
     * 
     * @param userId 用户主键
     * @return 结果
     */
    public int deleteTzUserByUserId(String userId);
}
