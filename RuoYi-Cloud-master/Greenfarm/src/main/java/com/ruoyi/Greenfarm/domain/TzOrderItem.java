package com.ruoyi.Greenfarm.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 订单项对象 tz_order_item
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public class TzOrderItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单项ID */
    private Long orderItemId;

    /** 店铺id */
    @Excel(name = "店铺id")
    private Long shopId;

    /** 订单order_number */
    @Excel(name = "订单order_number")
    private String orderNumber;

    /** 产品ID */
    @Excel(name = "产品ID")
    private Long prodId;

    /** 产品SkuID */
    @Excel(name = "产品SkuID")
    private Long skuId;

    /** 购物车产品个数 */
    @Excel(name = "购物车产品个数")
    private Long prodCount;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String prodName;

    /** sku名称 */
    @Excel(name = "sku名称")
    private String skuName;

    /** 产品主图片路径 */
    @Excel(name = "产品主图片路径")
    private String pic;

    /** 产品价格 */
    @Excel(name = "产品价格")
    private BigDecimal price;

    /** 用户Id */
    @Excel(name = "用户Id")
    private String userId;

    /** 商品总金额 */
    @Excel(name = "商品总金额")
    private BigDecimal productTotalAmount;

    /** 购物时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "购物时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recTime;

    /** 评论状态： 0 未评价  1 已评价 */
    @Excel(name = "评论状态： 0 未评价  1 已评价")
    private Long commSts;

    /** 推广员使用的推销卡号 */
    @Excel(name = "推广员使用的推销卡号")
    private String distributionCardNo;

    /** 加入购物车时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "加入购物车时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date basketDate;

    public void setOrderItemId(Long orderItemId) 
    {
        this.orderItemId = orderItemId;
    }

    public Long getOrderItemId() 
    {
        return orderItemId;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setOrderNumber(String orderNumber) 
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() 
    {
        return orderNumber;
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
    public void setProdCount(Long prodCount) 
    {
        this.prodCount = prodCount;
    }

    public Long getProdCount() 
    {
        return prodCount;
    }
    public void setProdName(String prodName) 
    {
        this.prodName = prodName;
    }

    public String getProdName() 
    {
        return prodName;
    }
    public void setSkuName(String skuName) 
    {
        this.skuName = skuName;
    }

    public String getSkuName() 
    {
        return skuName;
    }
    public void setPic(String pic) 
    {
        this.pic = pic;
    }

    public String getPic() 
    {
        return pic;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setProductTotalAmount(BigDecimal productTotalAmount) 
    {
        this.productTotalAmount = productTotalAmount;
    }

    public BigDecimal getProductTotalAmount() 
    {
        return productTotalAmount;
    }
    public void setRecTime(Date recTime) 
    {
        this.recTime = recTime;
    }

    public Date getRecTime() 
    {
        return recTime;
    }
    public void setCommSts(Long commSts) 
    {
        this.commSts = commSts;
    }

    public Long getCommSts() 
    {
        return commSts;
    }
    public void setDistributionCardNo(String distributionCardNo) 
    {
        this.distributionCardNo = distributionCardNo;
    }

    public String getDistributionCardNo() 
    {
        return distributionCardNo;
    }
    public void setBasketDate(Date basketDate) 
    {
        this.basketDate = basketDate;
    }

    public Date getBasketDate() 
    {
        return basketDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderItemId", getOrderItemId())
            .append("shopId", getShopId())
            .append("orderNumber", getOrderNumber())
            .append("prodId", getProdId())
            .append("skuId", getSkuId())
            .append("prodCount", getProdCount())
            .append("prodName", getProdName())
            .append("skuName", getSkuName())
            .append("pic", getPic())
            .append("price", getPrice())
            .append("userId", getUserId())
            .append("productTotalAmount", getProductTotalAmount())
            .append("recTime", getRecTime())
            .append("commSts", getCommSts())
            .append("distributionCardNo", getDistributionCardNo())
            .append("basketDate", getBasketDate())
            .toString();
    }
}
