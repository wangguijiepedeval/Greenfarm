package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzSysRole;

/**
 * 角色Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface TzSysRoleMapper 
{
    /**
     * 查询角色
     * 
     * @param roleId 角色主键
     * @return 角色
     */
    public TzSysRole selectTzSysRoleByRoleId(Long roleId);

    /**
     * 查询角色列表
     * 
     * @param tzSysRole 角色
     * @return 角色集合
     */
    public List<TzSysRole> selectTzSysRoleList(TzSysRole tzSysRole);

    /**
     * 新增角色
     * 
     * @param tzSysRole 角色
     * @return 结果
     */
    public int insertTzSysRole(TzSysRole tzSysRole);

    /**
     * 修改角色
     * 
     * @param tzSysRole 角色
     * @return 结果
     */
    public int updateTzSysRole(TzSysRole tzSysRole);

    /**
     * 删除角色
     * 
     * @param roleId 角色主键
     * @return 结果
     */
    public int deleteTzSysRoleByRoleId(Long roleId);

    /**
     * 批量删除角色
     * 
     * @param roleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzSysRoleByRoleIds(Long[] roleIds);
}
