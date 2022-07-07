package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzIndexImg;

/**
 * 主页轮播图Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface TzIndexImgMapper 
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
     * 删除主页轮播图
     * 
     * @param imgId 主页轮播图主键
     * @return 结果
     */
    public int deleteTzIndexImgByImgId(Long imgId);

    /**
     * 批量删除主页轮播图
     * 
     * @param imgIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzIndexImgByImgIds(Long[] imgIds);
}
