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
import com.cloud.provider.safe.rest.request.dict.DictCodeRequest;
import com.cloud.provider.safe.rest.request.dict.DictRequest;
import com.cloud.provider.safe.rest.request.page.dict.DictPageRequest;
import com.cloud.provider.safe.service.IDictService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.dict.DictVo;
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
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody DictPageRequest req) {
		logger.info("===step1:【分页查询字典列表】(DictController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<Dict> list = dictService.selectListByPage(page, req);
		logger.info("===step2:【分页查询字典列表】(DictController-selectListByPage)-分页查询字典列表, list.size:{}", list == null ? null : list.size());
		List<DictVo> dataList = new DictVo().convertToDictVoList(list);

		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		dictResponse.put(PageConstants.PAGE, PageHelperUtil.INSTANCE.getPageVo(list));
		dictResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【分页查询字典列表】(DictController-selectListByPage)-返回信息, dictResponse:{}", dictResponse);
		return dictResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询字典")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody DictPageRequest req) {
		logger.info("===step1:【不分页查询字典列表】(DictController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<Dict> list = dictService.selectList(req);
		logger.info("===step2:【不分页查询字典列表】(DictController-selectList)-不分页查询字典列表, list.size:{}", list == null ? null : list.size());
		List<DictVo> dataList = new DictVo().convertToDictVoList(list);

		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		dictResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【不分页查询字典列表】(DictController-selectList)-返回信息, dictResponse:{}", dictResponse);
		return dictResponse;
	}

	/**
	 * 根据id查询字典
	 * @param dictId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询字典")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer dictId) {
		logger.info("===step1:【据id查询字典】(DictController-selectById)-传入参数, dictId:{}", dictId);

		if(dictId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "dictId不能为空");
		}

		Dict dict = dictService.selectById(dictId);
		logger.info("===step2:【据id查询字典】(DictController-selectById)-根据id查询字典, dict:{}", dict);
		DictVo dictVo = new DictVo().convertToDictVo(dict);

		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		dictResponse.putAll((JSONObject) JSONObject.toJSON(dictVo));
		logger.info("===step3:【据id查询字典】(DictController-selectById)-返回信息, dictResponse:{}", dictResponse);
		return dictResponse;
	}

	/**
	 * 根据enterpriseId和dictCode查询字典
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据enterpriseId和dictCode查询字典")
	@RequestMapping(value="/selectByEnterpriseIdDictCode",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectByEnterpriseIdDictCode(
		@Validated @RequestBody DictCodeRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【根据enterpriseId和dictCode查询字典】(DictController-selectByEnterpriseIdDictCode)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer enterpriseId = req.getEnterpriseId();
		String dictCode = req.getDictCode();

		Dict dict = dictService.selectByEnterpriseIdDictCode(enterpriseId, dictCode);
		logger.info("===step2:【根据enterpriseId和dictCode查询字典】(DictController-selectByEnterpriseIdDictCode)-根据enterpriseId和dictCode查询字典, dict:{}", dict);
		DictVo dictVo = new DictVo().convertToDictVo(dict);

		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		dictResponse.putAll((JSONObject) JSONObject.toJSON(dictVo));
		logger.info("===step3:【根据enterpriseId和dictCode查询字典】(DictController-selectByEnterpriseIdDictCode)-返回信息, dictResponse:{}", dictResponse);
		return dictResponse;
	}

	/**
	 * 添加字典
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加字典")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody DictRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加字典】(DictController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Dict dict = req.convertToDict();
		int i = dictService.insert(dict);
		logger.info("===step2:【添加字典】(DictController-insert)-插入字典, i:{}", i);

		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加字典】(DictController-insert)-返回信息, dictResponse:{}", dictResponse);
		return dictResponse;
	}

	/**
	 * 根据id删除字典
	 * @param dictId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除字典")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer dictId) {
		logger.info("===step1:【根据id删除字典】(selectById-deleteById)-传入参数, dictId:{}", dictId);

		if(dictId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "dictId不能为空");
		}

		int i = dictService.deleteById(dictId);
		logger.info("===step2:【根据id删除字典】(DictController-deleteById)-根据id查询字典, i:{}", i);

		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除字典】(DictController-deleteById)-返回信息, dictResponse:{}", dictResponse);
		return dictResponse;
	}

	/**
	 * 修改字典
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改字典")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody DictRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改字典】(DictController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer dictId = req.getDictId();
		Dict dict = req.convertToDict();
		dict.setId(dictId);
		int i = dictService.modify(dict);
		logger.info("===step2:【修改字典】(DictController-modify)-修改字典, i:{}", i);

		BaseRestMapResponse dictResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改字典】(DictController-modify)-返回信息, dictResponse:{}", dictResponse);
		return dictResponse;
	}

}