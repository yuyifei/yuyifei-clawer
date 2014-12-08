package com.yuyifei.parser;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.yuyifei.common.Common;
import com.yuyifei.common.Html;
import com.yuyifei.main.Parser;
import com.yuyifei.util.FileOperation;

public class BaiDuHtmlParser extends Parser{
	
	public static String getDownloadUrl(String newUrl)
	{
    	System.out.println("****************************");
    	System.out.println("BaiDuHtmlParserBaiDuHtmlParser");
    	System.out.println("****************************");
		String downloadUrl = null;
		
		String html = Html.getHtmlFromUrl(newUrl);
		//System.out.println(html);
		
		Document doc = Jsoup.parse(html);
		Elements divs = doc.select("div.area-download");
		
		//System.out.println("divs_size:" + divs.size());
		
		//System.out.println(divs.first().select("a").first().attr("data_url"));
		
		downloadUrl = divs.first().select("a").first().attr("data_url");
		
		return downloadUrl;
	}

	@Override
	public void parserHtml(String keyWord) {
		int num = 0;
		String url = null;
		try {
			url = Common.getBaiduMarketUrl() 
					+ URLEncoder.encode(keyWord, "utf-8") + "&data_type=app&f=header_app%40input&from=as";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(url);
		String html = Html.getHtmlFromUrl(url);
//		System.out.println(html);
		
    	Document doc = Jsoup.parse(html);
    	Elements lis =  doc.select("ul.app-list  > li.app-outer");  	
    	System.out.println("size:" + lis.size());
    	
    	for (Element li : lis)
    	{
    		Elements as = li.select("a.apk");
    		//System.out.println("div_size:" + as.size());
    		//System.out.println(as.first().attr("data_name"));
    		
    		String title = as.first().attr("data_name");
    		
    		if (title.contains(keyWord))
    		{
    			//System.out.println(li.select("div.icon").first().select("a").first().attr("href"));
    			String href = li.select("div.icon").first().select("a").first().attr("href");
    			String newUrl = "http://shouji.baidu.com/" + href;
    			System.out.println(newUrl);
    			//System.out.println(li.select("a.app_name").attr("href"));
    			//Elements app_as = li.select("div.icon");
    			//System.out.println("app_as_size:" + app_as.size());
    			
    			String downloadUrl = getDownloadUrl(newUrl);
    			
    			title = title.replace("/", "_");
    			FileOperation.downloadFromUrl(Common.getBaiDuMarketName(), 
    					keyWord, title + "_" + num + ".apk", downloadUrl);
    			++num;
    		}
    	}
	}
}
