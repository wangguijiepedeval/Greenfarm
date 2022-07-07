package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzLoginHistMapper;
import com.ruoyi.Greenfarm.domain.TzLoginHist;
import com.ruoyi.Greenfarm.service.ITzLoginHistService;

/**
 * 登录历史Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzLoginHistServiceImpl implements ITzLoginHistService 
{
    @Autowired
    private TzLoginHistMapper tzLoginHistMapper;

    /**
     * 查询登录历史
     * 
     * @param id 登录历史主键
     * @return 登录历史
     */
    @Override
    public TzLoginHist selectTzLoginHistById(Long id)
    {
        return tzLoginHistMapper.selectTzLoginHistById(id);
    }

    /**
     * 查询登录历史列表
     * 
     * @param tzLoginHist 登录历史
     * @return 登录历史
     */
    @Override
    public List<TzLoginHist> selectTzLoginHistList(TzLoginHist tzLoginHist)
    {
        return tzLoginHistMapper.selectTzLoginHistList(tzLoginHist);
    }

    /**
     * 新增登录历史
     * 
     * @param tzLoginHist 登录历史
     * @return 结果
     */
    @Override
    public int insertTzLoginHist(TzLoginHist tzLoginHist)
    {
        return tzLoginHistMapper.insertTzLoginHist(tzLoginHist);
    }

    /**
     * 修改登录历史
     * 
     * @param tzLoginHist 登录历史
     * @return 结果
     */
    @Override
    public int updateTzLoginHist(TzLoginHist tzLoginHist)
    {
        return tzLoginHistMapper.updateTzLoginHist(tzLoginHist);
    }

    /**
     * 批量删除登录历史
     * 
     * @param ids 需要删除的登录历史主键
     * @return 结果
     */
    @Override
    public int deleteTzLoginHistByIds(Long[] ids)
    {
        return tzLoginHistMapper.deleteTzLoginHistByIds(ids);
    }

    /**
     * 删除登录历史信息
     * 
     * @param id 登录历史主键
     * @return 结果
     */
    @Override
    public int deleteTzLoginHistById(Long id)
    {
        return tzLoginHistMapper.deleteTzLoginHistById(id);
    }
}
