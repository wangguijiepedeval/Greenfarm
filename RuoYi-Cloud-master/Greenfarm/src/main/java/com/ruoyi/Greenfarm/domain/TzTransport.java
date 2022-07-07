package com.ruoyi.Greenfarm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 订单详情对象 tz_transport
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzTransport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 运费模板id */
    private Long transportId;

    /** 运费模板名称 */
    @Excel(name = "运费模板名称")
    private String transName;

    /** 店铺id */
    @Excel(name = "店铺id")
    private Long shopId;

    /** 收费方式（0 按件数,1 按重量 2 按体积） */
    @Excel(name = "收费方式", readConverterExp = "0=,按=件数,1,按=重量,2=,按=体积")
    private Integer chargeType;

    /** 是否包邮 0:不包邮 1:包邮 */
    @Excel(name = "是否包邮 0:不包邮 1:包邮")
    private Integer isFreeFee;

    /** 是否含有包邮条件 0 否 1是 */
    @Excel(name = "是否含有包邮条件 0 否 1是")
    private Integer hasFreeCondition;

    public void setTransportId(Long transportId) 
    {
        this.transportId = transportId;
    }

    public Long getTransportId() 
    {
        return transportId;
    }
    public void setTransName(String transName) 
    {
        this.transName = transName;
    }

    public String getTransName() 
    {
        return transName;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setChargeType(Integer chargeType) 
    {
        this.chargeType = chargeType;
    }

    public Integer getChargeType() 
    {
        return chargeType;
    }
    public void setIsFreeFee(Integer isFreeFee) 
    {
        this.isFreeFee = isFreeFee;
    }

    public Integer getIsFreeFee() 
    {
        return isFreeFee;
    }
    public void setHasFreeCondition(Integer hasFreeCondition) 
    {
        this.hasFreeCondition = hasFreeCondition;
    }

    public Integer getHasFreeCondition() 
    {
        return hasFreeCondition;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("transportId", getTransportId())
            .append("transName", getTransName())
            .append("createTime", getCreateTime())
            .append("shopId", getShopId())
            .append("chargeType", getChargeType())
            .append("isFreeFee", getIsFreeFee())
            .append("hasFreeCondition", getHasFreeCondition())
            .toString();
    }
}
