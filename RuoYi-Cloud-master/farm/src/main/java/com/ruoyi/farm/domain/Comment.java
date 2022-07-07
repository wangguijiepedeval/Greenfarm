package com.ruoyi.farm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * comment管理对象 comment
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public class Comment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String commentatorid;

    /** 标识位，0是农场评论，1是货物评论 */
    @Excel(name = "标识位，0是农场评论，1是货物评论")
    private Long type;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String farmid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String goodsid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String content;

    public void setCommentatorid(String commentatorid) 
    {
        this.commentatorid = commentatorid;
    }

    public String getCommentatorid() 
    {
        return commentatorid;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setFarmid(String farmid) 
    {
        this.farmid = farmid;
    }

    public String getFarmid() 
    {
        return farmid;
    }
    public void setGoodsid(String goodsid) 
    {
        this.goodsid = goodsid;
    }

    public String getGoodsid() 
    {
        return goodsid;
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
            .append("commentatorid", getCommentatorid())
            .append("type", getType())
            .append("farmid", getFarmid())
            .append("goodsid", getGoodsid())
            .append("content", getContent())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
