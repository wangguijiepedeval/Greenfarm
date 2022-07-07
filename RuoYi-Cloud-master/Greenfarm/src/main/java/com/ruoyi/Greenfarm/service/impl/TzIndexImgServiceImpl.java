package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzIndexImgMapper;
import com.ruoyi.Greenfarm.domain.TzIndexImg;
import com.ruoyi.Greenfarm.service.ITzIndexImgService;

/**
 * 主页轮播图Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzIndexImgServiceImpl implements ITzIndexImgService 
{
    @Autowired
    private TzIndexImgMapper tzIndexImgMapper;

    /**
     * 查询主页轮播图
     * 
     * @param imgId 主页轮播图主键
     * @return 主页轮播图
     */
    @Override
    public TzIndexImg selectTzIndexImgByImgId(Long imgId)
    {
        return tzIndexImgMapper.selectTzIndexImgByImgId(imgId);
    }

    /**
     * 查询主页轮播图列表
     * 
     * @param tzIndexImg 主页轮播图
     * @return 主页轮播图
     */
    @Override
    public List<TzIndexImg> selectTzIndexImgList(TzIndexImg tzIndexImg)
    {
        return tzIndexImgMapper.selectTzIndexImgList(tzIndexImg);
    }

    /**
     * 新增主页轮播图
     * 
     * @param tzIndexImg 主页轮播图
     * @return 结果
     */
    @Override
    public int insertTzIndexImg(TzIndexImg tzIndexImg)
    {
        return tzIndexImgMapper.insertTzIndexImg(tzIndexImg);
    }

    /**
     * 修改主页轮播图
     * 
     * @param tzIndexImg 主页轮播图
     * @return 结果
     */
    @Override
    public int updateTzIndexImg(TzIndexImg tzIndexImg)
    {
        return tzIndexImgMapper.updateTzIndexImg(tzIndexImg);
    }

    /**
     * 批量删除主页轮播图
     * 
     * @param imgIds 需要删除的主页轮播图主键
     * @return 结果
     */
    @Override
    public int deleteTzIndexImgByImgIds(Long[] imgIds)
    {
        return tzIndexImgMapper.deleteTzIndexImgByImgIds(imgIds);
    }

    /**
     * 删除主页轮播图信息
     * 
     * @param imgId 主页轮播图主键
     * @return 结果
     */
    @Override
    public int deleteTzIndexImgByImgId(Long imgId)
    {
        return tzIndexImgMapper.deleteTzIndexImgByImgId(imgId);
    }
}
