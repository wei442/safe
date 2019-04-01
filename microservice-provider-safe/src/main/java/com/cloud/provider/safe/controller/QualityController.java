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
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody QualityPageRequest req) {
		logger.info("===step1:【分页查询资质列表】(QualityController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<Quality> list = qualityService.selectListByPage(page, req);
		logger.info("===step2:【分页查询资质列表】(QualityController-selectListByPage)-分页查询资质列表, list.size:{}", list == null ? null : list.size());
		List<QualityVo> qualityVoList = new QualityVo().convertToQualityVoList(list);

		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		qualityResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(qualityVoList));
		logger.info("===step3:【分页查询资质列表】(QualityController-selectListByPage)-返回信息, qualityResponse:{}", qualityResponse);
		return qualityResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询资质列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody QualityPageRequest req) {
		logger.info("===step1:【不分页查询资质列表】(QualityController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<Quality> list = qualityService.selectList(req);
		logger.info("===step2:【不分页查询资质列表】(QualityController-selectList)-不分页查询资质列表, list.size:{}", list == null ? null : list.size());
		List<QualityVo> qualityVoList = new QualityVo().convertToQualityVoList(list);

		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		qualityResponse.put(PageConstants.DATA_LIST, qualityVoList);
		logger.info("===step3:【不分页查询资质列表】(QualityController-selectList)-返回信息, qualityResponse:{}", qualityResponse);
		return qualityResponse;
	}

	/**
	 * 据id查询资质
	 * @param qualityId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询资质")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer qualityId) {
		logger.info("===step1:【据id查询资质】(selectById-selectById)-传入参数, qualityId:{}", qualityId);

		if(qualityId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "qualityId不能为空");
		}

		Quality quality = qualityService.selectById(qualityId);
		logger.info("===step2:【据id查询资质】(QualityController-selectById)-根据id查询资质, quality:{}", quality);
		QualityVo qualityVo = new QualityVo().convertToQualityVo(quality);

		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		qualityResponse.putAll((JSONObject) JSONObject.toJSON(qualityVo));
		logger.info("===step3:【据id查询资质】(QualityController-selectById)-返回信息, qualityResponse:{}", qualityResponse);
		return qualityResponse;
	}

	/**
	 * 添加资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加资质")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody QualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加资质】(QualityController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		

		Quality quality = req.convertToQuality();
		int i = qualityService.insert(quality);
		logger.info("===step2:【添加资质】(QualityController-insert)-插入资质, i:{}", i);

		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加资质】(QualityController-insert)-返回信息, qualityResponse:{}", qualityResponse);
		return qualityResponse;
	}

	/**
	 * 根据id删除资质
	 * @param qualityId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除资质")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer qualityId) {
		logger.info("===step1:【根据id删除资质】(selectById-deleteById)-传入参数, qualityId:{}", qualityId);

		if(qualityId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "qualityId不能为空");
		}

		int i = qualityService.deleteById(qualityId);
		logger.info("===step2:【根据id删除资质】(QualityController-deleteById)-根据id查询资质, i:{}", i);

		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除资质】(QualityController-deleteById)-返回信息, qualityResponse:{}", qualityResponse);
		return qualityResponse;
	}

	/**
	 * 修改资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改资质")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody QualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改资质】(QualityController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		

		Integer qualityId = req.getQualityId();
		Quality quality = req.convertToQuality();
		quality.setId(qualityId);
		int i = qualityService.modify(quality);
		logger.info("===step2:【修改资质】(QualityController-modify)-修改资质, i:{}", i);

		BaseRestMapResponse qualityResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改资质】(QualityController-modify)-返回信息, qualityResponse:{}", qualityResponse);
		return qualityResponse;
	}

}