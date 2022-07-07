package com.ruoyi.Greenfarm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 包邮信息对象 tz_transcity_free
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzTranscityFree extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 指定条件包邮城市项id */
    private Long transcityFreeId;

    /** 指定条件包邮项id */
    @Excel(name = "指定条件包邮项id")
    private Long transfeeFreeId;

    /** 城市id */
    @Excel(name = "城市id")
    private Long freeCityId;

    public void setTranscityFreeId(Long transcityFreeId) 
    {
        this.transcityFreeId = transcityFreeId;
    }

    public Long getTranscityFreeId() 
    {
        return transcityFreeId;
    }
    public void setTransfeeFreeId(Long transfeeFreeId) 
    {
        this.transfeeFreeId = transfeeFreeId;
    }

    public Long getTransfeeFreeId() 
    {
        return transfeeFreeId;
    }
    public void setFreeCityId(Long freeCityId) 
    {
        this.freeCityId = freeCityId;
    }

    public Long getFreeCityId() 
    {
        return freeCityId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("transcityFreeId", getTranscityFreeId())
            .append("transfeeFreeId", getTransfeeFreeId())
            .append("freeCityId", getFreeCityId())
            .toString();
    }
}
