package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzNoticeMapper;
import com.ruoyi.Greenfarm.domain.TzNotice;
import com.ruoyi.Greenfarm.service.ITzNoticeService;

/**
 * 公告Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-06
 */
@Service
public class TzNoticeServiceImpl implements ITzNoticeService 
{
    @Autowired
    private TzNoticeMapper tzNoticeMapper;

    /**
     * 查询公告
     * 
     * @param id 公告主键
     * @return 公告
     */
    @Override
    public TzNotice selectTzNoticeById(Long id)
    {
        return tzNoticeMapper.selectTzNoticeById(id);
    }

    /**
     * 查询公告列表
     * 
     * @param tzNotice 公告
     * @return 公告
     */
    @Override
    public List<TzNotice> selectTzNoticeList(TzNotice tzNotice)
    {
        return tzNoticeMapper.selectTzNoticeList(tzNotice);
    }

    /**
     * 新增公告
     * 
     * @param tzNotice 公告
     * @return 结果
     */
    @Override
    public int insertTzNotice(TzNotice tzNotice)
    {
        return tzNoticeMapper.insertTzNotice(tzNotice);
    }

    /**
     * 修改公告
     * 
     * @param tzNotice 公告
     * @return 结果
     */
    @Override
    public int updateTzNotice(TzNotice tzNotice)
    {
        tzNotice.setUpdateTime(DateUtils.getNowDate());
        return tzNoticeMapper.updateTzNotice(tzNotice);
    }

    /**
     * 批量删除公告
     * 
     * @param ids 需要删除的公告主键
     * @return 结果
     */
    @Override
    public int deleteTzNoticeByIds(Long[] ids)
    {
        return tzNoticeMapper.deleteTzNoticeByIds(ids);
    }

    /**
     * 删除公告信息
     * 
     * @param id 公告主键
     * @return 结果
     */
    @Override
    public int deleteTzNoticeById(Long id)
    {
        return tzNoticeMapper.deleteTzNoticeById(id);
    }
}
