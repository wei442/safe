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
import com.cloud.provider.safe.po.BaseUser;
import com.cloud.provider.safe.rest.request.BaseUserRequest;
import com.cloud.provider.safe.rest.request.page.BaseUserPageRequest;
import com.cloud.provider.safe.service.IBaseUserService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.BaseUserVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 基础用户 BaseUserController
 * @author wei.yong
 */
@Api(tags = "基础用户")
@RestController
@RequestMapping(value="/baseUser")
public class BaseUserController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//基础用户Service
	@Autowired
	private IBaseUserService baseUserService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询基础用户列表")
	@RequestMapping(value="/selectBaseUserListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectBaseUserListByPage(
		@RequestBody BaseUserPageRequest req) {
		logger.info("===step1:【分页查询基础用户列表】(BaseUserController-selectBaseUserListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		BaseUser baseUser = new BaseUser();
		Page<?> page = new Page<>(pageNum, pageSize);
		List<BaseUser> list = baseUserService.selectBaseUserListByPage(page, baseUser);
		logger.info("===step2:【分页查询基础用户列表】(BaseUserController-selectBaseUserListByPage)-分页查询基础用户列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}
		List<BaseUserVo> baseUserVoList = new BaseUserVo().convertToBaseUserVoList(list);

		BaseRestMapResponse baseUserResponse = new BaseRestMapResponse();
		baseUserResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(baseUserVoList));
		logger.info("===step3:【分页查询基础用户列表】(BaseUserController-selectBaseUserListByPage)-返回信息, baseUserResponse:{}", baseUserResponse);
		return baseUserResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询基础用户")
	@RequestMapping(value="/selectBaseUserList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectBaseUserList(
		@RequestBody BaseUserPageRequest req) {
		logger.info("===step1:【不分页查询基础用户列表】(BaseUserController-selectBaseUserList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		BaseUser baseUser = new BaseUser();
		List<BaseUser> list = null;
		list = baseUserService.selectBaseUserList(baseUser);
		logger.info("===step2:【不分页查询基础用户列表】(BaseUserController-selectBaseUserList)-不分页查询基础用户列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}
		List<BaseUserVo> baseUserVoList = new BaseUserVo().convertToBaseUserVoList(list);

		BaseRestMapResponse baseUserResponse = new BaseRestMapResponse();
		baseUserResponse.put(PageConstants.DATA_LIST, baseUserVoList);
		logger.info("===step3:【不分页查询基础用户列表】(BaseUserController-selectBaseUserList)-返回信息, baseUserResponse:{}", baseUserResponse);
		return baseUserResponse;
	}

	/**
	 * 据id查询基础用户
	 * @param baseUserId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询基础用户")
	@RequestMapping(value="/selectBaseUserById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectBaseUserById(
		@PathVariable(value="id",required=false) Integer baseUserId) {
		logger.info("===step1:【据id查询基础用户】(selectBaseUserById-selectBaseUserById)-传入参数, baseUserId:{}", baseUserId);

		if(baseUserId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "baseUserId为空");
		}

		BaseUser baseUser = baseUserService.selectBaseUserById(baseUserId);
		logger.info("===step2:【据id查询基础用户】(BaseUserController-selectBaseUserById)-根据id查询基础用户, baseUser:{}", baseUser);
		if(baseUser == null) {
			return new BaseRestMapResponse(SafeResultEnum.ORDER_SETTING_ENTITY_NOTEXIST);
		}
		BaseUserVo baseUserVo = new BaseUserVo().convertToBaseUserVo(baseUser);

		BaseRestMapResponse baseUserResponse = new BaseRestMapResponse();
		baseUserResponse.putAll((JSONObject) JSONObject.toJSON(baseUserVo));
		logger.info("===step3:【据id查询基础用户】(BaseUserController-selectBaseUserById)-返回信息, baseUserResponse:{}", baseUserResponse);
		return baseUserResponse;
	}

	/**
	 * 添加基础用户
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加基础用户")
	@RequestMapping(value="/insertBaseUser",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertBaseUser(
		@Validated @RequestBody BaseUserRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加基础用户】(BaseUserController-insertBaseUser)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		BaseUser baseUser = req.convertToBaseUser();
		int i = baseUserService.insertBaseUser(baseUser);
		logger.info("===step2:【添加基础用户】(BaseUserController-insertBaseUser)-插入基础用户, i:{}", i);

		BaseRestMapResponse baseUserResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加基础用户】(BaseUserController-insertBaseUser)-返回信息, baseUserResponse:{}", baseUserResponse);
		return baseUserResponse;
	}

	/**
	 * 根据id删除基础用户
	 * @param baseUserId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除基础用户")
	@RequestMapping(value="/deleteBaseUserById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteBaseUserById(
		@PathVariable(value="id",required=false) Integer baseUserId) {
		logger.info("===step1:【根据id删除基础用户】(selectBaseUserById-deleteBaseUserById)-传入参数, baseUserId:{}", baseUserId);

		if(baseUserId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "baseUserId为空");
		}

		int i = baseUserService.deleteBaseUserById(baseUserId);
		logger.info("===step2:【根据id删除基础用户】(BaseUserController-deleteBaseUserById)-根据id查询基础用户, i:{}", i);

		BaseRestMapResponse baseUserResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除基础用户】(BaseUserController-deleteBaseUserById)-返回信息, baseUserResponse:{}", baseUserResponse);
		return baseUserResponse;
	}

	/**
	 * 修改基础用户
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改基础用户")
	@RequestMapping(value="/modifyBaseUser",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyBaseUser(
		@Validated({ ModifyGroup.class }) @RequestBody BaseUserRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改基础用户】(BaseUserController-modifyBaseUser)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer baseUserId = req.getBaseUserId();
		BaseUser baseUser = req.convertToBaseUser();
		baseUser.setId(baseUserId);
		int i = baseUserService.modifyBaseUser(baseUser);
		logger.info("===step2:【修改基础用户】(BaseUserController-modifyBaseUser)-修改基础用户, i:{}", i);

		BaseRestMapResponse baseUserResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改基础用户】(BaseUserController-modifyBaseUser)-返回信息, baseUserResponse:{}", baseUserResponse);
		return baseUserResponse;
	}


}