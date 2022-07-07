package com.ruoyi.Greenfarm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 用户配送地址对象 tz_user_addr
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzUserAddr extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long addrId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String userId;

    /** 收货人 */
    @Excel(name = "收货人")
    private String receiver;

    /** 省ID */
    @Excel(name = "省ID")
    private Long provinceId;

    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 城市ID */
    @Excel(name = "城市ID")
    private Long cityId;

    /** 区 */
    @Excel(name = "区")
    private String area;

    /** 区ID */
    @Excel(name = "区ID")
    private Long areaId;

    /** 邮编 */
    @Excel(name = "邮编")
    private String postCode;

    /** 地址 */
    @Excel(name = "地址")
    private String addr;

    /** 手机 */
    @Excel(name = "手机")
    private String mobile;

    /** 状态,1正常，0无效 */
    @Excel(name = "状态,1正常，0无效")
    private Long status;

    /** 是否默认地址 1是 */
    @Excel(name = "是否默认地址 1是")
    private Long commonAddr;

    /** 版本号 */
    @Excel(name = "版本号")
    private Long version;

    public void setAddrId(Long addrId) 
    {
        this.addrId = addrId;
    }

    public Long getAddrId() 
    {
        return addrId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setReceiver(String receiver) 
    {
        this.receiver = receiver;
    }

    public String getReceiver() 
    {
        return receiver;
    }
    public void setProvinceId(Long provinceId) 
    {
        this.provinceId = provinceId;
    }

    public Long getProvinceId() 
    {
        return provinceId;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setCityId(Long cityId) 
    {
        this.cityId = cityId;
    }

    public Long getCityId() 
    {
        return cityId;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setAreaId(Long areaId) 
    {
        this.areaId = areaId;
    }

    public Long getAreaId() 
    {
        return areaId;
    }
    public void setPostCode(String postCode) 
    {
        this.postCode = postCode;
    }

    public String getPostCode() 
    {
        return postCode;
    }
    public void setAddr(String addr) 
    {
        this.addr = addr;
    }

    public String getAddr() 
    {
        return addr;
    }
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setCommonAddr(Long commonAddr) 
    {
        this.commonAddr = commonAddr;
    }

    public Long getCommonAddr() 
    {
        return commonAddr;
    }
    public void setVersion(Long version) 
    {
        this.version = version;
    }

    public Long getVersion() 
    {
        return version;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("addrId", getAddrId())
            .append("userId", getUserId())
            .append("receiver", getReceiver())
            .append("provinceId", getProvinceId())
            .append("province", getProvince())
            .append("city", getCity())
            .append("cityId", getCityId())
            .append("area", getArea())
            .append("areaId", getAreaId())
            .append("postCode", getPostCode())
            .append("addr", getAddr())
            .append("mobile", getMobile())
            .append("status", getStatus())
            .append("commonAddr", getCommonAddr())
            .append("createTime", getCreateTime())
            .append("version", getVersion())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
