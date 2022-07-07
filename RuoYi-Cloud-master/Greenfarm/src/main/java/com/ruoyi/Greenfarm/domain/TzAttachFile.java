package com.ruoyi.Greenfarm.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 文件管理对象 tz_attach_file
 * 
 * @author ruoyi
 * @date 2022-07-07
 */
public class TzAttachFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文件ID */
    private Long fileId;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String filePath;

    /** 文件类型 */
    @Excel(name = "文件类型")
    private String fileType;

    /** 文件大小 */
    @Excel(name = "文件大小")
    private Long fileSize;

    /** 上传时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uploadTime;

    /** 文件关联的表主键id */
    @Excel(name = "文件关联的表主键id")
    private Long fileJoinId;

    /** 文件关联表类型：1 商品表  FileJoinType */
    @Excel(name = "文件关联表类型：1 商品表  FileJoinType")
    private Integer fileJoinType;

    public void setFileId(Long fileId) 
    {
        this.fileId = fileId;
    }

    public Long getFileId() 
    {
        return fileId;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }
    public void setFileType(String fileType) 
    {
        this.fileType = fileType;
    }

    public String getFileType() 
    {
        return fileType;
    }
    public void setFileSize(Long fileSize) 
    {
        this.fileSize = fileSize;
    }

    public Long getFileSize() 
    {
        return fileSize;
    }
    public void setUploadTime(Date uploadTime) 
    {
        this.uploadTime = uploadTime;
    }

    public Date getUploadTime() 
    {
        return uploadTime;
    }
    public void setFileJoinId(Long fileJoinId) 
    {
        this.fileJoinId = fileJoinId;
    }

    public Long getFileJoinId() 
    {
        return fileJoinId;
    }
    public void setFileJoinType(Integer fileJoinType) 
    {
        this.fileJoinType = fileJoinType;
    }

    public Integer getFileJoinType() 
    {
        return fileJoinType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fileId", getFileId())
            .append("filePath", getFilePath())
            .append("fileType", getFileType())
            .append("fileSize", getFileSize())
            .append("uploadTime", getUploadTime())
            .append("fileJoinId", getFileJoinId())
            .append("fileJoinType", getFileJoinType())
            .toString();
    }
}
