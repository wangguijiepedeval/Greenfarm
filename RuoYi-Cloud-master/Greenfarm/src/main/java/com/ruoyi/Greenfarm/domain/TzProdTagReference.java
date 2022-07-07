package com.ruoyi.Greenfarm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 店铺分组对象 tz_prod_tag_reference
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzProdTagReference extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 分组引用id */
    private Long referenceId;

    /** 店铺id */
    @Excel(name = "店铺id")
    private Long shopId;

    /** 标签id */
    @Excel(name = "标签id")
    private Long tagId;

    /** 商品id */
    @Excel(name = "商品id")
    private Long prodId;

    /** 状态(1:正常,0:删除) */
    @Excel(name = "状态(1:正常,0:删除)")
    private Integer status;

    public void setReferenceId(Long referenceId) 
    {
        this.referenceId = referenceId;
    }

    public Long getReferenceId() 
    {
        return referenceId;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setTagId(Long tagId) 
    {
        this.tagId = tagId;
    }

    public Long getTagId() 
    {
        return tagId;
    }
    public void setProdId(Long prodId) 
    {
        this.prodId = prodId;
    }

    public Long getProdId() 
    {
        return prodId;
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
            .append("referenceId", getReferenceId())
            .append("shopId", getShopId())
            .append("tagId", getTagId())
            .append("prodId", getProdId())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .toString();
    }
}
