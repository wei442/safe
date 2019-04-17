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
import com.cloud.provider.safe.po.Rule;
import com.cloud.provider.safe.rest.request.activity.RuleRequest;
import com.cloud.provider.safe.rest.request.page.activity.RulePageRequest;
import com.cloud.provider.safe.service.IRuleService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.activity.RuleVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 规范文件 RuleController
 * @author wei.yong
 */
@Api(tags = "规范文件")
@RestController
@RequestMapping(value="/rule")
public class RuleController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//规范文件Service
	@Autowired
	private IRuleService ruleService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询规范文件列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody RulePageRequest req) {
		logger.info("===step1:【分页查询规范文件列表】(RuleController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<Rule> list = ruleService.selectListByPage(page, req);
		logger.info("===step2:【分页查询规范文件列表】(RuleController-selectListByPage)-分页查询规范文件列表, list.size:{}", list == null ? null : list.size());
		List<RuleVo> ruleVoList = new RuleVo().convertToRuleVoList(list);

		BaseRestMapResponse ruleResponse = new BaseRestMapResponse();
		ruleResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(ruleVoList));
		logger.info("===step3:【分页查询规范文件列表】(RuleController-selectListByPage)-返回信息, ruleResponse:{}", ruleResponse);
		return ruleResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询规范文件列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody RulePageRequest req) {
		logger.info("===step1:【不分页查询规范文件列表】(RuleController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<Rule> list = ruleService.selectList(req);
		logger.info("===step2:【不分页查询规范文件列表】(RuleController-selectList)-不分页查询规范文件列表, list.size:{}", list == null ? null : list.size());
		List<RuleVo> ruleVoList = new RuleVo().convertToRuleVoList(list);

		BaseRestMapResponse ruleResponse = new BaseRestMapResponse();
		ruleResponse.put(PageConstants.DATA_LIST, ruleVoList);
		logger.info("===step3:【不分页查询规范文件列表】(RuleController-selectList)-返回信息, ruleResponse:{}", ruleResponse);
		return ruleResponse;
	}

	/**
	 * 据id查询规范文件
	 * @param ruleId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询规范文件")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer ruleId) {
		logger.info("===step1:【据id查询规范文件】(selectById-selectById)-传入参数, ruleId:{}", ruleId);

		if(ruleId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "ruleId不能为空");
		}

		Rule rule = ruleService.selectById(ruleId);
		logger.info("===step2:【据id查询规范文件】(RuleController-selectById)-根据id查询规范文件, rule:{}", rule);
		RuleVo ruleVo = new RuleVo().convertToRuleVo(rule);

		BaseRestMapResponse ruleResponse = new BaseRestMapResponse();
		ruleResponse.putAll((JSONObject) JSONObject.toJSON(ruleVo));
		logger.info("===step3:【据id查询规范文件】(RuleController-selectById)-返回信息, ruleResponse:{}", ruleResponse);
		return ruleResponse;
	}

	/**
	 * 添加规范文件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加规范文件")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody RuleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加规范文件】(RuleController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Rule rule = req.convertToRule();
		int i = ruleService.insert(rule);
		logger.info("===step2:【添加规范文件】(RuleController-insert)-插入规范文件, i:{}", i);

		BaseRestMapResponse ruleResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加规范文件】(RuleController-insert)-返回信息, ruleResponse:{}", ruleResponse);
		return ruleResponse;
	}

	/**
	 * 根据id删除规范文件
	 * @param ruleId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除规范文件")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer ruleId) {
		logger.info("===step1:【根据id删除规范文件】(RuleController-deleteById)-传入参数, ruleId:{}", ruleId);

		if(ruleId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "ruleId不能为空");
		}

		int i = ruleService.deleteById(ruleId);
		logger.info("===step2:【根据id删除规范文件】(RuleController-deleteById)-根据id删除规范文件, i:{}", i);

		BaseRestMapResponse ruleResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除规范文件】(RuleController-deleteById)-返回信息, ruleResponse:{}", ruleResponse);
		return ruleResponse;
	}

	/**
	 * 修改规范文件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改规范文件")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody RuleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改规范文件】(RuleController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer ruleId = req.getRuleId();
		Rule rule = req.convertToRule();
		rule.setId(ruleId);
		int i = ruleService.modify(rule);
		logger.info("===step2:【修改规范文件】(RuleController-modify)-修改规范文件, i:{}", i);

		BaseRestMapResponse ruleResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改规范文件】(RuleController-modify)-返回信息, ruleResponse:{}", ruleResponse);
		return ruleResponse;
	}


}