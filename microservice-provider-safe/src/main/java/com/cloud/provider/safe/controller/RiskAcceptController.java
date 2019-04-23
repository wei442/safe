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
import com.cloud.provider.safe.po.RiskAccept;
import com.cloud.provider.safe.rest.request.page.risk.RiskAcceptPageRequest;
import com.cloud.provider.safe.rest.request.risk.RiskAcceptRequest;
import com.cloud.provider.safe.service.IRiskAcceptService;
import com.cloud.provider.safe.util.Assert;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.risk.RiskAcceptVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 风险验收 RiskAcceptController
 * @author wei.yong
 */
@Api(tags = "风险验收")
@RestController
@RequestMapping(value="/risk/accept")
public class RiskAcceptController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//风险验收Service
	@Autowired
	private IRiskAcceptService riskAcceptService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询风险验收列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody RiskAcceptPageRequest req) {
		logger.info("===step1:【分页查询风险验收列表】(RiskAcceptController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<RiskAccept> list = riskAcceptService.selectListByPage(page, req);
		logger.info("===step2:【分页查询风险验收列表】(RiskAcceptController-selectListByPage)-分页查询风险验收列表, list.size:{}", list == null ? null : list.size());
		List<RiskAcceptVo> riskAcceptVoList = new RiskAcceptVo().convertToRiskAcceptVoList(list);

		BaseRestMapResponse riskAcceptResponse = new BaseRestMapResponse();
		riskAcceptResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(riskAcceptVoList));
		logger.info("===step3:【分页查询风险验收列表】(RiskAcceptController-selectListByPage)-返回信息, riskAcceptResponse:{}", riskAcceptResponse);
		return riskAcceptResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询风险验收")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody RiskAcceptPageRequest req) {
		logger.info("===step1:【不分页查询风险验收列表】(RiskAcceptController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<RiskAccept> list = riskAcceptService.selectList(req);
		logger.info("===step2:【不分页查询风险验收列表】(RiskAcceptController-selectList)-不分页查询风险验收列表, list.size:{}", list == null ? null : list.size());
		List<RiskAcceptVo> riskAcceptVoList = new RiskAcceptVo().convertToRiskAcceptVoList(list);

		BaseRestMapResponse riskAcceptResponse = new BaseRestMapResponse();
		riskAcceptResponse.put(PageConstants.DATA_LIST, riskAcceptVoList);
		logger.info("===step3:【不分页查询风险验收列表】(RiskAcceptController-selectList)-返回信息, riskAcceptResponse:{}", riskAcceptResponse);
		return riskAcceptResponse;
	}

	/**
	 * 据id查询风险验收
	 * @param riskAcceptId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询风险验收")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer riskAcceptId) {
		logger.info("===step1:【据id查询风险验收】(RiskAcceptController-selectById)-传入参数, riskAcceptId:{}", riskAcceptId);

		if(riskAcceptId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "riskAcceptId不能为空");
		}

		RiskAccept riskAccept = riskAcceptService.selectById(riskAcceptId);
		Assert.thanOrEqualZreo(riskAccept, SafeResultEnum.DATABASE_NOTEXIST);
		logger.info("===step2:【据id查询风险验收】(RiskAcceptController-selectById)-根据id查询风险验收, riskAccept:{}", riskAccept);
		RiskAcceptVo riskAcceptVo = new RiskAcceptVo().convertToRiskAcceptVo(riskAccept);

		BaseRestMapResponse riskAcceptResponse = new BaseRestMapResponse();
		riskAcceptResponse.putAll((JSONObject) JSONObject.toJSON(riskAcceptVo));
		logger.info("===step3:【据id查询风险验收】(RiskAcceptController-selectById)-返回信息, riskAcceptResponse:{}", riskAcceptResponse);
		return riskAcceptResponse;
	}

	/**
	 * 添加风险验收
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加风险验收")
	@RequestMapping(value="/insertRiskAccept",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody RiskAcceptRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加风险验收】(RiskAcceptController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		RiskAccept riskAccept = req.convertToRiskAccept();
		int i = riskAcceptService.insert(riskAccept);
		logger.info("===step2:【添加风险验收】(RiskAcceptController-insert)-插入风险验收, i:{}", i);

		BaseRestMapResponse riskAcceptResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加风险验收】(RiskAcceptController-insert)-返回信息, riskAcceptResponse:{}", riskAcceptResponse);
		return riskAcceptResponse;
	}

	/**
	 * 根据id删除风险验收
	 * @param riskAcceptId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除风险验收")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer riskAcceptId) {
		logger.info("===step1:【根据id删除风险验收】(RiskAcceptController-deleteById)-传入参数, riskAcceptId:{}", riskAcceptId);

		if(riskAcceptId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "riskAcceptId不能为空");
		}

		int i = riskAcceptService.deleteById(riskAcceptId);
		logger.info("===step2:【根据id删除风险验收】(RiskAcceptController-deleteById)-根据id删除风险验收, i:{}", i);

		BaseRestMapResponse riskAcceptResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除风险验收】(RiskAcceptController-deleteById)-返回信息, riskAcceptResponse:{}", riskAcceptResponse);
		return riskAcceptResponse;
	}

	/**
	 * 根据ids删除风险验收
	 * @param riskAcceptIds
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据ids删除风险验收")
	@RequestMapping(value="/deleteByIds/{ids}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteByIds(
		@PathVariable(value="ids",required=false) List<Integer> riskAcceptIds) {
		logger.info("===step1:【根据ids删除风险验收】(RiskAcceptController-deleteByIds)-传入参数, riskAcceptIds:{}", riskAcceptIds);

		if(riskAcceptIds == null || riskAcceptIds.isEmpty()) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "riskAcceptIds不能为空");
		}

		int i = riskAcceptService.deleteByIds(riskAcceptIds);
		logger.info("===step2:【根据ids删除风险验收】(RiskAcceptController-deleteByIds)-根据ids删除风险验收, i:{}", i);

		BaseRestMapResponse riskAcceptResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据ids删除风险验收】(RiskAcceptController-deleteByIds)-返回信息, riskAcceptResponse:{}", riskAcceptResponse);
		return riskAcceptResponse;
	}

	/**
	 * 修改风险验收
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改风险验收")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody RiskAcceptRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改风险验收】(RiskAcceptController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer riskAcceptId = req.getRiskAcceptId();
		RiskAccept riskAccept = req.convertToRiskAccept();
		riskAccept.setId(riskAcceptId);
		int i = riskAcceptService.modify(riskAccept);
		logger.info("===step2:【修改风险验收】(RiskAcceptController-modify)-修改风险验收, i:{}", i);

		BaseRestMapResponse riskAcceptResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改风险验收】(RiskAcceptController-modify)-返回信息, riskAcceptResponse:{}", riskAcceptResponse);
		return riskAcceptResponse;
	}

}