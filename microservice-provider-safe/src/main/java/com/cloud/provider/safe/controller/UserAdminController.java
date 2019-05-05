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
import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.base.BaseRestMapResponse;
import com.cloud.provider.safe.page.PageHelperUtil;
import com.cloud.provider.safe.po.UserAdmin;
import com.cloud.provider.safe.po.UserInfo;
import com.cloud.provider.safe.po.UserMenu;
import com.cloud.provider.safe.rest.request.enterprise.EnterpriseIdRequest;
import com.cloud.provider.safe.rest.request.page.user.UserAdminPageRequest;
import com.cloud.provider.safe.rest.request.user.UserAdminMasterRequest;
import com.cloud.provider.safe.rest.request.user.UserAdminRequest;
import com.cloud.provider.safe.service.IUserAdminService;
import com.cloud.provider.safe.service.IUserInfoService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.user.UserAdminVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户管理 UserAdminController
 * @author wei.yong
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping(value="/user/admin")
public class UserAdminController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户管理Service
	@Autowired
	private IUserAdminService userAdminService;

	//用户信息Service
	@Autowired
	private IUserInfoService userInfoService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户管理列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody UserAdminPageRequest req) {
		logger.info("===step1:【分页查询用户管理列表】(UserAdminController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserAdminVo> list = userAdminService.selectListByPage(page, req);
		logger.info("===step2:【分页查询用户管理列表】(UserAdminController-selectListByPage)-分页查询用户管理列表, list.size:{}", list == null ? null : list.size());

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		userAdminResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(list));
		logger.info("===step3:【分页查询用户管理列表】(UserAdminController-selectListByPage)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户管理列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody UserAdminPageRequest req) {
		logger.info("===step1:【不分页查询用户管理列表】(UserAdminController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<UserAdminVo> list = userAdminService.selectList(req);
		logger.info("===step2:【不分页查询用户管理列表】(UserAdminController-selectList)-不分页查询用户管理列表, list.size:{}", list == null ? null : list.size());

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		userAdminResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【不分页查询用户管理列表】(UserAdminController-selectList)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 据id查询用户管理
	 * @param userAdminId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户管理")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer userAdminId) {
		logger.info("===step1:【据id查询用户管理】(UserAdminController-selectById)-传入参数, userAdminId:{}", userAdminId);

		if(userAdminId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "userAdminId不能为空");
		}

		UserAdmin userAdmin = userAdminService.selectById(userAdminId);
		logger.info("===step2:【据id查询用户管理】(UserAdminController-selectById)-根据id查询用户管理, userAdmin:{}", userAdmin);
		UserAdminVo userAdminVo = new UserAdminVo().convertToUserAdminVo(userAdmin);

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		userAdminResponse.putAll((JSONObject) JSONObject.toJSON(userAdminVo));
		logger.info("===step3:【据id查询用户管理】(UserAdminController-selectById)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 据userId查询用户管理
	 * @param userId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据userId查询用户管理")
	@RequestMapping(value="/selectByUserId/{userId}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectByUserId(
		@PathVariable(value="userId",required=false) Integer userId) {
		logger.info("===step1:【据userId查询用户管理】(UserAdminController-selectByUserId)-传入参数, userId:{}", userId);

		if(userId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "userId不能为空");
		}

		UserAdmin userAdmin = userAdminService.selectByUserId(userId);
		logger.info("===step2:【据userId查询用户管理】(UserAdminController-selectByUserId)-根据userId查询用户管理, userAdmin:{}", userAdmin);
		UserAdminVo userAdminVo = new UserAdminVo().convertToUserAdminVo(userAdmin);

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		userAdminResponse.putAll((JSONObject) JSONObject.toJSON(userAdminVo));
		logger.info("===step3:【据userId查询用户管理】(UserAdminController-selectByUserId)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

//	/**
//	 * 根据enterpriseId和userId查询用户管理
//	 * @param req
//	 * @param bindingResult
//	 * @return BaseRestMapResponse
//	 */
//	@ApiOperation(value = "根据userId查询用户管理")
//	@RequestMapping(value="/selectByEnterpriseIdUserId",method={RequestMethod.POST})
//	@ResponseBody
//	public BaseRestMapResponse selectByEnterpriseIdUserId(
//		@Validated @RequestBody UserAdminRequest req,
//		BindingResult bindingResult) {
//		logger.info("===step1:【根据enterpriseId和userId查询用户管理】(UserAdminController-selectByEnterpriseIdUserId)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
//
//		Integer enterpriseId = req.getEnterpriseId();
//		Integer userId = req.getUserId();
//
//		UserAdmin userAdmin = userAdminService.selectByEnterpriseIdUserId(enterpriseId, userId);
//		logger.info("===step2:【根据enterpriseId和userId查询用户管理】(UserAdminController-selectByEnterpriseIdUserId)-根据enterpriseId和userId查询用户管理, userAdmin:{}", userAdmin);
//		UserAdminVo userAdminVo = new UserAdminVo().convertToUserAdminVo(userAdmin);
//
//		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
//		userAdminResponse.putAll((JSONObject) JSONObject.toJSON(userAdminVo));
//		logger.info("===step3:【根据enterpriseId和userId查询用户管理】(UserAdminController-selectByEnterpriseIdUserId)-返回信息, userAdminResponse:{}", userAdminResponse);
//		return userAdminResponse;
//	}

	/**
	 * 查询用户主管理员
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "查询用户主管理员")
	@RequestMapping(value="/selectMaster",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectMaster(
		@Validated @RequestBody EnterpriseIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【查询用户主管理员】(UserAdminController-selectMaster)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer enterpriseId = req.getEnterpriseId();
		Integer adminType = SqlSafeConstants.SQL_USER_ADMIN_TYPE_MASTER;

		UserAdmin userAdmin = userAdminService.selectByEnterpriseIdAdminType(enterpriseId, adminType);
		logger.info("===step2:【查询用户主管理员】(UserAdminController-selectMaster)-根据enterpriseId和adminType查询用户管理, userAdmin:{}", userAdmin);
		if(userAdmin == null) {
			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_MASTER_NOT_EXIST);
		}
		UserAdminVo userAdminVo = new UserAdminVo().convertToUserAdminVo(userAdmin);
		Integer userId = userAdminVo.getUserId();

		UserInfo userInfo = userInfoService.selectById(userId);
		if(userInfo == null) {
			return new BaseRestMapResponse(SafeResultEnum.DATABASE_NOTEXIST);
		}
		logger.info("===step3:【查询用户主管理员】(UserAdminController-selectMaster)-根据userId查询用户信息, userInfo:{}", userInfo);
		String userAccount = userInfo.getUserAccount();
		String userName = userInfo.getUserName();
		userAdminVo.setUserAccount(userAccount);
		userAdminVo.setUserName(userName);

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		userAdminResponse.putAll((JSONObject) JSONObject.toJSON(userAdminVo));
		logger.info("===step4:【查询用户主管理员】(UserAdminController-selectMaster)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 添加用户管理
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户管理")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody UserAdminRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户管理】(UserAdminController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer enterpriseId = req.getEnterpriseId();
		Integer userId = req.getUserId();
		List<UserMenu> userMenuList = req.getUserMenuList();

		UserAdmin userAdmin = userAdminService.selectByUserId(userId);
		logger.info("===step2:【添加用户管理】(UserAdminController-insert)-根据userId查询用户管理, userAdmin:{}", userAdmin);
		Integer adminType = userAdmin.getAdminType();
		if(SqlSafeConstants.SQL_USER_ADMIN_TYPE_MASTER.equals(adminType)) {
			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_MASTER_NOT_INSERT);
		}

		userAdmin = userAdminService.selectByEnterpriseIdUserId(enterpriseId, userId);
		logger.info("===step3:【添加用户管理】(UserAdminController-insert)-根据enterpriseId和userId查询用户管理, userAdmin:{}", userAdmin);
		adminType = userAdmin.getAdminType();
		if(SqlSafeConstants.SQL_USER_ADMIN_TYPE_SLAVE.equals(adminType)) {
			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_SLAVE_EXIST);
		}

		userAdmin = req.convertToUserAdmin();
		int i = userAdminService.insert(userAdmin, userMenuList);
		logger.info("===step4:【添加用户管理】(UserAdminController-insert)-插入添加用户管理, i:{}", i);

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		logger.info("===step5:【添加用户管理】(UserAdminController-insert)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 根据id删除用户管理
	 * @param userAdminId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户管理")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer userAdminId) {
		logger.info("===step1:【根据id删除用户管理】(selectById-deleteById)-传入参数, userAdminId:{}", userAdminId);

		if(userAdminId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "userAdminId不能为空");
		}

		int i = userAdminService.deleteById(userAdminId);
		logger.info("===step2:【根据id删除用户管理】(UserAdminController-deleteById)-根据id查询用户管理, i:{}", i);

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户管理】(UserAdminController-deleteById)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 修改用户管理
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户管理")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody UserAdminRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户管理】(UserAdminController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer enterpriseId = req.getEnterpriseId();
		Integer userId = req.getUserId();
		List<UserMenu> userMenuList = req.getUserMenuList();

		UserAdmin userAdmin = userAdminService.selectByUserId(userId);
		logger.info("===step2:【修改用户管理】(UserAdminController-modify)-根据userId查询用户管理, userAdmin:{}", userAdmin);
		Integer adminType = userAdmin.getAdminType();
		if(SqlSafeConstants.SQL_USER_ADMIN_TYPE_MASTER.equals(adminType)) {
			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_MASTER_NOT_INSERT);
		}

		userAdmin = userAdminService.selectByEnterpriseIdUserId(enterpriseId, userId);
		logger.info("===step3:【修改用户管理】(UserAdminController-modify)-根据enterpriseId和userId查询用户管理, userAdmin:{}", userAdmin);
		adminType = userAdmin.getAdminType();
		if(SqlSafeConstants.SQL_USER_ADMIN_TYPE_SLAVE.equals(adminType)) {
			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_SLAVE_EXIST);
		}

		userAdmin = req.convertToUserAdmin();
		int i = userAdminService.modify(userAdmin, userMenuList);
		logger.info("===step4:【修改用户管理】(UserAdminController-modify)-修改子管理员, i:{}", i);

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		logger.info("===step4:【修改用户管理】(UserAdminController-modify)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 更改主管理员
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "更改主管理员")
	@RequestMapping(value="/changeMaster",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse changeMaster(
		@Validated @RequestBody UserAdminMasterRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【更改主管理员】(UserAdminController-changeMaster)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userAdminId = req.getUserAdminId();
		Integer enterpriseId = req.getEnterpriseId();
		Integer userId = req.getUserId();

		UserAdmin userAdmin = userAdminService.selectByEnterpriseIdUserId(enterpriseId, userId);
		logger.info("===step2:【更改主管理员】(UserAdminController-changeMaster)-根据enterpriseId和userId查询用户管理, userAdmin:{}", userAdmin);
		Integer adminType = userAdmin.getAdminType();
		if(SqlSafeConstants.SQL_USER_ADMIN_TYPE_SLAVE.equals(adminType)) {
			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_SLAVE_EXIST);
		}

		UserAdmin oldUserAdmin = userAdminService.selectById(userAdminId);
		UserAdmin newUserAdmin = req.convertToUserAdmin();
		int i = userAdminService.changeAdminMaster(oldUserAdmin, newUserAdmin);
		logger.info("===step3:【更改主管理员】(UserAdminController-changeMaster)-更改主管理员, i:{}", i);

		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		logger.info("===step4:【更改主管理员】(UserAdminController-changeMaster)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

//	/**
//	 * 添加子管理员
//	 * @param req
//	 * @param bindingResult
//	 * @return BaseRestMapResponse
//	 */
//	@ApiOperation(value = "添加子管理员")
//	@RequestMapping(value="/insertSlave",method={RequestMethod.POST})
//	@ResponseBody
//	public BaseRestMapResponse insertSlave(
//		@Validated @RequestBody UserAdminSlaveRequest req,
//		BindingResult bindingResult) {
//		logger.info("===step1:【添加子管理员】(UserAdminController-insertSlave)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
//
//		Integer enterpriseId = req.getEnterpriseId();
//		Integer userId = req.getUserId();
//		List<UserMenu> userMenuList = req.getUserMenuList();
//
//		UserAdmin userAdmin = userAdminService.selectByUserId(userId);
//		logger.info("===step2:【添加子管理员】(UserAdminController-insertSlave)-根据userId查询用户管理, userAdmin:{}", userAdmin);
//		Integer adminType = userAdmin.getAdminType();
//		if(SqlSafeConstants.SQL_USER_ADMIN_TYPE_MASTER.equals(adminType)) {
//			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_MASTER_NOT_INSERT);
//		}
//
//		userAdmin = userAdminService.selectByEnterpriseIdUserId(enterpriseId, userId);
//		logger.info("===step3:【添加子管理员】(UserAdminController-insertSlave)-根据enterpriseId和userId查询用户管理, userAdmin:{}", userAdmin);
//		adminType = userAdmin.getAdminType();
//		if(SqlSafeConstants.SQL_USER_ADMIN_TYPE_SLAVE.equals(adminType)) {
//			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_SLAVE_EXIST);
//		}
//
//		userAdmin = req.convertToUserAdmin();
//		int i = userAdminService.insertAdminSlave(userAdmin, userMenuList);
//		logger.info("===step4:【添加子管理员】(UserAdminController-insertSlave)-插入子管理员, i:{}", i);
//
//		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
//		logger.info("===step5:【添加子管理员】(UserAdminController-insertSlave)-返回信息, userAdminResponse:{}", userAdminResponse);
//		return userAdminResponse;
//	}
//
//	/**
//	 * 修改子管理员
//	 * @param req
//	 * @param bindingResult
//	 * @return BaseRestMapResponse
//	 */
//	@ApiOperation(value = "修改子管理员")
//	@RequestMapping(value="/modifySlave",method={RequestMethod.POST})
//	@ResponseBody
//	public BaseRestMapResponse modifySlave(
//		@Validated @RequestBody UserAdminSlaveRequest req,
//		BindingResult bindingResult) {
//		logger.info("===step1:【修改子管理员】(UserAdminController-modifySlave)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
//
//		Integer enterpriseId = req.getEnterpriseId();
//		Integer userId = req.getUserId();
//		List<UserMenu> userMenuList = req.getUserMenuList();
//
//		UserAdmin userAdmin = userAdminService.selectByUserId(userId);
//		logger.info("===step2:【修改子管理员】(UserAdminController-modifySlave)-根据userId查询用户管理, userAdmin:{}", userAdmin);
//		Integer adminType = userAdmin.getAdminType();
//		if(SqlSafeConstants.SQL_USER_ADMIN_TYPE_MASTER.equals(adminType)) {
//			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_MASTER_NOT_INSERT);
//		}
//
//		userAdmin = userAdminService.selectByEnterpriseIdUserId(enterpriseId, userId);
//		logger.info("===step3:【修改子管理员】(UserAdminController-modifySlave)-根据enterpriseId和userId查询用户管理, userAdmin:{}", userAdmin);
//		adminType = userAdmin.getAdminType();
//		if(SqlSafeConstants.SQL_USER_ADMIN_TYPE_SLAVE.equals(adminType)) {
//			return new BaseRestMapResponse(SafeResultEnum.USER_ADMIN_SLAVE_EXIST);
//		}
//
//		userAdmin = req.convertToUserAdmin();
//		int i = userAdminService.modifyAdminSlave(userAdmin, userMenuList);
//		logger.info("===step4:【修改子管理员】(UserAdminController-modifySlave)-修改子管理员, i:{}", i);
//
//		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
//		logger.info("===step5:【修改子管理员】(UserAdminController-modifySlave)-返回信息, userAdminResponse:{}", userAdminResponse);
//		return userAdminResponse;
//	}

}