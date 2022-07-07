package com.ruoyi.Greenfarm.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 运费信息对象 tz_transfee
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzTransfee extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 运费项id */
    private Long transfeeId;

    /** 运费模板id */
    @Excel(name = "运费模板id")
    private Long transportId;

    /** 续件数量 */
    @Excel(name = "续件数量")
    private BigDecimal continuousPiece;

    /** 首件数量 */
    @Excel(name = "首件数量")
    private BigDecimal firstPiece;

    /** 续件费用 */
    @Excel(name = "续件费用")
    private BigDecimal continuousFee;

    /** 首件费用 */
    @Excel(name = "首件费用")
    private BigDecimal firstFee;

    public void setTransfeeId(Long transfeeId) 
    {
        this.transfeeId = transfeeId;
    }

    public Long getTransfeeId() 
    {
        return transfeeId;
    }
    public void setTransportId(Long transportId) 
    {
        this.transportId = transportId;
    }

    public Long getTransportId() 
    {
        return transportId;
    }
    public void setContinuousPiece(BigDecimal continuousPiece) 
    {
        this.continuousPiece = continuousPiece;
    }

    public BigDecimal getContinuousPiece() 
    {
        return continuousPiece;
    }
    public void setFirstPiece(BigDecimal firstPiece) 
    {
        this.firstPiece = firstPiece;
    }

    public BigDecimal getFirstPiece() 
    {
        return firstPiece;
    }
    public void setContinuousFee(BigDecimal continuousFee) 
    {
        this.continuousFee = continuousFee;
    }

    public BigDecimal getContinuousFee() 
    {
        return continuousFee;
    }
    public void setFirstFee(BigDecimal firstFee) 
    {
        this.firstFee = firstFee;
    }

    public BigDecimal getFirstFee() 
    {
        return firstFee;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("transfeeId", getTransfeeId())
            .append("transportId", getTransportId())
            .append("continuousPiece", getContinuousPiece())
            .append("firstPiece", getFirstPiece())
            .append("continuousFee", getContinuousFee())
            .append("firstFee", getFirstFee())
            .toString();
    }
}
