package com.ruoyi.Greenfarm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 商品收藏对象 tz_prod_favorite
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzProdFavorite extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long favoriteId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long prodId;

    /** 收藏时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收藏时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recTime;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String userId;

    public void setFavoriteId(Long favoriteId) 
    {
        this.favoriteId = favoriteId;
    }

    public Long getFavoriteId() 
    {
        return favoriteId;
    }
    public void setProdId(Long prodId) 
    {
        this.prodId = prodId;
    }

    public Long getProdId() 
    {
        return prodId;
    }
    public void setRecTime(Date recTime) 
    {
        this.recTime = recTime;
    }

    public Date getRecTime() 
    {
        return recTime;
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
            .append("favoriteId", getFavoriteId())
            .append("prodId", getProdId())
            .append("recTime", getRecTime())
            .append("userId", getUserId())
            .toString();
    }
}
