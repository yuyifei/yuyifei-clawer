package com.yuyifei.common;

import java.io.IOException;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class Html {
		/**
		 * @param args
		 */
		public static String getHtmlFromUrl(String strUrl)
		{
			HttpClient client = new HttpClient();
			GetMethod method = new GetMethod(strUrl);
			
			method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
											new DefaultHttpMethodRetryHandler(3, false));
		
			// Execute the method.
			int statusCode = 0;
			try {
				statusCode = client.executeMethod(method);
			} catch (HttpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (statusCode != HttpStatus.SC_OK) 
			{
				System.err.println("Method failed: " + method.getStatusLine());
			}
		
			// Read the response body.
			byte[] responseBody = null;
			try {
				responseBody = method.getResponseBody();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new String(responseBody);
		}
		
    /** 
     * 根据URL抓取网页内容 
     *  
     * @param url 
     * @return 
     */
//    public static String getHtmlFormUrl(String url) 
//    { 
//        /* 实例化一个HttpClient客户端 */
//        HttpClient client = new DefaultHttpClient(); 
//        HttpGet getHttp = new HttpGet(url); 
//    
//        String content = null; 
//    
//        HttpResponse response; 
//        try
//        { 
//            /*获得信息载体*/
//            response = client.execute(getHttp); 
//            HttpEntity entity = response.getEntity(); 
//    
//            VisitedUrlQueue.addElem(url); 
//    
//            if (entity != null) 
//            { 
//                /* 转化为文本信息 */
//                content = EntityUtils.toString(entity); 
//    
//                /* 判断是否符合下载网页源代码到本地的条件 */
//                if (FunctionUtils.isCreateFile(url) 
//                        && FunctionUtils.isHasGoalContent(content) != -1) 
//                { 
//                    FunctionUtils.createFile(FunctionUtils 
//                            .getGoalContent(content), url); 
//                } 
//            } 
//    
//        } catch (ClientProtocolException e) 
//        { 
//            e.printStackTrace(); 
//        } catch (IOException e) 
//        { 
//            e.printStackTrace(); 
//        } finally 
//        { 
//            client.getConnectionManager().shutdown(); 
//        } 
//        
//        return content; 
//    }
//    
//    /**
//	 * 根据URL获得所有的html信息
//	 * @param url
//	 * @return
//	 */
//	public static String getHtmlByUrl(String url){
//		String html = null;
//		HttpClient httpClient = new DefaultHttpClient();//创建httpClient对象
//		HttpGet httpget = new HttpGet(url);//以get方式请求该URL
//		try {
//			HttpResponse responce = httpClient.execute(httpget);//得到responce对象
//			int resStatu = responce.getStatusLine().getStatusCode();//返回码
//			if (resStatu==HttpStatus.SC_OK) {//200正常  其他就不对
//				//获得相应实体
//				HttpEntity entity = responce.getEntity();
//				if (entity!=null) {
//					html = EntityUtils.toString(entity);//获得html源代码
//				}
//			}
//		} catch (Exception e) {
//			System.out.println("访问【"+url+"】出现异常!");
//			e.printStackTrace();
//		} finally {
//			httpClient.getConnectionManager().shutdown();
//		}
//		return html;
//	}
}
