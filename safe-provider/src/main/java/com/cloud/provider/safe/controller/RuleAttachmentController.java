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
import com.cloud.provider.safe.po.RuleAttachment;
import com.cloud.provider.safe.rest.request.activity.RuleAttachmentRequest;
import com.cloud.provider.safe.rest.request.page.activity.RuleAttachmentPageRequest;
import com.cloud.provider.safe.service.IRuleAttachmentService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.activity.RuleAttachmentVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 规范文件附件 RuleAttachmentController
 * @author wei.yong
 */
@Api(tags = "规范文件附件")
@RestController
@RequestMapping(value="/rule/attachment")
public class RuleAttachmentController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//规范文件附件Service
	@Autowired
	private IRuleAttachmentService ruleAttachmentService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询规范文件附件列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody RuleAttachmentPageRequest req) {
		logger.info("===step1:【分页查询规范文件附件列表】(RuleAttachmentController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<RuleAttachment> list = ruleAttachmentService.selectListByPage(page, req);
		logger.info("===step2:【分页查询规范文件附件列表】(RuleAttachmentController-selectListByPage)-分页查询规范文件附件列表, list.size:{}", list == null ? null : list.size());
		List<RuleAttachmentVo> dataList = new RuleAttachmentVo().convertToRuleAttachmentVoList(list);

		BaseRestMapResponse ruleAttachmentResponse = new BaseRestMapResponse();
		ruleAttachmentResponse.put(PageConstants.PAGE, PageHelperUtil.INSTANCE.getPageVo(list));
		ruleAttachmentResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【分页查询规范文件附件列表】(RuleAttachmentController-selectListByPage)-返回信息, ruleAttachmentResponse:{}", ruleAttachmentResponse);
		return ruleAttachmentResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询规范文件附件列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody RuleAttachmentPageRequest req) {
		logger.info("===step1:【不分页查询规范文件附件列表】(RuleAttachmentController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<RuleAttachment> list = ruleAttachmentService.selectList(req);
		logger.info("===step2:【不分页查询规范文件附件列表】(RuleAttachmentController-selectList)-不分页查询规范文件附件列表, list.size:{}", list == null ? null : list.size());
		List<RuleAttachmentVo> dataList = new RuleAttachmentVo().convertToRuleAttachmentVoList(list);

		BaseRestMapResponse ruleAttachmentResponse = new BaseRestMapResponse();
		ruleAttachmentResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【不分页查询规范文件附件列表】(RuleAttachmentController-selectList)-返回信息, ruleAttachmentResponse:{}", ruleAttachmentResponse);
		return ruleAttachmentResponse;
	}

	/**
	 * 据id查询规范文件附件
	 * @param ruleAttachmentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询规范文件附件")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer ruleAttachmentId) {
		logger.info("===step1:【据id查询规范文件附件】(RuleAttachmentController-selectById)-传入参数, ruleAttachmentId:{}", ruleAttachmentId);

		if(ruleAttachmentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "ruleAttachmentId不能为空");
		}

		RuleAttachment ruleAttachment = ruleAttachmentService.selectById(ruleAttachmentId);
		logger.info("===step2:【据id查询规范文件附件】(RuleAttachmentController-selectById)-根据id查询规范文件附件, ruleAttachment:{}", ruleAttachment);
		if(ruleAttachment == null) {
			return new BaseRestMapResponse(SafeResultEnum.DATABASE_NOTEXIST);
		}
		RuleAttachmentVo ruleAttachmentVo = new RuleAttachmentVo().convertToRuleAttachmentVo(ruleAttachment);

		BaseRestMapResponse ruleAttachmentResponse = new BaseRestMapResponse();
		ruleAttachmentResponse.putAll((JSONObject) JSONObject.toJSON(ruleAttachmentVo));
		logger.info("===step3:【据id查询规范文件附件】(RuleAttachmentController-selectById)-返回信息, ruleAttachmentResponse:{}", ruleAttachmentResponse);
		return ruleAttachmentResponse;
	}

	/**
	 * 添加规范文件附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加规范文件附件")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody RuleAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加规范文件附件】(RuleAttachmentController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		RuleAttachment ruleAttachment = req.convertToRuleAttachment();
		int i = ruleAttachmentService.insert(ruleAttachment);
		logger.info("===step2:【添加规范文件附件】(RuleAttachmentController-insert)-插入规范文件附件, i:{}", i);

		BaseRestMapResponse ruleAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加规范文件附件】(RuleAttachmentController-insert)-返回信息, ruleAttachmentResponse:{}", ruleAttachmentResponse);
		return ruleAttachmentResponse;
	}

	/**
	 * 根据id删除规范文件附件
	 * @param ruleAttachmentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除规范文件附件")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer ruleAttachmentId) {
		logger.info("===step1:【根据id删除规范文件附件】(selectById-deleteById)-传入参数, ruleAttachmentId:{}", ruleAttachmentId);

		if(ruleAttachmentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "ruleAttachmentId不能为空");
		}

		int i = ruleAttachmentService.deleteById(ruleAttachmentId);
		logger.info("===step2:【根据id删除规范文件附件】(RuleAttachmentController-deleteById)-根据id查询规范文件附件, i:{}", i);

		BaseRestMapResponse ruleAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除规范文件附件】(RuleAttachmentController-deleteById)-返回信息, ruleAttachmentResponse:{}", ruleAttachmentResponse);
		return ruleAttachmentResponse;
	}

	/**
	 * 修改规范文件附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改规范文件附件")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody RuleAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改规范文件附件】(RuleAttachmentController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer ruleAttachmentId = req.getRuleAttachmentId();
		RuleAttachment ruleAttachment = req.convertToRuleAttachment();
		ruleAttachment.setId(ruleAttachmentId);
		int i = ruleAttachmentService.modify(ruleAttachment);
		logger.info("===step2:【修改规范文件附件】(RuleAttachmentController-modify)-修改规范文件附件, i:{}", i);

		BaseRestMapResponse ruleAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改规范文件附件】(RuleAttachmentController-modify)-返回信息, ruleAttachmentResponse:{}", ruleAttachmentResponse);
		return ruleAttachmentResponse;
	}

}