package com.op.flow.manage.util;

import java.util.ArrayList;
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



public class BDAPIUtil {

	//private static String api_idm = "http://10.27.239.72:8080/idm/getIdm";
	//private static String api_idm = "http://10.252.83.250:8080/idm/getIdm";
	private static String api_idm = ConfigUtil.getInstance().getStringByKey("api.BD_idm", "");//"http://120.26.126.54:8080/idm/getIdm";
	
	//private static String api_track = "http://10.27.239.72:8080/idm/getTrack";
	//private static String api_track = "http://10.252.83.250:8080/idm/getTrack";
	private static String api_track = ConfigUtil.getInstance().getStringByKey("api.BD_track", "");//"http://120.26.126.54:8080/track/getTrack";
	
	public static String getIDM(String queryType,String queryValue)
	{
		String result = "";
		try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            try {
                httpclient = HttpClients.createDefault();
                HttpPost httpPost = new HttpPost(api_idm);
                RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(1000)
                        .setSocketTimeout(100000).build();
                httpPost.setConfig(requestConfig);
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                nvps.add(new BasicNameValuePair("queryType", queryType));
                nvps.add(new BasicNameValuePair("queryValue", queryValue));
                httpPost.setEntity(new UrlEncodedFormEntity(nvps));
                CloseableHttpResponse response1 = httpclient.execute(httpPost);
                try {
                    result = EntityUtils.toString(response1.getEntity());

                } finally {
                    response1.close();
                }
            } finally {
                httpclient.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }	
		return result;
	}
	
	public static String getTrack(String queryType,String queryValue)
	{
		String result = "";
		try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            try {
                httpclient = HttpClients.createDefault();
                HttpPost httpPost = new HttpPost(api_track);
                RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000).setConnectionRequestTimeout(1000)
                        .setSocketTimeout(100000).build();
                httpPost.setConfig(requestConfig);
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                nvps.add(new BasicNameValuePair("queryType", queryType));
                nvps.add(new BasicNameValuePair("queryValue", queryValue));
                httpPost.setEntity(new UrlEncodedFormEntity(nvps));
                CloseableHttpResponse response1 = httpclient.execute(httpPost);
                try {
                    result = EntityUtils.toString(response1.getEntity());

                } finally {
                    response1.close();
                }
            } finally {
                httpclient.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }	
		return result;
	}
}
