package com.ruoyi.Greenfarm.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 运费信息对象 tz_transfee_free
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzTransfeeFree extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 指定条件包邮项id */
    private Long transfeeFreeId;

    /** 运费模板id */
    @Excel(name = "运费模板id")
    private Long transportId;

    /** 包邮方式 （0 满x件/重量/体积包邮 1满金额包邮 2满x件/重量/体积且满金额包邮） */
    @Excel(name = "包邮方式 ", readConverterExp = "0=,满=x件/重量/体积包邮,1=满金额包邮,2=满x件/重量/体积且满金额包邮")
    private Integer freeType;

    /** 需满金额 */
    @Excel(name = "需满金额")
    private BigDecimal amount;

    /** 包邮x件/重量/体积 */
    @Excel(name = "包邮x件/重量/体积")
    private BigDecimal piece;

    public void setTransfeeFreeId(Long transfeeFreeId) 
    {
        this.transfeeFreeId = transfeeFreeId;
    }

    public Long getTransfeeFreeId() 
    {
        return transfeeFreeId;
    }
    public void setTransportId(Long transportId) 
    {
        this.transportId = transportId;
    }

    public Long getTransportId() 
    {
        return transportId;
    }
    public void setFreeType(Integer freeType) 
    {
        this.freeType = freeType;
    }

    public Integer getFreeType() 
    {
        return freeType;
    }
    public void setAmount(BigDecimal amount) 
    {
        this.amount = amount;
    }

    public BigDecimal getAmount() 
    {
        return amount;
    }
    public void setPiece(BigDecimal piece) 
    {
        this.piece = piece;
    }

    public BigDecimal getPiece() 
    {
        return piece;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("transfeeFreeId", getTransfeeFreeId())
            .append("transportId", getTransportId())
            .append("freeType", getFreeType())
            .append("amount", getAmount())
            .append("piece", getPiece())
            .toString();
    }
}
