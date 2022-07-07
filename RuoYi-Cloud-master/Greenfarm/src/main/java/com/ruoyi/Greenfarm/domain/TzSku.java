package com.ruoyi.Greenfarm.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 单品SKU对象 tz_sku
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public class TzSku extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 单品ID */
    private Long skuId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long prodId;

    /** 销售属性组合字符串 格式是p1:v1;p2:v2 */
    @Excel(name = "销售属性组合字符串 格式是p1:v1;p2:v2")
    private String properties;

    /** 原价 */
    @Excel(name = "原价")
    private BigDecimal oriPrice;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 商品在付款减库存的状态下，该sku上未付款的订单数量 */
    @Excel(name = "商品在付款减库存的状态下，该sku上未付款的订单数量")
    private Long stocks;

    /** 实际库存 */
    @Excel(name = "实际库存")
    private Long actualStocks;

    /** 记录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recTime;

    /** 商家编码 */
    @Excel(name = "商家编码")
    private String partyCode;

    /** 商品条形码 */
    @Excel(name = "商品条形码")
    private String modelId;

    /** sku图片 */
    @Excel(name = "sku图片")
    private String pic;

    /** sku名称 */
    @Excel(name = "sku名称")
    private String skuName;

    /** 商品名称 */
    @Excel(name = "商品名称")
    private String prodName;

    /** 版本号 */
    @Excel(name = "版本号")
    private Long version;

    /** 商品重量 */
    @Excel(name = "商品重量")
    private Long weight;

    /** 商品体积 */
    @Excel(name = "商品体积")
    private Long volume;

    /** 0 禁用 1 启用 */
    @Excel(name = "0 禁用 1 启用")
    private Integer status;

    /** 0 正常 1 已被删除 */
    @Excel(name = "0 正常 1 已被删除")
    private Integer isDelete;

    public void setSkuId(Long skuId) 
    {
        this.skuId = skuId;
    }

    public Long getSkuId() 
    {
        return skuId;
    }
    public void setProdId(Long prodId) 
    {
        this.prodId = prodId;
    }

    public Long getProdId() 
    {
        return prodId;
    }
    public void setProperties(String properties) 
    {
        this.properties = properties;
    }

    public String getProperties() 
    {
        return properties;
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
    public void setStocks(Long stocks) 
    {
        this.stocks = stocks;
    }

    public Long getStocks() 
    {
        return stocks;
    }
    public void setActualStocks(Long actualStocks) 
    {
        this.actualStocks = actualStocks;
    }

    public Long getActualStocks() 
    {
        return actualStocks;
    }
    public void setRecTime(Date recTime) 
    {
        this.recTime = recTime;
    }

    public Date getRecTime() 
    {
        return recTime;
    }
    public void setPartyCode(String partyCode) 
    {
        this.partyCode = partyCode;
    }

    public String getPartyCode() 
    {
        return partyCode;
    }
    public void setModelId(String modelId) 
    {
        this.modelId = modelId;
    }

    public String getModelId() 
    {
        return modelId;
    }
    public void setPic(String pic) 
    {
        this.pic = pic;
    }

    public String getPic() 
    {
        return pic;
    }
    public void setSkuName(String skuName) 
    {
        this.skuName = skuName;
    }

    public String getSkuName() 
    {
        return skuName;
    }
    public void setProdName(String prodName) 
    {
        this.prodName = prodName;
    }

    public String getProdName() 
    {
        return prodName;
    }
    public void setVersion(Long version) 
    {
        this.version = version;
    }

    public Long getVersion() 
    {
        return version;
    }
    public void setWeight(Long weight) 
    {
        this.weight = weight;
    }

    public Long getWeight() 
    {
        return weight;
    }
    public void setVolume(Long volume) 
    {
        this.volume = volume;
    }

    public Long getVolume() 
    {
        return volume;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setIsDelete(Integer isDelete) 
    {
        this.isDelete = isDelete;
    }

    public Integer getIsDelete() 
    {
        return isDelete;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("skuId", getSkuId())
            .append("prodId", getProdId())
            .append("properties", getProperties())
            .append("oriPrice", getOriPrice())
            .append("price", getPrice())
            .append("stocks", getStocks())
            .append("actualStocks", getActualStocks())
            .append("updateTime", getUpdateTime())
            .append("recTime", getRecTime())
            .append("partyCode", getPartyCode())
            .append("modelId", getModelId())
            .append("pic", getPic())
            .append("skuName", getSkuName())
            .append("prodName", getProdName())
            .append("version", getVersion())
            .append("weight", getWeight())
            .append("volume", getVolume())
            .append("status", getStatus())
            .append("isDelete", getIsDelete())
            .toString();
    }
}
