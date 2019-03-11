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
import com.cloud.consumer.safe.page.PageVo;
import com.cloud.consumer.safe.rest.request.DictRequest;
import com.cloud.consumer.safe.rest.request.page.DictPageRequest;
import com.cloud.consumer.safe.service.IDictService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.DictVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 字典管理 DictController
 * @author wei.yong
 * @ClassName: DictController
 */
@Api(tags = "字典")
@RestController
@RequestMapping("/dict")
public class DictController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//字典 Service
	@Autowired
	private IDictService dictService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询字典列表")
	@RequestMapping(value="/getDictListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDictListByPage(
		@RequestBody DictPageRequest req) {
		logger.info("===step1:【分页查询】(DictController-getDictListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDict = dictService.getDictListByPage(req);
		logger.info("===step2:【分页查询】(DictController-getDictListByPage)-分页查询字典列表, jsonDict:{}", jsonDict);
		String dataListStr = JSONObject.toJSONString(jsonDict.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonDict.getJSONObject(PageConstants.PAGE));
		List<DictVo> dictVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<DictVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, dictVoList);
		//返回信息
		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		dictResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(DictController-getDictListByPage)-返回信息, dictResponse:{}", dictResponse);
	    return dictResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询字典列表")
	@RequestMapping(value="/getDictList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDictList(
		@RequestBody DictPageRequest req) {
		logger.info("===step1:【不分页查询】(DictController-getDictList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDict = dictService.getDictListByPage(req);
		logger.info("===step2:【不分页查询】(DictController-getDictList)-不分页查询字典列表, jsonDict:{}", jsonDict);
		String dataListStr = JSONObject.toJSONString(jsonDict.getJSONArray(PageConstants.DATA_LIST));
		List<DictVo> dictVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<DictVo>>(){});

		//返回信息
		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		dictResponse.put(RetSafeConstants.RESULT, dictVoList);
		logger.info("===step3:【不分页查询】(DictController-getDictList)-返回信息, dictResponse:{}", dictResponse);
		return dictResponse;
	}

	/**
	 * 获取字典详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取字典详情")
	@RequestMapping(value="/getDict",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDict(
		@RequestBody DictRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取字典】(DictController-getDict)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer dictId = req.getDictId();
		JSONObject jsonDict = dictService.getDictById(dictId);
		logger.info("===step2:【获取字典】(DictController-getDict)-根据dictId获取字典, jsonDict:{}", jsonDict);
		DictVo dictVo = JSONObject.toJavaObject(jsonDict, DictVo.class);

		//返回信息
		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		dictResponse.put(RetSafeConstants.RESULT, dictVo);
	    logger.info("===step3:【获取字典】(DictController-getDict)-返回信息, dictResponse:{}", dictResponse);
	    return dictResponse;
	}

	/**
	 * 新增字典
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增字典")
	@RequestMapping(value="/addDict",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse addDict(
		@Validated @RequestBody DictRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增字典】(DictController-addDict)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonDict = dictService.addDict(req);
		logger.info("===step2:【新增字典】(DictController-addDict)-分页查询字典列表, jsonDict:{}", jsonDict);
		DictVo dictVo = JSONObject.toJavaObject(jsonDict, DictVo.class);

		//返回信息
		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		dictResponse.put(RetSafeConstants.RESULT, dictVo);
	    logger.info("===step3:【新增字典】(DictController-addDict)-返回信息, dictResponse:{}", dictResponse);
	    return dictResponse;
	}

	/**
	 * 删除字典
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除字典")
	@RequestMapping(value="/deleteDict",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteDict(
		@RequestBody DictRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除字典】(DictController-deleteDict)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer dictId = req.getDictId();
		JSONObject jsonDict = dictService.deleteDictById(dictId);
		logger.info("===step2:【删除字典】(DictController-deleteDict)-根据dictId删除字典, jsonDict:{}", jsonDict);
		DictVo dictVo = JSONObject.toJavaObject(jsonDict, DictVo.class);

		//返回信息
		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		dictResponse.put(RetSafeConstants.RESULT, dictVo);
		logger.info("===step3:【删除字典】(DictController-deleteDict)-返回信息, dictResponse:{}", dictResponse);
		return dictResponse;
	}

	/**
	 * 修改字典
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改字典")
	@RequestMapping(value="/updateDict",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse updateDict(
		@Validated({ UpdateGroup.class }) @RequestBody DictRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改字典】(DictController-updateDict)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonDict = dictService.addDict(req);
		logger.info("===step2:【修改字典】(DictController-updateDict)-修改字典, jsonDict:{}", jsonDict);
		DictVo dictVo = JSONObject.toJavaObject(jsonDict, DictVo.class);

		//返回信息
		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		dictResponse.put(RetSafeConstants.RESULT, dictVo);
		logger.info("===step3:【修改字典】(DictController-updateDict)-返回信息, dictResponse:{}", dictResponse);
		return dictResponse;
	}

}