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
import com.cloud.provider.safe.po.UserQuality;
import com.cloud.provider.safe.rest.request.UserQualityRequest;
import com.cloud.provider.safe.rest.request.page.UserQualityPageRequest;
import com.cloud.provider.safe.service.IUserQualityService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.UserQualityVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户资质 UserQualityController
 * @author wei.yong
 */
@Api(tags = "用户资质")
@RestController
@RequestMapping(value="/userQuality")
public class UserQualityController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户资质Service
	@Autowired
	private IUserQualityService userQualityService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户资质列表")
	@RequestMapping(value="/selectUserQualityListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserQualityListByPage(
		@RequestBody UserQualityPageRequest req) {
		logger.info("===step1:【分页查询用户资质列表】(UserQualityController-selectUserQualityListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		UserQuality userQuality = new UserQuality();
		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserQuality> list = userQualityService.selectUserQualityListByPage(page, userQuality);
		logger.info("===step2:【分页查询用户资质列表】(UserQualityController-selectUserQualityListByPage)-分页查询用户资质列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}
		List<UserQualityVo> userQualityVoList = new UserQualityVo().convertToUserQualityVoList(list);

		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		userQualityResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(userQualityVoList));
		logger.info("===step3:【分页查询用户资质列表】(UserQualityController-selectUserQualityListByPage)-返回信息, userQualityResponse:{}", userQualityResponse);
		return userQualityResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户资质列表")
	@RequestMapping(value="/selectUserQualityList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserQualityList(
		@RequestBody UserQualityPageRequest req) {
		logger.info("===step1:【不分页查询用户资质列表】(UserQualityController-selectUserQualityList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		UserQuality userQuality = new UserQuality();
		List<UserQuality> list = null;
		list = userQualityService.selectUserQualityList(userQuality);
		logger.info("===step2:【不分页查询用户资质列表】(UserQualityController-selectUserQualityList)-不分页查询用户资质列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}
		List<UserQualityVo> userQualityVoList = new UserQualityVo().convertToUserQualityVoList(list);

		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		userQualityResponse.put(PageConstants.DATA_LIST, userQualityVoList);
		logger.info("===step3:【不分页查询用户资质列表】(UserQualityController-selectUserQualityList)-返回信息, userQualityResponse:{}", userQualityResponse);
		return userQualityResponse;
	}

	/**
	 * 据id查询用户资质
	 * @param userQualityId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户资质")
	@RequestMapping(value="/selectUserQualityById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserQualityById(
		@PathVariable(value="id",required=false) Integer userQualityId) {
		logger.info("===step1:【据id查询用户资质】(selectUserQualityById-selectUserQualityById)-传入参数, userQualityId:{}", userQualityId);

		if(userQualityId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userQualityId为空");
		}

		UserQuality userQuality = userQualityService.selectUserQualityById(userQualityId);
		logger.info("===step2:【据id查询用户资质】(UserQualityController-selectUserQualityById)-根据id查询用户资质, userQuality:{}", userQuality);
		if(userQuality == null) {
			return new BaseRestMapResponse(SafeResultEnum.ORDER_SETTING_ENTITY_NOTEXIST);
		}
		UserQualityVo userQualityVo = new UserQualityVo().convertToUserQualityVo(userQuality);

		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		userQualityResponse.putAll((JSONObject) JSONObject.toJSON(userQualityVo));
		logger.info("===step3:【据id查询用户资质】(UserQualityController-selectUserQualityById)-返回信息, userQualityResponse:{}", userQualityResponse);
		return userQualityResponse;
	}

	/**
	 * 添加用户资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户资质")
	@RequestMapping(value="/insertUserQuality",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertUserQuality(
		@Validated @RequestBody UserQualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户资质】(UserQualityController-insertUserQuality)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		UserQuality userQuality = req.convertToUserQuality();
		int i = userQualityService.insertUserQuality(userQuality);
		logger.info("===step2:【添加用户资质】(UserQualityController-insertUserQuality)-插入用户资质, i:{}", i);

		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户资质】(UserQualityController-insertUserQuality)-返回信息, userQualityResponse:{}", userQualityResponse);
		return userQualityResponse;
	}

	/**
	 * 根据id删除用户资质
	 * @param userQualityId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户资质")
	@RequestMapping(value="/deleteUserQualityById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteUserQualityById(
		@PathVariable(value="id",required=false) Integer userQualityId) {
		logger.info("===step1:【根据id删除用户资质】(selectUserQualityById-deleteUserQualityById)-传入参数, userQualityId:{}", userQualityId);

		if(userQualityId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userQualityId为空");
		}

		int i = userQualityService.deleteUserQualityById(userQualityId);
		logger.info("===step2:【根据id删除用户资质】(UserQualityController-deleteUserQualityById)-根据id查询用户资质, i:{}", i);

		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户资质】(UserQualityController-deleteUserQualityById)-返回信息, userQualityResponse:{}", userQualityResponse);
		return userQualityResponse;
	}

	/**
	 * 修改用户资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户资质")
	@RequestMapping(value="/modifyUserQuality",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyUserQuality(
		@Validated({ ModifyGroup.class }) @RequestBody UserQualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户资质】(UserQualityController-modifyUserQuality)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer userQualityId = req.getUserQualityId();
		UserQuality userQuality = req.convertToUserQuality();
		userQuality.setId(userQualityId);
		int i = userQualityService.modifyUserQuality(userQuality);
		logger.info("===step2:【修改用户资质】(UserQualityController-modifyUserQuality)-修改用户资质, i:{}", i);

		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户资质】(UserQualityController-modifyUserQuality)-返回信息, userQualityResponse:{}", userQualityResponse);
		return userQualityResponse;
	}

}