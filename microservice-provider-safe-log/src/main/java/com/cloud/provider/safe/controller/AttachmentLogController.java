package com.cloud.provider.safe.controller;

import java.util.List;

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
import com.cloud.common.constants.PageConstants;
import com.cloud.provider.safe.base.BaseRestMapResponse;
import com.cloud.provider.safe.page.PageHelperUtil;
import com.cloud.provider.safe.po.AttachmentLog;
import com.cloud.provider.safe.rest.request.AttachmentLogRequest;
import com.cloud.provider.safe.rest.request.page.AttachmentLogPageRequest;
import com.cloud.provider.safe.service.IAttachmentLogService;
import com.cloud.provider.safe.vo.AttachmentLogVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 附件日志 AttachmentLogController
 * @author wei.yong
 */
@Api(tags = "附件日志")
@RestController
@RequestMapping(value="/attachment/log")
public class AttachmentLogController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//附件日志 Service
	@Autowired
	private IAttachmentLogService attachmentLogService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询附件日志列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody AttachmentLogPageRequest req) {
		logger.info("===step1:【分页查询附件日志列表】(AttachmentLogController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<AttachmentLog> list = attachmentLogService.selectListByPage(page, req);
		logger.info("===step2:【分页查询附件日志列表】(AttachmentLogController-selectListByPage)-分页查询附件日志列表, list.size:{}", list == null ? null : list.size());
		List<AttachmentLogVo> dataList = new AttachmentLogVo().convertToAttachmentLogVoList(list);

		BaseRestMapResponse attachmentLogResponse = new BaseRestMapResponse();
		attachmentLogResponse.put(PageConstants.PAGE, PageHelperUtil.INSTANCE.getPageVo(list));
		attachmentLogResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【分页查询附件日志列表】(AttachmentLogController-selectListByPage)-返回信息, attachmentLogResponse:{}", attachmentLogResponse);
		return attachmentLogResponse;
	}

	/**
	 * 添加附件日志
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加附件日志")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody AttachmentLogRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加附件日志】(AttachmentLogController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		AttachmentLog attachmentLog = req.convertToAttachmentLog();
		int i = attachmentLogService.insert(attachmentLog);
		logger.info("===step2:【添加附件日志】(AttachmentLogController-insert)-插入附件日志, i:{}", i);

		BaseRestMapResponse attachmentLogResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加附件日志】(AttachmentLogController-insert)-返回信息, attachmentLogResponse:{}", attachmentLogResponse);
		return attachmentLogResponse;
	}

}