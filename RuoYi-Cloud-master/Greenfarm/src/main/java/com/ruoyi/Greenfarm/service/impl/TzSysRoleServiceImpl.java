package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzSysRoleMapper;
import com.ruoyi.Greenfarm.domain.TzSysRole;
import com.ruoyi.Greenfarm.service.ITzSysRoleService;

/**
 * 角色Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class TzSysRoleServiceImpl implements ITzSysRoleService 
{
    @Autowired
    private TzSysRoleMapper tzSysRoleMapper;

    /**
     * 查询角色
     * 
     * @param roleId 角色主键
     * @return 角色
     */
    @Override
    public TzSysRole selectTzSysRoleByRoleId(Long roleId)
    {
        return tzSysRoleMapper.selectTzSysRoleByRoleId(roleId);
    }

    /**
     * 查询角色列表
     * 
     * @param tzSysRole 角色
     * @return 角色
     */
    @Override
    public List<TzSysRole> selectTzSysRoleList(TzSysRole tzSysRole)
    {
        return tzSysRoleMapper.selectTzSysRoleList(tzSysRole);
    }

    /**
     * 新增角色
     * 
     * @param tzSysRole 角色
     * @return 结果
     */
    @Override
    public int insertTzSysRole(TzSysRole tzSysRole)
    {
        tzSysRole.setCreateTime(DateUtils.getNowDate());
        return tzSysRoleMapper.insertTzSysRole(tzSysRole);
    }

    /**
     * 修改角色
     * 
     * @param tzSysRole 角色
     * @return 结果
     */
    @Override
    public int updateTzSysRole(TzSysRole tzSysRole)
    {
        return tzSysRoleMapper.updateTzSysRole(tzSysRole);
    }

    /**
     * 批量删除角色
     * 
     * @param roleIds 需要删除的角色主键
     * @return 结果
     */
    @Override
    public int deleteTzSysRoleByRoleIds(Long[] roleIds)
    {
        return tzSysRoleMapper.deleteTzSysRoleByRoleIds(roleIds);
    }

    /**
     * 删除角色信息
     * 
     * @param roleId 角色主键
     * @return 结果
     */
    @Override
    public int deleteTzSysRoleByRoleId(Long roleId)
    {
        return tzSysRoleMapper.deleteTzSysRoleByRoleId(roleId);
    }
}
