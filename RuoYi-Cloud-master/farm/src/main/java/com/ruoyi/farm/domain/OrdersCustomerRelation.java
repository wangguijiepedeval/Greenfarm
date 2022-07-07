package com.ruoyi.farm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * orders_customer_relation管理对象 orders_customer_relation
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public class OrdersCustomerRelation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String ordersid;

    /** $column.columnComment */
    private String customerid;

    public void setOrdersid(String ordersid) 
    {
        this.ordersid = ordersid;
    }

    public String getOrdersid() 
    {
        return ordersid;
    }
    public void setCustomerid(String customerid) 
    {
        this.customerid = customerid;
    }

    public String getCustomerid() 
    {
        return customerid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ordersid", getOrdersid())
            .append("customerid", getCustomerid())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
