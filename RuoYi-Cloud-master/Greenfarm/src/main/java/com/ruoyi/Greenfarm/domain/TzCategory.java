package com.ruoyi.Greenfarm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 产品类目对象 tz_category
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 类目ID */
    private Long categoryId;

    /** 店铺ID */
    @Excel(name = "店铺ID")
    private Long shopId;

    /** 父节点 */
    @Excel(name = "父节点")
    private Long parentId;

    /** 产品类目名称 */
    @Excel(name = "产品类目名称")
    private String categoryName;

    /** 类目图标 */
    @Excel(name = "类目图标")
    private String icon;

    /** 类目的显示图片 */
    @Excel(name = "类目的显示图片")
    private String pic;

    /** 排序 */
    @Excel(name = "排序")
    private Long seq;

    /** 默认是1，表示正常状态,0为下线状态 */
    @Excel(name = "默认是1，表示正常状态,0为下线状态")
    private Long status;

    /** 记录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recTime;

    /** 分类层级 */
    @Excel(name = "分类层级")
    private Long grade;

    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setParentId(Long parentId) 
    {
        this.parentId = parentId;
    }

    public Long getParentId() 
    {
        return parentId;
    }
    public void setCategoryName(String categoryName) 
    {
        this.categoryName = categoryName;
    }

    public String getCategoryName() 
    {
        return categoryName;
    }
    public void setIcon(String icon) 
    {
        this.icon = icon;
    }

    public String getIcon() 
    {
        return icon;
    }
    public void setPic(String pic) 
    {
        this.pic = pic;
    }

    public String getPic() 
    {
        return pic;
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
    public void setRecTime(Date recTime) 
    {
        this.recTime = recTime;
    }

    public Date getRecTime() 
    {
        return recTime;
    }
    public void setGrade(Long grade) 
    {
        this.grade = grade;
    }

    public Long getGrade() 
    {
        return grade;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("categoryId", getCategoryId())
            .append("shopId", getShopId())
            .append("parentId", getParentId())
            .append("categoryName", getCategoryName())
            .append("icon", getIcon())
            .append("pic", getPic())
            .append("seq", getSeq())
            .append("status", getStatus())
            .append("recTime", getRecTime())
            .append("grade", getGrade())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
