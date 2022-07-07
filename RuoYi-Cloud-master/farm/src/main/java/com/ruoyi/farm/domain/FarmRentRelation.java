package com.ruoyi.farm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * rent_relation管理对象 farm_rent_relation
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public class FarmRentRelation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 租户id，复合主键，注意 */
    private String userid;

    /** $column.columnComment */
    private String farmid;

    public void setUserid(String userid) 
    {
        this.userid = userid;
    }

    public String getUserid() 
    {
        return userid;
    }
    public void setFarmid(String farmid) 
    {
        this.farmid = farmid;
    }

    public String getFarmid() 
    {
        return farmid;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userid", getUserid())
            .append("farmid", getFarmid())
            .append("updateTime", getUpdateTime())
            .append("createTime", getCreateTime())
            .toString();
    }
}
