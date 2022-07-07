package com.ruoyi.Greenfarm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 个人消息对象 tz_message
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzMessage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 姓名 */
    @Excel(name = "姓名")
    private String userName;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String contact;

    /** 留言内容 */
    @Excel(name = "留言内容")
    private String content;

    /** 留言回复 */
    @Excel(name = "留言回复")
    private String reply;

    /** 状态：0:未审核 1审核通过 */
    @Excel(name = "状态：0:未审核 1审核通过")
    private Integer status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setContact(String contact) 
    {
        this.contact = contact;
    }

    public String getContact() 
    {
        return contact;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setReply(String reply) 
    {
        this.reply = reply;
    }

    public String getReply() 
    {
        return reply;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("createTime", getCreateTime())
            .append("userName", getUserName())
            .append("email", getEmail())
            .append("contact", getContact())
            .append("content", getContent())
            .append("reply", getReply())
            .append("status", getStatus())
            .toString();
    }
}
