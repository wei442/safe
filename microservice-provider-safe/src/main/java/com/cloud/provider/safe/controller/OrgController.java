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
import com.cloud.provider.safe.param.OrgParam;
import com.cloud.provider.safe.po.Org;
import com.cloud.provider.safe.po.UserOrg;
import com.cloud.provider.safe.rest.request.enterprise.OrgRequest;
import com.cloud.provider.safe.rest.request.page.enterprise.OrgPageRequest;
import com.cloud.provider.safe.rest.request.page.enterprise.OrgTreeRequest;
import com.cloud.provider.safe.service.IOrgService;
import com.cloud.provider.safe.service.IUserOrgService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.enterprise.OrgVo;
import com.github.pagehelper.Page;

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

	//用户机构Service
	@Autowired
	private IUserOrgService userOrgService;

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

		Integer orgId = req.getOrgId();
		Integer enterpriseId = req.getEnterpriseId();
		OrgParam param = new OrgParam();
		param.setEnterpriseId(enterpriseId);
		if(orgId == null) {
			param.setParentOrgId(-1);
		} else {
			param.setParentOrgId(orgId);
		}
		List<OrgVo> list = orgService.selectTreeList(param);
		logger.info("===step2:【查询组织机构树列表】(OrgController-selectTreeList)-查询组织机构树列表, list.size:{}", list == null ? null : list.size());

		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		orgResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询组织机构树列表】(OrgController-selectTreeList)-返回信息, orgResponse:{}", orgResponse);
		return orgResponse;
	}

	/**
	 * 查询父组织机构树列表
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "查询父组织机构树列表")
	@RequestMapping(value="/selectParentTreeList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectParentTreeList(
		@RequestBody OrgTreeRequest req) {
		logger.info("===step1:【查询组织机构树列表】(OrgController-selectParentTreeList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer orgId = req.getOrgId();
		Integer enterpriseId = req.getEnterpriseId();
		OrgParam param = new OrgParam();
		param.setEnterpriseId(enterpriseId);
		List<OrgVo> list = null;
		if(orgId != null) {
			param.setOrgId(orgId);
			list = orgService.selectParentTreeList(param);
			logger.info("===step2:【查询父组织机构树列表】(OrgController-selectParentTreeList)-查询父组织机构树列表, list.size:{}", list);
		}

		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		orgResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询父组织机构树列表】(OrgController-selectParentTreeList)-查询父组织机构树列表, orgResponse:{}", orgResponse);
		return orgResponse;
	}

	/**
	 * 分页查询组织机构列表
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询组织机构列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody OrgPageRequest req) {
		logger.info("===step1:【分页查询组织机构列表】(OrgController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<Org> list = orgService.selectListByPage(page, req);
		logger.info("===step2:【分页查询组织机构列表】(OrgController-selectListByPage)-分页查询组织机构列表, list.size:{}", list == null ? null : list.size());
		List<OrgVo> orgVoList = new OrgVo().convertToOrgVoList(list);

		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		orgResponse.put(PageConstants.PAGE, PageHelperUtil.INSTANCE.getPageVo(list));
		orgResponse.put(PageConstants.DATA_LIST, orgVoList);
		logger.info("===step3:【分页查询组织机构列表】(OrgController-selectListByPage)-返回信息, orgResponse:{}", orgResponse);
		return orgResponse;
	}

	/**
	 * 不分页查询组织机构列表
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询组织机构列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody OrgPageRequest req) {
		logger.info("===step1:【不分页查询组织机构列表】(OrgController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		List<Org> list = orgService.selectList(req);
		logger.info("===step2:【不分页查询组织机构列表】(OrgController-selectList)-不分页查询组织机构列表, list.size:{}", list == null ? null : list.size());
		List<OrgVo> orgVoList = new OrgVo().convertToOrgVoList(list);

		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		orgResponse.put(PageConstants.DATA_LIST, orgVoList);
		logger.info("===step3:【不分页查询组织机构列表】(OrgController-selectList)-返回信息, orgResponse:{}", orgResponse);
		return orgResponse;
	}


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
		logger.info("===step1:【据id查询组织机构】(OrgController-selectById)-传入参数, orgId:{}", orgId);

		if(orgId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "orgId不能为空");
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
		logger.info("===step1:【根据id删除组织机构】(OrgController-deleteById)-传入参数, orgId:{}", orgId);

		if(orgId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "orgId不能为空");
		}

		List<UserOrg> userOrgList = userOrgService.selectListByOrgId(orgId);
		logger.info("===step2:【根据id删除组织机构】(OrgController-deleteById)-根据orgId查询用户组织机构列表, userOrgList.size:{}", userOrgList == null ? null : userOrgList.size());

		if(userOrgList != null && !userOrgList.isEmpty()) {
			return new BaseRestMapResponse(SafeResultEnum.USER_ORG_LIST_EXIST);
		}

		OrgParam param = new OrgParam();
		param.setParentOrgId(orgId);
		List<OrgVo> orgVoList = orgService.selectTreeList(param);
		logger.info("===step3:【根据id删除组织机构】(OrgController-deleteById)-根据orgId查询组织机构列表, orgVoList.size:{}", orgVoList == null ? null : orgVoList.size());

		if(orgVoList != null && !orgVoList.isEmpty()) {
			return new BaseRestMapResponse(SafeResultEnum.ORG_CHILD_LIST_EXIST);
		}

		int i = orgService.deleteById(orgId);
		logger.info("===step4:【根据id删除组织机构】(OrgController-deleteById)-根据id删除组织机构, i:{}", i);

		BaseRestMapResponse orgResponse = new BaseRestMapResponse();
		logger.info("===step5:【根据id删除组织机构】(OrgController-deleteById)-返回信息, orgResponse:{}", orgResponse);
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