package com.yuyifei.parser;

import java.io.IOException;
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

public class JiFengHtmlParser extends Parser
{

	public static String getDownloadUrl(String newUrl)
	{
    	System.out.println("****************************");
    	System.out.println("JiFengHtmlParserJiFengHtmlParser");
    	System.out.println("****************************");
    	
		String downloadUrl = null;
		
		String html = Html.getHtmlFromUrl(newUrl);
		
		Document doc = Jsoup.parse(html);
		Element a = doc.getElementById("computerLoad");
		//System.out.println(a.attr("href"));
		downloadUrl = a.attr("href");
		
		return downloadUrl;
	}
	@Override
	public void parserHtml(String keyWord) {
		int num = 0;
		String url = null;
		try {
			url = Common.getJiFengMarketUrl() + URLEncoder.encode(keyWord, "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(url);
		String html = Html.getHtmlFromUrl(url);
		//System.out.println(html);
		
		Document doc = Jsoup.parse(html);
		Elements lis = doc.select("ul.lp-app-list").first().select("li");
		System.out.println("uls_size:" + lis.size());
		
		for (Element li : lis)
		{
			Elements spans = li.select("span.apphot-tit");
			Elements as = li.select("span.apphot-tit").first().select("a");
			String title = as.first().text();
			if (title.contains(keyWord))
			{
//				System.out.println(li.select("span.apphot-tit")
//						.first().select("a").first().attr("href"));
				String newUrl = "http://apk.gfan.com/"
						+li.select("span.apphot-tit")
						.first().select("a").first().attr("href");
				String downloadUrl = getDownloadUrl(newUrl);
				
				title = title.replace("/", "_");
				System.out.println("yuyfei" +  title);
				
    			FileOperation.downloadFromUrl(Common.getJiFengMarketName(), 
    					keyWord, title + "_" + num + ".apk", downloadUrl);
    			++num;
			}
		}
	}
	
}
