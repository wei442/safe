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
import com.cloud.provider.safe.rest.request.BaseUserInfoRequest;
import com.cloud.provider.safe.rest.request.page.BaseUserInfoPageRequest;
import com.cloud.provider.safe.service.IBaseUserInfoService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.BaseUserInfoVo;
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
	@RequestMapping(value="/selectBaseUserInfoListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectBaseUserInfoListByPage(
		@RequestBody BaseUserInfoPageRequest req) {
		logger.info("===step1:【分页查询基础用户信息列表】(BaseUserInfoController-selectBaseUserInfoListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<BaseUserInfo> list = baseUserInfoService.selectBaseUserInfoListByPage(page, req);
		logger.info("===step2:【分页查询基础用户信息列表】(BaseUserInfoController-selectBaseUserInfoListByPage)-分页查询基础用户信息列表, list.size:{}", list == null ? null : list.size());
		List<BaseUserInfoVo> baseUserInfoVoList = new BaseUserInfoVo().convertToBaseUserInfoVoList(list);

		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		baseUserInfoResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(baseUserInfoVoList));
		logger.info("===step3:【分页查询基础用户信息列表】(BaseUserInfoController-selectBaseUserInfoListByPage)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
		return baseUserInfoResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询基础用户信息")
	@RequestMapping(value="/selectBaseUserInfoList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectBaseUserInfoList(
		@RequestBody BaseUserInfoPageRequest req) {
		logger.info("===step1:【不分页查询基础用户信息列表】(BaseUserInfoController-selectBaseUserInfoList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<BaseUserInfo> list = baseUserInfoService.selectBaseUserInfoList(req);
		logger.info("===step2:【不分页查询基础用户信息列表】(BaseUserInfoController-selectBaseUserInfoList)-不分页查询基础用户信息列表, list.size:{}", list == null ? null : list.size());
		List<BaseUserInfoVo> baseUserInfoVoList = new BaseUserInfoVo().convertToBaseUserInfoVoList(list);

		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		baseUserInfoResponse.put(PageConstants.DATA_LIST, baseUserInfoVoList);
		logger.info("===step3:【不分页查询基础用户信息列表】(BaseUserInfoController-selectBaseUserInfoList)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
		return baseUserInfoResponse;
	}

	/**
	 * 据id查询基础用户信息
	 * @param baseUserInfoId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询基础用户信息")
	@RequestMapping(value="/selectBaseUserInfoById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectBaseUserInfoById(
		@PathVariable(value="id",required=false) Integer baseUserInfoId) {
		logger.info("===step1:【据id查询基础用户信息】(selectBaseUserInfoById-selectBaseUserInfoById)-传入参数, baseUserInfoId:{}", baseUserInfoId);

		if(baseUserInfoId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "baseUserInfoId为空");
		}

		BaseUserInfo baseUserInfo = baseUserInfoService.selectBaseUserInfoById(baseUserInfoId);
		logger.info("===step2:【据id查询基础用户信息】(BaseUserInfoController-selectBaseUserInfoById)-根据id查询基础用户信息, baseUserInfo:{}", baseUserInfo);
		BaseUserInfoVo baseUserInfoVo = new BaseUserInfoVo().convertToBaseUserInfoVo(baseUserInfo);

		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		baseUserInfoResponse.putAll((JSONObject) JSONObject.toJSON(baseUserInfoVo));
		logger.info("===step3:【据id查询基础用户信息】(BaseUserInfoController-selectBaseUserInfoById)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
		return baseUserInfoResponse;
	}

	/**
	 * 添加基础用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加基础用户信息")
	@RequestMapping(value="/insertBaseUserInfo",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertBaseUserInfo(
		@Validated @RequestBody BaseUserInfoRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加基础用户信息】(BaseUserInfoController-insertBaseUserInfo)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		BaseUserInfo baseUserInfo = req.convertToBaseUserInfo();
		int i = baseUserInfoService.insertBaseUserInfo(baseUserInfo);
		logger.info("===step2:【添加基础用户信息】(BaseUserInfoController-insertBaseUserInfo)-插入基础用户信息, i:{}", i);

		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加基础用户信息】(BaseUserInfoController-insertBaseUserInfo)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
		return baseUserInfoResponse;
	}

	/**
	 * 根据id删除基础用户信息
	 * @param baseUserInfoId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除基础用户信息")
	@RequestMapping(value="/deleteBaseUserInfoById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteBaseUserInfoById(
		@PathVariable(value="id",required=false) Integer baseUserInfoId) {
		logger.info("===step1:【根据id删除基础用户信息】(selectBaseUserInfoById-deleteBaseUserInfoById)-传入参数, baseUserInfoId:{}", baseUserInfoId);

		if(baseUserInfoId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "baseUserInfoId为空");
		}

		int i = baseUserInfoService.deleteBaseUserInfoById(baseUserInfoId);
		logger.info("===step2:【根据id删除基础用户信息】(BaseUserInfoController-deleteBaseUserInfoById)-根据id查询基础用户信息, i:{}", i);

		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除基础用户信息】(BaseUserInfoController-deleteBaseUserInfoById)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
		return baseUserInfoResponse;
	}

	/**
	 * 修改基础用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改基础用户信息")
	@RequestMapping(value="/modifyBaseUserInfo",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyBaseUserInfo(
		@Validated({ ModifyGroup.class }) @RequestBody BaseUserInfoRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改基础用户信息】(BaseUserInfoController-modifyBaseUserInfo)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer baseUserInfoId = req.getBaseUserInfoId();
		BaseUserInfo baseUserInfo = req.convertToBaseUserInfo();
		baseUserInfo.setId(baseUserInfoId);
		int i = baseUserInfoService.modifyBaseUserInfo(baseUserInfo);
		logger.info("===step2:【修改基础用户信息】(BaseUserInfoController-modifyBaseUserInfo)-修改基础用户信息, i:{}", i);

		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改基础用户信息】(BaseUserInfoController-modifyBaseUserInfo)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
		return baseUserInfoResponse;
	}


}