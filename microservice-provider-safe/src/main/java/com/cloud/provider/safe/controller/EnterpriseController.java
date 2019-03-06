package com.cloud.provider.safe.controller;

import java.util.List;
import java.util.Map;

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
import com.cloud.provider.safe.rest.request.EnterpriseRequest;
import com.cloud.provider.safe.service.IEnterpriseService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.EnterpriseVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 资质 EnterpriseController
 * @author wei.yong
 */
@Api(tags = "资质")
@RestController
@RequestMapping(value="/enterprise")
public class EnterpriseController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//资质Service
	@Autowired
	private IEnterpriseService enterpriseService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询资质列表")
	@RequestMapping(value="/selectEnterpriseListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectEnterpriseListByPage(
		@RequestBody EnterpriseRequest req) {
		logger.info("===step1:【分页查询资质列表】(EnterpriseController-selectEnterpriseListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Enterprise enterprise = new Enterprise();
		Page<?> page = new Page<>(pageNum, pageSize);
		List<Enterprise> list = enterpriseService.selectEnterpriseListByPage(page, enterprise);
		logger.info("===step2:【分页查询资质列表】(EnterpriseController-selectEnterpriseListByPage)-分页查询资质列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}

		Map<String, Object> pageListMap = PageHelperUtil.INSTANCE.getPageListMap(list);
		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		enterpriseResponse.putAll(pageListMap);
		logger.info("===step3:【分页查询资质列表】(EnterpriseController-selectEnterpriseListByPage)-返回信息, enterpriseResponse:{}", enterpriseResponse);
		return enterpriseResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询资质列表")
	@RequestMapping(value="/selectEnterpriseList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectEnterpriseList(
		@RequestBody EnterpriseRequest req) {
		logger.info("===step1:【不分页查询资质列表】(EnterpriseController-selectEnterpriseList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Enterprise enterprise = new Enterprise();
		List<Enterprise> list = null;
		list = enterpriseService.selectEnterpriseList(enterprise);
		logger.info("===step2:【不分页查询资质列表】(EnterpriseController-selectEnterpriseList)-不分页查询资质列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}

		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		enterpriseResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【不分页查询资质列表】(EnterpriseController-selectEnterpriseList)-返回信息, enterpriseResponse:{}", enterpriseResponse);
		return enterpriseResponse;
	}

	/**
	 * 据id查询资质
	 * @param enterpriseId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询资质")
	@RequestMapping(value="/selectEnterpriseById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectEnterpriseById(
		@PathVariable(value="id",required=false) Integer enterpriseId) {
		logger.info("===step1:【据id查询资质】(selectEnterpriseById-selectEnterpriseById)-传入参数, enterpriseId:{}", enterpriseId);

		if(enterpriseId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "enterpriseId为空");
		}

		Enterprise enterprise = enterpriseService.selectEnterpriseById(enterpriseId);
		logger.info("===step2:【据id查询资质】(EnterpriseController-selectEnterpriseById)-根据id查询资质, enterprise:{}", enterprise);
		if(enterprise == null) {
			return new BaseRestMapResponse(SafeResultEnum.ORDER_SETTING_ENTITY_NOTEXIST);
		}
		EnterpriseVo enterpriseVo = new EnterpriseVo().convertToEnterpriseVo(enterprise);

		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		enterpriseResponse.putAll((JSONObject) JSONObject.toJSON(enterpriseVo));
		logger.info("===step3:【据id查询资质】(EnterpriseController-selectEnterpriseById)-返回信息, enterpriseResponse:{}", enterpriseResponse);
		return enterpriseResponse;
	}

	/**
	 * 添加资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加资质")
	@RequestMapping(value="/insertEnterprise",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertEnterprise(
		@Validated @RequestBody EnterpriseRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加资质】(EnterpriseController-insertEnterprise)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Enterprise enterprise = req.convertToEnterprise();
		int i = enterpriseService.insertEnterprise(enterprise);
		logger.info("===step2:【添加资质】(EnterpriseController-insertEnterprise)-插入资质, i:{}", i);

		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加资质】(EnterpriseController-insertEnterprise)-返回信息, enterpriseResponse:{}", enterpriseResponse);
		return enterpriseResponse;
	}

	/**
	 * 根据id删除资质
	 * @param enterpriseId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除资质")
	@RequestMapping(value="/deleteEnterpriseById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteEnterpriseById(
		@PathVariable(value="id",required=false) Integer enterpriseId) {
		logger.info("===step1:【根据id删除资质】(selectEnterpriseById-deleteEnterpriseById)-传入参数, enterpriseId:{}", enterpriseId);

		if(enterpriseId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "enterpriseId为空");
		}

		int i = enterpriseService.deleteEnterpriseById(enterpriseId);
		logger.info("===step2:【根据id删除资质】(EnterpriseController-deleteEnterpriseById)-根据id查询资质, i:{}", i);

		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除资质】(EnterpriseController-deleteEnterpriseById)-返回信息, enterpriseResponse:{}", enterpriseResponse);
		return enterpriseResponse;
	}

	/**
	 * 修改资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改资质")
	@RequestMapping(value="/modifyEnterprise",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyEnterprise(
		@Validated({ ModifyGroup.class }) @RequestBody EnterpriseRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改资质】(EnterpriseController-modifyEnterprise)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer enterpriseId = req.getEnterpriseId();
		Enterprise enterprise = req.convertToEnterprise();
		enterprise.setId(enterpriseId);
		int i = enterpriseService.modifyEnterprise(enterprise);
		logger.info("===step2:【修改资质】(EnterpriseController-modifyEnterprise)-修改资质, i:{}", i);

		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改资质】(EnterpriseController-modifyEnterprise)-返回信息, enterpriseResponse:{}", enterpriseResponse);
		return enterpriseResponse;
	}


}