package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzSysRoleMenuMapper;
import com.ruoyi.Greenfarm.domain.TzSysRoleMenu;
import com.ruoyi.Greenfarm.service.ITzSysRoleMenuService;

/**
 * 角色与菜单对应关系Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class TzSysRoleMenuServiceImpl implements ITzSysRoleMenuService 
{
    @Autowired
    private TzSysRoleMenuMapper tzSysRoleMenuMapper;

    /**
     * 查询角色与菜单对应关系
     * 
     * @param id 角色与菜单对应关系主键
     * @return 角色与菜单对应关系
     */
    @Override
    public TzSysRoleMenu selectTzSysRoleMenuById(Long id)
    {
        return tzSysRoleMenuMapper.selectTzSysRoleMenuById(id);
    }

    /**
     * 查询角色与菜单对应关系列表
     * 
     * @param tzSysRoleMenu 角色与菜单对应关系
     * @return 角色与菜单对应关系
     */
    @Override
    public List<TzSysRoleMenu> selectTzSysRoleMenuList(TzSysRoleMenu tzSysRoleMenu)
    {
        return tzSysRoleMenuMapper.selectTzSysRoleMenuList(tzSysRoleMenu);
    }

    /**
     * 新增角色与菜单对应关系
     * 
     * @param tzSysRoleMenu 角色与菜单对应关系
     * @return 结果
     */
    @Override
    public int insertTzSysRoleMenu(TzSysRoleMenu tzSysRoleMenu)
    {
        return tzSysRoleMenuMapper.insertTzSysRoleMenu(tzSysRoleMenu);
    }

    /**
     * 修改角色与菜单对应关系
     * 
     * @param tzSysRoleMenu 角色与菜单对应关系
     * @return 结果
     */
    @Override
    public int updateTzSysRoleMenu(TzSysRoleMenu tzSysRoleMenu)
    {
        return tzSysRoleMenuMapper.updateTzSysRoleMenu(tzSysRoleMenu);
    }

    /**
     * 批量删除角色与菜单对应关系
     * 
     * @param ids 需要删除的角色与菜单对应关系主键
     * @return 结果
     */
    @Override
    public int deleteTzSysRoleMenuByIds(Long[] ids)
    {
        return tzSysRoleMenuMapper.deleteTzSysRoleMenuByIds(ids);
    }

    /**
     * 删除角色与菜单对应关系信息
     * 
     * @param id 角色与菜单对应关系主键
     * @return 结果
     */
    @Override
    public int deleteTzSysRoleMenuById(Long id)
    {
        return tzSysRoleMenuMapper.deleteTzSysRoleMenuById(id);
    }
}
