package com.cloud.provider.safe.controller;

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
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.base.BaseRestMapResponse;
import com.cloud.provider.safe.po.UserInfo;
import com.cloud.provider.safe.rest.request.UserInfoRequest;
import com.cloud.provider.safe.rest.request.UserRequest;
import com.cloud.provider.safe.service.IUserInfoService;
import com.cloud.provider.safe.service.IUserService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.UserInfoVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户 UserController
 * @author wei.yong
 */
@Api(tags = "用户")
@RestController
@RequestMapping(value="/user")
public class UserController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户 Service
	@Autowired
	private IUserService userService;

	//用户信息Service
	@Autowired
	private IUserInfoService userInfoService;



	/**
	 * 添加用户
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户信息")
	@RequestMapping(value="/insertUser",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertUser(
		@Validated @RequestBody UserRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户信息】(UserInfoController-insertUserInfo)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		UserInfo userInfo = req.convertToUserInfo();
		int i = userService.insertUser(enterprise, userInfo);
		logger.info("===step2:【添加用户信息】(UserInfoController-insertUserInfo)-插入用户信息, i:{}", i);

		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户信息】(UserInfoController-insertUserInfo)-返回信息, userInfoResponse:{}", userInfoResponse);
		return userInfoResponse;
	}






	/**
	 * 据id查询用户信息
	 * @param userInfoId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户信息")
	@RequestMapping(value="/selectUserInfoById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserInfoById(
		@PathVariable(value="id",required=false) Integer userInfoId) {
		logger.info("===step1:【据id查询用户信息】(selectUserInfoById-selectUserInfoById)-传入参数, userInfoId:{}", userInfoId);

		if(userInfoId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userInfoId为空");
		}

		UserInfo userInfo = userInfoService.selectUserInfoById(userInfoId);
		logger.info("===step2:【据id查询用户信息】(UserInfoController-selectUserInfoById)-根据id查询用户信息, userInfo:{}", userInfo);
		if(userInfo == null) {
			return new BaseRestMapResponse(SafeResultEnum.ORDER_SETTING_ENTITY_NOTEXIST);
		}
		UserInfoVo userInfoVo = new UserInfoVo().convertToUserInfoVo(userInfo);

		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		userInfoResponse.putAll((JSONObject) JSONObject.toJSON(userInfoVo));
		logger.info("===step3:【据id查询用户信息】(UserInfoController-selectUserInfoById)-返回信息, userInfoResponse:{}", userInfoResponse);
		return userInfoResponse;
	}

	/**
	 * 添加用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户信息")
	@RequestMapping(value="/insertUserInfo",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertUserInfo(
		@Validated @RequestBody UserInfoRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户信息】(UserInfoController-insertUserInfo)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		UserInfo userInfo = req.convertToUserInfo();
		int i = userInfoService.insertUserInfo(userInfo);
		logger.info("===step2:【添加用户信息】(UserInfoController-insertUserInfo)-插入用户信息, i:{}", i);

		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户信息】(UserInfoController-insertUserInfo)-返回信息, userInfoResponse:{}", userInfoResponse);
		return userInfoResponse;
	}

	/**
	 * 根据id删除用户信息
	 * @param userInfoId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户信息")
	@RequestMapping(value="/deleteUserInfoById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteUserInfoById(
		@PathVariable(value="id",required=false) Integer userInfoId) {
		logger.info("===step1:【根据id删除用户信息】(selectUserInfoById-deleteUserInfoById)-传入参数, userInfoId:{}", userInfoId);

		if(userInfoId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userInfoId为空");
		}

		int i = userInfoService.deleteUserInfoById(userInfoId);
		logger.info("===step2:【根据id删除用户信息】(UserInfoController-deleteUserInfoById)-根据id查询用户信息, i:{}", i);

		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户信息】(UserInfoController-deleteUserInfoById)-返回信息, userInfoResponse:{}", userInfoResponse);
		return userInfoResponse;
	}

	/**
	 * 修改用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户信息")
	@RequestMapping(value="/modifyUserInfo",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyUserInfo(
		@Validated({ ModifyGroup.class }) @RequestBody UserInfoRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户信息】(UserInfoController-modifyUserInfo)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer userInfoId = req.getUserId();
		UserInfo userInfo = req.convertToUserInfo();
		userInfo.setId(userInfoId);
		int i = userInfoService.modifyUserInfo(userInfo);
		logger.info("===step2:【修改用户信息】(UserInfoController-modifyUserInfo)-修改用户信息, i:{}", i);

		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户信息】(UserInfoController-modifyUserInfo)-返回信息, userInfoResponse:{}", userInfoResponse);
		return userInfoResponse;
	}

}