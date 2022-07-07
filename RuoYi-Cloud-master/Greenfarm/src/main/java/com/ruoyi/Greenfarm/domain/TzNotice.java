package com.ruoyi.Greenfarm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 公告对象 tz_notice
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public class TzNotice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 公告id */
    private Long id;

    /** 店铺id */
    @Excel(name = "店铺id")
    private Long shopId;

    /** 公告标题 */
    @Excel(name = "公告标题")
    private String title;

    /** 公告内容 */
    @Excel(name = "公告内容")
    private String content;

    /** 状态(1:公布 0:撤回) */
    @Excel(name = "状态(1:公布 0:撤回)")
    private Integer status;

    /** 是否置顶 */
    @Excel(name = "是否置顶")
    private Integer isTop;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setIsTop(Integer isTop) 
    {
        this.isTop = isTop;
    }

    public Integer getIsTop() 
    {
        return isTop;
    }
    public void setPublishTime(Date publishTime) 
    {
        this.publishTime = publishTime;
    }

    public Date getPublishTime() 
    {
        return publishTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shopId", getShopId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("status", getStatus())
            .append("isTop", getIsTop())
            .append("publishTime", getPublishTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
