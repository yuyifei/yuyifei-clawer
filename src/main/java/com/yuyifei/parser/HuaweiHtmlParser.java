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

public class HuaweiHtmlParser extends Parser {
    public void parserHtml(String keyWord)
    {
    	System.out.println("****************************");
    	System.out.println("HuaweiHtmlParserHuaweiHtmlParser");
    	System.out.println("****************************");
    	
    	String url = null;
		try {
			url = Common.getHuaWeiMarketUrl() 
					+ URLEncoder.encode(keyWord, "utf-8") 
					+ "/1";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    			
    	String html = Html.getHtmlFromUrl(url);
    	
    	//System.out.println(html);   
    	Document doc = Jsoup.parse(html);
    	Elements as =  doc.select("a.btn-blue");
    	System.out.println("div_size:" + as.size());
    	for (Element a : as)
    	{
        	String title;
        	String href;
        	String attr[];
    		String tmp = a.attr("onclick");

        	attr = tmp.split("'");
        	title = attr[3];
        	href = attr[11];
        	
        	if (title.contains(keyWord))
        	{
            	System.out.println(title);
            	System.out.println(href);
            	//download it by url we have got.
            	
            	title = title.replace("/", "_");
            	FileOperation.downloadFromUrl(Common.getHuaWeiMarketName(), keyWord, title+".apk", href);
        	}
    	}
    }
}
