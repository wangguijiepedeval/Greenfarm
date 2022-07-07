package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzSysUserMapper;
import com.ruoyi.Greenfarm.domain.TzSysUser;
import com.ruoyi.Greenfarm.service.ITzSysUserService;

/**
 * 系统用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class TzSysUserServiceImpl implements ITzSysUserService 
{
    @Autowired
    private TzSysUserMapper tzSysUserMapper;

    /**
     * 查询系统用户
     * 
     * @param userId 系统用户主键
     * @return 系统用户
     */
    @Override
    public TzSysUser selectTzSysUserByUserId(Long userId)
    {
        return tzSysUserMapper.selectTzSysUserByUserId(userId);
    }

    /**
     * 查询系统用户列表
     * 
     * @param tzSysUser 系统用户
     * @return 系统用户
     */
    @Override
    public List<TzSysUser> selectTzSysUserList(TzSysUser tzSysUser)
    {
        return tzSysUserMapper.selectTzSysUserList(tzSysUser);
    }

    /**
     * 新增系统用户
     * 
     * @param tzSysUser 系统用户
     * @return 结果
     */
    @Override
    public int insertTzSysUser(TzSysUser tzSysUser)
    {
        tzSysUser.setCreateTime(DateUtils.getNowDate());
        return tzSysUserMapper.insertTzSysUser(tzSysUser);
    }

    /**
     * 修改系统用户
     * 
     * @param tzSysUser 系统用户
     * @return 结果
     */
    @Override
    public int updateTzSysUser(TzSysUser tzSysUser)
    {
        return tzSysUserMapper.updateTzSysUser(tzSysUser);
    }

    /**
     * 批量删除系统用户
     * 
     * @param userIds 需要删除的系统用户主键
     * @return 结果
     */
    @Override
    public int deleteTzSysUserByUserIds(Long[] userIds)
    {
        return tzSysUserMapper.deleteTzSysUserByUserIds(userIds);
    }

    /**
     * 删除系统用户信息
     * 
     * @param userId 系统用户主键
     * @return 结果
     */
    @Override
    public int deleteTzSysUserByUserId(Long userId)
    {
        return tzSysUserMapper.deleteTzSysUserByUserId(userId);
    }
}
