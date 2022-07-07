package com.ruoyi.Greenfarm.mapper;

import java.util.List;
import com.ruoyi.Greenfarm.domain.TzAttachFile;

/**
 * 文件管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public interface TzAttachFileMapper 
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
     * 删除文件管理
     * 
     * @param fileId 文件管理主键
     * @return 结果
     */
    public int deleteTzAttachFileByFileId(Long fileId);

    /**
     * 批量删除文件管理
     * 
     * @param fileIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTzAttachFileByFileIds(Long[] fileIds);
}
