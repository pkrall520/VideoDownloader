package com.personal.phillip.krall.VideoDownloader.dto;

import java.io.File;

public class MessageBlock {

	File targetFolder;
	File tempFolder;
	String videoName;
	String url;
	boolean done = false;
	
	public File getTargetFolder() {
		return targetFolder;
	}
	public void setTargetFolder(File targetFolder) {
		this.targetFolder = targetFolder;
	}
	public File getTempFolder() {
		return tempFolder;
	}
	public void setTempFolder(File tempFolder) {
		this.tempFolder = tempFolder;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	public boolean isDone() {
		return done;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
