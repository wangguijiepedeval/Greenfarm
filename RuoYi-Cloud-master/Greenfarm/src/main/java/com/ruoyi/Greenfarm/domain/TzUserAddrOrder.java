package com.ruoyi.Greenfarm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 用户订单配送地址对象 tz_user_addr_order
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzUserAddrOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long addrOrderId;

    /** 地址ID */
    @Excel(name = "地址ID")
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

    /** 区域ID */
    @Excel(name = "区域ID")
    private Long areaId;

    /** 区 */
    @Excel(name = "区")
    private String area;

    /** 城市ID */
    @Excel(name = "城市ID")
    private Long cityId;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 地址 */
    @Excel(name = "地址")
    private String addr;

    /** 邮编 */
    @Excel(name = "邮编")
    private String postCode;

    /** 手机 */
    @Excel(name = "手机")
    private String mobile;

    /** 版本号 */
    @Excel(name = "版本号")
    private Long version;

    public void setAddrOrderId(Long addrOrderId) 
    {
        this.addrOrderId = addrOrderId;
    }

    public Long getAddrOrderId() 
    {
        return addrOrderId;
    }
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
    public void setAreaId(Long areaId) 
    {
        this.areaId = areaId;
    }

    public Long getAreaId() 
    {
        return areaId;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setCityId(Long cityId) 
    {
        this.cityId = cityId;
    }

    public Long getCityId() 
    {
        return cityId;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setAddr(String addr) 
    {
        this.addr = addr;
    }

    public String getAddr() 
    {
        return addr;
    }
    public void setPostCode(String postCode) 
    {
        this.postCode = postCode;
    }

    public String getPostCode() 
    {
        return postCode;
    }
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
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
            .append("addrOrderId", getAddrOrderId())
            .append("addrId", getAddrId())
            .append("userId", getUserId())
            .append("receiver", getReceiver())
            .append("provinceId", getProvinceId())
            .append("province", getProvince())
            .append("areaId", getAreaId())
            .append("area", getArea())
            .append("cityId", getCityId())
            .append("city", getCity())
            .append("addr", getAddr())
            .append("postCode", getPostCode())
            .append("mobile", getMobile())
            .append("createTime", getCreateTime())
            .append("version", getVersion())
            .toString();
    }
}
