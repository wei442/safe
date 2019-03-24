package com.cloud.provider.safe.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
import com.cloud.provider.safe.po.UserInfo;
import com.cloud.provider.safe.rest.request.UserInfoRequest;
import com.cloud.provider.safe.rest.request.page.UserInfoPageRequest;
import com.cloud.provider.safe.service.IUserInfoService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.UserInfoVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户信息 UserInfoController
 * @author wei.yong
 */
@Api(tags = "用户信息")
@RestController
@RequestMapping(value="/user/info")
public class UserInfoController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户信息Service
	@Autowired
	private IUserInfoService userInfoService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户信息列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody UserInfoPageRequest req) {
		logger.info("===step1:【分页查询用户信息列表】(UserInfoController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserInfo> list = userInfoService.selectListByPage(page, req);
		logger.info("===step2:【分页查询用户信息列表】(UserInfoController-selectListByPage)-分页查询用户信息列表, list.size:{}", list == null ? null : list.size());
		List<UserInfoVo> userInfoVoList = new UserInfoVo().convertToUserInfoVoList(list);

		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		userInfoResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(userInfoVoList));
		logger.info("===step3:【分页查询用户信息列表】(UserInfoController-selectListByPage)-返回信息, userInfoResponse:{}", userInfoResponse);
		return userInfoResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户信息列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody UserInfoPageRequest req) {
		logger.info("===step1:【不分页查询用户信息列表】(UserInfoController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<UserInfo> list = userInfoService.selectList(req);
		logger.info("===step2:【不分页查询用户信息列表】(UserInfoController-selectList)-不分页查询用户信息列表, list.size:{}", list == null ? null : list.size());
		List<UserInfoVo> userInfoVoList = new UserInfoVo().convertToUserInfoVoList(list);

		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		userInfoResponse.put(PageConstants.DATA_LIST, userInfoVoList);
		logger.info("===step3:【不分页查询用户信息列表】(UserInfoController-selectList)-返回信息, userInfoResponse:{}", userInfoResponse);
		return userInfoResponse;
	}

	/**
	 * 据id查询用户信息
	 * @param userInfoId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户信息")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer userInfoId) {
		logger.info("===step1:【据id查询用户信息】(selectById-selectById)-传入参数, userInfoId:{}", userInfoId);

		if(userInfoId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userInfoId为空");
		}

		UserInfo userInfo = userInfoService.selectById(userInfoId);
		logger.info("===step2:【据id查询用户信息】(UserInfoController-selectById)-根据id查询用户信息, userInfo:{}", userInfo);
		UserInfoVo userInfoVo = new UserInfoVo().convertToUserInfoVo(userInfo);

		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		userInfoResponse.putAll((JSONObject) JSONObject.toJSON(userInfoVo));
		logger.info("===step3:【据id查询用户信息】(UserInfoController-selectById)-返回信息, userInfoResponse:{}", userInfoResponse);
		return userInfoResponse;
	}

	/**
	 * 据userAccount查询用户信息
	 * @param userInfoId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据userAccount查询用户信息")
	@RequestMapping(value="/selectByUserAccount/{userAccount}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectByUserAccount(
		@PathVariable(value="userAccount",required=false) String userAccount) {
		logger.info("===step1:【据userAccount查询用户信息】(selectById-selectById)-传入参数, userAccount:{}", userAccount);

		if(StringUtils.isBlank(userAccount)) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userAccount为空");
		}

		UserInfo userInfo = userInfoService.selectByUserAccount(userAccount);
		logger.info("===step2:【据userAccount查询用户信息】(UserInfoController-selectByUserAccount)-根据id查询用户信息, userInfo:{}", userInfo);
		UserInfoVo userInfoVo = new UserInfoVo().convertToUserInfoVo(userInfo);

		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		userInfoResponse.putAll((JSONObject) JSONObject.toJSON(userInfoVo));
		logger.info("===step3:【据id查询用户信息】(UserInfoController-selectByUserAccount)-返回信息, userInfoResponse:{}", userInfoResponse);
		return userInfoResponse;
	}

	/**
	 * 添加用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户信息")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody UserInfoRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户信息】(UserInfoController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		

		UserInfo userInfo = req.convertToUserInfo();
		int i = userInfoService.insert(userInfo);
		logger.info("===step2:【添加用户信息】(UserInfoController-insert)-插入用户信息, i:{}", i);

		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户信息】(UserInfoController-insert)-返回信息, userInfoResponse:{}", userInfoResponse);
		return userInfoResponse;
	}

	/**
	 * 根据id删除用户信息
	 * @param userInfoId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户信息")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer userInfoId) {
		logger.info("===step1:【根据id删除用户信息】(selectById-deleteById)-传入参数, userInfoId:{}", userInfoId);

		if(userInfoId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userInfoId为空");
		}

		int i = userInfoService.deleteById(userInfoId);
		logger.info("===step2:【根据id删除用户信息】(UserInfoController-deleteById)-根据id查询用户信息, i:{}", i);

		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户信息】(UserInfoController-deleteById)-返回信息, userInfoResponse:{}", userInfoResponse);
		return userInfoResponse;
	}

	/**
	 * 修改用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户信息")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody UserInfoRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户信息】(UserInfoController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		

		Integer userInfoId = req.getUserId();
		UserInfo userInfo = req.convertToUserInfo();
		userInfo.setId(userInfoId);
		int i = userInfoService.modify(userInfo);
		logger.info("===step2:【修改用户信息】(UserInfoController-modify)-修改用户信息, i:{}", i);

		BaseRestMapResponse userInfoResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户信息】(UserInfoController-modify)-返回信息, userInfoResponse:{}", userInfoResponse);
		return userInfoResponse;
	}

}