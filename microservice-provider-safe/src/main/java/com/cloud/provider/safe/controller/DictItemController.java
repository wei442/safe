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
import com.cloud.provider.safe.rest.request.dict.DictItemRequest;
import com.cloud.provider.safe.rest.request.page.dict.DictItemPageRequest;
import com.cloud.provider.safe.service.IDictItemService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.dict.DictItemVo;
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
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@Validated @RequestBody DictItemPageRequest req) {
		logger.info("===step1:【分页查询字典子项列表】(DictItemController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<DictItem> list = dictItemService.selectListByPage(page, req);
		logger.info("===step2:【分页查询字典子项列表】(DictItemController-selectListByPage)-分页查询字典子项列表, list.size:{}", list == null ? null : list.size());
		List<DictItemVo> dictItemVoList = new DictItemVo().convertToDictItemVoList(list);

		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		dictItemResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(dictItemVoList));
		logger.info("===step3:【分页查询字典子项列表】(DictItemController-selectListByPage)-返回信息, dictItemResponse:{}", dictItemResponse);
		return dictItemResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询字典子项列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody DictItemPageRequest req) {
		logger.info("===step1:【不分页查询字典子项列表】(DictItemController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<DictItem> list = dictItemService.selectList(req);
		logger.info("===step2:【不分页查询字典子项列表】(DictItemController-selectList)-不分页查询字典子项列表, list.size:{}", list == null ? null : list.size());
		List<DictItemVo> dictItemVoList = new DictItemVo().convertToDictItemVoList(list);

		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		dictItemResponse.put(PageConstants.DATA_LIST, dictItemVoList);
		logger.info("===step3:【不分页查询字典子项列表】(DictItemController-selectList)-返回信息, dictItemResponse:{}", dictItemResponse);
		return dictItemResponse;
	}

	/**
	 * 据id查询字典子项
	 * @param dictItemId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询字典子项")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer dictItemId) {
		logger.info("===step1:【据id查询字典子项】(DictItemController-selectById)-传入参数, dictItemId:{}", dictItemId);

		if(dictItemId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "dictItemId不能为空");
		}

		DictItem dictItem = dictItemService.selectById(dictItemId);
		logger.info("===step2:【据id查询字典子项】(DictItemController-selectById)-根据id查询字典子项, dictItem:{}", dictItem);
		DictItemVo dictItemVo = new DictItemVo().convertToDictItemVo(dictItem);

		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		dictItemResponse.putAll((JSONObject) JSONObject.toJSON(dictItemVo));
		logger.info("===step3:【据id查询字典子项】(DictItemController-selectById)-返回信息, dictItemResponse:{}", dictItemResponse);
		return dictItemResponse;
	}

	/**
	 * 添加字典子项
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加字典子项")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody DictItemRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加字典子项】(DictItemController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		DictItem dictItem = req.convertToDictItem();
		int i = dictItemService.insert(dictItem);
		logger.info("===step2:【添加字典子项】(DictItemController-insert)-插入字典子项, i:{}", i);

		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加字典子项】(DictItemController-insert)-返回信息, dictItemResponse:{}", dictItemResponse);
		return dictItemResponse;
	}

	/**
	 * 根据id删除字典子项
	 * @param dictItemId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除字典子项")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer dictItemId) {
		logger.info("===step1:【根据id删除字典子项】(selectById-deleteById)-传入参数, dictItemId:{}", dictItemId);

		if(dictItemId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "dictItemId不能为空");
		}

		int i = dictItemService.deleteById(dictItemId);
		logger.info("===step2:【根据id删除字典子项】(DictItemController-deleteById)-根据id查询字典子项, i:{}", i);

		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除字典子项】(DictItemController-deleteById)-返回信息, dictItemResponse:{}", dictItemResponse);
		return dictItemResponse;
	}

	/**
	 * 修改字典子项
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改字典子项")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody DictItemRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改字典子项】(DictItemController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer dictItemId = req.getDictItemId();
		DictItem dictItem = req.convertToDictItem();
		dictItem.setId(dictItemId);
		int i = dictItemService.modify(dictItem);
		logger.info("===step2:【修改字典子项】(DictItemController-modify)-修改字典子项, i:{}", i);

		BaseRestMapResponse dictItemResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改字典子项】(DictItemController-modify)-返回信息, dictItemResponse:{}", dictItemResponse);
		return dictItemResponse;
	}


}