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
import com.cloud.provider.safe.po.UserInfo;
import com.cloud.provider.safe.po.UserOrg;
import com.cloud.provider.safe.rest.request.page.user.UserOrgPageRequest;
import com.cloud.provider.safe.rest.request.user.UserOrgIdsRequest;
import com.cloud.provider.safe.rest.request.user.UserOrgRequest;
import com.cloud.provider.safe.service.IUserInfoService;
import com.cloud.provider.safe.service.IUserOrgService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.user.UserOrgVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户机构 UserOrgController
 * @author wei.yong
 */
@Api(tags = "用户机构")
@RestController
@RequestMapping(value="/user/org")
public class UserOrgController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户机构Service
	@Autowired
	private IUserOrgService userOrgService;

	//用户信息Service
	@Autowired
	private IUserInfoService userInfoService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户机构列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody UserOrgPageRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【分页查询用户机构列表】(UserOrgController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserOrgVo> list = userOrgService.selectListByPage(page, req);
		logger.info("===step2:【分页查询用户机构列表】(UserOrgController-selectListByPage)-分页查询用户机构列表, list.size:{}", list == null ? null : list.size());

		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		userOrgResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(list));
		logger.info("===step3:【分页查询用户机构列表】(UserOrgController-selectListByPage)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户机构列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody UserOrgPageRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【不分页查询用户机构列表】(UserOrgController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<UserOrgVo> list = userOrgService.selectList(req);
		logger.info("===step2:【不分页查询用户机构列表】(UserOrgController-selectList)-不分页查询用户机构列表, list.size:{}", list == null ? null : list.size());

		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		userOrgResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【不分页查询用户机构列表】(UserOrgController-selectList)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

	/**
	 * 据id查询用户机构
	 * @param userOrgId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户机构")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer userOrgId) {
		logger.info("===step1:【据id查询用户机构】(UserOrgController-selectById)-传入参数, userOrgId:{}", userOrgId);

		if(userOrgId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "userOrgId不能为空");
		}

		UserOrg userOrg = userOrgService.selectById(userOrgId);
		logger.info("===step2:【据id查询用户机构】(UserOrgController-selectById)-根据id查询用户机构, userOrg:{}", userOrg);
		UserOrgVo userOrgVo = new UserOrgVo().convertToUserOrgVo(userOrg);

		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		userOrgResponse.putAll((JSONObject) JSONObject.toJSON(userOrgVo));
		logger.info("===step3:【据id查询用户机构】(UserOrgController-selectById)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

	/**
	 * 据userId查询用户机构
	 * @param userId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户机构")
	@RequestMapping(value="/selectByUserId/{userId}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectByUserId(
		@PathVariable(value="userId",required=false) Integer userId) {
		logger.info("===step1:【据userId查询用户机构】(UserOrgController-selectByUserId)-传入参数, userId:{}", userId);

		if(userId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "userId不能为空");
		}

		UserOrg userOrg = userOrgService.selectByUserId(userId);
		logger.info("===step2:【据userId查询用户机构】(UserOrgController-selectByUserId)-根据userId查询用户机构, userOrg:{}", userOrg);
		UserOrgVo userOrgVo = new UserOrgVo().convertToUserOrgVo(userOrg);

		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		userOrgResponse.putAll((JSONObject) JSONObject.toJSON(userOrgVo));
		logger.info("===step3:【据userId查询用户机构】(UserOrgController-selectByUserId)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

	/**
	 * 添加用户机构
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户机构")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody UserOrgRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户机构】(UserOrgController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String userAccount = req.getUserAccount();
//		String userName = req.getUserName();
		UserInfo userInfo = userInfoService.selectByUserAccount(userAccount);
		logger.info("===step2:【添加用户机构】(UserOrgController-insert)-根据userAccount查询用户信息, userInfo:{}", userInfo);
		Integer userId = null;
		if(userInfo == null) {
			userInfo = new UserInfo();
			userInfo.setUserAccount(userAccount);
//			userInfo.setUserName(userName);
			int i = userInfoService.insert(userInfo);
			logger.info("===step2.1:【添加用户机构】(UserOrgController-insert)-插入用户信息, i:{}", i);
		}
		userId = userInfo.getId();

		UserOrg userOrg = userOrgService.selectByUserId(userId);
		logger.info("===step3:【添加用户机构】(UserOrgController-insert)-根据userId查询用户机构, userOrg:{}", userOrg);
		if(userOrg != null) {
			return new BaseRestMapResponse(SafeResultEnum.USER_ORG_EXIST);
		}

		userOrg = req.convertToUserOrg();
		userOrg.setUserId(userId);
		int i = userOrgService.insert(userOrg);
		logger.info("===step4:【添加用户机构】(UserOrgController-insert)-插入用户机构, i:{}", i);

		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		logger.info("===step5:【添加用户机构】(UserOrgController-insert)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

	/**
	 * 根据id删除用户机构
	 * @param userOrgId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户机构")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer userOrgId) {
		logger.info("===step1:【根据id删除用户机构】(UserOrgController-deleteById)-传入参数, userOrgId:{}", userOrgId);

		if(userOrgId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "userOrgId不能为空");
		}

		int i = userOrgService.deleteById(userOrgId);
		logger.info("===step2:【根据id删除用户机构】(UserOrgController-deleteById)-根据id删除用户机构, i:{}", i);

		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户机构】(UserOrgController-deleteById)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

	/**
	 * 批量删除用户机构
	 * @param userOrgIds
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "批量删除用户机构")
	@RequestMapping(value="/batchDelete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse batchDelete(
		@Validated @RequestBody UserOrgIdsRequest req) {
		logger.info("===step1:【批量删除用户机构】(UserOrgController-batchDelete)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		List<Integer> userOrgIds = req.getUserOrgIds();
		int i = userOrgService.deleteByIds(userOrgIds);
		logger.info("===step2:【批量删除用户机构】(UserOrgController-batchDelete)-根据userOrgIds删除用户机构, i:{}", i);

		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		logger.info("===step3:【批量删除用户机构】(UserOrgController-batchDelete)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}


	/**
	 * 修改用户机构
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户机构")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody UserOrgRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户机构】(UserOrgController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userOrgId = req.getUserOrgId();
		UserOrg userOrg = req.convertToUserOrg();
		userOrg.setId(userOrgId);
		int i = userOrgService.modify(userOrg);
		logger.info("===step2:【修改用户机构】(UserOrgController-modify)-修改用户机构, i:{}", i);

		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户机构】(UserOrgController-modify)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

}