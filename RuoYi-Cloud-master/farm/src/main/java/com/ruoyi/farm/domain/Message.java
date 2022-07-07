package com.ruoyi.farm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * message管理对象 message
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public class Message extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long messageid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String senderid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String receiveid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String content;

    public void setMessageid(Long messageid) 
    {
        this.messageid = messageid;
    }

    public Long getMessageid() 
    {
        return messageid;
    }
    public void setSenderid(String senderid) 
    {
        this.senderid = senderid;
    }

    public String getSenderid() 
    {
        return senderid;
    }
    public void setReceiveid(String receiveid) 
    {
        this.receiveid = receiveid;
    }

    public String getReceiveid() 
    {
        return receiveid;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("messageid", getMessageid())
            .append("senderid", getSenderid())
            .append("receiveid", getReceiveid())
            .append("content", getContent())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
