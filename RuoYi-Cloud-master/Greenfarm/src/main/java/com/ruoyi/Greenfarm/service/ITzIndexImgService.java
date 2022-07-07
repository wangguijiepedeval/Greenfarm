package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzIndexImg;

/**
 * 主页轮播图Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzIndexImgService 
{
    /**
     * 查询主页轮播图
     * 
     * @param imgId 主页轮播图主键
     * @return 主页轮播图
     */
    public TzIndexImg selectTzIndexImgByImgId(Long imgId);

    /**
     * 查询主页轮播图列表
     * 
     * @param tzIndexImg 主页轮播图
     * @return 主页轮播图集合
     */
    public List<TzIndexImg> selectTzIndexImgList(TzIndexImg tzIndexImg);

    /**
     * 新增主页轮播图
     * 
     * @param tzIndexImg 主页轮播图
     * @return 结果
     */
    public int insertTzIndexImg(TzIndexImg tzIndexImg);

    /**
     * 修改主页轮播图
     * 
     * @param tzIndexImg 主页轮播图
     * @return 结果
     */
    public int updateTzIndexImg(TzIndexImg tzIndexImg);

    /**
     * 批量删除主页轮播图
     * 
     * @param imgIds 需要删除的主页轮播图主键集合
     * @return 结果
     */
    public int deleteTzIndexImgByImgIds(Long[] imgIds);

    /**
     * 删除主页轮播图信息
     * 
     * @param imgId 主页轮播图主键
     * @return 结果
     */
    public int deleteTzIndexImgByImgId(Long imgId);
}
