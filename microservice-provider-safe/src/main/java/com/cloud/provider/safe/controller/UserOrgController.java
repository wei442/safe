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
import com.cloud.provider.safe.po.UserOrg;
import com.cloud.provider.safe.rest.request.UserOrgRequest;
import com.cloud.provider.safe.rest.request.page.UserOrgPageRequest;
import com.cloud.provider.safe.service.IUserOrgService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.UserOrgVo;
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

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户机构列表")
	@RequestMapping(value="/selectUserOrgListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserOrgListByPage(
		@RequestBody UserOrgPageRequest req) {
		logger.info("===step1:【分页查询用户机构列表】(UserOrgController-selectUserOrgListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserOrg> list = userOrgService.selectUserOrgListByPage(page, req);
		logger.info("===step2:【分页查询用户机构列表】(UserOrgController-selectUserOrgListByPage)-分页查询用户机构列表, list.size:{}", list == null ? null : list.size());
		List<UserOrgVo> userOrgVoList = new UserOrgVo().convertToUserOrgVoList(list);

		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		userOrgResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(userOrgVoList));
		logger.info("===step3:【分页查询用户机构列表】(UserOrgController-selectUserOrgListByPage)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户机构列表")
	@RequestMapping(value="/selectUserOrgList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserOrgList(
		@RequestBody UserOrgPageRequest req) {
		logger.info("===step1:【不分页查询用户机构列表】(UserOrgController-selectUserOrgList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<UserOrg> list = userOrgService.selectUserOrgList(req);
		logger.info("===step2:【不分页查询用户机构列表】(UserOrgController-selectUserOrgList)-不分页查询用户机构列表, list.size:{}", list == null ? null : list.size());
		List<UserOrgVo> userOrgVoList = new UserOrgVo().convertToUserOrgVoList(list);

		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		userOrgResponse.put(PageConstants.DATA_LIST, userOrgVoList);
		logger.info("===step3:【不分页查询用户机构列表】(UserOrgController-selectUserOrgList)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

	/**
	 * 据id查询用户机构
	 * @param userOrgId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户机构")
	@RequestMapping(value="/selectUserOrgById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectUserOrgById(
		@PathVariable(value="id",required=false) Integer userOrgId) {
		logger.info("===step1:【据id查询用户机构】(selectUserOrgById-selectUserOrgById)-传入参数, userOrgId:{}", userOrgId);

		if(userOrgId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userOrgId为空");
		}

		UserOrg userOrg = userOrgService.selectUserOrgById(userOrgId);
		logger.info("===step2:【据id查询用户机构】(UserOrgController-selectUserOrgById)-根据id查询用户机构, userOrg:{}", userOrg);
		if(userOrg == null) {
			return new BaseRestMapResponse(SafeResultEnum.ORDER_SETTING_ENTITY_NOTEXIST);
		}
		UserOrgVo userOrgVo = new UserOrgVo().convertToUserOrgVo(userOrg);

		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		userOrgResponse.putAll((JSONObject) JSONObject.toJSON(userOrgVo));
		logger.info("===step3:【据id查询用户机构】(UserOrgController-selectUserOrgById)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

	/**
	 * 添加用户机构
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户机构")
	@RequestMapping(value="/insertUserOrg",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertUserOrg(
		@Validated @RequestBody UserOrgRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户机构】(UserOrgController-insertUserOrg)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		UserOrg userOrg = req.convertToUserOrg();
		int i = userOrgService.insertUserOrg(userOrg);
		logger.info("===step2:【添加用户机构】(UserOrgController-insertUserOrg)-插入用户机构, i:{}", i);

		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户机构】(UserOrgController-insertUserOrg)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

	/**
	 * 根据id删除用户机构
	 * @param userOrgId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户机构")
	@RequestMapping(value="/deleteUserOrgById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteUserOrgById(
		@PathVariable(value="id",required=false) Integer userOrgId) {
		logger.info("===step1:【根据id删除用户机构】(selectUserOrgById-deleteUserOrgById)-传入参数, userOrgId:{}", userOrgId);

		if(userOrgId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "userOrgId为空");
		}

		int i = userOrgService.deleteUserOrgById(userOrgId);
		logger.info("===step2:【根据id删除用户机构】(UserOrgController-deleteUserOrgById)-根据id查询用户机构, i:{}", i);

		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户机构】(UserOrgController-deleteUserOrgById)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

	/**
	 * 修改用户机构
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户机构")
	@RequestMapping(value="/modifyUserOrg",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyUserOrg(
		@Validated({ ModifyGroup.class }) @RequestBody UserOrgRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户机构】(UserOrgController-modifyUserOrg)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer userOrgId = req.getUserOrgId();
		UserOrg userOrg = req.convertToUserOrg();
		userOrg.setId(userOrgId);
		int i = userOrgService.modifyUserOrg(userOrg);
		logger.info("===step2:【修改用户机构】(UserOrgController-modifyUserOrg)-修改用户机构, i:{}", i);

		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户机构】(UserOrgController-modifyUserOrg)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

}