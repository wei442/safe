package com.cloud.provider.safe.controller;

import java.util.List;
import java.util.Map;

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
import com.cloud.provider.safe.po.QualityAttachment;
import com.cloud.provider.safe.rest.request.QualityAttachmentRequest;
import com.cloud.provider.safe.service.IQualityAttachmentService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.QualityAttachmentVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 资质附件 QualityAttachmentController
 * @author wei.yong
 */
@Api(tags = "资质附件")
@RestController
@RequestMapping(value="/qualityAttachment")
public class QualityAttachmentController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//资质附件Service
	@Autowired
	private IQualityAttachmentService qualityAttachmentService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询资质附件列表")
	@RequestMapping(value="/selectQualityAttachmentListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectQualityAttachmentListByPage(
		@RequestBody QualityAttachmentRequest req) {
		logger.info("===step1:【分页查询资质附件列表】(QualityAttachmentController-selectQualityAttachmentListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		QualityAttachment qualityAttachment = new QualityAttachment();
		Page<?> page = new Page<>(pageNum, pageSize);
		List<QualityAttachment> list = qualityAttachmentService.selectQualityAttachmentListByPage(page, qualityAttachment);
		logger.info("===step2:【分页查询资质附件列表】(QualityAttachmentController-selectQualityAttachmentListByPage)-分页查询资质附件列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}

		Map<String, Object> pageListMap = PageHelperUtil.INSTANCE.getPageListMap(list);
		BaseRestMapResponse qualityAttachmentResponse = new BaseRestMapResponse();
		qualityAttachmentResponse.putAll(pageListMap);
		logger.info("===step3:【分页查询资质附件列表】(QualityAttachmentController-selectQualityAttachmentListByPage)-返回信息, qualityAttachmentResponse:{}", qualityAttachmentResponse);
		return qualityAttachmentResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询资质附件列表")
	@RequestMapping(value="/selectQualityAttachmentList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectQualityAttachmentList(
		@RequestBody QualityAttachmentRequest req) {
		logger.info("===step1:【不分页查询资质附件列表】(QualityAttachmentController-selectQualityAttachmentList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		QualityAttachment qualityAttachment = new QualityAttachment();
		List<QualityAttachment> list = null;
		list = qualityAttachmentService.selectQualityAttachmentList(qualityAttachment);
		logger.info("===step2:【不分页查询资质附件列表】(QualityAttachmentController-selectQualityAttachmentList)-不分页查询资质附件列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}

		BaseRestMapResponse qualityAttachmentResponse = new BaseRestMapResponse();
		qualityAttachmentResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【不分页查询资质附件列表】(QualityAttachmentController-selectQualityAttachmentList)-返回信息, qualityAttachmentResponse:{}", qualityAttachmentResponse);
		return qualityAttachmentResponse;
	}

	/**
	 * 据id查询资质附件
	 * @param qualityAttachmentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询资质附件")
	@RequestMapping(value="/selectQualityAttachmentById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectQualityAttachmentById(
		@PathVariable(value="id",required=false) Integer qualityAttachmentId) {
		logger.info("===step1:【据id查询资质附件】(selectQualityAttachmentById-selectQualityAttachmentById)-传入参数, qualityAttachmentId:{}", qualityAttachmentId);

		if(qualityAttachmentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "qualityAttachmentId为空");
		}

		QualityAttachment qualityAttachment = qualityAttachmentService.selectQualityAttachmentById(qualityAttachmentId);
		logger.info("===step2:【据id查询资质附件】(QualityAttachmentController-selectQualityAttachmentById)-根据id查询资质附件, qualityAttachment:{}", qualityAttachment);
		if(qualityAttachment == null) {
			return new BaseRestMapResponse(SafeResultEnum.ORDER_SETTING_ENTITY_NOTEXIST);
		}
		QualityAttachmentVo qualityAttachmentVo = new QualityAttachmentVo().convertToQualityAttachmentVo(qualityAttachment);

		BaseRestMapResponse qualityAttachmentResponse = new BaseRestMapResponse();
		qualityAttachmentResponse.putAll((JSONObject) JSONObject.toJSON(qualityAttachmentVo));
		logger.info("===step3:【据id查询资质附件】(QualityAttachmentController-selectQualityAttachmentById)-返回信息, qualityAttachmentResponse:{}", qualityAttachmentResponse);
		return qualityAttachmentResponse;
	}

	/**
	 * 添加资质附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加资质附件")
	@RequestMapping(value="/insertQualityAttachment",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertQualityAttachment(
		@Validated @RequestBody QualityAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加资质附件】(QualityAttachmentController-insertQualityAttachment)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		QualityAttachment qualityAttachment = req.convertToQualityAttachment();
		int i = qualityAttachmentService.insertQualityAttachment(qualityAttachment);
		logger.info("===step2:【添加资质附件】(QualityAttachmentController-insertQualityAttachment)-插入资质附件, i:{}", i);

		BaseRestMapResponse qualityAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加资质附件】(QualityAttachmentController-insertQualityAttachment)-返回信息, qualityAttachmentResponse:{}", qualityAttachmentResponse);
		return qualityAttachmentResponse;
	}

	/**
	 * 根据id删除资质附件
	 * @param qualityAttachmentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除资质附件")
	@RequestMapping(value="/deleteQualityAttachmentById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteQualityAttachmentById(
		@PathVariable(value="id",required=false) Integer qualityAttachmentId) {
		logger.info("===step1:【根据id删除资质附件】(selectQualityAttachmentById-deleteQualityAttachmentById)-传入参数, qualityAttachmentId:{}", qualityAttachmentId);

		if(qualityAttachmentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "qualityAttachmentId为空");
		}

		int i = qualityAttachmentService.deleteQualityAttachmentById(qualityAttachmentId);
		logger.info("===step2:【根据id删除资质附件】(QualityAttachmentController-deleteQualityAttachmentById)-根据id查询资质附件, i:{}", i);

		BaseRestMapResponse qualityAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除资质附件】(QualityAttachmentController-deleteQualityAttachmentById)-返回信息, qualityAttachmentResponse:{}", qualityAttachmentResponse);
		return qualityAttachmentResponse;
	}

	/**
	 * 修改资质附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改资质附件")
	@RequestMapping(value="/modifyQualityAttachment",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyQualityAttachment(
		@Validated({ ModifyGroup.class }) @RequestBody QualityAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改资质附件】(QualityAttachmentController-modifyQualityAttachment)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer qualityAttachmentId = req.getQualityAttachmentId();
		QualityAttachment qualityAttachment = req.convertToQualityAttachment();
		qualityAttachment.setId(qualityAttachmentId);
		int i = qualityAttachmentService.modifyQualityAttachment(qualityAttachment);
		logger.info("===step2:【修改资质附件】(QualityAttachmentController-modifyQualityAttachment)-修改资质附件, i:{}", i);

		BaseRestMapResponse qualityAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改资质附件】(QualityAttachmentController-modifyQualityAttachment)-返回信息, qualityAttachmentResponse:{}", qualityAttachmentResponse);
		return qualityAttachmentResponse;
	}

}