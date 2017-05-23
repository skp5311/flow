package com.op.flow.manage.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GDAPIUtil {

	public static void main(String[] args) {
		ArrayList<String> poiList = new ArrayList<String>();
		poiList.add("116.310003,39.991957");
		poiList.add("116.46644,39.95905");
		HashMap<String, String> temp = regeo(poiList);
		System.out.println("temp=" + temp);

	}

	public static HashMap<String, String> regeo(ArrayList<String> poiList) {
		HashMap<String, String> result = new HashMap<String, String>();
		for (int i = 0; i < poiList.size(); i = i + 20) {
			ArrayList<String> poiList_temp = new ArrayList<String>();
			StringBuffer sb = new StringBuffer();
			for (int j = i; j < poiList.size() && j < i + 20; j++) {
				sb.append(poiList.get(j));
				sb.append("|");
				poiList_temp.add(poiList.get(j));
			}
			try {
				CloseableHttpClient httpclient = HttpClients.createDefault();
				try {
					httpclient = HttpClients.createDefault();
					HttpPost httpPost = new HttpPost(ConfigUtil.getInstance().getStringByKey("api.GD_url", ""));
					RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(ConfigUtil.getInstance().getIntByKey("api.GD_ConnectTimeout", 50000))
							.setConnectionRequestTimeout(ConfigUtil.getInstance().getIntByKey("api.GD_RequestTimeout", 10000))
							.setSocketTimeout(ConfigUtil.getInstance().getIntByKey("api.GD_SocketTimeout", 100000)).build();
					httpPost.setConfig(requestConfig);
					List<NameValuePair> nvps = new ArrayList<NameValuePair>();
					nvps.add(new BasicNameValuePair("key", ConfigUtil.getInstance().getStringByKey("api.GD_key", "")));
					nvps.add(new BasicNameValuePair("radius", ConfigUtil.getInstance().getStringByKey("api.GD_radius", "")));
					nvps.add(new BasicNameValuePair("extensions", ConfigUtil.getInstance().getStringByKey("api.GD_extensions", "")));
					nvps.add(new BasicNameValuePair("batch", "true"));
					nvps.add(new BasicNameValuePair("location", sb.toString()));
					httpPost.setEntity(new UrlEncodedFormEntity(nvps));
					CloseableHttpResponse response1 = httpclient.execute(httpPost);
					try {
						String strResult = EntityUtils.toString(response1.getEntity());
						System.out.println("strResult=" + strResult);
						JSONObject jo = JSONObject.fromObject(strResult);
						if (jo.containsKey("regeocodes")) {
							JSONArray ja = jo.getJSONArray("regeocodes");
							for (int k = 0; k < ja.size(); k++) {
								JSONObject jo_temp = ja.getJSONObject(k);
								result.put(poiList_temp.get(k), jo_temp.getString("formatted_address"));
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
		}

		return result;
	}

}
