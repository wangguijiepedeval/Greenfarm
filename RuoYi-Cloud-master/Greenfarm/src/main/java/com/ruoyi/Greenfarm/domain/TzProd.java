package com.ruoyi.Greenfarm.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 商品对象 tz_prod
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzProd extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 产品ID */
    private Long prodId;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String prodName;

    /** 店铺id */
    @Excel(name = "店铺id")
    private Long shopId;

    /** 原价 */
    @Excel(name = "原价")
    private BigDecimal oriPrice;

    /** 现价 */
    @Excel(name = "现价")
    private BigDecimal price;

    /** 简要描述,卖点等 */
    @Excel(name = "简要描述,卖点等")
    private String brief;

    /** 详细描述 */
    @Excel(name = "详细描述")
    private String content;

    /** 商品主图 */
    @Excel(name = "商品主图")
    private String pic;

    /** 商品图片，以,分割 */
    @Excel(name = "商品图片，以,分割")
    private String imgs;

    /** 默认是1，表示正常状态, -1表示删除, 0下架 */
    @Excel(name = "默认是1，表示正常状态, -1表示删除, 0下架")
    private Long status;

    /** 商品分类 */
    @Excel(name = "商品分类")
    private Long categoryId;

    /** 销量 */
    @Excel(name = "销量")
    private Long soldNum;

    /** 总库存 */
    @Excel(name = "总库存")
    private Long totalStocks;

    /** 配送方式json见TransportModeVO */
    @Excel(name = "配送方式json见TransportModeVO")
    private String deliveryMode;

    /** 运费模板id */
    @Excel(name = "运费模板id")
    private Long deliveryTemplateId;

    /** 上架时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上架时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date putawayTime;

    /** 版本 乐观锁 */
    @Excel(name = "版本 乐观锁")
    private Long version;

    public void setProdId(Long prodId) 
    {
        this.prodId = prodId;
    }

    public Long getProdId() 
    {
        return prodId;
    }
    public void setProdName(String prodName) 
    {
        this.prodName = prodName;
    }

    public String getProdName() 
    {
        return prodName;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setOriPrice(BigDecimal oriPrice) 
    {
        this.oriPrice = oriPrice;
    }

    public BigDecimal getOriPrice() 
    {
        return oriPrice;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setBrief(String brief) 
    {
        this.brief = brief;
    }

    public String getBrief() 
    {
        return brief;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setPic(String pic) 
    {
        this.pic = pic;
    }

    public String getPic() 
    {
        return pic;
    }
    public void setImgs(String imgs) 
    {
        this.imgs = imgs;
    }

    public String getImgs() 
    {
        return imgs;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }
    public void setSoldNum(Long soldNum) 
    {
        this.soldNum = soldNum;
    }

    public Long getSoldNum() 
    {
        return soldNum;
    }
    public void setTotalStocks(Long totalStocks) 
    {
        this.totalStocks = totalStocks;
    }

    public Long getTotalStocks() 
    {
        return totalStocks;
    }
    public void setDeliveryMode(String deliveryMode) 
    {
        this.deliveryMode = deliveryMode;
    }

    public String getDeliveryMode() 
    {
        return deliveryMode;
    }
    public void setDeliveryTemplateId(Long deliveryTemplateId) 
    {
        this.deliveryTemplateId = deliveryTemplateId;
    }

    public Long getDeliveryTemplateId() 
    {
        return deliveryTemplateId;
    }
    public void setPutawayTime(Date putawayTime) 
    {
        this.putawayTime = putawayTime;
    }

    public Date getPutawayTime() 
    {
        return putawayTime;
    }
    public void setVersion(Long version) 
    {
        this.version = version;
    }

    public Long getVersion() 
    {
        return version;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("prodId", getProdId())
            .append("prodName", getProdName())
            .append("shopId", getShopId())
            .append("oriPrice", getOriPrice())
            .append("price", getPrice())
            .append("brief", getBrief())
            .append("content", getContent())
            .append("pic", getPic())
            .append("imgs", getImgs())
            .append("status", getStatus())
            .append("categoryId", getCategoryId())
            .append("soldNum", getSoldNum())
            .append("totalStocks", getTotalStocks())
            .append("deliveryMode", getDeliveryMode())
            .append("deliveryTemplateId", getDeliveryTemplateId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("putawayTime", getPutawayTime())
            .append("version", getVersion())
            .toString();
    }
}
