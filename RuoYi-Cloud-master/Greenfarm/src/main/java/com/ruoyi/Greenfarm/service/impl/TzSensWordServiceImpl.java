package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzSensWordMapper;
import com.ruoyi.Greenfarm.domain.TzSensWord;
import com.ruoyi.Greenfarm.service.ITzSensWordService;

/**
 * 敏感字过滤Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzSensWordServiceImpl implements ITzSensWordService 
{
    @Autowired
    private TzSensWordMapper tzSensWordMapper;

    /**
     * 查询敏感字过滤
     * 
     * @param sensId 敏感字过滤主键
     * @return 敏感字过滤
     */
    @Override
    public TzSensWord selectTzSensWordBySensId(Long sensId)
    {
        return tzSensWordMapper.selectTzSensWordBySensId(sensId);
    }

    /**
     * 查询敏感字过滤列表
     * 
     * @param tzSensWord 敏感字过滤
     * @return 敏感字过滤
     */
    @Override
    public List<TzSensWord> selectTzSensWordList(TzSensWord tzSensWord)
    {
        return tzSensWordMapper.selectTzSensWordList(tzSensWord);
    }

    /**
     * 新增敏感字过滤
     * 
     * @param tzSensWord 敏感字过滤
     * @return 结果
     */
    @Override
    public int insertTzSensWord(TzSensWord tzSensWord)
    {
        return tzSensWordMapper.insertTzSensWord(tzSensWord);
    }

    /**
     * 修改敏感字过滤
     * 
     * @param tzSensWord 敏感字过滤
     * @return 结果
     */
    @Override
    public int updateTzSensWord(TzSensWord tzSensWord)
    {
        return tzSensWordMapper.updateTzSensWord(tzSensWord);
    }

    /**
     * 批量删除敏感字过滤
     * 
     * @param sensIds 需要删除的敏感字过滤主键
     * @return 结果
     */
    @Override
    public int deleteTzSensWordBySensIds(Long[] sensIds)
    {
        return tzSensWordMapper.deleteTzSensWordBySensIds(sensIds);
    }

    /**
     * 删除敏感字过滤信息
     * 
     * @param sensId 敏感字过滤主键
     * @return 结果
     */
    @Override
    public int deleteTzSensWordBySensId(Long sensId)
    {
        return tzSensWordMapper.deleteTzSensWordBySensId(sensId);
    }
}
