package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzNotice;

/**
 * 公告Service接口
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
public interface ITzNoticeService 
{
    /**
     * 查询公告
     * 
     * @param id 公告主键
     * @return 公告
     */
    public TzNotice selectTzNoticeById(Long id);

    /**
     * 查询公告列表
     * 
     * @param tzNotice 公告
     * @return 公告集合
     */
    public List<TzNotice> selectTzNoticeList(TzNotice tzNotice);

    /**
     * 新增公告
     * 
     * @param tzNotice 公告
     * @return 结果
     */
    public int insertTzNotice(TzNotice tzNotice);

    /**
     * 修改公告
     * 
     * @param tzNotice 公告
     * @return 结果
     */
    public int updateTzNotice(TzNotice tzNotice);

    /**
     * 批量删除公告
     * 
     * @param ids 需要删除的公告主键集合
     * @return 结果
     */
    public int deleteTzNoticeByIds(Long[] ids);

    /**
     * 删除公告信息
     * 
     * @param id 公告主键
     * @return 结果
     */
    public int deleteTzNoticeById(Long id);
}
