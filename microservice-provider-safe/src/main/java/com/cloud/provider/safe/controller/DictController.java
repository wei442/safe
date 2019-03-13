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
import com.cloud.provider.safe.po.Dict;
import com.cloud.provider.safe.rest.request.DictRequest;
import com.cloud.provider.safe.rest.request.page.DictPageRequest;
import com.cloud.provider.safe.service.IDictService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.DictVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 字典 DictController
 * @author wei.yong
 */
@Api(tags = "字典")
@RestController
@RequestMapping(value="/dict")
public class DictController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//字典Service
	@Autowired
	private IDictService dictService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询字典列表")
	@RequestMapping(value="/selectDictListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectDictListByPage(
		@RequestBody DictPageRequest req) {
		logger.info("===step1:【分页查询字典列表】(DictController-selectDictListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<Dict> list = dictService.selectDictListByPage(page, req);
		logger.info("===step2:【分页查询字典列表】(DictController-selectDictListByPage)-分页查询字典列表, list.size:{}", list == null ? null : list.size());
		List<DictVo> dictVoList = new DictVo().convertToDictVoList(list);

		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		dictResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(dictVoList));
		logger.info("===step3:【分页查询字典列表】(DictController-selectDictListByPage)-返回信息, dictResponse:{}", dictResponse);
		return dictResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询字典")
	@RequestMapping(value="/selectDictList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectDictList(
		@RequestBody DictPageRequest req) {
		logger.info("===step1:【不分页查询字典列表】(DictController-selectDictList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<Dict> list = dictService.selectDictList(req);
		logger.info("===step2:【不分页查询字典列表】(DictController-selectDictList)-不分页查询字典列表, list.size:{}", list == null ? null : list.size());
		List<DictVo> dictVoList = new DictVo().convertToDictVoList(list);

		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		dictResponse.put(PageConstants.DATA_LIST, dictVoList);
		logger.info("===step3:【不分页查询字典列表】(DictController-selectDictList)-返回信息, dictResponse:{}", dictResponse);
		return dictResponse;
	}

	/**
	 * 据id查询字典
	 * @param dictId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询字典")
	@RequestMapping(value="/selectDictById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectDictById(
		@PathVariable(value="id",required=false) Integer dictId) {
		logger.info("===step1:【据id查询字典】(selectDictById-selectDictById)-传入参数, dictId:{}", dictId);

		if(dictId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "dictId为空");
		}

		Dict dict = dictService.selectDictById(dictId);
		logger.info("===step2:【据id查询字典】(DictController-selectDictById)-根据id查询字典, dict:{}", dict);
		if(dict == null) {
			return new BaseRestMapResponse(SafeResultEnum.DICT_ENTITY_NOTEXIST);
		}
		DictVo dictVo = new DictVo().convertToDictVo(dict);

		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		dictResponse.putAll((JSONObject) JSONObject.toJSON(dictVo));
		logger.info("===step3:【据id查询字典】(DictController-selectDictById)-返回信息, dictResponse:{}", dictResponse);
		return dictResponse;
	}

	/**
	 * 添加字典
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加字典")
	@RequestMapping(value="/insertDict",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertDict(
		@Validated @RequestBody DictRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加字典】(DictController-insertDict)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Dict dict = req.convertToDict();
		int i = dictService.insertDict(dict);
		logger.info("===step2:【添加字典】(DictController-insertDict)-插入字典, i:{}", i);

		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加字典】(DictController-insertDict)-返回信息, dictResponse:{}", dictResponse);
		return dictResponse;
	}

	/**
	 * 根据id删除字典
	 * @param dictId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除字典")
	@RequestMapping(value="/deleteDictById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteDictById(
		@PathVariable(value="id",required=false) Integer dictId) {
		logger.info("===step1:【根据id删除字典】(selectDictById-deleteDictById)-传入参数, dictId:{}", dictId);

		if(dictId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "dictId为空");
		}

		int i = dictService.deleteDictById(dictId);
		logger.info("===step2:【根据id删除字典】(DictController-deleteDictById)-根据id查询字典, i:{}", i);

		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除字典】(DictController-deleteDictById)-返回信息, dictResponse:{}", dictResponse);
		return dictResponse;
	}

	/**
	 * 修改字典
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改字典")
	@RequestMapping(value="/modifyDict",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyDict(
		@Validated({ ModifyGroup.class }) @RequestBody DictRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改字典】(DictController-modifyDict)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer dictId = req.getDictId();
		Dict dict = req.convertToDict();
		dict.setId(dictId);
		int i = dictService.modifyDict(dict);
		logger.info("===step2:【修改字典】(DictController-modifyDict)-修改字典, i:{}", i);

		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改字典】(DictController-modifyDict)-返回信息, dictResponse:{}", dictResponse);
		return dictResponse;
	}


}