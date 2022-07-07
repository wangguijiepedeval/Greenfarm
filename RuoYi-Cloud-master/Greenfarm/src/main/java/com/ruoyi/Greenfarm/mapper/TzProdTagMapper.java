package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzProdTag;

/**
 * 商品分组Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface TzProdTagMapper 
{
    /**
     * 查询商品分组
     * 
     * @param id 商品分组主键
     * @return 商品分组
     */
    public TzProdTag selectTzProdTagById(Long id);

    /**
     * 查询商品分组列表
     * 
     * @param tzProdTag 商品分组
     * @return 商品分组集合
     */
    public List<TzProdTag> selectTzProdTagList(TzProdTag tzProdTag);

    /**
     * 新增商品分组
     * 
     * @param tzProdTag 商品分组
     * @return 结果
     */
    public int insertTzProdTag(TzProdTag tzProdTag);

    /**
     * 修改商品分组
     * 
     * @param tzProdTag 商品分组
     * @return 结果
     */
    public int updateTzProdTag(TzProdTag tzProdTag);

    /**
     * 删除商品分组
     * 
     * @param id 商品分组主键
     * @return 结果
     */
    public int deleteTzProdTagById(Long id);

    /**
     * 批量删除商品分组
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzProdTagByIds(Long[] ids);
}
