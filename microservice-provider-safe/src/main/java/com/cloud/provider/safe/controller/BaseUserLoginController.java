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
import com.cloud.provider.safe.po.BaseUserLogin;
import com.cloud.provider.safe.rest.request.base.user.BaseUserLoginRequest;
import com.cloud.provider.safe.rest.request.page.base.user.BaseUserLoginPageRequest;
import com.cloud.provider.safe.service.IBaseUserLoginService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.base.user.BaseUserLoginVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 基础用户登录 BaseUserLoginController
 * @author wei.yong
 */
@Api(tags = "基础用户登录")
@RestController
@RequestMapping(value="/base/user/login")
public class BaseUserLoginController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//基础用户登录Service
	@Autowired
	private IBaseUserLoginService baseUserLoginService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询基础用户登录列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody BaseUserLoginPageRequest req) {
		logger.info("===step1:【分页查询基础用户登录列表】(BaseUserLoginController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<BaseUserLogin> list = baseUserLoginService.selectListByPage(page, req);
		logger.info("===step2:【分页查询基础用户登录列表】(BaseUserLoginController-selectListByPage)-分页查询基础用户登录列表, list.size:{}", list == null ? null : list.size());
		List<BaseUserLoginVo> dataList = new BaseUserLoginVo().convertToBaseUserLoginVoList(list);

		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		baseUserLoginResponse.put(PageConstants.PAGE, PageHelperUtil.INSTANCE.getPageVo(list));
		baseUserLoginResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【分页查询基础用户登录列表】(BaseUserLoginController-selectListByPage)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
		return baseUserLoginResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询基础用户登录列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody BaseUserLoginPageRequest req) {
		logger.info("===step1:【不分页查询基础用户登录列表】(BaseUserLoginController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<BaseUserLogin> list = baseUserLoginService.selectList(req);
		logger.info("===step2:【不分页查询基础用户登录列表】(BaseUserLoginController-selectList)-不分页查询基础用户登录列表, list.size:{}", list == null ? null : list.size());
		List<BaseUserLoginVo> dataList = new BaseUserLoginVo().convertToBaseUserLoginVoList(list);

		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		baseUserLoginResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【不分页查询基础用户登录列表】(BaseUserLoginController-selectList)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
		return baseUserLoginResponse;
	}

	/**
	 * 据id查询基础用户登录
	 * @param baseUserLoginId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询基础用户登录")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer baseUserLoginId) {
		logger.info("===step1:【据id查询基础用户登录】(BaseUserLoginController-selectById)-传入参数, baseUserLoginId:{}", baseUserLoginId);

		if(baseUserLoginId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "baseUserLoginId不能为空");
		}

		BaseUserLogin baseUserLogin = baseUserLoginService.selectById(baseUserLoginId);
		logger.info("===step2:【据id查询基础用户登录】(BaseUserLoginController-selectById)-根据id查询基础用户登录, baseUserLogin:{}", baseUserLogin);
		if(baseUserLogin == null) {
			return new BaseRestMapResponse(SafeResultEnum.DATABASE_NOTEXIST);
		}
		BaseUserLoginVo baseUserLoginVo = new BaseUserLoginVo().convertToBaseUserLoginVo(baseUserLogin);

		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		baseUserLoginResponse.putAll((JSONObject) JSONObject.toJSON(baseUserLoginVo));
		logger.info("===step3:【据id查询基础用户登录】(BaseUserLoginController-selectById)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
		return baseUserLoginResponse;
	}

	/**
	 * 添加基础用户登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加基础用户登录")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody BaseUserLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加基础用户登录】(BaseUserLoginController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		BaseUserLogin baseUserLogin = req.convertToBaseUserLogin();
		int i = baseUserLoginService.insert(baseUserLogin);
		logger.info("===step2:【添加基础用户登录】(BaseUserLoginController-insert)-插入基础用户登录, i:{}", i);

		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加基础用户登录】(BaseUserLoginController-insert)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
		return baseUserLoginResponse;
	}

	/**
	 * 根据id删除基础用户登录
	 * @param baseUserLoginId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除基础用户登录")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer baseUserLoginId) {
		logger.info("===step1:【根据id删除基础用户登录】(selectById-deleteById)-传入参数, baseUserLoginId:{}", baseUserLoginId);

		if(baseUserLoginId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "baseUserLoginId不能为空");
		}

		int i = baseUserLoginService.deleteById(baseUserLoginId);
		logger.info("===step2:【根据id删除基础用户登录】(BaseUserLoginController-deleteById)-根据id查询基础用户登录, i:{}", i);

		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除基础用户登录】(BaseUserLoginController-deleteById)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
		return baseUserLoginResponse;
	}

	/**
	 * 基础用户登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "基础用户登录")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody BaseUserLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【基础用户登录】(BaseUserLoginController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer baseUserLoginId = req.getBaseUserLoginId();
		BaseUserLogin baseUserLogin = req.convertToBaseUserLogin();
		baseUserLogin.setId(baseUserLoginId);
		int i = baseUserLoginService.modify(baseUserLogin);
		logger.info("===step2:【基础用户登录】(BaseUserLoginController-modify)-基础用户登录, i:{}", i);

		BaseRestMapResponse baseUserLoginResponse = new BaseRestMapResponse();
		logger.info("===step3:【基础用户登录】(BaseUserLoginController-modify)-返回信息, baseUserLoginResponse:{}", baseUserLoginResponse);
		return baseUserLoginResponse;
	}

}