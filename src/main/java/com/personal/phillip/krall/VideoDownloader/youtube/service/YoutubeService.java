package com.personal.phillip.krall.VideoDownloader.youtube.service;

import java.io.File;
import java.net.URL;

import com.github.axet.vget.VGet;
import com.github.axet.vget.info.VideoInfo;

public class YoutubeService {
	
	private VGet downloader;
	private VideoInfo info;
	
	public YoutubeService(URL url, File saveLocation) {
		downloader = new VGet(url, saveLocation);
		downloader.extract();
		info = downloader.getVideo();
//		info.getInfo().get(0).getContentType()
//		info.getInfo().get(0).getContentType()
//		 try {
//            VGet v = new VGet(url, saveLocation);
//            System.out.println("Starting to download");
//            v.download();
//        } catch (Exception e) {
//        	e.printStackTrace();
//        	System.out.println("Error");
//            throw new RuntimeException(e);
//        }
	}
	
	public String getContentType() {
		return "." + info.getInfo().get(0).getContentType().replace("video/", "");
	}
	public String getTempFileName() {
		return info.getInfo().get(0).getTarget().toString();
	}
	
	public void download() {
		downloader.download();
		
	}
}
