/**
 * 
 */
package com.ivan.she.stu.utils;

import java.util.Arrays;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
/**
 * @author shezhigao
 *
 */
public class HttpUtils {
	
	private HttpUtils(){}
	
	private static PoolingHttpClientConnectionManager connMgr;  
    private static RequestConfig requestConfig;
	private static final int MAX_READ_TIMEOUT = 50000000;
	private static final int MAX_CONNECTION_TIMEOUT = 5000;
	private static final int MAX_FROM_POOL_TIMEOUT = 1500;
	private static final int MAX_SIZE = 10;
	private static final int MAX_PER_ROUTE_SIZE = 2;
	static{
		// 设置连接池  
        connMgr = new PoolingHttpClientConnectionManager();  
        // 设置连接池大小  
        connMgr.setMaxTotal(MAX_SIZE);  
        connMgr.setDefaultMaxPerRoute(MAX_PER_ROUTE_SIZE);  
  
        RequestConfig.Builder configBuilder = RequestConfig.custom();  
        // 设置连接超时  
        configBuilder.setConnectTimeout(MAX_CONNECTION_TIMEOUT);  
        // 设置读取超时  
        configBuilder.setSocketTimeout(MAX_READ_TIMEOUT);  
        // 待执行线程的等待超时时间 
        configBuilder.setConnectionRequestTimeout(MAX_FROM_POOL_TIMEOUT);  
        requestConfig = configBuilder.build();
	}
	
	public static CloseableHttpClient getCloseableHttpClient(){
		return HttpClients.custom()
                .setConnectionManager(connMgr)
                .build();
	}
	
	public static RequestConfig getRequestConfig(){
		return requestConfig;
	}
	
	public static String executePostJson(String uri, String requestBody){
		return executePost(uri, requestBody, "application/json");
	}
	
	public static String executePost(String uri, String requestBody, String contentType){
		HttpPost httpPost = new HttpPost(uri);
		httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/37.0.2062.102 Safari/537.36");
		if(contentType != null){
			httpPost.addHeader("Content-Type", contentType);
		}
		
		httpPost.setConfig(getRequestConfig());
		CloseableHttpResponse response = null;
		try {
			HttpEntity entity = new StringEntity(requestBody, "utf-8");
			httpPost.setEntity(entity);
			response = getCloseableHttpClient().execute(httpPost);
		    int statusCode = response.getStatusLine().getStatusCode();
		    if(statusCode == 200){
		    	HttpEntity respEntity = response.getEntity();
		    	String str = EntityUtils.toString(respEntity);
		    	System.out.println(str);
		    	return str;
		    }
		}catch(Exception e){
		} finally {
			if(response != null){
				try {
					response.close();
				} catch (Exception e) {
				}
			}
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
