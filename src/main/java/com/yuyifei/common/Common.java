package com.yuyifei.common;

public class Common {
	
	//Market url
	private static String HuaWeiMarketUrl = "http://appstore.huawei.com/search/";
	private static String BaiduMarketUrl  = "http://shouji.baidu.com/s?wd=";
	private static String JiFengMarketUrl = "http://apk.gfan.com/search?q=";
	
	//Market Name
	private static String huaWeiMarketName = "HuaWeiMarket";
	private static String baiDuMarketName = "BaiDuMarket";
	private static String jiFengMarketName = "JiFengMarket";
	
	//store Apk location
	private static String apkDir = "/home/yuyifei/Downloads/Apk/";
	
	//page count
	private int pageCount = 10;


	public static String getApkDir() {
		return apkDir;
	}

	public static void setApkDir(String apkDir) {
		Common.apkDir = apkDir;
	}

	public static String getHuaWeiMarketUrl() {
		return HuaWeiMarketUrl;
	}

	public static void setHuaWeiMarketUrl(String huaWeiMarket) {
		HuaWeiMarketUrl = huaWeiMarket;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public static String getHuaWeiMarketName() {
		return huaWeiMarketName;
	}

	public static void setHuaWeiMarketName(String huaWeiMarketName) {
		Common.huaWeiMarketName = huaWeiMarketName;
	}

	public static String getBaiduMarketUrl() {
		return BaiduMarketUrl;
	}

	public static void setBaiduMarketUrl(String baiduMarketUrl) {
		BaiduMarketUrl = baiduMarketUrl;
	}

	public static String getJiFengMarketUrl() {
		return JiFengMarketUrl;
	}

	public static void setJiFengMarketUrl(String jiFengMarketUrl) {
		JiFengMarketUrl = jiFengMarketUrl;
	}

	public static String getJiFengMarketName() {
		return jiFengMarketName;
	}

	public static void setJiFengMarketName(String jiFengMarketName) {
		Common.jiFengMarketName = jiFengMarketName;
	}

	public static String getBaiDuMarketName() {
		return baiDuMarketName;
	}

	public static void setBaiDuMarketName(String baiDuMarketName) {
		Common.baiDuMarketName = baiDuMarketName;
	}
}
