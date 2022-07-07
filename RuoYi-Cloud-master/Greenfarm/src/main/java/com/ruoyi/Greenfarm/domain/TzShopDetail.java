package com.ruoyi.Greenfarm.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 商家管理对象 tz_shop_detail
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public class TzShopDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 店铺id */
    private Long shopId;

    /** 店铺名称(数字、中文，英文(可混合，不可有特殊字符)，可修改)、不唯一 */
    @Excel(name = "店铺名称(数字、中文，英文(可混合，不可有特殊字符)，可修改)、不唯一")
    private String shopName;

    /** 店长用户id */
    @Excel(name = "店长用户id")
    private String userId;

    /** 店铺类型 */
    @Excel(name = "店铺类型")
    private Integer shopType;

    /** 店铺简介(可修改) */
    @Excel(name = "店铺简介(可修改)")
    private String intro;

    /** 店铺公告(可修改) */
    @Excel(name = "店铺公告(可修改)")
    private String shopNotice;

    /** 店铺行业(餐饮、生鲜果蔬、鲜花等) */
    @Excel(name = "店铺行业(餐饮、生鲜果蔬、鲜花等)")
    private Integer shopIndustry;

    /** 店长 */
    @Excel(name = "店长")
    private String shopOwner;

    /** 店铺绑定的手机(登录账号：唯一) */
    @Excel(name = "店铺绑定的手机(登录账号：唯一)")
    private String mobile;

    /** 店铺联系电话 */
    @Excel(name = "店铺联系电话")
    private String tel;

    /** 店铺所在纬度(可修改) */
    @Excel(name = "店铺所在纬度(可修改)")
    private String shopLat;

    /** 店铺所在经度(可修改) */
    @Excel(name = "店铺所在经度(可修改)")
    private String shopLng;

    /** 店铺详细地址 */
    @Excel(name = "店铺详细地址")
    private String shopAddress;

    /** 店铺所在省份（描述） */
    @Excel(name = "店铺所在省份", readConverterExp = "描=述")
    private String province;

    /** 店铺所在城市（描述） */
    @Excel(name = "店铺所在城市", readConverterExp = "描=述")
    private String city;

    /** 店铺所在区域（描述） */
    @Excel(name = "店铺所在区域", readConverterExp = "描=述")
    private String area;

    /** 店铺省市区代码，用于回显 */
    @Excel(name = "店铺省市区代码，用于回显")
    private String pcaCode;

    /** 店铺logo(可修改) */
    @Excel(name = "店铺logo(可修改)")
    private String shopLogo;

    /** 店铺相册 */
    @Excel(name = "店铺相册")
    private String shopPhotos;

    /** 每天营业时间段(可修改) */
    @Excel(name = "每天营业时间段(可修改)")
    private String openTime;

    /** 店铺状态(-1:未开通 0: 停业中 1:营业中)，可修改 */
    @Excel(name = "店铺状态(-1:未开通 0: 停业中 1:营业中)，可修改")
    private Integer shopStatus;

    /** 0:商家承担运费; 1:买家承担运费 */
    @Excel(name = "0:商家承担运费; 1:买家承担运费")
    private Integer transportType;

    /** 固定运费 */
    @Excel(name = "固定运费")
    private BigDecimal fixedFreight;

    /** 满X包邮 */
    @Excel(name = "满X包邮")
    private BigDecimal fullFreeShipping;

    /** 分销开关(0:开启 1:关闭) */
    @Excel(name = "分销开关(0:开启 1:关闭)")
    private Integer isDistribution;

    public void setShopId(Long shopId) 
    {
        this.shopId = shopId;
    }

    public Long getShopId() 
    {
        return shopId;
    }
    public void setShopName(String shopName) 
    {
        this.shopName = shopName;
    }

    public String getShopName() 
    {
        return shopName;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setShopType(Integer shopType) 
    {
        this.shopType = shopType;
    }

    public Integer getShopType() 
    {
        return shopType;
    }
    public void setIntro(String intro) 
    {
        this.intro = intro;
    }

    public String getIntro() 
    {
        return intro;
    }
    public void setShopNotice(String shopNotice) 
    {
        this.shopNotice = shopNotice;
    }

    public String getShopNotice() 
    {
        return shopNotice;
    }
    public void setShopIndustry(Integer shopIndustry) 
    {
        this.shopIndustry = shopIndustry;
    }

    public Integer getShopIndustry() 
    {
        return shopIndustry;
    }
    public void setShopOwner(String shopOwner) 
    {
        this.shopOwner = shopOwner;
    }

    public String getShopOwner() 
    {
        return shopOwner;
    }
    public void setMobile(String mobile) 
    {
        this.mobile = mobile;
    }

    public String getMobile() 
    {
        return mobile;
    }
    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }
    public void setShopLat(String shopLat) 
    {
        this.shopLat = shopLat;
    }

    public String getShopLat() 
    {
        return shopLat;
    }
    public void setShopLng(String shopLng) 
    {
        this.shopLng = shopLng;
    }

    public String getShopLng() 
    {
        return shopLng;
    }
    public void setShopAddress(String shopAddress) 
    {
        this.shopAddress = shopAddress;
    }

    public String getShopAddress() 
    {
        return shopAddress;
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
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setPcaCode(String pcaCode) 
    {
        this.pcaCode = pcaCode;
    }

    public String getPcaCode() 
    {
        return pcaCode;
    }
    public void setShopLogo(String shopLogo) 
    {
        this.shopLogo = shopLogo;
    }

    public String getShopLogo() 
    {
        return shopLogo;
    }
    public void setShopPhotos(String shopPhotos) 
    {
        this.shopPhotos = shopPhotos;
    }

    public String getShopPhotos() 
    {
        return shopPhotos;
    }
    public void setOpenTime(String openTime) 
    {
        this.openTime = openTime;
    }

    public String getOpenTime() 
    {
        return openTime;
    }
    public void setShopStatus(Integer shopStatus) 
    {
        this.shopStatus = shopStatus;
    }

    public Integer getShopStatus() 
    {
        return shopStatus;
    }
    public void setTransportType(Integer transportType) 
    {
        this.transportType = transportType;
    }

    public Integer getTransportType() 
    {
        return transportType;
    }
    public void setFixedFreight(BigDecimal fixedFreight) 
    {
        this.fixedFreight = fixedFreight;
    }

    public BigDecimal getFixedFreight() 
    {
        return fixedFreight;
    }
    public void setFullFreeShipping(BigDecimal fullFreeShipping) 
    {
        this.fullFreeShipping = fullFreeShipping;
    }

    public BigDecimal getFullFreeShipping() 
    {
        return fullFreeShipping;
    }
    public void setIsDistribution(Integer isDistribution) 
    {
        this.isDistribution = isDistribution;
    }

    public Integer getIsDistribution() 
    {
        return isDistribution;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("shopId", getShopId())
            .append("shopName", getShopName())
            .append("userId", getUserId())
            .append("shopType", getShopType())
            .append("intro", getIntro())
            .append("shopNotice", getShopNotice())
            .append("shopIndustry", getShopIndustry())
            .append("shopOwner", getShopOwner())
            .append("mobile", getMobile())
            .append("tel", getTel())
            .append("shopLat", getShopLat())
            .append("shopLng", getShopLng())
            .append("shopAddress", getShopAddress())
            .append("province", getProvince())
            .append("city", getCity())
            .append("area", getArea())
            .append("pcaCode", getPcaCode())
            .append("shopLogo", getShopLogo())
            .append("shopPhotos", getShopPhotos())
            .append("openTime", getOpenTime())
            .append("shopStatus", getShopStatus())
            .append("transportType", getTransportType())
            .append("fixedFreight", getFixedFreight())
            .append("fullFreeShipping", getFullFreeShipping())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDistribution", getIsDistribution())
            .toString();
    }
}
