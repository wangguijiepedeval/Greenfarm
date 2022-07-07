package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzSysUser;

/**
 * 系统用户Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface TzSysUserMapper 
{
    /**
     * 查询系统用户
     * 
     * @param userId 系统用户主键
     * @return 系统用户
     */
    public TzSysUser selectTzSysUserByUserId(Long userId);

    /**
     * 查询系统用户列表
     * 
     * @param tzSysUser 系统用户
     * @return 系统用户集合
     */
    public List<TzSysUser> selectTzSysUserList(TzSysUser tzSysUser);

    /**
     * 新增系统用户
     * 
     * @param tzSysUser 系统用户
     * @return 结果
     */
    public int insertTzSysUser(TzSysUser tzSysUser);

    /**
     * 修改系统用户
     * 
     * @param tzSysUser 系统用户
     * @return 结果
     */
    public int updateTzSysUser(TzSysUser tzSysUser);

    /**
     * 删除系统用户
     * 
     * @param userId 系统用户主键
     * @return 结果
     */
    public int deleteTzSysUserByUserId(Long userId);

    /**
     * 批量删除系统用户
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzSysUserByUserIds(Long[] userIds);
}
