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
import com.cloud.provider.safe.po.UserMenu;
import com.cloud.provider.safe.rest.request.page.user.UserMenuPageRequest;
import com.cloud.provider.safe.rest.request.user.UserMenuIdsRequest;
import com.cloud.provider.safe.rest.request.user.UserMenuRequest;
import com.cloud.provider.safe.service.IUserMenuService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.user.UserMenuVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户菜单 UserMenuController
 * @author wei.yong
 */
@Api(tags = "用户菜单")
@RestController
@RequestMapping(value="/user/menu")
public class UserMenuController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户菜单Service
	@Autowired
	private IUserMenuService userMenuService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户菜单列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@Validated @RequestBody UserMenuPageRequest req) {
		logger.info("===step1:【分页查询用户菜单列表】(UserMenuController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserMenu> list = userMenuService.selectListByPage(page, req);
		logger.info("===step2:【分页查询用户菜单列表】(UserMenuController-selectListByPage)-分页查询用户菜单列表, list.size:{}", list == null ? null : list.size());
		List<UserMenuVo> userMenuVoList = new UserMenuVo().convertToUserMenuVoList(list);

		BaseRestMapResponse userMenuResponse = new BaseRestMapResponse();
		userMenuResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(userMenuVoList));
		logger.info("===step3:【分页查询用户菜单列表】(UserMenuController-selectListByPage)-返回信息, userMenuResponse:{}", userMenuResponse);
		return userMenuResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户菜单列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody UserMenuPageRequest req) {
		logger.info("===step1:【不分页查询用户菜单列表】(UserMenuController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<UserMenu> list = userMenuService.selectList(req);
		logger.info("===step2:【不分页查询用户菜单列表】(UserMenuController-selectList)-不分页查询用户菜单列表, list.size:{}", list == null ? null : list.size());
		List<UserMenuVo> userMenuVoList = new UserMenuVo().convertToUserMenuVoList(list);

		BaseRestMapResponse userMenuResponse = new BaseRestMapResponse();
		userMenuResponse.put(PageConstants.DATA_LIST, userMenuVoList);
		logger.info("===step3:【不分页查询用户菜单列表】(UserMenuController-selectList)-返回信息, userMenuResponse:{}", userMenuResponse);
		return userMenuResponse;
	}

	/**
	 * 据id查询用户菜单
	 * @param userMenuId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户菜单")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer userMenuId) {
		logger.info("===step1:【据id查询用户菜单】(UserMenuController-selectById)-传入参数, userMenuId:{}", userMenuId);

		if(userMenuId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "userMenuId不能为空");
		}

		UserMenu userMenu = userMenuService.selectById(userMenuId);
		logger.info("===step2:【据id查询用户菜单】(UserMenuController-selectById)-根据id查询用户菜单, userMenu:{}", userMenu);
		UserMenuVo userMenuVo = new UserMenuVo().convertToUserMenuVo(userMenu);

		BaseRestMapResponse userMenuResponse = new BaseRestMapResponse();
		userMenuResponse.putAll((JSONObject) JSONObject.toJSON(userMenuVo));
		logger.info("===step3:【据id查询用户菜单】(UserMenuController-selectById)-返回信息, userMenuResponse:{}", userMenuResponse);
		return userMenuResponse;
	}

	/**
	 * 添加用户菜单
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户菜单")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody UserMenuRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户菜单】(UserMenuController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		UserMenu userMenu = req.convertToUserMenu();
		int i = userMenuService.insert(userMenu);
		logger.info("===step2:【添加用户菜单】(UserMenuController-insert)-插入用户菜单, i:{}", i);

		BaseRestMapResponse userMenuResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户菜单】(UserMenuController-insert)-返回信息, userMenuResponse:{}", userMenuResponse);
		return userMenuResponse;
	}

	/**
	 * 根据id删除用户菜单
	 * @param userMenuId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户菜单")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer userMenuId) {
		logger.info("===step1:【根据id删除用户菜单】(selectById-deleteById)-传入参数, userMenuId:{}", userMenuId);

		if(userMenuId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "userMenuId不能为空");
		}

		int i = userMenuService.deleteById(userMenuId);
		logger.info("===step2:【根据id删除用户菜单】(UserMenuController-deleteById)-根据id查询用户菜单, i:{}", i);

		BaseRestMapResponse userMenuResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户菜单】(UserMenuController-deleteById)-返回信息, userMenuResponse:{}", userMenuResponse);
		return userMenuResponse;
	}

	/**
	 * 批量删除用户机构
	 * @param userOrgIds
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "批量删除用户机构")
	@RequestMapping(value="/batchDelete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse batchDelete(
		@Validated @RequestBody UserMenuIdsRequest req) {
		logger.info("===step1:【批量删除用户机构】(UserOrgController-batchDelete)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		List<Integer> userMenuIds = req.getUserMenuIds();
		int i = userMenuService.deleteByIds(userMenuIds);
		logger.info("===step2:【批量删除用户机构】(UserOrgController-batchDelete)-根据userOrgIds删除用户机构, i:{}", i);

		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		logger.info("===step3:【批量删除用户机构】(UserOrgController-batchDelete)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

	/**
	 * 修改用户菜单
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户菜单")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody UserMenuRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户菜单】(UserMenuController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userMenuId = req.getUserMenuId();
		UserMenu userMenu = req.convertToUserMenu();
		userMenu.setId(userMenuId);
		int i = userMenuService.modify(userMenu);
		logger.info("===step2:【修改用户菜单】(UserMenuController-modify)-修改用户菜单, i:{}", i);

		BaseRestMapResponse userMenuResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户菜单】(UserMenuController-modify)-返回信息, userMenuResponse:{}", userMenuResponse);
		return userMenuResponse;
	}


}