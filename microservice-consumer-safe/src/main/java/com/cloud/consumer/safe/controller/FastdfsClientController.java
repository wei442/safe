package com.cloud.consumer.safe.controller;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.CommConstants;
import com.cloud.common.enums.safe.RetSafeAdminResultEnum;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.rest.request.fastdfs.FastdfsRequest;
import com.cloud.consumer.safe.vo.fastdfs.FastdfsVo;
import com.github.tobato.fastdfs.domain.conn.FdfsWebServer;
import com.github.tobato.fastdfs.domain.fdfs.FileInfo;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * fastdfs客户端管理 FastdfsClientController
 * @author wei.yong
 * @ClassName: FastdfsClientController
 */
@Api(tags = "fastdfs")
@RestController
@RequestMapping("/fastdfsClient")
public class FastdfsClientController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private FastFileStorageClient fastFileStorageClient;

    @Autowired
    private FdfsWebServer fdfsWebServer;

    /**
     * 上传文件
     * @param file
     * @param bindingResult
     * @return BaseRestMapResponse
     */
	@ApiOperation(value = "上传文件")
	@RequestMapping(value="/uploadFile",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse uploadFile(
		MultipartFile file,
		BindingResult bindingResult) {
		logger.info("===step1:【上传文件】(FastdfsClientController-uploadFile)-请求参数, file:{}", file);

		StorePath storePath = null;
		try {
            storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
            logger.info("===step2:【上传文件】(FastdfsClientController-uploadFile)-上传文件, storePath:{}", storePath);
        } catch (Exception e) {
			logger.error("===step2.1:【上传文件】(FastdfsClientController-uploadFile)-上传文件异常, Exception = {}, message = {}", e, e.getMessage());
			return new BaseRestMapResponse(RetSafeAdminResultEnum.FASTDFS_UPLOAD_FILE_ERROR);
        }

		String fileUrl = fdfsWebServer.getWebServerUrl() + storePath.getFullPath();
		FastdfsVo fastdfsVo = new FastdfsVo();
		fastdfsVo.setGroup(storePath.getGroup());
		fastdfsVo.setFileUrl(fileUrl);

		//返回信息
		BaseRestMapResponse fastdfsResponse = new BaseRestMapResponse();
		fastdfsResponse.put(CommConstants.RESULT, fastdfsVo);
	    logger.info("===step3:【上传文件】(FastdfsClientController-uploadFile)-返回信息, fastdfsResponse:{}", fastdfsResponse);
	    return fastdfsResponse;
	}

    /**
     * 上传图片
     * @param file
     * @param bindingResult
     * @return BaseRestMapResponse
     */
	@ApiOperation(value = "上传图片")
	@RequestMapping(value="/uploadImage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse uploadImage(
		MultipartFile file,
		BindingResult bindingResult) {
		logger.info("===step1:【上传图片】(FastdfsClientController-uploadImage)-请求参数, file:{}", file);

		StorePath storePath = null;
		try {
            storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), null);
            logger.info("===step2:【上传图片】(FastdfsClientController-uploadImage)-上传文件, storePath:{}", storePath);
        } catch (Exception e) {
			logger.error("===step2.1:【上传图片】(FastdfsClientController-uploadImage)-上传文件异常, Exception = {}, message = {}", e, e.getMessage());
			return new BaseRestMapResponse(RetSafeAdminResultEnum.FASTDFS_UPLOAD_FILE_ERROR);
        }

		String fileUrl = fdfsWebServer.getWebServerUrl() + storePath.getFullPath();
		FastdfsVo fastdfsVo = new FastdfsVo();
		fastdfsVo.setGroup(storePath.getGroup());
		fastdfsVo.setFileUrl(fileUrl);

		//返回信息
		BaseRestMapResponse fastdfsResponse = new BaseRestMapResponse();
		fastdfsResponse.put(CommConstants.RESULT, fastdfsVo);
	    logger.info("===step3:【上传图片】(FastdfsClientController-uploadImage)-返回信息, fastdfsResponse:{}", fastdfsResponse);
	    return fastdfsResponse;
	}

	/**
	 * 获取文件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取文件")
	@RequestMapping(value="/getFile",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getFile(
		@Validated @RequestBody FastdfsRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取文件】(FastdfsClientController-getFile)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String fileUrl = req.getFileUrl();
		StorePath storePath = StorePath.parseFromUrl(fileUrl);
		FileInfo fileInfo = fastFileStorageClient.queryFileInfo(storePath.getGroup(), storePath.getPath());
		logger.info("===step2:【获取文件】(FastdfsClientController-getFile)-获取文件, fileInfo:{}", fileInfo);

		//返回信息
		BaseRestMapResponse fastdfsResponse = new BaseRestMapResponse();
		fastdfsResponse.put(CommConstants.RESULT, fileInfo);
	    logger.info("===step3:【获取文件】(FastdfsClientController-getFile)-返回信息, fastdfsResponse:{}", fastdfsResponse);
	    return fastdfsResponse;
	}

	/**
	 * 下载文件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "下载文件")
	@RequestMapping(value="/downloadFile",method={RequestMethod.POST})
	@ResponseBody
	public ResponseEntity<byte[]> downloadFile(
		@Validated @RequestBody FastdfsRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【下载文件】(FastdfsClientController-downloadFile)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String fileUrl = req.getFileUrl();
		StorePath storePath = StorePath.parseFromUrl(fileUrl);
		logger.info("===step1:【下载文件】(FastdfsClientController-downloadFile)-请求参数, storePath.getGroup():{}, storePath.getFullPath():{}", storePath.getGroup(), storePath.getFullPath());
		byte[] bytes = fastFileStorageClient.downloadFile(storePath.getGroup(), storePath.getPath(), null);
		logger.info("===step2:【下载文件】(FastdfsClientController-downloadFile)-下载文件, bytes.length:{}", bytes == null ? null : bytes.length);
		String fileName = StringUtils.substringAfterLast(fileUrl, "/");

		// 设置文件下载 Header
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setPragma("no-cache");
        headers.setExpires(0);

		return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
	}

	/**
	 * 删除文件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除文件")
	@RequestMapping(value="/deleteFile",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteFile(
		@Validated @RequestBody FastdfsRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除文件】(FastdfsClientController-deleteFile)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String fileUrl = req.getFileUrl();
		StorePath storePath = StorePath.parseFromUrl(fileUrl);
		fastFileStorageClient.deleteFile(storePath.getGroup(), storePath.getPath());

		//返回信息
		BaseRestMapResponse fastdfsResponse = new BaseRestMapResponse();
		logger.info("===step2:【删除文件】(FastdfsClientController-deleteFile)-返回信息, fastdfsResponse:{}", fastdfsResponse);
		return fastdfsResponse;
	}

}