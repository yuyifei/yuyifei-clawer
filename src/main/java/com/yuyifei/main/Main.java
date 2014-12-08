package com.yuyifei.main;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.yuyifei.parser.BaiDuHtmlParser;
import com.yuyifei.parser.HuaweiHtmlParser;
import com.yuyifei.parser.JiFengHtmlParser;


/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
//    	String keyWord = "百度云";
    	String keyWord = "UC浏览器";
    	
    	CountDownLatch count = new CountDownLatch(3);  
    	
    	System.out.println("**************************************");
    	System.out.println("main thread starting...");  
    	System.out.println("**************************************");
    	long tStart = System.currentTimeMillis();  
    	
    	Parser[] parsers = {new HuaweiHtmlParser()
    						,new BaiDuHtmlParser()
    						,new JiFengHtmlParser()};
        Clawer[] clawers = new Clawer[10];
        for(int i = 0 ; i < 3 ; i++) 
        { 
//        	HuaweiHtmlParser huaweiHtmlParser = new HuaweiHtmlParser();
//        	clawers[i] = new Clawer(huaweiHtmlParser, keyWord); 
        	
//        	BaiDuHtmlParser baiDuHtmlParser = new BaiDuHtmlParser();
//        	clawers[i] = new Clawer(baiDuHtmlParser, keyWord);
//            
//        	JiFengHtmlParser jiFengHtmlParser = new JiFengHtmlParser();
        	
        	clawers[i] = new Clawer(count, parsers[i], keyWord);
//        	clawers[i] = new Clawer(parsers[i], keyWord);
        	new Thread(clawers[i]).start(); 
        }
        
        try {
        	//after 15 minutes(Max) the main thread run. 
			long timeout = 15;
			count.await(15, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
        long tEnd = System.currentTimeMillis();  
        System.out.println("总共用时:"+ (tEnd - tStart) + "millions"); 
        System.out.println("**************************************");
        System.out.println("The Clawer program is over!");
        System.out.println("**************************************");
        
    }
}
