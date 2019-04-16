package com.cloud.consumer.safe.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.cloud.common.constants.CommConstants;
import com.cloud.common.constants.PageConstants;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.page.PageVo;
import com.cloud.consumer.safe.rest.request.enterprise.OrgQualityAttachmentRequest;
import com.cloud.consumer.safe.rest.request.enterprise.OrgQualityIdRequest;
import com.cloud.consumer.safe.rest.request.enterprise.OrgQualityRequest;
import com.cloud.consumer.safe.rest.request.page.enterprise.OrgQualityPageRequest;
import com.cloud.consumer.safe.service.IFastdfsService;
import com.cloud.consumer.safe.service.IOrgQualityService;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.enterprise.OrgQualityVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 机构资质管理 OrgQualityController
 * @author wei.yong
 * @ClassName: OrgQualityController
 */
@Api(tags = "机构资质")
@RestController
@RequestMapping("/org/quality")
public class OrgQualityController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//机构资质 Service
	@Autowired
	private IOrgQualityService orgQualityService;

	//fastdfs Service
	@Autowired
	private IFastdfsService fastdfsService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询机构资质列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody OrgQualityPageRequest req) {
		logger.info("===step1:【分页查询】(OrgQualityController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonOrgQuality = orgQualityService.getListByPage(req);
		logger.info("===step2:【分页查询】(OrgQualityController-getListByPage)-分页查询机构资质列表, jsonOrgQuality:{}", jsonOrgQuality);
		String dataListStr = JSONObject.toJSONString(jsonOrgQuality.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonOrgQuality.getJSONObject(PageConstants.PAGE));
		List<OrgQualityVo> orgQualityVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<OrgQualityVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, orgQualityVoList);
		//返回信息
		BaseRestMapResponse orgQualityResponse = new BaseRestMapResponse();
		orgQualityResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(OrgQualityController-getListByPage)-返回信息, orgQualityResponse:{}", orgQualityResponse);
	    return orgQualityResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询机构资质列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody OrgQualityPageRequest req) {
		logger.info("===step1:【不分页查询】(OrgQualityController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonOrgQuality = orgQualityService.getList(req);
		logger.info("===step2:【不分页查询】(OrgQualityController-getList)-不分页查询机构资质列表, jsonOrgQuality:{}", jsonOrgQuality);
		String dataListStr = JSONObject.toJSONString(jsonOrgQuality.getJSONArray(PageConstants.DATA_LIST));
		List<OrgQualityVo> orgQualityVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<OrgQualityVo>>(){});

		BaseResultVo result = new BaseResultVo(orgQualityVoList);
		//返回信息
		BaseRestMapResponse orgQualityResponse = new BaseRestMapResponse();
		orgQualityResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(OrgQualityController-getList)-返回信息, orgQualityResponse:{}", orgQualityResponse);
		return orgQualityResponse;
	}

	/**
	 * 获取机构资质详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取机构资质详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody OrgQualityIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取机构资质】(OrgQualityController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer orgQualityId = req.getOrgQualityId();
		JSONObject jsonOrgQuality = orgQualityService.getById(orgQualityId);
		logger.info("===step2:【获取机构资质】(OrgQualityController-getDetail)-根据orgQualityId获取机构资质, jsonOrgQuality:{}", jsonOrgQuality);
		OrgQualityVo orgQualityVo = JSONObject.toJavaObject(jsonOrgQuality, OrgQualityVo.class);

		//返回信息
		BaseRestMapResponse orgQualityResponse = new BaseRestMapResponse();
		orgQualityResponse.put(CommConstants.RESULT, orgQualityVo);
	    logger.info("===step3:【获取机构资质】(OrgQualityController-getDetail)-返回信息, orgQualityResponse:{}", orgQualityResponse);
	    return orgQualityResponse;
	}

	/**
	 * 新增机构资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增机构资质")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		OrgQualityRequest req, @RequestPart("fileList") MultipartFile[] multipartFiles,
		BindingResult bindingResult) {
		logger.info("===step1:【新增机构资质】(OrgQualityController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);
		//暂时
		req.setOrgId(-1);

		List<OrgQualityAttachmentRequest> orgQualityAttachmentList = null;
		OrgQualityAttachmentRequest orgQualityAttachmentRequest = null;
		if(multipartFiles != null && multipartFiles.length >0) {
			orgQualityAttachmentList = new ArrayList<OrgQualityAttachmentRequest>();
			for (MultipartFile multipartFile : multipartFiles) {
				orgQualityAttachmentRequest = new OrgQualityAttachmentRequest();

				String fileUrl = fastdfsService.uploadImage(multipartFile);
				String filename = multipartFile.getOriginalFilename();
				orgQualityAttachmentRequest.setName(filename);
				orgQualityAttachmentRequest.setUrl(fileUrl);
				orgQualityAttachmentList.add(orgQualityAttachmentRequest);
			}
		}
		req.setOrgQualityAttachmentList(orgQualityAttachmentList);

		JSONObject jsonOrgQuality = orgQualityService.add(req);
		logger.info("===step2:【新增机构资质】(OrgQualityController-add)-分页查询机构资质列表, jsonOrgQuality:{}", jsonOrgQuality);
		OrgQualityVo orgQualityVo = JSONObject.toJavaObject(jsonOrgQuality, OrgQualityVo.class);

		//返回信息
		BaseRestMapResponse orgQualityResponse = new BaseRestMapResponse();
		orgQualityResponse.put(CommConstants.RESULT, orgQualityVo);
	    logger.info("===step3:【新增机构资质】(OrgQualityController-add)-返回信息, orgQualityResponse:{}", orgQualityResponse);
	    return orgQualityResponse;
	}

	/**
	 * 删除机构资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除机构资质")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody OrgQualityIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除机构资质】(OrgQualityController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer orgQualityId = req.getOrgQualityId();
		JSONObject jsonOrgQuality = orgQualityService.deleteById(orgQualityId);
		logger.info("===step2:【删除机构资质】(OrgQualityController-delete)-根据orgQualityId删除机构资质, jsonOrgQuality:{}", jsonOrgQuality);
		OrgQualityVo orgQualityVo = JSONObject.toJavaObject(jsonOrgQuality, OrgQualityVo.class);

		//返回信息
		BaseRestMapResponse orgQualityResponse = new BaseRestMapResponse();
		orgQualityResponse.put(CommConstants.RESULT, orgQualityVo);
		logger.info("===step3:【删除机构资质】(OrgQualityController-delete)-返回信息, orgQualityResponse:{}", orgQualityResponse);
		return orgQualityResponse;
	}

	/**
	 * 修改机构资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改机构资质")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		OrgQualityRequest req, @RequestPart("fileList") MultipartFile[] multipartFiles,
		BindingResult bindingResult) {
		logger.info("===step1:【修改机构资质】(OrgQualityController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		List<OrgQualityAttachmentRequest> orgQualityAttachmentList = null;
		OrgQualityAttachmentRequest orgQualityAttachmentRequest = null;
		if(multipartFiles != null && multipartFiles.length >0) {
			orgQualityAttachmentList = new ArrayList<OrgQualityAttachmentRequest>();
			for (MultipartFile multipartFile : multipartFiles) {
				orgQualityAttachmentRequest = new OrgQualityAttachmentRequest();

				String fileUrl = fastdfsService.uploadImage(multipartFile);
				String filename = multipartFile.getOriginalFilename();
				orgQualityAttachmentRequest.setName(filename);
				orgQualityAttachmentRequest.setUrl(fileUrl);
				orgQualityAttachmentList.add(orgQualityAttachmentRequest);
			}
		}
		req.setOrgQualityAttachmentList(orgQualityAttachmentList);

		JSONObject jsonOrgQuality = orgQualityService.update(req);
		logger.info("===step2:【修改机构资质】(OrgQualityController-update)-修改机构资质, jsonOrgQuality:{}", jsonOrgQuality);
		OrgQualityVo orgQualityVo = JSONObject.toJavaObject(jsonOrgQuality, OrgQualityVo.class);

		//返回信息
		BaseRestMapResponse orgQualityResponse = new BaseRestMapResponse();
		orgQualityResponse.put(CommConstants.RESULT, orgQualityVo);
		logger.info("===step3:【修改机构资质】(OrgQualityController-update)-返回信息, orgQualityResponse:{}", orgQualityResponse);
		return orgQualityResponse;
	}

}