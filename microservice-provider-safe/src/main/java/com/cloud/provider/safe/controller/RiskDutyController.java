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
import com.cloud.provider.safe.po.RiskDuty;
import com.cloud.provider.safe.rest.request.page.risk.RiskDutyPageRequest;
import com.cloud.provider.safe.rest.request.risk.RiskDutyIdsRequest;
import com.cloud.provider.safe.rest.request.risk.RiskDutyRequest;
import com.cloud.provider.safe.service.IRiskDutyService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.risk.RiskDutyVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 风险责任 RiskDutyController
 * @author wei.yong
 */
@Api(tags = "风险责任")
@RestController
@RequestMapping(value="/risk/duty")
public class RiskDutyController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//风险责任Service
	@Autowired
	private IRiskDutyService riskDutyService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询风险责任列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody RiskDutyPageRequest req) {
		logger.info("===step1:【分页查询风险责任列表】(RiskDutyController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<RiskDuty> list = riskDutyService.selectListByPage(page, req);
		logger.info("===step2:【分页查询风险责任列表】(RiskDutyController-selectListByPage)-分页查询风险责任列表, list.size:{}", list == null ? null : list.size());
		List<RiskDutyVo> dataList = new RiskDutyVo().convertToRiskDutyVoList(list);

		BaseRestMapResponse riskDutyResponse = new BaseRestMapResponse();
		riskDutyResponse.put(PageConstants.PAGE, PageHelperUtil.INSTANCE.getPageVo(list));
		riskDutyResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【分页查询风险责任列表】(RiskDutyController-selectListByPage)-返回信息, riskDutyResponse:{}", riskDutyResponse);
		return riskDutyResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询风险责任")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody RiskDutyPageRequest req) {
		logger.info("===step1:【不分页查询风险责任列表】(RiskDutyController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<RiskDuty> list = riskDutyService.selectList(req);
		logger.info("===step2:【不分页查询风险责任列表】(RiskDutyController-selectList)-不分页查询风险责任列表, list.size:{}", list == null ? null : list.size());
		List<RiskDutyVo> riskDutyVoList = new RiskDutyVo().convertToRiskDutyVoList(list);

		BaseRestMapResponse riskDutyResponse = new BaseRestMapResponse();
		riskDutyResponse.put(PageConstants.DATA_LIST, riskDutyVoList);
		logger.info("===step3:【不分页查询风险责任列表】(RiskDutyController-selectList)-返回信息, riskDutyResponse:{}", riskDutyResponse);
		return riskDutyResponse;
	}

	/**
	 * 据id查询风险责任
	 * @param riskDutyId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询风险责任")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer riskDutyId) {
		logger.info("===step1:【据id查询风险责任】(RiskDutyController-selectById)-传入参数, riskDutyId:{}", riskDutyId);

		if(riskDutyId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "riskDutyId不能为空");
		}

		RiskDuty riskDuty = riskDutyService.selectById(riskDutyId);
		logger.info("===step2:【据id查询风险责任】(RiskDutyController-selectById)-根据id查询风险责任, riskDuty:{}", riskDuty);
		if(riskDuty == null) {
			return new BaseRestMapResponse(SafeResultEnum.DATABASE_NOTEXIST);
		}
		RiskDutyVo riskDutyVo = new RiskDutyVo().convertToRiskDutyVo(riskDuty);

		BaseRestMapResponse riskDutyResponse = new BaseRestMapResponse();
		riskDutyResponse.putAll((JSONObject) JSONObject.toJSON(riskDutyVo));
		logger.info("===step3:【据id查询风险责任】(RiskDutyController-selectById)-返回信息, riskDutyResponse:{}", riskDutyResponse);
		return riskDutyResponse;
	}

	/**
	 * 添加风险责任
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加风险责任")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody RiskDutyRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加风险责任】(RiskDutyController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		RiskDuty riskDuty = req.convertToRiskDuty();
		int i = riskDutyService.insert(riskDuty);
		logger.info("===step2:【添加风险责任】(RiskDutyController-insert)-插入风险责任, i:{}", i);

		BaseRestMapResponse riskDutyResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加风险责任】(RiskDutyController-insert)-返回信息, riskDutyResponse:{}", riskDutyResponse);
		return riskDutyResponse;
	}

	/**
	 * 根据id删除风险责任
	 * @param riskDutyId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除风险责任")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer riskDutyId) {
		logger.info("===step1:【根据id删除风险责任】(RiskDutyController-deleteById)-传入参数, riskDutyId:{}", riskDutyId);

		if(riskDutyId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "riskDutyId不能为空");
		}

		int i = riskDutyService.deleteById(riskDutyId);
		logger.info("===step2:【根据id删除风险责任】(RiskDutyController-deleteById)-根据id删除风险责任, i:{}", i);

		BaseRestMapResponse riskDutyResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除风险责任】(RiskDutyController-deleteById)-返回信息, riskDutyResponse:{}", riskDutyResponse);
		return riskDutyResponse;
	}

	/**
	 * 批量删除风险责任
	 * @param riskDutyIds
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "批量删除风险责任")
	@RequestMapping(value="/batchDelete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse batchDelete(
		@Validated @RequestBody RiskDutyIdsRequest req) {
		logger.info("===step1:【批量删除风险责任】(RiskDutyController-batchDelete)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		List<Integer> riskDutyIds = req.getRiskDutyIds();
		int i = riskDutyService.deleteByIds(riskDutyIds);
		logger.info("===step2:【批量删除风险责任】(RiskDutyController-batchDelete)-根据riskDutyIds删除风险责任, i:{}", i);

		BaseRestMapResponse riskDutyResponse = new BaseRestMapResponse();
		logger.info("===step3:【批量删除风险责任】(RiskDutyController-batchDelete)-返回信息, riskDutyResponse:{}", riskDutyResponse);
		return riskDutyResponse;
	}

	/**
	 * 修改风险责任
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改风险责任")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody RiskDutyRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改风险责任】(RiskDutyController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer riskDutyId = req.getRiskDutyId();
		RiskDuty riskDuty = req.convertToRiskDuty();
		riskDuty.setId(riskDutyId);
		int i = riskDutyService.modify(riskDuty);
		logger.info("===step2:【修改风险责任】(RiskDutyController-modify)-修改风险责任, i:{}", i);

		BaseRestMapResponse riskDutyResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改风险责任】(RiskDutyController-modify)-返回信息, riskDutyResponse:{}", riskDutyResponse);
		return riskDutyResponse;
	}

}