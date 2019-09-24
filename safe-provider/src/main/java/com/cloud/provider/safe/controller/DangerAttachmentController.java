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
import com.cloud.provider.safe.po.DangerAttachment;
import com.cloud.provider.safe.rest.request.danger.DangerAttachmentRequest;
import com.cloud.provider.safe.rest.request.page.danger.DangerAttachmentPageRequest;
import com.cloud.provider.safe.service.IDangerAttachmentService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.danger.DangerAttachmentVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 隐患附件 DangerAttachmentController
 * @author wei.yong
 */
@Api(tags = "隐患附件")
@RestController
@RequestMapping(value="/danger/attachment")
public class DangerAttachmentController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//隐患附件Service
	@Autowired
	private IDangerAttachmentService dangerAttachmentService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询隐患附件列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody DangerAttachmentPageRequest req) {
		logger.info("===step1:【分页查询隐患附件列表】(DangerAttachmentController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<DangerAttachment> list = dangerAttachmentService.selectListByPage(page, req);
		logger.info("===step2:【分页查询隐患附件列表】(DangerAttachmentController-selectListByPage)-分页查询隐患附件列表, list.size:{}", list == null ? null : list.size());
		List<DangerAttachmentVo> dataList = new DangerAttachmentVo().convertToDangerAttachmentVoList(list);

		BaseRestMapResponse dangerAttachmentResponse = new BaseRestMapResponse();
		dangerAttachmentResponse.put(PageConstants.PAGE, PageHelperUtil.INSTANCE.getPageVo(list));
		dangerAttachmentResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【分页查询隐患附件列表】(DangerAttachmentController-selectListByPage)-返回信息, dangerAttachmentResponse:{}", dangerAttachmentResponse);
		return dangerAttachmentResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询隐患附件列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody DangerAttachmentPageRequest req) {
		logger.info("===step1:【不分页查询隐患附件列表】(DangerAttachmentController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<DangerAttachment> list = dangerAttachmentService.selectList(req);
		logger.info("===step2:【不分页查询隐患附件列表】(DangerAttachmentController-selectList)-不分页查询隐患附件列表, list.size:{}", list == null ? null : list.size());
		List<DangerAttachmentVo> dataList = new DangerAttachmentVo().convertToDangerAttachmentVoList(list);

		BaseRestMapResponse dangerAttachmentResponse = new BaseRestMapResponse();
		dangerAttachmentResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【不分页查询隐患附件列表】(DangerAttachmentController-selectList)-返回信息, dangerAttachmentResponse:{}", dangerAttachmentResponse);
		return dangerAttachmentResponse;
	}

	/**
	 * 据id查询隐患附件
	 * @param dangerAttachmentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询隐患附件")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer dangerAttachmentId) {
		logger.info("===step1:【据id查询隐患附件】(DangerAttachmentController-selectById)-传入参数, dangerAttachmentId:{}", dangerAttachmentId);

		if(dangerAttachmentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "dangerAttachmentId不能为空");
		}

		DangerAttachment dangerAttachment = dangerAttachmentService.selectById(dangerAttachmentId);
		logger.info("===step2:【据id查询隐患附件】(DangerAttachmentController-selectById)-根据id查询隐患附件, dangerAttachment:{}", dangerAttachment);
		if(dangerAttachment == null) {
			return new BaseRestMapResponse(SafeResultEnum.DATABASE_NOTEXIST);
		}
		DangerAttachmentVo dangerAttachmentVo = new DangerAttachmentVo().convertToDangerAttachmentVo(dangerAttachment);

		BaseRestMapResponse dangerAttachmentResponse = new BaseRestMapResponse();
		dangerAttachmentResponse.putAll((JSONObject) JSONObject.toJSON(dangerAttachmentVo));
		logger.info("===step3:【据id查询隐患附件】(DangerAttachmentController-selectById)-返回信息, dangerAttachmentResponse:{}", dangerAttachmentResponse);
		return dangerAttachmentResponse;
	}

	/**
	 * 添加隐患附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加隐患附件")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody DangerAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加隐患附件】(DangerAttachmentController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		DangerAttachment dangerAttachment = req.convertToDangerAttachment();
		int i = dangerAttachmentService.insert(dangerAttachment);
		logger.info("===step2:【添加隐患附件】(DangerAttachmentController-insert)-插入隐患附件, i:{}", i);

		BaseRestMapResponse dangerAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加隐患附件】(DangerAttachmentController-insert)-返回信息, dangerAttachmentResponse:{}", dangerAttachmentResponse);
		return dangerAttachmentResponse;
	}

	/**
	 * 根据id删除隐患附件
	 * @param dangerAttachmentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除隐患附件")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer dangerAttachmentId) {
		logger.info("===step1:【根据id删除隐患附件】(selectById-deleteById)-传入参数, dangerAttachmentId:{}", dangerAttachmentId);

		if(dangerAttachmentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "dangerAttachmentId不能为空");
		}

		int i = dangerAttachmentService.deleteById(dangerAttachmentId);
		logger.info("===step2:【根据id删除隐患附件】(DangerAttachmentController-deleteById)-根据id查询隐患附件, i:{}", i);

		BaseRestMapResponse dangerAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除隐患附件】(DangerAttachmentController-deleteById)-返回信息, dangerAttachmentResponse:{}", dangerAttachmentResponse);
		return dangerAttachmentResponse;
	}

	/**
	 * 修改隐患附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改隐患附件")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody DangerAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改隐患附件】(DangerAttachmentController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer dangerAttachmentId = req.getDangerAttachmentId();
		DangerAttachment dangerAttachment = req.convertToDangerAttachment();
		dangerAttachment.setId(dangerAttachmentId);
		int i = dangerAttachmentService.modify(dangerAttachment);
		logger.info("===step2:【修改隐患附件】(DangerAttachmentController-modify)-修改隐患附件, i:{}", i);

		BaseRestMapResponse dangerAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改隐患附件】(DangerAttachmentController-modify)-返回信息, dangerAttachmentResponse:{}", dangerAttachmentResponse);
		return dangerAttachmentResponse;
	}

}