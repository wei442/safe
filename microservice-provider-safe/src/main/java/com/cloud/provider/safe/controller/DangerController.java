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
import com.cloud.provider.safe.po.Danger;
import com.cloud.provider.safe.po.DangerAttachment;
import com.cloud.provider.safe.rest.request.danger.DangerIdsRequest;
import com.cloud.provider.safe.rest.request.danger.DangerRequest;
import com.cloud.provider.safe.rest.request.page.danger.DangerPageRequest;
import com.cloud.provider.safe.service.IDangerService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.danger.DangerVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 隐患 DangerController
 * @author wei.yong
 */
@Api(tags = "隐患")
@RestController
@RequestMapping(value="/danger")
public class DangerController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//隐患Service
	@Autowired
	private IDangerService dangerService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询隐患列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody DangerPageRequest req) {
		logger.info("===step1:【分页查询隐患列表】(DangerController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<Danger> list = dangerService.selectListByPage(page, req);
		logger.info("===step2:【分页查询隐患列表】(DangerController-selectListByPage)-分页查询隐患列表, list.size:{}", list == null ? null : list.size());
		List<DangerVo> dataList = new DangerVo().convertToDangerVoList(list);

		BaseRestMapResponse dangerResponse = new BaseRestMapResponse();
		dangerResponse.put(PageConstants.PAGE, PageHelperUtil.INSTANCE.getPageVo(list));
		dangerResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【分页查询隐患列表】(DangerController-selectListByPage)-返回信息, dangerResponse:{}", dangerResponse);
		return dangerResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询隐患列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody DangerPageRequest req) {
		logger.info("===step1:【不分页查询隐患列表】(DangerController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<Danger> list = dangerService.selectList(req);
		logger.info("===step2:【不分页查询隐患列表】(DangerController-selectList)-不分页查询隐患列表, list.size:{}", list == null ? null : list.size());
		List<DangerVo> dataList = new DangerVo().convertToDangerVoList(list);

		BaseRestMapResponse dangerResponse = new BaseRestMapResponse();
		dangerResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【不分页查询隐患列表】(DangerController-selectList)-返回信息, dangerResponse:{}", dangerResponse);
		return dangerResponse;
	}

	/**
	 * 据id查询隐患
	 * @param dangerId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询隐患")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer dangerId) {
		logger.info("===step1:【据id查询隐患】(DangerController-selectById)-传入参数, dangerId:{}", dangerId);

		if(dangerId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "dangerId不能为空");
		}

		Danger danger = dangerService.selectById(dangerId);
		logger.info("===step2:【据id查询隐患】(DangerController-selectById)-根据id查询隐患, danger:{}", danger);
		DangerVo dangerVo = new DangerVo().convertToDangerVo(danger);

		BaseRestMapResponse dangerResponse = new BaseRestMapResponse();
		dangerResponse.putAll((JSONObject) JSONObject.toJSON(dangerVo));
		logger.info("===step3:【据id查询隐患】(DangerController-selectById)-返回信息, dangerResponse:{}", dangerResponse);
		return dangerResponse;
	}

	/**
	 * 添加隐患
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加隐患")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody DangerRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加隐患】(DangerController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Danger danger = req.convertToDanger();
		List<DangerAttachment> dangerAttachmentList = req.convertToDangerAttachmentList();
		int i = dangerService.insert(danger, dangerAttachmentList);
		logger.info("===step2:【添加隐患】(DangerController-insert)-插入隐患, i:{}", i);

		BaseRestMapResponse dangerResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加隐患】(DangerController-insert)-返回信息, dangerResponse:{}", dangerResponse);
		return dangerResponse;
	}

	/**
	 * 批量删除隐患
	 * @param dangerIds
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "批量删除隐患")
	@RequestMapping(value="/batchDelete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse batchDelete(
		@Validated @RequestBody DangerIdsRequest req) {
		logger.info("===step1:【批量删除隐患】(DangerController-batchDelete)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		List<Integer> dangerIds = req.getDangerIds();
		int i = dangerService.deleteByIds(dangerIds);
		logger.info("===step2:【批量删除隐患】(DangerController-batchDelete)-根据dangerIds删除隐患, i:{}", i);

		BaseRestMapResponse dangerResponse = new BaseRestMapResponse();
		logger.info("===step3:【批量删除隐患】(DangerController-batchDelete)-返回信息, dangerResponse:{}", dangerResponse);
		return dangerResponse;
	}

	/**
	 * 修改隐患
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改隐患")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody DangerRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改隐患】(DangerController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer dangerId = req.getDangerId();
		List<Integer> dangerAttachmentIds = req.getDangerAttachmentIds();
		List<DangerAttachment> dangerAttachments = req.convertToDangerAttachmentList();
		Danger danger = req.convertToDanger();
		danger.setId(dangerId);
		int i = dangerService.modify(danger, dangerAttachmentIds, dangerAttachments);
		logger.info("===step2:【修改隐患】(DangerController-modify)-修改隐患, i:{}", i);

		BaseRestMapResponse dangerResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改隐患】(DangerController-modify)-返回信息, dangerResponse:{}", dangerResponse);
		return dangerResponse;
	}

}