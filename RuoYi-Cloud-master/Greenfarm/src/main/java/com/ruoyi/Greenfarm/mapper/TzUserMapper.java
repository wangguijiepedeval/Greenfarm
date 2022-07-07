package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzUser;

/**
 * 用户Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface TzUserMapper 
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
     * 删除用户
     * 
     * @param userId 用户主键
     * @return 结果
     */
    public int deleteTzUserByUserId(String userId);

    /**
     * 批量删除用户
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzUserByUserIds(String[] userIds);
}
