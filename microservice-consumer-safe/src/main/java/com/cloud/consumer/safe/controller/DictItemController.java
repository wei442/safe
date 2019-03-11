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
import com.cloud.consumer.safe.rest.request.DictItemRequest;
import com.cloud.consumer.safe.rest.request.page.DictItemPageRequest;
import com.cloud.consumer.safe.service.IDictItemService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.DictItemVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 字典子项管理 DictItemController
 * @author wei.yong
 * @ClassName: DictItemController
 */
@Api(tags = "字典子项")
@RestController
@RequestMapping("/dictItem")
public class DictItemController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//字典子项 Service
	@Autowired
	private IDictItemService dictItemService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询字典子项列表")
	@RequestMapping(value="/getDictItemListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDictItemListByPage(
		@RequestBody DictItemPageRequest req) {
		logger.info("===step1:【分页查询】(DictItemController-getDictItemListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDictItem = dictItemService.getDictItemListByPage(req);
		logger.info("===step2:【分页查询】(DictItemController-getDictItemListByPage)-分页查询字典子项列表, jsonDictItem:{}", jsonDictItem);
		String dataListStr = JSONObject.toJSONString(jsonDictItem.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonDictItem.getJSONObject(PageConstants.PAGE));
		List<DictItemVo> dictItemVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<DictItemVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, dictItemVoList);
		//返回信息
		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		dictItemResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(DictItemController-getDictItemListByPage)-返回信息, dictItemResponse:{}", dictItemResponse);
	    return dictItemResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询字典子项列表")
	@RequestMapping(value="/getDictItemList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDictItemList(
		@RequestBody DictItemPageRequest req) {
		logger.info("===step1:【不分页查询】(DictItemController-getDictItemList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDictItem = dictItemService.getDictItemListByPage(req);
		logger.info("===step2:【不分页查询】(DictItemController-getDictItemList)-不分页查询字典子项列表, jsonDictItem:{}", jsonDictItem);
		String dataListStr = JSONObject.toJSONString(jsonDictItem.getJSONArray(PageConstants.DATA_LIST));
		List<DictItemVo> dictItemVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<DictItemVo>>(){});

		//返回信息
		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		dictItemResponse.put(RetSafeConstants.RESULT, dictItemVoList);
		logger.info("===step3:【不分页查询】(DictItemController-getDictItemList)-返回信息, dictItemResponse:{}", dictItemResponse);
		return dictItemResponse;
	}

	/**
	 * 获取字典子项详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取字典子项详情")
	@RequestMapping(value="/getDictItem",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDictItem(
		@RequestBody DictItemRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取字典子项】(DictItemController-getDictItem)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer dictItemId = req.getDictItemId();
		JSONObject jsonDictItem = dictItemService.getDictItemById(dictItemId);
		logger.info("===step2:【获取字典子项】(DictItemController-getDictItem)-根据dictItemId获取字典子项, jsonDictItem:{}", jsonDictItem);
		DictItemVo dictItemVo = JSONObject.toJavaObject(jsonDictItem, DictItemVo.class);

		//返回信息
		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		dictItemResponse.put(RetSafeConstants.RESULT, dictItemVo);
	    logger.info("===step3:【获取字典子项】(DictItemController-getDictItem)-返回信息, dictItemResponse:{}", dictItemResponse);
	    return dictItemResponse;
	}

	/**
	 * 新增字典子项
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增字典子项")
	@RequestMapping(value="/addDictItem",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse addDictItem(
		@Validated @RequestBody DictItemRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增字典子项】(DictItemController-addDictItem)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonDictItem = dictItemService.addDictItem(req);
		logger.info("===step2:【新增字典子项】(DictItemController-addDictItem)-分页查询字典子项列表, jsonDictItem:{}", jsonDictItem);
		DictItemVo dictItemVo = JSONObject.toJavaObject(jsonDictItem, DictItemVo.class);

		//返回信息
		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		dictItemResponse.put(RetSafeConstants.RESULT, dictItemVo);
	    logger.info("===step3:【新增字典子项】(DictItemController-addDictItem)-返回信息, dictItemResponse:{}", dictItemResponse);
	    return dictItemResponse;
	}

	/**
	 * 删除字典子项
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除字典子项")
	@RequestMapping(value="/deleteDictItem",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteDictItem(
		@RequestBody DictItemRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除字典子项】(DictItemController-deleteDictItem)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer dictItemId = req.getDictItemId();
		JSONObject jsonDictItem = dictItemService.deleteDictItemById(dictItemId);
		logger.info("===step2:【删除字典子项】(DictItemController-deleteDictItem)-根据dictItemId删除字典子项, jsonDictItem:{}", jsonDictItem);
		DictItemVo dictItemVo = JSONObject.toJavaObject(jsonDictItem, DictItemVo.class);

		//返回信息
		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		dictItemResponse.put(RetSafeConstants.RESULT, dictItemVo);
		logger.info("===step3:【删除字典子项】(DictItemController-deleteDictItem)-返回信息, dictItemResponse:{}", dictItemResponse);
		return dictItemResponse;
	}

	/**
	 * 修改字典子项
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改字典子项")
	@RequestMapping(value="/updateDictItem",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse updateDictItem(
		@Validated({ UpdateGroup.class }) @RequestBody DictItemRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改字典子项】(DictItemController-updateDictItem)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonDictItem = dictItemService.addDictItem(req);
		logger.info("===step2:【修改字典子项】(DictItemController-updateDictItem)-修改字典子项, jsonDictItem:{}", jsonDictItem);
		DictItemVo dictItemVo = JSONObject.toJavaObject(jsonDictItem, DictItemVo.class);

		//返回信息
		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		dictItemResponse.put(RetSafeConstants.RESULT, dictItemVo);
		logger.info("===step3:【修改字典子项】(DictItemController-updateDictItem)-返回信息, dictItemResponse:{}", dictItemResponse);
		return dictItemResponse;
	}

}