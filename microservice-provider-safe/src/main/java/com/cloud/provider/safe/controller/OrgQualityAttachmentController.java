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
import com.cloud.provider.safe.po.OrgQualityAttachment;
import com.cloud.provider.safe.rest.request.enterprise.OrgQualityAttachmentRequest;
import com.cloud.provider.safe.rest.request.page.enterprise.OrgQualityAttachmentPageRequest;
import com.cloud.provider.safe.service.IOrgQualityAttachmentService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.enterprise.OrgQualityAttachmentVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 机构资质附件 OrgQualityAttachmentController
 * @author wei.yong
 */
@Api(tags = "机构资质附件")
@RestController
@RequestMapping(value="/orgQuality/attachment")
public class OrgQualityAttachmentController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//机构资质附件Service
	@Autowired
	private IOrgQualityAttachmentService orgQualityAttachmentService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询机构资质附件列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody OrgQualityAttachmentPageRequest req) {
		logger.info("===step1:【分页查询机构资质附件列表】(OrgQualityAttachmentController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<OrgQualityAttachment> list = orgQualityAttachmentService.selectListByPage(page, req);
		logger.info("===step2:【分页查询机构资质附件列表】(OrgQualityAttachmentController-selectListByPage)-分页查询机构资质附件列表, list.size:{}", list == null ? null : list.size());
		List<OrgQualityAttachmentVo> orgQualityAttachmentVoList = new OrgQualityAttachmentVo().convertToOrgQualityAttachmentVoList(list);

		BaseRestMapResponse orgQualityAttachmentResponse = new BaseRestMapResponse();
		orgQualityAttachmentResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(orgQualityAttachmentVoList));
		logger.info("===step3:【分页查询机构资质附件列表】(OrgQualityAttachmentController-selectListByPage)-返回信息, orgQualityAttachmentResponse:{}", orgQualityAttachmentResponse);
		return orgQualityAttachmentResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询机构资质附件列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody OrgQualityAttachmentPageRequest req) {
		logger.info("===step1:【不分页查询机构资质附件列表】(OrgQualityAttachmentController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<OrgQualityAttachment> list = orgQualityAttachmentService.selectList(req);
		logger.info("===step2:【不分页查询机构资质附件列表】(OrgQualityAttachmentController-selectList)-不分页查询机构资质附件列表, list.size:{}", list == null ? null : list.size());
		List<OrgQualityAttachmentVo> orgQualityAttachmentVoList = new OrgQualityAttachmentVo().convertToOrgQualityAttachmentVoList(list);

		BaseRestMapResponse orgQualityAttachmentResponse = new BaseRestMapResponse();
		orgQualityAttachmentResponse.put(PageConstants.DATA_LIST, orgQualityAttachmentVoList);
		logger.info("===step3:【不分页查询机构资质附件列表】(OrgQualityAttachmentController-selectList)-返回信息, orgQualityAttachmentResponse:{}", orgQualityAttachmentResponse);
		return orgQualityAttachmentResponse;
	}

	/**
	 * 据id查询机构资质附件
	 * @param orgQualityAttachmentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询机构资质附件")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer orgQualityAttachmentId) {
		logger.info("===step1:【据id查询机构资质附件】(selectById-selectById)-传入参数, orgQualityAttachmentId:{}", orgQualityAttachmentId);

		if(orgQualityAttachmentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "orgQualityAttachmentId不能为空");
		}

		OrgQualityAttachment orgQualityAttachment = orgQualityAttachmentService.selectById(orgQualityAttachmentId);
		logger.info("===step2:【据id查询机构资质附件】(OrgQualityAttachmentController-selectById)-根据id查询机构资质附件, orgQualityAttachment:{}", orgQualityAttachment);
		OrgQualityAttachmentVo orgQualityAttachmentVo = new OrgQualityAttachmentVo().convertToOrgQualityAttachmentVo(orgQualityAttachment);

		BaseRestMapResponse orgQualityAttachmentResponse = new BaseRestMapResponse();
		orgQualityAttachmentResponse.putAll((JSONObject) JSONObject.toJSON(orgQualityAttachmentVo));
		logger.info("===step3:【据id查询机构资质附件】(OrgQualityAttachmentController-selectById)-返回信息, orgQualityAttachmentResponse:{}", orgQualityAttachmentResponse);
		return orgQualityAttachmentResponse;
	}

	/**
	 * 添加机构资质附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加机构资质附件")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody OrgQualityAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加机构资质附件】(OrgQualityAttachmentController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		OrgQualityAttachment orgQualityAttachment = req.convertToOrgQualityAttachment();
		int i = orgQualityAttachmentService.insert(orgQualityAttachment);
		logger.info("===step2:【添加机构资质附件】(OrgQualityAttachmentController-insert)-插入机构资质附件, i:{}", i);

		BaseRestMapResponse orgQualityAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加机构资质附件】(OrgQualityAttachmentController-insert)-返回信息, orgQualityAttachmentResponse:{}", orgQualityAttachmentResponse);
		return orgQualityAttachmentResponse;
	}

	/**
	 * 根据id删除机构资质附件
	 * @param orgQualityAttachmentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除机构资质附件")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer orgQualityAttachmentId) {
		logger.info("===step1:【根据id删除机构资质附件】(selectById-deleteById)-传入参数, orgQualityAttachmentId:{}", orgQualityAttachmentId);

		if(orgQualityAttachmentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "orgQualityAttachmentId不能为空");
		}

		int i = orgQualityAttachmentService.deleteById(orgQualityAttachmentId);
		logger.info("===step2:【根据id删除机构资质附件】(OrgQualityAttachmentController-deleteById)-根据id查询机构资质附件, i:{}", i);

		BaseRestMapResponse orgQualityAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除机构资质附件】(OrgQualityAttachmentController-deleteById)-返回信息, orgQualityAttachmentResponse:{}", orgQualityAttachmentResponse);
		return orgQualityAttachmentResponse;
	}

	/**
	 * 修改机构资质附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改机构资质附件")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody OrgQualityAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改机构资质附件】(OrgQualityAttachmentController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer orgQualityAttachmentId = req.getOrgQualityAttachmentId();
		OrgQualityAttachment orgQualityAttachment = req.convertToOrgQualityAttachment();
		orgQualityAttachment.setId(orgQualityAttachmentId);
		int i = orgQualityAttachmentService.modify(orgQualityAttachment);
		logger.info("===step2:【修改机构资质附件】(OrgQualityAttachmentController-modify)-修改机构资质附件, i:{}", i);

		BaseRestMapResponse orgQualityAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改机构资质附件】(OrgQualityAttachmentController-modify)-返回信息, orgQualityAttachmentResponse:{}", orgQualityAttachmentResponse);
		return orgQualityAttachmentResponse;
	}

}