package com.ruoyi.farm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * farm管理对象 farm
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public class Farm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String farmid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String farmname;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String farmphoto;

    /** 农场主 */
    @Excel(name = "农场主")
    private String merchantid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String farmaddress;

    /** 农场标识，0不可租，1可租 */
    @Excel(name = "农场标识，0不可租，1可租")
    private Long farmstatus;

    /** 租金 */
    @Excel(name = "租金")
    private Long rent;

    public void setFarmid(String farmid) 
    {
        this.farmid = farmid;
    }

    public String getFarmid() 
    {
        return farmid;
    }
    public void setFarmname(String farmname) 
    {
        this.farmname = farmname;
    }

    public String getFarmname() 
    {
        return farmname;
    }
    public void setFarmphoto(String farmphoto) 
    {
        this.farmphoto = farmphoto;
    }

    public String getFarmphoto() 
    {
        return farmphoto;
    }
    public void setMerchantid(String merchantid) 
    {
        this.merchantid = merchantid;
    }

    public String getMerchantid() 
    {
        return merchantid;
    }
    public void setFarmaddress(String farmaddress) 
    {
        this.farmaddress = farmaddress;
    }

    public String getFarmaddress() 
    {
        return farmaddress;
    }
    public void setFarmstatus(Long farmstatus) 
    {
        this.farmstatus = farmstatus;
    }

    public Long getFarmstatus() 
    {
        return farmstatus;
    }
    public void setRent(Long rent) 
    {
        this.rent = rent;
    }

    public Long getRent() 
    {
        return rent;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("farmid", getFarmid())
            .append("farmname", getFarmname())
            .append("farmphoto", getFarmphoto())
            .append("merchantid", getMerchantid())
            .append("farmaddress", getFarmaddress())
            .append("farmstatus", getFarmstatus())
            .append("rent", getRent())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
