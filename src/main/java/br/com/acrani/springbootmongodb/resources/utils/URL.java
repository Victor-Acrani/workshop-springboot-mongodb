package br.com.acrani.springbootmongodb.resources.utils;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

    private URL(){
    }

    public static String decodeParam(String text){
        try{
            return URLDecoder.decode(text, StandardCharsets.UTF_8);
        } catch (Exception e){
            return "";
        }
    }

    public static Date stringToDate(String dateString, Date defaultDate){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));

        try{
            return simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            return defaultDate;
        }
    }
}
