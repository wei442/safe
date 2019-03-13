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
import com.cloud.provider.safe.po.DictItem;
import com.cloud.provider.safe.rest.request.DictItemRequest;
import com.cloud.provider.safe.rest.request.page.DictItemPageRequest;
import com.cloud.provider.safe.service.IDictItemService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.DictItemVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 字典子项 DictItemController
 * @author wei.yong
 */
@Api(tags = "字典子项")
@RestController
@RequestMapping(value="/dict/item")
public class DictItemController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//字典子项Service
	@Autowired
	private IDictItemService dictItemService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询字典子项列表")
	@RequestMapping(value="/selectDictItemListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectDictItemListByPage(
		@RequestBody DictItemPageRequest req) {
		logger.info("===step1:【分页查询字典子项列表】(DictItemController-selectDictItemListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<DictItem> list = dictItemService.selectDictItemListByPage(page, req);
		logger.info("===step2:【分页查询字典子项列表】(DictItemController-selectDictItemListByPage)-分页查询字典子项列表, list.size:{}", list == null ? null : list.size());
		List<DictItemVo> dictItemVoList = new DictItemVo().convertToDictItemVoList(list);

		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		dictItemResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(dictItemVoList));
		logger.info("===step3:【分页查询字典子项列表】(DictItemController-selectDictItemListByPage)-返回信息, dictItemResponse:{}", dictItemResponse);
		return dictItemResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询字典子项列表")
	@RequestMapping(value="/selectDictItemList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectDictItemList(
		@RequestBody DictItemPageRequest req) {
		logger.info("===step1:【不分页查询字典子项列表】(DictItemController-selectDictItemList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<DictItem> list = dictItemService.selectDictItemList(req);
		logger.info("===step2:【不分页查询字典子项列表】(DictItemController-selectDictItemList)-不分页查询字典子项列表, list.size:{}", list == null ? null : list.size());
		List<DictItemVo> dictItemVoList = new DictItemVo().convertToDictItemVoList(list);

		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		dictItemResponse.put(PageConstants.DATA_LIST, dictItemVoList);
		logger.info("===step3:【不分页查询字典子项列表】(DictItemController-selectDictItemList)-返回信息, dictItemResponse:{}", dictItemResponse);
		return dictItemResponse;
	}

	/**
	 * 据id查询字典子项
	 * @param dictItemId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询字典子项")
	@RequestMapping(value="/selectDictItemById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectDictItemById(
		@PathVariable(value="id",required=false) Integer dictItemId) {
		logger.info("===step1:【据id查询字典子项】(selectDictItemById-selectDictItemById)-传入参数, dictItemId:{}", dictItemId);

		if(dictItemId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "dictItemId为空");
		}

		DictItem dictItem = dictItemService.selectDictItemById(dictItemId);
		logger.info("===step2:【据id查询字典子项】(DictItemController-selectDictItemById)-根据id查询字典子项, dictItem:{}", dictItem);
		if(dictItem == null) {
			return new BaseRestMapResponse(SafeResultEnum.DICT_ITEM_ENTITY_NOTEXIST);
		}
		DictItemVo dictItemVo = new DictItemVo().convertToDictItemVo(dictItem);

		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		dictItemResponse.putAll((JSONObject) JSONObject.toJSON(dictItemVo));
		logger.info("===step3:【据id查询字典子项】(DictItemController-selectDictItemById)-返回信息, dictItemResponse:{}", dictItemResponse);
		return dictItemResponse;
	}

	/**
	 * 添加字典子项
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加字典子项")
	@RequestMapping(value="/insertDictItem",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertDictItem(
		@Validated @RequestBody DictItemRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加字典子项】(DictItemController-insertDictItem)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		DictItem dictItem = req.convertToDictItem();
		int i = dictItemService.insertDictItem(dictItem);
		logger.info("===step2:【添加字典子项】(DictItemController-insertDictItem)-插入字典子项, i:{}", i);

		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加字典子项】(DictItemController-insertDictItem)-返回信息, dictItemResponse:{}", dictItemResponse);
		return dictItemResponse;
	}

	/**
	 * 根据id删除字典子项
	 * @param dictItemId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除字典子项")
	@RequestMapping(value="/deleteDictItemById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteDictItemById(
		@PathVariable(value="id",required=false) Integer dictItemId) {
		logger.info("===step1:【根据id删除字典子项】(selectDictItemById-deleteDictItemById)-传入参数, dictItemId:{}", dictItemId);

		if(dictItemId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "dictItemId为空");
		}

		int i = dictItemService.deleteDictItemById(dictItemId);
		logger.info("===step2:【根据id删除字典子项】(DictItemController-deleteDictItemById)-根据id查询字典子项, i:{}", i);

		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除字典子项】(DictItemController-deleteDictItemById)-返回信息, dictItemResponse:{}", dictItemResponse);
		return dictItemResponse;
	}

	/**
	 * 修改字典子项
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改字典子项")
	@RequestMapping(value="/modifyDictItem",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyDictItem(
		@Validated({ ModifyGroup.class }) @RequestBody DictItemRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改字典子项】(DictItemController-modifyDictItem)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer dictItemId = req.getDictItemId();
		DictItem dictItem = req.convertToDictItem();
		dictItem.setId(dictItemId);
		int i = dictItemService.modifyDictItem(dictItem);
		logger.info("===step2:【修改字典子项】(DictItemController-modifyDictItem)-修改字典子项, i:{}", i);

		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改字典子项】(DictItemController-modifyDictItem)-返回信息, dictItemResponse:{}", dictItemResponse);
		return dictItemResponse;
	}


}