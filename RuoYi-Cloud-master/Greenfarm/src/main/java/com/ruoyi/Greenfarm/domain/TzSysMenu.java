package com.ruoyi.Greenfarm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 菜单管理对象 tz_sys_menu
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public class TzSysMenu extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long menuId;

    /** 父菜单ID，一级菜单为0 */
    @Excel(name = "父菜单ID，一级菜单为0")
    private Long parentId;

    /** 菜单名称 */
    @Excel(name = "菜单名称")
    private String name;

    /** 菜单URL */
    @Excel(name = "菜单URL")
    private String url;

    /** 授权(多个用逗号分隔，如：user:list,user:create) */
    @Excel(name = "授权(多个用逗号分隔，如：user:list,user:create)")
    private String perms;

    /** 类型   0：目录   1：菜单   2：按钮 */
    @Excel(name = "类型   0：目录   1：菜单   2：按钮")
    private Long type;

    /** 菜单图标 */
    @Excel(name = "菜单图标")
    private String icon;

    /** 排序 */
    @Excel(name = "排序")
    private Long orderNum;

    public void setMenuId(Long menuId) 
    {
        this.menuId = menuId;
    }

    public Long getMenuId() 
    {
        return menuId;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setPerms(String perms) 
    {
        this.perms = perms;
    }

    public String getPerms() 
    {
        return perms;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setIcon(String icon) 
    {
        this.icon = icon;
    }

    public String getIcon() 
    {
        return icon;
    }
    public void setOrderNum(Long orderNum) 
    {
        this.orderNum = orderNum;
    }

    public Long getOrderNum() 
    {
        return orderNum;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("menuId", getMenuId())
            .append("parentId", getParentId())
            .append("name", getName())
            .append("url", getUrl())
            .append("perms", getPerms())
            .append("type", getType())
            .append("icon", getIcon())
            .append("orderNum", getOrderNum())
            .toString();
    }
}
