package com.ruoyi.Greenfarm.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 支付信息对象 tz_order_settlement
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzOrderSettlement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 支付结算单据ID */
    private Long settlementId;

    /** 支付单号 */
    @Excel(name = "支付单号")
    private String payNo;

    /** 外部订单流水号 */
    @Excel(name = "外部订单流水号")
    private String bizPayNo;

    /** order表中的订单号 */
    @Excel(name = "order表中的订单号")
    private String orderNumber;

    /** 支付方式 1 微信支付 2 支付宝 */
    @Excel(name = "支付方式 1 微信支付 2 支付宝")
    private Long payType;

    /** 支付方式名称 */
    @Excel(name = "支付方式名称")
    private String payTypeName;

    /** 支付金额 */
    @Excel(name = "支付金额")
    private BigDecimal payAmount;

    /** 是否清算 0:否 1:是 */
    @Excel(name = "是否清算 0:否 1:是")
    private Long isClearing;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String userId;

    /** 清算时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "清算时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date clearingTime;

    /** 版本号 */
    @Excel(name = "版本号")
    private Long version;

    /** 支付状态 */
    @Excel(name = "支付状态")
    private Long payStatus;

    public void setSettlementId(Long settlementId) 
    {
        this.settlementId = settlementId;
    }

    public Long getSettlementId() 
    {
        return settlementId;
    }
    public void setPayNo(String payNo) 
    {
        this.payNo = payNo;
    }

    public String getPayNo() 
    {
        return payNo;
    }
    public void setBizPayNo(String bizPayNo) 
    {
        this.bizPayNo = bizPayNo;
    }

    public String getBizPayNo() 
    {
        return bizPayNo;
    }
    public void setOrderNumber(String orderNumber) 
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() 
    {
        return orderNumber;
    }
    public void setPayType(Long payType) 
    {
        this.payType = payType;
    }

    public Long getPayType() 
    {
        return payType;
    }
    public void setPayTypeName(String payTypeName) 
    {
        this.payTypeName = payTypeName;
    }

    public String getPayTypeName() 
    {
        return payTypeName;
    }
    public void setPayAmount(BigDecimal payAmount) 
    {
        this.payAmount = payAmount;
    }

    public BigDecimal getPayAmount() 
    {
        return payAmount;
    }
    public void setIsClearing(Long isClearing) 
    {
        this.isClearing = isClearing;
    }

    public Long getIsClearing() 
    {
        return isClearing;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setClearingTime(Date clearingTime) 
    {
        this.clearingTime = clearingTime;
    }

    public Date getClearingTime() 
    {
        return clearingTime;
    }
    public void setVersion(Long version) 
    {
        this.version = version;
    }

    public Long getVersion() 
    {
        return version;
    }
    public void setPayStatus(Long payStatus) 
    {
        this.payStatus = payStatus;
    }

    public Long getPayStatus() 
    {
        return payStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("settlementId", getSettlementId())
            .append("payNo", getPayNo())
            .append("bizPayNo", getBizPayNo())
            .append("orderNumber", getOrderNumber())
            .append("payType", getPayType())
            .append("payTypeName", getPayTypeName())
            .append("payAmount", getPayAmount())
            .append("isClearing", getIsClearing())
            .append("userId", getUserId())
            .append("createTime", getCreateTime())
            .append("clearingTime", getClearingTime())
            .append("version", getVersion())
            .append("payStatus", getPayStatus())
            .toString();
    }
}
