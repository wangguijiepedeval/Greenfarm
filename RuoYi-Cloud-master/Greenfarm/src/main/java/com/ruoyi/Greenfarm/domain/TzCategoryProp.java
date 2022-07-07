package com.ruoyi.Greenfarm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 购物车商品对象 tz_category_prop
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public class TzCategoryProp extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 分类id */
    @Excel(name = "分类id")
    private Long categoryId;

    /** 商品属性id即表tz_prod_prop中的prop_id */
    @Excel(name = "商品属性id即表tz_prod_prop中的prop_id")
    private Long propId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }
    public void setPropId(Long propId) 
    {
        this.propId = propId;
    }

    public Long getPropId() 
    {
        return propId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("categoryId", getCategoryId())
            .append("propId", getPropId())
            .toString();
    }
}
