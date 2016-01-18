package com.tao.sdk.core.http;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import com.alibaba.fastjson.JSONObject;
import com.tao.sdk.util.StringUtil;

public abstract class AbstractHttpProvider implements HttpProvider{
	private Logger logger = LoggerFactory.getLogger(AbstractHttpProvider.class);
	protected static final String CHARSET = "UTF-8";
	protected  abstract HttpClient getHttpClient();
	@Override
	public JSONObject post(String url) {
		return post(url, null, new HashMap<String, String>());
	}

	@Override
	public JSONObject post(String url, Map<String, String> paramters) {
		return post(url, null, paramters);
	}

	@Override
	public JSONObject post(String url, Map<String, String> headers,
			Map<String, String> paramters) {
		JSONObject result = new JSONObject();
		try {
			// 创建POST请求
			HttpPost request = new HttpPost(url);
			addHeaders(headers, request);
			// 编码参数
			List<NameValuePair> formparams = new ArrayList<NameValuePair>(); // 请求参数
			if (paramters != null) {
				for (String key : paramters.keySet()) {
					String value = paramters.get(key);
					BasicNameValuePair param = new BasicNameValuePair(key,
							value);
					formparams.add(param);
				}
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams,
					CHARSET);
			request.setEntity(entity);
			HttpResponse response = executeRequest(request);
			parseResponse(result, response);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}
	private void addHeaders(Map<String, String> headers, HttpPost request) {
		if (headers != null) {
			for (String key : headers.keySet()) {
				String value = headers.get(key);
				Header header = new BasicHeader(key, value);
				request.addHeader(header);
			}
		}
	}
	private HttpResponse executeRequest(HttpPost request) throws IOException,
			ClientProtocolException {
		HttpClient client = getHttpClient();
		HttpResponse response = client.execute(request);
		return response;
	}
	private void parseResponse(JSONObject result, HttpResponse response) {
		if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
			result = null;
			return ;
		}
		Header[] responseHeaders = response.getAllHeaders();
		JSONObject headerJson = new JSONObject();
		if (responseHeaders != null) {
			for (Header h : responseHeaders) {
				headerJson.put(h.getName(), h.getValue());
			}
		}
		result.put("header", headerJson);
		String bodyStr ="";
		try {
			HttpEntity resEntity = response.getEntity();
			bodyStr = EntityUtils.toString(resEntity, CHARSET);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			result.put("body", bodyStr);
		}
	}

	@Override
	public JSONObject post(String url, Map<String, String> headers,
			JSONObject jsonObject) {
		return post(url, headers,
				jsonObject == null ? "" : jsonObject.toJSONString());
	}
	@Override
	public JSONObject post(String url, Map<String, String> headers, String body) {
		logger.debug("url:"+url+";"+"parameter:"+body);
		JSONObject result = new JSONObject();
		try {
			// 编码参数
			// 创建POST请求
			HttpPost request = new HttpPost(url);
			addHeaders(headers, request);
			if (!StringUtil.isEmpty(body)) {
				StringEntity entity = new StringEntity(body, CHARSET);
				request.setEntity(entity);
			}
			HttpResponse response = executeRequest(request);
			parseResponse(result, response);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.debug("result:"+result == null ?"":result.toJSONString());
		return result;
	}
	
	@Override
	public JSONObject post(String url, Map<String, String> headers, byte[] body) {
		JSONObject result = new JSONObject();
		try {
			// 编码参数
			// 创建POST请求
			HttpPost request = new HttpPost(url);
			addHeaders(headers, request);
			if (body != null) {
				ByteArrayEntity entity = new ByteArrayEntity(body);
				request.setEntity(entity);
			}
			// 发送请求
			HttpResponse response = executeRequest(request);
			parseResponse(result, response);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return result;
	}

	@Override
	public byte[] getPicture(String url) {
		try {
			// 创建POST请求
			HttpGet request = new HttpGet(url);
			// 发送请求
			HttpClient client = getHttpClient();
			HttpResponse response = client.execute(request);
			if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
				return null;
			}
			HttpEntity resEntity = response.getEntity();
			return (resEntity == null) ? null : EntityUtils
					.toByteArray(resEntity);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	@Override
	public boolean verificationResponse(String url) {
		try {
	        HttpGet request = new HttpGet(url);
	        HttpClient client = getHttpClient();
			HttpResponse response = client.execute(request);
			if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				return true;
			}
		} catch (Exception e) {
		}
		return false;
	}
	
}
