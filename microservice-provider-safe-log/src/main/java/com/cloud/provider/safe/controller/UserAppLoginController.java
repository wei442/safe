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
import com.cloud.provider.safe.po.UserAppLogin;
import com.cloud.provider.safe.rest.request.UserAppLoginRequest;
import com.cloud.provider.safe.rest.request.page.UserAppLoginPageRequest;
import com.cloud.provider.safe.service.IUserAppLoginService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.UserAppLoginVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户应用登录 UserAppLoginController
 * @author wei.yong
 */
@Api(tags = "用户应用登录")
@RestController
@RequestMapping(value="/user/appLogin")
public class UserAppLoginController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户应用登录Service
	@Autowired
	private IUserAppLoginService userAppLoginService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户应用登录列表")
	@RequestMapping(value="/selectUserAppLoginListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserAppLoginListByPage(
		@RequestBody UserAppLoginPageRequest req) {
		logger.info("===step1:【分页查询用户应用登录列表】(UserAppLoginController-selectUserAppLoginListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserAppLogin> list = userAppLoginService.selectUserAppLoginListByPage(page, req);
		logger.info("===step2:【分页查询用户应用登录列表】(UserAppLoginController-selectUserAppLoginListByPage)-分页查询用户应用登录列表, list.size:{}", list == null ? null : list.size());
		List<UserAppLoginVo> userAppLoginVoList = new UserAppLoginVo().convertToUserAppLoginVoList(list);

		BaseRestMapResponse userAppLoginResponse = new BaseRestMapResponse();
		userAppLoginResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(userAppLoginVoList));
		logger.info("===step3:【分页查询用户应用登录列表】(UserAppLoginController-selectUserAppLoginListByPage)-返回信息, userAppLoginResponse:{}", userAppLoginResponse);
		return userAppLoginResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户应用登录列表")
	@RequestMapping(value="/selectUserAppLoginList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserAppLoginList(
		@RequestBody UserAppLoginPageRequest req) {
		logger.info("===step1:【不分页查询用户应用登录列表】(UserAppLoginController-selectUserAppLoginList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<UserAppLogin> list = userAppLoginService.selectUserAppLoginList(req);
		logger.info("===step2:【不分页查询用户应用登录列表】(UserAppLoginController-selectUserAppLoginList)-不分页查询用户应用登录列表, list.size:{}", list == null ? null : list.size());
		List<UserAppLoginVo> userAppLoginVoList = new UserAppLoginVo().convertToUserAppLoginVoList(list);

		BaseRestMapResponse userAppLoginResponse = new BaseRestMapResponse();
		userAppLoginResponse.put(PageConstants.DATA_LIST, userAppLoginVoList);
		logger.info("===step3:【不分页查询用户应用登录列表】(UserAppLoginController-selectUserAppLoginList)-返回信息, userAppLoginResponse:{}", userAppLoginResponse);
		return userAppLoginResponse;
	}

	/**
	 * 据id查询用户应用登录
	 * @param userAppLoginId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户应用登录")
	@RequestMapping(value="/selectUserAppLoginById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserAppLoginById(
		@PathVariable(value="id",required=false) Integer userAppLoginId) {
		logger.info("===step1:【据id查询用户应用登录】(selectUserAppLoginById-selectUserAppLoginById)-传入参数, userAppLoginId:{}", userAppLoginId);

		if(userAppLoginId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userAppLoginId为空");
		}

		UserAppLogin userAppLogin = userAppLoginService.selectUserAppLoginById(userAppLoginId);
		logger.info("===step2:【据id查询用户应用登录】(UserAppLoginController-selectUserAppLoginById)-根据id查询用户应用登录, userAppLogin:{}", userAppLogin);
		if(userAppLogin == null) {
			return new BaseRestMapResponse(SafeResultEnum.ORDER_SETTING_ENTITY_NOTEXIST);
		}
		UserAppLoginVo userAppLoginVo = new UserAppLoginVo().convertToUserAppLoginVo(userAppLogin);

		BaseRestMapResponse userAppLoginResponse = new BaseRestMapResponse();
		userAppLoginResponse.putAll((JSONObject) JSONObject.toJSON(userAppLoginVo));
		logger.info("===step3:【据id查询用户应用登录】(UserAppLoginController-selectUserAppLoginById)-返回信息, userAppLoginResponse:{}", userAppLoginResponse);
		return userAppLoginResponse;
	}

	/**
	 * 添加用户应用登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户应用登录")
	@RequestMapping(value="/insertUserAppLogin",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertUserAppLogin(
		@Validated @RequestBody UserAppLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户应用登录】(UserAppLoginController-insertUserAppLogin)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		UserAppLogin userAppLogin = req.convertToUserAppLogin();
		int i = userAppLoginService.insertUserAppLogin(userAppLogin);
		logger.info("===step2:【添加用户应用登录】(UserAppLoginController-insertUserAppLogin)-插入用户应用登录, i:{}", i);

		BaseRestMapResponse userAppLoginResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户应用登录】(UserAppLoginController-insertUserAppLogin)-返回信息, userAppLoginResponse:{}", userAppLoginResponse);
		return userAppLoginResponse;
	}

	/**
	 * 根据id删除用户应用登录
	 * @param userAppLoginId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户应用登录")
	@RequestMapping(value="/deleteUserAppLoginById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteUserAppLoginById(
		@PathVariable(value="id",required=false) Integer userAppLoginId) {
		logger.info("===step1:【根据id删除用户应用登录】(selectUserAppLoginById-deleteUserAppLoginById)-传入参数, userAppLoginId:{}", userAppLoginId);

		if(userAppLoginId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userAppLoginId为空");
		}

		int i = userAppLoginService.deleteUserAppLoginById(userAppLoginId);
		logger.info("===step2:【根据id删除用户应用登录】(UserAppLoginController-deleteUserAppLoginById)-根据id查询用户应用登录, i:{}", i);

		BaseRestMapResponse userAppLoginResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户应用登录】(UserAppLoginController-deleteUserAppLoginById)-返回信息, userAppLoginResponse:{}", userAppLoginResponse);
		return userAppLoginResponse;
	}

	/**
	 * 修改用户应用登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户应用登录")
	@RequestMapping(value="/modifyUserAppLogin",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyUserAppLogin(
		@Validated({ ModifyGroup.class }) @RequestBody UserAppLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户应用登录】(UserAppLoginController-modifyUserAppLogin)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer userAppLoginId = req.getUserAppLoginId();
		UserAppLogin userAppLogin = req.convertToUserAppLogin();
		userAppLogin.setId(userAppLoginId);
		int i = userAppLoginService.modifyUserAppLogin(userAppLogin);
		logger.info("===step2:【修改用户应用登录】(UserAppLoginController-modifyUserAppLogin)-修改用户应用登录, i:{}", i);

		BaseRestMapResponse userAppLoginResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户应用登录】(UserAppLoginController-modifyUserAppLogin)-返回信息, userAppLoginResponse:{}", userAppLoginResponse);
		return userAppLoginResponse;
	}

}