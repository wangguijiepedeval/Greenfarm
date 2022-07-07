package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzTransfeeMapper;
import com.ruoyi.Greenfarm.domain.TzTransfee;
import com.ruoyi.Greenfarm.service.ITzTransfeeService;

/**
 * 运费信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzTransfeeServiceImpl implements ITzTransfeeService 
{
    @Autowired
    private TzTransfeeMapper tzTransfeeMapper;

    /**
     * 查询运费信息
     * 
     * @param transfeeId 运费信息主键
     * @return 运费信息
     */
    @Override
    public TzTransfee selectTzTransfeeByTransfeeId(Long transfeeId)
    {
        return tzTransfeeMapper.selectTzTransfeeByTransfeeId(transfeeId);
    }

    /**
     * 查询运费信息列表
     * 
     * @param tzTransfee 运费信息
     * @return 运费信息
     */
    @Override
    public List<TzTransfee> selectTzTransfeeList(TzTransfee tzTransfee)
    {
        return tzTransfeeMapper.selectTzTransfeeList(tzTransfee);
    }

    /**
     * 新增运费信息
     * 
     * @param tzTransfee 运费信息
     * @return 结果
     */
    @Override
    public int insertTzTransfee(TzTransfee tzTransfee)
    {
        return tzTransfeeMapper.insertTzTransfee(tzTransfee);
    }

    /**
     * 修改运费信息
     * 
     * @param tzTransfee 运费信息
     * @return 结果
     */
    @Override
    public int updateTzTransfee(TzTransfee tzTransfee)
    {
        return tzTransfeeMapper.updateTzTransfee(tzTransfee);
    }

    /**
     * 批量删除运费信息
     * 
     * @param transfeeIds 需要删除的运费信息主键
     * @return 结果
     */
    @Override
    public int deleteTzTransfeeByTransfeeIds(Long[] transfeeIds)
    {
        return tzTransfeeMapper.deleteTzTransfeeByTransfeeIds(transfeeIds);
    }

    /**
     * 删除运费信息信息
     * 
     * @param transfeeId 运费信息主键
     * @return 结果
     */
    @Override
    public int deleteTzTransfeeByTransfeeId(Long transfeeId)
    {
        return tzTransfeeMapper.deleteTzTransfeeByTransfeeId(transfeeId);
    }
}
