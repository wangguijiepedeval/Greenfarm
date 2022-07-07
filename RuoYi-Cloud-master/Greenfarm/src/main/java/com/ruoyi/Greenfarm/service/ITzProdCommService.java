package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzProdComm;

/**
 * 商品评论Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzProdCommService 
{
    /**
     * 查询商品评论
     * 
     * @param prodCommId 商品评论主键
     * @return 商品评论
     */
    public TzProdComm selectTzProdCommByProdCommId(Long prodCommId);

    /**
     * 查询商品评论列表
     * 
     * @param tzProdComm 商品评论
     * @return 商品评论集合
     */
    public List<TzProdComm> selectTzProdCommList(TzProdComm tzProdComm);

    /**
     * 新增商品评论
     * 
     * @param tzProdComm 商品评论
     * @return 结果
     */
    public int insertTzProdComm(TzProdComm tzProdComm);

    /**
     * 修改商品评论
     * 
     * @param tzProdComm 商品评论
     * @return 结果
     */
    public int updateTzProdComm(TzProdComm tzProdComm);

    /**
     * 批量删除商品评论
     * 
     * @param prodCommIds 需要删除的商品评论主键集合
     * @return 结果
     */
    public int deleteTzProdCommByProdCommIds(Long[] prodCommIds);

    /**
     * 删除商品评论信息
     * 
     * @param prodCommId 商品评论主键
     * @return 结果
     */
    public int deleteTzProdCommByProdCommId(Long prodCommId);
}
