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
import com.cloud.provider.safe.po.BaseUserInfo;
import com.cloud.provider.safe.rest.request.base.user.BaseUserInfoRequest;
import com.cloud.provider.safe.rest.request.page.base.user.BaseUserInfoPageRequest;
import com.cloud.provider.safe.service.IBaseUserInfoService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.base.user.BaseUserInfoVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 基础用户信息 BaseUserInfoController
 * @author wei.yong
 */
@Api(tags = "基础用户信息")
@RestController
@RequestMapping(value="/base/user/info")
public class BaseUserInfoController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//基础用户信息Service
	@Autowired
	private IBaseUserInfoService baseUserInfoService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询基础用户信息列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody BaseUserInfoPageRequest req) {
		logger.info("===step1:【分页查询基础用户信息列表】(BaseUserInfoController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<BaseUserInfo> list = baseUserInfoService.selectListByPage(page, req);
		logger.info("===step2:【分页查询基础用户信息列表】(BaseUserInfoController-selectListByPage)-分页查询基础用户信息列表, list.size:{}", list == null ? null : list.size());
		List<BaseUserInfoVo> dataList = new BaseUserInfoVo().convertToBaseUserInfoVoList(list);

		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		baseUserInfoResponse.put(PageConstants.PAGE, PageHelperUtil.INSTANCE.getPageVo(list));
		baseUserInfoResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【分页查询基础用户信息列表】(BaseUserInfoController-selectListByPage)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
		return baseUserInfoResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询基础用户信息")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody BaseUserInfoPageRequest req) {
		logger.info("===step1:【不分页查询基础用户信息列表】(BaseUserInfoController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<BaseUserInfo> list = baseUserInfoService.selectList(req);
		logger.info("===step2:【不分页查询基础用户信息列表】(BaseUserInfoController-selectList)-不分页查询基础用户信息列表, list.size:{}", list == null ? null : list.size());
		List<BaseUserInfoVo> dataList = new BaseUserInfoVo().convertToBaseUserInfoVoList(list);

		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		baseUserInfoResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【不分页查询基础用户信息列表】(BaseUserInfoController-selectList)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
		return baseUserInfoResponse;
	}

	/**
	 * 据id查询基础用户信息
	 * @param baseUserId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询基础用户信息")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer baseUserId) {
		logger.info("===step1:【据id查询基础用户信息】(BaseUserInfoController-selectById)-传入参数, baseUserId:{}", baseUserId);

		if(baseUserId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "baseUserInfoId不能为空");
		}

		BaseUserInfo baseUserInfo = baseUserInfoService.selectById(baseUserId);
		logger.info("===step2:【据id查询基础用户信息】(BaseUserInfoController-selectById)-根据id查询基础用户信息, baseUserInfo:{}", baseUserInfo);
		if(baseUserInfo == null) {
			return new BaseRestMapResponse(SafeResultEnum.DATABASE_NOTEXIST);
		}
		BaseUserInfoVo baseUserInfoVo = new BaseUserInfoVo().convertToBaseUserInfoVo(baseUserInfo);

		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		baseUserInfoResponse.putAll((JSONObject) JSONObject.toJSON(baseUserInfoVo));
		logger.info("===step3:【据id查询基础用户信息】(BaseUserInfoController-selectById)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
		return baseUserInfoResponse;
	}

	/**
	 * 添加基础用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加基础用户信息")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody BaseUserInfoRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加基础用户信息】(BaseUserInfoController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		BaseUserInfo baseUserInfo = req.convertToBaseUserInfo();
		int i = baseUserInfoService.insert(baseUserInfo);
		logger.info("===step2:【添加基础用户信息】(BaseUserInfoController-insert)-插入基础用户信息, i:{}", i);

		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加基础用户信息】(BaseUserInfoController-insert)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
		return baseUserInfoResponse;
	}

	/**
	 * 根据id删除基础用户信息
	 * @param baseUserId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除基础用户信息")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer baseUserId) {
		logger.info("===step1:【根据id删除基础用户信息】(selectById-deleteById)-传入参数, baseUserId:{}", baseUserId);

		if(baseUserId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "baseUserInfoId不能为空");
		}

		int i = baseUserInfoService.deleteById(baseUserId);
		logger.info("===step2:【根据id删除基础用户信息】(BaseUserInfoController-deleteById)-根据id查询基础用户信息, i:{}", i);

		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除基础用户信息】(BaseUserInfoController-deleteById)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
		return baseUserInfoResponse;
	}

	/**
	 * 修改基础用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改基础用户信息")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody BaseUserInfoRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改基础用户信息】(BaseUserInfoController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer baseUserId = req.getBaseUserId();
		BaseUserInfo baseUserInfo = req.convertToBaseUserInfo();
		baseUserInfo.setId(baseUserId);
		int i = baseUserInfoService.modify(baseUserInfo);
		logger.info("===step2:【修改基础用户信息】(BaseUserInfoController-modify)-修改基础用户信息, i:{}", i);

		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改基础用户信息】(BaseUserInfoController-modify)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
		return baseUserInfoResponse;
	}


}