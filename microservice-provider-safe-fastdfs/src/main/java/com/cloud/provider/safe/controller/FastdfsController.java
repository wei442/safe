package com.cloud.provider.safe.controller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cloud.provider.safe.base.BaseRestMapResponse;
import com.cloud.provider.safe.rest.request.FastdfsRequest;
import com.cloud.provider.safe.service.IAttachmentService;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.upload.FastFile;
import com.github.tobato.fastdfs.domain.upload.FastImageFile;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 附件 FastdfsController
 * @author wei.yong
 */
@Api(tags = "fastdfs")
@RestController
@RequestMapping(value="/fastdfs")
public class FastdfsController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//附件Service
	@Autowired
	private IAttachmentService attachmentService;

	//文件操作存储客户端
	@Autowired
	private FastFileStorageClient fastFileStorageClient;

	/**
	 * 上传图片
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "上传图片")
	@RequestMapping(value="/uploadImage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse uploadImage(
		@Validated @RequestBody FastdfsRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【上传图片】(FastdfsController-uploadImage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		byte[] bytes = req.getBytes();
		long fileSize = req.getFileSize();
		String fileName = req.getFileName();

		InputStream inputStream = new ByteArrayInputStream(bytes);
//		new BufferedInputStream(new ByteArrayInputStream(bytes));
		FastImageFile fastImageFile = new FastImageFile(inputStream, fileSize, fileName, null);
		StorePath storePath = fastFileStorageClient.uploadImage(fastImageFile);
//		byte[] bytes1 = fastFileStorageClient.downloadFile("", "", null);

		BaseRestMapResponse fastdfsResponse = new BaseRestMapResponse();
		fastdfsResponse.putAll((JSONObject) JSONObject.toJSON(storePath));
		logger.info("===step2:【上传图片】(FastdfsController-uploadImage)-返回信息, fastdfsResponse:{}", fastdfsResponse);
		return fastdfsResponse;
	}

	/**
	 * 上传图片并且生成缩略图
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "上传图片并且生成缩略图")
	@RequestMapping(value="/uploadImageAndCrtThumbImage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse uploadImageAndCrtThumbImage(
		@Validated @RequestBody FastdfsRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【上传图片并且生成缩略图】(FastdfsController-uploadImageAndCrtThumbImage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		byte[] bytes = req.getBytes();
		long fileSize = req.getFileSize();
		String fileName = req.getFileName();

		InputStream inputStream = new ByteArrayInputStream(bytes);
		StorePath storePath = fastFileStorageClient.uploadImageAndCrtThumbImage(inputStream, fileSize, fileName, null);

		BaseRestMapResponse fastdfsResponse = new BaseRestMapResponse();
		fastdfsResponse.putAll((JSONObject) JSONObject.toJSON(storePath));
		logger.info("===step3:【上传图片并且生成缩略图】(AttachmentController-uploadImageAndCrtThumbImage)-返回信息, fastdfsResponse:{}", fastdfsResponse);
		return fastdfsResponse;
	}

	/**
	 * 上传文件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "上传文件")
	@RequestMapping(value="/uploadFile",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse uploadFile(
		@Validated @RequestBody FastdfsRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【上传文件】(FastdfsController-uploadFile)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		byte[] bytes = req.getBytes();
		long fileSize = req.getFileSize();
		String fileName = req.getFileName();

		InputStream inputStream = new ByteArrayInputStream(bytes);
		FastFile fastFile = new FastFile(inputStream, fileSize, fileName, null);
		StorePath storePath = fastFileStorageClient.uploadFile(fastFile);

		BaseRestMapResponse fastdfsResponse = new BaseRestMapResponse();
		fastdfsResponse.putAll((JSONObject) JSONObject.toJSON(storePath));
		logger.info("===step2:【上传文件】(FastdfsController-uploadFile)-返回信息, fastdfsResponse:{}", fastdfsResponse);
		return fastdfsResponse;
	}


	/**
	 * 上传文件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除附件")
	@RequestMapping(value="/deleteFile",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteFile(
		@Validated @RequestBody FastdfsRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【上传文件】(FastdfsController-uploadFile)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		byte[] bytes = req.getBytes();
		long fileSize = req.getFileSize();
		String fileName = req.getFileName();

		InputStream inputStream = new ByteArrayInputStream(bytes);
		FastFile fastFile = new FastFile(inputStream, fileSize, fileName, null);
//		StorePath storePath = fastFileStorageClient.deleteFile(filePath);

		BaseRestMapResponse fastdfsResponse = new BaseRestMapResponse();
//		fastdfsResponse.putAll((JSONObject) JSONObject.toJSON(storePath));
		logger.info("===step2:【上传文件】(FastdfsController-uploadFile)-返回信息, fastdfsResponse:{}", fastdfsResponse);
		return fastdfsResponse;
	}





}