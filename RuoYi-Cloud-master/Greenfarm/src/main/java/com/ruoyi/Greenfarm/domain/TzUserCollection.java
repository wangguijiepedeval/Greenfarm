package com.ruoyi.Greenfarm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 用户收藏管理对象 tz_user_collection
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzUserCollection extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 收藏表 */
    private Long id;

    /** 商品id */
    @Excel(name = "商品id")
    private Long prodId;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setProdId(Long prodId) 
    {
        this.prodId = prodId;
    }

    public Long getProdId() 
    {
        return prodId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("prodId", getProdId())
            .append("userId", getUserId())
            .append("createTime", getCreateTime())
            .toString();
    }
}
