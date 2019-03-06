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
import com.cloud.provider.safe.po.UserAdmin;
import com.cloud.provider.safe.rest.request.UserAdminRequest;
import com.cloud.provider.safe.service.IUserAdminService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.UserAdminVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户登录 UserAdminController
 * @author wei.yong
 */
@Api(tags = "用户登录")
@RestController
@RequestMapping(value="/userAdmin")
public class UserAdminController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户登录Service
	@Autowired
	private IUserAdminService userAdminService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户登录列表")
	@RequestMapping(value="/selectUserAdminListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserAdminListByPage(
		@RequestBody UserAdminRequest req) {
		logger.info("===step1:【分页查询用户登录列表】(UserAdminController-selectUserAdminListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		UserAdmin userAdmin = new UserAdmin();
		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserAdmin> list = userAdminService.selectUserAdminListByPage(page, userAdmin);
		logger.info("===step2:【分页查询用户登录列表】(UserAdminController-selectUserAdminListByPage)-分页查询用户登录列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}

		Map<String, Object> pageListMap = PageHelperUtil.INSTANCE.getPageListMap(list);
		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		userAdminResponse.putAll(pageListMap);
		logger.info("===step3:【分页查询用户登录列表】(UserAdminController-selectUserAdminListByPage)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户登录列表")
	@RequestMapping(value="/selectUserAdminList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserAdminList(
		@RequestBody UserAdminRequest req) {
		logger.info("===step1:【不分页查询用户登录列表】(UserAdminController-selectUserAdminList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		UserAdmin userAdmin = new UserAdmin();
		List<UserAdmin> list = null;
		list = userAdminService.selectUserAdminList(userAdmin);
		logger.info("===step2:【不分页查询用户登录列表】(UserAdminController-selectUserAdminList)-不分页查询用户登录列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		userAdminResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【不分页查询用户登录列表】(UserAdminController-selectUserAdminList)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 据id查询用户登录
	 * @param userAdminId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户登录")
	@RequestMapping(value="/selectUserAdminById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserAdminById(
		@PathVariable(value="id",required=false) Integer userAdminId) {
		logger.info("===step1:【据id查询用户登录】(selectUserAdminById-selectUserAdminById)-传入参数, userAdminId:{}", userAdminId);

		if(userAdminId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userAdminId为空");
		}

		UserAdmin userAdmin = userAdminService.selectUserAdminById(userAdminId);
		logger.info("===step2:【据id查询用户登录】(UserAdminController-selectUserAdminById)-根据id查询用户登录, userAdmin:{}", userAdmin);
		if(userAdmin == null) {
			return new BaseRestMapResponse(SafeResultEnum.ORDER_SETTING_ENTITY_NOTEXIST);
		}
		UserAdminVo userAdminVo = new UserAdminVo().convertToUserAdminVo(userAdmin);

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		userAdminResponse.putAll((JSONObject) JSONObject.toJSON(userAdminVo));
		logger.info("===step3:【据id查询用户登录】(UserAdminController-selectUserAdminById)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 添加用户登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户登录")
	@RequestMapping(value="/insertUserAdmin",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertUserAdmin(
		@Validated @RequestBody UserAdminRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户登录】(UserAdminController-insertUserAdmin)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		UserAdmin userAdmin = req.convertToUserAdmin();
		int i = userAdminService.insertUserAdmin(userAdmin);
		logger.info("===step2:【添加用户登录】(UserAdminController-insertUserAdmin)-插入用户登录, i:{}", i);

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户登录】(UserAdminController-insertUserAdmin)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 根据id删除用户登录
	 * @param userAdminId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户登录")
	@RequestMapping(value="/deleteUserAdminById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteUserAdminById(
		@PathVariable(value="id",required=false) Integer userAdminId) {
		logger.info("===step1:【根据id删除用户登录】(selectUserAdminById-deleteUserAdminById)-传入参数, userAdminId:{}", userAdminId);

		if(userAdminId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userAdminId为空");
		}

		int i = userAdminService.deleteUserAdminById(userAdminId);
		logger.info("===step2:【根据id删除用户登录】(UserAdminController-deleteUserAdminById)-根据id查询用户登录, i:{}", i);

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户登录】(UserAdminController-deleteUserAdminById)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 修改用户登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户登录")
	@RequestMapping(value="/modifyUserAdmin",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyUserAdmin(
		@Validated({ ModifyGroup.class }) @RequestBody UserAdminRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户登录】(UserAdminController-modifyUserAdmin)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer userAdminId = req.getUserAdminId();
		UserAdmin userAdmin = req.convertToUserAdmin();
		userAdmin.setId(userAdminId);
		int i = userAdminService.modifyUserAdmin(userAdmin);
		logger.info("===step2:【修改用户登录】(UserAdminController-modifyUserAdmin)-修改用户登录, i:{}", i);

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户登录】(UserAdminController-modifyUserAdmin)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

}