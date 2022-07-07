package com.ruoyi.Greenfarm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 短信记录对象 tz_sms_log
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public class TzSmsLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String userPhone;

    /** 短信内容 */
    @Excel(name = "短信内容")
    private String content;

    /** 手机验证码 */
    @Excel(name = "手机验证码")
    private String mobileCode;

    /** 短信类型  1:注册  2:验证 */
    @Excel(name = "短信类型  1:注册  2:验证")
    private Long type;

    /** 发送时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发送时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recDate;

    /** 发送短信返回码 */
    @Excel(name = "发送短信返回码")
    private String responseCode;

    /** 状态  1:有效  0：失效 */
    @Excel(name = "状态  1:有效  0：失效")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setUserPhone(String userPhone) 
    {
        this.userPhone = userPhone;
    }

    public String getUserPhone() 
    {
        return userPhone;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setMobileCode(String mobileCode) 
    {
        this.mobileCode = mobileCode;
    }

    public String getMobileCode() 
    {
        return mobileCode;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setRecDate(Date recDate) 
    {
        this.recDate = recDate;
    }

    public Date getRecDate() 
    {
        return recDate;
    }
    public void setResponseCode(String responseCode) 
    {
        this.responseCode = responseCode;
    }

    public String getResponseCode() 
    {
        return responseCode;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("userPhone", getUserPhone())
            .append("content", getContent())
            .append("mobileCode", getMobileCode())
            .append("type", getType())
            .append("recDate", getRecDate())
            .append("responseCode", getResponseCode())
            .append("status", getStatus())
            .toString();
    }
}
