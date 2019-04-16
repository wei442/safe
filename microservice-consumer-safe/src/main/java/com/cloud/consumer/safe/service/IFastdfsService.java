package com.cloud.consumer.safe.service;

import java.io.InputStream;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

import com.github.tobato.fastdfs.domain.fdfs.FileInfo;
import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;

public interface IFastdfsService {

    /**
     * 查询文件信息
     * @param fileUrl
     * @return FileInfo
     */
	public FileInfo queryFileInfo(String fileUrl);

    /**
     * 上传文件
     * @param inputStream
     * @param fileSize
     * @param fileExtName
     * @param metaDataSet
     * @return StorePath
     */
	public StorePath uploadFile(InputStream inputStream, long fileSize, String fileExtName, Set<MetaData> metaDataSet);

    /**
     * 上传文件
     * @param file 文件对象
     * @return String
     */
    public String uploadFile(MultipartFile file);

    /**
     * 上传图片
     * @param inputStream
     * @param fileSize
     * @param fileExtName
     * @param metaDataSet
     * @return StorePath
     */
	public StorePath uploadImage(InputStream inputStream, long fileSize, String fileExtName, Set<MetaData> metaDataSet);

    /**
     * 上传图片
     * @param file
     * @return String
     */
    public String uploadImage(MultipartFile file);

    /**
     * 删除文件
     * @param fileUrl 文件访问地址
     */
    public void deleteFile(String fileUrl);

    /**
     * 下载文件
     * @param <T>
     * @param fileUrl
     * @return T
     */
    public <T> T downloadFile(String fileUrl);


}