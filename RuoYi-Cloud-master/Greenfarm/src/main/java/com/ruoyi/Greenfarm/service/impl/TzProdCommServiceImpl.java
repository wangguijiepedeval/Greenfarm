package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzProdCommMapper;
import com.ruoyi.Greenfarm.domain.TzProdComm;
import com.ruoyi.Greenfarm.service.ITzProdCommService;

/**
 * 商品评论Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzProdCommServiceImpl implements ITzProdCommService 
{
    @Autowired
    private TzProdCommMapper tzProdCommMapper;

    /**
     * 查询商品评论
     * 
     * @param prodCommId 商品评论主键
     * @return 商品评论
     */
    @Override
    public TzProdComm selectTzProdCommByProdCommId(Long prodCommId)
    {
        return tzProdCommMapper.selectTzProdCommByProdCommId(prodCommId);
    }

    /**
     * 查询商品评论列表
     * 
     * @param tzProdComm 商品评论
     * @return 商品评论
     */
    @Override
    public List<TzProdComm> selectTzProdCommList(TzProdComm tzProdComm)
    {
        return tzProdCommMapper.selectTzProdCommList(tzProdComm);
    }

    /**
     * 新增商品评论
     * 
     * @param tzProdComm 商品评论
     * @return 结果
     */
    @Override
    public int insertTzProdComm(TzProdComm tzProdComm)
    {
        return tzProdCommMapper.insertTzProdComm(tzProdComm);
    }

    /**
     * 修改商品评论
     * 
     * @param tzProdComm 商品评论
     * @return 结果
     */
    @Override
    public int updateTzProdComm(TzProdComm tzProdComm)
    {
        return tzProdCommMapper.updateTzProdComm(tzProdComm);
    }

    /**
     * 批量删除商品评论
     * 
     * @param prodCommIds 需要删除的商品评论主键
     * @return 结果
     */
    @Override
    public int deleteTzProdCommByProdCommIds(Long[] prodCommIds)
    {
        return tzProdCommMapper.deleteTzProdCommByProdCommIds(prodCommIds);
    }

    /**
     * 删除商品评论信息
     * 
     * @param prodCommId 商品评论主键
     * @return 结果
     */
    @Override
    public int deleteTzProdCommByProdCommId(Long prodCommId)
    {
        return tzProdCommMapper.deleteTzProdCommByProdCommId(prodCommId);
    }
}
