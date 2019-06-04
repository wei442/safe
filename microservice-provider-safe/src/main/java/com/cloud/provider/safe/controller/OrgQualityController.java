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
import com.cloud.provider.safe.po.OrgQuality;
import com.cloud.provider.safe.po.OrgQualityAttachment;
import com.cloud.provider.safe.rest.request.enterprise.OrgQualityRequest;
import com.cloud.provider.safe.rest.request.page.enterprise.OrgQualityPageRequest;
import com.cloud.provider.safe.service.IOrgQualityService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.enterprise.OrgQualityVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 机构资质 OrgQualityController
 * @author wei.yong
 */
@Api(tags = "机构资质")
@RestController
@RequestMapping(value="/org/quality")
public class OrgQualityController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//机构资质Service
	@Autowired
	private IOrgQualityService orgQualityService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询机构资质列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody OrgQualityPageRequest req) {
		logger.info("===step1:【分页查询机构资质列表】(OrgQualityController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<OrgQuality> list = orgQualityService.selectListByPage(page, req);
		logger.info("===step2:【分页查询机构资质列表】(OrgQualityController-selectListByPage)-分页查询机构资质列表, list.size:{}", list == null ? null : list.size());
		List<OrgQualityVo> dataList = new OrgQualityVo().convertToOrgQualityVoList(list);

		BaseRestMapResponse orgQualityResponse = new BaseRestMapResponse();
		orgQualityResponse.put(PageConstants.PAGE, PageHelperUtil.INSTANCE.getPageVo(list));
		orgQualityResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【分页查询机构资质列表】(OrgQualityController-selectListByPage)-返回信息, orgQualityResponse:{}", orgQualityResponse);
		return orgQualityResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询机构资质列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody OrgQualityPageRequest req) {
		logger.info("===step1:【不分页查询机构资质列表】(OrgQualityController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<OrgQuality> list = orgQualityService.selectList(req);
		logger.info("===step2:【不分页查询机构资质列表】(OrgQualityController-selectList)-不分页查询机构资质列表, list.size:{}", list == null ? null : list.size());
		List<OrgQualityVo> dataList = new OrgQualityVo().convertToOrgQualityVoList(list);

		BaseRestMapResponse orgQualityResponse = new BaseRestMapResponse();
		orgQualityResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【不分页查询机构资质列表】(OrgQualityController-selectList)-返回信息, orgQualityResponse:{}", orgQualityResponse);
		return orgQualityResponse;
	}

	/**
	 * 据id查询机构资质
	 * @param orgQualityId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询机构资质")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer orgQualityId) {
		logger.info("===step1:【据id查询机构资质】(OrgQualityController-selectById)-传入参数, orgQualityId:{}", orgQualityId);

		if(orgQualityId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "orgQualityId不能为空");
		}

		OrgQuality orgQuality = orgQualityService.selectById(orgQualityId);
		logger.info("===step2:【据id查询机构资质】(OrgQualityController-selectById)-根据id查询机构资质, orgQuality:{}", orgQuality);
		if(orgQuality == null) {
			return new BaseRestMapResponse(SafeResultEnum.DATABASE_NOTEXIST);
		}
		OrgQualityVo orgQualityVo = new OrgQualityVo().convertToOrgQualityVo(orgQuality);

		BaseRestMapResponse orgQualityResponse = new BaseRestMapResponse();
		orgQualityResponse.putAll((JSONObject) JSONObject.toJSON(orgQualityVo));
		logger.info("===step3:【据id查询机构资质】(OrgQualityController-selectById)-返回信息, orgQualityResponse:{}", orgQualityResponse);
		return orgQualityResponse;
	}

	/**
	 * 添加机构资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加机构资质")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody OrgQualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加机构资质】(OrgQualityController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		OrgQuality orgQuality = req.convertToOrgQuality();
		List<OrgQualityAttachment> orgQualityAttachmentList = req.convertToOrgQualityAttachmentList();
		int i = orgQualityService.insert(orgQuality, orgQualityAttachmentList);
		logger.info("===step2:【添加机构资质】(OrgQualityController-insert)-插入机构资质, i:{}", i);

		BaseRestMapResponse orgQualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加机构资质】(OrgQualityController-insert)-返回信息, orgQualityResponse:{}", orgQualityResponse);
		return orgQualityResponse;
	}

	/**
	 * 根据id删除机构资质
	 * @param orgQualityId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除机构资质")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer orgQualityId) {
		logger.info("===step1:【根据id删除机构资质】(selectById-deleteById)-传入参数, orgQualityId:{}", orgQualityId);

		if(orgQualityId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "orgQualityId不能为空");
		}

		int i = orgQualityService.deleteById(orgQualityId);
		logger.info("===step2:【根据id删除机构资质】(OrgQualityController-deleteById)-根据id查询机构资质, i:{}", i);

		BaseRestMapResponse orgQualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除机构资质】(OrgQualityController-deleteById)-返回信息, orgQualityResponse:{}", orgQualityResponse);
		return orgQualityResponse;
	}

	/**
	 * 修改机构资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改机构资质")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody OrgQualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改机构资质】(OrgQualityController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer orgQualityId = req.getOrgQualityId();
		List<Integer> orgQualityAttachmentIds = req.getOrgQualityAttachmentIds();
		List<OrgQualityAttachment> orgQualityAttachments = req.convertToOrgQualityAttachmentList();
		OrgQuality orgQuality = req.convertToOrgQuality();
		orgQuality.setId(orgQualityId);
		int i = orgQualityService.modify(orgQuality, orgQualityAttachmentIds, orgQualityAttachments);
		logger.info("===step2:【修改机构资质】(OrgQualityController-modify)-修改机构资质, i:{}", i);

		BaseRestMapResponse orgQualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改机构资质】(OrgQualityController-modify)-返回信息, orgQualityResponse:{}", orgQualityResponse);
		return orgQualityResponse;
	}


}