package com.ruoyi.farm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * goods_relation管理对象 farm_goods_relation
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public class FarmGoodsRelation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String farmid;

    /** $column.columnComment */
    private String goodsid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long num;

    public void setFarmid(String farmid) 
    {
        this.farmid = farmid;
    }

    public String getFarmid() 
    {
        return farmid;
    }
    public void setGoodsid(String goodsid) 
    {
        this.goodsid = goodsid;
    }

    public String getGoodsid() 
    {
        return goodsid;
    }
    public void setNum(Long num) 
    {
        this.num = num;
    }

    public Long getNum() 
    {
        return num;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("farmid", getFarmid())
            .append("goodsid", getGoodsid())
            .append("num", getNum())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
