package com.cloud.provider.safe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.PageConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.base.BaseRestMapResponse;
import com.cloud.provider.safe.page.PageHelperUtil;
import com.cloud.provider.safe.po.Attachment;
import com.cloud.provider.safe.rest.request.AttachmentRequest;
import com.cloud.provider.safe.rest.request.page.AttachmentPageRequest;
import com.cloud.provider.safe.service.IAttachmentService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.AttachmentVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 附件 AttachmentController
 * @author wei.yong
 */
@Api(tags = "附件")
@RestController
@RequestMapping(value="/attachment")
public class AttachmentController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//附件Service
	@Autowired
	private IAttachmentService attachmentService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询附件列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody AttachmentPageRequest req) {
		logger.info("===step1:【分页查询附件列表】(AttachmentController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<Attachment> list = attachmentService.selectListByPage(page, req);
		logger.info("===step2:【分页查询附件列表】(AttachmentController-selectListByPage)-分页查询附件列表, list.size:{}", list == null ? null : list.size());
		List<AttachmentVo> attachmentVoList = new AttachmentVo().convertToAttachmentVoList(list);

		BaseRestMapResponse attachmentResponse = new BaseRestMapResponse();
		attachmentResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(attachmentVoList));
		logger.info("===step3:【分页查询附件列表】(AttachmentController-selectListByPage)-返回信息, attachmentResponse:{}", attachmentResponse);
		return attachmentResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询附件列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody AttachmentPageRequest req) {
		logger.info("===step1:【不分页查询附件列表】(AttachmentController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<Attachment> list = attachmentService.selectList(req);
		logger.info("===step2:【不分页查询附件列表】(AttachmentController-selectList)-不分页查询附件列表, list.size:{}", list == null ? null : list.size());
		List<AttachmentVo> attachmentVoList = new AttachmentVo().convertToAttachmentVoList(list);

		BaseRestMapResponse attachmentResponse = new BaseRestMapResponse();
		attachmentResponse.put(PageConstants.DATA_LIST, attachmentVoList);
		logger.info("===step3:【不分页查询附件列表】(AttachmentController-selectList)-返回信息, attachmentResponse:{}", attachmentResponse);
		return attachmentResponse;
	}

	/**
	 * 据id查询附件
	 * @param attachmentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询附件")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer attachmentId) {
		logger.info("===step1:【据id查询附件】(selectById-selectById)-传入参数, attachmentId:{}", attachmentId);

		if(attachmentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "attachmentId不能为空");
		}

		Attachment attachment = attachmentService.selectById(attachmentId);
		logger.info("===step2:【据id查询附件】(AttachmentController-selectById)-根据id查询附件, attachment:{}", attachment);
		AttachmentVo attachmentVo = new AttachmentVo().convertToAttachmentVo(attachment);

		BaseRestMapResponse attachmentResponse = new BaseRestMapResponse();
		attachmentResponse.putAll((JSONObject) JSONObject.toJSON(attachmentVo));
		logger.info("===step3:【据id查询附件】(AttachmentController-selectById)-返回信息, attachmentResponse:{}", attachmentResponse);
		return attachmentResponse;
	}

	/**
	 * 添加附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加附件")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody AttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加附件】(AttachmentController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		

		Attachment attachment = req.convertToAttachment();
		int i = attachmentService.insert(attachment);
		logger.info("===step2:【添加附件】(AttachmentController-insert)-插入附件, i:{}", i);

		BaseRestMapResponse attachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加附件】(AttachmentController-insert)-返回信息, attachmentResponse:{}", attachmentResponse);
		return attachmentResponse;
	}

	/**
	 * 根据id删除附件
	 * @param attachmentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除附件")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer attachmentId) {
		logger.info("===step1:【根据id删除附件】(selectById-deleteById)-传入参数, attachmentId:{}", attachmentId);

		if(attachmentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "attachmentId不能为空");
		}

		int i = attachmentService.deleteById(attachmentId);
		logger.info("===step2:【根据id删除附件】(AttachmentController-deleteById)-根据id查询附件, i:{}", i);

		BaseRestMapResponse attachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除附件】(AttachmentController-deleteById)-返回信息, attachmentResponse:{}", attachmentResponse);
		return attachmentResponse;
	}

	/**
	 * 附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "附件")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody AttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【附件】(AttachmentController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		

		Integer attachmentId = req.getAttachmentId();
		Attachment attachment = req.convertToAttachment();
		attachment.setId(attachmentId);
		int i = attachmentService.modify(attachment);
		logger.info("===step2:【附件】(AttachmentController-modify)-附件, i:{}", i);

		BaseRestMapResponse attachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【附件】(AttachmentController-modify)-返回信息, attachmentResponse:{}", attachmentResponse);
		return attachmentResponse;
	}


}