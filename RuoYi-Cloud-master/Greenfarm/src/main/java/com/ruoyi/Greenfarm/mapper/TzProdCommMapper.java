package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzProdComm;

/**
 * 商品评论Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface TzProdCommMapper 
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
     * 删除商品评论
     * 
     * @param prodCommId 商品评论主键
     * @return 结果
     */
    public int deleteTzProdCommByProdCommId(Long prodCommId);

    /**
     * 批量删除商品评论
     * 
     * @param prodCommIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzProdCommByProdCommIds(Long[] prodCommIds);
}
