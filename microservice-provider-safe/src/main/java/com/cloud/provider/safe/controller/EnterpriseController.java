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
import com.cloud.provider.safe.po.Enterprise;
import com.cloud.provider.safe.rest.request.enterprise.EnterpriseRequest;
import com.cloud.provider.safe.rest.request.page.enterprise.EnterprisePageRequest;
import com.cloud.provider.safe.service.IEnterpriseService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.enterprise.EnterpriseVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 企业 EnterpriseController
 * @author wei.yong
 */
@Api(tags = "企业")
@RestController
@RequestMapping(value="/enterprise")
public class EnterpriseController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//企业Service
	@Autowired
	private IEnterpriseService enterpriseService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询企业列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody EnterprisePageRequest req) {
		logger.info("===step1:【分页查询企业列表】(EnterpriseController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<Enterprise> list = enterpriseService.selectListByPage(page, req);
		logger.info("===step2:【分页查询企业列表】(EnterpriseController-selectListByPage)-分页查询企业列表, list.size:{}", list == null ? null : list.size());
		List<EnterpriseVo> enterpriseVoList = new EnterpriseVo().convertToEnterpriseVoList(list);

		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		enterpriseResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(enterpriseVoList));
		logger.info("===step3:【分页查询企业列表】(EnterpriseController-selectListByPage)-返回信息, enterpriseResponse:{}", enterpriseResponse);
		return enterpriseResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询企业列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody EnterprisePageRequest req) {
		logger.info("===step1:【不分页查询企业列表】(EnterpriseController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<Enterprise> list = enterpriseService.selectList(req);
		logger.info("===step2:【不分页查询企业列表】(EnterpriseController-selectList)-不分页查询企业列表, list.size:{}", list == null ? null : list.size());
		List<EnterpriseVo> enterpriseVoList = new EnterpriseVo().convertToEnterpriseVoList(list);

		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		enterpriseResponse.put(PageConstants.DATA_LIST, enterpriseVoList);
		logger.info("===step3:【不分页查询企业列表】(EnterpriseController-selectList)-返回信息, enterpriseResponse:{}", enterpriseResponse);
		return enterpriseResponse;
	}

	/**
	 * 据id查询企业
	 * @param enterpriseId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询企业")
	@ApiParam(name="id", value="企业id", required=true)
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer enterpriseId) {
		logger.info("===step1:【据id查询企业】(EnterpriseController-selectById)-传入参数, enterpriseId:{}", enterpriseId);

		if(enterpriseId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "enterpriseId不能为空");
		}

		Enterprise enterprise = enterpriseService.selectById(enterpriseId);
		logger.info("===step2:【据id查询企业】(EnterpriseController-selectById)-根据id查询企业, enterprise:{}", enterprise);
		EnterpriseVo enterpriseVo = new EnterpriseVo().convertToEnterpriseVo(enterprise);

		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		enterpriseResponse.putAll((JSONObject) JSONObject.toJSON(enterpriseVo));
		logger.info("===step3:【据id查询企业】(EnterpriseController-selectById)-返回信息, enterpriseResponse:{}", enterpriseResponse);
		return enterpriseResponse;
	}

	/**
	 * 添加企业
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加企业")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody EnterpriseRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加企业】(EnterpriseController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));



		Enterprise enterprise = req.convertToEnterprise();
		int i = enterpriseService.insert(enterprise);
		logger.info("===step2:【添加企业】(EnterpriseController-insert)-插入企业, i:{}", i);

		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加企业】(EnterpriseController-insert)-返回信息, enterpriseResponse:{}", enterpriseResponse);
		return enterpriseResponse;
	}

	/**
	 * 根据id删除企业
	 * @param enterpriseId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除企业")
	@ApiParam(name="id", value="企业id", required=true)
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer enterpriseId) {
		logger.info("===step1:【根据id删除企业】(selectById-deleteById)-传入参数, enterpriseId:{}", enterpriseId);

		if(enterpriseId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "enterpriseId不能为空");
		}

		int i = enterpriseService.deleteById(enterpriseId);
		logger.info("===step2:【根据id删除企业】(EnterpriseController-deleteById)-根据id查询企业, i:{}", i);

		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除企业】(EnterpriseController-deleteById)-返回信息, enterpriseResponse:{}", enterpriseResponse);
		return enterpriseResponse;
	}

	/**
	 * 修改企业
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改企业")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody EnterpriseRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改企业】(EnterpriseController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));



		Integer enterpriseId = req.getEnterpriseId();
		Enterprise enterprise = req.convertToEnterprise();
		enterprise.setId(enterpriseId);
		int i = enterpriseService.modify(enterprise);
		logger.info("===step2:【修改企业】(EnterpriseController-modify)-修改企业, i:{}", i);

		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改企业】(EnterpriseController-modify)-返回信息, enterpriseResponse:{}", enterpriseResponse);
		return enterpriseResponse;
	}


}