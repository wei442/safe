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
import com.cloud.provider.safe.po.UserQualityAttachment;
import com.cloud.provider.safe.rest.request.page.user.UserQualityAttachmentPageRequest;
import com.cloud.provider.safe.rest.request.user.UserQualityAttachmentRequest;
import com.cloud.provider.safe.service.IUserQualityAttachmentService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.user.UserQualityAttachmentVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户资质附件 UserQualityAttachmentController
 * @author wei.yong
 */
@Api(tags = "用户资质附件")
@RestController
@RequestMapping(value="/user/quality/attachment")
public class UserQualityAttachmentController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户资质附件Service
	@Autowired
	private IUserQualityAttachmentService userQualityAttachmentService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户资质附件列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody UserQualityAttachmentPageRequest req) {
		logger.info("===step1:【分页查询用户资质附件列表】(UserQualityAttachmentController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserQualityAttachment> list = userQualityAttachmentService.selectListByPage(page, req);
		logger.info("===step2:【分页查询用户资质附件列表】(UserQualityAttachmentController-selectListByPage)-分页查询用户资质附件列表, list.size:{}", list == null ? null : list.size());
		List<UserQualityAttachmentVo> userQualityAttachmentVoList = new UserQualityAttachmentVo().convertToUserQualityAttachmentVoList(list);

		BaseRestMapResponse userQualityAttachmentResponse = new BaseRestMapResponse();
		userQualityAttachmentResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(userQualityAttachmentVoList));
		logger.info("===step3:【分页查询用户资质附件列表】(UserQualityAttachmentController-selectListByPage)-返回信息, userQualityAttachmentResponse:{}", userQualityAttachmentResponse);
		return userQualityAttachmentResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户资质附件列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody UserQualityAttachmentPageRequest req) {
		logger.info("===step1:【不分页查询用户资质附件列表】(UserQualityAttachmentController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<UserQualityAttachment> list = userQualityAttachmentService.selectList(req);
		logger.info("===step2:【不分页查询用户资质附件列表】(UserQualityAttachmentController-selectList)-不分页查询用户资质附件列表, list.size:{}", list == null ? null : list.size());
		List<UserQualityAttachmentVo> userQualityAttachmentVoList = new UserQualityAttachmentVo().convertToUserQualityAttachmentVoList(list);

		BaseRestMapResponse userQualityAttachmentResponse = new BaseRestMapResponse();
		userQualityAttachmentResponse.put(PageConstants.DATA_LIST, userQualityAttachmentVoList);
		logger.info("===step3:【不分页查询用户资质附件列表】(UserQualityAttachmentController-selectList)-返回信息, userQualityAttachmentResponse:{}", userQualityAttachmentResponse);
		return userQualityAttachmentResponse;
	}

	/**
	 * 据id查询用户资质附件
	 * @param userQualityAttachmentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户资质附件")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer userQualityAttachmentId) {
		logger.info("===step1:【据id查询用户资质附件】(selectById-selectById)-传入参数, userQualityAttachmentId:{}", userQualityAttachmentId);

		if(userQualityAttachmentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userQualityAttachmentId不能为空");
		}

		UserQualityAttachment userQualityAttachment = userQualityAttachmentService.selectById(userQualityAttachmentId);
		logger.info("===step2:【据id查询用户资质附件】(UserQualityAttachmentController-selectById)-根据id查询用户资质附件, userQualityAttachment:{}", userQualityAttachment);
		UserQualityAttachmentVo userQualityAttachmentVo = new UserQualityAttachmentVo().convertToUserQualityAttachmentVo(userQualityAttachment);

		BaseRestMapResponse userQualityAttachmentResponse = new BaseRestMapResponse();
		userQualityAttachmentResponse.putAll((JSONObject) JSONObject.toJSON(userQualityAttachmentVo));
		logger.info("===step3:【据id查询用户资质附件】(UserQualityAttachmentController-selectById)-返回信息, userQualityAttachmentResponse:{}", userQualityAttachmentResponse);
		return userQualityAttachmentResponse;
	}

	/**
	 * 添加用户资质附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户资质附件")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody UserQualityAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户资质附件】(UserQualityAttachmentController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		UserQualityAttachment userQualityAttachment = req.convertToUserQualityAttachment();
		int i = userQualityAttachmentService.insert(userQualityAttachment);
		logger.info("===step2:【添加用户资质附件】(UserQualityAttachmentController-insert)-插入用户资质附件, i:{}", i);

		BaseRestMapResponse userQualityAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户资质附件】(UserQualityAttachmentController-insert)-返回信息, userQualityAttachmentResponse:{}", userQualityAttachmentResponse);
		return userQualityAttachmentResponse;
	}

	/**
	 * 根据id删除用户资质附件
	 * @param userQualityAttachmentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户资质附件")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer userQualityAttachmentId) {
		logger.info("===step1:【根据id删除用户资质附件】(selectById-deleteById)-传入参数, userQualityAttachmentId:{}", userQualityAttachmentId);

		if(userQualityAttachmentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userQualityAttachmentId不能为空");
		}

		int i = userQualityAttachmentService.deleteById(userQualityAttachmentId);
		logger.info("===step2:【根据id删除用户资质附件】(UserQualityAttachmentController-deleteById)-根据id查询用户资质附件, i:{}", i);

		BaseRestMapResponse userQualityAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户资质附件】(UserQualityAttachmentController-deleteById)-返回信息, userQualityAttachmentResponse:{}", userQualityAttachmentResponse);
		return userQualityAttachmentResponse;
	}

	/**
	 * 修改用户资质附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户资质附件")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody UserQualityAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户资质附件】(UserQualityAttachmentController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userQualityAttachmentId = req.getUserQualityAttachmentId();
		UserQualityAttachment userQualityAttachment = req.convertToUserQualityAttachment();
		userQualityAttachment.setId(userQualityAttachmentId);
		int i = userQualityAttachmentService.modify(userQualityAttachment);
		logger.info("===step2:【修改用户资质附件】(UserQualityAttachmentController-modify)-修改用户资质附件, i:{}", i);

		BaseRestMapResponse userQualityAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户资质附件】(UserQualityAttachmentController-modify)-返回信息, userQualityAttachmentResponse:{}", userQualityAttachmentResponse);
		return userQualityAttachmentResponse;
	}

}