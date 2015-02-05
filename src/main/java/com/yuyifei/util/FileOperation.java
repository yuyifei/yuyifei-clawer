package com.yuyifei.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

import com.yuyifei.common.Common;

public class FileOperation {
	public static void downloadFromUrl(String marketName, String keyWord, String fileName, String url)
	{
			URL httpurl = null;
			try {
				System.out.println("yuyifei:" + url);
				//httpurl = new URL("http://gdown.baidu.com/data/wisegame/34c22e79d212844d/baiduyunjishiben.apk");
				httpurl = new URL(url);
			} catch (MalformedURLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//creat dir
			File file1 = new File(Common.getApkDir() + keyWord + "/" + marketName);
			file1.mkdirs();
			
			//download it 
			File file2 = new File(Common.getApkDir() + keyWord + "/" + marketName + "/" + fileName);
			try {
				FileUtils.copyURLToFile(httpurl, file2);
				System.out.println(fileName + ":" + "Download compelete!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
