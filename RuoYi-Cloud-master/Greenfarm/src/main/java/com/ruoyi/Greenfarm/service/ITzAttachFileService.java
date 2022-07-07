package com.ruoyi.Greenfarm.service;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzAttachFile;

/**
 * 文件管理Service接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface ITzAttachFileService 
{
    /**
     * 查询文件管理
     * 
     * @param fileId 文件管理主键
     * @return 文件管理
     */
    public TzAttachFile selectTzAttachFileByFileId(Long fileId);

    /**
     * 查询文件管理列表
     * 
     * @param tzAttachFile 文件管理
     * @return 文件管理集合
     */
    public List<TzAttachFile> selectTzAttachFileList(TzAttachFile tzAttachFile);

    /**
     * 新增文件管理
     * 
     * @param tzAttachFile 文件管理
     * @return 结果
     */
    public int insertTzAttachFile(TzAttachFile tzAttachFile);

    /**
     * 修改文件管理
     * 
     * @param tzAttachFile 文件管理
     * @return 结果
     */
    public int updateTzAttachFile(TzAttachFile tzAttachFile);

    /**
     * 批量删除文件管理
     * 
     * @param fileIds 需要删除的文件管理主键集合
     * @return 结果
     */
    public int deleteTzAttachFileByFileIds(Long[] fileIds);

    /**
     * 删除文件管理信息
     * 
     * @param fileId 文件管理主键
     * @return 结果
     */
    public int deleteTzAttachFileByFileId(Long fileId);
}
