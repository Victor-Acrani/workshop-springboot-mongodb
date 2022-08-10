package br.com.acrani.springbootmongodb.resources.utils;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

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
}
