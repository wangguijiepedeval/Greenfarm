package com.ruoyi.farm.service;

import java.util.List;
import com.ruoyi.farm.domain.Comment;

/**
 * comment管理Service接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface ICommentService 
{
    /**
     * 查询comment管理
     * 
     * @param commentatorid comment管理主键
     * @return comment管理
     */
    public Comment selectCommentByCommentatorid(String commentatorid);

    /**
     * 查询comment管理列表
     * 
     * @param comment comment管理
     * @return comment管理集合
     */
    public List<Comment> selectCommentList(Comment comment);

    /**
     * 新增comment管理
     * 
     * @param comment comment管理
     * @return 结果
     */
    public int insertComment(Comment comment);

    /**
     * 修改comment管理
     * 
     * @param comment comment管理
     * @return 结果
     */
    public int updateComment(Comment comment);

    /**
     * 批量删除comment管理
     * 
     * @param commentatorids 需要删除的comment管理主键集合
     * @return 结果
     */
    public int deleteCommentByCommentatorids(String[] commentatorids);

    /**
     * 删除comment管理信息
     * 
     * @param commentatorid comment管理主键
     * @return 结果
     */
    public int deleteCommentByCommentatorid(String commentatorid);
}
