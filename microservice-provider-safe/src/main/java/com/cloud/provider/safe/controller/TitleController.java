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
import com.cloud.provider.safe.po.Title;
import com.cloud.provider.safe.rest.request.page.post.TitlePageRequest;
import com.cloud.provider.safe.rest.request.post.TitleRequest;
import com.cloud.provider.safe.service.ITitleService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.post.TitleVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 职务 TitleController
 * @author wei.yong
 */
@Api(tags = "职务")
@RestController
@RequestMapping(value="/title")
public class TitleController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//职务Service
	@Autowired
	private ITitleService TitleService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询职务列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody TitlePageRequest req) {
		logger.info("===step1:【分页查询职务列表】(TitleController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<Title> list = TitleService.selectListByPage(page, req);
		logger.info("===step2:【分页查询职务列表】(TitleController-selectListByPage)-分页查询职务列表, list.size:{}", list == null ? null : list.size());
		List<TitleVo> titleVoList = new TitleVo().convertToTitleVoList(list);

		BaseRestMapResponse titleResponse = new BaseRestMapResponse();
		titleResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(titleVoList));
		logger.info("===step3:【分页查询职务列表】(TitleController-selectListByPage)-返回信息, titleResponse:{}", titleResponse);
		return titleResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询职务列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody TitlePageRequest req) {
		logger.info("===step1:【不分页查询职务列表】(TitleController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<Title> list = TitleService.selectList(req);
		logger.info("===step2:【不分页查询职务列表】(TitleController-selectList)-不分页查询职务列表, list.size:{}", list == null ? null : list.size());
		List<TitleVo> titleVoList = new TitleVo().convertToTitleVoList(list);

		BaseRestMapResponse TitleResponse = new BaseRestMapResponse();
		TitleResponse.put(PageConstants.DATA_LIST, titleVoList);
		logger.info("===step3:【不分页查询职务列表】(TitleController-selectList)-返回信息, TitleResponse:{}", TitleResponse);
		return TitleResponse;
	}

	/**
	 * 据id查询职务
	 * @param TitleId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询职务")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer TitleId) {
		logger.info("===step1:【据id查询职务】(TitleController-selectById)-传入参数, TitleId:{}", TitleId);

		if(TitleId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "TitleId不能为空");
		}

		Title Title = TitleService.selectById(TitleId);
		logger.info("===step2:【据id查询职务】(TitleController-selectById)-根据id查询职务, Title:{}", Title);
		TitleVo TitleVo = new TitleVo().convertToTitleVo(Title);

		BaseRestMapResponse TitleResponse = new BaseRestMapResponse();
		TitleResponse.putAll((JSONObject) JSONObject.toJSON(TitleVo));
		logger.info("===step3:【据id查询职务】(TitleController-selectById)-返回信息, TitleResponse:{}", TitleResponse);
		return TitleResponse;
	}

	/**
	 * 添加职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加职务")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody TitleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加职务】(TitleController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Title Title = req.convertToTitle();
		int i = TitleService.insert(Title);
		logger.info("===step2:【添加职务】(TitleController-insert)-插入职务, i:{}", i);

		BaseRestMapResponse TitleResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加职务】(TitleController-insert)-返回信息, TitleResponse:{}", TitleResponse);
		return TitleResponse;
	}

	/**
	 * 根据id删除职务
	 * @param TitleId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除职务")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer TitleId) {
		logger.info("===step1:【根据id删除职务】(selectById-deleteById)-传入参数, TitleId:{}", TitleId);

		if(TitleId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "TitleId不能为空");
		}

		int i = TitleService.deleteById(TitleId);
		logger.info("===step2:【根据id删除职务】(TitleController-deleteById)-根据id查询职务, i:{}", i);

		BaseRestMapResponse TitleResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除职务】(TitleController-deleteById)-返回信息, TitleResponse:{}", TitleResponse);
		return TitleResponse;
	}

	/**
	 * 修改职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改职务")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody TitleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改职务】(TitleController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));



		Integer TitleId = req.getTitleId();
		Title Title = req.convertToTitle();
		Title.setId(TitleId);
		int i = TitleService.modify(Title);
		logger.info("===step2:【修改职务】(TitleController-modify)-修改职务, i:{}", i);

		BaseRestMapResponse TitleResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改职务】(TitleController-modify)-返回信息, TitleResponse:{}", TitleResponse);
		return TitleResponse;
	}

}