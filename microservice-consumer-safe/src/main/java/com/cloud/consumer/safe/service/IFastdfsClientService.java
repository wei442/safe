package com.cloud.consumer.safe.service;

import org.springframework.web.multipart.MultipartFile;

import com.github.tobato.fastdfs.domain.fdfs.FileInfo;

public interface IFastdfsClientService {

    /**
     * 查询文件信息
     * @param fileUrl
     * @return FileInfo
     */
	public FileInfo queryFileInfo(String fileUrl);

    /**
     * 上传文件
     * @param file 文件对象
     * @return String
     */
    public String uploadFile(MultipartFile file);

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