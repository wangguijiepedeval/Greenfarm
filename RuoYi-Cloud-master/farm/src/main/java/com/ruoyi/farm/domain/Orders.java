package com.ruoyi.farm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * orders管理对象 orders
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public class Orders extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String orderid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String customerid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String goodsid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String shippingaddress;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long price;

    /** 标识位，0发货，1没发货 */
    @Excel(name = "标识位，0发货，1没发货")
    private Long orderstatus;

    public void setOrderid(String orderid) 
    {
        this.orderid = orderid;
    }

    public String getOrderid() 
    {
        return orderid;
    }
    public void setCustomerid(String customerid) 
    {
        this.customerid = customerid;
    }

    public String getCustomerid() 
    {
        return customerid;
    }
    public void setGoodsid(String goodsid) 
    {
        this.goodsid = goodsid;
    }

    public String getGoodsid() 
    {
        return goodsid;
    }
    public void setShippingaddress(String shippingaddress) 
    {
        this.shippingaddress = shippingaddress;
    }

    public String getShippingaddress() 
    {
        return shippingaddress;
    }
    public void setPrice(Long price) 
    {
        this.price = price;
    }

    public Long getPrice() 
    {
        return price;
    }
    public void setOrderstatus(Long orderstatus) 
    {
        this.orderstatus = orderstatus;
    }

    public Long getOrderstatus() 
    {
        return orderstatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderid", getOrderid())
            .append("customerid", getCustomerid())
            .append("goodsid", getGoodsid())
            .append("shippingaddress", getShippingaddress())
            .append("price", getPrice())
            .append("orderstatus", getOrderstatus())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
