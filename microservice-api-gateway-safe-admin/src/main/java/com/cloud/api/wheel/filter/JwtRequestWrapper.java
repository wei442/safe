package com.cloud.api.wheel.filter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * jwt请求捕捉 JwtRequestWrapper
 * @author wei.yong
 */
public class JwtRequestWrapper extends HttpServletRequestWrapper {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	private HttpServletRequest request;

	private String jwt = null;

	//JWT变量
	private static final String JWT = "jwt";

    public JwtRequestWrapper(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

    @Override
    public ServletInputStream getInputStream() {
		if(StringUtils.isBlank(jwt)) {
			jwt = this.getJwt();
		}
		String[] datas = StringUtils.split(jwt, ".");
	//	String header = null;
		String payload = null;
	//	String signature = null;
		try {
	//		header = datas[0];
			payload = datas[1];
	//		signature = datas[2];
		} catch (Exception e) {
			logger.error("【jwt请求捕捉】(JwtRequestWrapper-getInputStream)-jwt数组转换异常, Exception = {}, message = {}", e, e.getMessage());
		}

		String payloadStr = new String(Base64.decodeBase64(payload), StandardCharsets.UTF_8);
		if(logger.isInfoEnabled())logger.info("【jwt请求捕捉】(JwtRequestWrapper-getInputStream)-返回paylod结果, payloadStr:{}", payloadStr);

		final ByteArrayInputStream bais = new ByteArrayInputStream(payloadStr.getBytes(StandardCharsets.UTF_8));
        ServletInputStream servletInputStream = new ServletInputStream() {
            @Override
            public int read() throws IOException {
                return bais.read();
            }

			@Override
			public boolean isFinished() {
				return false;
			}

			@Override
			public boolean isReady() {
				return false;
			}

			@Override
			public void setReadListener(ReadListener listener) {
			}
        };
        return servletInputStream;
    }

    /**
     * 获取jwt
     * @return String
     */
    public String getJwt() {
    	String body = null;
    	ServletInputStream stream = null;
    	try {
    		stream = request.getInputStream();
    		body = IOUtils.toString(stream, StandardCharsets.UTF_8);
    		if(logger.isInfoEnabled())logger.info("【jwt请求捕捉】(JwtRequestWrapper-getJwt)-获取body, body:{}", body);
    	} catch (IOException e) {
    		logger.error("【jwt请求捕捉】(JwtRequestWrapper-getJwt)-获取body-通过请求输入流转换body异常, Exception = {}, message = {}", e, e.getMessage());
    	}

    	JSONObject bodyJson = null;
    	try {
    		bodyJson = JSONObject.parseObject(body);
    	} catch (Exception e) {
    		logger.error("【jwt请求捕捉】(JwtRequestWrapper-getJwt)-获取body-请求body参数非json格式, 解析异常, Exception = {}, message = {}", e, e.getMessage());
    	}
    	if(bodyJson != null && !bodyJson.isEmpty()) {
    		jwt = Objects.toString(bodyJson.get(JWT), "");
    	}
    	if(logger.isInfoEnabled())logger.info("【jwt请求捕捉】(JwtRequestWrapper-getJwt)-获取jwt, jwt:{}", jwt);
    	return jwt;
    }

}