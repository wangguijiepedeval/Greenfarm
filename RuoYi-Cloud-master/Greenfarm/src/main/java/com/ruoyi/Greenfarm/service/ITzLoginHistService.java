package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzLoginHist;

/**
 * 登录历史Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzLoginHistService 
{
    /**
     * 查询登录历史
     * 
     * @param id 登录历史主键
     * @return 登录历史
     */
    public TzLoginHist selectTzLoginHistById(Long id);

    /**
     * 查询登录历史列表
     * 
     * @param tzLoginHist 登录历史
     * @return 登录历史集合
     */
    public List<TzLoginHist> selectTzLoginHistList(TzLoginHist tzLoginHist);

    /**
     * 新增登录历史
     * 
     * @param tzLoginHist 登录历史
     * @return 结果
     */
    public int insertTzLoginHist(TzLoginHist tzLoginHist);

    /**
     * 修改登录历史
     * 
     * @param tzLoginHist 登录历史
     * @return 结果
     */
    public int updateTzLoginHist(TzLoginHist tzLoginHist);

    /**
     * 批量删除登录历史
     * 
     * @param ids 需要删除的登录历史主键集合
     * @return 结果
     */
    public int deleteTzLoginHistByIds(Long[] ids);

    /**
     * 删除登录历史信息
     * 
     * @param id 登录历史主键
     * @return 结果
     */
    public int deleteTzLoginHistById(Long id);
}
