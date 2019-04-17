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
import com.cloud.common.constants.CommConstants;
import com.cloud.common.constants.PageConstants;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.page.PageVo;
import com.cloud.consumer.safe.rest.request.dict.DictItemIdRequest;
import com.cloud.consumer.safe.rest.request.dict.DictItemRequest;
import com.cloud.consumer.safe.rest.request.page.dict.DictItemPageRequest;
import com.cloud.consumer.safe.service.IDictItemService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.dict.DictItemVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 字典子项管理 DictItemController
 * @author wei.yong
 * @ClassName: DictItemController
 */
@Api(tags = "字典子项")
@RestController
@RequestMapping("/dict/item")
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
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody DictItemPageRequest req) {
		logger.info("===step1:【分页查询】(DictItemController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDictItem = dictItemService.getListByPage(req);
		logger.info("===step2:【分页查询】(DictItemController-getListByPage)-分页查询字典子项列表, jsonDictItem:{}", jsonDictItem);
		String dataListStr = JSONObject.toJSONString(jsonDictItem.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonDictItem.getJSONObject(PageConstants.PAGE));
		List<DictItemVo> dictItemVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<DictItemVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, dictItemVoList);
		//返回信息
		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		dictItemResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(DictItemController-getListByPage)-返回信息, dictItemResponse:{}", dictItemResponse);
	    return dictItemResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询字典子项列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody DictItemPageRequest req) {
		logger.info("===step1:【不分页查询】(DictItemController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDictItem = dictItemService.getList(req);
		logger.info("===step2:【不分页查询】(DictItemController-getList)-不分页查询字典子项列表, jsonDictItem:{}", jsonDictItem);
		String dataListStr = JSONObject.toJSONString(jsonDictItem.getJSONArray(PageConstants.DATA_LIST));
		List<DictItemVo> dictItemVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<DictItemVo>>(){});

		BaseResultVo result = new BaseResultVo(dictItemVoList);
		//返回信息
		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		dictItemResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(DictItemController-getList)-返回信息, dictItemResponse:{}", dictItemResponse);
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
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody DictItemIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取字典子项】(DictItemController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer dictItemId = req.getDictItemId();
		JSONObject jsonDictItem = dictItemService.getById(dictItemId);
		logger.info("===step2:【获取字典子项】(DictItemController-getDetail)-根据dictItemId获取字典子项, jsonDictItem:{}", jsonDictItem);
		DictItemVo dictItemVo = JSONObject.toJavaObject(jsonDictItem, DictItemVo.class);

		//返回信息
		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		dictItemResponse.put(CommConstants.RESULT, dictItemVo);
	    logger.info("===step3:【获取字典子项】(DictItemController-getDetail)-返回信息, dictItemResponse:{}", dictItemResponse);
	    return dictItemResponse;
	}

	/**
	 * 新增字典子项
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增字典子项")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody DictItemRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增字典子项】(DictItemController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDictItem = dictItemService.add(req);
		logger.info("===step2:【新增字典子项】(DictItemController-add)-分页查询字典子项列表, jsonDictItem:{}", jsonDictItem);

		//返回信息
		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增字典子项】(DictItemController-add)-返回信息, dictItemResponse:{}", dictItemResponse);
	    return dictItemResponse;
	}

	/**
	 * 删除字典子项
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除字典子项")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody DictItemIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除字典子项】(DictItemController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer dictItemId = req.getDictItemId();
		JSONObject jsonDictItem = dictItemService.deleteById(dictItemId);
		logger.info("===step2:【删除字典子项】(DictItemController-delete)-根据dictItemId删除字典子项, jsonDictItem:{}", jsonDictItem);

		//返回信息
		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除字典子项】(DictItemController-delete)-返回信息, dictItemResponse:{}", dictItemResponse);
		return dictItemResponse;
	}

	/**
	 * 修改字典子项
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改字典子项")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody DictItemRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改字典子项】(DictItemController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDictItem = dictItemService.update(req);
		logger.info("===step2:【修改字典子项】(DictItemController-update)-修改字典子项, jsonDictItem:{}", jsonDictItem);

		//返回信息
		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改字典子项】(DictItemController-update)-返回信息, dictItemResponse:{}", dictItemResponse);
		return dictItemResponse;
	}

}