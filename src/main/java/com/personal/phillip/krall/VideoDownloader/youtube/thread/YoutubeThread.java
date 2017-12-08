package com.personal.phillip.krall.VideoDownloader.youtube.thread;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.personal.phillip.krall.VideoDownloader.dto.MessageBlock;
import com.personal.phillip.krall.VideoDownloader.util.Logger;
import com.personal.phillip.krall.VideoDownloader.youtube.service.YoutubeService;

public class YoutubeThread implements Runnable {

	private ConcurrentLinkedQueue<MessageBlock> queue;

	public void setQueue(ConcurrentLinkedQueue<MessageBlock> queue) {
		this.queue = queue;
	}

	public void run() {
		
		MessageBlock video = null;
		try {
			video = this.queue.poll();
			Logger log = new Logger(video.getVideoName());
			log.startDownload(video.getUrl());
			YoutubeService service = new YoutubeService(new URL(video.getUrl()), video.getTempFolder());
			service.download();
			System.out.println(service.getTempFileName());
			log.endDownload();
			Path tmp = Paths.get(service.getTempFileName());
			System.out.println(video.getTargetFolder().getAbsolutePath() + "\\" + video.getVideoName() + service.getContentType());
			Path dest = Paths.get(video.getTargetFolder().getAbsolutePath() + "\\" + video.getVideoName() + service.getContentType());
			Files.move(tmp, dest);
		
			
			video.setDone(true);
			this.queue.add(video);

		} catch (Exception err) {
			err.printStackTrace();
			System.err.println("Error on " );
			System.err.println("Failed: " + err.getMessage());
		}

	}

}
