package com.cloud.provider.safe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cloud.provider.safe.base.BaseRestMapResponse;
import com.cloud.provider.safe.page.PageHelperUtil;
import com.cloud.provider.safe.po.BaseUserLoginLog;
import com.cloud.provider.safe.rest.request.BaseUserLoginLogRequest;
import com.cloud.provider.safe.rest.request.page.BaseUserLoginLogPageRequest;
import com.cloud.provider.safe.service.IBaseUserLoginLogService;
import com.cloud.provider.safe.vo.BaseUserLoginLogVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 基础用户登录日志 BaseUserLoginLogController
 * @author wei.yong
 */
@Api(tags = "基础用户登录日志")
@RestController
@RequestMapping(value="/base/user/login/log")
public class BaseUserLoginLogController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//基础用户登录日志 Service
	@Autowired
	private IBaseUserLoginLogService baseUserLoginLogService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询基础用户登录日志列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody BaseUserLoginLogPageRequest req) {
		logger.info("===step1:【分页查询基础用户登录日志列表】(BaseUserLoginLogController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<BaseUserLoginLog> list = baseUserLoginLogService.selectListByPage(page, req);
		logger.info("===step2:【分页查询基础用户登录日志列表】(BaseUserLoginLogController-selectListByPage)-分页查询基础用户登录日志列表, list.size:{}", list == null ? null : list.size());
		List<BaseUserLoginLogVo> baseUserLoginLogVoList = new BaseUserLoginLogVo().convertToBaseUserLoginLogVoList(list);

		BaseRestMapResponse baseUserLoginLogResponse = new BaseRestMapResponse();
		baseUserLoginLogResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(baseUserLoginLogVoList));
		logger.info("===step3:【分页查询基础用户登录日志列表】(BaseUserLoginLogController-selectListByPage)-返回信息, baseUserLoginLogResponse:{}", baseUserLoginLogResponse);
		return baseUserLoginLogResponse;
	}

	/**
	 * 添加基础用户登录日志
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加基础用户登录日志")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody BaseUserLoginLogRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加基础用户登录日志】(BaseUserLoginLogController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));


		BaseUserLoginLog baseUserLoginLog = req.convertToBaseUserLoginLog();
		int i = baseUserLoginLogService.insert(baseUserLoginLog);
		logger.info("===step2:【添加基础用户登录日志】(BaseUserLoginLogController-insert)-插入基础用户登录日志, i:{}", i);

		BaseRestMapResponse baseUserLoginLogResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加基础用户登录日志】(BaseUserLoginLogController-insert)-返回信息, baseUserLoginLogResponse:{}", baseUserLoginLogResponse);
		return baseUserLoginLogResponse;
	}


}