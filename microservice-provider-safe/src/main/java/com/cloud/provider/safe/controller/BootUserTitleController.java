package com.cloud.provider.safe.controller;

import java.util.List;
import java.util.Map;

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
import com.cloud.provider.safe.boot.BootRestMapResponse;
import com.cloud.provider.safe.page.PageHelperUtil;
import com.cloud.provider.safe.po.UserTitle;
import com.cloud.provider.safe.rest.request.UserTitleRequest;
import com.cloud.provider.safe.service.IBootUserTitleService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.UserTitleVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 订单 BootUserTitleController
 * @author wang.tongmeng
 */
@Api(tags = "用户职务")
@RestController
@RequestMapping(value="/boot/oms/orderReturnReason")
public class BootUserTitleController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//订单Service
	@Autowired
	private IBootUserTitleService userTitleService;

	/**
	 * 分页用户职务
	 * @param req
	 * @return BootRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户职务列表")
	@RequestMapping(value="/selectUserTitleListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserTitleListByPage(
		@RequestBody UserTitleRequest req) {
		logger.info("===step1:【分页查询用户职务列表】(BootUserTitleController-selectUserTitleListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		UserTitle userTitle = new UserTitle();
		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserTitle> list = userTitleService.selectUserTitleListByPage(page, userTitle);
		logger.info("===step2:【分页查询用户职务列表】(BootUserTitleController-selectUserTitleListByPage)-分页查询用户职务列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BootRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}

		Map<String, Object> pageListMap = PageHelperUtil.INSTANCE.getPageListMap(list);
		BootRestMapResponse userTitleResponse = new BootRestMapResponse();
		userTitleResponse.putAll(pageListMap);
		logger.info("===step3:【分页查询用户职务列表】(BootUserTitleController-selectUserTitleListByPage)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

	/**
	 * 查询用户职务列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws MallException
	 */
	@ApiOperation(value = "不分页查询用户职务")
	@RequestMapping(value="/selectUserTitleList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserTitleList(
		@RequestBody UserTitleRequest req) {
		logger.info("===step1:【不分页查询用户职务】(BootUserTitleController-selectUserTitleList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		UserTitle userTitle = new UserTitle();
		List<UserTitle> list = null;
		list = userTitleService.selectUserTitleList(userTitle);
		logger.info("===step2:【不分页查询用户职务】(BootUserTitleController-selectUserTitleList)-查询用户职务列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BootRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}

		BootRestMapResponse userTitleResponse = new BootRestMapResponse();
		userTitleResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【不分页查询用户职务】(BootUserTitleController-selectUserTitleList)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

	/**
	 * 据id查询用户职务
	 * @param userTitleId
	 * @return BootRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户职务")
	@RequestMapping(value="/selectUserTitleById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserTitleById(
		@PathVariable(value="id",required=false) Integer userTitleId) {
		logger.info("===step1:【据id查询用户职务】(selectUserTitleById-selectUserTitleById)-传入参数, userTitleId:{}", userTitleId);

		if(userTitleId == null) {
			return new BootRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userTitleId为空");
		}

		UserTitle userTitle = userTitleService.selectUserTitleById(userTitleId);
		logger.info("===step2:【据id查询用户职务】(BootUserTitleController-selectUserTitleById)-根据id查询用户职务, userTitle:{}", userTitle);
		if(userTitle == null) {
			return new BootRestMapResponse(SafeResultEnum.ORDER_SETTING_ENTITY_NOTEXIST);
		}
		UserTitleVo userTitleVo = new UserTitleVo().convertToUserTitleVo(userTitle);

		BootRestMapResponse userTitleResponse = new BootRestMapResponse();
		userTitleResponse.putAll((JSONObject) JSONObject.toJSON(userTitleVo));
		logger.info("===step3:【据id查询用户职务】(BootUserTitleController-selectUserTitleById)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

	/**
	 * 添加用户职务
	 * @param req
	 * @param bindingResult
	 * @param request
	 * @param response
	 * @return
	 */
	@ApiOperation(value = "添加用户职务")
	@RequestMapping(value="/insertUserTitle",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertUserTitle(
		@Validated @RequestBody UserTitleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户职务】(BootUserTitleController-insertUserTitle)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		UserTitle userTitle = req.convertToUserTitle();
		int i = userTitleService.insertUserTitle(userTitle);
		logger.info("===step2:【添加用户职务】(BootUserTitleController-insertUserTitle)-插入用户职务, i:{}", i);

		BootRestMapResponse userTitleResponse = new BootRestMapResponse();
		logger.info("===step3:【添加用户职务】(BootUserTitleController-insertUserTitle)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

	/**
	 * 根据id删除用户职务
	 * @param userTitleId
	 * @return BootRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户职务")
	@RequestMapping(value="/deleteUserTitleById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse deleteUserTitleById(
		@PathVariable(value="id",required=false) Integer userTitleId) {
		logger.info("===step1:【根据id删除用户职务】(selectUserTitleById-deleteUserTitleById)-传入参数, userTitleId:{}", userTitleId);

		if(userTitleId == null) {
			return new BootRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userTitleId为空");
		}

		int i = userTitleService.deleteUserTitleById(userTitleId);
		logger.info("===step2:【根据id删除用户职务】(BootUserTitleController-deleteUserTitleById)-根据id查询用户职务, i:{}", i);

		BootRestMapResponse userTitleResponse = new BootRestMapResponse();
		logger.info("===step3:【根据id删除用户职务】(BootUserTitleController-deleteUserTitleById)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}

	/**
	 * 修改用户职务
	 * @param req
	 * @param bindingResult
	 * @return BootRestMapResponse
	 */
	@ApiOperation(value = "修改用户职务")
	@RequestMapping(value="/modifyUserTitle",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyUserTitle(
		@Validated({ ModifyGroup.class }) @RequestBody UserTitleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户职务】(BootUserTitleController-modifyUserTitle)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

//		UserTitle userTitle = userTitleService.selectUserTitleById(userTitleId);
//		logger.info("===step2:【修改用户职务】(BootUserTitleController-modifyUserTitle)-根据userTitleId查询用户职务, userTitle:{}", userTitle);

		Integer userTitleId = req.getUserTitleId();
		UserTitle userTitle = req.convertToUserTitle();
		userTitle.setId(userTitleId);
		int i = userTitleService.modifyUserTitle(userTitle);
		logger.info("===step3:【修改用户职务】(BootUserTitleController-modifyUserTitle)-修改用户职务, i:{}", i);

		BootRestMapResponse userTitleResponse = new BootRestMapResponse();
		logger.info("===step4:【修改用户职务】(BootUserTitleController-modifyUserTitle)-返回信息, userTitleResponse:{}", userTitleResponse);
		return userTitleResponse;
	}


}