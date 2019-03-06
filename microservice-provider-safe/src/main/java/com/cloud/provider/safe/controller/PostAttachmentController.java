package com.cloud.provider.safe.controller;

import java.util.List;
import java.util.Map;

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
@RequestMapping(value="/postAttachment")
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
	@RequestMapping(value="/selectPostAttachmentListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectPostAttachmentListByPage(
		@RequestBody PostAttachmentRequest req) {
		logger.info("===step1:【分页查询岗位附件列表】(PostAttachmentController-selectPostAttachmentListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		PostAttachment postAttachment = new PostAttachment();
		Page<?> page = new Page<>(pageNum, pageSize);
		List<PostAttachment> list = postAttachmentService.selectPostAttachmentListByPage(page, postAttachment);
		logger.info("===step2:【分页查询岗位附件列表】(PostAttachmentController-selectPostAttachmentListByPage)-分页查询岗位附件列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}

		Map<String, Object> pageListMap = PageHelperUtil.INSTANCE.getPageListMap(list);
		BaseRestMapResponse postAttachmentResponse = new BaseRestMapResponse();
		postAttachmentResponse.putAll(pageListMap);
		logger.info("===step3:【分页查询岗位附件列表】(PostAttachmentController-selectPostAttachmentListByPage)-返回信息, postAttachmentResponse:{}", postAttachmentResponse);
		return postAttachmentResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询岗位附件列表")
	@RequestMapping(value="/selectPostAttachmentList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectPostAttachmentList(
		@RequestBody PostAttachmentRequest req) {
		logger.info("===step1:【不分页查询岗位附件列表】(PostAttachmentController-selectPostAttachmentList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		PostAttachment postAttachment = new PostAttachment();
		List<PostAttachment> list = null;
		list = postAttachmentService.selectPostAttachmentList(postAttachment);
		logger.info("===step2:【不分页查询岗位附件列表】(PostAttachmentController-selectPostAttachmentList)-不分页查询岗位附件列表, list.size:{}", list == null ? null : list.size());
//		if(list == null || list.isEmpty()) {
//			return new BaseRestMapResponse(SafeResultEnum.ORDER_LIST_NOTEXIST);
//		}

		BaseRestMapResponse postAttachmentResponse = new BaseRestMapResponse();
		postAttachmentResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【不分页查询岗位附件列表】(PostAttachmentController-selectPostAttachmentList)-返回信息, postAttachmentResponse:{}", postAttachmentResponse);
		return postAttachmentResponse;
	}

	/**
	 * 据id查询岗位附件
	 * @param postAttachmentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询岗位附件")
	@RequestMapping(value="/selectPostAttachmentById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectPostAttachmentById(
		@PathVariable(value="id",required=false) Integer postAttachmentId) {
		logger.info("===step1:【据id查询岗位附件】(selectPostAttachmentById-selectPostAttachmentById)-传入参数, postAttachmentId:{}", postAttachmentId);

		if(postAttachmentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "postAttachmentId为空");
		}

		PostAttachment postAttachment = postAttachmentService.selectPostAttachmentById(postAttachmentId);
		logger.info("===step2:【据id查询岗位附件】(PostAttachmentController-selectPostAttachmentById)-根据id查询岗位附件, postAttachment:{}", postAttachment);
		if(postAttachment == null) {
			return new BaseRestMapResponse(SafeResultEnum.ORDER_SETTING_ENTITY_NOTEXIST);
		}
		PostAttachmentVo postAttachmentVo = new PostAttachmentVo().convertToPostAttachmentVo(postAttachment);

		BaseRestMapResponse postAttachmentResponse = new BaseRestMapResponse();
		postAttachmentResponse.putAll((JSONObject) JSONObject.toJSON(postAttachmentVo));
		logger.info("===step3:【据id查询岗位附件】(PostAttachmentController-selectPostAttachmentById)-返回信息, postAttachmentResponse:{}", postAttachmentResponse);
		return postAttachmentResponse;
	}

	/**
	 * 添加岗位附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加岗位附件")
	@RequestMapping(value="/insertPostAttachment",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insertPostAttachment(
		@Validated @RequestBody PostAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加岗位附件】(PostAttachmentController-insertPostAttachment)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		PostAttachment postAttachment = req.convertToPostAttachment();
		int i = postAttachmentService.insertPostAttachment(postAttachment);
		logger.info("===step2:【添加岗位附件】(PostAttachmentController-insertPostAttachment)-插入岗位附件, i:{}", i);

		BaseRestMapResponse postAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加岗位附件】(PostAttachmentController-insertPostAttachment)-返回信息, postAttachmentResponse:{}", postAttachmentResponse);
		return postAttachmentResponse;
	}

	/**
	 * 根据id删除岗位附件
	 * @param postAttachmentId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除岗位附件")
	@RequestMapping(value="/deletePostAttachmentById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deletePostAttachmentById(
		@PathVariable(value="id",required=false) Integer postAttachmentId) {
		logger.info("===step1:【根据id删除岗位附件】(selectPostAttachmentById-deletePostAttachmentById)-传入参数, postAttachmentId:{}", postAttachmentId);

		if(postAttachmentId == null) {
			return new BaseRestMapResponse(SafeResultEnum.FIELD_EMPTY.getCode(), "postAttachmentId为空");
		}

		int i = postAttachmentService.deletePostAttachmentById(postAttachmentId);
		logger.info("===step2:【根据id删除岗位附件】(PostAttachmentController-deletePostAttachmentById)-根据id查询岗位附件, i:{}", i);

		BaseRestMapResponse postAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除岗位附件】(PostAttachmentController-deletePostAttachmentById)-返回信息, postAttachmentResponse:{}", postAttachmentResponse);
		return postAttachmentResponse;
	}

	/**
	 * 修改岗位附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改岗位附件")
	@RequestMapping(value="/modifyPostAttachment",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modifyPostAttachment(
		@Validated({ ModifyGroup.class }) @RequestBody PostAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改岗位附件】(PostAttachmentController-modifyPostAttachment)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer postAttachmentId = req.getPostAttachmentId();
		PostAttachment postAttachment = req.convertToPostAttachment();
		postAttachment.setId(postAttachmentId);
		int i = postAttachmentService.modifyPostAttachment(postAttachment);
		logger.info("===step2:【修改岗位附件】(PostAttachmentController-modifyPostAttachment)-修改岗位附件, i:{}", i);

		BaseRestMapResponse postAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改岗位附件】(PostAttachmentController-modifyPostAttachment)-返回信息, postAttachmentResponse:{}", postAttachmentResponse);
		return postAttachmentResponse;
	}


}