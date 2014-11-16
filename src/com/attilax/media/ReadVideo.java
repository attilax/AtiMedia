package com.attilax.media;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncoderException;
import it.sauronsoftware.jave.InputFormatException;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;
import java.text.ParseException;
import java.util.Date;

public class ReadVideo {

    public static void main(String[] args) throws InputFormatException, EncoderException, ParseException{
        String f = "E:\\������Ƶ\\R41.avi";
       f="d:\\t.mp4";
     //  f="d:\\t.avi";
       f="d:\\t.vob";
       f="d:\\t.rmvb";
       f="d:\\t.rm";    f="d:\\t.mov";
		File source = new File(f);
        Encoder encoder = new Encoder();
       
             MultimediaInfo m = encoder.getInfo(source);
             long ls = m.getDuration();//millSecs
             ls=ls/1000;
             System.out.println(ls);
             System.out.println(secs2str(ls) );
        //     System.out.println("����Ƶʱ��Ϊ:"+ls/60000+"��"+(ls`000)/1000+"�룡");
       
    }
    
    
    private static String secs2str(long sec)  {

    	 String date="2014-01-01";

    	Date start= DateUtil.fmtStrToDate(date+" 00:00:00", DateUtil.YYYY_MM_DD_HH_MM_SS); 

    	long endTimestamp = sec*1000+start.getTime();

    	Date end=new Date(endTimestamp);

    	String s=DateUtil.fmtDateToStr( end, DateUtil.YYYY_MM_DD_HH_MM_SS);

    	String[] sa=s.split(" ");

    	return sa[1];

    	}
}