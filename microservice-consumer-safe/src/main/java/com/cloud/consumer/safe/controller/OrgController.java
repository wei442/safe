package com.cloud.consumer.safe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.cloud.common.constants.PageConstants;
import com.cloud.common.constants.safe.RetSafeConstants;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.rest.request.OrgIdRequest;
import com.cloud.consumer.safe.rest.request.OrgRequest;
import com.cloud.consumer.safe.rest.request.page.OrgPageRequest;
import com.cloud.consumer.safe.service.IOrgService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.OrgVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 组织机构管理 OrgController
 * @author wei.yong
 * @ClassName: OrgController
 */
@Api(tags = "组织机构")
@RestController
@RequestMapping("/org")
public class OrgController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//组织机构 Service
	@Autowired
	private IOrgService orgService;

	/**
	 * 查询组织机构树列表
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "查询组织机构树列表")
	@RequestMapping(value="/getTreeList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getTreeList(
		@RequestBody OrgPageRequest req) {
		logger.info("===step1:【查询组织机构树列表】(OrgController-getTreeList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonOrg = orgService.getTreeList(req);
		logger.info("===step2:【查询组织机构树列表】(OrgController-getTreeList)-查询组织机构树列表, jsonOrg:{}", jsonOrg);
		String dataListStr = JSONObject.toJSONString(jsonOrg.getJSONArray(PageConstants.DATA_LIST));
		List<OrgVo> orgVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<OrgVo>>(){});

		BaseResultVo result = new BaseResultVo(orgVoList);
		//返回信息
		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		orgResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【查询组织机构树列表】(OrgController-getTreeList)-返回信息, orgResponse:{}", orgResponse);
	    return orgResponse;
	}

//	/**
//	 * 查询组织机构树用户列表
//	 * @param req
//	 * @return BaseRestMapResponse
//	 */
//	@ApiOperation(value = "查询组织机构树用户列表")
//	@RequestMapping(value="/getTreeUserList",method={RequestMethod.POST})
//	@ResponseBody
//	public BaseRestMapResponse getTreeUserList(
//		@RequestBody OrgPageRequest req) {
//		logger.info("===step1:【查询组织机构树用户列表】(OrgController-getTreeUserList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
//		Integer enterpriseId = this.getTokenEnterpriseId();
//		req.setEnterpriseId(enterpriseId);
//
//		JSONObject jsonOrg = orgService.getTreeUserList(req);
//		logger.info("===step2:【查询组织机构树用户列表】(OrgController-getTreeUserList)-查询组织机构树用户列表, jsonOrg:{}", jsonOrg);
//		String dataListStr = JSONObject.toJSONString(jsonOrg.getJSONArray(PageConstants.DATA_LIST));
//		List<UserInfoOrgVo> userInfoOrgVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserInfoOrgVo>>(){});
//
//		BaseResultVo result = new BaseResultVo(userInfoOrgVoList);
//		//返回信息
//		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
//		orgResponse.put(RetSafeConstants.RESULT, result);
//	    logger.info("===step3:【查询组织机构树用户列表】(OrgController-getTreeUserList)-返回信息, orgResponse:{}", orgResponse);
//	    return orgResponse;
//	}

	/**
	 * 获取组织机构详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取组织机构详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody OrgIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取组织机构】(OrgController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer orgId = req.getOrgId();
		JSONObject jsonOrg = orgService.getById(orgId);
		logger.info("===step2:【获取组织机构】(OrgController-getDetail)-根据orgId获取组织机构, jsonOrg:{}", jsonOrg);
		OrgVo orgVo = JSONObject.toJavaObject(jsonOrg, OrgVo.class);

		//返回信息
		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		orgResponse.put(RetSafeConstants.RESULT, orgVo);
	    logger.info("===step3:【获取组织机构】(OrgController-getDetail)-返回信息, orgResponse:{}", orgResponse);
	    return orgResponse;
	}

	/**
	 * 新增组织机构
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增组织机构")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody OrgRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增组织机构】(OrgController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonOrg = orgService.add(req);
		logger.info("===step2:【新增组织机构】(OrgController-add)-分页查询组织机构列表, jsonOrg:{}", jsonOrg);
		OrgVo orgVo = JSONObject.toJavaObject(jsonOrg, OrgVo.class);

		//返回信息
		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		orgResponse.put(RetSafeConstants.RESULT, orgVo);
	    logger.info("===step3:【新增组织机构】(OrgController-add)-返回信息, orgResponse:{}", orgResponse);
	    return orgResponse;
	}

	/**
	 * 删除组织机构
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除组织机构")
	@RequestMapping(value="/deleteOrg",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteOrg(
		@Validated @RequestBody OrgIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除组织机构】(OrgController-deleteOrg)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer orgId = req.getOrgId();
		JSONObject jsonOrg = orgService.deleteById(orgId);
		logger.info("===step2:【删除组织机构】(OrgController-deleteOrg)-根据orgId删除组织机构, jsonOrg:{}", jsonOrg);
		OrgVo orgVo = JSONObject.toJavaObject(jsonOrg, OrgVo.class);

		//返回信息
		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		orgResponse.put(RetSafeConstants.RESULT, orgVo);
		logger.info("===step3:【删除组织机构】(OrgController-deleteOrg)-返回信息, orgResponse:{}", orgResponse);
		return orgResponse;
	}

	/**
	 * 修改组织机构
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改组织机构")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody OrgRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改组织机构】(OrgController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonOrg = orgService.update(req);
		logger.info("===step2:【修改组织机构】(OrgController-update)-修改组织机构, jsonOrg:{}", jsonOrg);
		OrgVo orgVo = JSONObject.toJavaObject(jsonOrg, OrgVo.class);

		//返回信息
		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		orgResponse.put(RetSafeConstants.RESULT, orgVo);
		logger.info("===step3:【修改组织机构】(OrgController-update)-返回信息, orgResponse:{}", orgResponse);
		return orgResponse;
	}

}