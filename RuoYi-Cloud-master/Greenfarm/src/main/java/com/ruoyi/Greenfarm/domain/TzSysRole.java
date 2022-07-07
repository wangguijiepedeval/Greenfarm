package com.ruoyi.Greenfarm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 角色对象 tz_sys_role
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public class TzSysRole extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 序号 */
    private Long roleId;

    /** 角色名称 */
    @Excel(name = "角色名称")
    private String roleName;

    /** 创建者ID */
    @Excel(name = "创建者ID")
    private Long createUserId;

    public void setRoleId(Long roleId) 
    {
        this.roleId = roleId;
    }

    public Long getRoleId() 
    {
        return roleId;
    }
    public void setRoleName(String roleName) 
    {
        this.roleName = roleName;
    }

    public String getRoleName() 
    {
        return roleName;
    }
    public void setCreateUserId(Long createUserId) 
    {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId() 
    {
        return createUserId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("roleId", getRoleId())
            .append("roleName", getRoleName())
            .append("remark", getRemark())
            .append("createUserId", getCreateUserId())
            .append("createTime", getCreateTime())
            .toString();
    }
}
