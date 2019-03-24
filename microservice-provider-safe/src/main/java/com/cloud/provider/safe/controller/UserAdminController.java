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
import com.cloud.provider.safe.po.UserAdmin;
import com.cloud.provider.safe.rest.request.UserAdminRequest;
import com.cloud.provider.safe.rest.request.page.UserAdminPageRequest;
import com.cloud.provider.safe.service.IUserAdminService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.UserAdminVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户管理 UserAdminController
 * @author wei.yong
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping(value="/user/admin")
public class UserAdminController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户管理Service
	@Autowired
	private IUserAdminService userAdminService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户管理列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody UserAdminPageRequest req) {
		logger.info("===step1:【分页查询用户管理列表】(UserAdminController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserAdmin> list = userAdminService.selectListByPage(page, req);
		logger.info("===step2:【分页查询用户管理列表】(UserAdminController-selectListByPage)-分页查询用户管理列表, list.size:{}", list == null ? null : list.size());
		List<UserAdminVo> userAdminVoList = new UserAdminVo().convertToUserAdminVoList(list);

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		userAdminResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(userAdminVoList));
		logger.info("===step3:【分页查询用户管理列表】(UserAdminController-selectListByPage)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户管理列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody UserAdminPageRequest req) {
		logger.info("===step1:【不分页查询用户管理列表】(UserAdminController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<UserAdmin> list = userAdminService.selectList(req);
		logger.info("===step2:【不分页查询用户管理列表】(UserAdminController-selectList)-不分页查询用户管理列表, list.size:{}", list == null ? null : list.size());
		List<UserAdminVo> userAdminVoList = new UserAdminVo().convertToUserAdminVoList(list);

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		userAdminResponse.put(PageConstants.DATA_LIST, userAdminVoList);
		logger.info("===step3:【不分页查询用户管理列表】(UserAdminController-selectList)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 据id查询用户管理
	 * @param userAdminId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户管理")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer userAdminId) {
		logger.info("===step1:【据id查询用户管理】(selectById-selectById)-传入参数, userAdminId:{}", userAdminId);

		if(userAdminId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userAdminId为空");
		}

		UserAdmin userAdmin = userAdminService.selectById(userAdminId);
		logger.info("===step2:【据id查询用户管理】(UserAdminController-selectById)-根据id查询用户管理, userAdmin:{}", userAdmin);
		UserAdminVo userAdminVo = new UserAdminVo().convertToUserAdminVo(userAdmin);

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		userAdminResponse.putAll((JSONObject) JSONObject.toJSON(userAdminVo));
		logger.info("===step3:【据id查询用户管理】(UserAdminController-selectById)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 据userId查询用户管理
	 * @param userId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据userId查询用户管理")
	@RequestMapping(value="/selectByUserId/{userId}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectByUserId(
		@PathVariable(value="userId",required=false) Integer userId) {
		logger.info("===step1:【据userId查询用户管理】(selectById-selectByUserId)-传入参数, userId:{}", userId);

		if(userId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userId为空");
		}

		UserAdmin userAdmin = userAdminService.selectByUserId(userId);
		logger.info("===step2:【据userId查询用户管理】(UserAdminController-selectByUserId)-根据userId查询用户管理, userAdmin:{}", userAdmin);
		UserAdminVo userAdminVo = new UserAdminVo().convertToUserAdminVo(userAdmin);

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		userAdminResponse.putAll((JSONObject) JSONObject.toJSON(userAdminVo));
		logger.info("===step3:【据userId查询用户管理】(UserAdminController-selectByUserId)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 添加用户管理
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户管理")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody UserAdminRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户管理】(UserAdminController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		

		UserAdmin userAdmin = req.convertToUserAdmin();
		int i = userAdminService.insert(userAdmin);
		logger.info("===step2:【添加用户管理】(UserAdminController-insert)-插入用户管理, i:{}", i);

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户管理】(UserAdminController-insert)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 根据id删除用户管理
	 * @param userAdminId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户管理")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer userAdminId) {
		logger.info("===step1:【根据id删除用户管理】(selectById-deleteById)-传入参数, userAdminId:{}", userAdminId);

		if(userAdminId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userAdminId为空");
		}

		int i = userAdminService.deleteById(userAdminId);
		logger.info("===step2:【根据id删除用户管理】(UserAdminController-deleteById)-根据id查询用户管理, i:{}", i);

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户管理】(UserAdminController-deleteById)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 修改用户管理
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户管理")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody UserAdminRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户管理】(UserAdminController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		

		Integer userAdminId = req.getUserAdminId();
		UserAdmin userAdmin = req.convertToUserAdmin();
		userAdmin.setId(userAdminId);
		int i = userAdminService.modify(userAdmin);
		logger.info("===step2:【修改用户管理】(UserAdminController-modify)-修改用户管理, i:{}", i);

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户管理】(UserAdminController-modify)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

}