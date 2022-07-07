package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzSysMenu;

/**
 * 菜单管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface TzSysMenuMapper 
{
    /**
     * 查询菜单管理
     * 
     * @param menuId 菜单管理主键
     * @return 菜单管理
     */
    public TzSysMenu selectTzSysMenuByMenuId(Long menuId);

    /**
     * 查询菜单管理列表
     * 
     * @param tzSysMenu 菜单管理
     * @return 菜单管理集合
     */
    public List<TzSysMenu> selectTzSysMenuList(TzSysMenu tzSysMenu);

    /**
     * 新增菜单管理
     * 
     * @param tzSysMenu 菜单管理
     * @return 结果
     */
    public int insertTzSysMenu(TzSysMenu tzSysMenu);

    /**
     * 修改菜单管理
     * 
     * @param tzSysMenu 菜单管理
     * @return 结果
     */
    public int updateTzSysMenu(TzSysMenu tzSysMenu);

    /**
     * 删除菜单管理
     * 
     * @param menuId 菜单管理主键
     * @return 结果
     */
    public int deleteTzSysMenuByMenuId(Long menuId);

    /**
     * 批量删除菜单管理
     * 
     * @param menuIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzSysMenuByMenuIds(Long[] menuIds);
}
