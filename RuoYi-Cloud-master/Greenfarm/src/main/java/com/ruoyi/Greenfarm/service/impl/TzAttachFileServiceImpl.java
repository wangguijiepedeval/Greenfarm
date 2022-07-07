package com.ruoyi.Greenfarm.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.Greenfarm.mapper.TzAttachFileMapper;
import com.ruoyi.Greenfarm.domain.TzAttachFile;
import com.ruoyi.Greenfarm.service.ITzAttachFileService;

/**
 * 文件管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
@Service
public class TzAttachFileServiceImpl implements ITzAttachFileService 
{
    @Autowired
    private TzAttachFileMapper tzAttachFileMapper;

    /**
     * 查询文件管理
     * 
     * @param fileId 文件管理主键
     * @return 文件管理
     */
    @Override
    public TzAttachFile selectTzAttachFileByFileId(Long fileId)
    {
        return tzAttachFileMapper.selectTzAttachFileByFileId(fileId);
    }

    /**
     * 查询文件管理列表
     * 
     * @param tzAttachFile 文件管理
     * @return 文件管理
     */
    @Override
    public List<TzAttachFile> selectTzAttachFileList(TzAttachFile tzAttachFile)
    {
        return tzAttachFileMapper.selectTzAttachFileList(tzAttachFile);
    }

    /**
     * 新增文件管理
     * 
     * @param tzAttachFile 文件管理
     * @return 结果
     */
    @Override
    public int insertTzAttachFile(TzAttachFile tzAttachFile)
    {
        return tzAttachFileMapper.insertTzAttachFile(tzAttachFile);
    }

    /**
     * 修改文件管理
     * 
     * @param tzAttachFile 文件管理
     * @return 结果
     */
    @Override
    public int updateTzAttachFile(TzAttachFile tzAttachFile)
    {
        return tzAttachFileMapper.updateTzAttachFile(tzAttachFile);
    }

    /**
     * 批量删除文件管理
     * 
     * @param fileIds 需要删除的文件管理主键
     * @return 结果
     */
    @Override
    public int deleteTzAttachFileByFileIds(Long[] fileIds)
    {
        return tzAttachFileMapper.deleteTzAttachFileByFileIds(fileIds);
    }

    /**
     * 删除文件管理信息
     * 
     * @param fileId 文件管理主键
     * @return 结果
     */
    @Override
    public int deleteTzAttachFileByFileId(Long fileId)
    {
        return tzAttachFileMapper.deleteTzAttachFileByFileId(fileId);
    }
}
