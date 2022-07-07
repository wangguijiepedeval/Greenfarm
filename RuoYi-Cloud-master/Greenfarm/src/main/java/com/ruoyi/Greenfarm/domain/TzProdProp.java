package com.ruoyi.Greenfarm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 店铺信息对象 tz_prod_prop
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzProdProp extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 属性id */
    private Long propId;

    /** 属性名称 */
    @Excel(name = "属性名称")
    private String propName;

    /** ProdPropRule 1:销售属性(规格); 2:参数属性; */
    @Excel(name = "ProdPropRule 1:销售属性(规格); 2:参数属性;")
    private Integer rule;

    /** 店铺id */
    @Excel(name = "店铺id")
    private Long shopId;

    public void setPropId(Long propId) 
    {
        this.propId = propId;
    }

    public Long getPropId() 
    {
        return propId;
    }
    public void setPropName(String propName) 
    {
        this.propName = propName;
    }

    public String getPropName() 
    {
        return propName;
    }
    public void setRule(Integer rule) 
    {
        this.rule = rule;
    }

    public Integer getRule() 
    {
        return rule;
    }
    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("propId", getPropId())
            .append("propName", getPropName())
            .append("rule", getRule())
            .append("shopId", getShopId())
            .toString();
    }
}
