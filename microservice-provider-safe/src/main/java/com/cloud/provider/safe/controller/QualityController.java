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
import com.cloud.provider.safe.po.Quality;
import com.cloud.provider.safe.rest.request.QualityRequest;
import com.cloud.provider.safe.rest.request.page.QualityPageRequest;
import com.cloud.provider.safe.service.IQualityService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.QualityVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 资质 QualityController
 * @author wei.yong
 */
@Api(tags = "资质")
@RestController
@RequestMapping(value="/quality")
public class QualityController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//资质Service
	@Autowired
	private IQualityService qualityService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询资质列表")
	@RequestMapping(value="/selectQualityListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectQualityListByPage(
		@RequestBody QualityPageRequest req) {
		logger.info("===step1:【分页查询资质列表】(QualityController-selectQualityListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<Quality> list = qualityService.selectQualityListByPage(page, req);
		logger.info("===step2:【分页查询资质列表】(QualityController-selectQualityListByPage)-分页查询资质列表, list.size:{}", list == null ? null : list.size());
		List<QualityVo> qualityVoList = new QualityVo().convertToQualityVoList(list);

		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		qualityResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(qualityVoList));
		logger.info("===step3:【分页查询资质列表】(QualityController-selectQualityListByPage)-返回信息, qualityResponse:{}", qualityResponse);
		return qualityResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询资质列表")
	@RequestMapping(value="/selectQualityList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectQualityList(
		@RequestBody QualityPageRequest req) {
		logger.info("===step1:【不分页查询资质列表】(QualityController-selectQualityList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<Quality> list = qualityService.selectQualityList(req);
		logger.info("===step2:【不分页查询资质列表】(QualityController-selectQualityList)-不分页查询资质列表, list.size:{}", list == null ? null : list.size());
		List<QualityVo> qualityVoList = new QualityVo().convertToQualityVoList(list);

		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		qualityResponse.put(PageConstants.DATA_LIST, qualityVoList);
		logger.info("===step3:【不分页查询资质列表】(QualityController-selectQualityList)-返回信息, qualityResponse:{}", qualityResponse);
		return qualityResponse;
	}

	/**
	 * 据id查询资质
	 * @param qualityId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询资质")
	@RequestMapping(value="/selectQualityById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectQualityById(
		@PathVariable(value="id",required=false) Integer qualityId) {
		logger.info("===step1:【据id查询资质】(selectQualityById-selectQualityById)-传入参数, qualityId:{}", qualityId);

		if(qualityId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "qualityId为空");
		}

		Quality quality = qualityService.selectQualityById(qualityId);
		logger.info("===step2:【据id查询资质】(QualityController-selectQualityById)-根据id查询资质, quality:{}", quality);
		if(quality == null) {
			return new BaseRestMapResponse(SafeResultEnum.ORDER_SETTING_ENTITY_NOTEXIST);
		}
		QualityVo qualityVo = new QualityVo().convertToQualityVo(quality);

		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		qualityResponse.putAll((JSONObject) JSONObject.toJSON(qualityVo));
		logger.info("===step3:【据id查询资质】(QualityController-selectQualityById)-返回信息, qualityResponse:{}", qualityResponse);
		return qualityResponse;
	}

	/**
	 * 添加资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加资质")
	@RequestMapping(value="/insertQuality",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertQuality(
		@Validated @RequestBody QualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加资质】(QualityController-insertQuality)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Quality quality = req.convertToQuality();
		int i = qualityService.insertQuality(quality);
		logger.info("===step2:【添加资质】(QualityController-insertQuality)-插入资质, i:{}", i);

		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加资质】(QualityController-insertQuality)-返回信息, qualityResponse:{}", qualityResponse);
		return qualityResponse;
	}

	/**
	 * 根据id删除资质
	 * @param qualityId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除资质")
	@RequestMapping(value="/deleteQualityById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteQualityById(
		@PathVariable(value="id",required=false) Integer qualityId) {
		logger.info("===step1:【根据id删除资质】(selectQualityById-deleteQualityById)-传入参数, qualityId:{}", qualityId);

		if(qualityId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "qualityId为空");
		}

		int i = qualityService.deleteQualityById(qualityId);
		logger.info("===step2:【根据id删除资质】(QualityController-deleteQualityById)-根据id查询资质, i:{}", i);

		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除资质】(QualityController-deleteQualityById)-返回信息, qualityResponse:{}", qualityResponse);
		return qualityResponse;
	}

	/**
	 * 修改资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改资质")
	@RequestMapping(value="/modifyQuality",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyQuality(
		@Validated({ ModifyGroup.class }) @RequestBody QualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改资质】(QualityController-modifyQuality)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer qualityId = req.getQualityId();
		Quality quality = req.convertToQuality();
		quality.setId(qualityId);
		int i = qualityService.modifyQuality(quality);
		logger.info("===step2:【修改资质】(QualityController-modifyQuality)-修改资质, i:{}", i);

		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改资质】(QualityController-modifyQuality)-返回信息, qualityResponse:{}", qualityResponse);
		return qualityResponse;
	}

}