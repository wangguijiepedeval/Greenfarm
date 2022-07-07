package com.ruoyi.Greenfarm.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 用户配送地址对象 tz_pick_addr
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzPickAddr extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long addrId;

    /** 自提点名称 */
    @Excel(name = "自提点名称")
    private String addrName;

    /** 地址 */
    @Excel(name = "地址")
    private String addr;

    /** 手机 */
    @Excel(name = "手机")
    private String mobile;

    /** 省份ID */
    @Excel(name = "省份ID")
    private Long provinceId;

    /** 省份 */
    @Excel(name = "省份")
    private String province;

    /** 城市ID */
    @Excel(name = "城市ID")
    private Long cityId;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 区/县ID */
    @Excel(name = "区/县ID")
    private Long areaId;

    /** 区/县 */
    @Excel(name = "区/县")
    private String area;

    /** 店铺id */
    @Excel(name = "店铺id")
    private Long shopId;

    public void setAddrId(Long addrId) 
    {
        this.addrId = addrId;
    }

    public Long getAddrId() 
    {
        return addrId;
    }
    public void setAddrName(String addrName) 
    {
        this.addrName = addrName;
    }

    public String getAddrName() 
    {
        return addrName;
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
            .append("addrId", getAddrId())
            .append("addrName", getAddrName())
            .append("addr", getAddr())
            .append("mobile", getMobile())
            .append("provinceId", getProvinceId())
            .append("province", getProvince())
            .append("cityId", getCityId())
            .append("city", getCity())
            .append("areaId", getAreaId())
            .append("area", getArea())
            .append("shopId", getShopId())
            .toString();
    }
}
