package com.ruoyi.farm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * goods管理对象 goods
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public class Goods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private String goodsid;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String goodsname;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String goodsphoto;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long goodsprice;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String introduce;

    public void setGoodsid(String goodsid) 
    {
        this.goodsid = goodsid;
    }

    public String getGoodsid() 
    {
        return goodsid;
    }
    public void setGoodsname(String goodsname) 
    {
        this.goodsname = goodsname;
    }

    public String getGoodsname() 
    {
        return goodsname;
    }
    public void setGoodsphoto(String goodsphoto) 
    {
        this.goodsphoto = goodsphoto;
    }

    public String getGoodsphoto() 
    {
        return goodsphoto;
    }
    public void setGoodsprice(Long goodsprice) 
    {
        this.goodsprice = goodsprice;
    }

    public Long getGoodsprice() 
    {
        return goodsprice;
    }
    public void setIntroduce(String introduce) 
    {
        this.introduce = introduce;
    }

    public String getIntroduce() 
    {
        return introduce;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("goodsid", getGoodsid())
            .append("goodsname", getGoodsname())
            .append("goodsphoto", getGoodsphoto())
            .append("goodsprice", getGoodsprice())
            .append("introduce", getIntroduce())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
