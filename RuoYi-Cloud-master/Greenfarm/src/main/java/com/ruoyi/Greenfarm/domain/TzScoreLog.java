package com.ruoyi.Greenfarm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 用户积分管理对象 tz_score_log
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzScoreLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 积分记录id */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private String userId;

    /** 0支出 1收入 */
    @Excel(name = "0支出 1收入")
    private Integer type;

    /** 流水号 */
    @Excel(name = "流水号")
    private String sn;

    /** 积分类型：1回收加积分 2购买减积分 */
    @Excel(name = "积分类型：1回收加积分 2购买减积分")
    private Integer scoreType;

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
    public void setType(Integer type) 
    {
        this.type = type;
    }

    public Integer getType() 
    {
        return type;
    }
    public void setSn(String sn) 
    {
        this.sn = sn;
    }

    public String getSn() 
    {
        return sn;
    }
    public void setScoreType(Integer scoreType) 
    {
        this.scoreType = scoreType;
    }

    public Integer getScoreType() 
    {
        return scoreType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("type", getType())
            .append("createTime", getCreateTime())
            .append("sn", getSn())
            .append("scoreType", getScoreType())
            .toString();
    }
}
