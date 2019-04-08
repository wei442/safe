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
import com.cloud.provider.safe.rest.request.page.user.UserQualityPageRequest;
import com.cloud.provider.safe.rest.request.user.UserQualityRequest;
import com.cloud.provider.safe.service.IUserQualityService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.user.UserQualityVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户资质 UserQualityController
 * @author wei.yong
 */
@Api(tags = "用户资质")
@RestController
@RequestMapping(value="/user/quality")
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
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody UserQualityPageRequest req) {
		logger.info("===step1:【分页查询用户资质列表】(UserQualityController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserQuality> list = userQualityService.selectListByPage(page, req);
		logger.info("===step2:【分页查询用户资质列表】(UserQualityController-selectListByPage)-分页查询用户资质列表, list.size:{}", list == null ? null : list.size());
		List<UserQualityVo> userQualityVoList = new UserQualityVo().convertToUserQualityVoList(list);

		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		userQualityResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(userQualityVoList));
		logger.info("===step3:【分页查询用户资质列表】(UserQualityController-selectListByPage)-返回信息, userQualityResponse:{}", userQualityResponse);
		return userQualityResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户资质列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody UserQualityPageRequest req) {
		logger.info("===step1:【不分页查询用户资质列表】(UserQualityController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<UserQuality> list = userQualityService.selectList(req);
		logger.info("===step2:【不分页查询用户资质列表】(UserQualityController-selectList)-不分页查询用户资质列表, list.size:{}", list == null ? null : list.size());
		List<UserQualityVo> userQualityVoList = new UserQualityVo().convertToUserQualityVoList(list);

		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		userQualityResponse.put(PageConstants.DATA_LIST, userQualityVoList);
		logger.info("===step3:【不分页查询用户资质列表】(UserQualityController-selectList)-返回信息, userQualityResponse:{}", userQualityResponse);
		return userQualityResponse;
	}

	/**
	 * 据id查询用户资质
	 * @param userQualityId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户资质")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer userQualityId) {
		logger.info("===step1:【据id查询用户资质】(selectById-selectById)-传入参数, userQualityId:{}", userQualityId);

		if(userQualityId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userQualityId不能为空");
		}

		UserQuality userQuality = userQualityService.selectById(userQualityId);
		logger.info("===step2:【据id查询用户资质】(UserQualityController-selectById)-根据id查询用户资质, userQuality:{}", userQuality);
		UserQualityVo userQualityVo = new UserQualityVo().convertToUserQualityVo(userQuality);

		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		userQualityResponse.putAll((JSONObject) JSONObject.toJSON(userQualityVo));
		logger.info("===step3:【据id查询用户资质】(UserQualityController-selectById)-返回信息, userQualityResponse:{}", userQualityResponse);
		return userQualityResponse;
	}

	/**
	 * 据userId查询用户资质
	 * @param userId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户资质")
	@RequestMapping(value="/selectByUserId/{userId}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectByUserId(
		@PathVariable(value="userId",required=false) Integer userId) {
		logger.info("===step1:【据userId查询用户资质】(selectById-selectByUserId)-传入参数, userId:{}", userId);

		if(userId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userId不能为空");
		}

		UserQuality userQuality = userQualityService.selectByUserId(userId);
		logger.info("===step2:【据userId查询用户资质】(UserQualityController-selectByUserId)-根据userId查询用户资质, userQuality:{}", userQuality);
		UserQualityVo userQualityVo = new UserQualityVo().convertToUserQualityVo(userQuality);

		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		userQualityResponse.putAll((JSONObject) JSONObject.toJSON(userQualityVo));
		logger.info("===step3:【据userId查询用户资质】(UserQualityController-selectByUserId)-返回信息, userQualityResponse:{}", userQualityResponse);
		return userQualityResponse;
	}

	/**
	 * 添加用户资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户资质")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertUserQuality(
		@Validated @RequestBody UserQualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户资质】(UserQualityController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		UserQuality userQuality = req.convertToUserQuality();
		int i = userQualityService.insert(userQuality);
		logger.info("===step2:【添加用户资质】(UserQualityController-insert)-插入用户资质, i:{}", i);

		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户资质】(UserQualityController-insert)-返回信息, userQualityResponse:{}", userQualityResponse);
		return userQualityResponse;
	}

	/**
	 * 根据id删除用户资质
	 * @param userQualityId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户资质")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer userQualityId) {
		logger.info("===step1:【根据id删除用户资质】(UserQualityController-deleteById)-传入参数, userQualityId:{}", userQualityId);

		if(userQualityId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userQualityId不能为空");
		}

		int i = userQualityService.deleteById(userQualityId);
		logger.info("===step2:【根据id删除用户资质】(UserQualityController-deleteById)-根据id查询用户资质, i:{}", i);

		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户资质】(UserQualityController-deleteById)-返回信息, userQualityResponse:{}", userQualityResponse);
		return userQualityResponse;
	}

	/**
	 * 根据ids删除用户资质
	 * @param userQualityIds
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据ids删除用户资质")
	@RequestMapping(value="/deleteByIds/{ids}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteByIds(
		@PathVariable(value="ids",required=false) List<Integer> userQualityIds) {
		logger.info("===step1:【根据ids删除用户资质】(UserQualityController-deleteByIds)-传入参数, userQualityIds:{}", userQualityIds);

		if(userQualityIds == null || userQualityIds.isEmpty()) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userQualityIds不能为空");
		}

		int i = userQualityService.deleteByIds(userQualityIds);
		logger.info("===step2:【根据ids删除用户资质】(UserQualityController-deleteByIds)-根据ids删除用户资质, i:{}", i);

		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据ids删除用户资质】(UserQualityController-deleteByIds)-返回信息, userQualityResponse:{}", userQualityResponse);
		return userQualityResponse;
	}

	/**
	 * 修改用户资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户资质")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody UserQualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户资质】(UserQualityController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));


		Integer userQualityId = req.getUserQualityId();
		UserQuality userQuality = req.convertToUserQuality();
		userQuality.setId(userQualityId);
		int i = userQualityService.modify(userQuality);
		logger.info("===step2:【修改用户资质】(UserQualityController-modify)-修改用户资质, i:{}", i);

		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户资质】(UserQualityController-modify)-返回信息, userQualityResponse:{}", userQualityResponse);
		return userQualityResponse;
	}

}