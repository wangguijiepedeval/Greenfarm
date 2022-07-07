package com.ruoyi.Greenfarm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 主页轮播图对象 tz_index_img
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzIndexImg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long imgId;

    /** 店铺ID */
    @Excel(name = "店铺ID")
    private Long shopId;

    /** 图片 */
    @Excel(name = "图片")
    private String imgUrl;

    /** 说明文字,描述 */
    @Excel(name = "说明文字,描述")
    private String des;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 链接 */
    @Excel(name = "链接")
    private String link;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 顺序 */
    @Excel(name = "顺序")
    private Long seq;

    /** 上传时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uploadTime;

    /** 关联 */
    @Excel(name = "关联")
    private Long relation;

    /** 类型 */
    @Excel(name = "类型")
    private Long type;

    public void setImgId(Long imgId) 
    {
        this.imgId = imgId;
    }

    public Long getImgId() 
    {
        return imgId;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setImgUrl(String imgUrl) 
    {
        this.imgUrl = imgUrl;
    }

    public String getImgUrl() 
    {
        return imgUrl;
    }
    public void setDes(String des) 
    {
        this.des = des;
    }

    public String getDes() 
    {
        return des;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setLink(String link) 
    {
        this.link = link;
    }

    public String getLink() 
    {
        return link;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setSeq(Long seq) 
    {
        this.seq = seq;
    }

    public Long getSeq() 
    {
        return seq;
    }
    public void setUploadTime(Date uploadTime) 
    {
        this.uploadTime = uploadTime;
    }

    public Date getUploadTime() 
    {
        return uploadTime;
    }
    public void setRelation(Long relation) 
    {
        this.relation = relation;
    }

    public Long getRelation() 
    {
        return relation;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("imgId", getImgId())
            .append("shopId", getShopId())
            .append("imgUrl", getImgUrl())
            .append("des", getDes())
            .append("title", getTitle())
            .append("link", getLink())
            .append("status", getStatus())
            .append("seq", getSeq())
            .append("uploadTime", getUploadTime())
            .append("relation", getRelation())
            .append("type", getType())
            .toString();
    }
}
