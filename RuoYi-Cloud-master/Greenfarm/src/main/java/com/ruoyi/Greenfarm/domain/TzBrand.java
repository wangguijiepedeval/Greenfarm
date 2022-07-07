package com.ruoyi.Greenfarm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 品牌对象 tz_brand
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzBrand extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long brandId;

    /** 品牌名称 */
    @Excel(name = "品牌名称")
    private String brandName;

    /** 图片路径 */
    @Excel(name = "图片路径")
    private String brandPic;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String userId;

    /** 备注 */
    @Excel(name = "备注")
    private String memo;

    /** 顺序 */
    @Excel(name = "顺序")
    private Long seq;

    /** 默认是1，表示正常状态,0为下线状态 */
    @Excel(name = "默认是1，表示正常状态,0为下线状态")
    private Long status;

    /** 简要描述 */
    @Excel(name = "简要描述")
    private String brief;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 记录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recTime;

    /** 品牌首字母 */
    @Excel(name = "品牌首字母")
    private String firstChar;

    public void setBrandId(Long brandId) 
    {
        this.brandId = brandId;
    }

    public Long getBrandId() 
    {
        return brandId;
    }
    public void setBrandName(String brandName) 
    {
        this.brandName = brandName;
    }

    public String getBrandName() 
    {
        return brandName;
    }
    public void setBrandPic(String brandPic) 
    {
        this.brandPic = brandPic;
    }

    public String getBrandPic() 
    {
        return brandPic;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setMemo(String memo) 
    {
        this.memo = memo;
    }

    public String getMemo() 
    {
        return memo;
    }
    public void setSeq(Long seq) 
    {
        this.seq = seq;
    }

    public Long getSeq() 
    {
        return seq;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setBrief(String brief) 
    {
        this.brief = brief;
    }

    public String getBrief() 
    {
        return brief;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setRecTime(Date recTime) 
    {
        this.recTime = recTime;
    }

    public Date getRecTime() 
    {
        return recTime;
    }
    public void setFirstChar(String firstChar) 
    {
        this.firstChar = firstChar;
    }

    public String getFirstChar() 
    {
        return firstChar;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("brandId", getBrandId())
            .append("brandName", getBrandName())
            .append("brandPic", getBrandPic())
            .append("userId", getUserId())
            .append("memo", getMemo())
            .append("seq", getSeq())
            .append("status", getStatus())
            .append("brief", getBrief())
            .append("content", getContent())
            .append("recTime", getRecTime())
            .append("updateTime", getUpdateTime())
            .append("firstChar", getFirstChar())
            .toString();
    }
}
