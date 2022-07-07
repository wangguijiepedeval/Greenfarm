package com.ruoyi.Greenfarm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 商品评论对象 tz_prod_comm
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzProdComm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long prodCommId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private Long prodId;

    /** 订单项ID */
    @Excel(name = "订单项ID")
    private Long orderItemId;

    /** 评论用户ID */
    @Excel(name = "评论用户ID")
    private String userId;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String content;

    /** 掌柜回复 */
    @Excel(name = "掌柜回复")
    private String replyContent;

    /** 记录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recTime;

    /** 回复时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "回复时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date replyTime;

    /** 是否回复 0:未回复  1:已回复 */
    @Excel(name = "是否回复 0:未回复  1:已回复")
    private Long replySts;

    /** IP来源 */
    @Excel(name = "IP来源")
    private String postip;

    /** 得分，0-5分 */
    @Excel(name = "得分，0-5分")
    private Integer score;

    /** 有用的计数 */
    @Excel(name = "有用的计数")
    private Long usefulCounts;

    /** 晒图的json字符串 */
    @Excel(name = "晒图的json字符串")
    private String pics;

    /** 是否匿名(1:是  0:否) */
    @Excel(name = "是否匿名(1:是  0:否)")
    private Long isAnonymous;

    /** 是否显示，1:为显示，0:待审核， -1：不通过审核，不显示。 如果需要审核评论，则是0,，否则1 */
    @Excel(name = "是否显示，1:为显示，0:待审核， -1：不通过审核，不显示。 如果需要审核评论，则是0,，否则1")
    private Long status;

    /** 评价(0好评 1中评 2差评) */
    @Excel(name = "评价(0好评 1中评 2差评)")
    private Integer evaluate;

    public void setProdCommId(Long prodCommId) 
    {
        this.prodCommId = prodCommId;
    }

    public Long getProdCommId() 
    {
        return prodCommId;
    }
    public void setProdId(Long prodId) 
    {
        this.prodId = prodId;
    }

    public Long getProdId() 
    {
        return prodId;
    }
    public void setOrderItemId(Long orderItemId) 
    {
        this.orderItemId = orderItemId;
    }

    public Long getOrderItemId() 
    {
        return orderItemId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setReplyContent(String replyContent) 
    {
        this.replyContent = replyContent;
    }

    public String getReplyContent() 
    {
        return replyContent;
    }
    public void setRecTime(Date recTime) 
    {
        this.recTime = recTime;
    }

    public Date getRecTime() 
    {
        return recTime;
    }
    public void setReplyTime(Date replyTime) 
    {
        this.replyTime = replyTime;
    }

    public Date getReplyTime() 
    {
        return replyTime;
    }
    public void setReplySts(Long replySts) 
    {
        this.replySts = replySts;
    }

    public Long getReplySts() 
    {
        return replySts;
    }
    public void setPostip(String postip) 
    {
        this.postip = postip;
    }

    public String getPostip() 
    {
        return postip;
    }
    public void setScore(Integer score) 
    {
        this.score = score;
    }

    public Integer getScore() 
    {
        return score;
    }
    public void setUsefulCounts(Long usefulCounts) 
    {
        this.usefulCounts = usefulCounts;
    }

    public Long getUsefulCounts() 
    {
        return usefulCounts;
    }
    public void setPics(String pics) 
    {
        this.pics = pics;
    }

    public String getPics() 
    {
        return pics;
    }
    public void setIsAnonymous(Long isAnonymous) 
    {
        this.isAnonymous = isAnonymous;
    }

    public Long getIsAnonymous() 
    {
        return isAnonymous;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setEvaluate(Integer evaluate) 
    {
        this.evaluate = evaluate;
    }

    public Integer getEvaluate() 
    {
        return evaluate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("prodCommId", getProdCommId())
            .append("prodId", getProdId())
            .append("orderItemId", getOrderItemId())
            .append("userId", getUserId())
            .append("content", getContent())
            .append("replyContent", getReplyContent())
            .append("recTime", getRecTime())
            .append("replyTime", getReplyTime())
            .append("replySts", getReplySts())
            .append("postip", getPostip())
            .append("score", getScore())
            .append("usefulCounts", getUsefulCounts())
            .append("pics", getPics())
            .append("isAnonymous", getIsAnonymous())
            .append("status", getStatus())
            .append("evaluate", getEvaluate())
            .toString();
    }
}
