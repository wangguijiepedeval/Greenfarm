package com.ruoyi.Greenfarm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * tz_transcity对象 tz_transcity
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public class TzTranscity extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long transcityId;

    /** 运费项id */
    @Excel(name = "运费项id")
    private Long transfeeId;

    /** 城市id */
    @Excel(name = "城市id")
    private Long cityId;

    public void setTranscityId(Long transcityId) 
    {
        this.transcityId = transcityId;
    }

    public Long getTranscityId() 
    {
        return transcityId;
    }
    public void setTransfeeId(Long transfeeId) 
    {
        this.transfeeId = transfeeId;
    }

    public Long getTransfeeId() 
    {
        return transfeeId;
    }
    public void setCityId(Long cityId) 
    {
        this.cityId = cityId;
    }

    public Long getCityId() 
    {
        return cityId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("transcityId", getTranscityId())
            .append("transfeeId", getTransfeeId())
            .append("cityId", getCityId())
            .toString();
    }
}
