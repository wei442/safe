package com.cloud.consumer.safe.controller;

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

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.CommConstants;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.rest.request.fastdfs.FastdfsRequest;
import com.cloud.consumer.safe.service.IFastdfsClientService;
import com.github.tobato.fastdfs.domain.fdfs.FileInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * fastdfs管理 FastdfsClientController
 * @author wei.yong
 * @ClassName: FastdfsClientController
 */
@Api(tags = "fastdfs")
@RestController
@RequestMapping("/fastdfsClient")
public class FastdfsClientController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//fastdfsClient Service
	@Autowired
	private IFastdfsClientService fastdfsClientService;

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
		FileInfo fileInfo = fastdfsClientService.queryFileInfo(fileUrl);
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
		byte[] bytes = fastdfsClientService.downloadFile(fileUrl);
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
		fastdfsClientService.deleteFile(fileUrl);

		//返回信息
		BaseRestMapResponse fastdfsResponse = new BaseRestMapResponse();
		logger.info("===step2:【删除文件】(FastdfsClientController-deleteFile)-返回信息, fastdfsResponse:{}", fastdfsResponse);
		return fastdfsResponse;
	}

}