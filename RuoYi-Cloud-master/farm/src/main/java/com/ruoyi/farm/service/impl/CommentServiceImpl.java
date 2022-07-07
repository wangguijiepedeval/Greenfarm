package com.ruoyi.farm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.farm.mapper.CommentMapper;
import com.ruoyi.farm.domain.Comment;
import com.ruoyi.farm.service.ICommentService;

/**
 * comment管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class CommentServiceImpl implements ICommentService 
{
    @Autowired
    private CommentMapper commentMapper;

    /**
     * 查询comment管理
     * 
     * @param commentatorid comment管理主键
     * @return comment管理
     */
    @Override
    public Comment selectCommentByCommentatorid(String commentatorid)
    {
        return commentMapper.selectCommentByCommentatorid(commentatorid);
    }

    /**
     * 查询comment管理列表
     * 
     * @param comment comment管理
     * @return comment管理
     */
    @Override
    public List<Comment> selectCommentList(Comment comment)
    {
        return commentMapper.selectCommentList(comment);
    }

    /**
     * 新增comment管理
     * 
     * @param comment comment管理
     * @return 结果
     */
    @Override
    public int insertComment(Comment comment)
    {
        comment.setCreateTime(DateUtils.getNowDate());
        return commentMapper.insertComment(comment);
    }

    /**
     * 修改comment管理
     * 
     * @param comment comment管理
     * @return 结果
     */
    @Override
    public int updateComment(Comment comment)
    {
        comment.setUpdateTime(DateUtils.getNowDate());
        return commentMapper.updateComment(comment);
    }

    /**
     * 批量删除comment管理
     * 
     * @param commentatorids 需要删除的comment管理主键
     * @return 结果
     */
    @Override
    public int deleteCommentByCommentatorids(String[] commentatorids)
    {
        return commentMapper.deleteCommentByCommentatorids(commentatorids);
    }

    /**
     * 删除comment管理信息
     * 
     * @param commentatorid comment管理主键
     * @return 结果
     */
    @Override
    public int deleteCommentByCommentatorid(String commentatorid)
    {
        return commentMapper.deleteCommentByCommentatorid(commentatorid);
    }
}
