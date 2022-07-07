package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzTransfee;

/**
 * 运费信息Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzTransfeeService 
{
    /**
     * 查询运费信息
     * 
     * @param transfeeId 运费信息主键
     * @return 运费信息
     */
    public TzTransfee selectTzTransfeeByTransfeeId(Long transfeeId);

    /**
     * 查询运费信息列表
     * 
     * @param tzTransfee 运费信息
     * @return 运费信息集合
     */
    public List<TzTransfee> selectTzTransfeeList(TzTransfee tzTransfee);

    /**
     * 新增运费信息
     * 
     * @param tzTransfee 运费信息
     * @return 结果
     */
    public int insertTzTransfee(TzTransfee tzTransfee);

    /**
     * 修改运费信息
     * 
     * @param tzTransfee 运费信息
     * @return 结果
     */
    public int updateTzTransfee(TzTransfee tzTransfee);

    /**
     * 批量删除运费信息
     * 
     * @param transfeeIds 需要删除的运费信息主键集合
     * @return 结果
     */
    public int deleteTzTransfeeByTransfeeIds(Long[] transfeeIds);

    /**
     * 删除运费信息信息
     * 
     * @param transfeeId 运费信息主键
     * @return 结果
     */
    public int deleteTzTransfeeByTransfeeId(Long transfeeId);
}