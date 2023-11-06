package com.prashanth.utils;

public class CommonUtils {
    public static boolean isNullOrEmpty(Object... objects){
        for(Object o :objects){
            if(o==null || o ==""){
                return true;
            }
        }
        return false;
    }
    public static boolean isNotNullOrEmpty(Object... objects){
        for(Object o :objects){
            if(o==null || o ==""){
                return false;
            }
        }
        return true;
    }
}
