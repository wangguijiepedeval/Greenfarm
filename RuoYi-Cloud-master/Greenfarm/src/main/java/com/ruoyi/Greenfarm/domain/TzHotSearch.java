package com.ruoyi.Greenfarm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 热搜对象 tz_hot_search
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public class TzHotSearch extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long hotSearchId;

    /** 店铺ID 0为全局热搜 */
    @Excel(name = "店铺ID 0为全局热搜")
    private Long shopId;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 录入时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "录入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recDate;

    /** 顺序 */
    @Excel(name = "顺序")
    private Long seq;

    /** 状态 0下线 1上线 */
    @Excel(name = "状态 0下线 1上线")
    private Integer status;

    /** 热搜标题 */
    @Excel(name = "热搜标题")
    private String title;

    public void setHotSearchId(Long hotSearchId) 
    {
        this.hotSearchId = hotSearchId;
    }

    public Long getHotSearchId() 
    {
        return hotSearchId;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setRecDate(Date recDate) 
    {
        this.recDate = recDate;
    }

    public Date getRecDate() 
    {
        return recDate;
    }
    public void setSeq(Long seq) 
    {
        this.seq = seq;
    }

    public Long getSeq() 
    {
        return seq;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("hotSearchId", getHotSearchId())
            .append("shopId", getShopId())
            .append("content", getContent())
            .append("recDate", getRecDate())
            .append("seq", getSeq())
            .append("status", getStatus())
            .append("title", getTitle())
            .toString();
    }
}
