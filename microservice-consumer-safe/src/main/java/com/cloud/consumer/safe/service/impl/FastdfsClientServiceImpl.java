package com.cloud.consumer.safe.service.impl;

import java.io.ByteArrayInputStream;
import java.nio.charset.Charset;

import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloud.common.enums.safe.RetSafeAdminResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.consumer.safe.service.IFastdfsClientService;
import com.github.tobato.fastdfs.domain.conn.FdfsWebServer;
import com.github.tobato.fastdfs.domain.fdfs.FileInfo;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

@Service
public class FastdfsClientServiceImpl extends BaseService implements IFastdfsClientService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private FdfsWebServer fdfsWebServer;

    /**
     * 查询文件信息
     * @param fileUrl
     * @return FileInfo
     */
	@Override
	public FileInfo queryFileInfo(String fileUrl) {
    	logger.info("(FastdfsClientService-queryFileInfo)-传入参数, fileUrl:{}", fileUrl);
    	FileInfo fileInfo = null;
        try {
        	StorePath storePath = StorePath.parseFromUrl(fileUrl);
        	fileInfo = storageClient.queryFileInfo(storePath.getGroup(), storePath.getPath());
        } catch (Exception e) {
			logger.error("(FastdfsClientService-queryFileInfo)-查询文件异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(RetSafeAdminResultEnum.FASTDFS_FILE_INFO_ERROR);
        }
        return fileInfo;
    }

    /**
     * 上传文件
     * @param file 文件对象
     * @return String
     */
    @Override
	public String uploadFile(MultipartFile file) {
    	logger.info("(FastdfsClientService-uploadFile)-传入参数, file:{}", file);
        StorePath storePath = null;
        try {
            storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        } catch (Exception e) {
			logger.error("(FastdfsClientService-uploadFile)-上传文件异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(RetSafeAdminResultEnum.FASTDFS_UPLOAD_FILE_ERROR);
        }
        return getResAccessUrl(storePath);
    }

    /**
     * 上传图片
     * @param file
     * @return String
     */
    @Override
	public String uploadImage(MultipartFile file) {
    	logger.info("(FastdfsClientService-uploadImage)-传入参数, file:{}", file);
    	StorePath storePath = null;
    	try {
    		storePath = storageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
        } catch (Exception e) {
			logger.error("(FastdfsClientService-deleteFile)-删除文件异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(RetSafeAdminResultEnum.FASTDFS_UPLOAD_IMAGE_ERROR);
        }

    	return getResAccessUrl(storePath);
    }

    /**
     * 删除文件
     * @param fileUrl 文件访问地址
     */
    @Override
	public void deleteFile(String fileUrl) {
    	logger.info("(FastdfsClientService-deleteFile)-传入参数, fileUrl:{}", fileUrl);
        try {
            StorePath storePath = StorePath.parseFromUrl(fileUrl);
            storageClient.deleteFile(storePath.getGroup(), storePath.getPath());
        } catch (Exception e) {
			logger.error("(FastdfsClientService-deleteFile)-删除文件异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(RetSafeAdminResultEnum.FASTDFS_DELETE_FILE_ERROR);
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
    	logger.info("(FastdfsClientService-downloadFile)-传入参数, fileUrl:{}", fileUrl);
    	T t = null;
		try {
			StorePath storePath = StorePath.parseFromUrl(fileUrl);
			t = storageClient.downloadFile(storePath.getGroup(), storePath.getPath(), null);
        } catch (Exception e) {
			logger.error("(FastdfsClientService-downloadFile)-下载文件异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(RetSafeAdminResultEnum.FASTDFS_DOWNLOAD_ERROR);
        }
    	return t;
    }


//    /**
//     * 上传文件
//     * @param file 文件对象
//     * @return 文件访问地址
//     * @throws IOException
//     */
//    public String uploadFile(File file) throws IOException {
//        FileInputStream inputStream = new FileInputStream (file);
//        StorePath storePath = storageClient.uploadFile(inputStream, file.length(), FilenameUtils.getExtension(file.getName()), null);
//        return getResAccessUrl(storePath);
//    }

    /**
     * 将一段字符串生成一个文件上传
     * @param content 文件内容
     * @param fileExtension
     * @return
     */
    public String uploadFile(String content, String fileExtension) {
        byte[] buff = content.getBytes(Charset.forName("UTF-8"));
        ByteArrayInputStream stream = new ByteArrayInputStream(buff);
        StorePath storePath = storageClient.uploadFile(stream, buff.length, fileExtension,null);
        return getResAccessUrl(storePath);
    }

    /**
     * 封装图片完整URL地址
     * @param storePath
     * @return String
     */
    private String getResAccessUrl(StorePath storePath) {
    	logger.info("(FastdfsClientService-getResAccessUrl)-传入参数, storePath:{}", storePath);
        String fileUrl = fdfsWebServer.getWebServerUrl() + storePath.getFullPath();
        return fileUrl;
    }

}
