package com.ruoyi.Greenfarm.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 订单对象 tz_order
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public class TzOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单ID */
    private Long orderId;

    /** 店铺id */
    @Excel(name = "店铺id")
    private Long shopId;

    /** 产品名称,多个产品将会以逗号隔开 */
    @Excel(name = "产品名称,多个产品将会以逗号隔开")
    private String prodName;

    /** 订购用户ID */
    @Excel(name = "订购用户ID")
    private String userId;

    /** 订购流水号 */
    @Excel(name = "订购流水号")
    private String orderNumber;

    /** 总值 */
    @Excel(name = "总值")
    private BigDecimal total;

    /** 实际总值 */
    @Excel(name = "实际总值")
    private BigDecimal actualTotal;

    /** 支付方式 0 手动代付 1 微信支付 2 支付宝 */
    @Excel(name = "支付方式 0 手动代付 1 微信支付 2 支付宝")
    private Long payType;

    /** 订单备注 */
    @Excel(name = "订单备注")
    private String remarks;

    /** 订单状态 1:待付款 2:待发货 3:待收货 4:待评价 5:成功 6:失败 */
    @Excel(name = "订单状态 1:待付款 2:待发货 3:待收货 4:待评价 5:成功 6:失败")
    private Long status;

    /** 配送类型 */
    @Excel(name = "配送类型")
    private String dvyType;

    /** 配送方式ID */
    @Excel(name = "配送方式ID")
    private Long dvyId;

    /** 物流单号 */
    @Excel(name = "物流单号")
    private String dvyFlowId;

    /** 订单运费 */
    @Excel(name = "订单运费")
    private BigDecimal freightAmount;

    /** 用户订单地址Id */
    @Excel(name = "用户订单地址Id")
    private Long addrOrderId;

    /** 订单商品总数 */
    @Excel(name = "订单商品总数")
    private Long productNums;

    /** 付款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "付款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date payTime;

    /** 发货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dvyTime;

    /** 完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date finallyTime;

    /** 取消时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "取消时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cancelTime;

    /** 是否已经支付，1：已经支付过，0：，没有支付过 */
    @Excel(name = "是否已经支付，1：已经支付过，0：，没有支付过")
    private Integer isPayed;

    /** 用户订单删除状态，0：没有删除， 1：回收站， 2：永久删除 */
    @Excel(name = "用户订单删除状态，0：没有删除， 1：回收站， 2：永久删除")
    private Long deleteStatus;

    /** 0:默认,1:在处理,2:处理完成 */
    @Excel(name = "0:默认,1:在处理,2:处理完成")
    private Long refundSts;

    /** 优惠总额 */
    @Excel(name = "优惠总额")
    private BigDecimal reduceAmount;

    /** 订单类型 */
    @Excel(name = "订单类型")
    private Integer orderType;

    /** 订单关闭原因 1-超时未支付 2-退款关闭 4-买家取消 15-已通过货到付款交易 */
    @Excel(name = "订单关闭原因 1-超时未支付 2-退款关闭 4-买家取消 15-已通过货到付款交易")
    private Integer closeType;

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setProdName(String prodName) 
    {
        this.prodName = prodName;
    }

    public String getProdName() 
    {
        return prodName;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setOrderNumber(String orderNumber) 
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() 
    {
        return orderNumber;
    }
    public void setTotal(BigDecimal total) 
    {
        this.total = total;
    }

    public BigDecimal getTotal() 
    {
        return total;
    }
    public void setActualTotal(BigDecimal actualTotal) 
    {
        this.actualTotal = actualTotal;
    }

    public BigDecimal getActualTotal() 
    {
        return actualTotal;
    }
    public void setPayType(Long payType) 
    {
        this.payType = payType;
    }

    public Long getPayType() 
    {
        return payType;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setDvyType(String dvyType) 
    {
        this.dvyType = dvyType;
    }

    public String getDvyType() 
    {
        return dvyType;
    }
    public void setDvyId(Long dvyId) 
    {
        this.dvyId = dvyId;
    }

    public Long getDvyId() 
    {
        return dvyId;
    }
    public void setDvyFlowId(String dvyFlowId) 
    {
        this.dvyFlowId = dvyFlowId;
    }

    public String getDvyFlowId() 
    {
        return dvyFlowId;
    }
    public void setFreightAmount(BigDecimal freightAmount) 
    {
        this.freightAmount = freightAmount;
    }

    public BigDecimal getFreightAmount() 
    {
        return freightAmount;
    }
    public void setAddrOrderId(Long addrOrderId) 
    {
        this.addrOrderId = addrOrderId;
    }

    public Long getAddrOrderId() 
    {
        return addrOrderId;
    }
    public void setProductNums(Long productNums) 
    {
        this.productNums = productNums;
    }

    public Long getProductNums() 
    {
        return productNums;
    }
    public void setPayTime(Date payTime) 
    {
        this.payTime = payTime;
    }

    public Date getPayTime() 
    {
        return payTime;
    }
    public void setDvyTime(Date dvyTime) 
    {
        this.dvyTime = dvyTime;
    }

    public Date getDvyTime() 
    {
        return dvyTime;
    }
    public void setFinallyTime(Date finallyTime) 
    {
        this.finallyTime = finallyTime;
    }

    public Date getFinallyTime() 
    {
        return finallyTime;
    }
    public void setCancelTime(Date cancelTime) 
    {
        this.cancelTime = cancelTime;
    }

    public Date getCancelTime() 
    {
        return cancelTime;
    }
    public void setIsPayed(Integer isPayed) 
    {
        this.isPayed = isPayed;
    }

    public Integer getIsPayed() 
    {
        return isPayed;
    }
    public void setDeleteStatus(Long deleteStatus) 
    {
        this.deleteStatus = deleteStatus;
    }

    public Long getDeleteStatus() 
    {
        return deleteStatus;
    }
    public void setRefundSts(Long refundSts) 
    {
        this.refundSts = refundSts;
    }

    public Long getRefundSts() 
    {
        return refundSts;
    }
    public void setReduceAmount(BigDecimal reduceAmount) 
    {
        this.reduceAmount = reduceAmount;
    }

    public BigDecimal getReduceAmount() 
    {
        return reduceAmount;
    }
    public void setOrderType(Integer orderType) 
    {
        this.orderType = orderType;
    }

    public Integer getOrderType() 
    {
        return orderType;
    }
    public void setCloseType(Integer closeType) 
    {
        this.closeType = closeType;
    }

    public Integer getCloseType() 
    {
        return closeType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("shopId", getShopId())
            .append("prodName", getProdName())
            .append("userId", getUserId())
            .append("orderNumber", getOrderNumber())
            .append("total", getTotal())
            .append("actualTotal", getActualTotal())
            .append("payType", getPayType())
            .append("remarks", getRemarks())
            .append("status", getStatus())
            .append("dvyType", getDvyType())
            .append("dvyId", getDvyId())
            .append("dvyFlowId", getDvyFlowId())
            .append("freightAmount", getFreightAmount())
            .append("addrOrderId", getAddrOrderId())
            .append("productNums", getProductNums())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("payTime", getPayTime())
            .append("dvyTime", getDvyTime())
            .append("finallyTime", getFinallyTime())
            .append("cancelTime", getCancelTime())
            .append("isPayed", getIsPayed())
            .append("deleteStatus", getDeleteStatus())
            .append("refundSts", getRefundSts())
            .append("reduceAmount", getReduceAmount())
            .append("orderType", getOrderType())
            .append("closeType", getCloseType())
            .toString();
    }
}
