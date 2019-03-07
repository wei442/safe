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
import com.cloud.provider.safe.po.UserAdminLogin;
import com.cloud.provider.safe.rest.request.UserAdminLoginRequest;
import com.cloud.provider.safe.rest.request.page.UserAdminLoginPageRequest;
import com.cloud.provider.safe.service.IUserAdminLoginService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.UserAdminLoginVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户管理登录 UserAdminLoginController
 * @author wei.yong
 */
@Api(tags = "用户管理登录")
@RestController
@RequestMapping(value="/user/adminLogin")
public class UserAdminLoginController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户管理登录Service
	@Autowired
	private IUserAdminLoginService userAdminLoginService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户管理登录列表")
	@RequestMapping(value="/selectUserAdminLoginListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserAdminLoginListByPage(
		@RequestBody UserAdminLoginPageRequest req) {
		logger.info("===step1:【分页查询用户管理登录列表】(UserAdminLoginController-selectUserAdminLoginListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		UserAdminLogin userAdminLogin = new UserAdminLogin();
		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserAdminLogin> list = userAdminLoginService.selectUserAdminLoginListByPage(page, userAdminLogin);
		logger.info("===step2:【分页查询用户管理登录列表】(UserAdminLoginController-selectUserAdminLoginListByPage)-分页查询用户管理登录列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}
		List<UserAdminLoginVo> userAdminLoginVoList = new UserAdminLoginVo().convertToUserAdminLoginVoList(list);

		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		userAdminLoginResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(userAdminLoginVoList));
		logger.info("===step3:【分页查询用户管理登录列表】(UserAdminLoginController-selectUserAdminLoginListByPage)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
		return userAdminLoginResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户管理登录列表")
	@RequestMapping(value="/selectUserAdminLoginList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserAdminLoginList(
		@RequestBody UserAdminLoginPageRequest req) {
		logger.info("===step1:【不分页查询用户管理登录列表】(UserAdminLoginController-selectUserAdminLoginList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		UserAdminLogin userAdminLogin = new UserAdminLogin();
		List<UserAdminLogin> list = null;
		list = userAdminLoginService.selectUserAdminLoginList(userAdminLogin);
		logger.info("===step2:【不分页查询用户管理登录列表】(UserAdminLoginController-selectUserAdminLoginList)-不分页查询用户管理登录列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}
		List<UserAdminLoginVo> userAdminLoginVoList = new UserAdminLoginVo().convertToUserAdminLoginVoList(list);

		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		userAdminLoginResponse.put(PageConstants.DATA_LIST, userAdminLoginVoList);
		logger.info("===step3:【不分页查询用户管理登录列表】(UserAdminLoginController-selectUserAdminLoginList)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
		return userAdminLoginResponse;
	}

	/**
	 * 据id查询用户管理登录
	 * @param userAdminLoginId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户管理登录")
	@RequestMapping(value="/selectUserAdminLoginById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserAdminLoginById(
		@PathVariable(value="id",required=false) Integer userAdminLoginId) {
		logger.info("===step1:【据id查询用户管理登录】(selectUserAdminLoginById-selectUserAdminLoginById)-传入参数, userAdminLoginId:{}", userAdminLoginId);

		if(userAdminLoginId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userAdminLoginId为空");
		}

		UserAdminLogin userAdminLogin = userAdminLoginService.selectUserAdminLoginById(userAdminLoginId);
		logger.info("===step2:【据id查询用户管理登录】(UserAdminLoginController-selectUserAdminLoginById)-根据id查询用户管理登录, userAdminLogin:{}", userAdminLogin);
		if(userAdminLogin == null) {
			return new BaseRestMapResponse(SafeResultEnum.ORDER_SETTING_ENTITY_NOTEXIST);
		}
		UserAdminLoginVo userAdminLoginVo = new UserAdminLoginVo().convertToUserAdminLoginVo(userAdminLogin);

		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		userAdminLoginResponse.putAll((JSONObject) JSONObject.toJSON(userAdminLoginVo));
		logger.info("===step3:【据id查询用户管理登录】(UserAdminLoginController-selectUserAdminLoginById)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
		return userAdminLoginResponse;
	}

	/**
	 * 添加用户管理登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户管理登录")
	@RequestMapping(value="/insertUserAdminLogin",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertUserAdminLogin(
		@Validated @RequestBody UserAdminLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户管理登录】(UserAdminLoginController-insertUserAdminLogin)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		UserAdminLogin userAdminLogin = req.convertToUserAdminLogin();
		int i = userAdminLoginService.insertUserAdminLogin(userAdminLogin);
		logger.info("===step2:【添加用户管理登录】(UserAdminLoginController-insertUserAdminLogin)-插入用户管理登录, i:{}", i);

		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户管理登录】(UserAdminLoginController-insertUserAdminLogin)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
		return userAdminLoginResponse;
	}

	/**
	 * 根据id删除用户管理登录
	 * @param userAdminLoginId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户管理登录")
	@RequestMapping(value="/deleteUserAdminLoginById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteUserAdminLoginById(
		@PathVariable(value="id",required=false) Integer userAdminLoginId) {
		logger.info("===step1:【根据id删除用户管理登录】(selectUserAdminLoginById-deleteUserAdminLoginById)-传入参数, userAdminLoginId:{}", userAdminLoginId);

		if(userAdminLoginId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userAdminLoginId为空");
		}

		int i = userAdminLoginService.deleteUserAdminLoginById(userAdminLoginId);
		logger.info("===step2:【根据id删除用户管理登录】(UserAdminLoginController-deleteUserAdminLoginById)-根据id查询用户管理登录, i:{}", i);

		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户管理登录】(UserAdminLoginController-deleteUserAdminLoginById)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
		return userAdminLoginResponse;
	}

	/**
	 * 修改用户管理登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户管理登录")
	@RequestMapping(value="/modifyUserAdminLogin",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyUserAdminLogin(
		@Validated({ ModifyGroup.class }) @RequestBody UserAdminLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户管理登录】(UserAdminLoginController-modifyUserAdminLogin)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer userAdminLoginId = req.getUserAdminLoginId();
		UserAdminLogin userAdminLogin = req.convertToUserAdminLogin();
		userAdminLogin.setId(userAdminLoginId);
		int i = userAdminLoginService.modifyUserAdminLogin(userAdminLogin);
		logger.info("===step2:【修改用户管理登录】(UserAdminLoginController-modifyUserAdminLogin)-修改用户管理登录, i:{}", i);

		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户管理登录】(UserAdminLoginController-modifyUserAdminLogin)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
		return userAdminLoginResponse;
	}

}