package com.cloud.common.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: AjaxUtils
 * @Description: ajax 返回信息处理类
 * @author wei.yong
 * @date 2014年5月9日 上午9:58:12
 */
public class AjaxUtil {

	protected final static Logger logger = LoggerFactory.getLogger(AjaxUtil.class);

	private final static String APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";

    /**
     * Ajax打印通用方法
     * @param response
     * @param message
     */
	public static void printByWriter(HttpServletResponse response, String message) {
		response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
		response.setContentType(APPLICATION_JSON_UTF8_VALUE);
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.write(message);
			pw.flush();
		} catch (IOException e) {
			logger.error("(AjaxUtil-printByWriter)-Ajax打印字符, Exception = {}, message = {}", e, e.getMessage());
		} finally {
			if(pw != null) {
				pw.close();
			}
		}
	}

	/**
	 * Ajax打印输出流
	 * @param response
	 * @param contentType
	 * @param data
	 */
	public static void printByOutputStream(HttpServletResponse response, String contentType,byte[] data) {
		response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
		response.setContentType(contentType);
		response.setHeader("Cache-Control", "no-cache");
		OutputStream os = null;
		try {
			os = response.getOutputStream();
			os.write(data);
			os.flush();
		} catch (IOException e) {
			logger.error("(AjaxUtil-printByOutputStream)-Ajax打印输出流, Exception = {}, message = {}", e, e.getMessage());
		} finally {
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}