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
import com.cloud.provider.safe.po.UserTitle;
import com.cloud.provider.safe.rest.request.page.user.UserTitlePageRequest;
import com.cloud.provider.safe.rest.request.user.UserTitleIdsRequest;
import com.cloud.provider.safe.rest.request.user.UserTitleListRequest;
import com.cloud.provider.safe.rest.request.user.UserTitleRequest;
import com.cloud.provider.safe.service.IUserTitleService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.user.UserTitleVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户职务 UserTitleController
 * @author wei.yong
 */
@Api(tags = "用户职务")
@RestController
@RequestMapping(value="/user/title")
public class UserTitleController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户职务Service
	@Autowired
	private IUserTitleService userTitleService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户职务列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody UserTitlePageRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【分页查询用户职务列表】(UserTitleController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserTitleVo> list = userTitleService.selectListByPage(page, req);
		logger.info("===step2:【分页查询用户职务列表】(UserTitleController-selectListByPage)-分页查询用户职务列表, list.size:{}", list == null ? null : list.size());

		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		userTitleResponse.put(PageConstants.PAGE, PageHelperUtil.INSTANCE.getPageVo(list));
		userTitleResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询用户职务列表】(UserTitleController-selectListByPage)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户职务列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody UserTitlePageRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【不分页查询用户职务列表】(UserTitleController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<UserTitleVo> list = userTitleService.selectList(req);
		logger.info("===step2:【不分页查询用户职务列表】(UserTitleController-selectList)-不分页查询用户职务列表, list.size:{}", list == null ? null : list.size());

		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		userTitleResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【不分页查询用户职务列表】(UserTitleController-selectList)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

	/**
	 * 据id查询用户职务
	 * @param userTitleId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户职务")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer userTitleId) {
		logger.info("===step1:【据id查询用户职务】(UserTitleController-selectById)-传入参数, userTitleId:{}", userTitleId);

		if(userTitleId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "userTitleId不能为空");
		}

		UserTitle userTitle = userTitleService.selectById(userTitleId);
		logger.info("===step2:【据id查询用户职务】(UserTitleController-selectById)-根据id查询用户职务, userTitle:{}", userTitle);
		if(userTitle == null) {
			return new BaseRestMapResponse(SafeResultEnum.DATABASE_NOTEXIST);
		}
		UserTitleVo userTitleVo = new UserTitleVo().convertToUserTitleVo(userTitle);

		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		userTitleResponse.putAll((JSONObject) JSONObject.toJSON(userTitleVo));
		logger.info("===step3:【据id查询用户职务】(UserTitleController-selectById)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

	/**
	 * 据userId查询用户职务
	 * @param userId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户职务")
	@RequestMapping(value="/selectByUserId/{userId}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectByUserId(
		@PathVariable(value="userId",required=false) Integer userId) {
		logger.info("===step1:【据userId查询用户职务】(UserTitleController-selectByUserId)-传入参数, userId:{}", userId);

		if(userId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "userId不能为空");
		}

		UserTitle userTitle = userTitleService.selectByUserId(userId);
		logger.info("===step2:【据userId查询用户职务】(UserTitleController-selectByUserId)-根据userId查询用户职务, userTitle:{}", userTitle);
		if(userTitle == null) {
			return new BaseRestMapResponse(SafeResultEnum.DATABASE_NOTEXIST);
		}
		UserTitleVo userTitleVo = new UserTitleVo().convertToUserTitleVo(userTitle);

		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		userTitleResponse.putAll((JSONObject) JSONObject.toJSON(userTitleVo));
		logger.info("===step3:【据userId查询用户职务】(UserTitleController-selectByUserId)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

	/**
	 * 添加用户职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户职务")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody UserTitleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户职务】(UserTitleController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		UserTitle userTitle = req.convertToUserTitle();
		int i = userTitleService.insert(userTitle);
		logger.info("===step2:【添加用户职务】(UserTitleController-insert)-插入用户职务, i:{}", i);

		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户职务】(UserTitleController-insert)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

	/**
	 * 批量添加用户职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "批量添加用户职务")
	@RequestMapping(value="/insertList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertList(
		@Validated @RequestBody UserTitleListRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【批量添加用户职务】(UserTitleController-insertList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		List<UserTitle> userTitleList = req.getUserTitleList();
		int i = userTitleService.insertList(userTitleList);
		logger.info("===step2:【批量添加用户职务】(UserTitleController-insertList)-批量插入用户职务, i:{}", i);

		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		logger.info("===step3:【批量添加用户职务】(UserTitleController-insertList)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

	/**
	 * 根据id删除用户职务
	 * @param userTitleId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户职务")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer userTitleId) {
		logger.info("===step1:【根据id删除用户职务】(UserTitleController-deleteById)-传入参数, userTitleId:{}", userTitleId);

		if(userTitleId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "userTitleId不能为空");
		}

		int i = userTitleService.deleteById(userTitleId);
		logger.info("===step2:【根据id删除用户职务】(UserTitleController-deleteById)-根据id删除用户职务, i:{}", i);

		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户职务】(UserTitleController-deleteById)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

	/**
	 * 批量删除用户职务
	 * @param userTitleIds
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "批量删除用户职务")
	@RequestMapping(value="/batchDelete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse batchDelete(
		@Validated @RequestBody UserTitleIdsRequest req) {
		logger.info("===step1:【批量删除用户职务】(UserTitleController-batchDelete)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		List<Integer> userTitleIds = req.getUserTitleIds();
		int i = userTitleService.deleteByIds(userTitleIds);
		logger.info("===step2:【批量删除用户职务】(UserTitleController-batchDelete)-根据userTitleIds删除用户职务, i:{}", i);

		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		logger.info("===step3:【批量删除用户职务】(UserTitleController-batchDelete)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}


	/**
	 * 修改用户职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户职务")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody UserTitleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户职务】(UserTitleController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userTitleId = req.getUserTitleId();
		UserTitle userTitle = req.convertToUserTitle();
		userTitle.setId(userTitleId);
		int i = userTitleService.modify(userTitle);
		logger.info("===step2:【修改用户职务】(UserTitleController-modify)-修改用户职务, i:{}", i);

		BaseRestMapResponse userTitleResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户职务】(UserTitleController-modify)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

}