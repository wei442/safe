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
import com.cloud.provider.safe.po.BaseUserLogin;
import com.cloud.provider.safe.rest.request.BaseUserLoginRequest;
import com.cloud.provider.safe.rest.request.page.BaseUserLoginPageRequest;
import com.cloud.provider.safe.service.IBaseUserLoginService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.BaseUserLoginVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 基础用户登录 BaseUserLoginController
 * @author wei.yong
 */
@Api(tags = "基础用户登录")
@RestController
@RequestMapping(value="/base/userLogin")
public class BaseUserLoginController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//基础用户登录Service
	@Autowired
	private IBaseUserLoginService baseUserLoginService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询基础用户登录列表")
	@RequestMapping(value="/selectBaseUserLoginListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectBaseUserLoginListByPage(
		@RequestBody BaseUserLoginPageRequest req) {
		logger.info("===step1:【分页查询基础用户登录列表】(BaseUserLoginController-selectBaseUserLoginListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		BaseUserLogin baseUserLogin = new BaseUserLogin();
		Page<?> page = new Page<>(pageNum, pageSize);
		List<BaseUserLogin> list = baseUserLoginService.selectBaseUserLoginListByPage(page, baseUserLogin);
		logger.info("===step2:【分页查询基础用户登录列表】(BaseUserLoginController-selectBaseUserLoginListByPage)-分页查询基础用户登录列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}
		List<BaseUserLoginVo> baseUserLoginVoList = new BaseUserLoginVo().convertToBaseUserLoginVoList(list);

		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		baseUserLoginResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(baseUserLoginVoList));
		logger.info("===step3:【分页查询基础用户登录列表】(BaseUserLoginController-selectBaseUserLoginListByPage)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
		return baseUserLoginResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询基础用户登录列表")
	@RequestMapping(value="/selectBaseUserLoginList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectBaseUserLoginList(
		@RequestBody BaseUserLoginPageRequest req) {
		logger.info("===step1:【不分页查询基础用户登录列表】(BaseUserLoginController-selectBaseUserLoginList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		BaseUserLogin baseUserLogin = new BaseUserLogin();
		List<BaseUserLogin> list = null;
		list = baseUserLoginService.selectBaseUserLoginList(baseUserLogin);
		logger.info("===step2:【不分页查询基础用户登录列表】(BaseUserLoginController-selectBaseUserLoginList)-不分页查询基础用户登录列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}
		List<BaseUserLoginVo> baseUserLoginVoList = new BaseUserLoginVo().convertToBaseUserLoginVoList(list);

		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		baseUserLoginResponse.put(PageConstants.DATA_LIST, baseUserLoginVoList);
		logger.info("===step3:【不分页查询基础用户登录列表】(BaseUserLoginController-selectBaseUserLoginList)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
		return baseUserLoginResponse;
	}

	/**
	 * 据id查询基础用户登录
	 * @param baseUserLoginId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询基础用户登录")
	@RequestMapping(value="/selectBaseUserLoginById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectBaseUserLoginById(
		@PathVariable(value="id",required=false) Integer baseUserLoginId) {
		logger.info("===step1:【据id查询基础用户登录】(selectBaseUserLoginById-selectBaseUserLoginById)-传入参数, baseUserLoginId:{}", baseUserLoginId);

		if(baseUserLoginId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "baseUserLoginId为空");
		}

		BaseUserLogin baseUserLogin = baseUserLoginService.selectBaseUserLoginById(baseUserLoginId);
		logger.info("===step2:【据id查询基础用户登录】(BaseUserLoginController-selectBaseUserLoginById)-根据id查询基础用户登录, baseUserLogin:{}", baseUserLogin);
		if(baseUserLogin == null) {
			return new BaseRestMapResponse(SafeResultEnum.ORDER_SETTING_ENTITY_NOTEXIST);
		}
		BaseUserLoginVo baseUserLoginVo = new BaseUserLoginVo().convertToBaseUserLoginVo(baseUserLogin);

		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		baseUserLoginResponse.putAll((JSONObject) JSONObject.toJSON(baseUserLoginVo));
		logger.info("===step3:【据id查询基础用户登录】(BaseUserLoginController-selectBaseUserLoginById)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
		return baseUserLoginResponse;
	}

	/**
	 * 添加基础用户登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加基础用户登录")
	@RequestMapping(value="/insertBaseUserLogin",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertBaseUserLogin(
		@Validated @RequestBody BaseUserLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加基础用户登录】(BaseUserLoginController-insertBaseUserLogin)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		BaseUserLogin baseUserLogin = req.convertToBaseUserLogin();
		int i = baseUserLoginService.insertBaseUserLogin(baseUserLogin);
		logger.info("===step2:【添加基础用户登录】(BaseUserLoginController-insertBaseUserLogin)-插入基础用户登录, i:{}", i);

		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加基础用户登录】(BaseUserLoginController-insertBaseUserLogin)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
		return baseUserLoginResponse;
	}

	/**
	 * 根据id删除基础用户登录
	 * @param baseUserLoginId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除基础用户登录")
	@RequestMapping(value="/deleteBaseUserLoginById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteBaseUserLoginById(
		@PathVariable(value="id",required=false) Integer baseUserLoginId) {
		logger.info("===step1:【根据id删除基础用户登录】(selectBaseUserLoginById-deleteBaseUserLoginById)-传入参数, baseUserLoginId:{}", baseUserLoginId);

		if(baseUserLoginId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "baseUserLoginId为空");
		}

		int i = baseUserLoginService.deleteBaseUserLoginById(baseUserLoginId);
		logger.info("===step2:【根据id删除基础用户登录】(BaseUserLoginController-deleteBaseUserLoginById)-根据id查询基础用户登录, i:{}", i);

		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除基础用户登录】(BaseUserLoginController-deleteBaseUserLoginById)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
		return baseUserLoginResponse;
	}

	/**
	 * 基础用户登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "基础用户登录")
	@RequestMapping(value="/modifyBaseUserLogin",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyBaseUserLogin(
		@Validated({ ModifyGroup.class }) @RequestBody BaseUserLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【基础用户登录】(BaseUserLoginController-modifyBaseUserLogin)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer baseUserLoginId = req.getBaseUserLoginId();
		BaseUserLogin baseUserLogin = req.convertToBaseUserLogin();
		baseUserLogin.setId(baseUserLoginId);
		int i = baseUserLoginService.modifyBaseUserLogin(baseUserLogin);
		logger.info("===step2:【基础用户登录】(BaseUserLoginController-modifyBaseUserLogin)-基础用户登录, i:{}", i);

		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		logger.info("===step3:【基础用户登录】(BaseUserLoginController-modifyBaseUserLogin)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
		return baseUserLoginResponse;
	}


}