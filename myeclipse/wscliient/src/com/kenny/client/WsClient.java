package com.kenny.client;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;



public class WsClient {
     
	public void post(String mobileCode,String userID) throws Exception{
		//URI uri=new URI("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo HTTP/1.1");
		//HttpClient httpClient=new HttpClient(url, mobileCode, code);
	   HttpClient httpClient =new HttpClient();
	   PostMethod postMethod=new PostMethod("http://ws.webxml.com.cn/WebServices/MobileCodeWS.asmx/getMobileCodeInfo");
	   postMethod.setParameter("mobileCode", mobileCode);
	   postMethod.setParameter("userID", userID);
	   
	   int code=httpClient.executeMethod(postMethod);
	   String result=postMethod.getResponseBodyAsString();
	   System.out.println("Post请求的结果"+result);
	}
	/**
	 * 
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		new WsClient().post("15626217879", "");
	}

}