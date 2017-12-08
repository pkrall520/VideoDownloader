package com.personal.phillip.krall.VideoDownloader.util;

public class Logger {
	private long start;
	private String name;
	
	public Logger(String name) {
		this.name = name;
	}
	
	public void startDownload(String url) {
		this.start = System.currentTimeMillis();
		System.out.println("Starting to download: " + this.name + " at " + url);
	}
	
	public void endDownload() {
		Long end = System.currentTimeMillis();
		long milliseconds = end - this.start;
		int seconds = (int) ((milliseconds / 1000) % 60);
		int minutes = (int) ((milliseconds / 1000) / 60);
		System.out.println("Finished downloading: " + this.name);
		System.out.println("Took: " + minutes + "min " + seconds + "sec");
	}
}
