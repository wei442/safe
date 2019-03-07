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
import com.cloud.provider.safe.rest.request.TitleRequest;
import com.cloud.provider.safe.rest.request.page.TitlePageRequest;
import com.cloud.provider.safe.service.ITitleService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.TitleVo;
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
	@RequestMapping(value="/selectTitleListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectTitleListByPage(
		@RequestBody TitlePageRequest req) {
		logger.info("===step1:【分页查询职务列表】(TitleController-selectTitleListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Title Title = new Title();
		Page<?> page = new Page<>(pageNum, pageSize);
		List<Title> list = TitleService.selectTitleListByPage(page, Title);
		logger.info("===step2:【分页查询职务列表】(TitleController-selectTitleListByPage)-分页查询职务列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}
		List<TitleVo> titleVoList = new TitleVo().convertToTitleVoList(list);

		BaseRestMapResponse titleResponse = new BaseRestMapResponse();
		titleResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(titleVoList));
		logger.info("===step3:【分页查询职务列表】(TitleController-selectTitleListByPage)-返回信息, titleResponse:{}", titleResponse);
		return titleResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询职务列表")
	@RequestMapping(value="/selectTitleList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectTitleList(
		@RequestBody TitlePageRequest req) {
		logger.info("===step1:【不分页查询职务列表】(TitleController-selectTitleList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Title Title = new Title();
		List<Title> list = null;
		list = TitleService.selectTitleList(Title);
		logger.info("===step2:【不分页查询职务列表】(TitleController-selectTitleList)-不分页查询职务列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}
		List<TitleVo> titleVoList = new TitleVo().convertToTitleVoList(list);

		BaseRestMapResponse TitleResponse = new BaseRestMapResponse();
		TitleResponse.put(PageConstants.DATA_LIST, titleVoList);
		logger.info("===step3:【不分页查询职务列表】(TitleController-selectTitleList)-返回信息, TitleResponse:{}", TitleResponse);
		return TitleResponse;
	}

	/**
	 * 据id查询职务
	 * @param TitleId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询职务")
	@RequestMapping(value="/selectTitleById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectTitleById(
		@PathVariable(value="id",required=false) Integer TitleId) {
		logger.info("===step1:【据id查询职务】(selectTitleById-selectTitleById)-传入参数, TitleId:{}", TitleId);

		if(TitleId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "TitleId为空");
		}

		Title Title = TitleService.selectTitleById(TitleId);
		logger.info("===step2:【据id查询职务】(TitleController-selectTitleById)-根据id查询职务, Title:{}", Title);
		if(Title == null) {
			return new BaseRestMapResponse(SafeResultEnum.ORDER_SETTING_ENTITY_NOTEXIST);
		}
		TitleVo TitleVo = new TitleVo().convertToTitleVo(Title);

		BaseRestMapResponse TitleResponse = new BaseRestMapResponse();
		TitleResponse.putAll((JSONObject) JSONObject.toJSON(TitleVo));
		logger.info("===step3:【据id查询职务】(TitleController-selectTitleById)-返回信息, TitleResponse:{}", TitleResponse);
		return TitleResponse;
	}

	/**
	 * 添加职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加职务")
	@RequestMapping(value="/insertTitle",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertTitle(
		@Validated @RequestBody TitleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加职务】(TitleController-insertTitle)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Title Title = req.convertToTitle();
		int i = TitleService.insertTitle(Title);
		logger.info("===step2:【添加职务】(TitleController-insertTitle)-插入职务, i:{}", i);

		BaseRestMapResponse TitleResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加职务】(TitleController-insertTitle)-返回信息, TitleResponse:{}", TitleResponse);
		return TitleResponse;
	}

	/**
	 * 根据id删除职务
	 * @param TitleId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除职务")
	@RequestMapping(value="/deleteTitleById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteTitleById(
		@PathVariable(value="id",required=false) Integer TitleId) {
		logger.info("===step1:【根据id删除职务】(selectTitleById-deleteTitleById)-传入参数, TitleId:{}", TitleId);

		if(TitleId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "TitleId为空");
		}

		int i = TitleService.deleteTitleById(TitleId);
		logger.info("===step2:【根据id删除职务】(TitleController-deleteTitleById)-根据id查询职务, i:{}", i);

		BaseRestMapResponse TitleResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除职务】(TitleController-deleteTitleById)-返回信息, TitleResponse:{}", TitleResponse);
		return TitleResponse;
	}

	/**
	 * 修改职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改职务")
	@RequestMapping(value="/modifyTitle",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyTitle(
		@Validated({ ModifyGroup.class }) @RequestBody TitleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改职务】(TitleController-modifyTitle)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer TitleId = req.getTitleId();
		Title Title = req.convertToTitle();
		Title.setId(TitleId);
		int i = TitleService.modifyTitle(Title);
		logger.info("===step2:【修改职务】(TitleController-modifyTitle)-修改职务, i:{}", i);

		BaseRestMapResponse TitleResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改职务】(TitleController-modifyTitle)-返回信息, TitleResponse:{}", TitleResponse);
		return TitleResponse;
	}

}