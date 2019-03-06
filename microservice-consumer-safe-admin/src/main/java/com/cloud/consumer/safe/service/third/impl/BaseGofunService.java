package com.cloud.consumer.safe.service.third.impl;

import java.util.Date;
import java.util.Objects;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ochain.common.util.UUIDUtil;

/**
 * 基础超类 Service，其他Service需要继承
 * @author wei.yong
 */
@Service
public class BaseGofunService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//rest模板
	@Autowired
	protected RestTemplate simpleRestTemplate;

	//gofun访问地址
	@Value("${gofun.url}")
	protected String gofunUrl;

	//gofun appId
	@Value("${gofun.appId}")
	protected String gofunAppId;

	//gofun secret
	@Value("${gofun.secret}")
	protected String gofunSecret;

	/**
	 * gofun header
	 * @return HttpHeaders
	 */
	protected HttpHeaders getGofunHeaders() {
		String currentDate = Objects.toString(new Date().getTime());
		String businessKey = UUIDUtil.INSTANCE.getUUID();
		StringBuffer sb = new StringBuffer();
		sb.append(this.gofunAppId);
		sb.append(this.gofunSecret);
		sb.append(currentDate);
		sb.append(businessKey);
		String accessKey = DigestUtils.sha512Hex(sb.toString());

    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    	headers.add("appId", this.gofunAppId);
    	headers.add("secret", this.gofunSecret);
    	headers.add("currentDate", currentDate);
    	headers.add("businessKey", businessKey);
    	headers.add("accessKey", accessKey);
		return headers;
    }

}