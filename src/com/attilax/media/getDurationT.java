package com.attilax.media;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.media.Manager;
import javax.media.NoDataSourceException;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.Time;

public class getDurationT {

	public static void main(String[] args) throws NoDataSourceException, IOException, NoPlayerException {
		String s="d:\\t2.mp4";
		javax.media.protocol.DataSource source;

		URL url = new File(s).toURL();
		source = Manager.createDataSource(url);
		Time a =source.getDuration();
		System.out.println(a.getSeconds());
		System.out.println("--");
		Player player = Manager.createPlayer(url);  
		System.out.println(player.getDuration().getSeconds());

	}

}
