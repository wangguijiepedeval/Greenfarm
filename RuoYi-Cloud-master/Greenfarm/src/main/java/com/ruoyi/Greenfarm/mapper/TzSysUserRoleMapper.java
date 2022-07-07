package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzSysUserRole;

/**
 * 用户与角色对应关系Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface TzSysUserRoleMapper 
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
     * 删除用户与角色对应关系
     * 
     * @param id 用户与角色对应关系主键
     * @return 结果
     */
    public int deleteTzSysUserRoleById(Long id);

    /**
     * 批量删除用户与角色对应关系
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzSysUserRoleByIds(Long[] ids);
}
