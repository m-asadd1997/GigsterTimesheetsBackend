package com.example.excelProj.util;

import org.antlr.stringtemplate.StringTemplate;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.Map;

public final class Util {

    public static String populateMessageBodyByTemplate(String template, Map<String,Object> values) {
        File file = null ;
        try {
            file = ResourceUtils.getFile("classpath:"+template);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Read File Content
        StringTemplate stringTemplate = null;
        try {
            String content = new String(Files.readAllBytes(file.toPath()));
            stringTemplate = new StringTemplate(content);
            stringTemplate.setAttribute("value", values);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringTemplate.toString();
    }
}
