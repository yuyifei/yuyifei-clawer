package com.yuyifei.main;

import java.util.concurrent.CountDownLatch;

public class Clawer implements Runnable 
{ 
    private Parser parser = null;
	private String keyWord = null;
	private CountDownLatch count;
	
	public Clawer(CountDownLatch cnt, Parser par, String key) {
		parser = par;
		keyWord = key;
		count = cnt;
	}
	
//	public Clawer(Parser par, String key) {
//		parser = par;
//		keyWord = key;
//	}

	/** 
     * 下载对应页面并分析出页面对应的URL放在未访问队列中。 
     * @param parser 
     */
    public void clawering(Parser parser, String keyWord) 
    {
    	parser.parserHtml(keyWord);
    	
    	this.count.countDown(); 
    } 
             
    public void run() 
    { 
    	clawering(parser, keyWord); 
    } 
}
