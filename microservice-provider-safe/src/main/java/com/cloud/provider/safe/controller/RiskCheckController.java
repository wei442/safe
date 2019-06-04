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
import com.cloud.provider.safe.po.RiskCheck;
import com.cloud.provider.safe.rest.request.page.risk.RiskCheckPageRequest;
import com.cloud.provider.safe.rest.request.risk.RiskCheckIdsRequest;
import com.cloud.provider.safe.rest.request.risk.RiskCheckRequest;
import com.cloud.provider.safe.service.IRiskCheckService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.risk.RiskCheckVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 风险排查 RiskCheckController
 * @author wei.yong
 */
@Api(tags = "风险排查")
@RestController
@RequestMapping(value="/risk/check")
public class RiskCheckController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//风险排查Service
	@Autowired
	private IRiskCheckService riskCheckService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询风险排查列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody RiskCheckPageRequest req) {
		logger.info("===step1:【分页查询风险排查列表】(RiskCheckController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<RiskCheck> list = riskCheckService.selectListByPage(page, req);
		logger.info("===step2:【分页查询风险排查列表】(RiskCheckController-selectListByPage)-分页查询风险排查列表, list.size:{}", list == null ? null : list.size());
		List<RiskCheckVo> dataList = new RiskCheckVo().convertToRiskCheckVoList(list);

		BaseRestMapResponse riskCheckResponse = new BaseRestMapResponse();
		riskCheckResponse.put(PageConstants.PAGE, PageHelperUtil.INSTANCE.getPageVo(list));
		riskCheckResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【分页查询风险排查列表】(RiskCheckController-selectListByPage)-返回信息, riskCheckResponse:{}", riskCheckResponse);
		return riskCheckResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询风险排查")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody RiskCheckPageRequest req) {
		logger.info("===step1:【不分页查询风险排查列表】(RiskCheckController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<RiskCheck> list = riskCheckService.selectList(req);
		logger.info("===step2:【不分页查询风险排查列表】(RiskCheckController-selectList)-不分页查询风险排查列表, list.size:{}", list == null ? null : list.size());
		List<RiskCheckVo> dataList = new RiskCheckVo().convertToRiskCheckVoList(list);

		BaseRestMapResponse riskCheckResponse = new BaseRestMapResponse();
		riskCheckResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【不分页查询风险排查列表】(RiskCheckController-selectList)-返回信息, riskCheckResponse:{}", riskCheckResponse);
		return riskCheckResponse;
	}

	/**
	 * 据id查询风险排查
	 * @param riskCheckId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询风险排查")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer riskCheckId) {
		logger.info("===step1:【据id查询风险排查】(RiskCheckController-selectById)-传入参数, riskCheckId:{}", riskCheckId);

		if(riskCheckId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "riskCheckId不能为空");
		}

		RiskCheck riskCheck = riskCheckService.selectById(riskCheckId);
		logger.info("===step2:【据id查询风险排查】(RiskCheckController-selectById)-根据id查询风险排查, riskCheck:{}", riskCheck);
		if(riskCheck == null) {
			return new BaseRestMapResponse(SafeResultEnum.DATABASE_NOTEXIST);
		}
		RiskCheckVo riskCheckVo = new RiskCheckVo().convertToRiskCheckVo(riskCheck);

		BaseRestMapResponse riskCheckResponse = new BaseRestMapResponse();
		riskCheckResponse.putAll((JSONObject) JSONObject.toJSON(riskCheckVo));
		logger.info("===step3:【据id查询风险排查】(RiskCheckController-selectById)-返回信息, riskCheckResponse:{}", riskCheckResponse);
		return riskCheckResponse;
	}

	/**
	 * 添加风险排查
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加风险排查")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody RiskCheckRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加风险排查】(RiskCheckController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		RiskCheck riskCheck = req.convertToRiskCheck();
		int i = riskCheckService.insert(riskCheck);
		logger.info("===step2:【添加风险排查】(RiskCheckController-insert)-插入风险排查, i:{}", i);

		BaseRestMapResponse riskCheckResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加风险排查】(RiskCheckController-insert)-返回信息, riskCheckResponse:{}", riskCheckResponse);
		return riskCheckResponse;
	}

	/**
	 * 根据id删除风险排查
	 * @param riskCheckId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除风险排查")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer riskCheckId) {
		logger.info("===step1:【根据id删除风险排查】(RiskCheckController-deleteById)-传入参数, riskCheckId:{}", riskCheckId);

		if(riskCheckId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "riskCheckId不能为空");
		}

		int i = riskCheckService.deleteById(riskCheckId);
		logger.info("===step2:【根据id删除风险排查】(RiskCheckController-deleteById)-根据id删除风险排查, i:{}", i);

		BaseRestMapResponse riskCheckResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除风险排查】(RiskCheckController-deleteById)-返回信息, riskCheckResponse:{}", riskCheckResponse);
		return riskCheckResponse;
	}

	/**
	 * 批量删除风险排查
	 * @param riskCheckIds
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "批量删除风险排查")
	@RequestMapping(value="/batchDelete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse batchDelete(
		@Validated @RequestBody RiskCheckIdsRequest req) {
		logger.info("===step1:【批量删除风险排查】(RiskCheckController-batchDelete)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		List<Integer> riskCheckIds = req.getRiskCheckIds();
		int i = riskCheckService.deleteByIds(riskCheckIds);
		logger.info("===step2:【批量删除风险排查】(RiskCheckController-batchDelete)-根据riskCheckIds删除风险排查, i:{}", i);

		BaseRestMapResponse riskCheckResponse = new BaseRestMapResponse();
		logger.info("===step3:【批量删除风险排查】(RiskCheckController-batchDelete)-返回信息, riskCheckResponse:{}", riskCheckResponse);
		return riskCheckResponse;
	}

	/**
	 * 修改风险排查
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改风险排查")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody RiskCheckRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改风险排查】(RiskCheckController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer riskCheckId = req.getRiskCheckId();
		RiskCheck riskCheck = req.convertToRiskCheck();
		riskCheck.setId(riskCheckId);
		int i = riskCheckService.modify(riskCheck);
		logger.info("===step2:【修改风险排查】(RiskCheckController-modify)-修改风险排查, i:{}", i);

		BaseRestMapResponse riskCheckResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改风险排查】(RiskCheckController-modify)-返回信息, riskCheckResponse:{}", riskCheckResponse);
		return riskCheckResponse;
	}

}