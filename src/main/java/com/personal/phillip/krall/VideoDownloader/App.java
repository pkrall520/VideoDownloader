package com.personal.phillip.krall.VideoDownloader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.personal.phillip.krall.VideoDownloader.dto.MessageBlock;
import com.personal.phillip.krall.VideoDownloader.youtube.thread.YoutubeThread;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, InterruptedException
    {
    	Path tmp = Files.createTempDirectory("VideoDownloader_");
		System.out.println(tmp.toString());
		File desktop = new File(System.getProperty("user.home") + "/Desktop");
		ConcurrentLinkedQueue<MessageBlock> queue = new ConcurrentLinkedQueue<MessageBlock>();
    	MessageBlock video = new MessageBlock();
    	video.setUrl("https://www.youtube.com/watch?v=l69CUx5-sYQ");
    	video.setVideoName("rudolph the red nosed reindeer");
    	video.setTempFolder(tmp.toFile());
    	video.setTargetFolder(desktop);
    	queue.add(video);
        YoutubeThread thread = new YoutubeThread();
        thread.setQueue(queue);
        
        new Thread(thread).start();

        Thread.sleep(1000);
        boolean done = false;
        while(!done) {
        	for(MessageBlock v : queue) {
        		if(v.isDone()) {
        			done = true;
        		}
        	}
        }
        Files.delete(tmp);
        System.out.println("Done!!");
    }
}
