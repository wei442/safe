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
import com.cloud.provider.safe.rest.request.page.OrgPageRequest;
import com.cloud.provider.safe.service.IOrgService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.OrgUserVo;
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

	/**
	 * 查询组织机构树用户列表
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "查询组织机构树用户列表")
	@RequestMapping(value="/selectOrgTreeUserList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectOrgTreeUserList(
		@RequestBody OrgPageRequest req) {
		logger.info("===step1:【查询组织机构树用户列表】(OrgController-selectOrgTreeUserList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer parentOrgId = req.getParentOrgId();
		Integer orgId = req.getOrgId();
		Integer enterpriseId = req.getEnterpriseId();

		OrgParam param = new OrgParam();
		param.setParentOrgId(parentOrgId);
		param.setOrgId(orgId);
		param.setEnterpriseId(enterpriseId);

		List<OrgUserVo> list = orgService.selectOrgTreeUserList(param);
		logger.info("===step2:【查询组织机构树用户列表】(OrgController-selectOrgTreeUserList)-查询组织机构树用户列表, list.size:{}", list == null ? null : list.size());

		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		orgResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询组织机构树用户列表】(OrgController-selectOrgTreeUserList)-返回信息, orgResponse:{}", orgResponse);
		return orgResponse;
	}

	/**
	 * 查询组织机构树列表
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "查询组织机构树列表")
	@RequestMapping(value="/selectOrgTreeList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectOrgTreeList(
		@RequestBody OrgPageRequest req) {
		logger.info("===step1:【查询组织机构树列表】(OrgController-selectOrgTreeList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer parentOrgId = req.getParentOrgId();
		Integer orgId = req.getOrgId();
		Integer enterpriseId = req.getEnterpriseId();

		OrgParam param = new OrgParam();
		param.setParentOrgId(parentOrgId);
		param.setOrgId(orgId);
		param.setEnterpriseId(enterpriseId);

		List<OrgVo> list = orgService.selectOrgTreeList(param);
		logger.info("===step2:【查询组织机构树列表】(OrgController-selectOrgTreeList)-查询组织机构树列表, list.size:{}", list == null ? null : list.size());

		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		orgResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询组织机构树列表】(OrgController-selectOrgTreeList)-返回信息, orgResponse:{}", orgResponse);
		return orgResponse;
	}


	/**
	 * 据id查询组织机构
	 * @param orgId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询组织机构")
	@RequestMapping(value="/selectOrgById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectOrgById(
		@PathVariable(value="id",required=false) Integer orgId) {
		logger.info("===step1:【据id查询组织机构】(selectOrgById-selectOrgById)-传入参数, orgId:{}", orgId);

		if(orgId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "orgId为空");
		}

		Org org = orgService.selectOrgById(orgId);
		logger.info("===step2:【据id查询组织机构】(OrgController-selectOrgById)-根据id查询组织机构, org:{}", org);
		OrgVo orgVo = new OrgVo().convertToOrgVo(org);

		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		orgResponse.putAll((JSONObject) JSONObject.toJSON(orgVo));
		logger.info("===step3:【据id查询组织机构】(OrgController-selectOrgById)-返回信息, orgResponse:{}", orgResponse);
		return orgResponse;
	}

	/**
	 * 添加组织机构
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加组织机构")
	@RequestMapping(value="/insertOrg",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertOrg(
		@Validated @RequestBody OrgRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加组织机构】(OrgController-insertOrg)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Org org = req.convertToOrg();
		int i = orgService.insertOrg(org);
		logger.info("===step2:【添加组织机构】(OrgController-insertOrg)-插入组织机构, i:{}", i);

		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加组织机构】(OrgController-insertOrg)-返回信息, orgResponse:{}", orgResponse);
		return orgResponse;
	}

	/**
	 * 根据id删除组织机构
	 * @param orgId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除组织机构")
	@RequestMapping(value="/deleteOrgById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteOrgById(
		@PathVariable(value="id",required=false) Integer orgId) {
		logger.info("===step1:【根据id删除组织机构】(selectOrgById-deleteOrgById)-传入参数, orgId:{}", orgId);

		if(orgId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "orgId为空");
		}

		int i = orgService.deleteOrgById(orgId);
		logger.info("===step2:【根据id删除组织机构】(OrgController-deleteOrgById)-根据id查询组织机构, i:{}", i);

		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除组织机构】(OrgController-deleteOrgById)-返回信息, orgResponse:{}", orgResponse);
		return orgResponse;
	}

	/**
	 * 修改组织机构
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改组织机构")
	@RequestMapping(value="/modifyOrg",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyOrg(
		@Validated({ ModifyGroup.class }) @RequestBody OrgRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改组织机构】(OrgController-modifyOrg)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer orgId = req.getOrgId();
		Org org = req.convertToOrg();
		org.setId(orgId);
		int i = orgService.modifyOrg(org);
		logger.info("===step2:【修改组织机构】(OrgController-modifyOrg)-修改组织机构, i:{}", i);

		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改组织机构】(OrgController-modifyOrg)-返回信息, orgResponse:{}", orgResponse);
		return orgResponse;
	}


}