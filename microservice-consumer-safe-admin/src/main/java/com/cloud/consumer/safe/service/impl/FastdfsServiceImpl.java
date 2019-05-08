package com.cloud.consumer.safe.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.common.enums.safe.RetSafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.consumer.safe.service.IFastdfsService;
import com.github.tobato.fastdfs.domain.conn.FdfsWebServer;
import com.github.tobato.fastdfs.domain.fdfs.FileInfo;
import com.github.tobato.fastdfs.domain.fdfs.MetaData;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

@Service
public class FastdfsServiceImpl extends BaseService implements IFastdfsService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Autowired
    private FdfsWebServer fdfsWebServer;

    /**
     * 查询文件信息
     * @param fileUrl
     * @return FileInfo
     */
	@Override
	public FileInfo queryFileInfo(String fileUrl) {
    	logger.info("(FastdfsService-queryFileInfo)-传入参数, fileUrl:{}", fileUrl);
    	FileInfo fileInfo = null;
        try {
        	StorePath storePath = StorePath.parseFromUrl(fileUrl);
        	fileInfo = fastFileStorageClient.queryFileInfo(storePath.getGroup(), storePath.getPath());
        } catch (Exception e) {
			logger.error("(FastdfsService-queryFileInfo)-查询文件异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(RetSafeResultEnum.FASTDFS_FILE_INFO_ERROR);
        }
        return fileInfo;
    }

    /**
     * 上传文件
     * @param inputStream
     * @param fileSize
     * @param fileExtName
     * @param metaDataSet
     * @return StorePath
     */
	@Override
	public StorePath uploadFile(InputStream inputStream, long fileSize, String fileExtName, Set<MetaData> metaDataSet) {
    	logger.info("(FastdfsService-uploadFile)-传入参数, inputStream:{}, fileExtName:{}, fileExtName:{}, metaDataSet:{}", inputStream, fileSize, fileExtName, metaDataSet);
        StorePath storePath = null;
        try {
            storePath = fastFileStorageClient.uploadFile(inputStream, fileSize, fileExtName, metaDataSet);
        } catch (Exception e) {
			logger.error("(FastdfsService-uploadFile)-上传文件异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(RetSafeResultEnum.FASTDFS_UPLOAD_FILE_ERROR);
        }
        return storePath;
    }

    /**
     * 上传文件
     * @param file 文件对象
     * @return String
     */
    @Override
	public String uploadFile(MultipartFile file) {
    	logger.info("(FastdfsService-uploadFile)-传入参数, file:{}", file);
        StorePath storePath = null;
        try {
            storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        } catch (Exception e) {
			logger.error("(FastdfsService-uploadFile)-上传文件异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(RetSafeResultEnum.FASTDFS_UPLOAD_FILE_ERROR);
        }
        return getAccessUrl(storePath);
    }

    /**
     * 上传图片
     * @param inputStream
     * @param fileSize
     * @param fileExtName
     * @param metaDataSet
     * @return StorePath
     */
	@Override
	public StorePath uploadImage(InputStream inputStream, long fileSize, String fileExtName, Set<MetaData> metaDataSet) {
    	logger.info("(FastdfsService-uploadImage)-传入参数, inputStream:{}, fileExtName:{}, fileExtName:{}, metaDataSet:{}", inputStream, fileSize, fileExtName, metaDataSet);
    	StorePath storePath = null;
    	try {
    		storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(inputStream, fileSize, fileExtName, metaDataSet);
        } catch (Exception e) {
			logger.error("(FastdfsService-uploadImage)-删除文件异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(RetSafeResultEnum.FASTDFS_UPLOAD_IMAGE_ERROR);
        }

    	return storePath;
    }

    /**
     * 上传图片
     * @param file
     * @return String
     */
    @Override
	public String uploadImage(MultipartFile file) {
    	logger.info("(FastdfsService-uploadImage)-传入参数, file:{}", file);
    	StorePath storePath = null;
    	try {
    		storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        } catch (Exception e) {
			logger.error("(FastdfsService-deleteFile)-删除文件异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(RetSafeResultEnum.FASTDFS_UPLOAD_IMAGE_ERROR);
        }

    	return getAccessUrl(storePath);
    }

    /**
     * 删除文件
     * @param fileUrl 文件访问地址
     */
    @Override
	public void deleteFile(String fileUrl) {
    	logger.info("(FastdfsService-deleteFile)-传入参数, fileUrl:{}", fileUrl);
        try {
            StorePath storePath = StorePath.parseFromUrl(fileUrl);
            fastFileStorageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (Exception e) {
			logger.error("(FastdfsService-deleteFile)-删除文件异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(RetSafeResultEnum.FASTDFS_DELETE_FILE_ERROR);
        }
    }

    /**
     * 下载文件
     * @param <T>
     * @param fileUrl
     * @return T
     */
    @Override
	public <T> T downloadFile(String fileUrl) {
    	logger.info("(FastdfsService-downloadFile)-传入参数, fileUrl:{}", fileUrl);
    	T t = null;
		try {
			StorePath storePath = StorePath.parseFromUrl(fileUrl);
			t = fastFileStorageClient.downloadFile(storePath.getGroup(), storePath.getPath(), null);
        } catch (Exception e) {
			logger.error("(FastdfsService-downloadFile)-下载文件异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(RetSafeResultEnum.FASTDFS_DOWNLOAD_ERROR);
        }
    	return t;
    }

    /**
     * 将一段字符串生成一个文件上传
     * @param content 文件内容
     * @param fileExtension
     * @return
     */
    public String uploadFile(String content, String fileExtension) {
        byte[] buff = content.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
        StorePath storePath = fastFileStorageClient.uploadFile(stream, buff.length, fileExtension,null);
        return getAccessUrl(storePath);
    }

    /**
     * 封装图片完整URL地址
     * @param storePath
     * @return String
     */
    private String getAccessUrl(StorePath storePath) {
    	logger.info("(FastdfsService-getAccessUrl)-传入参数, storePath:{}", storePath);
        String fileUrl = fdfsWebServer.getWebServerUrl() + "/" + storePath.getFullPath();
        return fileUrl;
    }

}
