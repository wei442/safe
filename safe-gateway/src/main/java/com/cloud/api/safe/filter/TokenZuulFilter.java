package com.cloud.api.safe.filter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.CommConstants;
import com.cloud.common.constants.ZuulConstants;
import com.cloud.common.enums.ResultEnum;
import com.cloud.common.enums.safe.RetSafeResultEnum;
import com.cloud.common.util.IpUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * tokenZuul请求过滤 TokenZuulFilter
 * @author wei.yong
 */
public class TokenZuulFilter extends ZuulFilter {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProxyRequestHelper helper;

	//不需要拦截的url map
	private Map<String, Object> ignoreUriMap;

	//不做拦截的url
	@Value("${security.ignore.uri}")
	private String ignoreUri;

	/**
	 * 是否执行该过滤器，此处为true，说明需要过滤
	 */
	@Override
	public boolean shouldFilter() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		String requestURI = helper.buildZuulRequestURI(request);
		String ip = IpUtil.getIpAddr(request);
		logger.info("【tokenZuul请求过滤】(TokenZuulFilter-shouldFilter)-请求uri, 请求ip:{}, requestURI:{}", ip, requestURI);
		//设置api网关请求到消费者(consumer)header里面
	    context.addZuulRequestHeader(ZuulConstants.API_GATEWAY, ZuulConstants.API_GATEWAY_SAFE_ADMIN);
	    //如果是不需要校验jwt的URI资源，如果是以/third开头，不要过滤
		if(null != MapUtils.getObject(ignoreUriMap, requestURI)) {
			return false;
		}
		return true;
	}

	/**
	 * 前置过滤器
	 */
	@Override
	public String filterType() {
		init();
		return "pre";
	}

	/**
	 *
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
    public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();

		String token = request.getHeader(CommConstants.TOKEN);
//		logger.info("【tokenZuul请求过滤】(TokenZuulFilter-run)-token请求过滤-请求URI, token:{}", token);
		if(StringUtils.isBlank(token)) {
	    	String respStr = this.addRetMsg(RetSafeResultEnum.TOKEN_NULL_ERROR);
	    	logger.info("【tokenZuul请求过滤】(TokenZuulFilter-run)-header的token为空, respStr:{}", respStr);
	    	context.setResponseBody(respStr);
	    	context.setSendZuulResponse(false);
	    	return null;
	    }

		return null;
    }

	/**
	 *初始化
	 */
	public void init() {
		if(ignoreUriMap == null || ignoreUriMap.isEmpty()) {
			this.getIgnoreUriMap();
		}
	}

    /**
     * 设置返回信息（编码/编码信息）
     * @param retCode
     * @param retMsg
     * @return String
     */
    public String addRetMsg(ResultEnum enums) {
		JSONObject json = new JSONObject();
    	json.put(CommConstants.RET_CODE, enums.getCode());
    	json.put(CommConstants.RET_MSG, enums.getMsg());
    	return json.toJSONString();
    }

	/**
	 * 获得不需要拦截的url
	 */
	public void getIgnoreUriMap() {
		this.ignoreUriMap = new ConcurrentHashMap<String, Object>();
		String[] excludePaths = StringUtils.split(ignoreUri, ",");
		if(excludePaths != null && excludePaths.length >0) {
			for (String igUri : excludePaths) {
				if(StringUtils.isNotBlank(igUri)) {
					ignoreUriMap.put(igUri.trim(), igUri.trim());
				}
			}
		}
	}

}