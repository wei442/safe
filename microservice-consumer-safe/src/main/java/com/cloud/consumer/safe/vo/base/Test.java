package com.cloud.consumer.safe.vo.base;

import com.cloud.common.constants.safe.RetSafeConstants;
import com.cloud.consumer.safe.base.BaseRestMapResponse;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		BasePageResultVo result = new BasePageResultVo();
		BaseRestMapResponse enterpriseResponse = new BaseRestMapResponse();
		enterpriseResponse.put(RetSafeConstants.RESULT, result);
//		JSONObject.toJSON(enterpriseResponse, SerializerFeature.WriteMapNullValue);

//		 String str = JSON.toJSONString(enterpriseResponse,SerializerFeature.WriteMapNullValue);
		System.out.println(result);
		System.out.println(enterpriseResponse);
	}

}
