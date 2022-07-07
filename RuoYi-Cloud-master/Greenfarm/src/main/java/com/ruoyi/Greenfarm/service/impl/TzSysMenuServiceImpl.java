package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzSysMenuMapper;
import com.ruoyi.Greenfarm.domain.TzSysMenu;
import com.ruoyi.Greenfarm.service.ITzSysMenuService;

/**
 * 菜单管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class TzSysMenuServiceImpl implements ITzSysMenuService 
{
    @Autowired
    private TzSysMenuMapper tzSysMenuMapper;

    /**
     * 查询菜单管理
     * 
     * @param menuId 菜单管理主键
     * @return 菜单管理
     */
    @Override
    public TzSysMenu selectTzSysMenuByMenuId(Long menuId)
    {
        return tzSysMenuMapper.selectTzSysMenuByMenuId(menuId);
    }

    /**
     * 查询菜单管理列表
     * 
     * @param tzSysMenu 菜单管理
     * @return 菜单管理
     */
    @Override
    public List<TzSysMenu> selectTzSysMenuList(TzSysMenu tzSysMenu)
    {
        return tzSysMenuMapper.selectTzSysMenuList(tzSysMenu);
    }

    /**
     * 新增菜单管理
     * 
     * @param tzSysMenu 菜单管理
     * @return 结果
     */
    @Override
    public int insertTzSysMenu(TzSysMenu tzSysMenu)
    {
        return tzSysMenuMapper.insertTzSysMenu(tzSysMenu);
    }

    /**
     * 修改菜单管理
     * 
     * @param tzSysMenu 菜单管理
     * @return 结果
     */
    @Override
    public int updateTzSysMenu(TzSysMenu tzSysMenu)
    {
        return tzSysMenuMapper.updateTzSysMenu(tzSysMenu);
    }

    /**
     * 批量删除菜单管理
     * 
     * @param menuIds 需要删除的菜单管理主键
     * @return 结果
     */
    @Override
    public int deleteTzSysMenuByMenuIds(Long[] menuIds)
    {
        return tzSysMenuMapper.deleteTzSysMenuByMenuIds(menuIds);
    }

    /**
     * 删除菜单管理信息
     * 
     * @param menuId 菜单管理主键
     * @return 结果
     */
    @Override
    public int deleteTzSysMenuByMenuId(Long menuId)
    {
        return tzSysMenuMapper.deleteTzSysMenuByMenuId(menuId);
    }
}
