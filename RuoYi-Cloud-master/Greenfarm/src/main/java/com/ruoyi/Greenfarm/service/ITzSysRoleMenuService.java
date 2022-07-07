package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzSysRoleMenu;

/**
 * 角色与菜单对应关系Service接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface ITzSysRoleMenuService 
{
    /**
     * 查询角色与菜单对应关系
     * 
     * @param id 角色与菜单对应关系主键
     * @return 角色与菜单对应关系
     */
    public TzSysRoleMenu selectTzSysRoleMenuById(Long id);

    /**
     * 查询角色与菜单对应关系列表
     * 
     * @param tzSysRoleMenu 角色与菜单对应关系
     * @return 角色与菜单对应关系集合
     */
    public List<TzSysRoleMenu> selectTzSysRoleMenuList(TzSysRoleMenu tzSysRoleMenu);

    /**
     * 新增角色与菜单对应关系
     * 
     * @param tzSysRoleMenu 角色与菜单对应关系
     * @return 结果
     */
    public int insertTzSysRoleMenu(TzSysRoleMenu tzSysRoleMenu);

    /**
     * 修改角色与菜单对应关系
     * 
     * @param tzSysRoleMenu 角色与菜单对应关系
     * @return 结果
     */
    public int updateTzSysRoleMenu(TzSysRoleMenu tzSysRoleMenu);

    /**
     * 批量删除角色与菜单对应关系
     * 
     * @param ids 需要删除的角色与菜单对应关系主键集合
     * @return 结果
     */
    public int deleteTzSysRoleMenuByIds(Long[] ids);

    /**
     * 删除角色与菜单对应关系信息
     * 
     * @param id 角色与菜单对应关系主键
     * @return 结果
     */
    public int deleteTzSysRoleMenuById(Long id);
}