package com.ruoyi.Greenfarm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 角色与菜单对应关系对象 tz_sys_role_menu
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public class TzSysRoleMenu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long id;

    /** 角色ID */
    @Excel(name = "角色ID")
    private Long roleId;

    /** 菜单ID */
    @Excel(name = "菜单ID")
    private Long menuId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRoleId(Long roleId) 
    {
        this.roleId = roleId;
    }

    public Long getRoleId() 
    {
        return roleId;
    }
    public void setMenuId(Long menuId) 
    {
        this.menuId = menuId;
    }

    public Long getMenuId() 
    {
        return menuId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("roleId", getRoleId())
            .append("menuId", getMenuId())
            .toString();
    }
}
