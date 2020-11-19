package com.ibm.springboot.util;

import org.springframework.util.Base64Utils;

import java.util.Arrays;

public class Base64Util {

    public static String encode(String string){

        return Arrays.toString(Base64Utils.encode(string.getBytes()));

    }

    public static String decode(String string){

        return Arrays.toString(Base64Utils.decode(string.getBytes()));

    }
}
