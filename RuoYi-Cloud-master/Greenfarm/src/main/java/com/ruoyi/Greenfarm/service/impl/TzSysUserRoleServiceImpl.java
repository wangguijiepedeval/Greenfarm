package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzSysUserRoleMapper;
import com.ruoyi.Greenfarm.domain.TzSysUserRole;
import com.ruoyi.Greenfarm.service.ITzSysUserRoleService;

/**
 * 用户与角色对应关系Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class TzSysUserRoleServiceImpl implements ITzSysUserRoleService 
{
    @Autowired
    private TzSysUserRoleMapper tzSysUserRoleMapper;

    /**
     * 查询用户与角色对应关系
     * 
     * @param id 用户与角色对应关系主键
     * @return 用户与角色对应关系
     */
    @Override
    public TzSysUserRole selectTzSysUserRoleById(Long id)
    {
        return tzSysUserRoleMapper.selectTzSysUserRoleById(id);
    }

    /**
     * 查询用户与角色对应关系列表
     * 
     * @param tzSysUserRole 用户与角色对应关系
     * @return 用户与角色对应关系
     */
    @Override
    public List<TzSysUserRole> selectTzSysUserRoleList(TzSysUserRole tzSysUserRole)
    {
        return tzSysUserRoleMapper.selectTzSysUserRoleList(tzSysUserRole);
    }

    /**
     * 新增用户与角色对应关系
     * 
     * @param tzSysUserRole 用户与角色对应关系
     * @return 结果
     */
    @Override
    public int insertTzSysUserRole(TzSysUserRole tzSysUserRole)
    {
        return tzSysUserRoleMapper.insertTzSysUserRole(tzSysUserRole);
    }

    /**
     * 修改用户与角色对应关系
     * 
     * @param tzSysUserRole 用户与角色对应关系
     * @return 结果
     */
    @Override
    public int updateTzSysUserRole(TzSysUserRole tzSysUserRole)
    {
        return tzSysUserRoleMapper.updateTzSysUserRole(tzSysUserRole);
    }

    /**
     * 批量删除用户与角色对应关系
     * 
     * @param ids 需要删除的用户与角色对应关系主键
     * @return 结果
     */
    @Override
    public int deleteTzSysUserRoleByIds(Long[] ids)
    {
        return tzSysUserRoleMapper.deleteTzSysUserRoleByIds(ids);
    }

    /**
     * 删除用户与角色对应关系信息
     * 
     * @param id 用户与角色对应关系主键
     * @return 结果
     */
    @Override
    public int deleteTzSysUserRoleById(Long id)
    {
        return tzSysUserRoleMapper.deleteTzSysUserRoleById(id);
    }
}
