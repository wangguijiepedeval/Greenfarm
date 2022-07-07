package com.ruoyi.Greenfarm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 用户对象 tz_user
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private String userId;

    /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String nickName;

    /** 真实姓名 */
    @Excel(name = "真实姓名")
    private String realName;

    /** 用户邮箱 */
    @Excel(name = "用户邮箱")
    private String userMail;

    /** 登录密码 */
    @Excel(name = "登录密码")
    private String loginPassword;

    /** 支付密码 */
    @Excel(name = "支付密码")
    private String payPassword;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String userMobile;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date modifyTime;

    /** 注册时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "注册时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date userRegtime;

    /** 注册IP */
    @Excel(name = "注册IP")
    private String userRegip;

    /** 最后登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "最后登录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date userLasttime;

    /** 最后登录IP */
    @Excel(name = "最后登录IP")
    private String userLastip;

    /** 备注 */
    @Excel(name = "备注")
    private String userMemo;

    /** M(男) or F(女) */
    @Excel(name = "M(男) or F(女)")
    private String sex;

    /** 例如：2009-11-27 */
    @Excel(name = "例如：2009-11-27")
    private String birthDate;

    /** 头像图片路径 */
    @Excel(name = "头像图片路径")
    private String pic;

    /** 状态 1 正常 0 无效 */
    @Excel(name = "状态 1 正常 0 无效")
    private Long status;

    /** 用户积分 */
    @Excel(name = "用户积分")
    private Long score;

    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setRealName(String realName) 
    {
        this.realName = realName;
    }

    public String getRealName() 
    {
        return realName;
    }
    public void setUserMail(String userMail) 
    {
        this.userMail = userMail;
    }

    public String getUserMail() 
    {
        return userMail;
    }
    public void setLoginPassword(String loginPassword) 
    {
        this.loginPassword = loginPassword;
    }

    public String getLoginPassword() 
    {
        return loginPassword;
    }
    public void setPayPassword(String payPassword) 
    {
        this.payPassword = payPassword;
    }

    public String getPayPassword() 
    {
        return payPassword;
    }
    public void setUserMobile(String userMobile) 
    {
        this.userMobile = userMobile;
    }

    public String getUserMobile() 
    {
        return userMobile;
    }
    public void setModifyTime(Date modifyTime) 
    {
        this.modifyTime = modifyTime;
    }

    public Date getModifyTime() 
    {
        return modifyTime;
    }
    public void setUserRegtime(Date userRegtime) 
    {
        this.userRegtime = userRegtime;
    }

    public Date getUserRegtime() 
    {
        return userRegtime;
    }
    public void setUserRegip(String userRegip) 
    {
        this.userRegip = userRegip;
    }

    public String getUserRegip() 
    {
        return userRegip;
    }
    public void setUserLasttime(Date userLasttime) 
    {
        this.userLasttime = userLasttime;
    }

    public Date getUserLasttime() 
    {
        return userLasttime;
    }
    public void setUserLastip(String userLastip) 
    {
        this.userLastip = userLastip;
    }

    public String getUserLastip() 
    {
        return userLastip;
    }
    public void setUserMemo(String userMemo) 
    {
        this.userMemo = userMemo;
    }

    public String getUserMemo() 
    {
        return userMemo;
    }
    public void setSex(String sex) 
    {
        this.sex = sex;
    }

    public String getSex() 
    {
        return sex;
    }
    public void setBirthDate(String birthDate) 
    {
        this.birthDate = birthDate;
    }

    public String getBirthDate() 
    {
        return birthDate;
    }
    public void setPic(String pic) 
    {
        this.pic = pic;
    }

    public String getPic() 
    {
        return pic;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setScore(Long score) 
    {
        this.score = score;
    }

    public Long getScore() 
    {
        return score;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("nickName", getNickName())
            .append("realName", getRealName())
            .append("userMail", getUserMail())
            .append("loginPassword", getLoginPassword())
            .append("payPassword", getPayPassword())
            .append("userMobile", getUserMobile())
            .append("modifyTime", getModifyTime())
            .append("userRegtime", getUserRegtime())
            .append("userRegip", getUserRegip())
            .append("userLasttime", getUserLasttime())
            .append("userLastip", getUserLastip())
            .append("userMemo", getUserMemo())
            .append("sex", getSex())
            .append("birthDate", getBirthDate())
            .append("pic", getPic())
            .append("status", getStatus())
            .append("score", getScore())
            .toString();
    }
}
