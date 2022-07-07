package com.ruoyi.Greenfarm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 商品分组对象 tz_prod_tag
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzProdTag extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 分组标签id */
    private Long id;

    /** 分组标题 */
    @Excel(name = "分组标题")
    private String title;

    /** 店铺Id */
    @Excel(name = "店铺Id")
    private Long shopId;

    /** 状态(1为正常,0为删除) */
    @Excel(name = "状态(1为正常,0为删除)")
    private Integer status;

    /** 默认类型(0:商家自定义,1:系统默认) */
    @Excel(name = "默认类型(0:商家自定义,1:系统默认)")
    private Integer isDefault;

    /** 商品数量 */
    @Excel(name = "商品数量")
    private Long prodCount;

    /** 列表样式(0:一列一个,1:一列两个,2:一列三个) */
    @Excel(name = "列表样式(0:一列一个,1:一列两个,2:一列三个)")
    private Long style;

    /** 排序 */
    @Excel(name = "排序")
    private Long seq;

    /** 删除时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "删除时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date deleteTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setIsDefault(Integer isDefault) 
    {
        this.isDefault = isDefault;
    }

    public Integer getIsDefault() 
    {
        return isDefault;
    }
    public void setProdCount(Long prodCount) 
    {
        this.prodCount = prodCount;
    }

    public Long getProdCount() 
    {
        return prodCount;
    }
    public void setStyle(Long style) 
    {
        this.style = style;
    }

    public Long getStyle() 
    {
        return style;
    }
    public void setSeq(Long seq) 
    {
        this.seq = seq;
    }

    public Long getSeq() 
    {
        return seq;
    }
    public void setDeleteTime(Date deleteTime) 
    {
        this.deleteTime = deleteTime;
    }

    public Date getDeleteTime() 
    {
        return deleteTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("shopId", getShopId())
            .append("status", getStatus())
            .append("isDefault", getIsDefault())
            .append("prodCount", getProdCount())
            .append("style", getStyle())
            .append("seq", getSeq())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("deleteTime", getDeleteTime())
            .toString();
    }
}
