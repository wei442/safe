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
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody UserAppLoginPageRequest req) {
		logger.info("===step1:【分页查询用户应用登录列表】(UserAppLoginController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserAppLogin> list = userAppLoginService.selectListByPage(page, req);
		logger.info("===step2:【分页查询用户应用登录列表】(UserAppLoginController-selectListByPage)-分页查询用户应用登录列表, list.size:{}", list == null ? null : list.size());
		List<UserAppLoginVo> userAppLoginVoList = new UserAppLoginVo().convertToUserAppLoginVoList(list);

		BaseRestMapResponse userAppLoginResponse = new BaseRestMapResponse();
		userAppLoginResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(userAppLoginVoList));
		logger.info("===step3:【分页查询用户应用登录列表】(UserAppLoginController-selectListByPage)-返回信息, userAppLoginResponse:{}", userAppLoginResponse);
		return userAppLoginResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户应用登录列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody UserAppLoginPageRequest req) {
		logger.info("===step1:【不分页查询用户应用登录列表】(UserAppLoginController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<UserAppLogin> list = userAppLoginService.selectList(req);
		logger.info("===step2:【不分页查询用户应用登录列表】(UserAppLoginController-selectList)-不分页查询用户应用登录列表, list.size:{}", list == null ? null : list.size());
		List<UserAppLoginVo> userAppLoginVoList = new UserAppLoginVo().convertToUserAppLoginVoList(list);

		BaseRestMapResponse userAppLoginResponse = new BaseRestMapResponse();
		userAppLoginResponse.put(PageConstants.DATA_LIST, userAppLoginVoList);
		logger.info("===step3:【不分页查询用户应用登录列表】(UserAppLoginController-selectList)-返回信息, userAppLoginResponse:{}", userAppLoginResponse);
		return userAppLoginResponse;
	}

	/**
	 * 据id查询用户应用登录
	 * @param userAppLoginId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户应用登录")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer userAppLoginId) {
		logger.info("===step1:【据id查询用户应用登录】(selectById-selectById)-传入参数, userAppLoginId:{}", userAppLoginId);

		if(userAppLoginId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userAppLoginId为空");
		}

		UserAppLogin userAppLogin = userAppLoginService.selectById(userAppLoginId);
		logger.info("===step2:【据id查询用户应用登录】(UserAppLoginController-selectById)-根据id查询用户应用登录, userAppLogin:{}", userAppLogin);
		UserAppLoginVo userAppLoginVo = new UserAppLoginVo().convertToUserAppLoginVo(userAppLogin);

		BaseRestMapResponse userAppLoginResponse = new BaseRestMapResponse();
		userAppLoginResponse.putAll((JSONObject) JSONObject.toJSON(userAppLoginVo));
		logger.info("===step3:【据id查询用户应用登录】(UserAppLoginController-selectById)-返回信息, userAppLoginResponse:{}", userAppLoginResponse);
		return userAppLoginResponse;
	}

	/**
	 * 添加用户应用登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户应用登录")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody UserAppLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户应用登录】(UserAppLoginController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		

		UserAppLogin userAppLogin = req.convertToUserAppLogin();
		int i = userAppLoginService.insert(userAppLogin);
		logger.info("===step2:【添加用户应用登录】(UserAppLoginController-insert)-插入用户应用登录, i:{}", i);

		BaseRestMapResponse userAppLoginResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户应用登录】(UserAppLoginController-insert)-返回信息, userAppLoginResponse:{}", userAppLoginResponse);
		return userAppLoginResponse;
	}

	/**
	 * 根据id删除用户应用登录
	 * @param userAppLoginId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户应用登录")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer userAppLoginId) {
		logger.info("===step1:【根据id删除用户应用登录】(selectById-deleteById)-传入参数, userAppLoginId:{}", userAppLoginId);

		if(userAppLoginId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userAppLoginId为空");
		}

		int i = userAppLoginService.deleteById(userAppLoginId);
		logger.info("===step2:【根据id删除用户应用登录】(UserAppLoginController-deleteById)-根据id查询用户应用登录, i:{}", i);

		BaseRestMapResponse userAppLoginResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户应用登录】(UserAppLoginController-deleteById)-返回信息, userAppLoginResponse:{}", userAppLoginResponse);
		return userAppLoginResponse;
	}

	/**
	 * 修改用户应用登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户应用登录")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody UserAppLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户应用登录】(UserAppLoginController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		

		Integer userAppLoginId = req.getUserAppLoginId();
		UserAppLogin userAppLogin = req.convertToUserAppLogin();
		userAppLogin.setId(userAppLoginId);
		int i = userAppLoginService.modify(userAppLogin);
		logger.info("===step2:【修改用户应用登录】(UserAppLoginController-modify)-修改用户应用登录, i:{}", i);

		BaseRestMapResponse userAppLoginResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户应用登录】(UserAppLoginController-modify)-返回信息, userAppLoginResponse:{}", userAppLoginResponse);
		return userAppLoginResponse;
	}

}