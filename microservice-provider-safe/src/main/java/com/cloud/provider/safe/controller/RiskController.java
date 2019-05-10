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
import com.cloud.provider.safe.po.Risk;
import com.cloud.provider.safe.rest.request.page.risk.RiskPageRequest;
import com.cloud.provider.safe.rest.request.risk.RiskIdsRequest;
import com.cloud.provider.safe.rest.request.risk.RiskRequest;
import com.cloud.provider.safe.service.IRiskService;
import com.cloud.provider.safe.util.Assert;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.risk.RiskVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 风险 RiskController
 * @author wei.yong
 */
@Api(tags = "风险")
@RestController
@RequestMapping(value="/risk")
public class RiskController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//风险Service
	@Autowired
	private IRiskService riskService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询风险列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody RiskPageRequest req) {
		logger.info("===step1:【分页查询风险列表】(RiskController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<Risk> list = riskService.selectListByPage(page, req);
		logger.info("===step2:【分页查询风险列表】(RiskController-selectListByPage)-分页查询风险列表, list.size:{}", list == null ? null : list.size());
		List<RiskVo> riskVoList = new RiskVo().convertToRiskVoList(list);

		BaseRestMapResponse riskResponse = new BaseRestMapResponse();
		riskResponse.put(PageConstants.PAGE, PageHelperUtil.INSTANCE.getPageVo(list));
		riskResponse.put(PageConstants.DATA_LIST, riskVoList);
		logger.info("===step3:【分页查询风险列表】(RiskController-selectListByPage)-返回信息, riskResponse:{}", riskResponse);
		return riskResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询风险")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody RiskPageRequest req) {
		logger.info("===step1:【不分页查询风险列表】(RiskController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<Risk> list = riskService.selectList(req);
		logger.info("===step2:【不分页查询风险列表】(RiskController-selectList)-不分页查询风险列表, list.size:{}", list == null ? null : list.size());
		List<RiskVo> riskVoList = new RiskVo().convertToRiskVoList(list);

		BaseRestMapResponse riskResponse = new BaseRestMapResponse();
		riskResponse.put(PageConstants.DATA_LIST, riskVoList);
		logger.info("===step3:【不分页查询风险列表】(RiskController-selectList)-返回信息, riskResponse:{}", riskResponse);
		return riskResponse;
	}

	/**
	 * 据id查询风险
	 * @param riskId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询风险")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer riskId) {
		logger.info("===step1:【据id查询风险】(RiskController-selectById)-传入参数, riskId:{}", riskId);

		if(riskId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "riskId不能为空");
		}

		Risk risk = riskService.selectById(riskId);
		Assert.thanOrEqualZreo(risk, SafeResultEnum.DATABASE_NOTEXIST);
		logger.info("===step2:【据id查询风险】(RiskController-selectById)-根据id查询风险, risk:{}", risk);
		RiskVo riskVo = new RiskVo().convertToRiskVo(risk);

		BaseRestMapResponse riskResponse = new BaseRestMapResponse();
		riskResponse.putAll((JSONObject) JSONObject.toJSON(riskVo));
		logger.info("===step3:【据id查询风险】(RiskController-selectById)-返回信息, riskResponse:{}", riskResponse);
		return riskResponse;
	}

	/**
	 * 添加风险
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加风险")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody RiskRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加风险】(RiskController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Risk risk = req.convertToRisk();
		int i = riskService.insert(risk);
		logger.info("===step2:【添加风险】(RiskController-insert)-插入风险, i:{}", i);

		BaseRestMapResponse riskResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加风险】(RiskController-insert)-返回信息, riskResponse:{}", riskResponse);
		return riskResponse;
	}

	/**
	 * 根据id删除风险
	 * @param riskId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除风险")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer riskId) {
		logger.info("===step1:【根据id删除风险】(RiskController-deleteById)-传入参数, riskId:{}", riskId);

		if(riskId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "riskId不能为空");
		}

		int i = riskService.deleteById(riskId);
		logger.info("===step2:【根据id删除风险】(RiskController-deleteById)-根据id删除风险, i:{}", i);

		BaseRestMapResponse riskResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除风险】(RiskController-deleteById)-返回信息, riskResponse:{}", riskResponse);
		return riskResponse;
	}

	/**
	 * 批量删除风险
	 * @param riskIds
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "批量删除风险")
	@RequestMapping(value="/batchDelete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse batchDelete(
		@Validated @RequestBody RiskIdsRequest req) {
		logger.info("===step1:【批量删除风险】(RiskController-batchDelete)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		List<Integer> riskIds = req.getRiskIds();
		int i = riskService.deleteByIds(riskIds);
		logger.info("===step2:【批量删除风险】(RiskController-batchDelete)-根据riskIds删除风险, i:{}", i);

		BaseRestMapResponse riskResponse = new BaseRestMapResponse();
		logger.info("===step3:【批量删除风险】(RiskController-batchDelete)-返回信息, riskResponse:{}", riskResponse);
		return riskResponse;
	}

	/**
	 * 修改风险
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改风险")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody RiskRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改风险】(RiskController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer riskId = req.getRiskId();
		Risk risk = req.convertToRisk();
		risk.setId(riskId);
		int i = riskService.modify(risk);
		logger.info("===step2:【修改风险】(RiskController-modify)-修改风险, i:{}", i);

		BaseRestMapResponse riskResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改风险】(RiskController-modify)-返回信息, riskResponse:{}", riskResponse);
		return riskResponse;
	}

}