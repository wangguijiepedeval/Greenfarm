package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzSysUserRole;

/**
 * 用户与角色对应关系Service接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface ITzSysUserRoleService 
{
    /**
     * 查询用户与角色对应关系
     * 
     * @param id 用户与角色对应关系主键
     * @return 用户与角色对应关系
     */
    public TzSysUserRole selectTzSysUserRoleById(Long id);

    /**
     * 查询用户与角色对应关系列表
     * 
     * @param tzSysUserRole 用户与角色对应关系
     * @return 用户与角色对应关系集合
     */
    public List<TzSysUserRole> selectTzSysUserRoleList(TzSysUserRole tzSysUserRole);

    /**
     * 新增用户与角色对应关系
     * 
     * @param tzSysUserRole 用户与角色对应关系
     * @return 结果
     */
    public int insertTzSysUserRole(TzSysUserRole tzSysUserRole);

    /**
     * 修改用户与角色对应关系
     * 
     * @param tzSysUserRole 用户与角色对应关系
     * @return 结果
     */
    public int updateTzSysUserRole(TzSysUserRole tzSysUserRole);

    /**
     * 批量删除用户与角色对应关系
     * 
     * @param ids 需要删除的用户与角色对应关系主键集合
     * @return 结果
     */
    public int deleteTzSysUserRoleByIds(Long[] ids);

    /**
     * 删除用户与角色对应关系信息
     * 
     * @param id 用户与角色对应关系主键
     * @return 结果
     */
    public int deleteTzSysUserRoleById(Long id);
}
