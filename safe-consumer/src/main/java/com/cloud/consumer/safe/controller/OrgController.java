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
import com.cloud.common.constants.CommConstants;
import com.cloud.common.constants.PageConstants;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.page.PageVo;
import com.cloud.consumer.safe.rest.request.enterprise.OrgIdRequest;
import com.cloud.consumer.safe.rest.request.enterprise.OrgRequest;
import com.cloud.consumer.safe.rest.request.page.enterprise.OrgPageRequest;
import com.cloud.consumer.safe.rest.request.page.enterprise.OrgTreeRequest;
import com.cloud.consumer.safe.service.IOrgService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.enterprise.OrgVo;

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
		@RequestBody OrgTreeRequest req) {
		logger.info("===step1:【查询组织机构树列表】(OrgController-getTreeList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonOrg = orgService.getTreeList(req);
		logger.info("===step2:【查询组织机构树列表】(OrgController-getTreeList)-查询组织机构树列表, jsonOrg:{}", jsonOrg);
		String dataListStr = JSONObject.toJSONString(jsonOrg.getJSONArray(PageConstants.DATA_LIST));
		List<OrgVo> orgVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<OrgVo>>(){});
//		Integer orgId = null;
//		if(orgVoList != null && !orgVoList.isEmpty()) {
//			orgId = orgVoList.get(0).getOrgId();
//		}

//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("orgId", orgId);
//		JSONObject jsonParentOrg = orgService.getParentTreeList(params);
//		logger.info("===step2:【查询组织机构树列表】(OrgController-getTreeList)-查询组织机构树列表, jsonParentOrg:{}", jsonParentOrg);

		BaseResultVo result = new BaseResultVo(orgVoList);
		//返回信息
		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		orgResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【查询组织机构树列表】(OrgController-getTreeList)-返回信息, orgResponse:{}", orgResponse);
	    return orgResponse;
	}

	/**
	 * 查询父组织机构树列表
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "查询父组织机构树列表")
	@RequestMapping(value="/getParentTreeList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getParentTreeList(
		@RequestBody OrgTreeRequest req) {
		logger.info("===step1:【查询父组织机构树列表】(OrgController-getParentTreeList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonOrg = orgService.getParentTreeList(req);
		logger.info("===step2:【查询父组织机构树列表】(OrgController-getParentTreeList)-查询父组织机构树列表, jsonOrg:{}", jsonOrg);
		String dataListStr = JSONObject.toJSONString(jsonOrg.getJSONArray(PageConstants.DATA_LIST));
		List<OrgVo> orgVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<OrgVo>>(){});

		BaseResultVo result = new BaseResultVo(orgVoList);
		//返回信息
		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		orgResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【查询父组织机构树列表】(OrgController-getParentTreeList)-返回信息, orgResponse:{}", orgResponse);
	    return orgResponse;
	}

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询组织机构列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody OrgPageRequest req) {
		logger.info("===step1:【分页查询】(OrgController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonOrg = orgService.getListByPage(req);
		logger.info("===step2:【分页查询】(OrgController-getListByPage)-分页查询组织机构列表, jsonOrg:{}", jsonOrg);
		String dataListStr = JSONObject.toJSONString(jsonOrg.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonOrg.getJSONObject(PageConstants.PAGE));
		List<OrgVo> orgVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<OrgVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, orgVoList);
		//返回信息
		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		orgResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(OrgController-getListByPage)-返回信息, orgResponse:{}", orgResponse);
	    return orgResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询组织机构列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody OrgPageRequest req) {
		logger.info("===step1:【不分页查询】(OrgController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonOrg = orgService.getList(req);
		logger.info("===step2:【不分页查询】(OrgController-getList)-不分页查询组织机构列表, jsonOrg:{}", jsonOrg);
		String dataListStr = JSONObject.toJSONString(jsonOrg.getJSONArray(PageConstants.DATA_LIST));
		List<OrgVo> orgVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<OrgVo>>(){});

		BaseResultVo result = new BaseResultVo(orgVoList);
		//返回信息
		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		orgResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(OrgController-getList)-返回信息, orgResponse:{}", orgResponse);
		return orgResponse;
	}

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
		orgResponse.put(CommConstants.RESULT, orgVo);
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

		//返回信息
		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
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
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody OrgIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除组织机构】(OrgController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer orgId = req.getOrgId();
		JSONObject jsonOrg = orgService.deleteById(orgId);
		logger.info("===step2:【删除组织机构】(OrgController-delete)-根据orgId删除组织机构, jsonOrg:{}", jsonOrg);

		//返回信息
		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除组织机构】(OrgController-delete)-返回信息, orgResponse:{}", orgResponse);
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

		//返回信息
		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改组织机构】(OrgController-update)-返回信息, orgResponse:{}", orgResponse);
		return orgResponse;
	}

}