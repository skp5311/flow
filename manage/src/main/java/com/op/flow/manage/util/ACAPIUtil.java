package com.op.flow.manage.util;

import net.sf.json.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ACAPIUtil {
	public static String ac_prefix = ConfigUtil.getInstance().getStringByKey("api.AC_prefix", "");
	public static String appId = ConfigUtil.getInstance().getStringByKey("api.AC_appId", "");
	public static String accessToken = ConfigUtil.getInstance().getStringByKey("api.AC_accessToken", "");
	public static String customerId = ConfigUtil.getInstance().getStringByKey("api.AC_customerId", "");

	public static ArrayList<String> queryMacListByApSerails(String[] deviceNos) {
		System.out.println("ac_prefix:" + ac_prefix);
		System.out.println("queryMacListByApSerails begin:" + System.currentTimeMillis());
		ArrayList<String> result = new ArrayList<String>();
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			try {
				StringBuffer sb = new StringBuffer();
				for (String deviceNo : deviceNos) {
					sb.append(deviceNo);
					sb.append(",");
				}
				sb.append("-1");
				httpclient = HttpClients.createDefault();
				HttpPost httpPost = new HttpPost(ac_prefix + "/scandevice/queryMacListByApSerails");
				RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
						.setConnectionRequestTimeout(1000).setSocketTimeout(100000).build();
				httpPost.setConfig(requestConfig);
				List<NameValuePair> nvps = new ArrayList<NameValuePair>();
				nvps.add(new BasicNameValuePair("customerId", customerId));
				nvps.add(new BasicNameValuePair("apSerials", sb.toString()));
				nvps.add(new BasicNameValuePair("appId", appId));
				nvps.add(new BasicNameValuePair("accessToken", accessToken));
				httpPost.setEntity(new UrlEncodedFormEntity(nvps));
				CloseableHttpResponse response1 = httpclient.execute(httpPost);
				try {
					String responseStr = EntityUtils.toString(response1.getEntity());
					JSONObject jo = JSONObject.fromObject(responseStr);
					if (jo.get("status").toString().equals("200") && jo.containsKey("data")) {
						JSONObject jsonObject = jo.getJSONObject("data");
						Object[] keys = jsonObject.keySet().toArray();
						for (int i = 0; i < keys.length; i ++) {
							JSONObject jobj = jsonObject.getJSONObject(String.valueOf(keys[i]));
							Iterator<String> iter = jobj.keys();
							while(iter.hasNext()) {
								String mac = iter.next();
								if(!result.contains(mac)) {
									result.add(mac);
								}
							}
						}
					}
				} finally {
					response1.close();
				}
			} finally {
				httpclient.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("queryMacListByApSerails end:" + System.currentTimeMillis());
		return result;

	}
}
