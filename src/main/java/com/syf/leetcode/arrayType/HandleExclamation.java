package com.syf.leetcode.arrayType;


import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class HandleExclamation {

    private static String filePath = "D:\\代码\\new3.txt";

    private static final String EXCLAMATION = "!";

    public static void main(String[] args) throws Exception{
        String sourceString = readFile(filePath);
        JsonObject sourceJson = new JsonObject(sourceString);
        System.out.println(sourceJson);
        long begin = System.currentTimeMillis();
        processJson(sourceJson);
        long end = System.currentTimeMillis();
        System.out.println(sourceJson);
        System.out.println("Time:" + (end - begin) + "ms");
    }

    private static void processJson(JsonObject jsonObject){
        Map<String, Object> expressionMap = new HashMap<>();
        for (Map.Entry<String, Object> stringObjectEntry : jsonObject) {
            String key = stringObjectEntry.getKey();
            Object value = stringObjectEntry.getValue();
            if(key.contains(EXCLAMATION)){
                expressionMap.put(key, value);
                continue;
            }
            if(value instanceof JsonObject){
                processJson((JsonObject) value);
            } else if(value instanceof JsonArray){
                JsonArray array = (JsonArray)value;
                if(!array.isEmpty()){
                    if(array.getValue(0) instanceof JsonObject){
                        for(int i = 0; i < array.size(); i++){
                            processJson(array.getJsonObject(i));
                        }
                    }
                }
            }
        }
        if(!expressionMap.isEmpty()){
            JsonObject json = new JsonObject();
            for (Map.Entry entry : expressionMap.entrySet()){
                jsonObject.remove((String)entry.getKey());
                processDistribute(json, entry);
            }
            json.stream().forEach(entry -> {
                jsonObject.put(entry.getKey(), entry.getValue());
            });
        }
    }

    private static void processDistribute(JsonObject json, Map.Entry<String, Object> entry){
        String expression = entry.getKey();
        String[] distribute = expression.split(EXCLAMATION);
        if(distribute.length == 1){
            json.put(entry.getKey(), entry.getValue());
        } else {
            JsonObject subJson = json.getJsonObject(distribute[0]);
            if(subJson == null){
                subJson = new JsonObject();
                json.put(distribute[0], subJson);
            }
            Map.Entry subEntry = new Map.Entry() {
                @Override
                public Object getKey() {
                    return expression.substring(expression.indexOf(EXCLAMATION) + 1, expression.length());
                }

                @Override
                public Object getValue() {
                    return entry.getValue();
                }

                @Override
                public Object setValue(Object value) {
                    return value;
                }
            };
            processDistribute(subJson, subEntry);
        }
    }

    private static String readFile(String path) throws Exception{
        FileInputStream fis = new FileInputStream(path);
        InputStreamReader is = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(is);
        StringBuffer sb = new StringBuffer();
        String s = null;
        while ((s = br.readLine()) != null){
            sb.append(s);
        }
        br.close();
        is.close();
        fis.close();
        return sb.toString();
    }

}
