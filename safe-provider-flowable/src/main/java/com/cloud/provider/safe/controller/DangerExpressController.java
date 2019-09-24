package com.cloud.provider.safe.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.flowable.engine.HistoryService;
import org.flowable.engine.ProcessEngine;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cloud.provider.safe.base.BaseRestMapResponse;
import com.cloud.provider.safe.rest.request.page.danger.DangerCheckPageRequest;
import com.cloud.provider.safe.service.MyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 隐患快报 DangerExpressController
 * @author wei.yong
 */
@Api(tags = "隐患快报")
@RestController
@RequestMapping(value="/danger/express")
public class DangerExpressController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
    private MyService myService;

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @Autowired
    private ProcessEngine processEngine;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "启动流程申请")
	@RequestMapping(value="/start",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse start(
		@RequestBody DangerCheckPageRequest req) {
		logger.info("===step1:【分页查询】(DangerCheckController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		HashMap<String, Object> map = new HashMap<>();
//		map.put("userId", userId);
//	 	map.put("purchaseOrderId", purchaseOrderId);
	  	ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("OrderApproval", map);
	  	String processId = processInstance.getId();
		String processName = processInstance.getName();

		//返回信息
		BaseRestMapResponse dangerCheckResponse = new BaseRestMapResponse();
		dangerCheckResponse.put("processId", processId);
		dangerCheckResponse.put("processName", processName);
	    logger.info("===step3:【分页查询】(DangerCheckController-getListByPage)-返回信息, dangerCheckResponse:{}", dangerCheckResponse);
	    return dangerCheckResponse;
	}


    @RequestMapping(value="/process", method= RequestMethod.POST)
    public void startProcessInstance() {
        myService.startProcess();
    }

    @RequestMapping(value="/tasks", method= RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
    public List<TaskRepresentation> getTasks(@RequestParam String assignee) {
        List<Task> tasks = myService.getTasks(assignee);
        List<TaskRepresentation> dtos = new ArrayList<TaskRepresentation>();
        for (Task task : tasks) {
            dtos.add(new TaskRepresentation(task.getId(), task.getName()));
        }
        return dtos;
    }

    static class TaskRepresentation {

        private String id;
        private String name;

        public TaskRepresentation(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

    }

}