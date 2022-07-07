package com.ruoyi.Greenfarm.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 记录对象 tz_order_refund
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public class TzOrderRefund extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private Long refundId;

    /** 店铺ID */
    @Excel(name = "店铺ID")
    private Long shopId;

    /** 订单ID */
    @Excel(name = "订单ID")
    private Long orderId;

    /** 订单流水号 */
    @Excel(name = "订单流水号")
    private String orderNumber;

    /** 订单总金额 */
    @Excel(name = "订单总金额")
    private BigDecimal orderAmount;

    /** 订单项ID 全部退款是0 */
    @Excel(name = "订单项ID 全部退款是0")
    private Long orderItemId;

    /** 退款编号 */
    @Excel(name = "退款编号")
    private String refundSn;

    /** 订单支付流水号 */
    @Excel(name = "订单支付流水号")
    private String flowTradeNo;

    /** 第三方退款单号(微信退款单号) */
    @Excel(name = "第三方退款单号(微信退款单号)")
    private String outRefundNo;

    /** 订单支付方式 1 微信支付 2 支付宝 */
    @Excel(name = "订单支付方式 1 微信支付 2 支付宝")
    private Long payType;

    /** 订单支付名称 */
    @Excel(name = "订单支付名称")
    private String payTypeName;

    /** 买家ID */
    @Excel(name = "买家ID")
    private String userId;

    /** 退货数量 */
    @Excel(name = "退货数量")
    private Long goodsNum;

    /** 退款金额 */
    @Excel(name = "退款金额")
    private BigDecimal refundAmount;

    /** 申请类型:1,仅退款,2退款退货 */
    @Excel(name = "申请类型:1,仅退款,2退款退货")
    private Long applyType;

    /** 处理状态:1为待审核,2为同意,3为不同意 */
    @Excel(name = "处理状态:1为待审核,2为同意,3为不同意")
    private Long refundSts;

    /** 处理退款状态: 0:退款处理中 1:退款成功 -1:退款失败 */
    @Excel(name = "处理退款状态: 0:退款处理中 1:退款成功 -1:退款失败")
    private Long returnMoneySts;

    /** 申请时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "申请时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date applyTime;

    /** 卖家处理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "卖家处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date handelTime;

    /** 退款时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "退款时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date refundTime;

    /** 文件凭证json */
    @Excel(name = "文件凭证json")
    private String photoFiles;

    /** 申请原因 */
    @Excel(name = "申请原因")
    private String buyerMsg;

    /** 卖家备注 */
    @Excel(name = "卖家备注")
    private String sellerMsg;

    /** 物流公司名称 */
    @Excel(name = "物流公司名称")
    private String expressName;

    /** 物流单号 */
    @Excel(name = "物流单号")
    private String expressNo;

    /** 发货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date shipTime;

    /** 收货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receiveTime;

    /** 收货备注 */
    @Excel(name = "收货备注")
    private String receiveMessage;

    public void setRefundId(Long refundId) 
    {
        this.refundId = refundId;
    }

    public Long getRefundId() 
    {
        return refundId;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setOrderNumber(String orderNumber) 
    {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() 
    {
        return orderNumber;
    }
    public void setOrderAmount(BigDecimal orderAmount) 
    {
        this.orderAmount = orderAmount;
    }

    public BigDecimal getOrderAmount() 
    {
        return orderAmount;
    }
    public void setOrderItemId(Long orderItemId) 
    {
        this.orderItemId = orderItemId;
    }

    public Long getOrderItemId() 
    {
        return orderItemId;
    }
    public void setRefundSn(String refundSn) 
    {
        this.refundSn = refundSn;
    }

    public String getRefundSn() 
    {
        return refundSn;
    }
    public void setFlowTradeNo(String flowTradeNo) 
    {
        this.flowTradeNo = flowTradeNo;
    }

    public String getFlowTradeNo() 
    {
        return flowTradeNo;
    }
    public void setOutRefundNo(String outRefundNo) 
    {
        this.outRefundNo = outRefundNo;
    }

    public String getOutRefundNo() 
    {
        return outRefundNo;
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
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setGoodsNum(Long goodsNum) 
    {
        this.goodsNum = goodsNum;
    }

    public Long getGoodsNum() 
    {
        return goodsNum;
    }
    public void setRefundAmount(BigDecimal refundAmount) 
    {
        this.refundAmount = refundAmount;
    }

    public BigDecimal getRefundAmount() 
    {
        return refundAmount;
    }
    public void setApplyType(Long applyType) 
    {
        this.applyType = applyType;
    }

    public Long getApplyType() 
    {
        return applyType;
    }
    public void setRefundSts(Long refundSts) 
    {
        this.refundSts = refundSts;
    }

    public Long getRefundSts() 
    {
        return refundSts;
    }
    public void setReturnMoneySts(Long returnMoneySts) 
    {
        this.returnMoneySts = returnMoneySts;
    }

    public Long getReturnMoneySts() 
    {
        return returnMoneySts;
    }
    public void setApplyTime(Date applyTime) 
    {
        this.applyTime = applyTime;
    }

    public Date getApplyTime() 
    {
        return applyTime;
    }
    public void setHandelTime(Date handelTime) 
    {
        this.handelTime = handelTime;
    }

    public Date getHandelTime() 
    {
        return handelTime;
    }
    public void setRefundTime(Date refundTime) 
    {
        this.refundTime = refundTime;
    }

    public Date getRefundTime() 
    {
        return refundTime;
    }
    public void setPhotoFiles(String photoFiles) 
    {
        this.photoFiles = photoFiles;
    }

    public String getPhotoFiles() 
    {
        return photoFiles;
    }
    public void setBuyerMsg(String buyerMsg) 
    {
        this.buyerMsg = buyerMsg;
    }

    public String getBuyerMsg() 
    {
        return buyerMsg;
    }
    public void setSellerMsg(String sellerMsg) 
    {
        this.sellerMsg = sellerMsg;
    }

    public String getSellerMsg() 
    {
        return sellerMsg;
    }
    public void setExpressName(String expressName) 
    {
        this.expressName = expressName;
    }

    public String getExpressName() 
    {
        return expressName;
    }
    public void setExpressNo(String expressNo) 
    {
        this.expressNo = expressNo;
    }

    public String getExpressNo() 
    {
        return expressNo;
    }
    public void setShipTime(Date shipTime) 
    {
        this.shipTime = shipTime;
    }

    public Date getShipTime() 
    {
        return shipTime;
    }
    public void setReceiveTime(Date receiveTime) 
    {
        this.receiveTime = receiveTime;
    }

    public Date getReceiveTime() 
    {
        return receiveTime;
    }
    public void setReceiveMessage(String receiveMessage) 
    {
        this.receiveMessage = receiveMessage;
    }

    public String getReceiveMessage() 
    {
        return receiveMessage;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("refundId", getRefundId())
            .append("shopId", getShopId())
            .append("orderId", getOrderId())
            .append("orderNumber", getOrderNumber())
            .append("orderAmount", getOrderAmount())
            .append("orderItemId", getOrderItemId())
            .append("refundSn", getRefundSn())
            .append("flowTradeNo", getFlowTradeNo())
            .append("outRefundNo", getOutRefundNo())
            .append("payType", getPayType())
            .append("payTypeName", getPayTypeName())
            .append("userId", getUserId())
            .append("goodsNum", getGoodsNum())
            .append("refundAmount", getRefundAmount())
            .append("applyType", getApplyType())
            .append("refundSts", getRefundSts())
            .append("returnMoneySts", getReturnMoneySts())
            .append("applyTime", getApplyTime())
            .append("handelTime", getHandelTime())
            .append("refundTime", getRefundTime())
            .append("photoFiles", getPhotoFiles())
            .append("buyerMsg", getBuyerMsg())
            .append("sellerMsg", getSellerMsg())
            .append("expressName", getExpressName())
            .append("expressNo", getExpressNo())
            .append("shipTime", getShipTime())
            .append("receiveTime", getReceiveTime())
            .append("receiveMessage", getReceiveMessage())
            .toString();
    }
}
