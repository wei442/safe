package com.cloud.api.safe.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 响应请求过滤 ResponseZuulFilter
 * @author wei.yong
 */
public class ResponseZuulFilter extends ZuulFilter {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 是否执行该过滤器，此处为true，说明需要过滤
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 前置过滤器
	 */
	@Override
	public String filterType() {
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
		HttpServletResponse response = context.getResponse();
		response.setContentType(MediaType.APPLICATION_JSON_UTF8.toString());
		return null;
    }

}