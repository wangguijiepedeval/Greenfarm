package com.ruoyi.Greenfarm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 物流公司对象 tz_delivery
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public class TzDelivery extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long dvyId;

    /** 物流公司名称 */
    @Excel(name = "物流公司名称")
    private String dvyName;

    /** 公司主页 */
    @Excel(name = "公司主页")
    private String companyHomeUrl;

    /** 建立时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "建立时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recTime;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    /** 物流查询接口 */
    @Excel(name = "物流查询接口")
    private String queryUrl;

    public void setDvyId(Long dvyId) 
    {
        this.dvyId = dvyId;
    }

    public Long getDvyId() 
    {
        return dvyId;
    }
    public void setDvyName(String dvyName) 
    {
        this.dvyName = dvyName;
    }

    public String getDvyName() 
    {
        return dvyName;
    }
    public void setCompanyHomeUrl(String companyHomeUrl) 
    {
        this.companyHomeUrl = companyHomeUrl;
    }

    public String getCompanyHomeUrl() 
    {
        return companyHomeUrl;
    }
    public void setRecTime(Date recTime) 
    {
        this.recTime = recTime;
    }

    public Date getRecTime() 
    {
        return recTime;
    }
    public void setModifyTime(Date modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() 
    {
        return modifyTime;
    }
    public void setQueryUrl(String queryUrl) 
    {
        this.queryUrl = queryUrl;
    }

    public String getQueryUrl() 
    {
        return queryUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("dvyId", getDvyId())
            .append("dvyName", getDvyName())
            .append("companyHomeUrl", getCompanyHomeUrl())
            .append("recTime", getRecTime())
            .append("modifyTime", getModifyTime())
            .append("queryUrl", getQueryUrl())
            .toString();
    }
}
