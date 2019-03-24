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
import com.cloud.provider.safe.po.PostAttachment;
import com.cloud.provider.safe.rest.request.PostAttachmentRequest;
import com.cloud.provider.safe.rest.request.page.PostAttachmentPageRequest;
import com.cloud.provider.safe.service.IPostAttachmentService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.PostAttachmentVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 岗位附件 PostAttachmentController
 * @author wei.yong
 */
@Api(tags = "岗位附件")
@RestController
@RequestMapping(value="/post/attachment")
public class PostAttachmentController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//岗位附件Service
	@Autowired
	private IPostAttachmentService postAttachmentService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询岗位附件列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody PostAttachmentPageRequest req) {
		logger.info("===step1:【分页查询岗位附件列表】(PostAttachmentController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<PostAttachment> list = postAttachmentService.selectListByPage(page, req);
		logger.info("===step2:【分页查询岗位附件列表】(PostAttachmentController-selectListByPage)-分页查询岗位附件列表, list.size:{}", list == null ? null : list.size());
		List<PostAttachmentVo> postAttachmentVoList = new PostAttachmentVo().convertToPostAttachmentVoList(list);

		BaseRestMapResponse postAttachmentResponse = new BaseRestMapResponse();
		postAttachmentResponse.putAll(PageHelperUtil.INSTANCE.getPageListMap(postAttachmentVoList));
		logger.info("===step3:【分页查询岗位附件列表】(PostAttachmentController-selectListByPage)-返回信息, postAttachmentResponse:{}", postAttachmentResponse);
		return postAttachmentResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询岗位附件列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody PostAttachmentPageRequest req) {
		logger.info("===step1:【不分页查询岗位附件列表】(PostAttachmentController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<PostAttachment> list = postAttachmentService.selectList(req);
		logger.info("===step2:【不分页查询岗位附件列表】(PostAttachmentController-selectList)-不分页查询岗位附件列表, list.size:{}", list == null ? null : list.size());
		List<PostAttachmentVo> postAttachmentVoList = new PostAttachmentVo().convertToPostAttachmentVoList(list);

		BaseRestMapResponse postAttachmentResponse = new BaseRestMapResponse();
		postAttachmentResponse.put(PageConstants.DATA_LIST, postAttachmentVoList);
		logger.info("===step3:【不分页查询岗位附件列表】(PostAttachmentController-selectList)-返回信息, postAttachmentResponse:{}", postAttachmentResponse);
		return postAttachmentResponse;
	}

	/**
	 * 据id查询岗位附件
	 * @param postAttachmentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询岗位附件")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer postAttachmentId) {
		logger.info("===step1:【据id查询岗位附件】(selectById-selectById)-传入参数, postAttachmentId:{}", postAttachmentId);

		if(postAttachmentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "postAttachmentId为空");
		}

		PostAttachment postAttachment = postAttachmentService.selectById(postAttachmentId);
		logger.info("===step2:【据id查询岗位附件】(PostAttachmentController-selectById)-根据id查询岗位附件, postAttachment:{}", postAttachment);
		PostAttachmentVo postAttachmentVo = new PostAttachmentVo().convertToPostAttachmentVo(postAttachment);

		BaseRestMapResponse postAttachmentResponse = new BaseRestMapResponse();
		postAttachmentResponse.putAll((JSONObject) JSONObject.toJSON(postAttachmentVo));
		logger.info("===step3:【据id查询岗位附件】(PostAttachmentController-selectById)-返回信息, postAttachmentResponse:{}", postAttachmentResponse);
		return postAttachmentResponse;
	}

	/**
	 * 添加岗位附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加岗位附件")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody PostAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加岗位附件】(PostAttachmentController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		

		PostAttachment postAttachment = req.convertToPostAttachment();
		int i = postAttachmentService.insert(postAttachment);
		logger.info("===step2:【添加岗位附件】(PostAttachmentController-insert)-插入岗位附件, i:{}", i);

		BaseRestMapResponse postAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加岗位附件】(PostAttachmentController-insert)-返回信息, postAttachmentResponse:{}", postAttachmentResponse);
		return postAttachmentResponse;
	}

	/**
	 * 根据id删除岗位附件
	 * @param postAttachmentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除岗位附件")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer postAttachmentId) {
		logger.info("===step1:【根据id删除岗位附件】(selectById-deleteById)-传入参数, postAttachmentId:{}", postAttachmentId);

		if(postAttachmentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "postAttachmentId为空");
		}

		int i = postAttachmentService.deleteById(postAttachmentId);
		logger.info("===step2:【根据id删除岗位附件】(PostAttachmentController-deleteById)-根据id查询岗位附件, i:{}", i);

		BaseRestMapResponse postAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除岗位附件】(PostAttachmentController-deleteById)-返回信息, postAttachmentResponse:{}", postAttachmentResponse);
		return postAttachmentResponse;
	}

	/**
	 * 修改岗位附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改岗位附件")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody PostAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改岗位附件】(PostAttachmentController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		

		Integer postAttachmentId = req.getPostAttachmentId();
		PostAttachment postAttachment = req.convertToPostAttachment();
		postAttachment.setId(postAttachmentId);
		int i = postAttachmentService.modify(postAttachment);
		logger.info("===step2:【修改岗位附件】(PostAttachmentController-modify)-修改岗位附件, i:{}", i);

		BaseRestMapResponse postAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改岗位附件】(PostAttachmentController-modify)-返回信息, postAttachmentResponse:{}", postAttachmentResponse);
		return postAttachmentResponse;
	}


}