package com.ruoyi.Greenfarm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 购物车对象 tz_basket
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzBasket extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long basketId;

    /** 店铺ID */
    @Excel(name = "店铺ID")
    private Long shopId;

    /** 产品ID */
    @Excel(name = "产品ID")
    private Long prodId;

    /** SkuID */
    @Excel(name = "SkuID")
    private Long skuId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String userId;

    /** 购物车产品个数 */
    @Excel(name = "购物车产品个数")
    private Long basketCount;

    /** 购物时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "购物时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date basketDate;

    /** 满减活动ID */
    @Excel(name = "满减活动ID")
    private Long discountId;

    /** 分销推广人卡号 */
    @Excel(name = "分销推广人卡号")
    private String distributionCardNo;

    public void setBasketId(Long basketId) 
    {
        this.basketId = basketId;
    }

    public Long getBasketId() 
    {
        return basketId;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setProdId(Long prodId) 
    {
        this.prodId = prodId;
    }

    public Long getProdId() 
    {
        return prodId;
    }
    public void setSkuId(Long skuId) 
    {
        this.skuId = skuId;
    }

    public Long getSkuId() 
    {
        return skuId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setBasketCount(Long basketCount) 
    {
        this.basketCount = basketCount;
    }

    public Long getBasketCount() 
    {
        return basketCount;
    }
    public void setBasketDate(Date basketDate) 
    {
        this.basketDate = basketDate;
    }

    public Date getBasketDate() 
    {
        return basketDate;
    }
    public void setDiscountId(Long discountId) 
    {
        this.discountId = discountId;
    }

    public Long getDiscountId() 
    {
        return discountId;
    }
    public void setDistributionCardNo(String distributionCardNo) 
    {
        this.distributionCardNo = distributionCardNo;
    }

    public String getDistributionCardNo() 
    {
        return distributionCardNo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("basketId", getBasketId())
            .append("shopId", getShopId())
            .append("prodId", getProdId())
            .append("skuId", getSkuId())
            .append("userId", getUserId())
            .append("basketCount", getBasketCount())
            .append("basketDate", getBasketDate())
            .append("discountId", getDiscountId())
            .append("distributionCardNo", getDistributionCardNo())
            .toString();
    }
}
