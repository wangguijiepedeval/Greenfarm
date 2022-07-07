package com.ruoyi.Greenfarm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 敏感字过滤对象 tz_sens_word
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzSensWord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long sensId;

    /** 敏感字 */
    @Excel(name = "敏感字")
    private String words;

    public void setSensId(Long sensId) 
    {
        this.sensId = sensId;
    }

    public Long getSensId() 
    {
        return sensId;
    }
    public void setWords(String words) 
    {
        this.words = words;
    }

    public String getWords() 
    {
        return words;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sensId", getSensId())
            .append("words", getWords())
            .toString();
    }
}
