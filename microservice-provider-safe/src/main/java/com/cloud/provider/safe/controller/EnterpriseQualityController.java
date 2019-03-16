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
import com.cloud.provider.safe.po.EnterpriseQuality;
import com.cloud.provider.safe.rest.request.EnterpriseQualityRequest;
import com.cloud.provider.safe.rest.request.page.EnterpriseQualityPageRequest;
import com.cloud.provider.safe.service.IEnterpriseQualityService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.EnterpriseQualityVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 企业资质 EnterpriseQualityController
 * @author wei.yong
 */
@Api(tags = "企业资质")
@RestController
@RequestMapping(value="/enterprise/quality")
public class EnterpriseQualityController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//企业资质Service
	@Autowired
	private IEnterpriseQualityService enterpriseQualityService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询企业资质列表")
	@RequestMapping(value="/selectEnterpriseQualityListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectEnterpriseQualityListByPage(
		@RequestBody EnterpriseQualityPageRequest req) {
		logger.info("===step1:【分页查询企业资质列表】(EnterpriseQualityController-selectEnterpriseQualityListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<EnterpriseQuality> list = enterpriseQualityService.selectEnterpriseQualityListByPage(page, req);
		logger.info("===step2:【分页查询企业资质列表】(EnterpriseQualityController-selectEnterpriseQualityListByPage)-分页查询企业资质列表, list.size:{}", list == null ? null : list.size());
		List<EnterpriseQualityVo> enterpriseQualityVoList = new EnterpriseQualityVo().convertToEnterpriseQualityVoList(list);

		BaseRestMapResponse enterpriseQualityResponse = new BaseRestMapResponse();
		enterpriseQualityResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(enterpriseQualityVoList));
		logger.info("===step3:【分页查询企业资质列表】(EnterpriseQualityController-selectEnterpriseQualityListByPage)-返回信息, enterpriseQualityResponse:{}", enterpriseQualityResponse);
		return enterpriseQualityResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询企业资质列表")
	@RequestMapping(value="/selectEnterpriseQualityList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectEnterpriseQualityList(
		@RequestBody EnterpriseQualityPageRequest req) {
		logger.info("===step1:【不分页查询企业资质列表】(EnterpriseQualityController-selectEnterpriseQualityList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<EnterpriseQuality> list = enterpriseQualityService.selectEnterpriseQualityList(req);
		logger.info("===step2:【不分页查询企业资质列表】(EnterpriseQualityController-selectEnterpriseQualityList)-不分页查询企业资质列表, list.size:{}", list == null ? null : list.size());
		List<EnterpriseQualityVo> enterpriseQualityVoList = new EnterpriseQualityVo().convertToEnterpriseQualityVoList(list);

		BaseRestMapResponse enterpriseQualityResponse = new BaseRestMapResponse();
		enterpriseQualityResponse.put(PageConstants.DATA_LIST, enterpriseQualityVoList);
		logger.info("===step3:【不分页查询企业资质列表】(EnterpriseQualityController-selectEnterpriseQualityList)-返回信息, enterpriseQualityResponse:{}", enterpriseQualityResponse);
		return enterpriseQualityResponse;
	}

	/**
	 * 据id查询企业资质
	 * @param enterpriseQualityId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询企业资质")
	@RequestMapping(value="/selectEnterpriseQualityById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectEnterpriseQualityById(
		@PathVariable(value="id",required=false) Integer enterpriseQualityId) {
		logger.info("===step1:【据id查询企业资质】(selectEnterpriseQualityById-selectEnterpriseQualityById)-传入参数, enterpriseQualityId:{}", enterpriseQualityId);

		if(enterpriseQualityId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "enterpriseQualityId为空");
		}

		EnterpriseQuality enterpriseQuality = enterpriseQualityService.selectEnterpriseQualityById(enterpriseQualityId);
		logger.info("===step2:【据id查询企业资质】(EnterpriseQualityController-selectEnterpriseQualityById)-根据id查询企业资质, enterpriseQuality:{}", enterpriseQuality);
		EnterpriseQualityVo enterpriseQualityVo = new EnterpriseQualityVo().convertToEnterpriseQualityVo(enterpriseQuality);

		BaseRestMapResponse enterpriseQualityResponse = new BaseRestMapResponse();
		enterpriseQualityResponse.putAll((JSONObject) JSONObject.toJSON(enterpriseQualityVo));
		logger.info("===step3:【据id查询企业资质】(EnterpriseQualityController-selectEnterpriseQualityById)-返回信息, enterpriseQualityResponse:{}", enterpriseQualityResponse);
		return enterpriseQualityResponse;
	}

	/**
	 * 添加企业资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加企业资质")
	@RequestMapping(value="/insertEnterpriseQuality",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertEnterpriseQuality(
		@Validated @RequestBody EnterpriseQualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加企业资质】(EnterpriseQualityController-insertEnterpriseQuality)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		EnterpriseQuality enterpriseQuality = req.convertToEnterpriseQuality();
		int i = enterpriseQualityService.insertEnterpriseQuality(enterpriseQuality);
		logger.info("===step2:【添加企业资质】(EnterpriseQualityController-insertEnterpriseQuality)-插入企业资质, i:{}", i);

		BaseRestMapResponse enterpriseQualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加企业资质】(EnterpriseQualityController-insertEnterpriseQuality)-返回信息, enterpriseQualityResponse:{}", enterpriseQualityResponse);
		return enterpriseQualityResponse;
	}

	/**
	 * 根据id删除企业资质
	 * @param enterpriseQualityId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除企业资质")
	@RequestMapping(value="/deleteEnterpriseQualityById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteEnterpriseQualityById(
		@PathVariable(value="id",required=false) Integer enterpriseQualityId) {
		logger.info("===step1:【根据id删除企业资质】(selectEnterpriseQualityById-deleteEnterpriseQualityById)-传入参数, enterpriseQualityId:{}", enterpriseQualityId);

		if(enterpriseQualityId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "enterpriseQualityId为空");
		}

		int i = enterpriseQualityService.deleteEnterpriseQualityById(enterpriseQualityId);
		logger.info("===step2:【根据id删除企业资质】(EnterpriseQualityController-deleteEnterpriseQualityById)-根据id查询企业资质, i:{}", i);

		BaseRestMapResponse enterpriseQualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除企业资质】(EnterpriseQualityController-deleteEnterpriseQualityById)-返回信息, enterpriseQualityResponse:{}", enterpriseQualityResponse);
		return enterpriseQualityResponse;
	}

	/**
	 * 修改企业资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改企业资质")
	@RequestMapping(value="/modifyEnterpriseQuality",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyEnterpriseQuality(
		@Validated({ ModifyGroup.class }) @RequestBody EnterpriseQualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改企业资质】(EnterpriseQualityController-modifyEnterpriseQuality)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer enterpriseQualityId = req.getEnterpriseQualityId();
		EnterpriseQuality enterpriseQuality = req.convertToEnterpriseQuality();
		enterpriseQuality.setId(enterpriseQualityId);
		int i = enterpriseQualityService.modifyEnterpriseQuality(enterpriseQuality);
		logger.info("===step2:【修改企业资质】(EnterpriseQualityController-modifyEnterpriseQuality)-修改企业资质, i:{}", i);

		BaseRestMapResponse enterpriseQualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改企业资质】(EnterpriseQualityController-modifyEnterpriseQuality)-返回信息, enterpriseQualityResponse:{}", enterpriseQualityResponse);
		return enterpriseQualityResponse;
	}


}