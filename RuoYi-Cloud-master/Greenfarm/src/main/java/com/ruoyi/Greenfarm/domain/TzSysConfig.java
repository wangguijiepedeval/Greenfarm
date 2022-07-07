package com.ruoyi.Greenfarm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 系统配置信息对象 tz_sys_config
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public class TzSysConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** key */
    @Excel(name = "key")
    private String paramKey;

    /** value */
    @Excel(name = "value")
    private String paramValue;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setParamKey(String paramKey) 
    {
        this.paramKey = paramKey;
    }

    public String getParamKey() 
    {
        return paramKey;
    }
    public void setParamValue(String paramValue) 
    {
        this.paramValue = paramValue;
    }

    public String getParamValue() 
    {
        return paramValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("paramKey", getParamKey())
            .append("paramValue", getParamValue())
            .append("remark", getRemark())
            .toString();
    }
}
