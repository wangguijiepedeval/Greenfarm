package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzSensWord;

/**
 * 敏感字过滤Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzSensWordService 
{
    /**
     * 查询敏感字过滤
     * 
     * @param sensId 敏感字过滤主键
     * @return 敏感字过滤
     */
    public TzSensWord selectTzSensWordBySensId(Long sensId);

    /**
     * 查询敏感字过滤列表
     * 
     * @param tzSensWord 敏感字过滤
     * @return 敏感字过滤集合
     */
    public List<TzSensWord> selectTzSensWordList(TzSensWord tzSensWord);

    /**
     * 新增敏感字过滤
     * 
     * @param tzSensWord 敏感字过滤
     * @return 结果
     */
    public int insertTzSensWord(TzSensWord tzSensWord);

    /**
     * 修改敏感字过滤
     * 
     * @param tzSensWord 敏感字过滤
     * @return 结果
     */
    public int updateTzSensWord(TzSensWord tzSensWord);

    /**
     * 批量删除敏感字过滤
     * 
     * @param sensIds 需要删除的敏感字过滤主键集合
     * @return 结果
     */
    public int deleteTzSensWordBySensIds(Long[] sensIds);

    /**
     * 删除敏感字过滤信息
     * 
     * @param sensId 敏感字过滤主键
     * @return 结果
     */
    public int deleteTzSensWordBySensId(Long sensId);
}
