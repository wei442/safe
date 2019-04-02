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
import com.cloud.provider.safe.param.OrgParam;
import com.cloud.provider.safe.po.Org;
import com.cloud.provider.safe.rest.request.OrgRequest;
import com.cloud.provider.safe.rest.request.page.OrgTreeRequest;
import com.cloud.provider.safe.service.IOrgService;
import com.cloud.provider.safe.service.IUserInfoService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.OrgVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 组织机构 OrgController
 * @author wei.yong
 */
@Api(tags = "组织机构")
@RestController
@RequestMapping(value="/org")
public class OrgController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//组织机构Service
	@Autowired
	private IOrgService orgService;

	//用户信息Service
	@Autowired
	private IUserInfoService userInfoService;

	/**
	 * 查询组织机构树列表
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "查询组织机构树列表")
	@RequestMapping(value="/selectTreeList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectTreeList(
		@RequestBody OrgTreeRequest req) {
		logger.info("===step1:【查询组织机构树列表】(OrgController-selectTreeList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer parentOrgId = req.getParentOrgId();
		Integer orgId = req.getOrgId();
		Integer enterpriseId = req.getEnterpriseId();

		OrgParam param = new OrgParam();
		param.setOrgId(orgId);
		param.setEnterpriseId(enterpriseId);
		if(parentOrgId == null) {
			param.setParentOrgId(-1);
		} else {
			param.setParentOrgId(parentOrgId);
		}

		List<OrgVo> list = orgService.selectTreeList(param);
		logger.info("===step2:【查询组织机构树列表】(OrgController-selectTreeList)-查询组织机构树列表, list.size:{}", list == null ? null : list.size());

		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		orgResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询组织机构树列表】(OrgController-selectTreeList)-返回信息, orgResponse:{}", orgResponse);
		return orgResponse;
	}

//	/**
//	 * 查询组织机构树用户列表
//	 * @param req
//	 * @return BaseRestMapResponse
//	 */
//	@ApiOperation(value = "查询组织机构树用户列表")
//	@RequestMapping(value="/selectTreeUserList",method={RequestMethod.POST})
//	@ResponseBody
//	public BaseRestMapResponse selectTreeUserList(
//		@RequestBody OrgTreeRequest req) {
//		logger.info("===step1:【查询组织机构树用户列表】(OrgController-selectTreeUserList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
//
//		Integer orgId = req.getOrgId();
//		Integer enterpriseId = req.getEnterpriseId();
//
//		UserParam param = new UserParam();
//		param.setOrgId(orgId);
//		param.setEnterpriseId(enterpriseId);
//
//		List<UserInfoOrgVo> list = userInfoService.selectListByOrgId(param);
//		logger.info("===step2:【查询组织机构树用户列表】(OrgController-selectTreeUserList)-查询组织机构树用户列表, list.size:{}", list == null ? null : list.size());
//
//		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
//		orgResponse.put(PageConstants.DATA_LIST, list);
//		logger.info("===step3:【查询组织机构树用户列表】(OrgController-selectTreeUserList)-返回信息, orgResponse:{}", orgResponse);
//		return orgResponse;
//	}

	/**
	 * 据id查询组织机构
	 * @param orgId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询组织机构")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer orgId) {
		logger.info("===step1:【据id查询组织机构】(selectById-selectById)-传入参数, orgId:{}", orgId);

		if(orgId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "orgId不能为空");
		}

		Org org = orgService.selectById(orgId);
		logger.info("===step2:【据id查询组织机构】(OrgController-selectById)-根据id查询组织机构, org:{}", org);
		OrgVo orgVo = new OrgVo().convertToOrgVo(org);

		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		orgResponse.putAll((JSONObject) JSONObject.toJSON(orgVo));
		logger.info("===step3:【据id查询组织机构】(OrgController-selectById)-返回信息, orgResponse:{}", orgResponse);
		return orgResponse;
	}

	/**
	 * 添加组织机构
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加组织机构")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody OrgRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加组织机构】(OrgController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Org org = req.convertToOrg();
		int i = orgService.insert(org);
		logger.info("===step2:【添加组织机构】(OrgController-insert)-插入组织机构, i:{}", i);

		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加组织机构】(OrgController-insert)-返回信息, orgResponse:{}", orgResponse);
		return orgResponse;
	}

	/**
	 * 根据id删除组织机构
	 * @param orgId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除组织机构")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer orgId) {
		logger.info("===step1:【根据id删除组织机构】(selectById-deleteById)-传入参数, orgId:{}", orgId);

		if(orgId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "orgId不能为空");
		}

		int i = orgService.deleteById(orgId);
		logger.info("===step2:【根据id删除组织机构】(OrgController-deleteById)-根据id查询组织机构, i:{}", i);

		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除组织机构】(OrgController-deleteById)-返回信息, orgResponse:{}", orgResponse);
		return orgResponse;
	}

	/**
	 * 修改组织机构
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改组织机构")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody OrgRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改组织机构】(OrgController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer orgId = req.getOrgId();
		Org org = req.convertToOrg();
		org.setId(orgId);
		int i = orgService.modify(org);
		logger.info("===step2:【修改组织机构】(OrgController-modify)-修改组织机构, i:{}", i);

		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改组织机构】(OrgController-modify)-返回信息, orgResponse:{}", orgResponse);
		return orgResponse;
	}


}